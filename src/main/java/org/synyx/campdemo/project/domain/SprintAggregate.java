package org.synyx.campdemo.project.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;

import org.axonframework.eventsourcing.EventSourcingHandler;

import org.axonframework.spring.stereotype.Aggregate;

import org.synyx.campdemo.project.domain.command.CreateSprintCommand;
import org.synyx.campdemo.project.domain.event.SprintCreatedEvent;


@Aggregate
public class SprintAggregate {

    @AggregateIdentifier
    private String identifier;

    SprintAggregate() {

        // no-arg constructor required by Axon
    }


    @CommandHandler
    public SprintAggregate(CreateSprintCommand command) {

        AggregateLifecycle.apply(new SprintCreatedEvent(command.getIdentifier(), command.getName()));
    }

    @EventSourcingHandler
    private void handle(SprintCreatedEvent event) {

        this.identifier = event.getIdentifier();
    }
}
