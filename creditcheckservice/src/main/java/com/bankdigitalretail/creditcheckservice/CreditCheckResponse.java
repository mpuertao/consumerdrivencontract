package com.bankdigitalretail.creditcheckservice;


public class CreditCheckResponse {

    private Score score;
    private String uuid;

    public CreditCheckResponse(Score score, String uuid) {
        this.score = score;
        this.uuid = uuid;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getUuid() {
        return uuid;
    }

    public enum Score {
        HIGH, LOW
    }
}
