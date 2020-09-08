package org.example.dao.implement;

import org.example.dao.CategoryDao;
import org.example.dao.ProductDao;
import org.example.model.Category;
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

public class CategoryDaoImplement  implements CategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getCategoryList() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Category ");
        List<Category>categories=query.list();
        session.flush();
        return categories;

    }

    @Override
    public Category getCategoryById(int Id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = (Category) session.get(Category.class, Id);
        session.flush();
        return category;
    }

    @Override
    public   List<Product> getProductByCategory(int Id) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Product where CATEGORY_ID ="+Id);
        List<Product>products=query.list();
        session.flush();
        return products;
    }

}
