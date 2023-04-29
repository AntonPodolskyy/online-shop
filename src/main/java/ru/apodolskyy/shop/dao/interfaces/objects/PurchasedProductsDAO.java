package ru.apodolskyy.shop.dao.interfaces.objects;

import ru.apodolskyy.shop.dao.interfaces.CommonDAO;
import ru.apodolskyy.shop.entity.PurchasedProducts;

import java.util.List;

public interface PurchasedProductsDAO extends CommonDAO<PurchasedProducts> {

    // Get all items
    List<PurchasedProducts> findAll();

    // Get by Purchase ID
    List<PurchasedProducts> findByPurchase(Long purchaseId);

}
