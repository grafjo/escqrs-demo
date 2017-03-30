package org.synyx.campdemo.write.agileproject.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author  David Schilling - schilling@synyx.de
 */
public class CreateSprintDto {

    public String name;

    @JsonCreator
    public CreateSprintDto(@JsonProperty("name") String name) {

        this.name = name;
    }
}
