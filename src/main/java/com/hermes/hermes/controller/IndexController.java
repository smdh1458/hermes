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
    public String index(@PathVariable int product_reg_num, Model model) {
        // 1. product_reg_num 제품 번호에 해당하는 제품이름 ~ 이미지 등 가져와서 보여주기 = 1개의 상품만 들어있음
        Product product = productService.getProduct(product_reg_num);
        System.out.println(product);
        model.addAttribute("product", product);

        // 2. 제품 테이블에 있는 모든 제품 가지고 오기
        List<Product>  products   =   productService.getAllProducts();
        System.out.println("-- product table all --");
        System.out.println(products);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/category_page/{product_category}")
    public String CategoryPage(@PathVariable String product_category, Model model) {
        List<Product>  products   =   productService.getAllProducts();
        System.out.println("-- product table all --");
        System.out.println(products);
        model.addAttribute("products", products);
        return "category_page";
    }

}