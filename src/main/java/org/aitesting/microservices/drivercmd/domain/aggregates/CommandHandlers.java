package org.aitesting.microservices.drivercmd.domain.aggregates;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.aitesting.microservices.driver.common.events.DriverDeletedEvent;
import org.aitesting.microservices.drivercmd.domain.commands.DeleteDriverCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandHandlers {
    private static final Logger logger = LoggerFactory.getLogger(CommandHandler.class);

    @CommandHandler
    public void on(DeleteDriverCommand deleteDriverCommand) {
        logger.info(String.format("Dispatching DriverDeletedEvent %s", deleteDriverCommand.getId()));
        apply(new DriverDeletedEvent((deleteDriverCommand.getId())));
    }
}
