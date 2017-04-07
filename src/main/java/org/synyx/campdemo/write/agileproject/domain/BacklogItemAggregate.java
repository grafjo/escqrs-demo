package org.synyx.campdemo.write.agileproject.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.synyx.campdemo.write.agileproject.domain.command.CommitBacklogItemCommand;
import org.synyx.campdemo.write.agileproject.domain.command.CreateBacklogItemCommand;
import org.synyx.campdemo.write.agileproject.domain.event.BacklogItemCreatedEvent;
import org.synyx.campdemo.write.agileproject.domain.event.BacklogItemCommitEvent;

@Aggregate
public class BacklogItemAggregate {

    @AggregateIdentifier
    private String identifier;
    private String sprintidentifier;

    public BacklogItemAggregate() {
        // no-arg constructor required by Axon
    }

    @CommandHandler
    public BacklogItemAggregate(CreateBacklogItemCommand command) {

        AggregateLifecycle.apply(new BacklogItemCreatedEvent(command.getIdentifier(), command.getName()));
    }

    @CommandHandler
    public void commit(CommitBacklogItemCommand command) {

        AggregateLifecycle.apply(new BacklogItemCommitEvent(command.getSprintidentifier(), command.getBacklogItemidentifier()));
    }

    @EventSourcingHandler
    private void handle(BacklogItemCreatedEvent event) {
        this.identifier = event.getIdentifier();
    }

    @EventSourcingHandler
    private void handle(BacklogItemCommitEvent event) {
        this.sprintidentifier = event.getSprintidentifier();
    }
}
