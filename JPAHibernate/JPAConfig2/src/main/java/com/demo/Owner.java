package com.demo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Owner {
    @Id
    @SequenceGenerator(name = "seq", sequenceName = "SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Integer id;
    private String name;
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
