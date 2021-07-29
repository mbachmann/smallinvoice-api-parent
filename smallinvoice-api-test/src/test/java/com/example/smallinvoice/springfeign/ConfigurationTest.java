package com.example.smallinvoice.springfeign;

import com.example.smallinvoice.AbstractTest;
import com.example.smallinvoicespringfeign.api.ConfigurationApiClient;
import com.example.smallinvoicespringfeign.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigurationTest extends AbstractTest {

    @Autowired
    private ConfigurationApiClient configurationApiClient;

    @Override
    @BeforeEach
    public void setUp() {

    }

    @Order(1)
    @Test
    public void createBankAndChangeAccount() throws IOException, InterruptedException {
        String jsonBankAccount = readResource(new ClassPathResource("configuration/bankaccount1.json"));
        ConfigurationBankAccountPOST bankAccount = mapFromJson(jsonBankAccount, ConfigurationBankAccountPOST.class);
        deleteBankAccountIfExists(bankAccount.getDescription());

        ResponseEntity<ItemConfigurationBankAccountGET> accountResponse =  configurationApiClient.createBankAccount(bankAccount);
        int bankAccountId = accountResponse.getBody().getItem().getId();
        assertEquals(bankAccount, mapFromJson(mapToJson(accountResponse.getBody().getItem()), ConfigurationBankAccountPOST.class));

        // Change the new created bank account and save it again with update
        ConfigurationBankAccountPUT newBankAccount = mapFromJson(mapToJson(accountResponse.getBody().getItem()), ConfigurationBankAccountPUT.class);
        newBankAccount.setNumber("7654321");
        ResponseEntity<ItemConfigurationBankAccountGET> bankAccountResponseChange =  configurationApiClient.updateBankAccount(bankAccountId,newBankAccount);
        if (bankAccountResponseChange.getBody() != null) {
            assertEquals(newBankAccount, mapFromJson(mapToJson(bankAccountResponseChange.getBody().getItem()), ConfigurationBankAccountPUT.class));
        }
        TimeUnit.MILLISECONDS.sleep(500);
    }

    @Order(2)
    @Test
    public void createAndChangeExchangeRate() throws IOException, InterruptedException {
        String jsonExchangeRate = readResource(new ClassPathResource("configuration/exchangerate1.json"));
        ConfigurationExchangeRatePOST exchangeRate = mapFromJson(jsonExchangeRate, ConfigurationExchangeRatePOST.class);
        deleteExchangeRateIfExists(exchangeRate.getCurrencyFrom(), exchangeRate.getCurrencyTo());

        ResponseEntity<ItemConfigurationExchangeRateGET> accountResponse =  configurationApiClient.createCurrencyExchangeRate(exchangeRate);
        int bankAccountId = accountResponse.getBody().getItem().getId();
        assertEquals(exchangeRate, mapFromJson(mapToJson(accountResponse.getBody().getItem()), ConfigurationExchangeRatePOST.class));

        // Change the new created excange rate and save it again with update
        ConfigurationExchangeRatePUT newExchangeRate = mapFromJson(mapToJson(accountResponse.getBody().getItem()), ConfigurationExchangeRatePUT.class);
        newExchangeRate.setRate((float) (newExchangeRate.getRate() * 1.01));
        ResponseEntity<ItemConfigurationExchangeRateGET> exchangeRateResponseChange =  configurationApiClient.updateCurrencyExchangeRate(bankAccountId,newExchangeRate);
        if (exchangeRateResponseChange.getBody() != null) {
            assertEquals(newExchangeRate, mapFromJson(mapToJson(exchangeRateResponseChange.getBody().getItem()), ConfigurationExchangeRatePUT.class));
        }
        TimeUnit.MILLISECONDS.sleep(500);
    }

    @Order(3)
    @Test
    public void getBankAccounts() throws Exception {
        ResponseEntity<ListConfigurationBankAccounts> response = configurationApiClient.getBankAccounts("permissions", null, null, 100, 0, null);
        assertEquals(200, response.getStatusCodeValue());
        if (response.getBody() != null) {
            response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
        }
    }

    @Order(4)
    @Test
    public void getExchangeRates() throws Exception {
        // TimeUnit.MILLISECONDS.sleep(1000);
        ResponseEntity<ListConfigurationExchangeRates> response = configurationApiClient.getCurrencyExchangeRates(null, null, 100, 0, null);
        assertEquals(200, response.getStatusCodeValue());
        if (response.getBody() != null) {
            response.getBody().getItems().forEach(item -> getLogger().debug(item.toString()));
        }
    }

    public void deleteBankAccountIfExists(String description) {
        ResponseEntity<ListConfigurationBankAccounts> response = configurationApiClient.getBankAccounts(null, null, "{\"description\":\"" + description + "\"}", 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = configurationApiClient.deleteBankAccounts(response.getBody().getItems().get(0).getId());
        }
    }

    public void deleteExchangeRateIfExists(String currencyFrom, String currencyTo) {
        String filterJson = "{\"and\":[{\"currency_from\":\"" + currencyFrom + "\"},{\"currency_to\":\"" + currencyTo + "\"}]}";
        ResponseEntity<ListConfigurationExchangeRates> response = configurationApiClient.getCurrencyExchangeRates(null, filterJson, 100, 0, null);
        if (response.getBody() != null && response.getBody().getPagination().getTotal() > 0) {
            ResponseEntity<Void> responseDelete = configurationApiClient.deleteCurrencyExchangeRates(response.getBody().getItems().get(0).getId());
        }
    }

}
