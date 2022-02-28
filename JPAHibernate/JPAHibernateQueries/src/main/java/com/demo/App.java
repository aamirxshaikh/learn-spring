package com.demo;

import javax.persistence.*;
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

//            named parameter

//            TypedQuery<Product> productTypedQuery = entityManager.createQuery("SELECT p FROM Products p WHERE p.id < :id ORDER BY p.price DESC", Product.class);

            TypedQuery<Product> productTypedQuery = entityManager.createQuery("SELECT p FROM Products p WHERE p.name like :name", Product.class);

            productTypedQuery.setParameter("name", "Sam%");

//            positional parameter

//            TypedQuery<Product> productTypedQuery = entityManager.createQuery("SELECT p FROM Products p WHERE p.id = ?2", Product.class);
//
//            productTypedQuery.setParameter(2, 2);

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
