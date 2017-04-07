package org.synyx.campdemo.write.agileproject.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/backlogitems")
public class BacklogItemWriteController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody BacklogItemDto backlogItem) {

        throw new UnsupportedOperationException("Here is something missing. Fix it!");
    }


    @RequestMapping(value = "/{id}/commitment", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void commit(@PathVariable("id") String backlogItemIdentifier, @RequestBody CommitmentDto commitment) {

        throw new UnsupportedOperationException("Here is something missing. Fix it!");
    }
}
