package ru.apodolskyy.shop;

import ru.apodolskyy.shop.dao.impl.CustomerDAOImpl;
import ru.apodolskyy.shop.dao.impl.ProductDAOImpl;
import ru.apodolskyy.shop.dao.impl.PurchaseDAOImpl;
import ru.apodolskyy.shop.entity.*;

public class Main {
    public static void main(String[] args) {

        //Работа с клиентами
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        Customer customer1 = new Customer(1L,"Ivan", "Ivanov", "customer1", "12345");
        Customer customer2 = new Customer(2L,"Petr", "Petrov", "customer2", "23456");
        Customer customer3 = new Customer(3L, "Igor", "Moroz", "customer3", "34567");
        customerDAO.add(customer1);
        customerDAO.add(customer2);
        customerDAO.add(customer3);

        // Поиск клиента по email
//        customerDAO.findAll("customer2");
//
        // Поиск клиента по id
//        customerDAO.get(3L);

        // Показать всех клиентов (Фамилия, имя) + Удаление клиента 2 и показ всех клиентов опять
//        customerDAO.findAll();
//        customerDAO.delete(2L);
//        customerDAO.findAll();

        // Обновить данные клиента
//        customer1.setName("IvanChangedName");
//        customerDAO.update(customer1);
//        customerDAO.findAll();




        // Работа с товаром
        ProductDAOImpl productDAO = new ProductDAOImpl();
        Product product1 = new Product(1L,"Хлеб", 85);
        Product product2 = new Product(2L,"Молоко", 78);
        Product product3 = new Product(3L,"Картофель", 45);
        Product product4 = new Product("Тара");
        productDAO.add(product1);
        productDAO.add(product2);
        productDAO.add(product3);
        productDAO.add(product4);

        // Поиск товара по id
//        productDAO.get(3L);

        // Поиск товара по наименованию
//        productDAO.findAll("Хлеб");
//        productDAO.findAll("Капуста");

        // Показать все товары
//        productDAO.findAll();

        // Показать все товары (Наименование, цена) + Удаление товара 2 и показ всех товаров опять
//        productDAO.findAll();
//        productDAO.delete(2L);
//        productDAO.findAll();

        // Обновить данные товара
//        product1.setPrice(95);
//        productDAO.update(product1);
//        productDAO.findAll();




        // Работа с заказами (время заказа + клиент + товар)
        PurchaseDAOImpl purchaseDAO = new PurchaseDAOImpl();
        Purchase purchase1 = new Purchase(1L, customer1,product1);
        Purchase purchase2 = new Purchase(2L, customer2,product4);
        Purchase purchase3 = new Purchase(3L, customer3,product2);
        purchaseDAO.add(purchase1);
        purchaseDAO.add(purchase3);
        purchaseDAO.add(purchase2);

        // Показать заказ по ID
//        purchaseDAO.get(3L);

        // Удаление заказа
//        System.out.println("До удаления:");
//        purchaseDAO.findAll();
//        System.out.println();
//        purchaseDAO.delete(3L);
//        System.out.println();
//        System.out.println("После удаления:");
//        purchaseDAO.findAll();

        // Поиск заказа по фамилии заказчика
//        purchaseDAO.findAll("Moroz");

    }
}