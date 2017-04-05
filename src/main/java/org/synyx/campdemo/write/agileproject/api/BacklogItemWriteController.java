package org.synyx.campdemo.write.agileproject.api;

import org.axonframework.commandhandling.gateway.CommandGateway;

import org.axonframework.common.IdentifierFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.synyx.campdemo.write.agileproject.domain.command.AssignBacklogItemCommand;
import org.synyx.campdemo.write.agileproject.domain.command.CreateBacklogItemCommand;

import java.net.URI;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;


@RestController
@RequestMapping("/backlogitems")
public class BacklogItemWriteController {

    private final CommandGateway commandGateway;

    @Autowired
    public BacklogItemWriteController(CommandGateway commandGateway) {

        this.commandGateway = commandGateway;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(String name) {

        String identifier = IdentifierFactory.getInstance().generateIdentifier();
        CreateBacklogItemCommand command = new CreateBacklogItemCommand(identifier, name);
        commandGateway.sendAndWait(command);

        URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(identifier).toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}/commitment", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void assignToSprint(@PathVariable("id") String backlogItemIdentifier, String sprintIdentifier) {

        commandGateway.sendAndWait(new AssignBacklogItemCommand(backlogItemIdentifier, sprintIdentifier));
    }
}