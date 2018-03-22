package org.aitesting.microservices.drivercmd.domain;

import org.aist.libs.eventsourcing.configuration.handlers.CustomCommandHandler;
import org.aitesting.microservices.drivercmd.domain.aggregates.Driver;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.eventsourcing.EventSourcingRepository;

public class DriverCommandHandler extends CustomCommandHandler<Driver> {
    public DriverCommandHandler(EventSourcingRepository repository, CommandBus commandBus) {
        super(repository, commandBus, Driver.class);
    }
}
