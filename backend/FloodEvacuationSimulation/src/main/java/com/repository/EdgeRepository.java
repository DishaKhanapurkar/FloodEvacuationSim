package com.repository;


import com.entity.EdgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdgeRepository extends JpaRepository<EdgeEntity, Long> {
    // Spring Data JPA generates all CRUD methods automatically
}

