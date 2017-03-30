package org.synyx.campdemo.project.domain.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;


public final class AssignBacklogItemCommand {

    @TargetAggregateIdentifier
    private final String backlogItemIdentifier;
    private final String sprintIdentifier;

    public AssignBacklogItemCommand(String backlogItemIdentifier, String sprintIdentifier) {

        this.backlogItemIdentifier = backlogItemIdentifier;
        this.sprintIdentifier = sprintIdentifier;
    }

    public String getBacklogItemIdentifier() {

        return backlogItemIdentifier;
    }


    public String getSprintIdentifier() {

        return sprintIdentifier;
    }
}
