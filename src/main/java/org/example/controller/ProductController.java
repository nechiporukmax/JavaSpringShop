package org.example.controller;

import org.example.dao.ProductDao;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductDao productDao;
    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productDao.getProductList();
        model.addAttribute("products", products);
        return "productList";
    }
        @RequestMapping("/productList/viewProduct/{Id}")
    public String getProduct( Model model, @PathVariable String Id) throws IOException {
            Product product= productDao.getProductById(Id);
            model.addAttribute("product", product);
        return "viewProduct";
    }


}
