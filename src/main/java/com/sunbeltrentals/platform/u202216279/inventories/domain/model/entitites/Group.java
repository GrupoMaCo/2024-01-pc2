package com.sunbeltrentals.platform.u202216279.inventories.domain.model.entitites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }


    public Long getGroupId(){
        return id;
    }
}