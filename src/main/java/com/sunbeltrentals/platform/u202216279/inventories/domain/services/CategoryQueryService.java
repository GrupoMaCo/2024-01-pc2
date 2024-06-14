package com.sunbeltrentals.platform.u202216279.inventories.domain.services;

import com.sunbeltrentals.platform.u202216279.inventories.domain.model.aggregates.Category;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.queries.GetAllCategoryQuery;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.queries.GetCategoryByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CategoryQueryService {
    Optional<Category> handle(GetCategoryByIdQuery query);
    List<Category> handle(GetAllCategoryQuery query);
}
