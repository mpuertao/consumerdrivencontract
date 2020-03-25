package com.bankretaildigital.creditcardservice.models;

public class ApplyForCreditCardResponse {
    private Status status;

    public Status getStatus() {
        return status;
    }

    public ApplyForCreditCardResponse(Status status) {
        this.status = status;
    }

    public enum Status {
        GRANTED
    }
}
