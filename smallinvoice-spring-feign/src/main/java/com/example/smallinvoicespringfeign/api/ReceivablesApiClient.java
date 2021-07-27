package com.example.smallinvoicespringfeign.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.example.smallinvoicespringfeign.configuration.ClientConfiguration;

@FeignClient(name="${receivables.name:receivables}", url="${receivables.url:https://api.smallinvoice.com/v2}", configuration = ClientConfiguration.class)
public interface ReceivablesApiClient extends ReceivablesApi {
}
