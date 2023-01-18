package ru.apodolskyy.shop.interfaces;


/*
    Покупки (покупатель, товар, дата покупки)
*/


public interface IPurchase {

    String getOrderTime();
    IProduct getProduct();
    ICustomer getCustomer();
}
