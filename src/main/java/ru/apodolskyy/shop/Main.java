package ru.apodolskyy.shop;

import ru.apodolskyy.shop.objects.*;

public class Main {
    public static void main(String[] args) {

        // Работа с товаром
        ProductDatabase productDatabase = new ProductDatabase();
        Product product1 = new Product("Хлеб", 85);
        Product product2 = new Product("Молоко", 78);
        Product product3 = new Product("Картофель", 45);
        Product product4 = new Product("Тара");
        productDatabase.addProduct(product1);
        productDatabase.addProduct(product2);
        productDatabase.addProduct(product3);
        productDatabase.addProduct(product4);
//        productDatabase.deleteProduct("test2");
//        productDatabase.showProducts();


        //Работа с клиентами
        CustomerDatabase customerDatabase = new CustomerDatabase();
        Customer customer1 = new Customer("Ivan", "Ivanov");
        Customer customer2 = new Customer("Petr", "Petrov");
        Customer customer3 = new Customer("Igor", "Moroz");
        customerDatabase.addCustomer(customer1);
        customerDatabase.addCustomer(customer2);
        customerDatabase.addCustomer(customer3);
        customerDatabase.addCustomer("Artem", "Boyko");
        customerDatabase.addCustomer("Mark", "Marcjkevich");
//        System.out.println(" ------- Deleting customre 2 & 4 --------");
//        customerDatabase.deleteCustomer(customer2);
//        customerDatabase.deleteCustomer("Surname4");
//        customerDatabase.showCustomer();



        // Работа с заказами (время заказа + клиент + товар)
        PurchaseDatabase purchaseDatabase = new PurchaseDatabase();
        Purchase purchase1 = new Purchase(customer1,product1);
        Purchase purchase2 = new Purchase(customer2,product4);
        Purchase purchase3 = new Purchase(customer3,product2);
        purchaseDatabase.addPurchase(purchase1);
        purchaseDatabase.addPurchase(purchase2);
        purchaseDatabase.addPurchase(purchase3);
        purchaseDatabase.showPurchase();

    }
}