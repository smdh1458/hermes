package com.hermes.hermes.mapper;

import com.hermes.hermes.dto.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    // 상품 조회
    Product getProduct(@Param("product_reg_num") int product_reg_num);

    // 모든 상품 목록 조회
    List<Product> getAllProducts();

    // 카테고리별 상품 조회
    List<Product> getProductsByCategory(String category);

    //String getProductImagePath(int productId);

    List<Product> getCategoryList(String productCategory);
}
