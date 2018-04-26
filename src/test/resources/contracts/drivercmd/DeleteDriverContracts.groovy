package drivercmd

import org.springframework.cloud.contract.spec.Contract

[
    Contract.make {
        description("When DELETE request for api/v1/driver/delete/{id} should return 200")
        request {
            method 'DELETE'
            url '/api/v1/driver/delete/123e4567-e89b-12d3-a456-426655440000'
        }
        response {
            status 200
        }
    },
    Contract.make {
        description("When DELETE request for api/v1/driver/delete/{id} with invalid id should return 400")
        request {
            method 'DELETE'
            url '/api/v1/driver/delete/invalidId'
        }
        response {
            status 400
        }
    }
]