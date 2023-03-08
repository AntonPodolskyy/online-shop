package ru.apodolskyy.shop.dao.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.apodolskyy.shop.entity.Customer;
import ru.apodolskyy.shop.entity.Product;
import ru.apodolskyy.shop.entity.Purchase;

import static org.junit.jupiter.api.Assertions.*;

// TODO обычно прописывают минимально необходимый test coverage по главному функциноалу - и проверяют его покрытие

class PurchaseDAOImplTest {

    private static final Product product1 = new Product();
    private static final Product product2 = new Product();

    private static final Customer customer1 = new Customer();

    private static final Purchase purchase1 = new Purchase();
    private static final Purchase purchase2 = new Purchase();

    private static final PurchaseDAOImpl purchaseDAO = new PurchaseDAOImpl();

    @BeforeAll
    public static void initPurchases(){

        Product product1 = new Product(1L,"Хлеб", 85);
        Product product2 = new Product(2L,"Молоко", 78);

        Customer customer1 = new Customer(1L,"Ivan", "Ivanov", "customer1", "12345");
        Customer customer2 = new Customer(2L,"Petr", "Petrov", "customer2", "23456");

        purchase1.setId(1L);
        purchase1.setCustomer(customer1);
        purchase1.setProduct(product1);

        purchase2.setId(2L);
        purchase2.setCustomer(customer2);
        purchase2.setProduct(product2);

        purchaseDAO.add(purchase1);
        purchaseDAO.add(purchase2);
    }

    @Test
    @DisplayName("Extra tests for entity Purchase")
    void purchase (){
        Purchase purchase3 = new Purchase(3L, customer1, product2);
        assertNotNull(purchase3.getOrderTime());
        assertEquals(3L, purchase3.hashCode());
        assertFalse(purchase3.equals(purchase2));
    }

    @Test
    @DisplayName("Get existing and not existing purchase")
    void get() {
        assertNotNull(purchaseDAO.get(1L));
        assertNull(purchaseDAO.get(5L));
    }

    @Test
    @DisplayName("Update existing purchase")
    void update() {
        purchase2.setProduct(product1);
        purchaseDAO.update(purchase2);
        assertSame(product1, purchase2.getProduct());
        purchase2.setProduct(product2);
    }

    @Test
    @DisplayName("Delete purchase as object")
    void delete() {
        purchaseDAO.delete(purchase1);
        purchaseDAO.delete(purchase2);
        assertTrue(purchaseDAO.findAll().isEmpty());
        purchaseDAO.add(purchase1);
        purchaseDAO.add(purchase2);
    }

    @Test
    @DisplayName("Show all purchases")
    void findAll() {
        assertFalse(purchaseDAO.findAll().isEmpty());
    }

    @Test
    @DisplayName("Find purchases by customers surname")
    void testFindAll() {
        assertFalse(purchaseDAO.findAll("Petrov").isEmpty());
        assertTrue(purchaseDAO.findAll("Unknown").isEmpty());
    }
}