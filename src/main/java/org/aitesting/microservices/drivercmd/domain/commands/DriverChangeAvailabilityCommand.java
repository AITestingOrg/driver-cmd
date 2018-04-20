package org.aitesting.microservices.drivercmd.domain.commands;

import java.util.UUID;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class DriverChangeAvailabilityCommand {
    @TargetAggregateIdentifier
    private UUID id;
    private boolean available;

    public DriverChangeAvailabilityCommand(UUID id, boolean available) {
        this.id = id;
        this.available = available;
    }

    public UUID getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }
}
