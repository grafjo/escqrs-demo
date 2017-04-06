package org.synyx.campdemo.read.agileproject.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.synyx.campdemo.read.agileproject.domain.BacklogItem;
import org.synyx.campdemo.read.agileproject.domain.Sprint;
import org.synyx.campdemo.read.agileproject.domain.SprintService;

import java.util.List;


/**
 * @author  David Schilling - schilling@synyx.de
 */
@RestController
public class SprintReadController {

    private final SprintService sprintService;

    @Autowired
    public SprintReadController(SprintService sprintService) {

        this.sprintService = sprintService;
    }

    @RequestMapping(value = "/sprints/{id}", method = RequestMethod.GET)
    public Sprint sprint(@PathVariable("id") String id) {

        return sprintService.get(id);
    }


    @RequestMapping(value = "/sprints/{id}/backlogitems", method = RequestMethod.GET)
    public List<BacklogItem> backlogItems(@PathVariable("id") String identifier) {

        return sprintService.backlogItems(identifier);
    }
}
