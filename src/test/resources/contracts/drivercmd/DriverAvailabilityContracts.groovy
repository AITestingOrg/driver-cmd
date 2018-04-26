package drivercmd

import org.springframework.cloud.contract.spec.Contract

[
    Contract.make {
        description("When a PUT request for api/v1/driver/availability/{id} should return 200")
        request {
            method 'PUT'
            url '/api/v1/driver/availability/123e4567-e89b-12d3-a456-426655440000'
            headers{
                contentType(applicationJson())
            }
            body(
                "available": true,
            )
        }
        response {
            status 200
        }
    }
]
