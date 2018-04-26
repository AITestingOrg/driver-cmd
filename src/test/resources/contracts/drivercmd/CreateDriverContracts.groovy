package drivercmd

import org.springframework.cloud.contract.spec.Contract

[
    Contract.make {
        description("When a POST request to api/v1/driver should return 201")
        request {
            method 'POST'
            url '/api/v1/driver'
            headers{
                contentType(applicationJson())
            }
            body(
                    "firstName": "Jane",
                    "lastName": "Doe",
                    "address": "123 Address",
                    "email": "123@email.com",
                    "phone": "12345",
                    "license": "124DFEWCVDF342"
            )
        }
        response {
            status 201
            headers {
                contentType(applicationJson())
            }
        }
    },
    Contract.make {
        description("When a POST request to api/v1/driver with missing body" +
                " should return 400")
        request {
            method 'POST'
            url '/api/v1/driver'
            headers{
                contentType(applicationJson())
            }
        }
        response {
            status 400
        }
    }
]