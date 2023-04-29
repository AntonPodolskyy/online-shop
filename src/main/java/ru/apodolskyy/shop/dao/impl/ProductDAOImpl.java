package ru.apodolskyy.shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.apodolskyy.shop.HibernateUtil_purchases;
import ru.apodolskyy.shop.dao.interfaces.objects.ProductDAO;
import ru.apodolskyy.shop.entity.Product;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    /**
     * Get Product by ID
     * @param id Product
     * @return obj "Product"
     */
    @Override
    public Product get(long id) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    /**
     * Add new “Product” to DB
     * @param obj "Product"
     */
    @Override
    public void add(Product obj) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Update "Product"
     * @param obj "Product"
     */
    @Override
    public void update(Product obj) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(obj);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Delete "Product"
     */
    @Override
    public void delete(long id) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = get(id);
        session.remove(product);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Get all "Product"
     * @return List "Product"
     */
    @Override
    public List<Product> findAll() {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        Query<Product> query = session.createQuery("FROM Product", Product.class);
        List<Product> list = query.getResultList();
        session.close();
        return list;
    }

    /**
     * Get all “Product” with specific item
     * @return List "Product"
     */
    @Override
    public List<Product> findAll(String item) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        Query<Product> query = session.createQuery("FROM Product WHERE item LIKE :item", Product.class);
        query.setParameter("item", "%" + item + "%");
        List<Product> list = query.getResultList();
        session.close();
        return list;
    }
}
