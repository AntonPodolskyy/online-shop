package ru.apodolskyy.shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.apodolskyy.shop.HibernateUtil_customers;
import ru.apodolskyy.shop.dao.interfaces.objects.CustomerRoleDAO;
import ru.apodolskyy.shop.entity.CustomerRole;

import java.util.List;

public class CustomerRoleDAOImpl implements CustomerRoleDAO {

    /**
     * Get CustomerRole by Role ID
     * @param id of CustomerRole
     * @return obj CustomerRole
     */
    @Override
    public CustomerRole get(long id) {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        CustomerRole customerRole = session.get(CustomerRole.class, id);
        session.close();
        return customerRole;
    }

    /**
     * Update CustomerRole
     * @param obj CustomerRole
     */
    @Override
    public void update(CustomerRole obj) {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(obj);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Show all CustomerRoles
     * @return List with CustomerRole
     */
    @Override
    public List findAll() {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        Query<CustomerRole> query = session.createQuery("FROM Customer", CustomerRole.class);
        List<CustomerRole> list = query.getResultList();
        session.close();
        return list;
    }

    /**
     * Find CustomerRole by email
     * @param email for search
     * @return List CustomerRole
     */
    @Override
    public List findAll(String email) {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        Query<CustomerRole> query = session.createQuery("FROM Customer WHERE customerEmail LIKE :email ", CustomerRole.class);
        query.setParameter("email", "%" + email + "%");
        List<CustomerRole> list = query.getResultList();
        session.close();
        return list;
    }

}
