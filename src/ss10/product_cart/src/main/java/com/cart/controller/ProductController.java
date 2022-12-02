package com.cart.controller;

import com.cart.dto.CartDto;
import com.cart.dto.ProductDto;
import com.cart.model.Product;
import com.cart.repository.IProductRepository;
import com.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/product")
@SessionAttributes("/cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") CartDto cartDto){
        Optional<Product> product = productService.finById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(), productDto);
        cartDto.addProduct(productDto);

        return "redirect:/cart";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", String.valueOf(id));
        cookie.setMaxAge(60);
        cookie.setPath("/");
        response.addCookie(cookie);

        Optional<Product> product = productService.finById(id);
        if (product.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(), productDto);
            model.addAttribute("product", productDto);
        }
        return "views/details";
    }

    @GetMapping
    public String listProduct(Model model, @CookieValue(value = "idProduct", defaultValue = "-1")
            Long id) {

        Optional<Product> product = productService.finById(id);
        if (product.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(), productDto);
            model.addAttribute("historyProduct", productDto);
        }

        model.addAttribute("products", productService.finAll());
        return "views/list";
    }

}
