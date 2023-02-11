package ru.apodolskyy.shop.dao.impl;

import ru.apodolskyy.shop.dao.interfaces.objects.CustomerDAO;
import ru.apodolskyy.shop.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private static final ArrayList<Customer> customers = new ArrayList<>();

    @Override
    public Customer get(long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void add(Customer obj) {
        customers.add(obj);
    }

    @Override
    public void update(Customer obj) {
        for (Customer customer : customers) {
            if (obj.getId().equals(customer.getId())) {
                customers.remove(customer);
                customers.add(obj);
            }
        }
    }

    @Override
    public void delete(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

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
