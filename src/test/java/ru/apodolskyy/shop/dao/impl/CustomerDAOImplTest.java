package ru.apodolskyy.shop.dao.impl;

// TODO можно исп метод с аннотацией @BeforeAll, чтобы проиниц. данные +

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.apodolskyy.shop.entity.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOImplTest {

    private static final Customer customer1 = new Customer();
    private static final Customer customer2 = new Customer();

    private static final CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    @BeforeAll
    public static void initCustomers() {
        customer1.setId(1L);
        customer1.setName("Ivan");
        customer1.setSurname("Ivanov");
        customer1.setEmail("customer1");
        customer1.setPassword("12345");

        customer2.setId(2L);
        customer2.setName("Petr");
        customer2.setSurname("Petrov");
        customer2.setEmail("customer2");
        customer2.setPassword("23456");

        customerDAO.add(customer1);
        customerDAO.add(customer2);
    }

    @Test
    @DisplayName("Extra tests for entity Customer")
    void product(){
        Customer customer3 = new Customer(3L, "TestName","TestSurname","TestEmail","pass");
        assertEquals(3L, customer3.hashCode());
        assertFalse(customer3.equals(customer2));
    }

    @Test
    @DisplayName("Get existing and not existing customers")
    void get() {
        assertEquals(customer1, customerDAO.get(1L));
        assertNull(customerDAO.get(9L));
    }

    @Test
    @DisplayName("Add 3 customers")
    void addNewCustomers() {
        assertEquals(1L ,customerDAO.get(1L).getId());
        assertEquals(2L ,customerDAO.get(2L).getId());
    }

    @Test
    @DisplayName("Update existing customer")
    void update() {
        customer1.setName("Artem");
        customerDAO.update(customer1);
        assertTrue("Artem" == customerDAO.get(1L).getName());
    }

    @Test
    @DisplayName("Delete customer as object")
    void delete() {
        customerDAO.delete(customer1);
        customerDAO.delete(customer2);
        assertTrue(customerDAO.findAll().isEmpty());
        customerDAO.add(customer1);
        customerDAO.add(customer2);
    }

    @Test
    @DisplayName("Show all customers")
    void findAll() {
        assertFalse(customerDAO.findAll().isEmpty());

    }

    @Test
    @DisplayName("Find customer by email")
    void findAllByEmail() {
        assertFalse(customerDAO.findAll("customer1").isEmpty());
        assertTrue(customerDAO.findAll("Unknown").isEmpty());

    }
}