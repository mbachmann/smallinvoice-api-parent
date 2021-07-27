package com.example.smallinvoicespringfeign.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.example.smallinvoicespringfeign.configuration.ClientConfiguration;

@FeignClient(name="${configuration.name:configuration}", url="${configuration.url:https://api.smallinvoice.com/v2}", configuration = ClientConfiguration.class)
public interface ConfigurationApiClient extends ConfigurationApi {
}
