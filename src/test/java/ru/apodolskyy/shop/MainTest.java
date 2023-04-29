package ru.apodolskyy.shop;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.apodolskyy.shop.dao.impl.*;
import ru.apodolskyy.shop.entity.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    /**
     * Setup data for main tests
     */

    // 1. Creating new Customer
    static CustomerDAOImpl customerDAO = new CustomerDAOImpl();
    static Customer customer = new Customer();
    static Long customerId;
    static CustomerRoleDAOImpl customerRoleDAO = new CustomerRoleDAOImpl();

    // 2. Creating new Products
    static ProductDAOImpl productDAO = new ProductDAOImpl();
    static Product product1 = new Product();
    static Product product2 = new Product();
    static Double product1Qty = 3D;
    static Double product2Qty = 2D;
    static Long product1Id;
    static Long product2Id;

    // 3. Creating new Purchase
    static PurchaseDAOImpl purchaseDAO = new PurchaseDAOImpl();
    static Purchase purchase = new Purchase();
    static Long purchaseId;

    // 4. Creating list with purchased products
    static PurchasedProductsDAOImpl purchasedProductsDAO = new PurchasedProductsDAOImpl();
    static PurchasedProducts purchasedProduct1 = new PurchasedProducts();
    static Long purchasedProduct1Id;
    static PurchasedProducts purchasedProduct2 = new PurchasedProducts();
    static Long purchasedProduct2Id;
    static List<PurchasedProducts> purchasedProducts;

    @BeforeAll
    static void setupAndCheckTestData() {

        // Creating Customer
        customer.setCustomerName("customerNameTest");
        customer.setCustomerSurname("customerSurnameTest");
        customer.setCustomerEmail("customerEmailTest");
        customer.setCustomerPassword("customerPasswordTest");
        customerDAO.add(customer);
        customerId = customer.getId();
        assertTrue(customerDAO.get(customerId).equals(customer));

        // Creating 2 products
        product1.setItem("TestProduct1");
        product1.setPrice(14D);
        product2.setItem("TestProduct2");
        product2.setPrice(19D);
        productDAO.add(product1);
        productDAO.add(product2);
        product1Id = product1.getId();
        product2Id = product2.getId();
        assertEquals(productDAO.get(product1Id), product1);
        assertEquals(productDAO.get(product2Id), product2);

        // Creating new purchase ang getting purchase ID for assigning purchased products
        purchase.setCustomerId(customerId);
        purchaseDAO.add(purchase);
        purchaseId = purchase.getId();


        // Creating 2 purchased products from products
        purchasedProduct1.setPurchase(purchase);
        purchasedProduct1.setProduct(product1);
        purchasedProduct1.setProductQty(product1Qty);
        purchasedProduct1.setProductPrice(product1.getPrice());
        purchasedProductsDAO.add(purchasedProduct1);
        purchasedProduct1Id = purchasedProduct1.getId();

        purchasedProduct2.setPurchase(purchase);
        purchasedProduct2.setProduct(product2);
        purchasedProduct2.setProductQty(product2Qty);
        purchasedProduct2.setProductPrice(product2.getPrice());
        purchasedProductsDAO.add(purchasedProduct2);
        purchasedProduct2Id = purchasedProduct2.getId();
    }



    /**
     * Main functionality tests for Customer and his Role
     */
    @Test
    void customer_UpdateEmail(){
        String newEmail = "customerUpdatedEmailTest";
        customer.setCustomerEmail(newEmail);
        customerDAO.update(customer);
        assertEquals(customerDAO.get(customerId).getCustomerEmail(), newEmail);
    }

    @Test
    void customer_GetById(){
        assertEquals(customerDAO.get(customerId), customer);
    }

    @Test
    void customer_FindAll(){
        assertFalse(customerDAO.findAll().isEmpty());
    }

    @Test
    void customer_GetByEmail(){
        String customerEmail = customer.getCustomerEmail();
        assertTrue(customerDAO.getByEmail(customerEmail).equals(customer));
    }

    @Test
    void customer_ChangeRole(){
        CustomerRole customerRole = customerDAO.get(customerId).getCustomerRole();
        assertTrue(customerRole.getRoleDataId() == 2L);
        customerRole.setRoleDataId(1L);
        CustomerRoleDAOImpl customerRoleDAO = new CustomerRoleDAOImpl();
        customerRoleDAO.update(customerRole);
        assertTrue(customerDAO.get(customerId).getCustomerRole().getRoleDataId() == 1L);

    }



    /**
     * Main functionality tests for Products
     */
    @Test
    void product_UpdateProduct(){
        Double newPrice = 34.5D;
        product1.setPrice(newPrice);
        productDAO.update(product1);
        assertEquals(productDAO.get(product1Id).getPrice(), newPrice);
    }

    @Test
    void product_DeleteProduct(){
        Product product3 = new Product();
        product3.setItem("Test3Product");
        product3.setPrice(18.99D);
        productDAO.add(product3);
        Long product3Id = product3.getId();
        assertTrue(productDAO.get(product3Id).equals(product3));
        productDAO.delete(product3Id);
        assertTrue(productDAO.get(product3Id) == null);
    }

    @Test
    void product_GetProductByItem(){
        assertFalse(productDAO.findAll("Prod").isEmpty());
    }



    /**
     * Main functionality tests for PurchasedProducts
     */
    @Test
    void purchasedProducts_Update(){
        // TODO 29.04.2023: При вкл кеше, даже TRANSACTIONAL - не загружаются актуальные данные из БД. Кеш для entity отключен
        // Expected 42 because Product1 price 14 * product1Qty 3
        assertEquals(42D, purchasedProductsDAO.get(purchasedProduct1Id).getTotalAmount());
        // Changing qty. 12 * 10 = 128
        purchasedProduct1 = purchasedProductsDAO.get(purchasedProduct1Id);
        purchasedProduct1.setProductQty(10D);
        purchasedProductsDAO.update(purchasedProduct1);
        assertEquals(140D, purchasedProductsDAO.get(purchasedProduct1Id).getTotalAmount());
    }

    @Test
    void purchasedProducts_FindAll(){
        assertFalse(purchasedProductsDAO.findAll().isEmpty());
    }

    @Test
    void purchasedProducts_FindByPurchaseId(){
        assertFalse(purchasedProductsDAO.findByPurchase(purchaseId).isEmpty());
    }

    /**
     * Delete all test data from DB
     */
    @AfterAll
    static void deleteTestData(){

        // Deleting Customer
        customerDAO.delete(customerId);

        // Deleting test PurchasedProducts
        purchasedProductsDAO.delete(purchasedProduct1Id);
        purchasedProductsDAO.delete(purchasedProduct2Id);

        // delete test ProductData
        productDAO.delete(product1Id);
        productDAO.delete(product2Id);

        // Delete PurchaseData
        purchaseDAO.delete(purchaseId);

        HibernateUtil_purchases.close();
    }

}