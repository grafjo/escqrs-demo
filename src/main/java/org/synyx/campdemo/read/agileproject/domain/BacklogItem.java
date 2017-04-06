package org.synyx.campdemo.read.agileproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * @author  David Schilling - schilling@synyx.de
 */
@Entity
public class BacklogItem {

    @Id
    private String identifier;
    private String name;
    private Integer storyPoints;

    @ManyToOne
    private Sprint sprint;

    public BacklogItem(String identifier, String name) {

        this.identifier = identifier;
        this.name = name;
    }


    public BacklogItem() {
    }

    public String getIdentifier() {

        return identifier;
    }


    public String getName() {

        return name;
    }


    public Integer getStoryPoints() {

        return storyPoints;
    }


    @JsonIgnore
    public Sprint getSprint() {

        return sprint;
    }


    public void setIdentifier(String identifier) {

        this.identifier = identifier;
    }


    public void setName(String name) {

        this.name = name;
    }


    public void setStoryPoints(Integer storyPoints) {

        this.storyPoints = storyPoints;
    }


    public void setSprint(Sprint sprint) {

        this.sprint = sprint;
    }
}
