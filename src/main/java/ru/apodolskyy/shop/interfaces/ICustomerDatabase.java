package ru.apodolskyy.shop.interfaces;

import java.util.ArrayList;

// База данных пользователей

// TODO если создавать интерфейс для операция с БД, то лучше использовать паттерн DAO и описать там все методы (add, delete, update, findAll и пр.), вообще это было нашим след. шагом


public interface ICustomerDatabase {

    ArrayList<ICustomer> getCustomerList();

    void addCustomer(ICustomer customer);
    void deleteCustomer(ICustomer customer);
    void showCustomer();

}
