package com.example.test_project_sec.data.service;

import com.example.test_project_sec.data.dto.ProductDTO;

public interface ProductService {
    ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock);

    ProductDTO getProduct(String productId);
}
