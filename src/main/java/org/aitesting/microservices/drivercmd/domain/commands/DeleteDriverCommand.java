package org.aitesting.microservices.drivercmd.domain.commands;

import java.util.UUID;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class DeleteDriverCommand {
    @TargetAggregateIdentifier
    private UUID id;

    public DeleteDriverCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
