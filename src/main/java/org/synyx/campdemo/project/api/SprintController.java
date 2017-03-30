package org.synyx.campdemo.project.api;

import org.axonframework.commandhandling.gateway.CommandGateway;

import org.axonframework.common.IdentifierFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.synyx.campdemo.project.domain.command.CreateSprintCommand;

import java.net.URI;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;


@RestController
@RequestMapping("/sprints")
public class SprintController {

    private final CommandGateway commandGateway;

    @Autowired
    public SprintController(CommandGateway commandGateway) {

        this.commandGateway = commandGateway;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(String name) {

        String identifier = IdentifierFactory.getInstance().generateIdentifier();
        CreateSprintCommand command = new CreateSprintCommand(identifier, name);
        commandGateway.sendAndWait(command);

        URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(identifier).toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }
}
