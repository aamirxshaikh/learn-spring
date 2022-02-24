package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueriesDBUnit");

        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Query query = entityManager.createNativeQuery("SELECT * FROM Categories", Category.class);

            List<Category> categories = query.getResultList();

            categories.forEach(System.out::println);

            query = entityManager.createNativeQuery("SELECT * FROM Products", Product.class);

            List<Product> products = query.getResultList();

            products.forEach(System.out::println);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
