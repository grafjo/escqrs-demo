package org.synyx.campdemo.read.agileproject.domain;

/**
 * @author  David Schilling - schilling@synyx.de
 */
public interface BacklogItemService {

    void create(String identifier, String name);


    BacklogItem get(String id);
}
