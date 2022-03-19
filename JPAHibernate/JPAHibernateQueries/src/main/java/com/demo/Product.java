package com.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Products")
@NamedQueries({
        @NamedQuery(
                name = Product.SELECT_PRODUCTS_IN_CATEGORY,
                query = "SELECT p FROM Products p WHERE p.category.id = :categoryId"
        ),
        @NamedQuery(
                name = Product.SELECT_PRODUCTS_IN_PRICE_RANGE,
                query = "SELECT p FROM Products p WHERE p.price >= :low AND p.price <= :high"
        )
})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SELECT_PRODUCTS_IN_CATEGORY = "selectProductsInCategory";

    public static final String SELECT_PRODUCTS_IN_PRICE_RANGE = "selectProductsInPriceRange";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Float price;

    private boolean inStock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                '}';
    }
}
