package com.demo;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
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

//          Aggregates

//          Count of Categories

            TypedQuery<Long> categoryCount = entityManager.createQuery("SELECT COUNT(c) FROM Categories c", Long.class);

            System.out.println("Category count");
            System.out.println(categoryCount.getSingleResult());

//          Products average

            TypedQuery<Double> productPriceAverage = entityManager.createQuery("SELECT AVG(p.price) FROM Products p", Double.class);

            System.out.println("Products average");
            System.out.println(productPriceAverage.getSingleResult());

//          Average price for each category

            Query averagePriceForEachCategory = entityManager.createQuery(
                    "SELECT c.name, AVG(p.price) FROM Categories c " +
                            "INNER JOIN c.products p GROUP BY c.name");

            List<Object[]> averagePriceForEachCategoryList = averagePriceForEachCategory.getResultList();

            System.out.println("Average price for each category");
            averagePriceForEachCategoryList.forEach(result -> System.out.println(Arrays.toString(result)));

//          Constructing objects in query (average price)

            TypedQuery<CategoryAveragePrice> averagePriceForEachCategoryObject = entityManager.createQuery(
                    "SELECT new com.demo.CategoryAveragePrice(c.name, AVG(p.price)) FROM Categories c " +
                            "INNER JOIN c.products p GROUP BY c.name", CategoryAveragePrice.class);

            List<CategoryAveragePrice> averagePriceForEachCategoryObjectList = averagePriceForEachCategoryObject.getResultList();

            System.out.println("Constructing objects in query (average)");
            averagePriceForEachCategoryObjectList.forEach(System.out::println);

//          Maximum price for each category greater than a value

            Query maxPriceForEachCategory = entityManager.createQuery(
                    "SELECT c.name, MAX(p.price) FROM Categories c " +
                            "INNER JOIN c.products p GROUP BY c.name " +
                            "HAVING MAX(p.price) > ?1");

            maxPriceForEachCategory.setParameter(1, 34000F);

            List<Object[]> maxPriceForEachCategoryList = maxPriceForEachCategory.getResultList();

            System.out.println("Maximum price for each category greater than a value");
            maxPriceForEachCategoryList.forEach(result -> System.out.println(Arrays.toString(result)));

//          Exists clause and sub query

            Query existsAndSubQuery = entityManager.createQuery(
                    "SELECT c.name, c.id FROM Categories c " +
                            "WHERE EXISTS " +
                            "(SELECT p FROM Products p WHERE p.price > ?1 AND p.category.id = c.id)");

            existsAndSubQuery.setParameter(1, 34000F);

            List<Object[]> existsAndSubQueryList = existsAndSubQuery.getResultList();

            System.out.println("Exists clause and sub query");
            existsAndSubQueryList.forEach(result -> System.out.println(Arrays.toString(result)));

//          Case and statements

            Query caseQuery = entityManager.createQuery(
                    "SELECT p.name, p.price, " +
                            "CASE p.category.id " +
                            "WHEN 1 THEN 'Electronics' " +
                            "WHEN 2 THEN 'Fashion' " +
                            "ELSE p.category.name END " +
                            "FROM Products p");

            List<Object[]> caseQueryList = caseQuery.getResultList();

            System.out.println("Case and statements");
            caseQueryList.forEach(result -> System.out.println(Arrays.toString(result)));

//            update

//            Query updateQuery = entityManager.createQuery("UPDATE Products p SET p.name = 'iPhone 13 Pro' WHERE p.name = :name");
//
//            updateQuery.setParameter("name", "iPhone 13");
//
//            int rowsUpdated = updateQuery.executeUpdate();
//
//            System.out.println(rowsUpdated);
//
//            updateQuery = entityManager.createQuery("UPDATE Categories c SET c.name = " +
//                    "CASE " +
//                    "WHEN c.id = 3 THEN 't-shirt' " +
//                    "WHEN c.id = 2 THEN 'fashion' " +
//                    "ELSE c.name " +
//                    "END");
//
//            rowsUpdated = updateQuery.executeUpdate();
//
//            System.out.println(rowsUpdated);

//            delete

//            Query deleteQuery = entityManager.createQuery("DELETE FROM Products p WHERE p.id > :id");
//
//            deleteQuery.setParameter("id", 1);
//
//            int rowsDeleted = deleteQuery.executeUpdate();
//
//            System.out.println(rowsDeleted);

//            Named Query

            TypedQuery<Category> namedQueryCategory = entityManager.createNamedQuery(Category.SELECT_CATEGORY, Category.class);

            namedQueryCategory.setParameter("name", "Fitness");

            System.out.println("Named Query for Category");
            System.out.println(namedQueryCategory.getResultList());

            TypedQuery<Product> namedQueryProductsInCategory = entityManager.createNamedQuery(Product.SELECT_PRODUCTS_IN_CATEGORY, Product.class);

            namedQueryProductsInCategory.setParameter("categoryId", 4);

            System.out.println("Named Query for Products in Category");
            System.out.println(namedQueryProductsInCategory.getResultList());

            TypedQuery<Product> namedQueryProductsInPriceRange = entityManager.createNamedQuery(Product.SELECT_PRODUCTS_IN_PRICE_RANGE, Product.class);

            namedQueryProductsInPriceRange.setParameter("low", 40000F);
            namedQueryProductsInPriceRange.setParameter("high", 90000F);

            System.out.println("Named Query for Products in price range");
            System.out.println(namedQueryProductsInPriceRange.getResultList());

//            Criteria API

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();

            CriteriaQuery<Category> categoryCriteriaQuery = builder.createQuery(Category.class);

            Root<Category> categoryRoot = categoryCriteriaQuery.from(Category.class);

            categoryCriteriaQuery.select(categoryRoot);

            TypedQuery<Category> categoryTypedQuery = entityManager.createQuery(categoryCriteriaQuery);

            System.out.println("Criteria API - Select Query");
            System.out.println(categoryTypedQuery.getResultList());

            // Criteria API = where clause

            CriteriaQuery<Product> productCriteriaQuery = builder.createQuery(Product.class);

            Root<Product> productRoot = productCriteriaQuery.from(Product.class);

            Predicate equalToId = builder.equal(productRoot.get("id"), 2);

            productCriteriaQuery.select(productRoot)
                    .where(equalToId.not());

            TypedQuery<Product> productTypedQuery = entityManager.createQuery(productCriteriaQuery);

            System.out.println("Criteria API - Where clause");
            System.out.println(productTypedQuery.getResultList());

            // Criteria API - order by clause

            productCriteriaQuery.select(productRoot)
                    .orderBy(builder.asc(productRoot.get("price")));

            productTypedQuery = entityManager.createQuery(productCriteriaQuery);

            System.out.println("Criteria API - order by clause");
            System.out.println(productTypedQuery.getResultList());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
