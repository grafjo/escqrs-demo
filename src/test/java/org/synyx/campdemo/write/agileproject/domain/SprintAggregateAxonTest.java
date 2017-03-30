package org.synyx.campdemo.write.agileproject.domain;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.synyx.campdemo.write.agileproject.domain.command.CreateSprintCommand;
import org.synyx.campdemo.write.agileproject.domain.event.SprintCreatedEvent;


class SprintAggregateAxonTest {

    private FixtureConfiguration<SprintAggregate> fixtureConfiguration;

    @BeforeEach
    public void before() {

        fixtureConfiguration = new AggregateTestFixture<>(SprintAggregate.class);
    }


    @Test
    void createSprint() {

        CreateSprintCommand command = new CreateSprintCommand("id", "name");
        SprintCreatedEvent expected = new SprintCreatedEvent("id", "name");

        fixtureConfiguration.given().when(command).expectEvents(expected);
    }
}
