package org.example.dao;

import org.example.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProductList();
    Product getProductById(String Id);
    void addProduct (Product product);
    void editProduct (Product product);
    void delProduct(String id);
    void SetWishList(String id);
    void SetCart(String id);
    List<Product> GetCart();
    List<Product> GetWishList();
    public List<Product> getProductBySearch(String NameSearch);
}
