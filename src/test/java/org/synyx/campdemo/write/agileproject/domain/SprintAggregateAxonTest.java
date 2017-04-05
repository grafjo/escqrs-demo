package org.synyx.campdemo.write.agileproject.domain;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;

import org.junit.Before;
import org.junit.Test;

import org.synyx.campdemo.write.agileproject.domain.command.CreateSprintCommand;
import org.synyx.campdemo.write.agileproject.domain.event.SprintCreatedEvent;


public class SprintAggregateAxonTest {

    private FixtureConfiguration<SprintAggregate> fixtureConfiguration;

    @Before
    public void before() {

        fixtureConfiguration = new AggregateTestFixture<>(SprintAggregate.class);
    }


    @Test
    public void createSprint() {

        CreateSprintCommand command = new CreateSprintCommand("id", "name");
        SprintCreatedEvent expected = new SprintCreatedEvent("id", "name");

        fixtureConfiguration.given().when(command).expectEvents(expected);
    }
}
