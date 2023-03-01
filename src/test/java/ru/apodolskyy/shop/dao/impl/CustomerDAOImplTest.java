package ru.apodolskyy.shop.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.apodolskyy.shop.entity.Customer;

import static org.junit.jupiter.api.Assertions.*;

// TODO можно исп метод с аннотацией @BeforeAll, чтобы проиниц. данные

class CustomerDAOImplTest {

    Customer customer1 = new Customer(1L,"Ivan", "Ivanov", "customer1", "12345");
    Customer customer2 = new Customer(2L,"Petr", "Petrov", "customer2", "23456");
    Customer customer3 = new Customer(3L, "Igor", "Moroz", "customer3", "34567");

    CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    @Test
    @DisplayName("Get existing and not existing customers")
    void get() {
        customerDAO.add(customer1);
        assertEquals(customer1, customerDAO.get(1L));
        assertNull(customerDAO.get(9L));
    }

    @Test
    @DisplayName("Add 3 customers")
    void addNewCustomers() {
        customerDAO.add(customer1);
        customerDAO.add(customer2);
        customerDAO.add(customer3);
        assertEquals(1L ,customerDAO.get(1L).getId());
        assertEquals(2L ,customerDAO.get(2L).getId());
        assertEquals(3L ,customerDAO.get(3L).getId());
    }

    @Test
    @DisplayName("Update existing customer")
    void update() {
        Customer customer5 = new Customer(5L, "1", "2", "3", "4");
        customerDAO.add(customer5);
        customer5.setName("UpdatedName");
        customerDAO.update(customer5);
        assertEquals("UpdatedName", customerDAO.get(5L).getName());
    }

    @Test
    @DisplayName("Delete customer as object")
    void delete() {
        assertTrue(customerDAO.findAll().isEmpty());
        customerDAO.add(customer1);
        customerDAO.add(customer2);
        customerDAO.add(customer3);
        assertFalse(customerDAO.findAll().isEmpty());
        customerDAO.delete(customer1);
        customerDAO.delete(customer2);
        customerDAO.delete(customer3);
        assertTrue(customerDAO.findAll().isEmpty());
    }

    @Test
    @DisplayName("Show all customers")
    void findAll() {
        customerDAO.add(customer1);
        customerDAO.add(customer2);
        customerDAO.add(customer3);
        assertFalse(customerDAO.findAll().isEmpty());

    }

    @Test
    @DisplayName("Find customer by email")
    void findAllByEmail() {
        customerDAO.add(customer1);
        customerDAO.add(customer2);
        customerDAO.add(customer3);
        assertFalse(customerDAO.findAll("customer1").isEmpty());
        assertTrue(customerDAO.findAll("Unknown").isEmpty());

    }
}