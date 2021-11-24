package com.demo.Registration;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Registration {
    @NotEmpty
    @Size(min = 3, max = 20, message = "First Name should not be empty and should be between 3 to 20 characters")
    private String firstName;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Last Name should not be empty and should be between 3 to 20 characters")
    private String lastName;

    private String gender;

    @NotEmpty(message = "Please enter your E-mail")
    @Email(message = "Your E-mail is not valid")
    private String email;

    @Min(value = 18, message = "Your age must be 18 or above")
    private Integer age;

    private String interest;

    private String[] skills;

    public Registration() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }
}
