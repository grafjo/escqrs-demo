package org.synyx.campdemo.project.domain.event;

public final class SprintCreatedEvent {

    private final String identifier;
    private final String name;

    public SprintCreatedEvent(String identifier, String name) {

        this.identifier = identifier;
        this.name = name;
    }

    public String getIdentifier() {

        return identifier;
    }


    public String getName() {

        return name;
    }
}
