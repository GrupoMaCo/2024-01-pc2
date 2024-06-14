package com.sunbeltrentals.platform.u202216279.inventories.domain.model.aggregates;

import com.sunbeltrentals.platform.u202216279.inventories.domain.model.commands.CreateCategoryCommand;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.entitites.Group;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.valueobjects.CategoryName;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.valueobjects.CategoryDescription;
import com.sunbeltrentals.platform.u202216279.inventories.domain.model.valueobjects.CategoryReferenceImageUrl;
import com.sunbeltrentals.platform.u202216279.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Category extends AuditableAbstractAggregateRoot<Category> {
    @Embedded
    @NotNull(message="Name is mandatory")
    private CategoryName categoryName;

    @Embedded
    @NotNull(message="Description is mandatory")
    private CategoryDescription categoryDescription;

    @Embedded
    @NotNull(message="Reference Image URL is mandatory")
    private CategoryReferenceImageUrl categoryReferenceImageUrl;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @NotNull(message = "GroupId is mandatory")
    private Group groupId;

    protected Category() {
    }

    public Category(CreateCategoryCommand command, Group group){
        this.groupId = group;
        this.categoryName = new CategoryName(command.name());
        this.categoryDescription = new CategoryDescription(command.description());
        this.categoryReferenceImageUrl = new CategoryReferenceImageUrl(command.referenceImageUrl());
    }

    public Long getGroupId(){
        return groupId.getGroupId();
    }

    public String getCategoryName() {
        return categoryName.getCategoryName();
    }

    public String getCategoryDescription() {
        return categoryDescription.getDescription();
    }

    public String getCategoryReferenceImageUrl() {
        return categoryReferenceImageUrl.getReferenceImageUrl();
    }
}