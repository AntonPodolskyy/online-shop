package ru.apodolskyy.shop.dao.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.apodolskyy.shop.HibernateUtil_purchases;
import ru.apodolskyy.shop.entity.Purchase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PurchaseDAOImplTest {

    static PurchaseDAOImpl purchaseDAO = new PurchaseDAOImpl();
    static Purchase purchase = new Purchase();
    static Long purchaseId;
    static Long customerId = 1l;
    static ProductDAOImpl productDAO = new ProductDAOImpl();

    @BeforeAll
    static void addPurchase() {
        purchase.setCustomerId(customerId);
        purchase.setPaid(true);
        purchaseDAO.add(purchase);
        purchaseId = purchase.getId();
    }

    @AfterAll
    static void deletePurchase() {
        purchaseDAO.delete(purchaseId);
        HibernateUtil_purchases.close();
    }

    @Test
    void findAll() {
        assertFalse(purchaseDAO.findAll().isEmpty());
    }

    @Test
    void testFindAllById() {
        List<Purchase> purchases = purchaseDAO.findAll(customerId);
        assertFalse(purchases.isEmpty());
    }

    @Test
    void changePaidAndDeliveryStatus(){
        assertFalse(purchaseDAO.get(purchaseId).getOnDelivery());
        assertTrue(purchaseDAO.get(purchaseId).getPaid());
        purchase.setPaid(false);
        purchase.setOnDelivery(true);
        purchaseDAO.update(purchase);
        assertTrue(purchaseDAO.get(purchaseId).getOnDelivery());
        assertFalse(purchaseDAO.get(purchaseId).getPaid());

    }
}