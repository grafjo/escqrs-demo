package org.synyx.campdemo.write.agileproject.domain.command;


import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CommitBacklogItemCommand {

    private final String sprintidentifier;

    @TargetAggregateIdentifier
    private final String backlogItemidentifier;

    public CommitBacklogItemCommand(String sprintidentifier, String backlogItemidentifier) {
        this.sprintidentifier = sprintidentifier;
        this.backlogItemidentifier = backlogItemidentifier;
    }

    public String getSprintidentifier() {
        return sprintidentifier;
    }

    public String getBacklogItemidentifier() {
        return backlogItemidentifier;
    }
}
