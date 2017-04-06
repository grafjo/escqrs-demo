package org.synyx.campdemo.read.agileproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * @author  David Schilling - schilling@synyx.de
 */
@Entity
public class Sprint {

    @Id
    private String identifier;
    private String name;

    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BacklogItem> backlogItems = new ArrayList<>();

    protected Sprint() {
    }


    public Sprint(String identifier, String name) {

        this.identifier = identifier;
        this.name = name;
    }

    public String getIdentifier() {

        return identifier;
    }


    public String getName() {

        return name;
    }


    @JsonIgnore
    public List<BacklogItem> getBacklogItems() {

        return backlogItems;
    }


    void addBacklogItem(BacklogItem backlogItem) {

        backlogItems.add(backlogItem);
        backlogItem.setSprint(this);
    }
}
