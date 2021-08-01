package com.example.smallinvoice.springfeign;

import com.example.smallinvoice.AbstractTest;
import com.example.smallinvoicespringfeign.api.CatalogApiClient;
import com.example.smallinvoicespringfeign.api.ContactsApiClient;
import com.example.smallinvoicespringfeign.api.ReceivablesApiClient;
import com.example.smallinvoicespringfeign.model.*;
import com.example.smallinvoicespringfeign.service.SmallInvoiceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SharedTest extends AbstractTest {

    @Autowired
    private ContactsApiClient contactsApiClient;

    @Autowired
    private CatalogApiClient catalogApiClient;

    @Autowired
    private ReceivablesApiClient receivablesApiClient;

    @Autowired
    SmallInvoiceApiService apiService;


    public int createContactAddressFromResource(int contactId, String jsonResource) throws IOException {
        String jsonAddress = readResource(new ClassPathResource(jsonResource));
        ContactAddressPOST contactaddressPOST = mapFromJson(jsonAddress, ContactAddressPOST.class);
        ResponseEntity<ItemContactAddressGET> responseAddress = contactsApiClient.createContactAddress(contactId, contactaddressPOST);
        if (responseAddress.getBody() != null) {
            assertEquals(contactaddressPOST, mapFromJson(mapToJson(responseAddress.getBody().getItem()), ContactAddressPOST.class));
            return responseAddress.getBody().getItem().getId();
        }
        return 0;
    }

    public int createContactPeopleFromResource(int id, String jsonResource) throws IOException {
        String jsonPeople = readResource(new ClassPathResource(jsonResource));
        ContactPeoplePOST contactPeoplePOST = mapFromJson(jsonPeople, ContactPeoplePOST.class);
        ResponseEntity<ItemContactPeopleGET> responsePeople = contactsApiClient.createContactPeople(id, contactPeoplePOST);
        if (responsePeople.getBody() != null) {
            assertEquals(contactPeoplePOST, mapFromJson(mapToJson(responsePeople.getBody().getItem()), ContactPeoplePOST.class));
            return responsePeople.getBody().getItem().getId();
        }
        return 0;
    }


    public void createContactAccountFromResource(int contactId, String jsonResource) throws IOException {
        String jsonAccount = readResource(new ClassPathResource(jsonResource));
        ContactAccountPOST contactAccountPOST = mapFromJson(jsonAccount, ContactAccountPOST.class);
        ResponseEntity<ItemContactAccountGET> responseAccount = contactsApiClient.createContactAccount(contactId, contactAccountPOST);
        if (responseAccount.getBody() != null) {
            assertEquals(contactAccountPOST, mapFromJson(mapToJson(responseAccount.getBody().getItem()), ContactAccountPOST.class));
        }
    }

    public int createContactIfNotExistsFromResource(String contactResource, String addressResource, String peopleResource, String accountResource) throws IOException {
        String jsonContact = readResource(new ClassPathResource(contactResource));
        ContactPOST contact = mapFromJson(jsonContact, ContactPOST.class);

        ContactGET firstContact = apiService.getFirstContactByName(contact.getName(), null);
        if (firstContact == null) {

            ResponseEntity<ItemContactGET> contactResponse = contactsApiClient.createContact(contact);
            if (contactResponse.getBody() != null ) {
                int contactId = contactResponse.getBody().getItem().getId();
                createContactAddressFromResource(contactId, addressResource);
                createContactPeopleFromResource(contactId, peopleResource);
                createContactAccountFromResource(contactId, accountResource);
                return contactId;
            }
        } else return firstContact.getId();
        return 0;
    }


    public CatalogProductGET createProductIfNotExistsFromResource(String productResource) throws IOException {
        String jsonProduct = readResource(new ClassPathResource(productResource));
        CatalogProductPOST product = mapFromJson(jsonProduct, CatalogProductPOST.class);
        ResponseEntity<ListProducts> response = catalogApiClient.getCatalogProducts(null, null, "{\"name\":\"" + product.getName() + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() == 0) {
            ResponseEntity<ItemCatalogProductGET> productResponse = catalogApiClient.createCatalogProduct(product);
            if (productResponse.getBody() != null ) {
                int productId = productResponse.getBody().getItem().getId();
                ResponseEntity<ItemCatalogProductGET> responseGet = catalogApiClient.getCatalogProduct(productId,  null);
                if (responseGet.getBody() != null) return responseGet.getBody().getItem();
            }
        } else if (response.getBody() != null){
            return response.getBody().getItems().get(0);
        }
        return null;
    }


    public CatalogServiceGET createServiceIfNotExistsFromResource(String serviceResource) throws IOException {
        String jsonService = readResource(new ClassPathResource(serviceResource));
        CatalogServicePOST service = mapFromJson(jsonService, CatalogServicePOST.class);
        ResponseEntity<ListServices> response = catalogApiClient.getCatalogServices(null, null, "{\"name\":\"" + service.getName() + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() == 0) {
            ResponseEntity<ItemCatalogServiceGET> productResponse = catalogApiClient.createCatalogService(service);
            if (productResponse.getBody() != null ) {
                int serviceId = productResponse.getBody().getItem().getId();
                ResponseEntity<ItemCatalogServiceGET> responseGet = catalogApiClient.getCatalogService(serviceId,  null);
                if (responseGet.getBody() != null) return responseGet.getBody().getItem();
            }
        } else if (response.getBody() != null){
            return response.getBody().getItems().get(0);
        }
        return null;
    }



}
