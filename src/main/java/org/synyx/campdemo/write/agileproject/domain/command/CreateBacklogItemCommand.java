package org.synyx.campdemo.write.agileproject.domain.command;


public class CreateBacklogItemCommand {

    private final String identifier;
    private final String name;

    public CreateBacklogItemCommand(String identifier, String name) {
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
