package com.sunbeltrentals.platform.u202216279.inventories.interfaces.rest.resources;

public record CategoryResource(
        Long id,
        Long groupId,
        String name,
        String description,
        String referenceImageUrl
) {
}
