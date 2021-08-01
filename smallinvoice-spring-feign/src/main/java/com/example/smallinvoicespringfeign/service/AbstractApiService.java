package com.example.smallinvoicespringfeign.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.io.IOException;


public class AbstractApiService implements HasLogger {

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(json, clazz);
    }

    protected String createOrFilter (String property, String... values) {
        StringBuilder filterJson = new StringBuilder("{\"or\":[");
        for (String value : values) {
            filterJson.append("{\"").append(property).append("\":\"").append(value).append("\"},");
        }
        filterJson.deleteCharAt(filterJson.length() - 1);
        filterJson.append("]}");
        return filterJson.toString();
    }

    protected String createOrFilter (String property, Integer... values) {
        StringBuilder filterJson = new StringBuilder("{\"or\":[");
        for (int value : values) {
            filterJson.append("{\"").append(property).append("\":\"").append(value).append("\"},");
        }
        filterJson.deleteCharAt(filterJson.length() - 1);
        filterJson.append("]}");
        return filterJson.toString();
    }

}
