package com.example.test_project_sec.data.dao;

import com.example.test_project_sec.data.entity.ProductEntity;
public interface ProductDAO {
    ProductEntity  saveProduct(ProductEntity productEntity);
    ProductEntity getProduct (String productId);
}
