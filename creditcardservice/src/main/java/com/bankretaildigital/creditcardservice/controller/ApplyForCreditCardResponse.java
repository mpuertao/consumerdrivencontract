package com.bankretaildigital.creditcardservice.controller;

public class ApplyForCreditCardResponse {

    private Status status;
    private String uuid;

    public ApplyForCreditCardResponse(Status status, String uuid) {
        this.status = status;
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public Status getStatus() {
        return status;
    }


    public enum Status {
        GRANTED, DENIED
    }
}
