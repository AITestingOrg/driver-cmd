package org.aitesting.microservices.drivercmd.service.configuration;

import org.aist.libs.eventsourcing.configuration.configurations.AmqpEventPublisherConfiguration;
import org.aitesting.microservices.drivercmd.domain.DriverCommandHandler;
import org.aitesting.microservices.drivercmd.domain.aggregates.DriverAggregate;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverEventStoreConfiguration
        extends AmqpEventPublisherConfiguration<DriverAggregate, DriverCommandHandler> {
    public DriverEventStoreConfiguration() {
        super(DriverAggregate.class);
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
