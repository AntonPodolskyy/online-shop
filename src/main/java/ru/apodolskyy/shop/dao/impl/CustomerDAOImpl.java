package ru.apodolskyy.shop.dao.impl;

import ru.apodolskyy.shop.dao.interfaces.objects.CustomerDAO;
import ru.apodolskyy.shop.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private static final ArrayList<Customer> customers = new ArrayList<>();

    /**
     * Получение клиента по ID
     * @param id - id
     * @return объект "Клиент"
     */
    @Override
    public Customer get(long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Добавление объекта "Клиент" в БД
     * @param obj объект "Клиент"
     */
    @Override
    public void add(Customer obj) {
        customers.add(obj);
    }

    /**
     * Обновление объект "Клиент" (по ID)
     * @param obj объект "Клиент"
     */
    @Override
    public void update(Customer obj) {
        for (Customer customer : customers) {
            if (obj.getId().equals(customer.getId())) {
                customers.remove(customer);
                customers.add(obj);
                break;
            }
        }
    }

    /**
     * Удаление объект "Клиент"
     * @param customer объект "Клиент"
     */
    @Override
    public void delete(Customer customer) {
        customers.remove(customer);
    }

    /**
     * Возврат коллекции со всеми объектами "Клиент"
     * @return коллекция объектов "Клиент"
     */
    @Override
    public List<Customer> findAll() {
        return customers;
    }


    /**
     * Возврат коллекции с объектами "Клиент" имеющими заданный Email
     * @return коллекция отобранных объектов "Клиент"
     */
    @Override
    public List<Customer> findAll(String email) {

        List<Customer> findResult = new ArrayList<>();

        for (Customer customer : customers){
            if (customer.getEmail().equals(email)){
                findResult.add(customer);
            }
        }

        return findResult;
    }

}
