package com.example.smallinvoicespringfeign.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.example.smallinvoicespringfeign.configuration.ClientConfiguration;

@FeignClient(name="${catalog.name:catalog}", url="${catalog.url:https://api.smallinvoice.com/v2}", configuration = ClientConfiguration.class)
public interface CatalogApiClient extends CatalogApi {
}
