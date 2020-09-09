package org.example.controller;

import org.example.dao.CategoryDao;
import org.example.dao.ProductDao;
import org.example.model.Category;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.util.List;

@Controller



public class CategoryController {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;
    @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
    public ModelAndView addCategory(Model model,@RequestParam(value="error", required = false) String error){

        if(error != null) {
            model.addAttribute("error", "This name already used");
        }
        model.addAttribute("category",new Category());
        return new ModelAndView("addCategory");
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public ModelAndView addCategory(Model model,
                                    @ModelAttribute("category") Category category, HttpServletRequest request){
       Category c=categoryDao.GetCategoryByName(category.getName());
        if(c != null) {
            model.addAttribute("error", "This name already used");
            model.addAttribute("category",category);
            return new ModelAndView("addCategory");
        }
        categoryDao.addCategory(category);
        return new ModelAndView("admin");

    }
}
