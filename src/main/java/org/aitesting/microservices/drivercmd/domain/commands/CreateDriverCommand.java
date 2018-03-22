package org.aitesting.microservices.drivercmd.domain.commands;

import org.aitesting.microservices.driver.common.events.DriverCreatedEvent;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;

import java.util.UUID;

public class CreateDriverCommand {
    @TargetAggregateIdentifier
    private UUID id;
    private String license;
    private boolean available;

    public CreateDriverCommand(String license, boolean available) {
        this.id = UUID.randomUUID();
        this.license = license;
        this.available = available;
    }

    public UUID getId() {
        return id;
    }

    public String getLicense() {
        return license;
    }

    public boolean isAvailable() {
        return available;
    }

}
