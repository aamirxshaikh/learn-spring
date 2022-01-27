package com.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Invoices")
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float amount;

    private Long invoiceKey;

    public Invoice() {
    }

    public Invoice(Float amount) {
        this.amount = amount;
        this.invoiceKey = ((Double) (Math.random() * 1000000)).longValue();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public long getInvoiceKey() {
        return invoiceKey;
    }

    public void setInvoiceKey(long invoiceKey) {
        this.invoiceKey = invoiceKey;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", amount=" + amount +
                ", invoiceKey=" + invoiceKey +
                '}';
    }
}
