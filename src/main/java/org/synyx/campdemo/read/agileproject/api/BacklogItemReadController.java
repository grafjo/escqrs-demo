package org.synyx.campdemo.read.agileproject.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.synyx.campdemo.read.agileproject.domain.BacklogItem;
import org.synyx.campdemo.read.agileproject.domain.BacklogItemService;


/**
 * @author  David Schilling - schilling@synyx.de
 */
@RestController
public class BacklogItemReadController {

    private final BacklogItemService backlogItemService;

    public BacklogItemReadController(BacklogItemService backlogItemService) {

        this.backlogItemService = backlogItemService;
    }

    @RequestMapping(value = "/backlogitems/{id}", method = RequestMethod.GET)
    public BacklogItem backlogItem(@PathVariable("id") String id) {

        return backlogItemService.get(id);
    }
}
