package ru.apodolskyy.shop.dao.impl;

import ru.apodolskyy.shop.dao.interfaces.objects.PurchaseDAO;
import ru.apodolskyy.shop.entity.Purchase;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAOImpl implements PurchaseDAO {

    private ArrayList<Purchase> purchases = new ArrayList<>();

    @Override
    public Purchase get(long id) {
        for (Purchase purchase : purchases){
            if (purchase.getId() == id){
                System.out.println("По ID найден заказ от " + purchase.getCustomer().getSurname() +
                        ", дата заказа " + purchase.getOrderTime() +
                        " Товар: " + purchase.getProduct().getItem() +
                        ", цена " + purchase.getProduct().getPrice());
                break;
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
    }

    @Override
    public void delete(long id) {
        for (Purchase purchase : purchases){
            if (purchase.getId() == id){
                System.out.println("Заказ от: " + purchase.getCustomer().getSurname() + " от " + purchase.getOrderTime() + " удален");
                purchases.remove(purchase);
                break;
            }
        }
    }

    @Override
    public List<Purchase> findAll() {
        for (Purchase purchase : purchases){
            System.out.println("Заказ от: " + purchase.getCustomer().getSurname() + ", дата " + purchase.getOrderTime() + ", ID " + purchase.getId());
        }
        return null;
    }

    @Override
    public List<Purchase> findAll(String surname) {
        for (Purchase purchase : purchases){
            if (purchase.getCustomer().getSurname().equals(surname)){
                System.out.println("Найден заказ от: " + purchase.getOrderTime() + ", ID заказа: " + purchase.getId());
            }
        }
        return null;
    }


}
