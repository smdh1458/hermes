package com.hermes.hermes.controller;
import com.hermes.hermes.dto.Product;
import com.hermes.hermes.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ProductService productService;


    /**
     * List<Product>  products   =   productService.getAllIndexProducts(); //productService 에 있는 getAllIndexProducts 가져오기
     * @param model html에 보내기 위한 model
     * @return index.html 페이지에 products로 불러온 모든 제품리스트를 전달
     */
    @GetMapping("/")
    public String index( Model model) {
        List<Product>  products   =   productService.getAllIndexProducts();
        model.addAttribute("products", products);
        return "index";
    }
    /*
    @GetMapping("/")
    public String index(HttpSession session, Model model) {  -->  Model model1 모델하나 더 추가하면 전체 리스트도 보낼 수 있음
        Object user = session.getAttribute("loggedInUser");
        model.addAttribute("loggedInUser", user);

        List<Product> products = productService.getAllIndexProducts();
        List<Product> recommendedProducts = products.stream()
                .limit(6)
                .toList();
        model.addAttribute("products", recommendedProducts);
        System.out.println(recommendedProducts);
        model1.addAttribute("allProducts", products); --> 이건 전체 리스트 보낼때만 사용
        return "index";
    }
    */

    /**
     * @param product_category 카테고리에 해당하는 리스트만 가져오기 위해 카테고리 변수 문자열로 선언
     * @param model html thymeleaf 에 보내기 위한 model
     * List<Product>  products   =   productService.getCategoryList(product_category); //productService 에 있는 getCategoryList 가져오기
     * @return category_page.html 페이지에 카테고리별 해당 상품 리스트를 전달
     */
    @GetMapping("/category_page/{product_category}")
    public String CategoryPage(@PathVariable String product_category, Model model) {
        List<Product>  products   =   productService.getCategoryList(product_category);
        model.addAttribute("products", products);
        return "category_page";
    }
}