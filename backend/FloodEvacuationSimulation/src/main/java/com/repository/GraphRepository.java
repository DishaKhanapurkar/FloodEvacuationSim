package com.repository;


import com.entity.GraphEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphRepository extends JpaRepository<GraphEntity, Long> {
    // No code needed here
}
