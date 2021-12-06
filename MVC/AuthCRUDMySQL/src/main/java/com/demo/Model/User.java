package com.demo.Model;

import com.demo.Validator.NotDuplicateEmail;
import com.demo.Validator.NotDuplicateId;

import javax.validation.constraints.*;

public class User {
    @NotEmpty(message = "Please Enter Name")
    private String name;

    @Min(value = 1, message = "Id must be greater than equal to 1")
    @Max(value = 1000000, message = "Id must be less than equal to 1000000")
    @NotDuplicateId
    private int id;

    @NotEmpty(message = "Please Enter College Name")
    private String college;

    @NotEmpty(message = "Please Enter Stream")
    private String stream;

    @NotEmpty(message = "Please Enter Email")
    @Email(message = "Please Enter Valid Email")
    @NotDuplicateEmail
    private String email;

    @NotEmpty(message = "Please Enter Password")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Please Enter a Valid Password. Password must contain minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
