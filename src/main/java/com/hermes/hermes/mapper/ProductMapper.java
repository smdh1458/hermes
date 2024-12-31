package com.hermes.hermes.mapper;

import com.hermes.hermes.dto.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    // index 페이지 메인 이미지 하나 가져오기
    Product getIndexProduct(@Param("product_reg_num") int product_reg_num);

    // 모든 상품 목록 조회
    List<Product> getAllIndexProducts();

    // 카테고리에 쓸 정보 리스트로 가져오기
    List<Product> getCategoryList(String productCategory);
}
