package com.example.test_project_sec.data.service.Impl;

import com.example.test_project_sec.data.dto.ProductDTO;
import com.example.test_project_sec.data.entity.ProductEntity;
import com.example.test_project_sec.data.handler.ProductDataHandler;
import com.example.test_project_sec.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Service
@EnableWebMvc
public class ProductServiceImpl implements ProductService {
    ProductDataHandler productDataHandeler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler){
        this.productDataHandeler = productDataHandler;
    }


    @Override
    public ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock){
        ProductEntity productEntity = productDataHandeler.saveProductEntity(productId, productName, productPrice, productStock);

        ProductDTO productDTO = new ProductDTO(productEntity.getProductId(), productEntity.getProductName(),
                productEntity.getProductPrice(), productEntity.getProductStocks());
        return productDTO;
    }

    @Override
    public ProductDTO getProduct(String productId){
        ProductEntity productEntity = productDataHandeler.getProductEntity(productId);

        ProductDTO productDTO = new ProductDTO(productEntity.getProductId(), productEntity.getProductName(),
                productEntity.getProductPrice(), productEntity.getProductStocks());
        return productDTO;
    }

}
