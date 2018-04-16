package org.aitesting.microservices.drivercmd.domain.aggregates;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import java.util.UUID;
import org.aitesting.microservices.driver.common.events.DriverCreatedEvent;
import org.aitesting.microservices.drivercmd.domain.commands.CreateDriverCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateMember;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aggregate
public class Driver {
    private static final Logger logger = LoggerFactory.getLogger(Driver.class);

    @AggregateIdentifier
    private UUID id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String license;

    private double currentLocationLat;
    private double currentLocationLong;
    private boolean available;
    private double rating;
    private int numberOfRatings;

    @AggregateMember
    private CommandHandlers commandHandlers = new CommandHandlers();
    public Driver() {

    }

    @CommandHandler
    public Driver(CreateDriverCommand createDriverCommand) {
        logger.info(String.format("Dispatching CreateDriverCommand %s", createDriverCommand.getId()));
        apply(new DriverCreatedEvent(createDriverCommand.getId(), createDriverCommand.getFirstName(),
                createDriverCommand.getLastName(),createDriverCommand.getAddress(),
                createDriverCommand.getEmail(), createDriverCommand.getPhone(),
                createDriverCommand.getLicense()));
    }

    public UUID getId() {
        return id;
    }

    public String getFname() {
        return firstName;
    }

    public String getLname() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLicense() {
        return license;
    }

    public double getCurrent_location_lat() {
        return currentLocationLat;
    }

    public double getCurrent_location_long() {
        return currentLocationLong;
    }

    public boolean isAvailable() {
        return available;
    }

    public double getRating() {
        return rating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public CommandHandlers getCommandHandlers() {
        return commandHandlers;
    }

    @EventSourcingHandler
    public void on(DriverCreatedEvent driverCreatedEvent) {
        this.id = driverCreatedEvent.getId();
        this.firstName = driverCreatedEvent.getFirstName();
        this.lastName = driverCreatedEvent.getLastName();
        this.address = driverCreatedEvent.getAddress();
        this.email = driverCreatedEvent.getEmail();
        this.phone = driverCreatedEvent.getPhone();
        this.license = driverCreatedEvent.getLicense();
    }
}
