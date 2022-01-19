package com.demo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Owner {
    @Id
    @TableGenerator(name = "generator",
            table = "Seq",
            pkColumnName = "gen_name",
            pkColumnValue = "owner_id",
            valueColumnName = "gen_val",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
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
