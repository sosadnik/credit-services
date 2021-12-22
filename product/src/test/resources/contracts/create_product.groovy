package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should create product by id=1"

    request {
        url "/product/create"
        method POST()
        body([

                id         : 1,
                credit     : [
                        id        : 1,
                        creditName: "bulka"
                ],
                productName: "panierka",
                value      : 3

        ])
        headers {
            contentType('application/json')
        }
    }

    response {
        status(200)


    }
}