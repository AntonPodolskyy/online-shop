package ru.apodolskyy.shop.dao.impl;

import ru.apodolskyy.shop.dao.interfaces.objects.ProductDAO;
import ru.apodolskyy.shop.entity.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private final ArrayList<Product> products = new ArrayList<>();

    /**
     * Получение товара по ID
     * @param id - id
     * @return объект "Товар"
     */
    @Override
    public Product get(long id) {
        for (Product product : products){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    /**
     * Добавление объекта "Товар" в БД
     * @param obj объект "Товар"
     */
    @Override
    public void add(Product obj) {
        products.add(obj);
    }

    /**
     * Обновление объекта "Товар" (По ID)
     * @param obj объект "Товар"
     */
    @Override
    public void update(Product obj) {
        for (Product product : products){
            if (obj.getId().equals(product.getId())){
                products.remove(product);
                products.add(obj);
                break;
            }
        }

    }

    /**
     * Удаление объект "Товар"
     * @param product объект "Товар"
     */
    @Override
    public void delete(Product product) {
        products.remove(product);
    }

    /**
     * Возврат коллекции со всеми объектами "Товар"
     * @return коллекция объектов "Товар"
     */
    @Override
    public List<Product> findAll() {
        return products;
    }

    /**
     * Возврат коллекции с объектами "Товар" имеющими заданное наименование
     * @return коллекция отобранных объектов "Товар"
     */
    @Override
    public List<Product> findAll(String item) {
        List<Product> productListByItem = new ArrayList<>();
        for (Product product : products){
            if (product.getItem().equals(item)){
                productListByItem.add(product);
            }
        }
        return productListByItem;
    }
}
