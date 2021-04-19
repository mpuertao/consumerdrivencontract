package com.bankretaildigital.creditcardservice.gateway;

import java.time.LocalDate;
import java.util.UUID;

public class CreditCheckRequest {

    private final int citizenNumber;
    private final String requestDate = LocalDate.now().toString();
    private final String uuid = UUID.randomUUID().toString();

    public CreditCheckRequest(int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public String getUuid() {
        return uuid;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public int getCitizenNumber() {
        return citizenNumber;
    }
}
