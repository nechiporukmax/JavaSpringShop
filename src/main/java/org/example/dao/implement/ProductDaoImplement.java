package org.example.dao.implement;

import org.example.dao.ProductDao;
import org.example.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImplement implements ProductDao {
    @Autowired
private SessionFactory sessionFactory;

    public List<Product> getProductList() {
       Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Product ");
        List<Product>products=query.list();
        session.flush();
        return products;
    }
public List<Product> getProductBySearch(String NameSearch)
{
    Session session=sessionFactory.getCurrentSession();

    Query query=session.createQuery("from Product WHERE  Name  LIKE'%"+NameSearch+"%'");
    List<Product>products=query.list();
    session.flush();
    return products;
}
    public Product getProductById(String Id) {

        Session session = sessionFactory.getCurrentSession();
    Product product = (Product) session.get(Product.class, Id);
        session.flush();
        return product;
    }
    public void SetWishList(String id)
    {
        Product product=getProductById(id);
        product.setWishList(!product.getWishList());
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        session.flush();
    }


    public void SetCart(String id) {
        Product product=getProductById(id);
        product.setCart(!product.getCart());
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        session.flush();
    }


    public List<Product> GetCart() {
        Session session=sessionFactory.getCurrentSession();

        Query query=session.createQuery("from Product WHERE Cart=TRUE");
        List<Product>products=query.list();
        session.flush();
        return products;
    }


    public List<Product> GetWishList() {
        Session session=sessionFactory.getCurrentSession();

        Query query=session.createQuery("from Product WHERE WISHLIST=TRUE");
        List<Product>products=query.list();
        session.flush();
        return products;
    }

    public void addProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void delProduct(String id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Product where Id =" + id);
        query.executeUpdate();
        session.flush();
    }

    public void editProduct (Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }
}
