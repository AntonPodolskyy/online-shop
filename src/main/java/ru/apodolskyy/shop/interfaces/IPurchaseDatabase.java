package ru.apodolskyy.shop.interfaces;

import java.util.ArrayList;

// База данных заказов
public interface IPurchaseDatabase {

    ArrayList<IPurchase> getPurchaseList();

    void addPurchase(IPurchase purchase);
    void deletePurchase(IPurchase purchase);
    void showPurchase();
}
