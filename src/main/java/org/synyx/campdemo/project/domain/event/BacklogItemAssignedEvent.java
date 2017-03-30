package org.synyx.campdemo.project.domain.event;

public final class BacklogItemAssignedEvent {

    private final String backlogItemIdentifier;
    private final String sprintIdentifier;

    public BacklogItemAssignedEvent(String backlogItemIdentifier, String sprintIdentifier) {

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
