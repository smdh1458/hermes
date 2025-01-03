package com.hermes.hermes.service;

import com.hermes.hermes.dto.Product;
import com.hermes.hermes.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    /*
    @Autowired
    private ProductMapper productMapper;

    아래와 같이 작성한 기능 속성 및 생성자 명칭을 위  @Autowired로 스프링부트에서 객체를 관리할 수 있도록 사용할 수 있음

    // ProductMapper 주입
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    */

    @Autowired
    private ProductMapper productMapper;

    // 모든 상품 목록 조회
    @Override
    public List<Product> getAllIndexProducts() {
        return productMapper.getAllIndexProducts();
    }

    // product_category으로 값을 받아서 productMapper에 getCategoryList로 return하기
    @Override
    public List<Product> getCategoryList(String product_category){
        return productMapper.getCategoryList(product_category);
    }
}