package com.sunbeltrentals.platform.u202216279.inventories.domain.model.valueobjects;

public record CategoryReferenceImageUrl(String referenceImageUrl) {
    public CategoryReferenceImageUrl {
        if(referenceImageUrl == null || referenceImageUrl.isBlank()){
            throw new IllegalArgumentException("The reference image url is required.");
        }
    }
    public String getReferenceImageUrl()  {return referenceImageUrl;}

}
