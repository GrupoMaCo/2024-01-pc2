package com.sunbeltrentals.platform.u202216279.inventories.infrastructure.persistance.jpa.repositories;

import com.sunbeltrentals.platform.u202216279.inventories.domain.model.aggregates.Category;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.valueobjects.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    Optional<Category> findByCategoryName(CategoryName categoryName);
}