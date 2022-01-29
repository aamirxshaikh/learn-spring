package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;

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

//            Invoice invoice1 = new Invoice(499.99F);
//            Invoice invoice2 = new Invoice(59.99F);
//
//            Order order1 = new Order("PS5", 1, new GregorianCalendar(2022, 1, 3).getTime());
//            Order order2 = new Order("PS5 Controller", 1, new GregorianCalendar(2022, 1, 3).getTime());
//
//            order1.setInvoice(invoice1);
//            order2.setInvoice(invoice2);
//
//            entityManager.persist(order1);
//            entityManager.persist(order2);
//
//            entityManager.persist(invoice1);
//            entityManager.persist(invoice2);

//            Order orderOne = entityManager.find(Order.class, 1);
//
//            System.out.println(orderOne);
//
//            Order orderTwo = entityManager.find(Order.class, 2);
//
//            System.out.println(orderTwo);

            Invoice invoiceOne = entityManager.find(Invoice.class, 1);

            System.out.println(invoiceOne);

            Invoice invoiceTwo = entityManager.find(Invoice.class, 2);

            System.out.println(invoiceTwo);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
