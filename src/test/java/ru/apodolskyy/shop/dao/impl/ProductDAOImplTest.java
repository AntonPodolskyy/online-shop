package ru.apodolskyy.shop.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.apodolskyy.shop.entity.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOImplTest {

    Product product1 = new Product(1L,"Хлеб", 85);
    Product product2 = new Product(2L,"Молоко", 78);
    Product product3 = new Product(3L,"Картофель", 45);
    Product product4 = new Product("Тара");

    ProductDAOImpl productDAO = new ProductDAOImpl();

    @Test
    @DisplayName("Get existing and not existing product")
    void get() {
        productDAO.add(product1);
        assertEquals(product1, productDAO.get(1L));
        assertNull(productDAO.get(12L));
    }

    @Test
    @DisplayName("Add 3 products")
    void add() {
        assertTrue(productDAO.findAll().isEmpty());
        productDAO.add(product1);
        productDAO.add(product2);
        productDAO.add(product3);
        assertEquals(1L, productDAO.get(1L).getId());
        assertEquals(2L, productDAO.get(2L).getId());
        assertEquals(3L, productDAO.get(3L).getId());
    }

    @Test
    @DisplayName("Update existing product")
    void update() {
        Product product5 = new Product(5L,"Мука", 50);
        productDAO.add(product5);
        assertEquals(50, productDAO.get(5L).getPrice());
        product5.setPrice(105);
        productDAO.update(product5);
        assertEquals(105, productDAO.get(5L).getPrice());
    }

    @Test
    @DisplayName("Delete products as object")
    void delete() {
        assertTrue(productDAO.findAll().isEmpty());
        productDAO.add(product1);
        productDAO.add(product2);
        productDAO.add(product3);
        productDAO.add(product4);
        assertFalse(productDAO.findAll().isEmpty());
        productDAO.delete(product1);
        productDAO.delete(product2);
        productDAO.delete(product3);
        productDAO.delete(product4);
        assertTrue(productDAO.findAll().isEmpty());
    }

    @Test
    @DisplayName("Show all products")
    void findAll() {
        productDAO.add(product1);
        productDAO.add(product2);
        productDAO.add(product3);
        assertFalse(productDAO.findAll().isEmpty());
    }

    @Test
    @DisplayName("Find products by item")
    void findAllByItem() {
        productDAO.add(product1);
        productDAO.add(product2);
        productDAO.add(product3);
        productDAO.add(product4);
        assertTrue(productDAO.findAll("Unknown").isEmpty());
        assertFalse(productDAO.findAll("Молоко").isEmpty());
    }
}