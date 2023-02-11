package ru.apodolskyy.shop.dao.impl;

import ru.apodolskyy.shop.dao.interfaces.objects.ProductDAO;
import ru.apodolskyy.shop.entity.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private final ArrayList<Product> products = new ArrayList<>();

    @Override
    public Product get(long id) {
        for (Product product : products){
            if (product.getId() == id){
                return product;
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
        for (Product product : products){
            if (obj.getId().equals(product.getId())){
                products.remove(product);
                products.add(obj);
            }
        }

    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

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
