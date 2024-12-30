package com.hermes.hermes.controller;
import com.hermes.hermes.dto.Product;
import com.hermes.hermes.service.ProductService;
import org.springframework.ui.Model;
import com.hermes.hermes.dto.User;
import com.hermes.hermes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;


    @GetMapping("/{product_reg_num}")
    public String index(@PathVariable int product_reg_num, Model model) {
        Product product = productService.getProduct(product_reg_num);
        model.addAttribute("product", product);
        return "index";
    }

    @GetMapping("/Signup")
    public String signup() {
        return "signup";
    }
    @PostMapping("/Signup-success")
    public String signupSuccess(@ModelAttribute User user, Model model) {
        userService.insertUser(user);
        model.addAttribute("msg","회원가입이 성공적으로 완료되었습니다.");
        return "success";
    }
    @GetMapping("/Category_Page")
    public String CategoryPage() {
        return "category_Page";
    }

}