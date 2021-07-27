package com.example.smallinvoicespringfeign.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.example.smallinvoicespringfeign.configuration.ClientConfiguration;

@FeignClient(name="${reporting.name:reporting}", url="${reporting.url:https://api.smallinvoice.com/v2}", configuration = ClientConfiguration.class)
public interface ReportingApiClient extends ReportingApi {
}
