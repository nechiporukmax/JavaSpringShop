package org.example.controller;

import org.example.dao.ProductDao;
import org.example.model.Product;
import org.example.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private FileService fileService;

    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){
        List<Product> products = productDao.getProductList();
        model.addAttribute("products", products);
        return "productInventory";
    }
    @RequestMapping("/productList/setWishList/{Id}")
    public RedirectView SetWishList(Model model, @PathVariable String Id) throws IOException {
        productDao.SetWishList(Id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/productList");
        return redirectView;
    }
    @RequestMapping("/productList/delete/{Id}")
    public RedirectView Delete(Model model, @PathVariable String Id) throws IOException {
        productDao.delProduct(Id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/productList");
        return redirectView;
    }
    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public ModelAndView addProduct(Model model) {

        return new ModelAndView("AddProduct", "product", new Product());
    }
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public RedirectView addProduct(@ModelAttribute("product") Product product  ) {

       productDao.addProduct(product);

       // fileService.saveFile(product.getImage());
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/productList");
        return redirectView;
    }

    @RequestMapping(value = "/editProduct", method = RequestMethod.GET)
    public ModelAndView editProduct(Model model) {
        List<Product> products = productDao.getProductList();
        return new ModelAndView("AddProduct", "product", products.get(0));
    }
    @RequestMapping(value = "/editProduct", method = RequestMethod.POST)
    public RedirectView editProduct(@ModelAttribute("product") Product product  ) {
        productDao.addProduct(product);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/productList");
        return redirectView;
    }
}
