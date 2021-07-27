package com.example.smallinvoice.springfeign;

import com.example.smallinvoice.AbstractTest;
import com.example.smallinvoice.utils.FieldMapper;
import com.example.smallinvoicespringfeign.api.ContactsApiClient;
import com.example.smallinvoicespringfeign.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ContactsTest extends AbstractTest {

    @Autowired
    private ContactsApiClient contactsApiClient;

    @Override
    @BeforeEach
    public void setUp()  {

    }

    @Test
    public void getContactsList() throws Exception {

        ResponseEntity<ListContacts> response = contactsApiClient.getContacts("main_address,groups,permissions,custom_fields", null, null, 100, 0, null);
        response.getBody().getItems().forEach(item -> System.out.println(item.toString()));
        ContactGET contact = response.getBody().getItems().get(0);

        String jsonContact = mapToJson(contact);
        ContactPOST newContact = mapFromJson(jsonContact, ContactPOST.class);

    }

    @Test
    public void createContact() throws Exception {

        String jsonContact = readResource(new ClassPathResource("contact/contact4.json"));
        ContactPOST newContact = mapFromJson(jsonContact, ContactPOST.class);

        deleteContactIfExists(newContact.getName());

        ResponseEntity<ItemContactGET> responseCreate = contactsApiClient.createContact(newContact);
        int contactId = responseCreate.getBody().getItem().getId();

        createReminder(contactId, "contact/reminder1.json");
        int addressId = createAddress(contactId, "contact/address1.json");
        int peopleId = createPeople(contactId, "contact/people1.json");
        createAccount(contactId, "contact/account1.json");
        createAccount(contactId, "contact/account2.json");

        deleteGroupsIfExists("Kino-A", "Kino-B", "Kino-C");
        int groupId1 = createGroupAndAssign(contactId, "Kino-A");
        int groupId2 = createGroupAndAssign(contactId, "Kino-B");
        int groupId3 = createGroupAndAssign(contactId, "Kino-C");

        int letterId = createLetter(contactId, addressId, peopleId, "contact/letter1.json");

        ResponseEntity<Void> responseDelete = contactsApiClient.deleteContacts(contactId);
        ResponseEntity<Void> responseDeleteGroup1 = contactsApiClient.deleteContactGroup(groupId1);
        ResponseEntity<Void> responseDeleteGroup2 = contactsApiClient.deleteContactGroup(groupId2);
        ResponseEntity<Void> responseDeleteGroup3 = contactsApiClient.deleteContactGroup(groupId3);

    }


    public String readResource(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void deleteContactIfExists(String contactName) {
        ResponseEntity<ListContacts> response = contactsApiClient.getContacts(null, null, "{\"name\":\"" + contactName + "\"}", 100, 0, null);
        if (response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = contactsApiClient.deleteContacts(response.getBody().getItems().get(0).getId());
        }
    }

    public void createReminder(int contactId, String jsonResource) throws IOException {
        String jsonReminder = readResource(new ClassPathResource(jsonResource));
        ContactReminderPOST contactReminderPOST = mapFromJson(jsonReminder, ContactReminderPOST.class);
        contactReminderPOST.setContactId(contactId);
        ResponseEntity<ItemContactReminderGET> responseReminder = contactsApiClient.createReminder(contactReminderPOST);
    }

    public int createAddress(int contactId, String jsonResource) throws IOException {
        String jsonAddress = readResource(new ClassPathResource(jsonResource));
        ContactAddressPOST contactaddressPOST = mapFromJson(jsonAddress, ContactAddressPOST.class);
        ResponseEntity<ItemContactAddressGET> responseAddress = contactsApiClient.createContactAddress(contactId, contactaddressPOST);
        return responseAddress.getBody().getItem().getId();
    }

    public int createPeople(int id, String jsonResource) throws IOException {
        String jsonPeople = readResource(new ClassPathResource(jsonResource));
        ContactPeoplePOST contactPeoplePOST = mapFromJson(jsonPeople, ContactPeoplePOST.class);
        ResponseEntity<ItemContactPeopleGET> responsePeople = contactsApiClient.createContactPeople(id, contactPeoplePOST);
        return responsePeople.getBody().getItem().getId();
    }

    public void createAccount(int contactId, String jsonResource) throws IOException {
        String jsonAccount = readResource(new ClassPathResource(jsonResource));
        ContactAccountPOST contactAccountPOST = mapFromJson(jsonAccount, ContactAccountPOST.class);
        ResponseEntity<ItemContactAccountGET> responsePeople = contactsApiClient.createContactAccount(contactId, contactAccountPOST);
    }

    public void deleteGroupsIfExists (String... groupNames) {

        StringBuilder filterJson = new StringBuilder("{\"or\":[");
        for (String groupName : groupNames) {
            filterJson.append("{\"name\":\"").append(groupName).append("\"},");
        }
        filterJson.deleteCharAt(filterJson.length()-1);
        filterJson.append("]}");
        ResponseEntity<ListContactConfigurationGroups> responseGroups = contactsApiClient.getContactGroups(null, null, filterJson.toString(), 100, 0, null);
        responseGroups.getBody().getItems().forEach( item -> contactsApiClient.deleteContactGroup(item.getId()) );

    }

    public int createGroupAndAssign(int contactId, String groupName) throws IOException {

        ContactConfigurationGroupPOST contactGroupPOST = new ContactConfigurationGroupPOST();
        contactGroupPOST.setName(groupName);
        ResponseEntity<ItemContactConfigurationGroupGET> responseGroup = contactsApiClient.createContactGroup(contactGroupPOST);
        int groupId = responseGroup.getBody().getItem().getId();
        contactsApiClient.assignContactGroups(contactId, String.valueOf(groupId));
        return groupId;

    }

    public int createLetter(int contactId, int addressId, int peopleId, String jsonResource) throws IOException {
        String jsonAccount = readResource(new ClassPathResource(jsonResource));
        DocumentLetterPOST documentLetterPOST = mapFromJson(jsonAccount, DocumentLetterPOST.class);
        documentLetterPOST.contactId(contactId).contactAddressId(addressId).contactPersonId(peopleId);
        String test = mapToJson(documentLetterPOST);
        ResponseEntity<ItemDocumentLetterGET> responseLetter = contactsApiClient.createLetter(documentLetterPOST);
        return responseLetter.getBody().getItem().getId();
    }

    public ContactReminderPOST createReminderData(int contactId) {
        ContactReminderPOST contactReminderPOST = new ContactReminderPOST();
        contactReminderPOST.setContactId(contactId);
        contactReminderPOST.setDateTime(LocalDateTime.now());
        contactReminderPOST.setTitle("Important");
        contactReminderPOST.setDescription("Reminder Test");
        contactReminderPOST.setIntervalType("day");
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
        contactPeoplePOST.setGender("M");
        contactPeoplePOST.setName("Max");
        contactPeoplePOST.setSurname("Mustermann");
        contactPeoplePOST.setPhone("079 123 45 67");
        contactPeoplePOST.setSalutation("Sehr geehrter Herr Mustermann");
        contactPeoplePOST.setShowDepartment(true);
        contactPeoplePOST.setWantsNewsletter(true);
        contactPeoplePOST.setShowTitle(true);
        contactPeoplePOST.setCustomFields(new ArrayList<DescriptiveCustomFieldPOST>());

        return contactPeoplePOST;
    }



}
