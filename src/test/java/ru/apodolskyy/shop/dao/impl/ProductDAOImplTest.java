package ru.apodolskyy.shop.dao.impl;

// в тесты желательно добавлять не только assertEquals или assertNull, но и многие другие - для разнообразия. Иначе тесты становятся однотипными и можно пропустить функционал

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.apodolskyy.shop.entity.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOImplTest {

    private static final Product product1 = new Product();
    private static final Product product2 = new Product();

    private static final ProductDAOImpl productDAO = new ProductDAOImpl();

    @BeforeAll
    public static void initProducts(){
        product1.setId(1L);
        product1.setItem("Хлеб");
        product1.setPrice(85);

        product2.setId(2L);
        product2.setItem("Молоко");
        product2.setPrice(78);

        productDAO.add(product1);
        productDAO.add(product2);
    }

    @Test
    @DisplayName("Extra tests for entity Product")
    void product(){
        Product product5 = new Product("Test item");
        assertNull(product5.getPrice());
        assertEquals(0L, product5.hashCode());
    }

    @Test
    @DisplayName("Get existing and not existing product")
    void get() {
        assertEquals(product1, productDAO.get(1L));
        assertNull(productDAO.get(12L));
    }

    @Test
    @DisplayName("Add products")
    void add() {
        assertEquals(1L, productDAO.get(1L).getId());
        assertEquals(2L, productDAO.get(2L).getId());
    }

    @Test
    @DisplayName("Update existing product")
    void update() {
        product2.setPrice(50);
        productDAO.update(product2);
        assertSame(product2, productDAO.get(2L));
    }

    @Test
    @DisplayName("Delete products as object")
    void delete() {
        assertFalse(productDAO.findAll().isEmpty());
        productDAO.delete(product1);
        productDAO.delete(product2);
        assertTrue(productDAO.findAll().isEmpty());

        productDAO.add(product1);
        productDAO.add(product2);
    }

    @Test
    @DisplayName("Show all products")
    void findAll() {
        assertFalse(productDAO.findAll().isEmpty());
    }

    @Test
    @DisplayName("Find products by item")
    void findAllByItem() {
        assertTrue(productDAO.findAll("Unknown").isEmpty());
        assertFalse(productDAO.findAll("Молоко").isEmpty());
    }
}