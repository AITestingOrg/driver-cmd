package org.aitesting.microservices.drivercmd.domain;

import org.aist.libs.eventsourcing.configuration.handlers.CustomCommandHandler;
import org.aitesting.microservices.drivercmd.domain.aggregates.DriverAggregate;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.eventsourcing.EventSourcingRepository;

public class DriverCommandHandler extends CustomCommandHandler<DriverAggregate> {
    public DriverCommandHandler(EventSourcingRepository repository, CommandBus commandBus) {
        super(repository, commandBus, DriverAggregate.class);
    }
}
