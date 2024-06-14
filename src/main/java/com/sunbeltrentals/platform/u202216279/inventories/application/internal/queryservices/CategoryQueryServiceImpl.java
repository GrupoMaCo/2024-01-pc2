package com.sunbeltrentals.platform.u202216279.inventories.application.internal.queryservices;

import com.sunbeltrentals.platform.u202216279.inventories.domain.model.aggregates.Category;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.queries.GetAllCategoryQuery;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.queries.GetCategoryByIdQuery;
import com.sunbeltrentals.platform.u202216279.inventories.domain.services.CategoryQueryService;
import com.sunbeltrentals.platform.u202216279.inventories.infrastructure.persistance.jpa.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryQueryServiceImpl implements CategoryQueryService {
    private final CategoryRepository categoryRepository;
    public CategoryQueryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> handle(GetCategoryByIdQuery query) {
        return categoryRepository.findById(query.id());
    }

    public List<Category> handle(GetAllCategoryQuery query) {
        return categoryRepository.findAll();
    }

}
