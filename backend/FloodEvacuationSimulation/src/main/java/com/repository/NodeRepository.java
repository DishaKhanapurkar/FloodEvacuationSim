package com.repository;
import com.entity.NodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends JpaRepository<NodeEntity, Integer> {
    // Spring Data JPA provides all CRUD operations automatically
}
