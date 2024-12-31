package com.hermes.hermes.service;

import com.hermes.hermes.dto.Product;
import com.hermes.hermes.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    // ProductMapper 주입
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getAllIndexProducts() {
        // 모든 상품 목록 조회
        return productMapper.getAllIndexProducts();
    }

    // product_category으로 값을 받아서 productMapper에 getCategoryList로 return하기
    @Override
    public List<Product> getCategoryList(String product_category){
        return productMapper.getCategoryList(product_category);
    }
}