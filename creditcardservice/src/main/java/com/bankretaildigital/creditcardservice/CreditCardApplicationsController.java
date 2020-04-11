package com.bankretaildigital.creditcardservice;

import com.bankretaildigital.creditcardservice.models.ApplyForCreditCardRequest;
import com.bankretaildigital.creditcardservice.models.ApplyForCreditCardResponse;
import com.bankretaildigital.creditcardservice.models.CreditCheckRequest;
import com.bankretaildigital.creditcardservice.models.CreditCheckResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static com.bankretaildigital.creditcardservice.models.ApplyForCreditCardRequest.CardType.GOLD;
import static com.bankretaildigital.creditcardservice.models.ApplyForCreditCardResponse.Status.DENIED;
import static com.bankretaildigital.creditcardservice.models.ApplyForCreditCardResponse.Status.GRANTED;
import static com.bankretaildigital.creditcardservice.models.CreditCheckResponse.Score.HIGH;
import static com.bankretaildigital.creditcardservice.models.CreditCheckResponse.Score.LOW;

@RestController
public class CreditCardApplicationsController {

    private final RestTemplate restTemplate;
    private final String creditcheckserviceBaseUrl;

    public CreditCardApplicationsController(RestTemplate restTemplate, @Value("${creditcheckservice.baseurl}") String creditcheckserviceBaseUrl) {
        this.restTemplate = restTemplate;
        this.creditcheckserviceBaseUrl = creditcheckserviceBaseUrl;
    }

    @PostMapping("credit-card-applications")
    public ApplyForCreditCardResponse applyForCreditCard(@RequestBody final ApplyForCreditCardRequest applyForCreditCardRequest) {
        final int citizenNumber = applyForCreditCardRequest.getCitizenNumber();
        final String uri = UriComponentsBuilder.fromHttpUrl(creditcheckserviceBaseUrl)
                .path("credit-scores")
                .toUriString();
        final CreditCheckResponse creditCheckResponse = restTemplate.postForObject(uri, new CreditCheckRequest(citizenNumber), CreditCheckResponse.class);

        if (applyForCreditCardRequest.getCardType() == GOLD) {
            if (creditCheckResponse.getScore() == HIGH) {
                return new ApplyForCreditCardResponse(GRANTED);
            } else if (creditCheckResponse.getScore() == LOW) {
                return new ApplyForCreditCardResponse(DENIED);
            }
        }
        throw new RuntimeException("Card  and score not yet implemented");
    }
}
