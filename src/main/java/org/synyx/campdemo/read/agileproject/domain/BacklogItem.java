package org.synyx.campdemo.read.agileproject.domain;

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
}
