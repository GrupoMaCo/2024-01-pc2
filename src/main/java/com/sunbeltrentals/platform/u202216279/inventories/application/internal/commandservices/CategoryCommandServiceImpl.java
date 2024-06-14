package com.sunbeltrentals.platform.u202216279.inventories.application.internal.commandservices;


import com.sunbeltrentals.platform.u202216279.inventories.domain.exceptions.GroupNotFoundException;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.aggregates.Category;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.commands.CreateCategoryCommand;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.entitites.Group;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.valueobjects.CategoryName;
import com.sunbeltrentals.platform.u202216279.inventories.domain.services.CategoryCommandService;
import com.sunbeltrentals.platform.u202216279.inventories.infrastructure.persistance.jpa.repositories.CategoryRepository;
import com.sunbeltrentals.platform.u202216279.inventories.infrastructure.persistance.jpa.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryCommandServiceImpl implements CategoryCommandService{
    private final CategoryRepository categoryRepository;
    private final GroupRepository groupRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository, GroupRepository groupRepository) {
        this.categoryRepository = categoryRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public Optional<Category> handle(CreateCategoryCommand command) {
        Group group = groupRepository.findById(command.groupId())
                .orElseThrow(() -> new GroupNotFoundException(command.groupId()));

        var name = new CategoryName(command.name());
        categoryRepository.findByCategoryName(name).ifPresent(category ->{
            throw new IllegalArgumentException("Category with name " + name + " already exists");
        });

        var category = new Category(command, group);
        categoryRepository.save(category);
        return Optional.of(category);
    }
}
