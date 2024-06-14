package com.sunbeltrentals.platform.u202216279.inventories.domain.model.valueobjects;

public record CategoryName(String name) {
    public CategoryName {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("The name is required.");
        }
        if(name.length() > 50){
            throw new IllegalArgumentException("The name cannot be longer than 50 characters.");
        }
    }
    public String getCategoryName(){
        return name;
    }
}