package ru.apodolskyy.shop.interfaces;

import java.util.ArrayList;

// База данных товаров
public interface IProductDatabase {

    ArrayList<IProduct> getProductList();

    void addProduct(IProduct product);
    void deleteProduct(IProduct product);
    void showProducts();

}
