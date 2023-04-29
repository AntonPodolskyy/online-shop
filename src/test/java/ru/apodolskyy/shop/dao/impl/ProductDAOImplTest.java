package ru.apodolskyy.shop.dao.impl;

import org.junit.jupiter.api.*;
import ru.apodolskyy.shop.HibernateUtil_purchases;
import ru.apodolskyy.shop.entity.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOImplTest {

    static ProductDAOImpl productDAO = new ProductDAOImpl();
    static Product product = new Product();
    static Long productId;

    @BeforeAll
    static void addTestProduct() {
        product.setItem("Test Product");
        product.setPrice(999D);
        product.setRemark("Test Remark");
        productDAO.add(product);
        productId = product.getId();
    }

    @AfterAll
    static void deleteTestProduct() {
        productDAO.delete(productId);
        assertNull(productDAO.get(productId));
        HibernateUtil_purchases.close();
    }

    @Test
    void getProductById() {
        assertEquals(product, productDAO.get(productId));
    }

    @Test
    void updateProductPrice() {
        product.setPrice(999.99D);
        productDAO.update(product);
        assertEquals(999.99D, productDAO.get(productId).getPrice());
    }

    @Test
    void findAllProducts() {
        List<Product> list = productDAO.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    void testFindAllByItem() {
        List<Product> list1 = productDAO.findAll("dnfkjhrikfhskgrhwk");
        assertTrue(list1.isEmpty());
        List<Product> list2 = productDAO.findAll("Test Product");
        assertFalse(list2.isEmpty());

    }
}