package com.bankretaildigital.creditcardservice.models;

public class ApplyForCreditCardRequest {

    public int getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    private int citizenNumber;
    private CardType cardType;


    public enum CardType {
        GOLD
    }
}
