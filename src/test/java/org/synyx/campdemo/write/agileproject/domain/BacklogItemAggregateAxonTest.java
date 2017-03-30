package org.synyx.campdemo.write.agileproject.domain;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.synyx.campdemo.write.agileproject.RepositoryFacade;
import org.synyx.campdemo.write.agileproject.domain.command.AssignBacklogItemCommand;
import org.synyx.campdemo.write.agileproject.domain.command.CreateBacklogItemCommand;
import org.synyx.campdemo.write.agileproject.domain.event.BacklogItemAssignedEvent;
import org.synyx.campdemo.write.agileproject.domain.event.BacklogItemCreatedEvent;


class BacklogItemAggregateAxonTest {

    private FixtureConfiguration<BacklogItemAggregate> fixtureConfiguration;
    private RepositoryFacade repositoryFacade;

    @BeforeEach
    void before() {

        repositoryFacade = Mockito.mock(RepositoryFacade.class);

        fixtureConfiguration = new AggregateTestFixture<>(BacklogItemAggregate.class);
        fixtureConfiguration.registerInjectableResource(repositoryFacade);
    }


    @Test
    void createBacklogItem() {

        CreateBacklogItemCommand command = new CreateBacklogItemCommand("id", "name");
        BacklogItemCreatedEvent expected = new BacklogItemCreatedEvent("id", "name");

        fixtureConfiguration.given().when(command).expectEvents(expected);
    }


    @Test
    void assignBacklogItem() {

        BacklogItemCreatedEvent biCreatedEvent = new BacklogItemCreatedEvent("id-backlog-item", "name");
        AssignBacklogItemCommand command = new AssignBacklogItemCommand("id-backlog-item", "id-sprint");
        BacklogItemAssignedEvent expected = new BacklogItemAssignedEvent("id-backlog-item", "id-sprint");

        fixtureConfiguration.given(biCreatedEvent).when(command).expectEvents(expected);

        Mockito.verify(repositoryFacade).loadSprintAggregate("id-sprint");
    }
}
