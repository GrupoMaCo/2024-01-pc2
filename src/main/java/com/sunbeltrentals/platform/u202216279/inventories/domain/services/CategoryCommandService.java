package com.sunbeltrentals.platform.u202216279.inventories.domain.services;

import com.sunbeltrentals.platform.u202216279.inventories.domain.model.aggregates.Category;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.commands.CreateCategoryCommand;

import java.util.Optional;

public interface CategoryCommandService {
    Optional<Category> handle(CreateCategoryCommand createCategoryCommand);
}
