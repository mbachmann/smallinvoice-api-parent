package com.example.smallinvoice.springfeign;

import com.example.smallinvoicespringfeign.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigurationTest extends SharedTest {

    @Override
    @BeforeEach
    public void setUp() {

    }

    @Order(1)
    @Test
    public void createBankAndChangeAccount() throws IOException, InterruptedException {
        String jsonBankAccount = readResource(new ClassPathResource("configuration/bankaccount1.json"));
        ConfigurationBankAccountPOST bankAccount = mapFromJson(jsonBankAccount, ConfigurationBankAccountPOST.class);

        apiService.deleteBankAccountByDescriptionIfExists(bankAccount.getDescription());
        ConfigurationBankAccountGET  bankAccountGet = apiService.createBankAccount(bankAccount);

        assertEquals(bankAccount, mapFromJson(mapToJson(bankAccountGet), ConfigurationBankAccountPOST.class));

        // Change the new created bank account and save it again with update
        bankAccountGet.setNumber("7654321");
        ConfigurationBankAccountGET  bankAccountUpdated = apiService.updateBankAccount(bankAccountGet);

        if (bankAccountUpdated != null) assertEquals(bankAccountGet, bankAccountUpdated);
    }

    @Order(2)
    @Test
    public void createAndChangeExchangeRate() throws IOException {
        String jsonExchangeRate = readResource(new ClassPathResource("configuration/exchangerate1.json"));
        ConfigurationExchangeRatePOST exchangeRate = mapFromJson(jsonExchangeRate, ConfigurationExchangeRatePOST.class);
        apiService.deleteExchangeRateIfExists(exchangeRate.getCurrencyFrom(), exchangeRate.getCurrencyTo());

        ConfigurationExchangeRateGET exchangeRateGet = apiService.createExchangeRate(exchangeRate);

        assertEquals(exchangeRate, mapFromJson(mapToJson(exchangeRateGet), ConfigurationExchangeRatePOST.class));

        // Change the new created excange rate and save it again with update
        exchangeRateGet.setRate((float) (exchangeRateGet.getRate() * 1.01));
        ConfigurationExchangeRateGET  exchangeRateUpdated = apiService.updateExchangeRate(exchangeRateGet);

        if (exchangeRateUpdated != null) assertEquals(exchangeRateGet, exchangeRateUpdated);
    }

    @Order(3)
    @Test
    public void getBankAccounts() throws Exception {
        List<ConfigurationBankAccountGET> bankAccounts = apiService.getBankAccounts();
        if (bankAccounts != null) {
            bankAccounts.forEach(item -> getLogger().debug(item.toString()));
        }
    }

    @Order(4)
    @Test
    public void getExchangeRates() throws Exception {
        List<ConfigurationExchangeRateGET> exchangeRates = apiService.getExchangeRates();
        if (exchangeRates != null) {
            exchangeRates.forEach(item -> getLogger().debug(item.toString()));
        }
    }

}
