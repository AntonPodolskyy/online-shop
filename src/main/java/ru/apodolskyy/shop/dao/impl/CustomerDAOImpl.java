package ru.apodolskyy.shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.apodolskyy.shop.HibernateUtil_customers;
import ru.apodolskyy.shop.dao.interfaces.objects.CustomerDAO;
import ru.apodolskyy.shop.entity.Customer;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    /**
     * Get Customer by ID
     * @param id of Customer
     * @return obj "Customer"
     */
    @Override
    public Customer get(long id) {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    /**
     * Add new “Customer” to DB
     * @param obj "Customer"
     */
    @Override
    public void add(Customer obj) {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Update obj "Customer"
     * @param obj "Customer"
     */
    @Override
    public void update(Customer obj) {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(obj);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Delete obj "Customer" by ID
     */
    @Override
    public void delete(long id) {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = get(id);
        session.remove(customer);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Find all "Customer"
     * @return List "Customer"
     */
    @Override
    public List<Customer> findAll() {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
        List<Customer> list = query.getResultList();
        session.close();
        return list;
    }


    /**
     * Find all “Customer” by Email
     * @return List "Customer"
     */
    @Override
    public List<Customer> findAll(String email) {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        Query<Customer> query = session.createQuery("FROM Customer WHERE customerEmail LIKE :email", Customer.class);
        query.setParameter("email", "%" + email + "%");
        List<Customer> list = query.getResultList();
        session.close();
        return list;
    }

    /**
    * Find single “Customer” by email
    */
    @Override
    public Customer getByEmail(String email){
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        Query<Customer> query = session.createQuery("FROM Customer WHERE customerEmail = :email", Customer.class);
        query.setParameter("email", email);
        Customer customer = query.uniqueResult();
        session.close();
        return customer;
    }

}
