package ru.apodolskyy.shop.objects;

import lombok.Getter;
import lombok.Setter;
import ru.apodolskyy.shop.interfaces.ICustomer;
import ru.apodolskyy.shop.interfaces.IProduct;
import ru.apodolskyy.shop.interfaces.IPurchase;

import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
public class Purchase implements IPurchase {

    String orderTime;
    ICustomer customer;
    IProduct product;

    // при создании заказа добавляется текущая дата и время
    public Purchase(Customer customer, Product product) {
        this.orderTime = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date());
        this.customer = customer;
        this.product = product;
    }
}

