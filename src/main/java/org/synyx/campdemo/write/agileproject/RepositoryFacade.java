package org.synyx.campdemo.write.agileproject;

import org.axonframework.commandhandling.model.Aggregate;

import org.axonframework.config.Configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import org.synyx.campdemo.write.agileproject.domain.SprintAggregate;


@Component
public class RepositoryFacade {

    @Autowired
    private final Configuration configuration;

    public RepositoryFacade(Configuration configuration) {

        this.configuration = configuration;
    }

    public Aggregate<SprintAggregate> loadSprintAggregate(String identifier) {

        return configuration.repository(SprintAggregate.class).load(identifier);
    }
}
