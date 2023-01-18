package ru.apodolskyy.shop.objects;

import ru.apodolskyy.shop.interfaces.ICustomer;
import ru.apodolskyy.shop.interfaces.ICustomerDatabase;
import java.util.ArrayList;

public class CustomerDatabase implements ICustomerDatabase {

    public ArrayList<ICustomer> customers = new ArrayList<>();

    @Override
    public ArrayList<ICustomer> getCustomerList() {
        return customers;
    }



    // добавление клиента
    @Override
    public void addCustomer(ICustomer customer) {
        customers.add(customer);
    }

    public void addCustomer(String name, String surname) {
        Customer customer = new Customer(name, surname);
        customers.add(customer);
    }



    // удаление клиента
    @Override
    public void deleteCustomer(ICustomer customer) {
        System.out.println("Клиент " + customer.getSurname() + " " + customer.getName() + " удален");
        customers.remove(customer);
    }

    public void deleteCustomer(String surname) {
        for (ICustomer customer : customers){
            if (customer.getSurname().equals(surname)){
                System.out.println("Клиент " + customer.getSurname() + " " + customer.getName() + " удален");
                customers.remove(customer);
                break;
            }
        }
    }



    // показ клиентов
    @Override
    public void showCustomer() {
        for (ICustomer customer : customers) {
            System.out.println("Клиент: " + customer.getSurname() + " " + customer.getName());
        }
    }
}
