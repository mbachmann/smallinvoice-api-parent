package com.example.smallinvoice.springfeign;

import com.example.smallinvoice.AbstractTest;
import com.example.smallinvoicespringfeign.api.ContactsApiClient;
import com.example.smallinvoicespringfeign.api.ReceivablesApiClient;
import com.example.smallinvoicespringfeign.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceivablesTest extends AbstractTest {

    @Autowired
    private ReceivablesApiClient receivablesApiClient;

    @Autowired
    private ContactsApiClient contactsApiClient;

    @Override
    @BeforeEach
    public void setUp() {

    }

    /**
     * The test itself works. But the small invoice api delivers a wrong created date for some entries "-0001-11-30 00:00:00"
     * The deserializer can not work this way
     */
    @Test
    public void GetIsrs() {
        try {
            ResponseEntity<ListReceivablesConfigurationIsrs> response = receivablesApiClient.getIsrs("permissions", null, null, 100, 0, null);
            assertEquals(200, response.getStatusCode().value());
            if (response.getBody() != null) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                ResponseEntity<ReceivablesConfigurationIsrGET> responseIsr = receivablesApiClient.getIsr(response.getBody().getItems().get(0).getId(), "permissions");
                assertEquals(mapToJson(response.getBody().getItems().get(0)), mapToJson(responseIsr.getBody()));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDeliveryNotes() throws Exception {
        String with = "permissions,positions,texts,free_texts,contact_prepage_address,contact_address,contact,custom_fields";
        ResponseEntity<ListDeliveryNotes> response = receivablesApiClient.getDeliveryNotes(with, null, null, 100, 0, null);
        assertEquals(200, response.getStatusCode().value());
        if (response.getBody() != null) {
            response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
            String json = mapToJson(response.getBody().getItems());
            ResponseEntity<ItemDocumentDeliveryNoteGET> responseGet = receivablesApiClient.getDeliveryNote(response.getBody().getItems().get(0).getId(), with);
            if (responseGet.getBody() != null)
                assertEquals(mapToJson(response.getBody().getItems().get(0)), mapToJson(responseGet.getBody().getItem()));
        }
    }

    @Test
    public void getInvoices() throws Exception {
        // isr is producing errors due to wrong date format
        String with = "permissions,positions,texts,free_texts,bank_account,contact_person,contact_prepage_address,contact_address,contact,workflow,custom_fields";
        ResponseEntity<ListInvoicesStandard> response = receivablesApiClient.getInvoices(with, null, null, 100, 0, null);
        assertEquals(200, response.getStatusCode().value());
        if (response.getBody() != null) {
            response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
            String json = mapToJson(response.getBody().getItems());
            ResponseEntity<ItemDocumentInvoiceStandardGET> responseGet = receivablesApiClient.getInvoice(response.getBody().getItems().get(0).getId(), with);
            if (responseGet.getBody() != null)
                assertEquals(mapToJson(response.getBody().getItems().get(0)), mapToJson(responseGet.getBody().getItem()));
        }
    }

    @Test
    public void getOffers() throws Exception {
        String with = "permissions,positions,texts,free_texts,contact_person,contact_prepage_address,contact_address,contact,custom_fields";
        ResponseEntity<ListOffers> response = receivablesApiClient.getOffers(with, null, null, 100, 0, null);
        assertEquals(200, response.getStatusCode().value());
        if (response.getBody() != null) {
            response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
            String json = mapToJson(response.getBody().getItems());
            ResponseEntity<ItemDocumentOfferGET> responseGet = receivablesApiClient.getOffer(response.getBody().getItems().get(0).getId(), with);
            if (responseGet.getBody() != null)
                assertEquals(mapToJson(response.getBody().getItems().get(0)), mapToJson(responseGet.getBody().getItem()));
        }
    }

    @Test
    public void getOrderConfirmations() throws Exception {
        String with = "permissions,positions,texts,free_texts,contact_person,contact_prepage_address,contact_address,contact,custom_fields";
        ResponseEntity<ListOrderConfirmations> response = receivablesApiClient.getOrderConfirmations(with, null, null, 100, 0, null);
        assertEquals(200, response.getStatusCode().value());
        if (response.getBody() != null) {
            response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
            String json = mapToJson(response.getBody().getItems());
            ResponseEntity<ItemDocumentOrderConfirmationGET> responseGet = receivablesApiClient.getOderConfirmation(response.getBody().getItems().get(0).getId(), with);
            if (responseGet.getBody() != null)
                assertEquals(mapToJson(response.getBody().getItems().get(0)), mapToJson(responseGet.getBody().getItem()));
        }
    }

    @Test
    public void getPayments() throws Exception {

        ContactGET contact = getContact("Coiffure Kathrin");
        if (contact != null) {
            DocumentInvoiceStandardGET invoice = getFirstInvoice(contact.getId());
            ResponseEntity<ListDocumentInvoicePayments> response = receivablesApiClient.getInvoicePayments(invoice.getId(), null, null, null, 100, 0, null);
            assertEquals(200, response.getStatusCode().value());
            if (response.getBody() != null && response.getBody().getItems().size() > 0) {
                response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
                String json = mapToJson(response.getBody().getItems());
                int paymentId = response.getBody().getItems().get(0).getId();
                ResponseEntity<ItemDocumentInvoicePaymentGET> responseGet = receivablesApiClient.getInvoicePayment(invoice.getId(), paymentId, null);
                if (responseGet.getBody() != null)
                    assertEquals(mapToJson(response.getBody().getItems().get(0)), mapToJson(responseGet.getBody().getItem()));
            }
        }
    }

    public ContactGET getContact(String contactName) {
        String with = "main_address,groups,permissions,custom_fields";
        ResponseEntity<ListContacts> response = contactsApiClient.getContacts(with, null, "{\"name\":\"" + contactName + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getItems() != null) {
            return response.getBody().getItems().get(0);

        }
        return null;
    }

    public DocumentInvoiceStandardGET getFirstInvoice(int contactId) {
        String with = "contact_name,permissions,positions,texts,free_texts,bank_account,contact_person,contact_prepage_address,contact_address,contact,workflow,custom_fields";
        ResponseEntity<ListInvoicesStandard> response = receivablesApiClient.getInvoices(with, null, "{\"contact_id\":" + contactId + "}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getItems().size() > 0) {
            int invoiceId = response.getBody().getItems().get(0).getId();
            ResponseEntity<ItemDocumentInvoiceStandardGET> responseGet = receivablesApiClient.getInvoice(invoiceId, null);
            if (responseGet.getBody() != null && responseGet.getBody().getItem() != null) {
                return responseGet.getBody().getItem();
            }
        }
        return null;
    }
}
