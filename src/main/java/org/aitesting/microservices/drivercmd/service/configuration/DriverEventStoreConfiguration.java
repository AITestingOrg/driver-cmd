package org.aitesting.microservices.drivercmd.service.configuration;

import org.aist.libs.eventsourcing.configuration.configurations.AmqpEventPublisherConfiguration;
import org.aitesting.microservices.drivercmd.domain.DriverCommandHandler;
import org.aitesting.microservices.drivercmd.domain.aggregates.Driver;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverEventStoreConfiguration
        extends AmqpEventPublisherConfiguration<Driver, DriverCommandHandler> {
    public DriverEventStoreConfiguration() {
        super(Driver.class);
    }

    @Override
    @Bean
    public DriverCommandHandler commandHandler(
            EventSourcingRepository eventSourcingRepository, CommandBus commandBus) {
        DriverCommandHandler commandHandler
                = new DriverCommandHandler(eventSourcingRepository, commandBus);
        commandHandler.subscribe();
        return commandHandler;
    }
}
