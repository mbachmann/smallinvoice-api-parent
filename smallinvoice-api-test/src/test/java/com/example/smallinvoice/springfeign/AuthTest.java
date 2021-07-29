package com.example.smallinvoice.springfeign;

import com.example.smallinvoice.AbstractTest;
import com.example.smallinvoicespringfeign.api.AuthApiClient;
import com.example.smallinvoicespringfeign.model.ItemAuthOwnerGET;
import com.example.smallinvoicespringfeign.model.ItemAuthProfileGET;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest extends AbstractTest {

    @Autowired
    private AuthApiClient authApiClient;

    @Override
    @BeforeEach
    public void setUp() {

    }

    @Test
    public void getAuthUserProfile() throws Exception {
        ResponseEntity<ItemAuthProfileGET> response = authApiClient.getAuthUserProfile();
        assertEquals(200, response.getStatusCodeValue());
        if (response.getBody() != null) {
            getLogger().debug(response.getBody().getItem().toString());
        }
    }

    @Test
    public void getAuthenticatedResourceOwner() throws Exception {
        ResponseEntity<ItemAuthOwnerGET> response = authApiClient.getAuthenticatedResourceOwner();
        assertEquals(200, response.getStatusCodeValue());
        if (response.getBody() != null) {
            getLogger().debug(response.getBody().getItem().toString());
        }
    }

}
