package com.sunbeltrentals.platform.u202216279.inventories.infrastructure.persistance.jpa.repositories;

import com.sunbeltrentals.platform.u202216279.inventories.domain.model.entitites.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    boolean existsByName(String name);
}
