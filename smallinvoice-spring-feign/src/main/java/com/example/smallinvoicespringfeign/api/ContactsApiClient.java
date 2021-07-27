package com.example.smallinvoicespringfeign.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.example.smallinvoicespringfeign.configuration.ClientConfiguration;

@FeignClient(name="${contacts.name:contacts}", url="${contacts.url:https://api.smallinvoice.com/v2}", configuration = ClientConfiguration.class)
public interface ContactsApiClient extends ContactsApi {
}
