package com.bankretaildigital.creditcardservice.models;

import java.time.LocalDate;

public class CreditCheckRequest {

    private final int citizenNumber;
    private final String requestDate = LocalDate.now().toString();

    public String getRequestDate() {
        return requestDate;
    }

    public CreditCheckRequest(int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public int getCitizenNumber() {
        return citizenNumber;
    }
}
