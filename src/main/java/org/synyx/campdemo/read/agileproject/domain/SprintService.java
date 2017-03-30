package org.synyx.campdemo.read.agileproject.domain;

import java.util.List;


/**
 * @author  David Schilling - schilling@synyx.de
 */
public interface SprintService {

    void create(String identifier, String name);


    Sprint get(String identifier);


    List<BacklogItem> backlogItems(String identifier);
}
