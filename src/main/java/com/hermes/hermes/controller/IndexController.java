package com.hermes.hermes.controller;
import com.hermes.hermes.dto.Product;
import com.hermes.hermes.service.ProductService;
import org.springframework.ui.Model;
import com.hermes.hermes.dto.User;
import com.hermes.hermes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;


    @GetMapping("/{product_reg_num}")
    public String index(@PathVariable int product_reg_num, Model model) { //product_reg_num 통해 값 넣기
        // 1. product_reg_num 제품 번호에 해당하는 제품이름 ~ 이미지 등 가져와서 보여주기 = 1개의 상품만 들어있음
        Product product = productService.getIndexProduct(product_reg_num); //productService 에 있는 getIndexProduct 에 product_reg_num 값을 넣어서 가져오기
        model.addAttribute("product", product); // html로 보내기

        // 2. 제품 테이블에 있는 모든 제품 가지고 오기
        List<Product>  products   =   productService.getAllIndexProducts(); //productService 에 있는 getAllIndexProducts 가져오기
        model.addAttribute("products", products); // html 로 보내기
        return "index";
    }

    @GetMapping("/category_page/{product_category}")
    public String CategoryPage(@PathVariable String product_category, Model model) { //product_category 값 넣기
        List<Product>  products   =   productService.getCategoryList(product_category); //productService 에 있는 getCategoryList 가져오기
        model.addAttribute("products", products); // html 로 보내기
        return "category_page";
    }

}