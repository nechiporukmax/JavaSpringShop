package org.example.dao;

import org.example.model.Category;
import org.example.model.Product;

import java.util.List;

public interface CategoryDao {
    List<Category> getCategoryList();
    Category getCategoryById(int Id);
   List<Product> getProductByCategory(int Id);
}
