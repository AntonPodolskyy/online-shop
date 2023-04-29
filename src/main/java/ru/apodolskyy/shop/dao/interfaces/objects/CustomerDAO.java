package ru.apodolskyy.shop.dao.interfaces.objects;

import ru.apodolskyy.shop.dao.interfaces.CommonDAO;
import ru.apodolskyy.shop.dao.interfaces.FindDAO;
import ru.apodolskyy.shop.entity.Customer;

public interface CustomerDAO extends CommonDAO<Customer>, FindDAO<Customer> {

    Customer getByEmail(String email);

}
