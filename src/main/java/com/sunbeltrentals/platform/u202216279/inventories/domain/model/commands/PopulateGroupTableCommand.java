package com.sunbeltrentals.platform.u202216279.inventories.domain.model.commands;

public class PopulateGroupTableCommand {
    private final Long id;
    private final String name;

    public PopulateGroupTableCommand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
