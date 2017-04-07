package org.synyx.campdemo.read.agileproject.eventlistener;

import org.axonframework.eventhandling.EventHandler;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import org.synyx.campdemo.read.agileproject.domain.SprintService;
import org.synyx.campdemo.write.agileproject.domain.event.BacklogItemCommitEvent;
import org.synyx.campdemo.write.agileproject.domain.event.SprintCreatedEvent;


/**
 * @author  David Schilling - schilling@synyx.de
 */
@Component
public class SprintEventListener {

    private final SprintService sprintService;

    @Autowired
    public SprintEventListener(SprintService sprintService) {

        this.sprintService = sprintService;
    }

    @EventHandler
    public void handle(SprintCreatedEvent event) {

        sprintService.create(event.getIdentifier(), event.getName());
    }

    @EventHandler
    public void handle(BacklogItemCommitEvent event) {

        sprintService.commit(event.getSprintidentifier(), event.getBacklogItemidentifier());
    }
}
