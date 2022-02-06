package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ShoppingDBUnit");

        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Order order1 = new Order(new GregorianCalendar(2022, 1, 3).getTime());
            Order order2 = new Order(new GregorianCalendar(2022, 1, 3).getTime());

            Product product1 = new Product(order1, "PS5", 1);
            Product product2 = new Product(order1, "PS5 Controller", 1);
            Product product3 = new Product(order2, "Xbox One", 1);

            Invoice invoice1 = new Invoice(549.99F);
            Invoice invoice2 = new Invoice(499.99F);

            order1.setInvoice(invoice1);
            order2.setInvoice(invoice2);

            entityManager.persist(order1);
            entityManager.persist(order2);

            entityManager.persist(product1);
            entityManager.persist(product2);
            entityManager.persist(product3);

            entityManager.persist(invoice1);
            entityManager.persist(invoice2);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
