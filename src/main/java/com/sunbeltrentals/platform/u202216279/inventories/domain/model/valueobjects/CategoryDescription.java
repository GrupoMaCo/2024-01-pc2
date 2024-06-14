package com.sunbeltrentals.platform.u202216279.inventories.domain.model.valueobjects;

public record CategoryDescription(String description){
    public CategoryDescription {
        if(description == null || description.isBlank()){
            throw new IllegalArgumentException("The description is required.");
        }
        if(description.length() > 360){
            throw new IllegalArgumentException("The description cannot be longer than 360 characters.");
        }
    }
    public String getDescription(){
        return description;
    }
}