package ru.apodolskyy.shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.apodolskyy.shop.HibernateUtil_purchases;
import ru.apodolskyy.shop.dao.interfaces.objects.PurchasedProductsDAO;
import ru.apodolskyy.shop.entity.PurchasedProducts;

import java.util.List;

public class PurchasedProductsDAOImpl implements PurchasedProductsDAO {


    /**
     * Getting PurchasedProduct by ID
     * @param id of purchased product
     * @return obj PurchasedProduct
     */
    @Override
    public PurchasedProducts get(long id) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        PurchasedProducts purchasedProducts = session.get(PurchasedProducts.class, id);
        session.close();
        return purchasedProducts;
    }

    /**
     * Adding obj PurchasedProduct to DB
     * @param obj new PurchasedProduct
     */
    @Override
    public void add(PurchasedProducts obj) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Updating PurchasedProduct obj in DB
     * @param obj updated PurchasedProduct
     */
    @Override
    public void update(PurchasedProducts obj) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(obj);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Deleting PurchasedProduct obj in DB
     * @param id PurchasedProduct
     */
    @Override
    public void delete(long id) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        session.beginTransaction();
        PurchasedProducts purchasedProducts = get(id);
        session.remove(purchasedProducts);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Returning collection with all Purchased Products
     * @return List with ALL purchased products
     */
    @Override
    public List<PurchasedProducts> findAll() {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        Query<PurchasedProducts> query = session.createQuery("FROM PurchasedProducts ", PurchasedProducts.class);
        List<PurchasedProducts> list = query.getResultList();
        session.close();
        return list;
    }

    /**
     * Get all purchased items by purchase ID
     * @param purchaseId purchase ID
     * @return List with purchased items
     */
    @Override
    public List<PurchasedProducts> findByPurchase(Long purchaseId) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        Query<PurchasedProducts> query = session.createQuery("FROM PurchasedProducts WHERE purchase.id = :purchaseId", PurchasedProducts.class);
        query.setParameter("purchaseId", purchaseId);
        List<PurchasedProducts> list = query.getResultList();
        session.close();
        return list;
    }
}
