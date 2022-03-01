package com.demo;

import javax.persistence.*;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueriesDBUnit");

        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

//            referencing foreign keys

            TypedQuery<Product> productTypedQuery = entityManager.createQuery("SELECT p FROM Products p WHERE p.category.id = :category_id", Product.class);

            productTypedQuery.setParameter("category_id", 4);

            List<Product> product = productTypedQuery.getResultList();

            System.out.println(product);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
