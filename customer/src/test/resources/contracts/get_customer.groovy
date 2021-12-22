package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return customer list with id=1,2"

    request {
        url "/customer/get"
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
        body([[
                id       : 1,
                credit   : [
                        id        : 1,
                        creditName: "bulka"
                ],
                firstName: "tarta",
                sureName : "wytarta",
                pesel    : "9898"
        ],
              [
                      id       : 2,
                      credit   : [
                              id        : 2,
                              creditName: "test2"
                      ],
                      firstName: "first1",
                      sureName : "sur2",
                      pesel    : "9898"
              ]
        ])
    }
}