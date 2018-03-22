package org.aitesting.microservices.drivercmd.domain.aggregates;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.aitesting.microservices.driver.common.events.DriverCreatedEvent;
import org.aitesting.microservices.drivercmd.domain.commands.CreateDriverCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateMember;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class Driver {
    @AggregateIdentifier
    private UUID id;
    private String license;
    private boolean available;
    private double rating;
    @AggregateMember
    private CommandHandlers commandHandlers = new CommandHandlers();

    @CommandHandler
    public Driver(CreateDriverCommand createDriverCommand) {
        apply(new DriverCreatedEvent(createDriverCommand.getId(), createDriverCommand.getLicense(),
                createDriverCommand.isAvailable()));
    }

    public UUID getId() { return id; }

    public String getLicense() { return license; }

    public boolean isAvailable() { return available; }

    public double getRating() { return rating; }

    @EventSourcingHandler
    public void on(DriverCreatedEvent driverCreatedEvent) {
        id = driverCreatedEvent.getId();
        license = driverCreatedEvent.getLicense();
        available = false;
        rating = 0.0;
    }
}
