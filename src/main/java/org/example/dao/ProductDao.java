package org.example.dao;

import org.example.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProductList();
    Product getProductById(String Id);
    void addProduct (Product product);
    void delProduct(String id);
    void SetWishList(String id);
}
