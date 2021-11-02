package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration();

        configuration = configuration.configure("META-INF/hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Customer customer1 = new Customer(100, "Yea", "YEA", "Associate", 9999);
        Customer customer2 = new Customer(100, "Pqr", "Xyz", "Associate", 8999);

        Transaction transaction = session.beginTransaction();

        session.save(customer1);
        session.save(customer2);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
