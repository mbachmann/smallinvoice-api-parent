package com.example.smallinvoicespringfeign.service;

import com.example.smallinvoicespringfeign.api.CatalogApiClient;
import com.example.smallinvoicespringfeign.api.ConfigurationApiClient;
import com.example.smallinvoicespringfeign.api.ContactsApiClient;
import com.example.smallinvoicespringfeign.api.ReceivablesApiClient;
import com.example.smallinvoicespringfeign.configuration.SmallInvoiceNotFoundException;
import com.example.smallinvoicespringfeign.model.*;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class SmallInvoiceApiService extends AbstractApiService {

    @Autowired
    private ContactsApiClient contactsApiClient;

    @Autowired
    private CatalogApiClient catalogApiClient;

    @Autowired
    private ReceivablesApiClient receivablesApiClient;

    @Autowired
    private ConfigurationApiClient configurationApiClient;

    // ==================================
    //            Contact
    // ==================================

    /**
     * GET /contacts : Returns list of contacts
     *
     * @param with   Comma separated, optional keys that should be included in the response. (optional)
     *               <br/>"main_address,groups,permissions,custom_fields"
     * @param filter Filter expression (JSON) (optional) <br/>"{\"name\":\"" + contactName + "\"}"
     * @return {@code List<ContactGET>}
     */
    public List<ContactGET> getContacts(String with, String filter) {
        try {
            ResponseEntity<ListContacts> response = contactsApiClient.getContacts(with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /contacts : Returns the first contact with the specified contactName
     *
     * @param contactName the name of the contact
     * @param with        Comma separated, optional keys that should be included in the response. (optional)
     *                    <br/>"main_address,groups,permissions,custom_fields"
     * @return ContactGET Data of the requested contact
     */
    public ContactGET getFirstContactByName(String contactName, String with) {
        List<ContactGET> contacts = getContacts(with, "{\"name\":\"" + contactName + "\"}");
        if (contacts != null) return contacts.get(0);
        else return null;
    }

    public ContactGET getContactById(int contactId, String with) {
        ResponseEntity<ItemContactGET> contactItem = contactsApiClient.getContact(contactId, with);
        if (contactItem.getBody() != null) return contactItem.getBody().getItem();
        else return null;
    }

    public void deleteContactById(int contactId) {
        ResponseEntity<Void> contactItem = contactsApiClient.deleteContacts(contactId);
    }


    public boolean checkIfContactExistsByName(String contactName) {
        List<ContactGET> contacts = getContacts(null, "{\"name\":\"" + contactName + "\"}");
        if (contacts != null) return contacts.size() > 0;
        return false;
    }

    /**
     * Delete the contact if exists by name
     * @param contactName the name of the contact
     */
    public void deleteContactsIfExistsByName(String contactName) {
        List<ContactGET> contacts = getContacts(null, "{\"name\":\"" + contactName + "\"}");
        if (contacts != null && contacts.size() > 0) {
            contacts.forEach(contact -> deleteContactById(contact.getId()));
        }
    }

    /**
     * Returns list of people for specified contact Returns list of people for specified contact
     *
     * @param contactId the contactId (required)
     * @param maxRetry  maxRetry in case of amount of contact people is 0, 0 = no retry
     * @return {@code List<ContactPeopleGET>} Data of the requested people
     */
    public List<ContactPeopleGET> getContactPeoples(int contactId, int maxRetry) throws InterruptedException {
        ResponseEntity<ListContactPeople> response = contactsApiClient.getContactPeoples(contactId, null, null, null, 100, 0, null);

        // Retry mechanism, because smallinvoice throws 404 after inserting a new person
        for (int i = 0; i < maxRetry; i++) {
            if (Objects.requireNonNull(response.getBody()).getItems().size() == 0) {
                TimeUnit.MILLISECONDS.sleep(100);
                response = contactsApiClient.getContactPeoples(contactId, null, null, null, 100, 0, null);
            } else break;
        }
        return Objects.requireNonNull(response.getBody()).getItems();
    }

    /**
     * GET /contacts/{contactId}/accounts : Returns list of accounts for specified contact
     * @param contactId the contact id
     * @return {@code List<ContactAccountGET>} Data of the requested accounts
     */
    public List<ContactAccountGET> getContactAccounts (int contactId) {
        ResponseEntity<ListContactAccounts> responseAccounts = contactsApiClient.getContactAccounts(contactId, "permissions", null, null, 100, 0, null);
        if (responseAccounts.getBody() != null) {
            responseAccounts.getBody().getItems().forEach(account -> getLogger().debug(account.toString()));
            return responseAccounts.getBody().getItems();
        }
        return null;
    }

    public void deleteContactGroupsIfExists(String... groupNames) {

        StringBuilder filterJson = new StringBuilder("{\"or\":[");
        for (String groupName : groupNames) {
            filterJson.append("{\"name\":\"").append(groupName).append("\"},");
        }
        filterJson.deleteCharAt(filterJson.length() - 1);
        filterJson.append("]}");
        try {
            ResponseEntity<ListContactConfigurationGroups> responseGroups = contactsApiClient.getContactGroups(null, null, filterJson.toString(), 100, 0, null);
            if (responseGroups.getBody() != null) {
                responseGroups.getBody().getItems().forEach(item -> contactsApiClient.deleteContactGroups(item.getId()));
            }
        } catch (RetryableException ignored) {
        }
    }

    // ==================================
    //          Configuration
    // ==================================


    public List<ConfigurationBankAccountGET> getBankAccounts() throws Exception {
        ResponseEntity<ListConfigurationBankAccounts> response = null;
        try {
            response = configurationApiClient.getBankAccounts(null, null, null, 100, 0, null);
        } catch (SmallInvoiceNotFoundException exception) {
            TimeUnit.MILLISECONDS.sleep(500);
            response = configurationApiClient.getBankAccounts(null, null, null, 100, 0, null);
        }
        if (response != null && response.getBody() != null) return response.getBody().getItems();
        else return null;
    }


    public List<ConfigurationExchangeRateGET> getExchangeRates() throws Exception {
        ResponseEntity<ListConfigurationExchangeRates> response = null;
        try {
            response = configurationApiClient.getCurrencyExchangeRates(null, null, 100, 0, null);
        } catch (SmallInvoiceNotFoundException exception) {
            TimeUnit.MILLISECONDS.sleep(500);
            response = configurationApiClient.getCurrencyExchangeRates(null, null, 100, 0, null);
        }
        if (response != null && response.getBody() != null) return response.getBody().getItems();
        else return null;
    }

    // ==================================
    //             Catalog
    // ==================================

    public int createProductCategoryIfNotExists(String categoryName) {

        int categoryId = 0;
        try {
            ResponseEntity<ListProductsCategories> response = catalogApiClient.getCatalogProductCategories(null, null, "{\"name\":\"" + categoryName + "\"}", 100, 0, null);
            if (response.getBody() != null && response.getBody().getPagination().getTotal() == 0) {
                CatalogCategoryPOST category = new CatalogCategoryPOST();
                category.setName(categoryName);
                ResponseEntity<ItemCatalogCategoryGET> responseCategory = catalogApiClient.createCatalogProductCategory(category);
                categoryId = responseCategory.getBody().getItem().getId();
            } else {
                categoryId = response.getBody().getItems().get(0).getId();
            }
        } catch (RetryableException ignored) {
        }
        return categoryId;
    }

    public int createServiceCategoryIfNotExists(String categoryName) {

        int categoryId = 0;
        try {
            ResponseEntity<ListServicesCategories> response = catalogApiClient.getCatalogServiceCategories(null, null, "{\"name\":\"" + categoryName + "\"}", 100, 0, null);
            if (response.getBody() != null && response.getBody().getPagination().getTotal() == 0) {
                CatalogCategoryPOST category = new CatalogCategoryPOST();
                category.setName(categoryName);
                ResponseEntity<ItemCatalogCategoryGET> responseCategory = catalogApiClient.createCatalogServiceCategory(category);
                categoryId = responseCategory.getBody().getItem().getId();
            } else {
                categoryId = response.getBody().getItems().get(0).getId();
            }
        } catch (RetryableException ignored) {
        }
        return categoryId;
    }

    /**
     * GET /catalog/configuration/units : Returns list of units
     * @param with Comma separated, optional keys that should be included in the response. (optional)
     * @param filter Filter expression (JSON) (optional)
     * @return {@code List<CatalogConfigurationUnitGET>} Data of the requested unit types
     */
    public List<CatalogConfigurationUnitGET> getCatalogUnits(String with, String filter) {
        ResponseEntity<ListCatalogConfigurationUnits> response = catalogApiClient.getUnits(with, null, filter, 100, 0, null);
        if (response.getBody() != null) {
            return response.getBody().getItems();
        }
        return null;
    }

    /**
     * GET /catalog/configuration/units/{unitId} : Returns data of specified unit
     * @param catalogUnitId unit ID (required)
     * @param with Comma separated, optional keys that should be included in the response. (optional)
     * @return CatalogConfigurationUnitGET Data of the requested unit
     */
    public CatalogConfigurationUnitGET getCatalogUnitById(int catalogUnitId, String with) {
        ResponseEntity<ItemCatalogConfigurationUnitGET> response = catalogApiClient.getUnit(catalogUnitId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }


    /**
     * GET /receivables/configuration/isrs : Returns list of ISRs (Einzahlungsschein mit Referenznummer (ESR))
     * @param with Comma separated, optional keys that should be included in the response. (optional)
     * @param filter Filter expression (JSON) (optional)
     * @return {@code List<ReceivablesConfigurationIsrGET>} Data of the requested ISRs
     */
    public List<ReceivablesConfigurationIsrGET> getIsrs(String with, String filter) {
        ResponseEntity<ListReceivablesConfigurationIsrs> response = receivablesApiClient.getIsrs(with, null, filter, 100, 0, null);
        if (response.getBody() != null) {
            response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
            return response.getBody().getItems();
        }
        return null;
    }

    /**
     * GET /receivables/configuration/isrs/{isrId} : Returns data of specified ISR (Einzahlungsschein mit Referenznummer (ESR))
     * @param isrNoteId ISR ID (required)
     * @param with
     * @return
     */
    public ReceivablesConfigurationIsrGET getIsrById(int isrNoteId, String with) {
        ResponseEntity<ReceivablesConfigurationIsrGET> response = receivablesApiClient.getIsr(isrNoteId, with);
        if (response.getBody() != null) return response.getBody();
        else return null;
    }

    // ==================================
    //          Receivables
    // ==================================


    // ======== Delivery Notes ==========

    /**
     * GET /receivables/delivery-notes : Returns list of delivery notes
     *
     * @param with   Comma separated, optional keys that should be included in the response (optional).
     *               <br/> "permissions,positions,texts,free_texts,contact_prepage_address,contact_address,contact,custom_fields"
     * @param filter Filter expression (JSON) (optional)
     * @return {@code List<DocumentDeliveryNoteGET>} - Data of the requested delivery notes
     */
    public List<DocumentDeliveryNoteGET> getDeliveryNotes(String with, String filter) {
        try {
            ResponseEntity<ListDeliveryNotes> response = receivablesApiClient.getDeliveryNotes(with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /receivables/delivery-notes/{deliveryNoteId} : Returns data of specified delivery note
     *
     * @param deliveryNoteId deliveryNoteId – delivery note ID (required)
     * @param with           Comma separated, optional keys that should be included in the response (optional).
     *                       <br/> "permissions,positions,texts,free_texts,contact_prepage_address,contact_address,contact,custom_fields"
     * @return DocumentDeliveryNoteGET Data of the requested delivery note
     */
    public DocumentDeliveryNoteGET getDeliveryNoteById(int deliveryNoteId, String with) {
        ResponseEntity<ItemDocumentDeliveryNoteGET> response = receivablesApiClient.getDeliveryNote(deliveryNoteId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * POST /receivables/delivery-notes : Creates new delivery note
     *
     * @param deliveryNote documentDeliveryNotePOST – delivery note
     * @return Data of the created delivery note
     */
    public DocumentDeliveryNoteGET createDeliveryNote(DocumentDeliveryNotePOST deliveryNote) {
        ResponseEntity<ItemDocumentDeliveryNoteGET> response = receivablesApiClient.createDeliveryNote(deliveryNote);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /receivables/delivery-notes/{deliveryNoteId} : Updates specified delivery note
     *
     * @param deliveryNote DocumentDeliveryNoteGET - delivery note (required)
     * @return Data of the updated delivery note
     * @throws IOException if mapping from DocumentDeliveryNoteGET to DocumentDeliveryNotePUT fails
     */
    public DocumentDeliveryNoteGET updateDeliveryNote(DocumentDeliveryNoteGET deliveryNote) throws IOException {
        DocumentDeliveryNotePUT changedDeliveryNote = mapFromJson(mapToJson(deliveryNote), DocumentDeliveryNotePUT.class);
        ResponseEntity<ItemDocumentDeliveryNoteGET> response = receivablesApiClient.updateDeliveryNote(deliveryNote.getId(), changedDeliveryNote);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PATCH /receivables/delivery-notes/{deliveryNoteId}/change-status : Changes status of specified delivery note
     *
     * @param deliveryNoteId deliveryNoteId – delivery note ID (required)
     * @param status         documentDeliveryNoteChangeStatusPATCH.<br/> StatusEnum – change status, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)
     * @return Data of the changed delivery note
     */
    public DocumentDeliveryNoteGET changeDeliveryNoteStatusById(int deliveryNoteId, DocumentDeliveryNoteChangeStatusPATCH.StatusEnum status) {
        DocumentDeliveryNoteChangeStatusPATCH patch = new DocumentDeliveryNoteChangeStatusPATCH();
        patch.status(status)
                .dateTime(LocalDateTime.now());
        ResponseEntity<ItemDocumentDeliveryNoteGET> response = receivablesApiClient.changeDeliveryNoteStatus(deliveryNoteId, patch);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * GET /receivables/delivery-notes/{deliveryNoteId}/pdf : Gets pdf of specified delivery note
     *
     * @param deliveryNoteId deliveryNoteId – delivery note ID (required)
     * @return The PDF as a Resource
     */
    public Resource getDeliveryNotePdfResource(int deliveryNoteId) {
        ResponseEntity<Resource> response = receivablesApiClient.getDeliveryNotePdf(deliveryNoteId);
        return response.getBody();
    }

    /**
     * GET /receivables/delivery-notes/{deliveryNoteId}/preview : Gets preview of specified delivery note
     *
     * @param deliveryNoteId deliveryNoteId – delivery note ID (required)
     * @param page           page – page number [1 .. pages amount] (optional, default to 1)
     * @param size           width in pixels (optional, <br/> allowableValues = 240, 595, 600, 972, 1240, defaultValue = 972)
     * @return The png image as resource
     */
    public Resource getDeliveryNotePreviewResource(int deliveryNoteId, Integer page, Integer size) {
        // size on of "240, 595, 600, 972, 1240"
        ResponseEntity<Resource> response = receivablesApiClient.getDeliveryNotePreview(deliveryNoteId, page, size);
        return response.getBody();
    }

    /**
     * PATCH /receivables/delivery-notes/{deliveryNoteId}/send-by-email : Sends specified delivery note by email Sends specified delivery note by email
     *
     * @param deliveryNoteId deliveryNoteId – delivery note ID (required)
     * @param email          documentDeliveryNoteSendByEmailPATCH – sending mail data details
     */
    public void sendDeliveryNoteByEMail(int deliveryNoteId, DocumentDeliveryNoteSendByEmailPATCH email) {
        ResponseEntity<Void> response = receivablesApiClient.sendDeliveryNoteByEMail(deliveryNoteId, email);
    }

    /**
     * PATCH /receivables/delivery-notes/{deliveryNoteId}/send-by-post : Sends the specified delivery note by post
     *
     * @param deliveryNoteId deliveryNoteId – delivery note ID (required)
     * @param post           documentSendByPostPATCH – sending post data details
     */
    public void sendDeliveryNoteByPost(int deliveryNoteId, DocumentSendByPostPATCH post) {
        ResponseEntity<Void> response = receivablesApiClient.sendDeliveryNoteByPost(deliveryNoteId, post);
    }

    // ======== Standard Invoices ==========

    /**
     * GET /receivables/invoices : Returns list of invoices
     *
     * @param with   Comma separated, optional keys that should be included in the response (optional).
     *               <br/> "permissions,positions,texts,free_texts,bank_account,contact_person,contact_prepage_address,contact_address,contact,workflow,custom_fields"
     * @param filter Filter expression (JSON) (optional)
     * @return {@code List<DocumentInvoiceStandardGET>} Data of the requested invoices
     */
    public List<DocumentInvoiceStandardGET> getStandardInvoices(String with, String filter) {
        try {
            ResponseEntity<ListInvoicesStandard> response = receivablesApiClient.getInvoices(with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /receivables/invoices/{invoiceId} : Returns data of specified invoice
     *
     * @param invoiceId invoice ID (required)
     * @param with      Comma separated, optional keys that should be included in the response (optional).
     *                  <br/> "permissions,positions,texts,free_texts,bank_account,contact_person,contact_prepage_address,contact_address,contact,workflow,custom_fields"
     * @return DocumentInvoiceStandardGET - Data of the requested invoice
     */
    public DocumentInvoiceStandardGET getStandardInvoiceById(int invoiceId, String with) {
        ResponseEntity<ItemDocumentInvoiceStandardGET> response = receivablesApiClient.getInvoice(invoiceId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * GET /receivables/invoices/{invoiceId}/payments : Returns list of payments for specified invoice
     *
     * @param invoiceId invoice ID (required)
     * @param with      Comma separated, optional keys that should be included in the response (optional).
     * @param filter    Filter expression (JSON) (optional) <br/> String filter = "{\"contact_id\":" + contactId + "}";
     * @return {@code List<DocumentInvoicePaymentGET>}  Data of the requested payments
     */
    public List<DocumentInvoicePaymentGET> getInvoicePayments(int invoiceId, String with, String filter) {
        try {
            ResponseEntity<ListDocumentInvoicePayments> response = receivablesApiClient.getInvoicePayments(invoiceId, with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /receivables/invoices/{invoiceId}/payments/{paymentId} : Returns data of specified invoice's payment
     *
     * @param invoiceId invoice ID (required)
     * @param paymentId payment ID (required)
     * @param with      Comma separated, optional keys that should be included in the response. (optional) <br/> "permissions
     * @return DocumentInvoicePaymentGET Data of the requested payment
     */
    public DocumentInvoicePaymentGET getInvoicePaymentById(int invoiceId, int paymentId, String with) {
        ResponseEntity<ItemDocumentInvoicePaymentGET> response = receivablesApiClient.getInvoicePayment(invoiceId, paymentId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    // ======== Offers ==========

    /**
     * GET /receivables/offers : Returns list of offers
     *
     * @param with   Comma separated, optional keys that should be included in the response. (optional)
     *               <br/> "permissions,positions,texts,free_texts,contact_person,contact_prepage_address,contact_address,contact,custom_fields"
     * @param filter filter Filter expression (JSON) (optional)
     * @return {@code List<DocumentOfferGET>} Data of the requested offers
     */
    public List<DocumentOfferGET> getOffers(String with, String filter) {
        try {
            ResponseEntity<ListOffers> response = receivablesApiClient.getOffers(with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /receivables/offers/{offerId} : Returns data of specified offer
     *
     * @param offerId offer ID (required)
     * @param with    with Comma separated, optional keys that should be included in the response. (optional)
     *                *             <br/> "permissions,positions,texts,free_texts,contact_person,contact_prepage_address,contact_address,contact,custom_fields"
     * @return DocumentOfferGET Data of the requested offer
     */
    public DocumentOfferGET getOfferById(int offerId, String with) {
        ResponseEntity<ItemDocumentOfferGET> response = receivablesApiClient.getOffer(offerId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    // ======== Order Confirmations ==========

    /**
     * GET /receivables/order-confirmations : Returns list of order confirmations
     *
     * @param with   with with Comma separated, optional keys that should be included in the response. (optional)
     *               <br/>"permissions,positions,texts,free_texts,contact_person,contact_prepage_address,contact_address,contact,custom_fields"
     * @param filter filter Filter expression (JSON) (optional)
     * @return {@code List<DocumentOrderConfirmationGET>} Data of the requested order confirmations
     */
    public List<DocumentOrderConfirmationGET> getOrderConfirmations(String with, String filter) {
        try {
            ResponseEntity<ListOrderConfirmations> response = receivablesApiClient.getOrderConfirmations(with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /receivables/order-confirmations/{orderConfirmationId} : Returns data of specified order confirmation
     *
     * @param offerId order confirmation ID (required)
     * @param with    with with Comma separated, optional keys that should be included in the response. (optional)
     *                *             <br/>"permissions,positions,texts,free_texts,contact_person,contact_prepage_address,contact_address,contact,custom_fields"
     * @return DocumentOrderConfirmationGET Data of the requested order confirmation
     */
    public DocumentOrderConfirmationGET getOrderConfirmationById(int offerId, String with) {

        ResponseEntity<ItemDocumentOrderConfirmationGET> response = receivablesApiClient.getOrderConfirmation(offerId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    // ==================================
    //          Reporting
    // ==================================


}
