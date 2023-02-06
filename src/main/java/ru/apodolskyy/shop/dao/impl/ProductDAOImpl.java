package ru.apodolskyy.shop.dao.impl;

import ru.apodolskyy.shop.dao.interfaces.objects.ProductDAO;
import ru.apodolskyy.shop.entity.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public Product get(long id) {
        for (Product product : products){
            if (product.getId() == id){
                System.out.println("По ID найден товар " + product.getItem() + ", цена " + product.getPrice());
                break;
            }
        }
        return null;
    }

    @Override
    public void add(Product obj) {
        products.add(obj);
    }

    @Override
    public void update(Product obj) {

    }

    @Override
    public void delete(long id) {
        for (Product product : products){
            if (product.getId() == id){
                System.out.println("Продукт " + product.getItem() + " по цене: " + product.getPrice() + " удален");
                products.remove(product);
                break;
            }
        }

    }

    @Override
    public List<Product> findAll() {
        for (Product product : products){
            System.out.println("Товар: " + product.getItem() + ", цена: " + product.getPrice());
        }
        return null;
    }

    @Override
    public List<Product> findAll(String item) {
        for (Product product : products){
            if (product.getItem().equals(item)){
                System.out.println("Найден товар: " + product.getItem() + ", цена: " + product.getPrice());
            }
        }
        return null;
    }
}
