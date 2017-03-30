package org.synyx.campdemo.read.agileproject.domain;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author  David Schilling - schilling@synyx.de
 */
@Service
public class SprintServiceImpl implements SprintService {

    private SprintRepository sprintRepository;

    @Autowired
    public SprintServiceImpl(SprintRepository sprintRepository) {

        this.sprintRepository = sprintRepository;
    }

    @Override
    public void create(String identifier, String name) {

        sprintRepository.save(new Sprint(identifier, name));
    }


    @Override
    public Sprint get(String identifier) {

        return sprintRepository.findOne(identifier);
    }


    @Override
    public List<BacklogItem> backlogItems(String identifier) {

        return get(identifier).getBacklogItems();
    }
}
