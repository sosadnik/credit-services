package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should create customer by id=1"

    request {
        url "/customer/create"
        method POST()
        body([
                id       : 1,
                credit   : [
                        id        : 1,
                        creditName: "bulka"
                ],
                firstName: "tarta",
                sureName : "wytarta",
                pesel    : "9898"
        ])
        headers {
            contentType('application/json')
        }
    }

    response {
        status(200)
    }
}