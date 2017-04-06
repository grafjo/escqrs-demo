package org.synyx.campdemo.write.agileproject.domain;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

import org.synyx.campdemo.write.agileproject.RepositoryFacade;
import org.synyx.campdemo.write.agileproject.domain.command.CommitBacklogItemCommand;
import org.synyx.campdemo.write.agileproject.domain.command.CreateBacklogItemCommand;
import org.synyx.campdemo.write.agileproject.domain.event.BacklogItemCommittedEvent;
import org.synyx.campdemo.write.agileproject.domain.event.BacklogItemCreatedEvent;
import org.synyx.campdemo.write.agileproject.domain.event.BacklogItemUncommittedEvent;


public class BacklogItemAggregateAxonTest {

    private FixtureConfiguration<BacklogItemAggregate> fixtureConfiguration;
    private RepositoryFacade repositoryFacade;

    @Before
    public void before() {

        repositoryFacade = Mockito.mock(RepositoryFacade.class);

        fixtureConfiguration = new AggregateTestFixture<>(BacklogItemAggregate.class);
        fixtureConfiguration.registerInjectableResource(repositoryFacade);
    }


    @Test
    public void createBacklogItem() {

        CreateBacklogItemCommand command = new CreateBacklogItemCommand("id", "name");
        BacklogItemCreatedEvent expected = new BacklogItemCreatedEvent("id", "name");

        fixtureConfiguration.given().when(command).expectEvents(expected);
    }


    @Test
    public void commitBacklogItem() {

        BacklogItemCreatedEvent created = new BacklogItemCreatedEvent("id", "name");
        CommitBacklogItemCommand command = new CommitBacklogItemCommand("id", "id-sprint");
        BacklogItemCommittedEvent expected = new BacklogItemCommittedEvent("id", "id-sprint");

        fixtureConfiguration.given(created).when(command).expectEvents(expected);

        Mockito.verify(repositoryFacade).loadSprintAggregate("id-sprint");
    }


    @Test
    public void commitAlreadyCommittedBacklogItem() {

        BacklogItemCreatedEvent created = new BacklogItemCreatedEvent("id", "name");
        BacklogItemCommittedEvent committed = new BacklogItemCommittedEvent("id", "id-sprint");
        CommitBacklogItemCommand command = new CommitBacklogItemCommand("id", "id-new-sprint");

        fixtureConfiguration.given(created, committed)
            .when(command)
            .expectEvents(new BacklogItemUncommittedEvent("id", "id-sprint"),
                new BacklogItemCommittedEvent("id", "id-new-sprint"));

        Mockito.verify(repositoryFacade).loadSprintAggregate("id-new-sprint");
    }
}
