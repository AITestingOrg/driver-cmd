package org.aitesting.microservices.drivercmd.service.controllers;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.aitesting.microservices.drivercmd.domain.commands.CreateDriverCommand;
import org.aitesting.microservices.drivercmd.domain.models.DriverDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("driver")
    public ResponseEntity<Map<String,Object>> addDriver(@Valid @RequestBody DriverDto driver) {
        logger.info(String.format("Request to add driver first name: %s, last name: %s, "
                        + "address: %s, email: %s, phone: %s, and license: %s",
                driver.getFirstName(), driver.getLastName(), driver.getAddress(),
                driver.getEmail(), driver.getPhone(), driver.getLicense()));

        CreateDriverCommand createDriverCommand = new CreateDriverCommand(driver.getFirstName(),
                driver.getLastName(),driver.getAddress(), driver.getEmail(), driver.getPhone(),
                driver.getLicense());

        commandGateway.send(createDriverCommand);

        logger.info(String.format("Dispatched CreateDriverCommand %s",
                createDriverCommand.getId()));

        Map<String, Object> json = new HashMap<>();
        json.put("id", createDriverCommand.getId());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        return (new ResponseEntity<>(json, headers, HttpStatus.CREATED));
    }
}
