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

            Product product1 = new Product("PS5", 1);
            Product product2 = new Product("PS5 Controller", 1);

            Product product3 = new Product("Xbox One", 1);

            List<Product> list1 = new ArrayList<>();
            list1.add(product1);
            list1.add(product2);

            Order order1 = new Order(list1, new GregorianCalendar(2022, 1, 3).getTime());

            List<Product> list2 = new ArrayList<>();
            list2.add(product3);

            Order order2 = new Order(list2, new GregorianCalendar(2022, 1, 3).getTime());

            Invoice invoice1 = new Invoice(549.99F);
            Invoice invoice2 = new Invoice(499.99F);

            order1.setInvoice(invoice1);
            order2.setInvoice(invoice2);

//            entityManager.persist(product1);
//            entityManager.persist(product2);
//            entityManager.persist(product3);
//
//            entityManager.persist(order1);
//            entityManager.persist(order2);
//
//            entityManager.persist(invoice1);
//            entityManager.persist(invoice2);

            Order orderOne = entityManager.find(Order.class, 1);

//            System.out.println(orderOne);

            Order orderTwo = entityManager.find(Order.class, 2);

//            System.out.println(orderTwo);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
