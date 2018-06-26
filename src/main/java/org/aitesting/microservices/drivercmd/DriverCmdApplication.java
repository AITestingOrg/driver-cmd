package org.aitesting.microservices.drivercmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DriverCmdApplication {
    public static void main(String[] args) {
        SpringApplication.run(DriverCmdApplication.class, args);
    }
}
