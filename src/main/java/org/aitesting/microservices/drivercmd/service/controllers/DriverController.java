package org.aitesting.microservices.drivercmd.service.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.validation.Valid;
import org.aitesting.microservices.drivercmd.domain.commands.CreateDriverCommand;
import org.aitesting.microservices.drivercmd.domain.commands.DeleteDriverCommand;
import org.aitesting.microservices.drivercmd.domain.commands.DriverChangeAvailabilityCommand;
import org.aitesting.microservices.drivercmd.domain.models.DriverDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        logger.info(String.format("Dispatched CreateDriverCommand %s", createDriverCommand.getId()));
        Map<String, Object> json = new HashMap<>();
        json.put("id", createDriverCommand.getId());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        return (new ResponseEntity<>(json, headers, HttpStatus.CREATED));
    }

    @DeleteMapping("driver/delete/{id}")
    public void deleteDriver(@PathVariable("id") UUID id) {
        logger.info(String.format("Request to delete driver: %s", id));
        DeleteDriverCommand deleteDriverCommand = new DeleteDriverCommand(id);
        commandGateway.send(deleteDriverCommand);
        logger.info(String.format("Dispatched DeleteDriverCommand %s", deleteDriverCommand.getId()));
    }

    @PutMapping("driver/availability/{id}")
    public void updateDriverAvailability(@PathVariable("id") UUID id,
                                         @RequestBody DriverDto driverDto) {
        logger.info(String.format("Request to change driver availability to: ", driverDto.isAvailable()));
        DriverChangeAvailabilityCommand driverChangeAvailabilityCommand = new DriverChangeAvailabilityCommand(id,
                driverDto.isAvailable());
        commandGateway.send(driverChangeAvailabilityCommand);
        logger.info(String.format("Dispatched DriverChangeAvailabilityCommand %s",
                driverChangeAvailabilityCommand.getId()));
    }
}
