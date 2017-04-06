package org.synyx.campdemo.read.agileproject.domain;

import org.springframework.stereotype.Service;


/**
 * @author  David Schilling - schilling@synyx.de
 */
@Service
public class BacklogItemServiceImpl implements BacklogItemService {

    private final BacklogItemRepository backlogItemRepository;

    public BacklogItemServiceImpl(BacklogItemRepository backlogItemRepository) {

        this.backlogItemRepository = backlogItemRepository;
    }

    @Override
    public void create(String identifier, String name) {

        backlogItemRepository.save(new BacklogItem(identifier, name));
    }


    @Override
    public BacklogItem get(String id) {

        return backlogItemRepository.findOne(id);
    }
}
