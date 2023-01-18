package ru.apodolskyy.shop.objects;

import ru.apodolskyy.shop.interfaces.IPurchase;
import ru.apodolskyy.shop.interfaces.IPurchaseDatabase;

import java.util.ArrayList;

public class PurchaseDatabase implements IPurchaseDatabase {

    public ArrayList<IPurchase> purchases = new ArrayList<>();

    @Override
    public ArrayList<IPurchase> getPurchaseList() {
        return purchases;
    }


    // Добавление заказа
    @Override
    public void addPurchase(IPurchase purchase) {
        purchases.add(purchase);
    }


    // Удаление заказа
    @Override
    public void deletePurchase(IPurchase purchase) {
        System.out.println("Заказ " + purchase + " удален");
        purchases.remove(purchase);
    }


    // Просмотр заказов
    @Override
    public void showPurchase() {
        for (IPurchase purchase : purchases){
            System.out.println("Заказ от " +
                    purchase.getOrderTime() +
                    ", заказчик " +
                    purchase.getCustomer().getSurname() +
                    " " +
                    purchase.getCustomer().getSurname() +
                    ". Заказ: " +
                    purchase.getProduct().getItem() +
                    ", стоимость: " +
                    purchase.getProduct().getPrice());
        }
    }
}
