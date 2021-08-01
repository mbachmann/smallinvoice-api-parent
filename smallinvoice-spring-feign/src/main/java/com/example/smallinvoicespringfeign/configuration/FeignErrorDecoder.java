package com.example.smallinvoicespringfeign.configuration;


import java.util.Date;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

/**
 * Custom Error decoder for feign Retries the request again if response code is 404
 */
public class FeignErrorDecoder implements ErrorDecoder, HasLogger {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            getLogger().info("Error while executing " + methodKey + " Error code " + HttpStatus.NOT_FOUND);
            FeignException e =  SmallInvoiceNotFoundException.errorStatus(methodKey, response);
            return new SmallInvoiceNotFoundException(e);
            // return new RetryableException(response.status(), methodKey, null,
            //         new Date(System.currentTimeMillis()), response.request());
        }
        return defaultErrorDecoder.decode(methodKey, response);

    }
}
