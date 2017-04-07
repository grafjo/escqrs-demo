package org.synyx.campdemo.read.agileproject.eventlistener;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.synyx.campdemo.read.agileproject.domain.BacklogItemService;
import org.synyx.campdemo.write.agileproject.domain.event.BacklogItemCreatedEvent;

@Component
public class BacklogItemEventListener {

    private final BacklogItemService backlogItemService;

    @Autowired
    public BacklogItemEventListener(BacklogItemService backlogItemService) {
        this.backlogItemService = backlogItemService;
    }

    @EventHandler
    public void handle(BacklogItemCreatedEvent event) {

        backlogItemService.create(event.getIdentifier(), event.getName());
    }
}
