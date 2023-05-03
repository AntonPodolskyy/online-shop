package ru.apodolskyy.shop;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;

@Log4j2
public class Main {
    public static void main(String[] args) {

//        Session session = HibernateUtil_customers.getSessionFactory().openSession();
//        session.close();
//        HibernateUtil_customers.close();

        Session session2 = HibernateUtil_purchases.getSessionFactory().openSession();
        session2.close();
        HibernateUtil_purchases.close();


    }
}
