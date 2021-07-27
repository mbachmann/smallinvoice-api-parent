package com.example.smallinvoicespringfeign.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.example.smallinvoicespringfeign.configuration.ClientConfiguration;

@FeignClient(name="${auth.name:auth}", url="${auth.url:https://api.smallinvoice.com/v2}", configuration = ClientConfiguration.class)
public interface AuthApiClient extends AuthApi {
}
