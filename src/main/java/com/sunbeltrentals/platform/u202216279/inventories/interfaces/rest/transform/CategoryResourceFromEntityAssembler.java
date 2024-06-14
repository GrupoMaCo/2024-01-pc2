package com.sunbeltrentals.platform.u202216279.inventories.interfaces.rest.transform;

import com.sunbeltrentals.platform.u202216279.inventories.domain.model.aggregates.Category;
import com.sunbeltrentals.platform.u202216279.inventories.interfaces.rest.resources.CategoryResource;

public class CategoryResourceFromEntityAssembler {
    public static CategoryResource toResourceFromEntity(Category entity){
        return new CategoryResource(
                entity.getId(),
                entity.getGroupId(),
                entity.getCategoryName(),
                entity.getCategoryDescription(),
                entity.getCategoryReferenceImageUrl()
        );
    }
}
