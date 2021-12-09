package com.example.smallinvoice.springfeign;

import com.example.smallinvoicespringfeign.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactsTest extends SharedTest {

    @Override
    @BeforeEach
    public void setUp()  {

    }

    @Test
    public void getContactsList() {

        List<ContactGET> contacts = apiService.getContacts("main_address,groups,permissions,custom_fields", null);
        contacts.forEach(item -> getLogger().debug(item.toString()));
    }

    @Test
    public void getContactCoiffure() {

        ContactGET contact = apiService.getFirstContactByName("Coiffure Kathrin", "permissions");
        if (contact != null) {
            apiService.getContactAccounts(contact.getId());
        }
    }

    @Test
    public void createContact() throws Exception {

        String jsonContact = readResource(new ClassPathResource("contact/contact3.json"));
        ContactPOST newContact = mapFromJson(jsonContact, ContactPOST.class);

        if (!apiService.checkIfContactExistsByName(newContact.getName())) {
            ContactGET contactCreated = apiService.createContact(newContact);
            int contactId =  contactCreated.getId();

            createReminderFromResource(contactId, "contact/reminder1.json");
            int addressId = createContactAddressFromResource(contactId, "contact/address2.json");
            int peopleId1 = createContactPeopleFromResource(contactId, "contact/people1.json");
            int peopleId2 = createContactPeopleFromResource(contactId, "contact/people2.json");
            createContactAccountFromResource(contactId, "contact/account1.json");
            createContactAccountFromResource(contactId, "contact/account2.json");
            apiService.getContactAccounts(contactId);

            apiService.deleteContactGroupsIfExists("EX-A", "EX-B", "EX-C");
            int groupId1 = createGroupAndAssign(contactId, "EX-A");
            int groupId2 = createGroupAndAssign(contactId, "EX-B");
            int groupId3 = createGroupAndAssign(contactId, "EX-C");

            int letterId = createLetterFromResource(contactId, addressId, peopleId1, "contact/letter1.json");
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Test
    public void createContactAndDelete() throws Exception {

        String jsonContact = readResource(new ClassPathResource("contact/contact4.json"));
        ContactPOST newContact = mapFromJson(jsonContact, ContactPOST.class);

        apiService.deleteContactsIfExistsByName(newContact.getName());

        ContactGET contactCreated = apiService.createContact(newContact);
        int contactId =  contactCreated.getId();
        ContactGET contact = apiService.getContactById(contactId, "main_address,groups,permissions,custom_fields");

        assertEquals(newContact, mapFromJson(mapToJson(contact), ContactPOST.class));

        createReminderFromResource(contactId, "contact/reminder1.json");
        int addressId = createContactAddressFromResource(contactId, "contact/address1.json");
        int peopleId = createContactPeopleFromResource(contactId, "contact/people1.json");
        createContactAccountFromResource(contactId, "contact/account1.json");
        createContactAccountFromResource(contactId, "contact/account2.json");
        apiService.getContactAccounts(contactId);

        apiService.deleteContactGroupsIfExists("Kino-A", "Kino-B", "Kino-C");
        int groupId1 = createGroupAndAssign(contactId, "Kino-A");
        int groupId2 = createGroupAndAssign(contactId, "Kino-B");
        int groupId3 = createGroupAndAssign(contactId, "Kino-C");

        int letterId = createLetterFromResource(contactId, addressId, peopleId, "contact/letter1.json");
        writeLetterPdfToResource(letterId);
        writeLetterPreviewToResource(letterId);
        sendLetterByEMail(letterId, "contact/email1.json");
        sendLetterByPost(letterId, "contact/post1.json");
        changeLetterStatus(letterId, DocumentLetterChangeStatusPATCH.StatusEnum.S);

        apiService.deleteContactById(contactId);
        apiService.deleteContactGroupByIds(groupId1, groupId2, groupId3);
        TimeUnit.SECONDS.sleep(1);
    }


    public void createReminderFromResource(int contactId, String jsonResource) throws IOException {
        String jsonReminder = readResource(new ClassPathResource(jsonResource));
        ContactReminderPOST contactReminderPOST = mapFromJson(jsonReminder, ContactReminderPOST.class);
        contactReminderPOST.setContactId(contactId);
        ContactReminderGET reminder = apiService.createReminder(contactReminderPOST);
        if (reminder != null) {
            assertEquals(contactReminderPOST, mapFromJson(mapToJson(reminder), ContactReminderPOST.class));
        }
    }


    public int createGroupAndAssign(int contactId, String groupName) throws IOException {
        ContactConfigurationGroupPOST contactGroupPOST = new ContactConfigurationGroupPOST();
        contactGroupPOST.setName(groupName);

        ContactConfigurationGroupGET contactGroup = apiService.createContactGroup(contactGroupPOST);
        if (contactGroup != null) {
            assertEquals(contactGroupPOST, mapFromJson(mapToJson(contactGroup), ContactConfigurationGroupPOST.class));
            int groupId = contactGroup.getId();
            apiService.assignContactGroup(contactId,groupId);
            return groupId;
        }
        return 0;
    }

    public int createLetterFromResource(int contactId, int addressId, int peopleId, String jsonResource) throws IOException {
        String jsonAccount = readResource(new ClassPathResource(jsonResource));
        DocumentLetterPOST documentLetterPOST = mapFromJson(jsonAccount, DocumentLetterPOST.class);
        documentLetterPOST.contactId(contactId).contactAddressId(addressId).contactPersonId(peopleId);

        DocumentLetterGET letter = apiService.createLetter(documentLetterPOST);
        if (letter != null) return letter.getId();
        else return 0;
    }

    public void changeLetterStatus(int letterId, DocumentLetterChangeStatusPATCH.StatusEnum desiredStatus) {
        DocumentLetterGET letter = apiService.changeLetterStatusById(letterId, desiredStatus);
        DocumentLetterGET letterGet = apiService.getLetterById(letter.getId(), null);
        if (letterGet!= null) assertEquals(DocumentLetterGET.StatusEnum.S, letterGet.getStatus());
    }

    public void writeLetterPdfToResource(int letterId) {
        Resource resource  = apiService.getLetterPdfResource(letterId);
        writeResourceToFile(resource, "src/test/resources/receivedFiles/letterPdf.pdf");
    }

    public void writeLetterPreviewToResource(int letterId) {
        // size on of "240, 595, 600, 972, 1240"
        Resource resource  = apiService.getLetterPreviewResource(letterId, 1, 600);
        writeResourceToFile(resource, "src/test/resources/receivedFiles/letterPreview.png");
    }

    public void sendLetterByEMail (int letterId, String jsonResource) throws IOException {
        String jsonEmail = readResource(new ClassPathResource(jsonResource));
        DocumentLetterSendByEmailPATCH email = mapFromJson(jsonEmail, DocumentLetterSendByEmailPATCH.class);
        apiService.sendLetterByEMail(letterId, email);
    }

    public void sendLetterByPost (int letterId, String jsonResource) throws IOException {
        String jsonEmail = readResource(new ClassPathResource(jsonResource));
        DocumentSendByPostPATCH post = mapFromJson(jsonEmail, DocumentSendByPostPATCH.class);
        // not working at demo account
        //  apiService.sendLetterByPost(letterId, post);
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

    @Test
    public void createAndChangeContact() throws Exception {
        String jsonContact = readResource(new ClassPathResource("contact/contact5.json"));
        ContactPOST newContact = mapFromJson(jsonContact, ContactPOST.class);

        ContactGET contact;
        if (!apiService.checkIfContactExistsByName(newContact.getName()))
            contact = apiService.createContact(newContact);
        else
            contact = apiService.getFirstContactByName(newContact.getName(), "main_address");

        assertEquals(newContact.getName(), contact.getName());

        String updatedName = contact.getName().concat("-Test");
        contact.setName(updatedName);
        ContactGET updatedContact = apiService.updateContact(contact);
        assertEquals(updatedContact.getName(), updatedName);

        apiService.deleteContactById(contact.getId());
    }

    @Test

    public void createContactAndChangeAddress() throws Exception {
        String jsonContact = readResource(new ClassPathResource("contact/contact6.json"));
        ContactPOST newContact = mapFromJson(jsonContact, ContactPOST.class);

        ContactGET contact;
        if (!apiService.checkIfContactExistsByName(newContact.getName()))
            contact = apiService.createContact(newContact);
        else
            contact = apiService.getFirstContactByName(newContact.getName(), "main_address");
        assertEquals(newContact.getName(), contact.getName());

        ContactAddressGET contactAddress = apiService.getContactAddressById(contact.getId(), contact.getMainAddressId());
        String updatedStreet = contactAddress.getStreet().concat("-Test");
        String updatedCity = contactAddress.getCity().concat("-Test");
        contactAddress.setStreet(updatedStreet);
        contactAddress.setCity(updatedCity);
        ContactAddressGET updatedAddress = apiService.updateContactAddress(contact.getId(), contactAddress);
        assertEquals(updatedAddress.getStreet(), updatedStreet);
        assertEquals(updatedAddress.getCity(), updatedCity);

        apiService.deleteContactById(contact.getId());
    }



}
