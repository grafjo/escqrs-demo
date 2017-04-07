package org.synyx.campdemo.write.agileproject.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.synyx.campdemo.write.agileproject.domain.command.CreateBacklogItemCommand;
import org.synyx.campdemo.write.agileproject.domain.event.BacklogItemCreatedEvent;

@Aggregate
public class BacklogItemAggregate {

    @AggregateIdentifier
    private String identifier;

    public BacklogItemAggregate() {
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
}
