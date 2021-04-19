import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/credit-scores'
        body (
                "citizenNumber" : 1234,
                "requestDate" : $(consumer(anyDate()), producer("2020-04-26")),
                "uuid" : $(consumer(anyUuid()), producer("aac0a33c-8822-11ea-bc55-0242ac130003"))
        )
        headers {
            contentType applicationJson()
        }
    }
    response {
        status 200
        body  (
                "score": "HIGH",
                "uuid" : $(consumer(fromRequest().body('$.uuid')), producer("aac0a33c-8822-11ea-bc55-0242ac130003"))
        )
        headers {
            contentType applicationJson()
        }
    }
}
