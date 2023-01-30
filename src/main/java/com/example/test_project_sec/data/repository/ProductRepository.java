package com.example.test_project_sec.data.repository;

import com.example.test_project_sec.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
