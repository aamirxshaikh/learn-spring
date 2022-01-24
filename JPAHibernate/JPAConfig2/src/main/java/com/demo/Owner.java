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

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String bio;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] image;

    @Embedded
    private Address address;

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
