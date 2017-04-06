package org.synyx.campdemo.write.agileproject.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author  David Schilling - schilling@synyx.de
 */
public class BacklogItemDto {

    public String name;

    @JsonCreator
    public BacklogItemDto(@JsonProperty("name") String name) {

        this.name = name;
    }
}
