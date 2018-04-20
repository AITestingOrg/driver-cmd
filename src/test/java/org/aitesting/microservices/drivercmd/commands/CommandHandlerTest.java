package org.aitesting.microservices.drivercmd.commands;

import org.aitesting.microservices.driver.common.events.DriverAvailabilityChangedEvent;
import org.aitesting.microservices.driver.common.events.DriverCreatedEvent;
import org.aitesting.microservices.driver.common.events.DriverDeletedEvent;
import org.aitesting.microservices.drivercmd.domain.aggregates.DriverAggregate;
import org.aitesting.microservices.drivercmd.domain.commands.CreateDriverCommand;
import org.aitesting.microservices.drivercmd.domain.commands.DeleteDriverCommand;
import org.aitesting.microservices.drivercmd.domain.commands.DriverChangeAvailabilityCommand;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.aitesting.microservices.drivercmd.configuration.TestConstants.*;

@RunWith(SpringRunner.class)
@Profile("test")
@SpringBootTest
@ContextConfiguration
public class CommandHandlerTest {
    private FixtureConfiguration<DriverAggregate> fixture;

    @Before
    public void setUp() {
        fixture = new AggregateTestFixture<>(DriverAggregate.class);
    }

    @Test
    public void createDriver() {
        CreateDriverCommand command = new CreateDriverCommand(FIRST_NAME,
                LAST_NAME, ADDRESS, EMAIL, PHONE, LICENSE);
        fixture.given()
                .when(command)
                .expectEvents(new DriverCreatedEvent(command.getId(), FIRST_NAME, LAST_NAME,
                        ADDRESS, EMAIL, PHONE, LICENSE));
    }

    @Test
    public void deleteDriver() {
        CreateDriverCommand createDriverCommand = new CreateDriverCommand(FIRST_NAME,
                LAST_NAME, ADDRESS, EMAIL, PHONE, LICENSE);
        DeleteDriverCommand deleteDriverCommand = new DeleteDriverCommand(createDriverCommand.getId());

        fixture.givenCommands(createDriverCommand)
                .when(deleteDriverCommand)
                .expectEvents(new DriverDeletedEvent(createDriverCommand.getId()));
    }

    @Test
    public void deleteDriverWithNoValidDriver() {
        DeleteDriverCommand deleteDriverCommand = new DeleteDriverCommand(UUID.randomUUID());

        fixture.given()
                .when(deleteDriverCommand)
                .expectNoEvents();
    }

    @Test
    public void changeDriverAvailability() {
        CreateDriverCommand createDriverCommand = new CreateDriverCommand(FIRST_NAME,
                LAST_NAME, ADDRESS, EMAIL, PHONE, LICENSE);
        DriverChangeAvailabilityCommand command = new DriverChangeAvailabilityCommand(
                createDriverCommand.getId(), true);

        fixture.givenCommands(createDriverCommand)
                .when(command)
                .expectEvents(new DriverAvailabilityChangedEvent(createDriverCommand.getId(),
                true));
    }

    @Test
    public void changeDriverAvailabilityNoValidDriver() {
        DriverChangeAvailabilityCommand command = new DriverChangeAvailabilityCommand(
                UUID.randomUUID(), true);

        fixture.given()
                .when(command)
                .expectNoEvents();
    }
}
