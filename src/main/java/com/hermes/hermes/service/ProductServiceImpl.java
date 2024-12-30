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
    public Product getProduct(int product_reg_num) {
        Product product = productMapper.getProduct(product_reg_num);
        return product;
    }
    @Override
    public List<Product> getAllProducts() {
        // 모든 상품 목록 조회
        return productMapper.getAllProducts();
    }

    /*
    @Override
    public List<Map<String, Object>> getAllProducts() {
        List<Product> productList = productMapper.getAllProducts();
        return productList.stream().map(product -> {
            Map<String, Object> productMap = new HashMap<>();
            // product 객체에서 필요한 데이터를 맵에 추가
            productMap.put("product_image_path", product.getProduct_image_path());
            // 필요한 경우 추가적인 필드를 넣을 수 있습니다
            return productMap;
        }).collect(Collectors.toList());
    }*/

    @Override
    public List<Product> getProductsByCategory(String category) {
        // 카테고리별 상품 목록 조회
        return productMapper.getProductsByCategory(category);
    }

    @Override
    public void insertProduct(Product product) {
        // 상품 정보 등록
        productMapper.insertProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        // 상품 정보 수정
        productMapper.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
        // 상품 삭제
        productMapper.deleteProduct(productId);
    }


    @Override
    public String getProductImagePath(int productId) {
        Product product = productMapper.getProduct(productId);
        if (product != null) {
            return product.getProduct_image_path();
        }
        return null;
    }

}