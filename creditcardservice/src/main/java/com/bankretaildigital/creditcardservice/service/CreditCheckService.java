package com.bankretaildigital.creditcardservice.service;

import com.bankretaildigital.creditcardservice.controller.ApplyForCreditCardRequest;
import com.bankretaildigital.creditcardservice.controller.ApplyForCreditCardResponse;
import com.bankretaildigital.creditcardservice.gateway.CreditCheckGateway;
import com.bankretaildigital.creditcardservice.gateway.CreditCheckResponse;
import org.springframework.stereotype.Component;

import static com.bankretaildigital.creditcardservice.controller.ApplyForCreditCardRequest.CardType.GOLD;
import static com.bankretaildigital.creditcardservice.controller.ApplyForCreditCardResponse.Status.DENIED;
import static com.bankretaildigital.creditcardservice.controller.ApplyForCreditCardResponse.Status.GRANTED;
import static com.bankretaildigital.creditcardservice.gateway.CreditCheckResponse.Score.HIGH;

@Component
public class CreditCheckService {

    private final CreditCheckGateway creditCheckGateway;

    public CreditCheckService(CreditCheckGateway creditCheckGateway) {
        this.creditCheckGateway = creditCheckGateway;
    }

    public ApplyForCreditCardResponse doCheckForCitizen (ApplyForCreditCardRequest applyForCreditCardRequest) {

        final CreditCheckResponse creditCheckResponse = creditCheckGateway.doCreditCheckForCitizen(applyForCreditCardRequest.getCitizenNumber());

        final CreditCheckResponse.Score score = creditCheckResponse.getScore();
        final String uuid = creditCheckResponse.getUuid();

        if (applyForCreditCardRequest.getCardType() == GOLD) {
            if (score == HIGH) {
                return new ApplyForCreditCardResponse(GRANTED, uuid);
            } else if (score == CreditCheckResponse.Score.LOW) {
                return new ApplyForCreditCardResponse(DENIED, uuid);
            }
        }
        throw new RuntimeException("Card and score not yet implemented");
    }
}
