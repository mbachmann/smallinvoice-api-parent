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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
        if (contacts != null && contacts.size() > 0) return contacts.get(0);
        else return null;
    }

    /**
     * GET /contacts/{contactId} : Returns data of specified contact
     *
     * @param contactId contact ID (required)
     * @param with      Comma separated, optional keys that should be included in the response. (optional)
     *                  *                    <br/>"main_address,groups,permissions,custom_fields"
     * @return ContactGET
     * Data of the requested contact
     */
    public ContactGET getContactById(int contactId, String with) {
        ResponseEntity<ItemContactGET> contactItem = contactsApiClient.getContact(contactId, with);
        if (contactItem.getBody() != null) return contactItem.getBody().getItem();
        else return null;
    }

    /**
     * POST /contacts : Creates a new contact
     *
     * @param contactPOST contact POST data
     * @return ContactGET - Data of the created contact
     */
    public ContactGET createContact(ContactPOST contactPOST) {
        ResponseEntity<ItemContactGET> responseCreate = contactsApiClient.createContact(contactPOST);
        if (responseCreate.getBody() != null) return responseCreate.getBody().getItem();
        return null;
    }

    /**
     * Deletes specified contact
     *
     * @param contactId contact ID (required)
     */
    public void deleteContactById(int contactId) {
        ResponseEntity<Void> contactItem = contactsApiClient.deleteContacts(contactId);
    }


    /**
     * Check if a contact with a contact name exists
     *
     * @param contactName the name of the contact
     * @return true if contact exists
     */
    public boolean checkIfContactExistsByName(String contactName) {
        List<ContactGET> contacts = getContacts(null, "{\"name\":\"" + contactName + "\"}");
        if (contacts != null) return contacts.size() > 0;
        return false;
    }

    /**
     * Deletes contacts if exists by name
     *
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
     *
     * @param contactId the contact id
     * @return {@code List<ContactAccountGET>} Data of the requested accounts
     */
    public List<ContactAccountGET> getContactAccounts(int contactId) {
        ResponseEntity<ListContactAccounts> responseAccounts = contactsApiClient.getContactAccounts(contactId, "permissions", null, null, 100, 0, null);
        if (responseAccounts.getBody() != null) {
            responseAccounts.getBody().getItems().forEach(account -> getLogger().debug(account.toString()));
            return responseAccounts.getBody().getItems();
        }
        return null;
    }

    /**
     * GET /contacts/configuration/groups : Returns list of contact groups
     *
     * @param with   Comma separated, optional keys that should be included in the response. (optional)
     * @param filter Filter expression (JSON) (optional) <br/>"{\"name\":\"" + groupName + "\"}"
     * @return {@code List<ContactConfigurationGroupGET>} Data of the requested contact groups
     */
    public List<ContactConfigurationGroupGET> getContactGroups(String with, String filter) {
        try {
            ResponseEntity<ListContactConfigurationGroups> response = contactsApiClient.getContactGroups(with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * POST /contacts/configuration/groups : Creates new contact group
     * @param contactGroupPOST the contact group data
     * @return  ContactConfigurationGroupGET - Data of the created contact group
     */
    public ContactConfigurationGroupGET createContactGroup(ContactConfigurationGroupPOST contactGroupPOST) {
        ResponseEntity<ItemContactConfigurationGroupGET> responseGroup = contactsApiClient.createContactGroup(contactGroupPOST);
        if (responseGroup.getBody() != null) return  responseGroup.getBody().getItem();
        return null;
    }

    /**
     * PATCH /contacts/{contactId}/assign-groups/{groupsIds} : Assigns groups to specified contact
     * @param contactId contact ID (required)
     * @param groupId the group id to assign
     * @return ContactGET Data of the contact to which to grooup was assigned
     */
    public ContactGET assignContactGroup(int contactId, int groupId) {
        ResponseEntity<ItemContactGET> contact = contactsApiClient.assignContactGroups(contactId, String.valueOf(groupId));
        if (contact.getBody() != null) return  contact.getBody().getItem();
        return null;
    }

    /**
     * Deletes specified contact group
     *
     * @param contactGroupId contact group ID (required)
     */
    public void deleteContactGroupById(int contactGroupId) {
        ResponseEntity<Void> contactGroupItem = contactsApiClient.deleteContactGroups(contactGroupId);
    }

    /**
     * Deletes specified contact groups
     *
     * @param contactGroupIds contact group IDs (required)
     */
    public void deleteContactGroupByIds(Integer... contactGroupIds) {
        ResponseEntity<Void> responseDelete = contactsApiClient.deleteContactGroups(contactGroupIds);
    }

    /**
     * Deletes the specified groups if they exists
     *
     * @param groupNames the names of the contact groups
     */
    public void deleteContactGroupsIfExists(String... groupNames) {

        String filter = createOrFilter("name", groupNames);
        List<ContactConfigurationGroupGET> groups = getContactGroups(null, filter);

        if (groups != null) {
            groups.forEach(item -> deleteContactGroupById(item.getId()));
        }
    }

    /**
     * POST /contacts/reminders : Creates new reminder
     * @param contactReminderPOST contactReminderPOST – reminder JSON data (required)
     * @return ContactReminderGET Data of the created reminder
     */
    public ContactReminderGET createReminder(ContactReminderPOST contactReminderPOST) {
        ResponseEntity<ItemContactReminderGET> responseReminder = contactsApiClient.createReminder(contactReminderPOST);
        if (responseReminder.getBody() != null) return responseReminder.getBody().getItem();
        return null;
    }

    // ============ Letter ==============

    /**
     * GET /contacts/letters : Returns list of letters
     *
     * @param with   Comma separated, optional keys that should be included in the response (optional).
     *               <br/> "permissions,free_texts,contact_prepage_address,contact_address,contact,custom_fields"
     * @param filter Filter expression (JSON) (optional)
     * @return {@code List<DocumentLetterGET>} - Data of the requested letters
     */
    public @Valid List<DocumentLetterGET> getLetters(String with, String filter) {
        try {
            ResponseEntity<ListLetters> response = contactsApiClient.getLetters(with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /contacts/letters/{letterId} : Returns data of specified letter
     * @param letterId the ID of the letter
     * @param with   Comma separated, optional keys that should be included in the response (optional).
     *               <br/> "permissions,free_texts,contact_prepage_address,contact_address,contact,custom_fields"
     * @return DocumentLetterGET Data of the requested letter
     */
    public DocumentLetterGET getLetterById(int letterId, String with) {
        ResponseEntity<ItemDocumentLetterGET> response = contactsApiClient.getLetter(letterId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * POST /contacts/letters : Creates new letter
     *
     * @param documentLetterPOST DocumentLetterPOST – the letter data
     * @return DocumentLetterGET Data of the created letter
     */
    public DocumentLetterGET createLetter(DocumentLetterPOST documentLetterPOST) {
        ResponseEntity<ItemDocumentLetterGET> response = contactsApiClient.createLetter(documentLetterPOST);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /contacts/letters/{letterId} : Updates specified letter
     *
     * @param letter DocumentLetterGET - the letter data (required)
     * @return Data of the updated letter
     * @throws IOException if mapping from DocumentLetterGET to DocumentLetterPUT fails
     */
    public DocumentLetterGET updateLetter(DocumentLetterGET letter) throws IOException {
        DocumentLetterPUT changedLetter = mapFromJson(mapToJson(letter), DocumentLetterPUT.class);
        ResponseEntity<ItemDocumentLetterGET> response = contactsApiClient.updateLetter(letter.getId(), changedLetter);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PATCH /contacts/letters/{letterId}/change-status : Changes status of specified letter
     *
     * @param letterId       letterId ID (required)
     * @param status         DocumentLetterChangeStatusPATCH.StatusEnum.
     *                       <br/> StatusEnum – status of letter, possible values: DR - draft, S - sent, D - deleted (but still visible)
     * @return Data of the changed letter
     */
    public DocumentLetterGET changeLetterStatusById(int letterId, DocumentLetterChangeStatusPATCH.StatusEnum status) {
        DocumentLetterChangeStatusPATCH patch = new DocumentLetterChangeStatusPATCH();
        patch.   status(status)
                .dateTime(LocalDateTime.now());
        ResponseEntity<ItemDocumentLetterGET> response = contactsApiClient.changeLetterStatus(letterId, patch);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * GET /contacts/letters/{letterId}/pdf : Gets pdf of specified letter
     *
     * @param letterId letter ID (required)
     * @return The PDF as a Resource
     */
    public Resource getLetterPdfResource(int letterId) {
        ResponseEntity<Resource> response = contactsApiClient.getLetterPdf(letterId);
        return response.getBody();
    }

    /**
     * GET /contacts/letters/{letterId}/preview : Gets preview of specified letter
     *
     * @param letterId       letter note ID (required)
     * @param page           page – page number [1 .. pages amount] (optional, default to 1)
     * @param size           width in pixels (optional,
     *                       <br/> allowableValues = 240, 595, 600, 972, 1240, defaultValue = 972)
     * @return The png image as resource
     */
    public Resource getLetterPreviewResource(int letterId, Integer page, Integer size) {
        // size on of "240, 595, 600, 972, 1240"
        ResponseEntity<Resource> response = contactsApiClient.getLetterPreview(letterId, page, size);
        return response.getBody();
    }

    /**
     * PATCH /contacts/letters/{letterId}/send-by-email : Sends specified letter by email
     *
     * @param letterId       letter ID (required)
     * @param email          DocumentLetterSendByEmailPATCH – sending mail data details
     */
    public void sendLetterByEMail(int letterId, DocumentLetterSendByEmailPATCH email) {
        ResponseEntity<Void> response = contactsApiClient.sendLetterByEMail(letterId, email);
    }

    /**
     * PATCH /contacts/letters/{letterId}/send-by-post : Sends specified letter by post
     *
     * @param letterId       letterI note ID (required)
     * @param post           documentSendByPostPATCH – sending post data details
     */
    public void sendLetterByPost(int letterId, DocumentSendByPostPATCH post) {
        ResponseEntity<Void> response = contactsApiClient.sendLetterByPost(letterId, post);
    }


    // ==================================
    //          Configuration
    // ==================================


    /**
     * Get all Bankaccounts
     *
     * @return {@code List<ConfigurationBankAccountGET>} Data of the requested bank accounts
     * @throws InterruptedException about the TimeUnit
     */
    public List<ConfigurationBankAccountGET> getBankAccounts() throws InterruptedException {
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

    /**
     * Gets all exchange rates
     *
     * @return {@code List<ConfigurationExchangeRateGET>} Data of the requested exchange rates
     * @throws InterruptedException about the TimeUnit
     */
    public List<ConfigurationExchangeRateGET> getExchangeRates()  throws InterruptedException {
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

    /**
     * Creates a catalog product category if it does not exist
     * @param categoryName the name of the category to get created
     * @return the created category id, 0 in case of an error
     */
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

    /**
     * Creates a catalog service category if it does not exist
     * @param categoryName the name of the category to get created
     * @return the created category id, 0 in case of an error
     */
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
     *
     * @param with   Comma separated, optional keys that should be included in the response. (optional)
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
     *
     * @param catalogUnitId unit ID (required)
     * @param with          Comma separated, optional keys that should be included in the response. (optional)
     * @return CatalogConfigurationUnitGET Data of the requested unit
     */
    public CatalogConfigurationUnitGET getCatalogUnitById(int catalogUnitId, String with) {
        ResponseEntity<ItemCatalogConfigurationUnitGET> response = catalogApiClient.getUnit(catalogUnitId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * DELETE /catalog/products/{productIds} : Deletes specified products
     * @param productName the name of the product
     */
    public void deleteProductByNameIfExists(String productName) {
        ResponseEntity<ListProducts> response = catalogApiClient.getCatalogProducts(null, null, "{\"name\":\"" + productName + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = catalogApiClient.deleteCatalogProducts(response.getBody().getItems().get(0).getId());
        }
    }

    /**
     * DELETE /catalog/services/{serviceIds} : Deletes specified services
     * @param serviceName the name of the service
     */
    public void deleteServiceByNameIfExists(String serviceName) {
        ResponseEntity<ListServices> response = catalogApiClient.getCatalogServices(null, null, "{\"name\":\"" + serviceName + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = catalogApiClient.deleteCatalogServices(response.getBody().getItems().get(0).getId());
        }
    }


    // ==================================
    //          Receivables
    // ==================================

    // ===== ISRs (Einzahlungsschein mit Referenznummer (ESR)) ===

    /**
     * GET /receivables/configuration/isrs : Returns list of ISRs (Einzahlungsschein mit Referenznummer (ESR))
     *
     * @param with   Comma separated, optional keys that should be included in the response. (optional)
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
     *
     * @param isrNoteId ISR ID (required)
     * @param with
     * @return
     */
    public ReceivablesConfigurationIsrGET getIsrById(int isrNoteId, String with) {
        ResponseEntity<ReceivablesConfigurationIsrGET> response = receivablesApiClient.getIsr(isrNoteId, with);
        if (response.getBody() != null) return response.getBody();
        else return null;
    }

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
    public DocumentDeliveryNoteGET changeDeliveryNoteStatusById(
            int deliveryNoteId, DocumentDeliveryNoteChangeStatusPATCH.StatusEnum status) {
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
