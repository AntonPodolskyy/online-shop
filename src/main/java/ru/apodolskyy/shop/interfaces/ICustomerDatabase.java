package ru.apodolskyy.shop.interfaces;

import java.util.ArrayList;

// База данных пользователей
public interface ICustomerDatabase {

    ArrayList<ICustomer> getCustomerList();

    void addCustomer(ICustomer customer);
    void deleteCustomer(ICustomer customer);
    void showCustomer();

}
