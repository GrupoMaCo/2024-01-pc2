package com.sunbeltrentals.platform.u202216279.inventories.domain.model.commands;

public record CreateCategoryCommand
        (
        Long groupId,
        String name,
        String description,
        String referenceImageUrl
        ) {}
