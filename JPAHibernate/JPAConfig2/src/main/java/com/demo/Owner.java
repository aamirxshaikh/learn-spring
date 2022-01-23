package com.demo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "owner_name", columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(name = "owner_dob")
    private Date dob;

    public Owner() {
    }

    public Owner(String name, Date dob) {
        this.name = name;
        this.dob = dob;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
