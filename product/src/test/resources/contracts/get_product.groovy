package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return product list with id=1"

    request {
        url "/product/get"
        method POST()
        body([
                1,2
        ])
        headers {
            contentType('application/json')
        }
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body([
                [
                    id: 1,
                    credit: [
                    id: 1,
                    creditName: "bulka"
                ],
                    productName: "panierka",
                    value: 3
                ],
                [
                    id: 2,
                    credit: [
                    id: 2,
                    creditName: "pies"
                ],
                    productName: "kot",
                    value: 3
                ]
        ])
    }
}