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

//            inner joins

//            inner fetch join

            TypedQuery<Category> fetchJoinQuery = entityManager.createQuery("SELECT c FROM Categories c INNER JOIN FETCH c.products p WHERE c.name = :name AND p.price > :price", Category.class);

            fetchJoinQuery.setParameter("name", "Electronics");
            fetchJoinQuery.setParameter("price", 35000F);

            List<Category> categories = fetchJoinQuery.getResultList();

            System.out.println(categories);

//            inner join

            TypedQuery<Category> innerJoinQuery = entityManager.createQuery("SELECT c FROM Categories c INNER JOIN c.products p WHERE p.name IN (?1, ?2, ?3)", Category.class);

            innerJoinQuery.setParameter(1, "Learning Java");
            innerJoinQuery.setParameter(2, "T-shirt");
            innerJoinQuery.setParameter(3, "iPhone 13");

            categories = innerJoinQuery.getResultList();

            System.out.println(categories);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
