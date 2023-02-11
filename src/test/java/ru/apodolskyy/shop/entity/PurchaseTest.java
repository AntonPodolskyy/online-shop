package ru.apodolskyy.shop.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {
    Customer customer = new Customer(1L, "Name", "Surname", "Email", "Password");
    Customer customer2 = new Customer(2L, "Name2", "Surname2", "Email2", "Password2");
    Product product = new Product(3L, "TestItem", 112);
    Product product2 = new Product(3L, "TestItem2", 113);
    Purchase purchase = new Purchase(9L,customer, product);
    Purchase purchase2 = new Purchase(9L,customer, product);

    @Test
    void getId() {
        assertEquals(9L, purchase.getId());
    }

    @Test
    void getOrderTime() {
        assertNotNull(purchase.getOrderTime());
    }

    @Test
    void getCustomer() {
        assertEquals("Name", purchase.getCustomer().getName());
    }

    @Test
    void getProduct() {
        assertEquals("TestItem", purchase.getProduct().getItem());
    }

    @Test
    void setId() {
        purchase.setId(67L);
        assertEquals(67L, purchase.getId());
    }

    @Test
    void setOrderTime() {
        purchase.setOrderTime("22-12-2000");
        assertEquals("22-12-2000", purchase.getOrderTime());
    }

    @Test
    void setCustomer() {
        purchase.setCustomer(customer2);
        assertEquals("Name2", purchase.getCustomer().getName());
    }

    @Test
    void setProduct() {
        purchase.setProduct(product2);
        assertEquals("TestItem2", purchase.getProduct().getItem());
    }

    @Test
    void hashAndEqualsCheck(){
        assertTrue(purchase.equals(purchase2) && purchase2.equals(purchase));
        assertEquals(purchase.hashCode(), purchase2.hashCode());
    }
}