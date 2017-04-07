package org.synyx.campdemo.write.agileproject.domain.event;


public class BacklogItemCommitEvent {

    private final String sprintidentifier;

    private final String backlogItemidentifier;

    public BacklogItemCommitEvent(String sprintidentifier, String backlogItemidentifier) {
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
