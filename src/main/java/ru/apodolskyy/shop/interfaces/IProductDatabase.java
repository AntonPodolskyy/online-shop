package ru.apodolskyy.shop.interfaces;

import java.util.ArrayList;

// TODO когда будет единый DAO интерфейс, то все объекты будут просто реализовывать его методы и не нужно будет создавать отдельные интерфейсы для каждого типа объекта


// База данных товаров
public interface IProductDatabase {

    ArrayList<IProduct> getProductList();

    void addProduct(IProduct product);
    void deleteProduct(IProduct product);
    void showProducts();

}
