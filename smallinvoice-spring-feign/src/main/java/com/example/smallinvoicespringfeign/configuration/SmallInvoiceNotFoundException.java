package com.example.smallinvoicespringfeign.configuration;

import feign.FeignException;
import feign.Request;
import feign.Response;
import feign.Util;

import java.io.IOException;

public class SmallInvoiceNotFoundException extends FeignException {

    public SmallInvoiceNotFoundException(FeignException e) {
        super(e.status(),e.getMessage(), e.request(), e.getCause(), e.responseBody().get().array());
    }

    protected SmallInvoiceNotFoundException(int status, String message, Throwable cause) {
        super(status, message, cause);
    }

    protected SmallInvoiceNotFoundException(int status, String message, Throwable cause, byte[] responseBody) {
        super(status, message, cause, responseBody);
    }

    protected SmallInvoiceNotFoundException(int status, String message) {
        super(status, message);
    }

    protected SmallInvoiceNotFoundException(int status, String message, byte[] responseBody) {
        super(status, message, responseBody);
    }

    protected SmallInvoiceNotFoundException(int status, String message, Request request, Throwable cause) {
        super(status, message, request, cause);
    }

    protected SmallInvoiceNotFoundException(int status, String message, Request request, Throwable cause, byte[] responseBody) {
        super(status, message, request, cause, responseBody);
    }

    protected SmallInvoiceNotFoundException(int status, String message, Request request) {
        super(status, message, request);
    }

    protected SmallInvoiceNotFoundException(int status, String message, Request request, byte[] responseBody) {
        super(status, message, request, responseBody);
    }


}
