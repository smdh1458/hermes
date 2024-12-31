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


    @GetMapping("/")
    public String index( Model model) {
        // 제품 테이블에 있는 모든 제품 가지고 오기
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