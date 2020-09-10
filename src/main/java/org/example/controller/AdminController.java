package org.example.controller;
import org.example.dao.CategoryDao;
import org.example.dao.ProductDao;
import org.example.model.Category;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class AdminController {
    private Path path;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;
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
    @RequestMapping("/productList/setCart/{Id}")
    public RedirectView SetCart(Model model, @PathVariable String Id) throws IOException {
        productDao.SetCart(Id);
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

        List<Category> categories=categoryDao.getCategoryList();
        model.addAttribute("product",new Product());
        model.addAttribute("categories",categories);
        return new ModelAndView("AddProduct");
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public RedirectView addProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {
       product.setCategory( categoryDao.getCategoryById(product.getCategory().getId()));
        productDao.addProduct(product);
        MultipartFile productImage = product.getImage();
        System.out.println("productImage => " + productImage);
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\Uploads\\"+product.getId()+".png");
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/admin");
        return redirectView;
    }

    @RequestMapping(value = "/editProduct/{id}")
    public ModelAndView editProduct(@PathVariable("id") String id, Model model) {
        List<Category> categories=categoryDao.getCategoryList();
        model.addAttribute("product",productDao.getProductById(id));
        model.addAttribute("categories",categories);
        return new ModelAndView("editProduct");
    }

    @RequestMapping(value = "/editProduct", method = RequestMethod.POST)
    public RedirectView editProduct(@ModelAttribute("product") Product product, Model model, HttpServletRequest
            request ) {
        MultipartFile productImage = product.getImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\Uploads\\"+product.getId()+".png");
        if (productImage != null && !productImage.isEmpty()) {
            try {
                File file = new File(path.toString());
                if(file.delete())
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                throw new RuntimeException("Product image saving failed" , e);
            }
        }
        product.setCategory( categoryDao.getCategoryById(product.getCategory().getId()));
        productDao.editProduct(product);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/admin");
        return redirectView;
    }
}
