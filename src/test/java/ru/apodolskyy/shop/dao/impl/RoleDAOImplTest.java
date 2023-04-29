package ru.apodolskyy.shop.dao.impl;

import org.junit.jupiter.api.*;
import ru.apodolskyy.shop.HibernateUtil_customers;
import ru.apodolskyy.shop.entity.Role;

import static org.junit.jupiter.api.Assertions.*;

class RoleDAOImplTest {

    static RoleDAOImpl roleDAO = new RoleDAOImpl();
    static Role role = new Role();
    static Long roleId;

    @BeforeAll
    static void addRole() {
        role.setRoleName("TestRole");
        role.setRoleDescription("TestRoleDescription");
        roleDAO.add(role);
        roleId = role.getId();
    }

    @AfterAll
    static void deleteRole() {
        roleDAO.delete(roleId);
        assertNull(roleDAO.get(roleId));
        HibernateUtil_customers.close();
    }

    @Test
    void updateAndGetRole() {
        role.setRoleName("TestRole2");
        roleDAO.update(role);
        assertTrue(roleDAO.get(roleId).equals(role));
    }

}