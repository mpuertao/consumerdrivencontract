package com.bankdigitalretail.creditcheckservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import static com.bankdigitalretail.creditcheckservice.CreditCheckResponse.Score.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseContractTest {

    @Before
    public void setup() {
        final CreditCheckService mock = mock(CreditCheckService.class);
        when(mock.doCreditCheck(1234)).thenReturn(new CreditCheckResponse(HIGH, "aac0a33c-8822-11ea-bc55-0242ac130003"));
        when(mock.doCreditCheck(4444)).thenReturn(new CreditCheckResponse(LOW, "aac0a33c-8822-11ea-bc55-0242ac130003"));
        RestAssuredMockMvc.standaloneSetup(new CreditCheckController(mock));
    }
}
