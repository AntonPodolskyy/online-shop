package ru.apodolskyy.shop.dao.impl;

import org.hibernate.Session;
import ru.apodolskyy.shop.HibernateUtil_customers;
import ru.apodolskyy.shop.dao.interfaces.objects.RoleDAO;
import ru.apodolskyy.shop.entity.Role;

public class RoleDAOImpl implements RoleDAO {

    /**
     * Getting Role by ID
     * @param id of Role
     * @return obj Role
     */
    @Override
    public Role get(long id) {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        Role role = session.get(Role.class, id);
        session.close();
        return role;
    }

    /**
     * Adding new Role
     * @param obj Role
     */
    @Override
    public void add(Role obj) {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Updating Role
     * @param obj Role
     */
    @Override
    public void update(Role obj) {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(obj);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Deleting Role by id. DB limitation for delete if Role in use
     * @param id of Role
     */
    @Override
    public void delete(long id) {
        Session session = HibernateUtil_customers.getSessionFactory().openSession();
        session.beginTransaction();
        Role role = (Role) get(id);
        session.remove(role);
        session.getTransaction().commit();
        session.close();
    }
}
