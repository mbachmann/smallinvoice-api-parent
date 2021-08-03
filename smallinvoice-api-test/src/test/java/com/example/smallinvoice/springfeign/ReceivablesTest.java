package com.example.smallinvoice.springfeign;

import com.example.smallinvoicespringfeign.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import feign.codec.DecodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceivablesTest extends SharedTest {

    private int contactId = 0;
    CatalogProductGET product1 = null;
    CatalogServiceGET service1 = null;
    ContactGET contact = null;
    ContactPeopleGET people = null;

    @Override
    @BeforeEach
    public void setUp() {
        try {
            apiService.deleteContactsIfExistsByName("Autogarage Frei");
            contactId = createContactIfNotExistsFromResource("contact/contact2.json", "contact/address1.json", "contact/people1.json", "contact/account1.json");
            contact = apiService.getContactById(contactId, "main_address,groups,permissions,custom_fields");
            contactId = contact.getId();
            product1 = createProductIfNotExistsFromResource("catalog/product1.json");
            service1 = createServiceIfNotExistsFromResource("catalog/service1.json");
            people = apiService.getContactPeoples(contactId, 4).get(0);
        } catch(IOException | InterruptedException e) {
        e.printStackTrace();
    }
}

    /**
     * The test itself works. But the small invoice api delivers a wrong created date for some date entries "-0001-11-30 00:00:00"
     * The deserializer can not work this way
     */
    @Test
    public void GetIsrs() {
        try {
            List<ReceivablesConfigurationIsrGET> isrs = apiService.getIsrs(null, null);
            ReceivablesConfigurationIsrGET isr = apiService.getIsrById(isrs.get(0).getId(), null);
            assertEquals(mapToJson(isrs.get(0)), mapToJson(isr));
        } catch (JsonProcessingException | DecodeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDeliveryNotesTest() throws Exception {
        String with = "permissions,positions,texts,free_texts,contact_prepage_address,contact_address,contact,custom_fields";
        List<DocumentDeliveryNoteGET> deliveryNotes = apiService.getDeliveryNotes(with, null);
        String json = mapToJson(deliveryNotes);
        DocumentDeliveryNoteGET deliveryNote = apiService.getDeliveryNoteById(deliveryNotes.get(0).getId(), with);
        assertEquals(mapToJson(deliveryNotes.get(0)), mapToJson(deliveryNote));
    }

    /**
     * Delivery note with 2 positions from Catalog and 2 positions not from catalog (just free name and description)
     *
     * @throws IOException In case of reading resources
     */
    @Test
    public void createDeliveryNote() throws IOException {

        DocumentDeliveryNotePositionPOST position1 = apiService.createDeliveryNoteProductPosition(product1, 1.0F);
        DocumentDeliveryNotePositionPOST position2 = apiService.createDeliveryNoteServicePosition(service1, 1.0F);

        String jsonDeliveryNote = readResource(new ClassPathResource("receivables/deliverynote1.json"));
        DocumentDeliveryNotePOST deliveryNote = mapFromJson(jsonDeliveryNote, DocumentDeliveryNotePOST.class);

        deliveryNote
                .contactId(contactId)
                .contactAddressId(contact.getMainAddressId())
                .contactPersonId(people.getId())
                .date(LocalDate.now())
                .addPositionsItem(position1)
                .addPositionsItem(position2);

        DocumentDeliveryNoteGET createdDeliveryNote = apiService.createDeliveryNote(deliveryNote);

        createdDeliveryNote.periodText("This is a new period test");
        DocumentDeliveryNoteGET updatedDeliveryNote = apiService.updateDeliveryNote(createdDeliveryNote);

        writeDeliveryNotePdfToResource(updatedDeliveryNote.getId());
        writeDeliveryNotePreviewToResource(updatedDeliveryNote.getId());
        sendDeliveryNoteByEMail(updatedDeliveryNote.getId(), "contact/email1.json");
        // not possible with demo account
        // sendDeliveryNoteByPost(updatedDeliveryNote.getId(), "contact/post1.json");

        DocumentDeliveryNoteGET changedDeliveryNote = apiService.changeDeliveryNoteStatusById(updatedDeliveryNote.getId(),  DocumentDeliveryNoteChangeStatusPATCH.StatusEnum.S);
        assertEquals(apiService.getDeliveryNoteById(changedDeliveryNote.getId(), null), changedDeliveryNote);
    }

    @Test
    public void getInvoicesTest() throws Exception {
        // with... no isr ... because of wrong date from api
        String with = "permissions,positions,texts,free_texts,bank_account,contact_person,contact_prepage_address,contact_address,contact,workflow,custom_fields";
        List<DocumentInvoiceStandardGET> invoices = apiService.getStandardInvoices(with, null);
        String json = mapToJson(invoices);
        DocumentInvoiceStandardGET invoice = apiService.getStandardInvoiceById(invoices.get(0).getId(), with);
        assertEquals(mapToJson(invoices.get(0)), mapToJson(invoice));
    }

    /**
     * Delivery note with 2 positions from Catalog and 2 positions not from catalog (just free name and description)
     *
     * @throws IOException In case of reading resources
     */
    @Test
    public void createInvoice() throws IOException {
        List<ReceivablesConfigurationIsrGET> isrs = apiService.getIsrs(null, null);
        ReceivablesConfigurationIsrGET isr = isrs.size() > 0 ? isrs.get(0) : null;

        DocumentInvoicePositionPOST position1 = apiService.createInvoiceProductPosition(product1, 1.0F);
        DocumentInvoicePositionPOST position2 = apiService.createInvoiceServicePosition(service1, 1.0F);

        String jsonDeliveryNote = readResource(new ClassPathResource("receivables/invoice1.json"));
        DocumentInvoiceStandardPOST invoice = mapFromJson(jsonDeliveryNote, DocumentInvoiceStandardPOST.class);

        invoice
                .contactId(contactId)
                .contactAddressId(contact.getMainAddressId())
                .contactPersonId(people.getId())
                .date(LocalDate.now())
                .due(LocalDate.now().plusDays(30))
                .isrId(isr != null ? isr.getId() : null)
                .addPositionsItem(position1)
                .addPositionsItem(position2);

        DocumentInvoiceStandardGET createdInvoice = apiService.createInvoiceStandard(invoice);

        createdInvoice.periodText("This is a new period test");
        DocumentInvoiceStandardGET updatedInvoice = apiService.updateInvoiceStandard(createdInvoice);

        writeInvoiceStandardPdfToResource(updatedInvoice.getId());
        writeInvoiceStandardPreviewToResource(updatedInvoice.getId());
        sendInvoiceStandardByEMail(updatedInvoice.getId(), "contact/email1.json");
        // not possible with demo account
        // sendInvoiceStandardByPost(updatedInvoice.getId(), "contact/post1.json");

        DocumentInvoiceStandardGET changedInvoice = apiService.changeInvoiceStandardStatusById(updatedInvoice.getId(),  DocumentInvoiceStandardChangeStatusPATCH.StatusEnum.S);
        assertEquals(apiService.getStandardInvoiceById(changedInvoice.getId(), null), changedInvoice);
    }


    @Test
    public void getOffersTest() throws Exception {
        String with = "permissions,positions,texts,free_texts,contact_person,contact_prepage_address,contact_address,contact,custom_fields";
        List<DocumentOfferGET> offers = apiService.getOffers(with, null);
        String json = mapToJson(offers);
        DocumentOfferGET invoice = apiService.getOfferById(offers.get(0).getId(), with);
        assertEquals(mapToJson(offers.get(0)), mapToJson(invoice));
    }

    @Test
    public void getOrderConfirmationsTest() throws Exception {
        String with = "permissions,positions,texts,free_texts,contact_person,contact_prepage_address,contact_address,contact,custom_fields";
        List<DocumentOrderConfirmationGET> orderConfirmations = apiService.getOrderConfirmations(with, null);
        String json = mapToJson(orderConfirmations);
        DocumentOrderConfirmationGET invoice = apiService.getOrderConfirmationById(orderConfirmations.get(0).getId(), with);
        assertEquals(mapToJson(orderConfirmations.get(0)), mapToJson(invoice));
    }

    @Test
    public void getPaymentsTest() throws Exception {

        ContactGET contact = apiService.getFirstContactByName("Coiffure Kathrin", "main_address,groups,permissions,custom_fields");
        if (contact != null) {
            DocumentInvoiceStandardGET invoice = getFirstInvoice(contact.getId());
            List<DocumentInvoicePaymentGET> payments = apiService.getInvoicePayments(invoice.getId(), null, null);

            if (payments != null && payments.size() > 0) {
                payments.forEach(item -> getLogger().debug(item.toString()));
                String json = mapToJson(payments);
                int paymentId = payments.get(0).getId();
                DocumentInvoicePaymentGET payment = apiService.getInvoicePaymentById(invoice.getId(), paymentId, null);
                if (payment != null)
                    assertEquals(mapToJson(payments.get(0)), mapToJson(payment));
            }
        }
    }

    // ======== Helpers Delivery Notes ===========

    public void writeDeliveryNotePdfToResource(int letterId) {
        Resource resource  = apiService.getDeliveryNotePdfResource(letterId);
        writeResourceToFile(resource, "src/test/resources/receivedFiles/deliveryNotePdf.pdf");
    }

    public void writeDeliveryNotePreviewToResource(int letterId) {
        // size on of "240, 595, 600, 972, 1240"
        Resource resource  = apiService.getDeliveryNotePreviewResource(letterId, 1, 600);
        writeResourceToFile(resource, "src/test/resources/receivedFiles/deliveryNotePreview.png");
    }

    public void sendDeliveryNoteByEMail (int deliveryNoteId, String jsonResource) throws IOException {
        String jsonEmail = readResource(new ClassPathResource(jsonResource));
        DocumentDeliveryNoteSendByEmailPATCH email = mapFromJson(jsonEmail, DocumentDeliveryNoteSendByEmailPATCH.class);
        apiService.sendDeliveryNoteByEMail(deliveryNoteId,email);
    }

    public void sendDeliveryNoteByPost (int deliveryNoteId, String jsonResource) throws IOException {
        String jsonEmail = readResource(new ClassPathResource(jsonResource));
        DocumentSendByPostPATCH post = mapFromJson(jsonEmail, DocumentSendByPostPATCH.class);
        apiService.sendDeliveryNoteByPost(deliveryNoteId, post);
    }

    public DocumentInvoiceStandardGET getFirstInvoice(int contactId) throws Exception {
        String with = "contact_name,permissions,positions,texts,free_texts,bank_account,contact_person,contact_prepage_address,contact_address,contact,workflow,custom_fields";
        String filter = "{\"contact_id\":" + contactId + "}";
        List<DocumentInvoiceStandardGET> invoices = apiService.getStandardInvoices(with, filter);
        if (invoices != null && invoices.size() > 0) {
            int invoiceId = invoices.get(0).getId();
            return apiService.getStandardInvoiceById(invoiceId, with);
        }
        return null;
    }

    // ======== Helpers Invoice ===========

    public void writeInvoiceStandardPdfToResource(int invoiceId) {
        Resource resource  = apiService.getInvoiceStandardPdfResource(invoiceId, null);
        writeResourceToFile(resource, "src/test/resources/receivedFiles/invoicePdf.pdf");
    }

    public void writeInvoiceStandardPreviewToResource(int invoiceId) {
        // size on of "240, 595, 600, 972, 1240"
        Resource resource  = apiService.getInvoiceStandardPreviewResource(invoiceId, 1, 600);
        writeResourceToFile(resource, "src/test/resources/receivedFiles/invoicePreview.png");
    }

    public void sendInvoiceStandardByEMail (int invoiceId, String jsonResource) throws IOException {
        String jsonEmail = readResource(new ClassPathResource(jsonResource));
        DocumentInvoiceSendByEmailPATCH email = mapFromJson(jsonEmail, DocumentInvoiceSendByEmailPATCH.class);
        apiService.sendInvoiceStandardByEMail(invoiceId,email);
    }

    public void sendInvoiceStandardByPost (int invoiceId, String jsonResource) throws IOException {
        String jsonEmail = readResource(new ClassPathResource(jsonResource));
        DocumentSendByPostPATCH post = mapFromJson(jsonEmail, DocumentSendByPostPATCH.class);
        apiService.sendInvoiceStandardByPost(invoiceId, post);
    }

    // ======== Helpers Offers ===========

    public void writeOfferPdfToResource(int offerId) {
        Resource resource  = apiService.getOfferPdfResource(offerId);
        writeResourceToFile(resource, "src/test/resources/receivedFiles/offerPdf.pdf");
    }

    public void writeOfferPreviewToResource(int offerId) {
        // size on of "240, 595, 600, 972, 1240"
        Resource resource  = apiService.getOfferPreviewResource(offerId, 1, 600);
        writeResourceToFile(resource, "src/test/resources/receivedFiles/offerPreview.png");
    }

    public void sendOfferByEMail (int offerId, String jsonResource) throws IOException {
        String jsonEmail = readResource(new ClassPathResource(jsonResource));
        DocumentOfferSendByEmailPATCH email = mapFromJson(jsonEmail, DocumentOfferSendByEmailPATCH.class);
        apiService.sendOfferByEMail(offerId,email);
    }

    public void sendOfferPost (int invoiceId, String jsonResource) throws IOException {
        String jsonEmail = readResource(new ClassPathResource(jsonResource));
        DocumentSendByPostPATCH post = mapFromJson(jsonEmail, DocumentSendByPostPATCH.class);
        apiService.sendOfferByPost(invoiceId, post);
    }

    // ======== Helpers Order Confirmations ===========

    public void writeOrderConfirmationPdfToResource(int offerId) {
        Resource resource  = apiService.getOrderConfirmationPdfResource(offerId);
        writeResourceToFile(resource, "src/test/resources/receivedFiles/offerPdf.pdf");
    }

    public void writeOrderConfirmationPreviewToResource(int offerId) {
        // size on of "240, 595, 600, 972, 1240"
        Resource resource  = apiService.getOrderConfirmationPreviewResource(offerId, 1, 600);
        writeResourceToFile(resource, "src/test/resources/receivedFiles/offerPreview.png");
    }

    public void sendOrderConfirmationByEMail (int offerId, String jsonResource) throws IOException {
        String jsonEmail = readResource(new ClassPathResource(jsonResource));
        DocumentOrderConfirmationSendByEmailPATCH email = mapFromJson(jsonEmail, DocumentOrderConfirmationSendByEmailPATCH.class);
        apiService.sendOrderConfirmationByEMail(offerId,email);
    }

    public void sendOrderConfirmationPost (int invoiceId, String jsonResource) throws IOException {
        String jsonEmail = readResource(new ClassPathResource(jsonResource));
        DocumentSendByPostPATCH post = mapFromJson(jsonEmail, DocumentSendByPostPATCH.class);
        apiService.sendOrderConfirmationByPost(invoiceId, post);
    }

}
