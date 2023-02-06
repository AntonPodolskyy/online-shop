package ru.apodolskyy.shop.entity;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
public class Purchase{

    private Long id;
    private String orderTime;
    private Customer customer;
    private Product product;

    // при создании заказа добавляется текущая дата и время
    public Purchase(Long id, Customer customer, Product product) {
        this.orderTime = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date());
        this.customer = customer;
        this.product = product;
        this.id = id;
    }
}

