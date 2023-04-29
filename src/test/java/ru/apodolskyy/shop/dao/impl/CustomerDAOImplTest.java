package ru.apodolskyy.shop.dao.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.apodolskyy.shop.HibernateUtil_customers;
import ru.apodolskyy.shop.entity.Customer;
import ru.apodolskyy.shop.entity.CustomerRole;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOImplTest {

    static CustomerDAOImpl customerDAO = new CustomerDAOImpl();
    static Customer customer = new Customer();
    static Long customerId;

    static CustomerRoleDAOImpl customerRoleDAO = new CustomerRoleDAOImpl();

//    static Long customerRoleId;

    @BeforeAll
    static void addCustomer() {

        customer.setCustomerName("customerNameTest");
        customer.setCustomerSurname("customerSurnameTest");
        customer.setCustomerEmail("customerEmailTest");
        customer.setCustomerPassword("customerPasswordTest");
        customerDAO.add(customer);
        customerId = customer.getId();
    }

    @AfterAll
    static void deleteCustomer() {
        customerDAO.delete(customerId);
        assertNull(customerDAO.get(customerId));
        HibernateUtil_customers.close();
    }

    @Test
    void getCustomer() {
         assertEquals(customer,customerDAO.get(customerId));
    }

    @Test
    void updateCustomer() {
        customer.setCustomerName("Test");
        customerDAO.update(customer);
        assertTrue(customerDAO.get(customerId).getCustomerName().equals("Test"));
    }

    @Test
    void findAllCustomers() {
        List<Customer> list = customerDAO.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    void FindAllCustomersByEmail() {
        assertFalse(customerDAO.findAll("customerEmailTest").isEmpty());
    }

    @Test
    void getCustomerByEmail() {
        assertEquals(customerDAO.getByEmail("customerEmailTest"), customer);
    }


    // CustomerRoleDAOImpl test
    @Test
    void getAndSetCustomerRole() {
        assertEquals(2L, customerDAO.get(customerId).getCustomerRole().getRoleDataId());

        CustomerRoleDAOImpl customerRoleDAO = new CustomerRoleDAOImpl();
        CustomerRole customerRole = customerRoleDAO.get(customerId);
        customerRole.setRoleDataId(1L);
        customerRoleDAO.update(customerRole);

        assertEquals(1L, customerDAO.get(customerId).getCustomerRole().getRoleDataId());
    }

    @Test
    void findAllCustomersRole() {
        List<CustomerRole> list = customerRoleDAO.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    void FindAllCustomersRoleByEmail() {
        assertFalse(customerRoleDAO.findAll("customerEmailTest").isEmpty());
        assertTrue(customerRoleDAO.findAll("sdfwre34rdfawq2342rsafdqw4").isEmpty());

    }

}