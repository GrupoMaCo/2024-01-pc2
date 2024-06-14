package com.sunbeltrentals.platform.u202216279.inventories.interfaces.rest;

import com.sunbeltrentals.platform.u202216279.inventories.domain.model.queries.GetAllCategoryQuery;
import com.sunbeltrentals.platform.u202216279.inventories.domain.services.CategoryCommandService;
import com.sunbeltrentals.platform.u202216279.inventories.domain.services.CategoryQueryService;
import com.sunbeltrentals.platform.u202216279.inventories.interfaces.rest.resources.CategoryResource;
import com.sunbeltrentals.platform.u202216279.inventories.interfaces.rest.resources.CreateCategoryResource;
import com.sunbeltrentals.platform.u202216279.inventories.interfaces.rest.transform.CategoryResourceFromEntityAssembler;
import com.sunbeltrentals.platform.u202216279.inventories.interfaces.rest.transform.CreateCategoryCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/categories", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Categories", description = "Categories Management Endpoints")
public class CategoriesController {

    private final CategoryQueryService categoryQueryService;
    private final CategoryCommandService categoryCommandService;

    public CategoriesController(CategoryQueryService categoryQueryService, CategoryCommandService categoryCommandService) {
        this.categoryQueryService = categoryQueryService;
        this.categoryCommandService = categoryCommandService;
    }

    @Operation(summary = "Create a new Category", description = "Create a new Category with the input data.")
    @PostMapping
    public ResponseEntity<CategoryResource> createCategory(@RequestBody CreateCategoryResource resource) {
        try {
            var createCategoryCommand = CreateCategoryCommandFromResourceAssembler.toCommandFromResource(resource);
            var category = categoryCommandService.handle(createCategoryCommand);
            var categoryResource = CategoryResourceFromEntityAssembler.toResourceFromEntity(category.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryResource); // 201
        } catch (IllegalArgumentException e) { // 400
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }

    @Operation(summary = "Get all categories", description = "Retrieves a List of all categories in the database.")
    @GetMapping
    public ResponseEntity<List<CategoryResource>> getAllCategories() {
        var getAllCategoriesQuery = new GetAllCategoryQuery();
        var categories = categoryQueryService.handle(getAllCategoriesQuery);
        var categoryResources = categories.stream()
                .map(CategoryResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categoryResources);
    }
}
