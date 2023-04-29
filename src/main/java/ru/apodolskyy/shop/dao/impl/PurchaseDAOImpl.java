package ru.apodolskyy.shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.apodolskyy.shop.HibernateUtil_purchases;
import ru.apodolskyy.shop.dao.interfaces.objects.PurchaseDAO;
import ru.apodolskyy.shop.entity.Purchase;

import java.util.List;

public class PurchaseDAOImpl implements PurchaseDAO {


    /**
     * Get Purchase by ID
     * @param id - id
     * @return obj "Purchase"
     */
    @Override
    public Purchase get(long id) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        Purchase purchase = session.get(Purchase.class, id);
        session.close();
        return purchase;
    }

    /**
     * Add “Purchase” to DB
     * @param obj "Purchase"
     */
    @Override
    public void add(Purchase obj) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Update "Purchase" in DB (by ID)
     * @param obj "Purchase"
     */
    @Override
    public void update(Purchase obj) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(obj);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Delete "Purchase"
     */
    @Override
    public void delete(long id) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        session.beginTransaction();
        Purchase purchase = get(id);
        session.remove(purchase);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Find all "Purchase"
     * @return List "Purchase"
     */
    @Override
    public List<Purchase> findAll() {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        Query<Purchase> query = session.createQuery("FROM Purchase", Purchase.class);
        List<Purchase> list = query.getResultList();
        session.close();
        return list;
    }


    /**
     * Find all Customers "Purchase" (by Customers ID)
     * @return List "Purchase"
     */
    @Override
    public List<Purchase> findAll(Long customerId) {
        Session session = HibernateUtil_purchases.getSessionFactory().openSession();
        Query<Purchase> query = session.createQuery("FROM Purchase WHERE customerId = :customerId", Purchase.class);
        query.setParameter("customerId", customerId);
        List<Purchase> list = query.getResultList();
        session.close();
        return list;
    }

}
