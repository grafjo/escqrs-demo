package org.synyx.campdemo.write.agileproject.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author  David Schilling - schilling@synyx.de
 */
public class CommitmentDto {

    public String sprintIdentifier;

    @JsonCreator
    public CommitmentDto(@JsonProperty("name") String sprintIdentifier) {

        this.sprintIdentifier = sprintIdentifier;
    }
}
