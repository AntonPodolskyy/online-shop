package ru.apodolskyy.shop.dao.impl;

import ru.apodolskyy.shop.dao.interfaces.objects.CustomerDAO;
import ru.apodolskyy.shop.entity.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private static ArrayList<Customer> customers = new ArrayList<>();

    @Override
    public Customer get(long id) {
        for (Customer customer : customers){
            if (customer.getId() == id){
                System.out.println("По ID найден клиент " + customer.getSurname() + " " + customer.getName());
                break;
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

    }

    @Override
    public void delete(long id) {
        for (Customer customer : customers){
            if (customer.getId() == id){
                System.out.println("Клиент " + customer.getSurname() + " " + customer.getName() + " удален");
                customers.remove(customer);
                break;
            }
        }
    }

    @Override
    public List<Customer> findAll() {
        for (Customer customer : customers){
            System.out.println("Клиент: " + customer.getSurname() + " " + customer.getName());
        }
        return null;
    }

    @Override
    public List<Customer> findAll(String email) {
        for (Customer customer : customers){
            if (customer.getEmail().equals(email)){
                System.out.println("По email: " + email + " найден клиент " + customer.getSurname() + " " + customer.getName());
            }
        }
        return null;
    }

}
