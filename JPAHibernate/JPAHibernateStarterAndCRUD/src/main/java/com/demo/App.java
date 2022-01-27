package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;
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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CarDB_Unit");

        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Car car1 = new Car("BMW", "x5", "Aamir", 99.9999F);
            Car car2 = new Car("BMW", "x10", "Xyz", 793F);
            Car car3 = new Car("XYZ", "sx10", "Abc", 224.1234F);

            entityManager.persist(car1);
            entityManager.persist(car2);
            entityManager.persist(car3);

            Owner owner1 = new Owner("Aamir", new GregorianCalendar(2000, 1, 3).getTime());
            Address address1 = new Address("Mumbai", "India");

            owner1.setAddress(address1);

            Owner owner2 = new Owner("Xyz", new GregorianCalendar(2000, 2, 3).getTime());
            Address address2 = new Address("NY", "USA");

            owner2.setAddress(address2);

            owner1.setBio("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
            owner1.setImage("image1".getBytes());

            owner2.setBio("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.");
            owner2.setImage("image2".getBytes());

            entityManager.persist(owner1);
            entityManager.persist(owner2);

            Driver driver1 = new Driver("John Doe");
            Address address3 = new Address("MA", "USA");

            driver1.setAddress(address3);

            Driver driver2 = new Driver("Jane Doe");
            Address address4 = new Address("MA", "USA");

            driver2.setAddress(address4);

            entityManager.persist(driver1);
            entityManager.persist(driver2);

            Item item1 = new Item("abc", 10.88F);
            Item item2 = new Item("xyz", 10.99F);
            Item item3 = new Item("xss", 103.11F);

            entityManager.persist(item1);
            entityManager.persist(item2);
            entityManager.persist(item3);

//            read

            Item itemOne = entityManager.find(Item.class, 1);

            System.out.println(itemOne);

            List<Item> itemList = entityManager.createQuery("SELECT i FROM Item i").getResultList();

            System.out.println(itemList);

//            update

            itemOne.setPrice(101.99F);

            entityManager.merge(itemOne);

//            delete

            entityManager.remove(itemOne);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
