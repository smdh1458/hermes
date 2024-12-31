package com.hermes.hermes.service;

import com.hermes.hermes.dto.Product;
import com.hermes.hermes.dto.User;
import com.hermes.hermes.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    // ProductMapper 주입
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Product getIndexProduct(int product_reg_num) { // product_reg_num 에 해당하는 값 하나 가져오기
        Product product = productMapper.getIndexProduct(product_reg_num);
        return product;
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