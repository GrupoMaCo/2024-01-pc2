package com.sunbeltrentals.platform.u202216279.inventories.interfaces.rest.resources;

public record CreateCategoryResource(
        Long groupId,
        String name,
        String description,
        String referenceImageUrl
) {
}
