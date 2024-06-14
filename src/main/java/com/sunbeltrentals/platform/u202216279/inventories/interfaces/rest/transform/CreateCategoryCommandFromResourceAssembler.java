package com.sunbeltrentals.platform.u202216279.inventories.interfaces.rest.transform;

import com.sunbeltrentals.platform.u202216279.inventories.domain.model.commands.CreateCategoryCommand;
import com.sunbeltrentals.platform.u202216279.inventories.interfaces.rest.resources.CreateCategoryResource;

public class CreateCategoryCommandFromResourceAssembler {
    public static CreateCategoryCommand toCommandFromResource(CreateCategoryResource resource){
        return new CreateCategoryCommand(
                resource.groupId(),
                resource.name(),
                resource.description(),
                resource.referenceImageUrl()
        );
    }
}
