package com.example.smallinvoicespringfeign.service;

import com.example.smallinvoicespringfeign.api.*;
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
    private AuthApiClient authApiClient;

    @Autowired
    private ContactsApiClient contactsApiClient;

    @Autowired
    private CatalogApiClient catalogApiClient;

    @Autowired
    private ReceivablesApiClient receivablesApiClient;

    @Autowired
    private ConfigurationApiClient configurationApiClient;

    @Autowired
    private ReportingApiClient reportingApiClient;


    // ==================================
    //           Auth
    // ==================================


    /**
     * GET /auth/profile : Returns data of authenticated user's profile
     * @return AuthProfileGET - Data of the authenticated user's profile
     */
    public AuthProfileGET getAuthUserProfile() {
        ResponseEntity<ItemAuthProfileGET> response = authApiClient.getAuthUserProfile();
        if (response.getBody() != null) {
            getLogger().debug(response.getBody().getItem().toString());
            return response.getBody().getItem();
        }
        return null;
    }

    /**
     * GET /auth/owner : Returns data of authenticated resource owner
     * @return AuthOwnerGET - Data of the authenticated resource owner
     */
    public AuthOwnerGET getAuthenticatedResourceOwner()  {
        ResponseEntity<ItemAuthOwnerGET> response = authApiClient.getAuthenticatedResourceOwner();
        if (response.getBody() != null) {
            getLogger().debug(response.getBody().getItem().toString());
            return response.getBody().getItem();
        }
        return null;
    }


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

     * Update specified contact
     *
     * @param contact ContactGet contact (required)
     * @return ContactGet - Data of the updated Contact
     * @throws IOException if mapping from ContactGET to ContactPUT fails
     */
    public ContactGET updateContact(ContactGET contact) throws IOException {
        ContactPUT changedContact = mapFromJson(mapToJson(contact), ContactPUT.class);
        ResponseEntity<ItemContactGET> response = contactsApiClient.updateContact(contact.getId(), changedContact);
        return Objects.requireNonNull(response.getBody()).getItem();
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

     * Update specified contact address
     *
     * @param contactId Integer contactId (required)
     * @param contactAddress ContactAddressGet contactAddress (required)
     * @return ContactAddressGet - Data of the updated Contact address
     * @throws IOException if mapping from ContactAddressGET to ContactAddressPUT fails
     */
    public ContactAddressGET updateContactAddress(Integer contactId, ContactAddressGET contactAddress) throws IOException {
        ContactAddressPUT changedContactAddress = mapFromJson(mapToJson(contactAddress), ContactAddressPUT.class);
        ResponseEntity<ItemContactAddressGET> response = contactsApiClient.updateContactAddress(contactId, contactAddress.getId(), changedContactAddress);
        return Objects.requireNonNull(response.getBody().getItem());
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

     * Get specified contact address
     *
     * @param contactId int contactId
     * @param contactAddressId int contactAddressId (required)
     * @return ContactAddressGet - Data of the specified Contact address
     * @throws IOException if mapping from ContactAddressGET to ContactAddressPUT fails
     */
    public ContactAddressGET getContactAddressById(int contactId, int contactAddressId) throws IOException {
        ResponseEntity<ItemContactAddressGET> response = contactsApiClient.getContactAddress(contactId, contactAddressId, null);
        if (response.getBody() != null) return response.getBody().getItem();
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
     * @param letterId       letter ID (required)
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
     * @param letterId       letterID (required)
     * @param post           documentSendByPostPATCH – sending post data details
     */
    public void sendLetterByPost(int letterId, DocumentSendByPostPATCH post) {
        ResponseEntity<Void> response = contactsApiClient.sendLetterByPost(letterId, post);
    }


    // ==================================
    //          Configuration
    // ==================================

    // ========== Bank Accounts =========

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
     * DELETE /configuration/bank-accounts/{accountsIds} : Deletes specified bank accounts
     * @param description The description of the bank account
     */
    public void deleteBankAccountByDescriptionIfExists(String description) {
        ResponseEntity<ListConfigurationBankAccounts> response = configurationApiClient.getBankAccounts(null, null, "{\"description\":\"" + description + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = configurationApiClient.deleteBankAccounts(response.getBody().getItems().get(0).getId());
        }
    }

    /**
     * DELETE /configuration/bank-accounts/{accountsIds} : Deletes specified bank accounts
     * @param bankAccountsIds comma separated IDs of accounts to be deleted (required)
     */
    public void deleteBankAccountByIds(Integer... bankAccountsIds) {
        ResponseEntity<Void> response = configurationApiClient.deleteBankAccounts(bankAccountsIds);
    }

    /**
     * POST /configuration/bank-accounts : Creates new bank account
     *
     * @param bankAccount ConfigurationBankAccountPOST – bank account
     * @return ConfigurationBankAccountGET - Data of the created bank account
     */
    public ConfigurationBankAccountGET createBankAccount(ConfigurationBankAccountPOST bankAccount) {
        ResponseEntity<ItemConfigurationBankAccountGET> response = configurationApiClient.createBankAccount(bankAccount);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /configuration/bank-accounts/{accountId} : Updates specified bank account
     *
     * @param bankAccount ConfigurationBankAccountGET - bank account (required)
     * @return ConfigurationBankAccountGET - Data of the updated bank account
     * @throws IOException if mapping from ConfigurationBankAccountGET to ConfigurationBankAccountPUT fails
     */
    public ConfigurationBankAccountGET updateBankAccount(ConfigurationBankAccountGET bankAccount) throws IOException {
        ConfigurationBankAccountPUT changedBankAccount = mapFromJson(mapToJson(bankAccount), ConfigurationBankAccountPUT.class);
        ResponseEntity<ItemConfigurationBankAccountGET> response = configurationApiClient.updateBankAccount(bankAccount.getId(), changedBankAccount);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    // ========== Exchange Rates =========


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


    /**
     * DELETE /configuration/exchange-rates/{exchangeIds} : Deletes specified currency exchange rates
     * @param currencyFrom currency like CHF
     * @param currencyTo curreny like EUR
     */
    public void deleteExchangeRateIfExists(String currencyFrom, String currencyTo) {
        String filterJson = "{\"and\":[{\"currency_from\":\"" + currencyFrom + "\"},{\"currency_to\":\"" + currencyTo + "\"}]}";
        ResponseEntity<ListConfigurationExchangeRates> response = configurationApiClient.getCurrencyExchangeRates(null, filterJson, 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = configurationApiClient.deleteCurrencyExchangeRates(response.getBody().getItems().get(0).getId());
        }
    }

    /**
     * DELETE /configuration/exchange-rates/{exchangeIds} : Deletes specified currency exchange rates
     * @param exchangeRateIds exchangeIds – comma separated IDs of currency exchange rates to be deleted (required)
     */
    public void deleteExchangeRateByIds(Integer... exchangeRateIds) {
        ResponseEntity<Void> response = configurationApiClient.deleteCurrencyExchangeRates(exchangeRateIds);
    }

    /**
     * POST /configuration/exchange-rates : Creates new exchange rates
     *
     * @param exchangeRate ConfigurationExchangeRatePOST – exchange rates
     * @return ConfigurationExchangeRateGET - Data of the created exchange rates
     */
    public ConfigurationExchangeRateGET createExchangeRate(ConfigurationExchangeRatePOST exchangeRate) {
        ResponseEntity<ItemConfigurationExchangeRateGET> response = configurationApiClient.createCurrencyExchangeRate(exchangeRate);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /configuration/exchange-rates/{accountId} : Updates specified exchange rates
     *
     * @param exchangeRate ConfigurationExchangeRateGET - exchange rates (required)
     * @return ConfigurationExchangeRateGET - Data of the updated bank account
     * @throws IOException if mapping from ConfigurationExchangeRateGET to ConfigurationExchangeRatePUT fails
     */
    public ConfigurationExchangeRateGET updateExchangeRate(ConfigurationExchangeRateGET exchangeRate) throws IOException {
        ConfigurationExchangeRatePUT changedExchangeRate = mapFromJson(mapToJson(exchangeRate), ConfigurationExchangeRatePUT.class);
        ResponseEntity<ItemConfigurationExchangeRateGET> response = configurationApiClient.updateCurrencyExchangeRate(exchangeRate.getId(), changedExchangeRate);
        return Objects.requireNonNull(response.getBody()).getItem();
    }



    // ==================================
    //             Catalog
    // ==================================

    // ======= CatalogProductCategory ==========

    /**
     * Creates a catalog product category if it does not exist
     * @param categoryName the name of the category to get created
     * @return the created categoryId, 0 in case of an error
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
     * GET /catalog/products/categories : Returns list of product categories
     *
     * @param with   Comma separated, optional keys that should be included in the response. (optional)
     *               <br/> "permission,custom_fields"
     * @param filter filter Filter expression (JSON) (optional)
     * @return {@code List<CatalogCategoryGET>} Data of the requested product categories
     */
    public List<CatalogCategoryGET> getCatalogProductCategories(String with, String filter) {
        try {
            ResponseEntity<ListProductsCategories> response = catalogApiClient.getCatalogProductCategories(with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /catalog/products/categories/{categoryId} : Returns data of specified product category
     *
     * @param productCategoryId product category ID (required)
     * @param with    with Comma separated, optional keys that should be included in the response. (optional)
     *                <br/> "permission,custom_fields"
     * @return CatalogCategoryGET - Data of the requested product
     */
    public CatalogCategoryGET getCatalogProductCategoryById(int productCategoryId, String with) {
        ResponseEntity<ItemCatalogCategoryGET> response = catalogApiClient.getCatalogProductCategory(productCategoryId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * DELETE /catalog/products/categories/{categoryIds} : Deletes specified product categories
     * @param productCategoryName the name of the product
     */
    public void deleteProductCategoryByNameIfExists(String productCategoryName) {
        ResponseEntity<ListProductsCategories> response = catalogApiClient.getCatalogProductCategories(null, null, "{\"name\":\"" + productCategoryName + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = catalogApiClient.deleteCatalogProductCategories(response.getBody().getItems().get(0).getId());
        }
    }

    /**
     * DELETE /catalog/products/{productIds} : Deletes specified product categories
     * @param productCategoryIds comma separated product category IDs (required)
     */
    public void deleteCatalogProductCategoryByIds(Integer... productCategoryIds) {
        ResponseEntity<Void> response = catalogApiClient.deleteCatalogProductCategories(productCategoryIds);
    }

    /**
     * POST /catalog/products/categories : Creates new product category
     *
     * @param productCategory CatalogCategoryPOST – product category
     * @return CatalogCategoryGET - Data of the created product
     */
    public CatalogCategoryGET createCatalogProductCategory(CatalogCategoryPOST productCategory) {
        ResponseEntity<ItemCatalogCategoryGET> response = catalogApiClient.createCatalogProductCategory(productCategory);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /catalog/products/categories/{categoryId} : Updates specified product category
     *
     * @param productCategory CatalogCategoryGET - product category (required)
     * @return CatalogCategoryGET - Data of the updated product category
     * @throws IOException if mapping from ItemCatalogProductGET to CatalogProductPUT fails
     */
    public CatalogCategoryGET updateCatalogProductCategory(CatalogCategoryGET productCategory) throws IOException {
        CatalogCategoryPUT changedCatalogProduct = mapFromJson(mapToJson(productCategory), CatalogCategoryPUT.class);
        ResponseEntity<ItemCatalogCategoryGET> response = catalogApiClient.updateCatalogProductCategory(productCategory.getId(), changedCatalogProduct);
        return Objects.requireNonNull(response.getBody()).getItem();
    }


    // ======= CatalogProduct ==========

    /**
     * GET /catalog/products : Returns list of products
     *
     * @param with   Comma separated, optional keys that should be included in the response. (optional)
     *               <br/> "permission,custom_fields"
     * @param filter filter Filter expression (JSON) (optional)
     * @return {@code List<CatalogProductGET>} Data of the requested products
     */
    public List<CatalogProductGET> getCatalogProducts(String with, String filter) {
        try {
            ResponseEntity<ListProducts> response = catalogApiClient.getCatalogProducts(with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /catalog/products/{productId} : Returns data of specified product
     *
     * @param productId product ID (required)
     * @param with    with Comma separated, optional keys that should be included in the response. (optional)
     *                <br/> "permission,custom_fields"
     * @return CatalogProductGET - Data of the requested product
     */
    public CatalogProductGET getCatalogProductById(int productId, String with) {
        ResponseEntity<ItemCatalogProductGET> response = catalogApiClient.getCatalogProduct(productId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * DELETE /catalog/products/{productIds} : Deletes specified products
     * @param productName the name of the product
     */
    public void deleteCatalogProductByNameIfExists(String productName) {
        ResponseEntity<ListProducts> response = catalogApiClient.getCatalogProducts(null, null, "{\"name\":\"" + productName + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = catalogApiClient.deleteCatalogProducts(response.getBody().getItems().get(0).getId());
        }
    }

    /**
     * DELETE /catalog/products/{productIds} : Deletes specified products
     * @param productIds comma separated product IDs (required)
     */
    public void deleteCatalogProductByIds(Integer... productIds) {
        ResponseEntity<Void> response = catalogApiClient.deleteCatalogProducts(productIds);
    }

    /**
     * POST /catalog/products : Creates new product
     *
     * @param product CatalogProductPOST – product
     * @return CatalogProductGET - Data of the created product
     */
    public CatalogProductGET createCatalogProduct(CatalogProductPOST product) {
        ResponseEntity<ItemCatalogProductGET> response = catalogApiClient.createCatalogProduct(product);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /catalog/products/{productId} : Updates specified product
     *
     * @param product CatalogProductGET - product (required)
     * @return CatalogProductGET - Data of the updated product
     * @throws IOException if mapping from ItemCatalogProductGET to CatalogProductPUT fails
     */
    public CatalogProductGET updateCatalogProduct(CatalogProductGET product) throws IOException {
        CatalogProductPUT changedCatalogProduct = mapFromJson(mapToJson(product), CatalogProductPUT.class);
        ResponseEntity<ItemCatalogProductGET> response = catalogApiClient.updateCatalogProduct(product.getId(), changedCatalogProduct);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    // ======= CatalogServiceCategory ==========

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
     * GET /catalog/services/categories : Returns list of service categories
     *
     * @param with   Comma separated, optional keys that should be included in the response. (optional)
     *               <br/> "permission,custom_fields"
     * @param filter filter Filter expression (JSON) (optional)
     * @return {@code List<CatalogCategoryGET>} Data of the requested service categories
     */
    public List<CatalogCategoryGET> getCatalogServiceCategories(String with, String filter) {
        try {
            ResponseEntity<ListServicesCategories> response = catalogApiClient.getCatalogServiceCategories(with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /catalog/services/categories/{categoryId} : Returns data of specified service category
     *
     * @param serviceCategoryId service category ID (required)
     * @param with    with Comma separated, optional keys that should be included in the response. (optional)
     *                <br/> "permission,custom_fields"
     * @return CatalogCategoryGET - Data of the requested service
     */
    public CatalogCategoryGET getCatalogServiceCategoryById(int serviceCategoryId, String with) {
        ResponseEntity<ItemCatalogCategoryGET> response = catalogApiClient.getCatalogServiceCategory(serviceCategoryId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * DELETE /catalog/services/categories/{categoryIds} : Deletes specified service categories
     * @param serviceCategoryName the name of the service
     */
    public void deleteServiceCategoryByNameIfExists(String serviceCategoryName) {
        ResponseEntity<ListServicesCategories> response = catalogApiClient.getCatalogServiceCategories(null, null, "{\"name\":\"" + serviceCategoryName + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = catalogApiClient.deleteCatalogServiceCategories(response.getBody().getItems().get(0).getId());
        }
    }

    /**
     * DELETE /catalog/services/{serviceIds} : Deletes specified service categories
     * @param serviceCategoryIds comma separated service category IDs (required)
     */
    public void deleteCatalogServiceCategoryByIds(Integer... serviceCategoryIds) {
        ResponseEntity<Void> response = catalogApiClient.deleteCatalogServiceCategories(serviceCategoryIds);
    }

    /**
     * POST /catalog/services/categories : Creates new service category
     *
     * @param serviceCategory CatalogCategoryPOST – service category
     * @return CatalogCategoryGET - Data of the created service
     */
    public CatalogCategoryGET createCatalogServiceCategory(CatalogCategoryPOST serviceCategory) {
        ResponseEntity<ItemCatalogCategoryGET> response = catalogApiClient.createCatalogServiceCategory(serviceCategory);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /catalog/services/categories/{categoryId} : Updates specified service category
     *
     * @param serviceCategory CatalogCategoryGET - service category (required)
     * @return CatalogCategoryGET - Data of the updated service category
     * @throws IOException if mapping from ItemCatalogServiceGET to CatalogServicePUT fails
     */
    public CatalogCategoryGET updateCatalogServiceCategory(CatalogCategoryGET serviceCategory) throws IOException {
        CatalogCategoryPUT changedCatalogService = mapFromJson(mapToJson(serviceCategory), CatalogCategoryPUT.class);
        ResponseEntity<ItemCatalogCategoryGET> response = catalogApiClient.updateCatalogServiceCategory(serviceCategory.getId(), changedCatalogService);
        return Objects.requireNonNull(response.getBody()).getItem();
    }


    // ======= Catalog Unit ==========

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


    // ======= CatalogService ==========

    /**
     * GET /catalog/services : Returns list of services
     *
     * @param with   Comma separated, optional keys that should be included in the response. (optional)
     *               <br/> "permission,custom_fields"
     * @param filter filter Filter expression (JSON) (optional)
     * @return {@code List<CatalogServiceGET>} Data of the requested services
     */
    public List<CatalogServiceGET> getCatalogServices(String with, String filter) {
        try {
            ResponseEntity<ListServices> response = catalogApiClient.getCatalogServices(with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /catalog/services/{serviceId} : Returns data of specified service
     *
     * @param serviceId service ID (required)
     * @param with    with Comma separated, optional keys that should be included in the response. (optional)
     *                <br/> "permission,custom_fields"
     * @return CatalogServiceGET Data of the requested service
     */
    public CatalogServiceGET getCatalogServiceById(int serviceId, String with) {
        ResponseEntity<ItemCatalogServiceGET> response = catalogApiClient.getCatalogService(serviceId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * DELETE /catalog/services/{serviceIds} : Deletes specified services
     * @param serviceName the name of the service
     */
    public void deleteCatalogServiceByNameIfExists(String serviceName) {
        ResponseEntity<ListServices> response = catalogApiClient.getCatalogServices(null, null, "{\"name\":\"" + serviceName + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = catalogApiClient.deleteCatalogServices(response.getBody().getItems().get(0).getId());
        }
    }

    /**
     * DELETE /catalog/services/{serviceIds} : Deletes specified services
     * @param serviceIds comma separated service IDs (required)
     */
    public void deleteCatalogServiceByIds(Integer... serviceIds) {
        ResponseEntity<Void> response = catalogApiClient.deleteCatalogServices(serviceIds);
    }

    /**
     * POST /catalog/services : Creates new service
     *
     * @param service CatalogServicePOST – service
     * @return CatalogServiceGET Data of the created service
     */
    public CatalogServiceGET createCatalogService(CatalogServicePOST service) {
        ResponseEntity<ItemCatalogServiceGET> response = catalogApiClient.createCatalogService(service);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /catalog/services/{serviceId} : Updates specified service
     *
     * @param service CatalogServiceGET - service (required)
     * @return CatalogServiceGET -Data of the updated service
     * @throws IOException if mapping from ItemCatalogServiceGET to CatalogServicePUT fails
     */
    public CatalogServiceGET updateCatalogService(CatalogServiceGET service) throws IOException {
        CatalogServicePUT changedCatalogService = mapFromJson(mapToJson(service), CatalogServicePUT.class);
        ResponseEntity<ItemCatalogServiceGET> response = catalogApiClient.updateCatalogService(service.getId(), changedCatalogService);
        return Objects.requireNonNull(response.getBody()).getItem();
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
     * @param with Comma separated, optional keys that should be included in the response (optional).
     * @return ReceivablesConfigurationIsrGET one ISR Record
     */
    public ReceivablesConfigurationIsrGET getIsrById(int isrNoteId, String with) {
        ResponseEntity<ItemReceivablesConfigurationIsrGET> response = receivablesApiClient.getIsr(isrNoteId, with);
        if (response.getBody() != null) return response.getBody().getItem();
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
     * DELETE /receivables/delivery-notes/{deliveryNoteIds} : Deletes specified delivery notes
     * @param deliveryNoteIds comma separated delivery note IDs (required)
     */
    public void deleteDeliveryNoteByIds(Integer... deliveryNoteIds) {
        ResponseEntity<Void> response = receivablesApiClient.deleteDeliveryNotes(deliveryNoteIds);
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

    /**
     * Creates a document position
     * @param catalogProduct CatalogProductGET - catalog product data
     * @param amount the amount of products
     * @return DocumentDeliveryNotePositionPOST - the position
     * @throws IOException in case of mapping error
     */
    public DocumentDeliveryNotePositionPOST createDeliveryNoteProductPosition(CatalogProductGET catalogProduct, float amount) throws IOException {
        DocumentDeliveryNotePositionPOST productPosition = mapFromJson(mapToJson(catalogProduct), DocumentDeliveryNotePositionPOST.class);
        productPosition.catalogType(DocumentDeliveryNotePositionPOST.CatalogTypeEnum.P)
                .type(DocumentDeliveryNotePositionPOST.TypeEnum.N)
                .amount(amount)
                .showOnlyTotal(false);
        return productPosition;
    }

    /**
     * Creates a document position
     * @param catalogService CatalogServiceGET - catalog service data
     * @param amount the amount of services
     * @return DocumentDeliveryNotePositionPOST - the postion
     * @throws IOException in case of mapping error
     */
    public DocumentDeliveryNotePositionPOST createDeliveryNoteServicePosition(CatalogServiceGET catalogService, float amount) throws IOException {
        DocumentDeliveryNotePositionPOST servicePosition = mapFromJson(mapToJson(catalogService), DocumentDeliveryNotePositionPOST.class);
        servicePosition.catalogType(DocumentDeliveryNotePositionPOST.CatalogTypeEnum.S)
                .type(DocumentDeliveryNotePositionPOST.TypeEnum.N)
                .amount(amount)
                .showOnlyTotal(false);
        return servicePosition;
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
     * DELETE /receivables/invoices/{invoiceIds} : Deletes specified invoices
     * @param invoiceIds comma separated invoice IDs (required)
     */
    public void deleteInvoiceStandardByIds(Integer... invoiceIds) {
        ResponseEntity<Void> response = receivablesApiClient.deleteInvoices(invoiceIds);
    }

    /**
     * POST /receivables/invoices : Creates new invoice
     *
     * @param invoice documentInvoiceStandardPOST – invoice
     * @return Data of the created invoice
     */
    public DocumentInvoiceStandardGET createInvoiceStandard(DocumentInvoiceStandardPOST invoice) {
        ResponseEntity<ItemDocumentInvoiceStandardGET> response = receivablesApiClient.createInvoice(invoice);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /receivables/invoices/{invoiceId} : Updates specified invoice
     *
     * @param invoice DocumentInvoiceStandardGET - invoice (required)
     * @return Data of the updated invoice
     * @throws IOException if mapping from DocumentInvoiceStandardGET to DocumentInvoiceStandardPUT fails
     */
    public DocumentInvoiceStandardGET updateInvoiceStandard(DocumentInvoiceStandardGET invoice) throws IOException {
        DocumentInvoiceStandardPUT changedInvoiceStandard = mapFromJson(mapToJson(invoice), DocumentInvoiceStandardPUT.class);
        ResponseEntity<ItemDocumentInvoiceStandardGET> response = receivablesApiClient.updateInvoice(invoice.getId(), changedInvoiceStandard);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PATCH /receivables/invoices/{invoiceId}/change-status : Changes status of specified invoice
     *
     * @param invoiceId invoiceId – invoice ID (required)
     * @param status         documentInvoiceStandardChangeStatusPATCH.<br/> StatusEnum – change status, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)
     * @return Data of the changed invoice
     */
    public DocumentInvoiceStandardGET changeInvoiceStandardStatusById(
            int invoiceId, DocumentInvoiceStandardChangeStatusPATCH.StatusEnum status) {
        DocumentInvoiceStandardChangeStatusPATCH patch = new DocumentInvoiceStandardChangeStatusPATCH();
        patch.status(status)
                .dateTime(LocalDateTime.now());
        ResponseEntity<ItemDocumentInvoiceStandardGET> response = receivablesApiClient.changeInvoiceStatus(invoiceId, patch);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * GET /receivables/invoices/{invoiceId}/pdf : Gets pdf of specified invoice
     *
     * @param invoiceId invoiceId – invoice ID (required)
     * @return The PDF as a Resource
     */
    public Resource getInvoiceStandardPdfResource(int invoiceId, DocumentInvoicePdfOptionsGET options) {
        ResponseEntity<Resource> response = receivablesApiClient.getInvoicePdf(invoiceId, options);
        return response.getBody();
    }

    /**
     * GET /receivables/invoices/{invoiceId}/preview : Gets preview of specified invoice
     *
     * @param invoiceId invoiceId – invoice ID (required)
     * @param page           page – page number [1 .. pages amount] (optional, default to 1)
     * @param size           width in pixels (optional, <br/> allowableValues = 240, 595, 600, 972, 1240, defaultValue = 972)
     * @return The png image as resource
     */
    public Resource getInvoiceStandardPreviewResource(int invoiceId, Integer page, Integer size) {
        // size on of "240, 595, 600, 972, 1240"
        ResponseEntity<Resource> response = receivablesApiClient.getInvoicePreview(invoiceId, page, size);
        return response.getBody();
    }

    /**
     * PATCH /receivables/invoices/{invoiceId}/send-by-email : Sends specified invoice by email Sends specified invoice by email
     *
     * @param invoiceId invoiceId – invoice ID (required)
     * @param email          documentInvoiceStandardSendByEmailPATCH – sending mail data details
     */
    public void sendInvoiceStandardByEMail(int invoiceId, DocumentInvoiceSendByEmailPATCH email) {
        ResponseEntity<Void> response = receivablesApiClient.sendInvoiceByEMail(invoiceId, email);
    }

    /**
     * PATCH /receivables/invoices/{invoiceId}/send-by-post : Sends the specified invoice by post
     *
     * @param invoiceId invoiceId – invoice ID (required)
     * @param post           documentSendByPostPATCH – sending post data details
     */
    public void sendInvoiceStandardByPost(int invoiceId, DocumentSendByPostPATCH post) {
        ResponseEntity<Void> response = receivablesApiClient.sendInvoiceByPost(invoiceId, post);
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
     * Creates a document position
     * @param catalogProduct CatalogProductGET - catalog product data
     * @param amount the amount of products
     * @return DocumentDeliveryNotePositionPOST - the position
     * @throws IOException in case of mapping error
     */
    public DocumentInvoicePositionPOST createInvoiceProductPosition(CatalogProductGET catalogProduct, float amount) throws IOException {
        DocumentInvoicePositionPOST productPosition = mapFromJson(mapToJson(catalogProduct), DocumentInvoicePositionPOST.class);
        productPosition.catalogType(DocumentInvoicePositionPOST.CatalogTypeEnum.P)
                .type(DocumentInvoicePositionPOST.TypeEnum.N)
                .amount(amount)
                .showOnlyTotal(false);
        return productPosition;
    }

    /**
     * Creates a document position
     * @param catalogService CatalogServiceGET - catalog service data
     * @param amount the amount of services
     * @return DocumentDeliveryNotePositionPOST - the postion
     * @throws IOException in case of mapping error
     */
    public DocumentInvoicePositionPOST createInvoiceServicePosition(CatalogServiceGET catalogService, float amount) throws IOException {
        DocumentInvoicePositionPOST servicePosition = mapFromJson(mapToJson(catalogService), DocumentInvoicePositionPOST.class);
        servicePosition.catalogType(DocumentInvoicePositionPOST.CatalogTypeEnum.S)
                .type(DocumentInvoicePositionPOST.TypeEnum.N)
                .amount(amount)
                .showOnlyTotal(false);
        return servicePosition;
    }


    // ============= Payments ===================



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

    /**
     * DELETE /receivables/invoices/{invoiceId}/payments/{paymentIds} : Deletes specified invoice's payments
     * @param paymentIds comma separated payment IDs (required)
     */
    public void deleteInvoicePaymentByIds(int invoiceId, Integer... paymentIds) {
        ResponseEntity<Void> response = receivablesApiClient.deleteInvoicePayment(invoiceId, paymentIds);
    }

    /**
     * POST /receivables/invoices/{invoiceId}/payments
     *
     * @param invoiceId invoiceId (required)
     * @param payment DocumentInvoicePaymentPOST – payment data
     * @return DocumentInvoicePaymentGET Data of the created payment
     */
    public DocumentInvoicePaymentGET createInvoicePayment(int invoiceId, DocumentInvoicePaymentPOST payment) {
        ResponseEntity<ItemDocumentInvoicePaymentGET> response = receivablesApiClient.createInvoicePayment(invoiceId, payment);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /receivables/invoices/{invoiceId}/payments/{paymentId} : Updates specified invoice's payment
     * @param invoiceId invoiceId (required)
     * @param payment DocumentInvoicePaymentGET - payment (required)
     * @return DocumentInvoicePaymentGET -Data of the updated payment
     * @throws IOException if mapping from DocumentInvoicePaymentGET to DocumentInvoicePaymentPUT fails
     */
    public DocumentInvoicePaymentGET updateInvoicePayment(int invoiceId, DocumentInvoicePaymentGET payment) throws IOException {
        DocumentInvoicePaymentPUT changedOffer = mapFromJson(mapToJson(payment), DocumentInvoicePaymentPUT.class);
        ResponseEntity<ItemDocumentInvoicePaymentGET> response = receivablesApiClient.updateInvoicePayment(payment.getId(), invoiceId, changedOffer);
        return Objects.requireNonNull(response.getBody()).getItem();
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
     *                <br/> "permissions,positions,texts,free_texts,contact_person,contact_prepage_address,contact_address,contact,custom_fields"
     * @return DocumentOfferGET Data of the requested offer
     */
    public DocumentOfferGET getOfferById(int offerId, String with) {
        ResponseEntity<ItemDocumentOfferGET> response = receivablesApiClient.getOffer(offerId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * DELETE /receivables/offers/{offerIds} : Deletes specified offers
     * @param offerIds comma separated offer IDs (required)
     */
    public void deleteOfferByIds(Integer... offerIds) {
        ResponseEntity<Void> response = receivablesApiClient.deleteOffers(offerIds);
    }

    /**
     * POST /receivables/offers : Creates new offer
     *
     * @param offer DocumentOfferPOST – offer
     * @return DocumentOfferGET Data of the created offer
     */
    public DocumentOfferGET createOffer(DocumentOfferPOST offer) {
        ResponseEntity<ItemDocumentOfferGET> response = receivablesApiClient.createOffer(offer);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /receivables/offers/{offerId} : Updates specified offer
     *
     * @param offer DocumentOfferGET - offer (required)
     * @return DocumentOfferGET -Data of the updated offer
     * @throws IOException if mapping from ItemDocumentOfferGET to DocumentOfferPUT fails
     */
    public DocumentOfferGET updateOffer(DocumentOfferGET offer) throws IOException {
        DocumentOfferPUT changedOffer = mapFromJson(mapToJson(offer), DocumentOfferPUT.class);
        ResponseEntity<ItemDocumentOfferGET> response = receivablesApiClient.updateOffer(offer.getId(), changedOffer);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PATCH /receivables/offers/{offerId}/change-status : Changes status of specified offer
     *
     * @param offerId  offer ID (required)
     * @param status         DocumentOfferChangeStatusPATCH. status of offer,
     *                       <br/> possible values: DR - draft, S - sent, DE - declined, A - accepted, B - billed, D - deleted (but still visible)
     * @return DocumentOfferGET - Data of the changed offer
     */
    public DocumentOfferGET changeOfferStatusById(
            int offerId, DocumentOfferChangeStatusPATCH.StatusEnum status) {
        DocumentOfferChangeStatusPATCH patch = new DocumentOfferChangeStatusPATCH();
        patch.status(status)
                .dateTime(LocalDateTime.now());
        ResponseEntity<ItemDocumentOfferGET> response = receivablesApiClient.changeOfferStatus(offerId, patch);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * GET /receivables/offers/{offerId}/pdf : Gets pdf of specified offer
     *
     * @param offerId   offer ID (required)
     * @return The PDF as a Resource
     */
    public Resource getOfferPdfResource(int offerId) {
        ResponseEntity<Resource> response = receivablesApiClient.getOfferPdf(offerId);
        return response.getBody();
    }

    /**
     * GET /receivables/offers/{offerId}/preview : Gets preview of specified offer
     *
     * @param offerId  offer ID (required)
     * @param page           page – page number [1 .. pages amount] (optional, default to 1)
     * @param size           width in pixels (optional, <br/> allowableValues = 240, 595, 600, 972, 1240, defaultValue = 972)
     * @return The png image as resource
     */
    public Resource getOfferPreviewResource(int offerId, Integer page, Integer size) {
        // size on of "240, 595, 600, 972, 1240"
        ResponseEntity<Resource> response = receivablesApiClient.getOfferPreview(offerId, page, size);
        return response.getBody();
    }

    /**
     * PATCH /receivables/offers/{offerId}/send-by-email : Sends specified offer by email
     *
     * @param offerId  offer ID (required)
     * @param email          DocumentOfferSendByEmailPATCH – sending mail data details
     */
    public void sendOfferByEMail(int offerId, DocumentOfferSendByEmailPATCH email) {
        ResponseEntity<Void> response = receivablesApiClient.sendOfferByEMail(offerId, email);
    }

    /**
     * PATCH /receivables/offers/{offerId}/send-by-post : Sends specified offer by post
     *
     * @param offerId  offer ID (required)
     * @param post           DocumentSendByPostPATCH – sending post data details
     */
    public void sendOfferByPost(int offerId, DocumentSendByPostPATCH post) {
        ResponseEntity<Void> response = receivablesApiClient.sendOfferByPost(offerId, post);
    }

    /**
     * Creates a document position
     * @param catalogProduct CatalogProductGET - catalog product data
     * @param amount the amount of products
     * @return DocumentOfferPositionPOST - the position
     * @throws IOException in case of mapping error
     */
    public DocumentOfferPositionPOST createOfferProductPosition(CatalogProductGET catalogProduct, float amount) throws IOException {
        DocumentOfferPositionPOST productPosition = mapFromJson(mapToJson(catalogProduct), DocumentOfferPositionPOST.class);
        productPosition.catalogType(DocumentOfferPositionPOST.CatalogTypeEnum.P)
                .type(DocumentOfferPositionPOST.TypeEnum.N)
                .amount(amount)
                .showOnlyTotal(false);
        return productPosition;
    }

    /**
     * Creates a document position
     * @param catalogService CatalogServiceGET - catalog service data
     * @param amount the amount of services
     * @return DocumentOfferPositionPOST - the position
     * @throws IOException in case of mapping error
     */
    public DocumentOfferPositionPOST createOfferServicePosition(CatalogServiceGET catalogService, float amount) throws IOException {
        DocumentOfferPositionPOST servicePosition = mapFromJson(mapToJson(catalogService), DocumentOfferPositionPOST.class);
        servicePosition.catalogType(DocumentOfferPositionPOST.CatalogTypeEnum.S)
                .type(DocumentOfferPositionPOST.TypeEnum.N)
                .amount(amount)
                .showOnlyTotal(false);
        return servicePosition;
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
     * @param orderConfirmationId order confirmation ID (required)
     * @param with    with with Comma separated, optional keys that should be included in the response. (optional)
     *                *             <br/>"permissions,positions,texts,free_texts,contact_person,contact_prepage_address,contact_address,contact,custom_fields"
     * @return DocumentOrderConfirmationGET Data of the requested order confirmation
     */
    public DocumentOrderConfirmationGET getOrderConfirmationById(int orderConfirmationId, String with) {

        ResponseEntity<ItemDocumentOrderConfirmationGET> response = receivablesApiClient.getOrderConfirmation(orderConfirmationId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * DELETE /receivables/order-confirmations/{orderConfirmationIds} : Deletes specified order confirmation
     * @param orderConfirmationIds comma separated orderConfirmation IDs (required)
     */
    public void deleteOrderConfirmationByIds(Integer... orderConfirmationIds) {
        ResponseEntity<Void> response = receivablesApiClient.deleteOrderConfirmations(orderConfirmationIds);
    }

    /**
     * POST /receivables/order-confirmations : Creates new order confirmation
     *
     * @param orderConfirmation DocumentOrderConfirmationPOST – orderConfirmation
     * @return DocumentOrderConfirmationGET Data of the created orderConfirmation
     */
    public DocumentOrderConfirmationGET createOrderConfirmation(DocumentOrderConfirmationPOST orderConfirmation) {
        ResponseEntity<ItemDocumentOrderConfirmationGET> response = receivablesApiClient.createOrderConfirmation(orderConfirmation);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /receivables/order-confirmations/{orderConfirmationId} : Updates specified order confirmation
     *
     * @param orderConfirmation DocumentOrderConfirmationGET - orderConfirmation (required)
     * @return DocumentOrderConfirmationGET -Data of the updated orderConfirmation
     * @throws IOException if mapping from ItemDocumentOrderConfirmationGET to DocumentOrderConfirmationPUT fails
     */
    public DocumentOrderConfirmationGET updateOrderConfirmation(DocumentOrderConfirmationGET orderConfirmation) throws IOException {
        DocumentOrderConfirmationPUT changedOrderConfirmation = mapFromJson(mapToJson(orderConfirmation), DocumentOrderConfirmationPUT.class);
        ResponseEntity<ItemDocumentOrderConfirmationGET> response = receivablesApiClient.updateOrderConfirmation(orderConfirmation.getId(), changedOrderConfirmation);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PATCH /receivables/order-confirmations/{orderConfirmationId}/change-status : Changes status of specified order confirmation
     *
     * @param orderConfirmationId  orderConfirmation ID (required)
     * @param status         DocumentOrderConfirmationChangeStatusPATCH. status of orderConfirmation,
     *                       <br/> possible values: DR - draft, S - sent, DE - declined, A - accepted, B - billed, D - deleted (but still visible)
     * @return DocumentOrderConfirmationGET - Data of the changed orderConfirmation
     */
    public DocumentOrderConfirmationGET changeOrderConfirmationStatusById(
            int orderConfirmationId, DocumentOrderConfirmationChangeStatusPATCH.StatusEnum status) {
        DocumentOrderConfirmationChangeStatusPATCH patch = new DocumentOrderConfirmationChangeStatusPATCH();
        patch.status(status)
                .dateTime(LocalDateTime.now());
        ResponseEntity<ItemDocumentOrderConfirmationGET> response = receivablesApiClient.changeOrderConfirmationStatus(orderConfirmationId, patch);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * GET /receivables/order-confirmations/{orderConfirmationId}/pdf : Gets pdf of specified order confirmation
     *
     * @param orderConfirmationId   orderConfirmation ID (required)
     * @return The PDF as a Resource
     */
    public Resource getOrderConfirmationPdfResource(int orderConfirmationId) {
        ResponseEntity<Resource> response = receivablesApiClient.getOrderConfirmationPdf(orderConfirmationId);
        return response.getBody();
    }

    /**
     * GET /receivables/order-confirmations/{orderConfirmationId}/preview : Gets preview of specified order confirmation
     *
     * @param orderConfirmationId  orderConfirmation ID (required)
     * @param page           page – page number [1 .. pages amount] (optional, default to 1)
     * @param size           width in pixels (optional, <br/> allowableValues = 240, 595, 600, 972, 1240, defaultValue = 972)
     * @return The png image as resource
     */
    public Resource getOrderConfirmationPreviewResource(int orderConfirmationId, Integer page, Integer size) {
        // size on of "240, 595, 600, 972, 1240"
        ResponseEntity<Resource> response = receivablesApiClient.getOrderConfirmationPreview(orderConfirmationId, page, size);
        return response.getBody();
    }

    /**
     * PATCH /receivables/order-confirmations/{orderConfirmationId}/send-by-email : Sends specified order confirmation by email
     *
     * @param orderConfirmationId  orderConfirmation ID (required)
     * @param email          DocumentOrderConfirmationSendByEmailPATCH – sending mail data details
     */
    public void sendOrderConfirmationByEMail(int orderConfirmationId, DocumentOrderConfirmationSendByEmailPATCH email) {
        ResponseEntity<Void> response = receivablesApiClient.sendOrderConfirmationByEMail(orderConfirmationId, email);
    }

    /**
     * PATCH /receivables/order-confirmations/{orderConfirmationId}/send-by-post : Sends specified order confirmation by post
     *
     * @param orderConfirmationId  orderConfirmation ID (required)
     * @param post           DocumentSendByPostPATCH – sending post data details
     */
    public void sendOrderConfirmationByPost(int orderConfirmationId, DocumentSendByPostPATCH post) {
        ResponseEntity<Void> response = receivablesApiClient.sendOrderConfirmationByPost(orderConfirmationId, post);
    }

    /**
     * Creates a document position
     * @param catalogProduct CatalogProductGET - catalog product data
     * @param amount the amount of products
     * @return DocumentOrderConfirmationPositionPOST - the position
     * @throws IOException in case of mapping error
     */
    public DocumentOrderConfirmationPositionPOST createOrderConfirmationProductPosition(CatalogProductGET catalogProduct, float amount) throws IOException {
        DocumentOrderConfirmationPositionPOST productPosition = mapFromJson(mapToJson(catalogProduct), DocumentOrderConfirmationPositionPOST.class);
        productPosition.catalogType(DocumentOrderConfirmationPositionPOST.CatalogTypeEnum.P)
                .type(DocumentOrderConfirmationPositionPOST.TypeEnum.N)
                .amount(amount)
                .showOnlyTotal(false);
        return productPosition;
    }

    /**
     * Creates a document position
     * @param catalogService CatalogServiceGET - catalog service data
     * @param amount the amount of services
     * @return DocumentOrderConfirmationPositionPOST - the position
     * @throws IOException in case of mapping error
     */
    public DocumentOrderConfirmationPositionPOST createOrderConfirmationServicePosition(CatalogServiceGET catalogService, float amount) throws IOException {
        DocumentOrderConfirmationPositionPOST servicePosition = mapFromJson(mapToJson(catalogService), DocumentOrderConfirmationPositionPOST.class);
        servicePosition.catalogType(DocumentOrderConfirmationPositionPOST.CatalogTypeEnum.S)
                .type(DocumentOrderConfirmationPositionPOST.TypeEnum.N)
                .amount(amount)
                .showOnlyTotal(false);
        return servicePosition;
    }

    // ==================================
    //          Reporting
    // ==================================


    // ========== Activities ============

    /**
     * GET /reporting/activities : Returns list of activities entries
     *
     * @param filter filter Filter expression (JSON) (optional)
     * @param with    with with Comma separated, optional keys that should be included in the response. (optional)
     *                    <br/>"permissions"
     * @return {@code List<ActivityGET>} - Data of the requested activities entries
     */
    public @Valid List<ActivityGET> getReportingActivities(String with, String filter) {
        try {
            ResponseEntity<ListReportingActivities> response = reportingApiClient.getActivities( with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /reporting/activities/{activityId} : Returns data of specified activity entry
     *
     * @param activityId activity ID (required)
     * @param with    with with Comma separated, optional keys that should be included in the response. (optional)
     *                    <br/>"permissions"
     * @return ActivityGET - Data of the requested activity
     */
    public @NotNull @Valid ActivityGET getReportingActivityById(Integer activityId, String with) {

        ResponseEntity<ItemActivityGET> response = reportingApiClient.getActivity(activityId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }


    // ========= Cost Unit ==============
    /**
     * GET /reporting/cost-units : Returns list of cost units
     *
     * @param filter filter Filter expression (JSON) (optional)
     * @return {@code List<ReportingCostUnitGET>} - Data of the requested cost units
     */
    public @Valid List<ReportingCostUnitGET> getReportingCostUnits(String filter) {
        try {
            ResponseEntity<ListReportingCostUnits> response = reportingApiClient.getCostUnits( null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /reporting/cost-units/{costUnitId} : Returns data of specified cost unit
     *
     * @param costUnitId cost unit ID (required)
     * @return ReportingCostUnitGET - Data of the requested cost unit
     */
    public ReportingCostUnitGET getReportingCostUnitById(int costUnitId) {

        ResponseEntity<ItemReportingCostUnitGET> response = reportingApiClient.getCostUnit(costUnitId);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * DELETE /reporting/cost-units/{costUnitIds} : Deletes specified cost unit
     * @param costUnitIds comma separated costUnit IDs (required)
     */
    public void deleteReportingCostUnitByIds(Integer... costUnitIds) {
        ResponseEntity<Void> response = reportingApiClient.deleteCostUnits(costUnitIds);
    }

    /**
     * POST /reporting/cost-units : Creates new cost unit
     *
     * @param costUnit ReportingCostUnitPOST – costUnit
     * @return ReportingCostUnitGET - Data of the created costUnit
     */
    public ReportingCostUnitGET createReportingCostUnit(ReportingCostUnitPOST costUnit) {
        ResponseEntity<ItemReportingCostUnitGET> response = reportingApiClient.createCostUnit(costUnit);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /reporting/cost-units/{costUnitId} : Updates specified cost unit
     *
     * @param costUnit ReportingCostUnitGET - costUnit (required)
     * @return ReportingCostUnitGET -Data of the updated costUnit
     * @throws IOException if mapping from ReportingCostUnitGET to ReportingCostUnitPUT fails
     */
    public ReportingCostUnitGET updateReportingCostUnit(ReportingCostUnitGET costUnit) throws IOException {
        ReportingCostUnitPUT changedReportingCostUnit = mapFromJson(mapToJson(costUnit), ReportingCostUnitPUT.class);
        ResponseEntity<ItemReportingCostUnitGET> response = reportingApiClient.updateCostUnit(costUnit.getId(), changedReportingCostUnit);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    // ========= Efforts ==============
    /**
     * GET /reporting/efforts : Returns list of efforts
     * @param with  with with Comma separated, optional keys that should be included in the response. (optional)
     *              <br/>"user_name,activity_name,permissions"
     * @param filter filter Filter expression (JSON) (optional)
     * @return {@code List<ReportingEffortGET>} - Data of the requested efforts
     */
    public @Valid List<ReportingEffortGET> getReportingEfforts(String with, String filter) {
        try {
            ResponseEntity<ListReportingEfforts> response = reportingApiClient.getEfforts( with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /reporting/efforts/{effortId} : Returns data of specified effort
     *
     * @param effortId effort ID (required)
     * @param with    with with Comma separated, optional keys that should be included in the response. (optional)
     *                *             <br/>"permissions,custom_fields"
     * @return ReportingEffortGET - Data of the requested effort
     */
    public @NotNull @Valid ReportingEffortGET getReportingEffortById(int effortId, String with) {

        ResponseEntity<ItemReportingEffortGET> response = reportingApiClient.getEffort(effortId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * DELETE /reporting/efforts/{effortIds} : Deletes specified effort
     * @param effortIds comma separated effort IDs (required)
     */
    public void deleteReportingEffortByIds(Integer... effortIds) {
        ResponseEntity<Void> response = reportingApiClient.deleteEfforts(effortIds);
    }

    /**
     * POST /reporting/efforts : Creates new effort
     *
     * @param effort ReportingEffortPOST – effort
     * @return ReportingEffortGET - Data of the created effort
     */
    public ReportingEffortGET createReportingEffort(ReportingEffortPOST effort) {
        ResponseEntity<ItemReportingEffortGET> response = reportingApiClient.createEffort(effort);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /reporting/efforts/{effortId} : Updates specified effort
     *
     * @param effort ReportingEffortGET - effort (required)
     * @return ReportingEffortGET - Data of the updated effort
     * @throws IOException if mapping from ReportingEffortPUT to ReportingEffortPUT fails
     */
    public ReportingEffortGET updateReportingEffort(ReportingEffortGET effort) throws IOException {
        ReportingEffortPUT changedReportingEffort = mapFromJson(mapToJson(effort), ReportingEffortPUT.class);
        ResponseEntity<ItemReportingEffortGET> response = reportingApiClient.updateEffort(effort.getId(), changedReportingEffort);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    // ========= Projects ==============
    /**
     * GET /reporting/projects : Returns list of projects
     * @param with  with with Comma separated, optional keys that should be included in the response. (optional)
     *              <br/>"contact_name,permissions"
     * @param filter filter Filter expression (JSON) (optional)
     * @return {@code List<ReportingProjectGET>} - Data of the requested projects
     */
    public @Valid List<ReportingProjectGET> getReportingProjects(String with, String filter) {
        try {
            ResponseEntity<ListReportingProjects> response = reportingApiClient.getProjects( with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /reporting/projects/{projectId} : Returns data of specified project
     *
     * @param projectId project ID (required)
     * @param with    with with Comma separated, optional keys that should be included in the response. (optional)
     *                *             <br/>"permissions,custom_fields"
     * @return ReportingProjectGET - Data of the requested project
     */
    public @NotNull @Valid ReportingProjectGET getReportingProjectById(int projectId, String with) {

        ResponseEntity<ItemReportingProjectGET> response = reportingApiClient.getProject(projectId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * DELETE /reporting/projects/{projectIds} : Deletes specified projects
     * @param projectIds comma separated project IDs (required)
     */
    public void deleteReportingProjectByIds(Integer... projectIds) {
        ResponseEntity<Void> response = reportingApiClient.deleteProjects(projectIds);
    }

    /**
     * POST /reporting/projects : Creates new project
     *
     * @param project ReportingProjectPOST – project
     * @return ReportingProjectGET - Data of the created project
     */
    public ReportingProjectGET createReportingProject(ReportingProjectPOST project) {
        ResponseEntity<ItemReportingProjectGET> response = reportingApiClient.createProject(project);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /reporting/projects/{projectId} : Updates specified project
     *
     * @param project ReportingProjectGET - project (required)
     * @return ReportingProjectGET - Data of the updated project
     * @throws IOException if mapping from ReportingProjectPUT to ReportingProjectPUT fails
     */
    public ReportingProjectGET updateReportingProject(ReportingProjectGET project) throws IOException {
        ReportingProjectPUT changedReportingProject = mapFromJson(mapToJson(project), ReportingProjectPUT.class);
        ResponseEntity<ItemReportingProjectGET> response = reportingApiClient.updateProject(project.getId(), changedReportingProject);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PATCH /reporting/projects/{projectId}/change-status/{status} : Updates status for specified project
     *
     * @param projectId      project ID (required)
     * @param status         ReportingProjectGET.StatusEnum status of project,
     *                       <br/> possible values: 'status to be set, on of:  [''O'' - open, ''C'' - closed, ''B''
     *                     - billed, ''P'' - pending]'
     * @return ReportingProjectGET - Data of the changed orderConfirmation
     */

    public ReportingProjectGET changeReportingProjectStatusById(
            int projectId, ReportingProjectGET.StatusEnum status) {

        ResponseEntity<ItemReportingProjectGET> response = reportingApiClient.changeProjectStatus(projectId, status.toString());
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    // ========= Working Hours ==============
    /**
     * GET /reporting/working-hours : Returns list of working-hours
     * @param with with with Comma separated, optional keys that should be included in the response. (optional)
     *             <br/>"user_name,permissions"
     * @param filter filter Filter expression (JSON) (optional)
     * @return {@code List<WorkingHoursGET>} - Data of the requested working-hours
     */
    public @Valid List<WorkingHoursGET> getWorkingHours(String with, String filter) {
        try {
            ResponseEntity<ListWorkingHours> response = reportingApiClient.getWorkingHours( with, null, filter, 100, 0, null);
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                return response.getBody().getItems();
            }
        } catch (RetryableException | SmallInvoiceNotFoundException ignored) {
        }
        return null;
    }

    /**
     * GET /reporting/working-hours/{workingHourId} : Returns data of specified workingHour
     *
     * @param workingHourId workingHour ID (required)
     * @param with    with with Comma separated, optional keys that should be included in the response. (optional)
     *                *             <br/>"user_name,permissions"
     * @return WorkingHourGET - Data of the requested workingHour
     */
    public @NotNull @Valid WorkingHoursGET getWorkingHourById(int workingHourId, String with) {

        ResponseEntity<ItemWorkingHoursGET> response = reportingApiClient.getWorkingHour(workingHourId, with);
        if (response.getBody() != null) return response.getBody().getItem();
        else return null;
    }

    /**
     * DELETE /reporting/working-hours/{workingHourIds} : Deletes specified working-hours
     * @param workingHourIds comma separated workingHour IDs (required)
     */
    public void deleteWorkingHourByIds(String... workingHourIds) {
        ResponseEntity<Void> response = reportingApiClient.deleteWorkingHours(workingHourIds);
    }

    /**
     * POST /reporting/working-hours : Creates new workingHour
     *
     * @param workingHour WorkingHourPOST – workingHour
     * @return WorkingHourGET - Data of the created workingHour
     */
    public WorkingHoursGET createWorkingHour(WorkingHoursPOST workingHour) {
        ResponseEntity<ItemWorkingHoursGET> response = reportingApiClient.createWorkingHour(workingHour);
        return Objects.requireNonNull(response.getBody()).getItem();
    }

    /**
     * PUT /reporting/working-hours/{workingHourId} : Updates specified workingHour
     *
     * @param workingHour WorkingHourGET - workingHour (required)
     * @return WorkingHoursGET - Data of the updated workingHour
     * @throws IOException if mapping from WorkingHoursPUT to WorkingHoursPUT fails
     */
    public WorkingHoursGET updateWorkingHour(WorkingHoursGET workingHour) throws IOException {
        WorkingHoursPUT changedWorkingHour = mapFromJson(mapToJson(workingHour), WorkingHoursPUT.class);
        ResponseEntity<ItemWorkingHoursGET> response = reportingApiClient.updateWorkingHour(workingHour.getId(), changedWorkingHour);
        return Objects.requireNonNull(response.getBody()).getItem();
    }


}
