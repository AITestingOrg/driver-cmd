package org.aitesting.microservices.drivercmd.service.controllers;


import org.aitesting.microservices.drivercmd.domain.commands.CreateDriverCommand;
import org.aitesting.microservices.drivercmd.domain.models.DriverDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class DriverController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("driver")
    public ResponseEntity<Map<String,Object>> addDriver(@Valid @RequestBody DriverDto driver) {
        CreateDriverCommand createDriverCommand = new CreateDriverCommand(driver.getLicense(), driver.isAvailable());
        commandGateway.send(createDriverCommand);
        Map<String, Object> json = new HashMap<>();
        json.put("id", createDriverCommand.getId());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        return (new ResponseEntity<>(json, headers, HttpStatus.CREATED));
    }
}
