package ru.apodolskyy.shop.entity;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return id.equals(purchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

