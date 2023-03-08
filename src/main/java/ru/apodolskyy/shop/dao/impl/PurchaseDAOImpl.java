package ru.apodolskyy.shop.dao.impl;

import ru.apodolskyy.shop.dao.interfaces.objects.PurchaseDAO;
import ru.apodolskyy.shop.entity.Purchase;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAOImpl implements PurchaseDAO {

    private final ArrayList<Purchase> purchases = new ArrayList<>();

    /**
     * Получение заказа по ID
     * @param id - id
     * @return объект "Заказ"
     */
    @Override
    public Purchase get(long id) {
        for (Purchase purchase : purchases){
            if (purchase.getId() == id){
                return purchase;
            }
        }
        return null;
    }

    /**
     * Добавление объекта "Заказ" в БД
     * @param obj объект "Заказ"
     */
    @Override
    public void add(Purchase obj) {
        purchases.add(obj);
    }

    /**
     * Обновление объект "Заказ" (по ID)
     * @param obj объект "Заказ"
     */
    @Override
    public void update(Purchase obj) {
        for (Purchase purchase : purchases){
            if (obj.getId().equals(purchase.getId())){
                purchases.remove(purchase);
                purchases.add(obj);
                break;
            }
        }
    }

    /**
     * Удаление объект "Заказ"
     * @param purchase объект "Заказ"
     */
    @Override
    public void delete(Purchase purchase) {
        purchases.remove(purchase);
    }

    /**
     * Возврат коллекции со всеми объектами "Заказ"
     * @return коллекция объектов "Заказ"
     */
    @Override
    public List<Purchase> findAll() {
        return purchases;
    }

    /**
     * Возврат коллекции с объектами "Заказ" имеющими заданный Surname объекта Customer
     * @return коллекция отобранных объектов "Заказ"
     */
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
