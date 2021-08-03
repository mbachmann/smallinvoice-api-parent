package com.example.smallinvoice.springfeign;

import com.example.smallinvoicespringfeign.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogTest extends SharedTest {

    @Override
    @BeforeEach
    public void setUp() {

    }

    @Test
    public void getCatalogProducts() {

        List<CatalogProductGET> catalogProducts = apiService.getCatalogProducts("permissions", null);

        if (catalogProducts != null) {
            catalogProducts.forEach(item -> getLogger().debug(item.toString()));
            if (catalogProducts.size() > 0) {
                CatalogProductGET catalogProduct = apiService.getCatalogProductById(catalogProducts.get(0).getId(), "permissions");
                assertEquals(catalogProduct, catalogProducts.get(0));
            }
        }
    }

    @Test
    public void getCatalogProductCategories() {

        List<CatalogCategoryGET> catalogProductCategories = apiService.getCatalogProductCategories("permissions", null);

        if (catalogProductCategories != null) {
            catalogProductCategories.forEach(item -> getLogger().debug(item.toString()));
            if (catalogProductCategories.size() > 0) {
                CatalogCategoryGET catalogProductCategory = apiService.getCatalogProductCategoryById(catalogProductCategories.get(0).getId(), "permissions");
                assertEquals(catalogProductCategory, catalogProductCategories.get(0));
            }
        }
    }

    @Test
    public void getCatalogService() {
        List<CatalogServiceGET> catalogServices = apiService.getCatalogServices("permissions", null);

        if (catalogServices != null) {
            catalogServices.forEach(item -> getLogger().debug(item.toString()));
            if (catalogServices.size() > 0) {
                CatalogServiceGET catalogService = apiService.getCatalogServiceById(catalogServices.get(0).getId(), "permissions");
                assertEquals(catalogService, catalogServices.get(0));
            }
        }
    }

    @Test
    public void getCatalogServiceCategories() {

        List<CatalogCategoryGET> catalogServiceCategories = apiService.getCatalogServiceCategories("permissions", null);

        if (catalogServiceCategories != null) {
            catalogServiceCategories.forEach(item -> getLogger().debug(item.toString()));
            if (catalogServiceCategories.size() > 0) {
                CatalogCategoryGET catalogServiceCategory = apiService.getCatalogServiceCategoryById(catalogServiceCategories.get(0).getId(), "permissions");
                assertEquals(catalogServiceCategory, catalogServiceCategories.get(0));
            }
        }
    }

    @Test
    public void createAndChangeProduct() throws Exception {

        String jsonProduct = readResource(new ClassPathResource("catalog/product1.json"));
        CatalogProductPOST product = mapFromJson(jsonProduct, CatalogProductPOST.class);
        apiService.deleteCatalogProductByNameIfExists(product.getName());

        CatalogProductGET catalogProductGet = apiService.createCatalogProduct(product);
        assertEquals(product, mapFromJson(mapToJson(catalogProductGet), CatalogProductPOST.class));

        int productCategoryId = apiService.createProductCategoryIfNotExists("Product-Category-A");

        // Change the new created product and save it again with update
        catalogProductGet.setNotes("Some additional Notes");
        catalogProductGet.setCategoryId(productCategoryId);

        CatalogProductGET catalogProductUpdated = apiService.updateCatalogProduct(catalogProductGet);
        if (catalogProductUpdated != null) assertEquals(catalogProductGet, catalogProductUpdated);

        TimeUnit.MILLISECONDS.sleep(500);
    }

    @Test
    public void createAndChangeService() throws Exception {

        String jsonContact = readResource(new ClassPathResource("catalog/service1.json"));
        CatalogServicePOST service = mapFromJson(jsonContact, CatalogServicePOST.class);
        apiService.deleteCatalogServiceByNameIfExists(service.getName());

        CatalogServiceGET catalogServiceGet = apiService.createCatalogService(service);
        assertEquals(service, mapFromJson(mapToJson(catalogServiceGet), CatalogServicePOST.class));

        int productCategoryId = apiService.createServiceCategoryIfNotExists("Service-Category-A");

        // Change the new created product and save it again with update
        catalogServiceGet.setNotes("Some additional Notes");
        catalogServiceGet.setCategoryId(productCategoryId);

        CatalogServiceGET catalogServiceUpdated = apiService.updateCatalogService(catalogServiceGet);
        if (catalogServiceUpdated != null) assertEquals(catalogServiceGet, catalogServiceUpdated);

        TimeUnit.MILLISECONDS.sleep(500);
    }

    @Test
    public void getUnits() throws Exception {
        List<CatalogConfigurationUnitGET> units = apiService.getCatalogUnits("permissions", null);
        if (units != null) {
            units.forEach(unit -> getLogger().debug(unit.toString()));
            CatalogConfigurationUnitGET unit = apiService.getCatalogUnitById(units.get(0).getId(), "permissions");
            assertEquals(units.get(0), unit);
        }
    }
}
