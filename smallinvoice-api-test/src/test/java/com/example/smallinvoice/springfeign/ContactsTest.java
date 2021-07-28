package com.example.smallinvoice.springfeign;

import com.example.smallinvoice.AbstractTest;
import com.example.smallinvoicespringfeign.api.ContactsApiClient;
import com.example.smallinvoicespringfeign.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactsTest extends AbstractTest {

    @Autowired
    private ContactsApiClient contactsApiClient;

    @Override
    @BeforeEach
    public void setUp()  {

    }

    @Test
    public void getContactsList() {

        ResponseEntity<ListContacts> response = contactsApiClient.getContacts("main_address,groups,permissions,custom_fields", null, null, 100, 0, null);
        response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
        assertEquals(response.getBody().getItems().size(),response.getBody().getPagination().getTotal());
    }

    @Test
    public void getContactCoiffure()  {

        String contactName = "Coiffure Kathrin";
        ResponseEntity<ListContacts> response = contactsApiClient.getContacts("permissions", null, "{\"name\":\"" + contactName + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getItems() != null) {
            response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
            ContactGET contact = response.getBody().getItems().get(0);
            readAccounts(contact.getId());
        }
    }

    @Test
    public void createContact() throws Exception {

        String jsonContact = readResource(new ClassPathResource("contact/contact3.json"));
        ContactPOST newContact = mapFromJson(jsonContact, ContactPOST.class);

        if (!checkContactIfExists(newContact.getName())) {
            ResponseEntity<ItemContactGET> responseCreate = contactsApiClient.createContact(newContact);
            int contactId = responseCreate.getBody().getItem().getId();

            createReminder(contactId, "contact/reminder1.json");
            int addressId = createAddress(contactId, "contact/address2.json");
            int peopleId1 = createPeople(contactId, "contact/people1.json");
            int peopleId2 = createPeople(contactId, "contact/people2.json");
            createAccount(contactId, "contact/account1.json");
            createAccount(contactId, "contact/account2.json");
            readAccounts(contactId);

            deleteGroupsIfExists("EX-A", "EX-B", "EX-C");
            int groupId1 = createGroupAndAssign(contactId, "EX-A");
            int groupId2 = createGroupAndAssign(contactId, "EX-B");
            int groupId3 = createGroupAndAssign(contactId, "EX-C");

            int letterId = createLetter(contactId, addressId, peopleId1, "contact/letter1.json");
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Test
    public void createContactAndDelete() throws Exception {

        String jsonContact = readResource(new ClassPathResource("contact/contact4.json"));
        ContactPOST newContact = mapFromJson(jsonContact, ContactPOST.class);

        deleteContactIfExists(newContact.getName());

        ResponseEntity<ItemContactGET> responseCreate = contactsApiClient.createContact(newContact);
        ResponseEntity<ItemContactGET> responseGet = contactsApiClient.getContact(responseCreate.getBody().getItem().getId(), "main_address,groups,permissions,custom_fields");
        assertEquals(newContact, mapFromJson(mapToJson(responseGet.getBody().getItem()), ContactPOST.class));
        int contactId = responseCreate.getBody().getItem().getId();

        createReminder(contactId, "contact/reminder1.json");
        int addressId = createAddress(contactId, "contact/address1.json");
        int peopleId = createPeople(contactId, "contact/people1.json");
        createAccount(contactId, "contact/account1.json");
        createAccount(contactId, "contact/account2.json");
        readAccounts(contactId);

        deleteGroupsIfExists("Kino-A", "Kino-B", "Kino-C");
        int groupId1 = createGroupAndAssign(contactId, "Kino-A");
        int groupId2 = createGroupAndAssign(contactId, "Kino-B");
        int groupId3 = createGroupAndAssign(contactId, "Kino-C");

        int letterId = createLetter(contactId, addressId, peopleId, "contact/letter1.json");
        getLetterPdf(letterId);
        getLetterPreview(letterId);
        sendLetterByEMail(letterId, "contact/email1.json");
        sendLetterByPost(letterId, "contact/post1.json");
        changeLetterStatus(letterId, DocumentLetterChangeStatusPATCH.StatusEnum.S);

        ResponseEntity<Void> responseDelete = contactsApiClient.deleteContacts(contactId);
        ResponseEntity<Void> responseDeleteGroup1 = contactsApiClient.deleteContactGroups(groupId1,
                groupId2,
                groupId3);
        TimeUnit.SECONDS.sleep(1);
    }

    public void deleteContactIfExists(String contactName) {
        ResponseEntity<ListContacts> response = contactsApiClient.getContacts(null, null, "{\"name\":\"" + contactName + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = contactsApiClient.deleteContacts(response.getBody().getItems().get(0).getId());
            assertEquals(200, responseDelete.getStatusCode().value());
        }
    }

    private boolean checkContactIfExists(String contactName) {
        ResponseEntity<ListContacts> response = contactsApiClient.getContacts(null, null, "{\"name\":\"" + contactName + "\"}", 100, 0, null);
        if (response.getBody() != null) {
            return (response.getBody().getPagination().getTotal() > 0);
        }
        return false;
    }


    public void createReminder(int contactId, String jsonResource) throws IOException {
        String jsonReminder = readResource(new ClassPathResource(jsonResource));
        ContactReminderPOST contactReminderPOST = mapFromJson(jsonReminder, ContactReminderPOST.class);
        contactReminderPOST.setContactId(contactId);
        ResponseEntity<ItemContactReminderGET> responseReminder = contactsApiClient.createReminder(contactReminderPOST);
        if (responseReminder.getBody() != null) {
            assertEquals(contactReminderPOST, mapFromJson(mapToJson(responseReminder.getBody().getItem()), ContactReminderPOST.class));
        }

    }

    public int createAddress(int contactId, String jsonResource) throws IOException {
        String jsonAddress = readResource(new ClassPathResource(jsonResource));
        ContactAddressPOST contactaddressPOST = mapFromJson(jsonAddress, ContactAddressPOST.class);
        ResponseEntity<ItemContactAddressGET> responseAddress = contactsApiClient.createContactAddress(contactId, contactaddressPOST);
        if (responseAddress.getBody() != null) {
            assertEquals(contactaddressPOST, mapFromJson(mapToJson(responseAddress.getBody().getItem()), ContactAddressPOST.class));
            return responseAddress.getBody().getItem().getId();
        }
        return 0;
    }

    public int createPeople(int id, String jsonResource) throws IOException {
        String jsonPeople = readResource(new ClassPathResource(jsonResource));
        ContactPeoplePOST contactPeoplePOST = mapFromJson(jsonPeople, ContactPeoplePOST.class);
        ResponseEntity<ItemContactPeopleGET> responsePeople = contactsApiClient.createContactPeople(id, contactPeoplePOST);
        if (responsePeople.getBody() != null) {
            assertEquals(contactPeoplePOST, mapFromJson(mapToJson(responsePeople.getBody().getItem()), ContactPeoplePOST.class));
            return responsePeople.getBody().getItem().getId();
        }
        return 0;

    }

    public void createAccount(int contactId, String jsonResource) throws IOException {
        String jsonAccount = readResource(new ClassPathResource(jsonResource));
        ContactAccountPOST contactAccountPOST = mapFromJson(jsonAccount, ContactAccountPOST.class);
        ResponseEntity<ItemContactAccountGET> responseAccount = contactsApiClient.createContactAccount(contactId, contactAccountPOST);
        if (responseAccount.getBody() != null) {
            assertEquals(contactAccountPOST, mapFromJson(mapToJson(responseAccount.getBody().getItem()), ContactAccountPOST.class));
        }
    }

    public void readAccounts(int contactId) {
        ResponseEntity<ListContactAccounts> responseAccounts = contactsApiClient.getContactAccounts(contactId, "permissions", null, null, 100, 0, null);
        if (responseAccounts.getBody() != null) {
            responseAccounts.getBody().getItems().forEach(account -> getLogger().debug(account.toString()));
        }

    }

    public void deleteGroupsIfExists (String... groupNames) {

        StringBuilder filterJson = new StringBuilder("{\"or\":[");
        for (String groupName : groupNames) {
            filterJson.append("{\"name\":\"").append(groupName).append("\"},");
        }
        filterJson.deleteCharAt(filterJson.length()-1);
        filterJson.append("]}");
        ResponseEntity<ListContactConfigurationGroups> responseGroups = contactsApiClient.getContactGroups("permissions", null, filterJson.toString(), 100, 0, null);
        if (responseGroups.getBody() != null) {
            responseGroups.getBody().getItems().forEach( item -> contactsApiClient.deleteContactGroups(item.getId()) );
        }
    }

    public int createGroupAndAssign(int contactId, String groupName) throws IOException {
        ContactConfigurationGroupPOST contactGroupPOST = new ContactConfigurationGroupPOST();
        contactGroupPOST.setName(groupName);
        ResponseEntity<ItemContactConfigurationGroupGET> responseGroup = contactsApiClient.createContactGroup(contactGroupPOST);
        if (responseGroup.getBody() != null) {
            assertEquals(contactGroupPOST, mapFromJson(mapToJson(responseGroup.getBody().getItem()), ContactConfigurationGroupPOST.class));
            int groupId = responseGroup.getBody().getItem().getId();
            contactsApiClient.assignContactGroups(contactId, String.valueOf(groupId));
            return groupId;
        }
        return 0;
    }

    public int createLetter(int contactId, int addressId, int peopleId, String jsonResource) throws IOException {
        String jsonAccount = readResource(new ClassPathResource(jsonResource));
        DocumentLetterPOST documentLetterPOST = mapFromJson(jsonAccount, DocumentLetterPOST.class);
        documentLetterPOST.contactId(contactId).contactAddressId(addressId).contactPersonId(peopleId);
        ResponseEntity<ItemDocumentLetterGET> responseLetter = contactsApiClient.createLetter(documentLetterPOST);
        if (responseLetter.getBody() != null) {
            return responseLetter.getBody().getItem().getId();
        }
        return 0;
    }

    public void changeLetterStatus(int letterId, DocumentLetterChangeStatusPATCH.StatusEnum desiredStatus) {
        DocumentLetterChangeStatusPATCH patch = new DocumentLetterChangeStatusPATCH();
        patch.setStatus(desiredStatus);
        contactsApiClient.changeLetterStatus(letterId, patch);
        ResponseEntity<ItemDocumentLetterGET> response = contactsApiClient.getLetter(letterId, null);
        if (response.getBody() != null) {
            assertEquals(DocumentLetterGET.StatusEnum.S, response.getBody().getItem().getStatus());
        }
    }

    public void getLetterPdf(int letterId) {
        ResponseEntity<Resource> response = contactsApiClient.getLetterPdf(letterId);
        Resource resource  = response.getBody();
        writeResourceToFile(resource, "src/test/resources/receivedFiles/letterPdf.pdf");
    }

    public void getLetterPreview(int letterId) {
        // size on of "240, 595, 600, 972, 1240"
        ResponseEntity<Resource> response = contactsApiClient.getLetterPreview(letterId, 1, 600);
        Resource resource  = response.getBody();
        writeResourceToFile(resource, "src/test/resources/receivedFiles/letterPreview.png");
    }

    public void sendLetterByEMail (int letterId, String jsonResource) throws IOException {
        String jsonEmail = readResource(new ClassPathResource(jsonResource));
        DocumentLetterSendByEmailPATCH email = mapFromJson(jsonEmail, DocumentLetterSendByEmailPATCH.class);
        ResponseEntity<Void> response = contactsApiClient.sendLetterByEMail(letterId,email);
        assertEquals(204, response.getStatusCode().value());
    }

    public void sendLetterByPost (int letterId, String jsonResource) throws IOException {
        String jsonEmail = readResource(new ClassPathResource(jsonResource));
        DocumentSendByPostPATCH post = mapFromJson(jsonEmail, DocumentSendByPostPATCH.class);
        // not working at demo account
        // ResponseEntity<Void> response = contactsApiClient.sendLetterByPost(letterId,post);
        // assertEquals(204, response.getStatusCode().value());
    }


    public ContactReminderPOST createReminderData(int contactId) {
        ContactReminderPOST contactReminderPOST = new ContactReminderPOST();
        contactReminderPOST.setContactId(contactId);
        contactReminderPOST.setDateTime(LocalDateTime.now());
        contactReminderPOST.setTitle("Important");
        contactReminderPOST.setDescription("Reminder Test");
        contactReminderPOST.setIntervalType(ContactReminderPOST.IntervalTypeEnum.DAY);
        contactReminderPOST.setIntervalValue(10);
        return contactReminderPOST;
    }

    public ContactAddressPOST createAddressData(int id) {
        ContactAddressPOST contactAddressPOST = new ContactAddressPOST();
        contactAddressPOST.setCity("Aarau");
        contactAddressPOST.setCountry("CH");
        contactAddressPOST.setDefault(false);
        contactAddressPOST.setPostcode("5000");
        contactAddressPOST.setHideOnDocuments(false);
        contactAddressPOST.setStreet("Bahnhofstrasse");
        contactAddressPOST.setStreet2("hinten");
        contactAddressPOST.setStreetNo("1");
        return contactAddressPOST;
    }

    public ContactPeoplePOST createPeopleData(int id) {
        ContactPeoplePOST contactPeoplePOST = new ContactPeoplePOST();
        contactPeoplePOST.setDepartment("Sales");
        contactPeoplePOST.setEmail("test@example.com");
        contactPeoplePOST.setDefault(false);
        contactPeoplePOST.setGender(ContactPeoplePOST.GenderEnum.M);
        contactPeoplePOST.setName("Max");
        contactPeoplePOST.setSurname("Mustermann");
        contactPeoplePOST.setPhone("079 123 45 67");
        contactPeoplePOST.setSalutation("Sehr geehrter Herr Mustermann");
        contactPeoplePOST.setShowDepartment(true);
        contactPeoplePOST.setWantsNewsletter(true);
        contactPeoplePOST.setShowTitle(true);
        contactPeoplePOST.setCustomFields(new ArrayList<>());

        return contactPeoplePOST;
    }



}
