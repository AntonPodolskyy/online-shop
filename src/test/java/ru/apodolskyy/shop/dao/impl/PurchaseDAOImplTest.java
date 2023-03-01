package ru.apodolskyy.shop.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.apodolskyy.shop.entity.Customer;
import ru.apodolskyy.shop.entity.Product;
import ru.apodolskyy.shop.entity.Purchase;

import static org.junit.jupiter.api.Assertions.*;

// TODO обычно прописывают минимально необходимый test coverage по главному функциноалу - и проверяют его покрытие

class PurchaseDAOImplTest {

    Product product1 = new Product(1L,"Хлеб", 85);
    Product product2 = new Product(2L,"Молоко", 78);
    Product product3 = new Product(3L,"Картофель", 45);

    Customer customer1 = new Customer(1L,"Ivan", "Ivanov", "customer1", "12345");
    Customer customer2 = new Customer(2L,"Petr", "Petrov", "customer2", "23456");
    Customer customer3 = new Customer(3L, "Igor", "Moroz", "customer3", "34567");

    Purchase purchase1 = new Purchase(1L, customer1,product1);
    Purchase purchase2 = new Purchase(2L, customer2,product2);
    Purchase purchase3 = new Purchase(3L, customer3,product3);

    PurchaseDAOImpl purchaseDAO = new PurchaseDAOImpl();

    @Test
    @DisplayName("Get existing and not existing purchase")
    void get() {
        purchaseDAO.add(purchase1);
        assertEquals("Ivan", purchaseDAO.get(1L).getCustomer().getName());
        assertNull(purchaseDAO.get(5L));
    }

    @Test
    @DisplayName("Add 3 purchases")
    void add() {
        assertTrue(purchaseDAO.findAll().isEmpty());
        purchaseDAO.add(purchase1);
        purchaseDAO.add(purchase2);
        purchaseDAO.add(purchase3);
        assertFalse(purchaseDAO.findAll().isEmpty());
    }

    @Test
    @DisplayName("Update existing purchase")
    void update() {
        Purchase purchase4 = new Purchase(5L, customer2, product1);
        purchaseDAO.add(purchase4);
        assertEquals("Хлеб", purchaseDAO.get(5L).getProduct().getItem());
        purchase4.setProduct(product3);
        purchaseDAO.update(purchase4);
        assertEquals("Картофель", purchaseDAO.get(5L).getProduct().getItem());
    }

    @Test
    @DisplayName("Delete purchase as object")
    void delete() {
        assertTrue(purchaseDAO.findAll().isEmpty());
        purchaseDAO.add(purchase1);
        purchaseDAO.add(purchase2);
        purchaseDAO.add(purchase3);
        assertFalse(purchaseDAO.findAll().isEmpty());
        purchaseDAO.delete(purchase1);
        purchaseDAO.delete(purchase2);
        purchaseDAO.delete(purchase3);
        assertTrue(purchaseDAO.findAll().isEmpty());
    }

    @Test
    @DisplayName("Show all purchases")
    void findAll() {
        purchaseDAO.add(purchase1);
        purchaseDAO.add(purchase2);
        purchaseDAO.add(purchase3);
        assertFalse(purchaseDAO.findAll().isEmpty());
    }

    @Test
    @DisplayName("Find purchases by customers surname")
    void testFindAll() {
        purchaseDAO.add(purchase1);
        purchaseDAO.add(purchase2);
        purchaseDAO.add(purchase3);
        assertFalse(purchaseDAO.findAll("Ivanov").isEmpty());
        assertTrue(purchaseDAO.findAll("Unknown").isEmpty());
    }
}