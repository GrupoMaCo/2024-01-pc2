package com.sunbeltrentals.platform.u202216279.inventories.application.internal.eventhandlers;

import com.sunbeltrentals.platform.u202216279.inventories.domain.model.commands.PopulateGroupTableCommand;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.entitites.Group;
import com.sunbeltrentals.platform.u202216279.inventories.infrastructure.persistance.jpa.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationReadyEventHandler {

    private static final List<PopulateGroupTableCommand> INITIAL_BUSINESSES = List.of(
            new PopulateGroupTableCommand(1L, "Forestry"),
            new PopulateGroupTableCommand(2L, "Farming"),
            new PopulateGroupTableCommand(3L, "Livestock")
    );

    @Autowired
    private GroupRepository groupRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void populateBusinessTable() {
        for (PopulateGroupTableCommand command : INITIAL_BUSINESSES) {
            if (!groupRepository.existsByName(command.getName())) {
                Group group = new Group();
                group.setName(command.getName());
                groupRepository.save(group);
            }
        }
    }
}