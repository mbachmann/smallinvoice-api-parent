package com.example.smallinvoice.springfeign;

import com.example.smallinvoice.AbstractTest;
import com.example.smallinvoicespringfeign.api.CatalogApiClient;
import com.example.smallinvoicespringfeign.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogTest extends AbstractTest {

    @Autowired
    private CatalogApiClient catalogApiClient;

    @Override
    @BeforeEach
    public void setUp() {

    }

    @Test
    public void getCatalogList() throws Exception {
        ResponseEntity<ListProducts> listProductResponse = catalogApiClient.getCatalogProducts("permissions", null, null, 100, 0, null);
        listProductResponse.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
        assertEquals(listProductResponse.getBody().getItems().size(),listProductResponse.getBody().getPagination().getTotal());

        ResponseEntity<ListServices> listServiceResponse = catalogApiClient.getCatalogServices("permissions", null, null, 100, 0, null);
        listServiceResponse.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
        assertEquals(listServiceResponse.getBody().getItems().size(),listServiceResponse.getBody().getPagination().getTotal());
    }

    @Test
    public void createAndChangeProduct() throws Exception {

        String jsonProduct = readResource(new ClassPathResource("catalog/product1.json"));
        CatalogProductPOST product = mapFromJson(jsonProduct, CatalogProductPOST.class);
        deleteProductIfExists(product.getName());

        ResponseEntity<ItemCatalogProductGET> productResponse =  catalogApiClient.createCatalogProduct(product);
        int productId = productResponse.getBody().getItem().getId();
        assertEquals(product, mapFromJson(mapToJson(productResponse.getBody().getItem()), CatalogProductPOST.class));

        int productCategoryId = createProductCategoryIfNotExists("Product-Category-A");

        // Change the new created product and save it again with update
        CatalogProductPUT newProduct = mapFromJson(mapToJson(productResponse.getBody().getItem()), CatalogProductPUT.class);
        newProduct.setNotes("Some additional Notes");
        newProduct.setCategoryId(productCategoryId);
        ResponseEntity<ItemCatalogProductGET> productResponseChange =  catalogApiClient.updateCatalogProduct(productId,newProduct);
        assertEquals(newProduct, mapFromJson(mapToJson(productResponseChange.getBody().getItem()), CatalogProductPUT.class));
        TimeUnit.SECONDS.sleep(1);
   }

    @Test
    public void createAndChangeService() throws Exception {

        String jsonContact = readResource(new ClassPathResource("catalog/service1.json"));
        CatalogServicePOST service = mapFromJson(jsonContact, CatalogServicePOST.class);
        deleteServiceIfExists(service.getName());
        ResponseEntity<ItemCatalogServiceGET> serviceResponse =  catalogApiClient.createCatalogService(service);

        int serviceId = serviceResponse.getBody().getItem().getId();
        assertEquals(service, mapFromJson(mapToJson(serviceResponse.getBody().getItem()), CatalogServicePOST.class));

        int serviceCategoryId = createServiceCategoryIfNotExists("Service-Category-A");

        // Change the new created product and save it again with update
        CatalogServicePUT newService = mapFromJson(mapToJson(serviceResponse.getBody().getItem()), CatalogServicePUT.class);
        newService.setNotes("Some additional Notes");
        newService.setCategoryId(serviceCategoryId);
        ResponseEntity<ItemCatalogServiceGET> serviceResponseChange =  catalogApiClient.updateCatalogService(serviceId, newService);
        assertEquals(newService, mapFromJson(mapToJson(serviceResponseChange.getBody().getItem()), CatalogServicePUT.class));
        TimeUnit.SECONDS.sleep(1);
    }

    public void deleteProductIfExists(String productName) {
        ResponseEntity<ListProducts> response = catalogApiClient.getCatalogProducts(null, null, "{\"name\":\"" + productName + "\"}", 100, 0, null);
        if (response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = catalogApiClient.deleteCatalogProducts(response.getBody().getItems().get(0).getId());
        }
    }

    public void deleteServiceIfExists(String serviceName) {
        ResponseEntity<ListServices> response = catalogApiClient.getCatalogServices(null, null, "{\"name\":\"" + serviceName + "\"}", 100, 0, null);
        if (response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = catalogApiClient.deleteCatalogServices(response.getBody().getItems().get(0).getId());
        }
    }

    public int createProductCategoryIfNotExists (String categoryName) {
        ResponseEntity<ListProductsCategories> response = catalogApiClient.getCatalogProductCategories(null, null, "{\"name\":\"" + categoryName + "\"}", 100, 0, null);
        int categoryId = 0;
        if (response.getBody().getPagination().getTotal() == 0) {
            CatalogCategoryPOST category = new CatalogCategoryPOST();
            category.setName(categoryName);
            ResponseEntity<ItemCatalogCategoryGET> responseCategory = catalogApiClient.createCatalogProductCategory(category);
            categoryId = responseCategory.getBody().getItem().getId();
        } else {
            categoryId = response.getBody().getItems().get(0).getId();
        }
        return categoryId;
    }

    public int createServiceCategoryIfNotExists (String categoryName) {
        ResponseEntity<ListServicesCategories> response = catalogApiClient.getCatalogServiceCategories(null, null, "{\"name\":\"" + categoryName + "\"}", 100, 0, null);
        int categoryId = 0;
        if (response.getBody().getPagination().getTotal() == 0) {
            CatalogCategoryPOST category = new CatalogCategoryPOST();
            category.setName(categoryName);
            ResponseEntity<ItemCatalogCategoryGET> responseCategory = catalogApiClient.createCatalogServiceCategory(category);
            categoryId = responseCategory.getBody().getItem().getId();
        } else {
            categoryId = response.getBody().getItems().get(0).getId();
        }
        return categoryId;
    }
}
