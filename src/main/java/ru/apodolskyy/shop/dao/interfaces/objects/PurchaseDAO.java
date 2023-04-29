package ru.apodolskyy.shop.dao.interfaces.objects;

import ru.apodolskyy.shop.dao.interfaces.CommonDAO;
import ru.apodolskyy.shop.entity.Purchase;

import java.util.List;

public interface PurchaseDAO extends CommonDAO<Purchase>{

    // Get all purchases
    List<Purchase> findAll();

    // Get all purchases by Customer ID
    List<Purchase> findAll(Long customerId);


}
