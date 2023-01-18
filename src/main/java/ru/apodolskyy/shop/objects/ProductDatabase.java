package ru.apodolskyy.shop.objects;

import ru.apodolskyy.shop.interfaces.IProduct;
import ru.apodolskyy.shop.interfaces.IProductDatabase;

import java.util.ArrayList;

public class ProductDatabase implements IProductDatabase {

    public ArrayList<IProduct> products = new ArrayList<>();

    @Override
    public ArrayList<IProduct> getProductList() {
        return products;
    }



    // добавление товара
    @Override
    public void addProduct(IProduct product) {
        products.add(product);
    }



    // удаление товара
    @Override
    public void deleteProduct(IProduct product) {
        products.remove(product);
    }

    public void deleteProduct(String item) {
        for (IProduct product : products) {
            if (product.getItem().equals(item)){
                products.remove(product);
                System.out.println("Item " + item + " deleted");
                break;
            }
        }
    }



    // показ товара
    @Override
    public void showProducts() {
        for (IProduct product : products) {
            System.out.println("Товар: " + product.getItem() + ", цена: " + product.getPrice());
        }
    }

}
