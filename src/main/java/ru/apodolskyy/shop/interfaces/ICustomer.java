package ru.apodolskyy.shop.interfaces;


/*
    Покупатели (имя, фамилия)
*/

// TODO если только свойства, то можно не создавать интерфейс, а обойтись просто POJO

public interface ICustomer {

    String getName();
    String getSurname();
}
