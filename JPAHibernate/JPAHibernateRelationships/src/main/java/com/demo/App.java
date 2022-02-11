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
            Product product4 = new Product("Xbox Series X/S Controller", 1);

            List<Product> listOne = new ArrayList<>();

            List<Product> listTwo = new ArrayList<>();

            listOne.add(product1);
            listOne.add(product2);

            listTwo.add(product1);
            listTwo.add(product2);
            listTwo.add(product3);
            listTwo.add(product4);

            Order order1 = new Order(listOne, new GregorianCalendar(2022, 1, 3).getTime());
            Order order2 = new Order(listTwo, new GregorianCalendar(2022, 4, 3).getTime());

            List<Order> customerOneOrders = new ArrayList<>();
            List<Order> customerTwoOrders = new ArrayList<>();

            customerOneOrders.add(order1);
            customerTwoOrders.add(order2);

            Customer customerOne = new Customer("John", order1.getProducts(), customerOneOrders);
            Customer customerTwo = new Customer("James", order2.getProducts(), customerTwoOrders);

            Invoice invoice1 = new Invoice(549.99F);
            Invoice invoice2 = new Invoice(539.99F);

            order1.setInvoice(invoice1);
            order2.setInvoice(invoice2);

            entityManager.persist(customerOne);
            entityManager.persist(customerTwo);

            entityManager.persist(product1);
            entityManager.persist(product2);
            entityManager.persist(product3);
            entityManager.persist(product4);

            entityManager.persist(order1);
            entityManager.persist(order2);

            entityManager.persist(invoice1);
            entityManager.persist(invoice2);

//            Product productOne = entityManager.find(Product.class, 1);
//
//            System.out.println(productOne);
//
//            Product productThree = entityManager.find(Product.class, 3);
//
//            System.out.println(productThree);
////
//            Order orderOne = entityManager.find(Order.class, 1);
//
//            System.out.println(orderOne);
//            System.out.println(orderOne.getProducts());
//
//            Order orderTwo = entityManager.find(Order.class, 2);
//
//            System.out.println(orderTwo);
//            System.out.println(orderTwo.getProducts());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
