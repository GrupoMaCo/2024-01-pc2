package com.sunbeltrentals.platform.u202216279.inventories.domain.exceptions;

public class GroupNotFoundException extends RuntimeException{
public GroupNotFoundException(Long aLong) {
        super("Group with id " + aLong + " not found");
    }
}
