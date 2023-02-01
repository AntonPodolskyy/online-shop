package ru.apodolskyy.shop.interfaces;


/*
    Покупки (покупатель, товар, дата покупки)
*/

// TODO если только свойства, то можно не создавать интерфейс, а обойтись просто POJO

public interface IPurchase {

    String getOrderTime();
    IProduct getProduct();
    ICustomer getCustomer();
}
