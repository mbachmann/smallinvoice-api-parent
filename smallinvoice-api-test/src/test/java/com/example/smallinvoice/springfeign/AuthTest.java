package com.example.smallinvoice.springfeign;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthTest extends SharedTest {


    @Override
    @BeforeEach
    public void setUp() {

    }

    @Test
    public void getAuthUserProfile() throws Exception {
        apiService.getAuthUserProfile();
    }

    @Test
    public void getAuthenticatedResourceOwner() throws Exception {
        apiService.getAuthenticatedResourceOwner();
    }

}
