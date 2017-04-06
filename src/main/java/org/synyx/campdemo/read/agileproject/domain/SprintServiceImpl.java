package org.synyx.campdemo.read.agileproject.domain;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author  David Schilling - schilling@synyx.de
 */
@Service
public class SprintServiceImpl implements SprintService {

    private SprintRepository sprintRepository;
    private BacklogItemService backlogItemService;

    public SprintServiceImpl(SprintRepository sprintRepository, BacklogItemService backlogItemService) {

        this.sprintRepository = sprintRepository;
        this.backlogItemService = backlogItemService;
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


    @Override
    @Transactional
    public void commit(String sprintIdentifier, String backlogItemIdentifier) {

        BacklogItem backlogItem = backlogItemService.get(backlogItemIdentifier);
        Sprint sprint = get(sprintIdentifier);

        sprint.addBacklogItem(backlogItem);

        sprintRepository.save(sprint);
    }
}
