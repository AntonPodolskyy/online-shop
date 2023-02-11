package ru.apodolskyy.shop.dao.impl;

import ru.apodolskyy.shop.dao.interfaces.objects.PurchaseDAO;
import ru.apodolskyy.shop.entity.Purchase;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAOImpl implements PurchaseDAO {

    private final ArrayList<Purchase> purchases = new ArrayList<>();

    @Override
    public Purchase get(long id) {
        for (Purchase purchase : purchases){
            if (purchase.getId() == id){
                return purchase;
            }
        }
        return null;
    }

    @Override
    public void add(Purchase obj) {
        purchases.add(obj);
    }

    @Override
    public void update(Purchase obj) {
        for (Purchase purchase : purchases){
            if (obj.getId().equals(purchase.getId())){
                purchases.remove(purchase);
                purchases.add(obj);
            }
        }
    }

    @Override
    public void delete(Purchase purchase) {
        purchases.remove(purchase);
    }

    @Override
    public List<Purchase> findAll() {
        return purchases;
    }

    @Override
    public List<Purchase> findAll(String surname) {

        List<Purchase> findResult = new ArrayList<>();

        for (Purchase purchase : purchases){
            if (purchase.getCustomer().getSurname().equals(surname)){
                findResult.add(purchase);
            }
        }
        return findResult;
    }


}
