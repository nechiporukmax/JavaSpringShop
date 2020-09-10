package org.example.controller;

import org.example.dao.CategoryDao;
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

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping("/productList/{Id}")
    public String getProducts(Model model,@PathVariable int Id){
        List<Product> products = categoryDao.getProductByCategory(Id);
        model.addAttribute("products", products);
        return "productList";
    }
    @RequestMapping("/productList")
    public String getAllProducts(Model model){
        List<Product> products = productDao.getProductList();
        model.addAttribute("products", products);
        return "productList";
    }
    @RequestMapping(value = "/productList/Search/", method = RequestMethod.POST)
    public String getProductBySearch(@RequestParam("Name") String Name,Model model)
    {
        List<Product> products = productDao.getProductBySearch(Name);
        model.addAttribute("products", products);
        return "productList";
    }
    @RequestMapping("/wishList")
    public String getWishList( Model model) throws IOException {
        List<Product> products= productDao.GetWishList();
        model.addAttribute("products", products);
        return "wishList";
    }
    @RequestMapping("/cart")
    public String getCart( Model model) throws IOException {
        List<Product> products= productDao.GetCart();
        float totalPrice=0;
        for(int i=0;i<products.size();i++)
        {
            totalPrice+=products.get(i).getPrice();
        }
        model.addAttribute("products", products);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }
        @RequestMapping("/productList/viewProduct/{Id}")
    public String getProduct( Model model, @PathVariable String Id) throws IOException {
            Product product= productDao.getProductById(Id);
            model.addAttribute("product", product);
        return "viewProduct";
    }
}
