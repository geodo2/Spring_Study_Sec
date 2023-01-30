package com.example.test_project_sec.data.handler;

import com.example.test_project_sec.data.entity.ProductEntity;

public interface ProductDataHandler {
    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);

    ProductEntity getProductEntity(String productId);

}
