package org.synyx.campdemo.project.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;

import org.axonframework.eventsourcing.EventSourcingHandler;

import org.axonframework.spring.stereotype.Aggregate;

import org.synyx.campdemo.project.RepositoryFacade;
import org.synyx.campdemo.project.domain.command.AssignBacklogItemCommand;
import org.synyx.campdemo.project.domain.command.CreateBacklogItemCommand;
import org.synyx.campdemo.project.domain.event.BacklogItemAssignedEvent;
import org.synyx.campdemo.project.domain.event.BacklogItemCreatedEvent;


@Aggregate
public class BacklogItemAggregate {

    @AggregateIdentifier
    private String identifier;
    private String sprintIdentifier;

    BacklogItemAggregate() {

        // no-arg constructor required by Axon
    }


    @CommandHandler
    public BacklogItemAggregate(CreateBacklogItemCommand command) {

        AggregateLifecycle.apply(new BacklogItemCreatedEvent(command.getIdentifier(), command.getName()));
    }

    @EventSourcingHandler
    private void handle(BacklogItemCreatedEvent event) {

        this.identifier = event.getIdentifier();
    }


    @CommandHandler
    public void assign(AssignBacklogItemCommand command, RepositoryFacade repositoryFacade) {

        String sprintIdentifier = command.getSprintIdentifier();
        repositoryFacade.loadSprintAggregate(sprintIdentifier); // fails if sprint does not exist

        String backlogItemIdentifier = command.getBacklogItemIdentifier();
        AggregateLifecycle.apply(new BacklogItemAssignedEvent(backlogItemIdentifier, sprintIdentifier));
    }


    @EventSourcingHandler
    private void handle(BacklogItemAssignedEvent event) {

        this.sprintIdentifier = event.getSprintIdentifier();
    }
}
