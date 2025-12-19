package com.example.loyalty.model;

import java.util.Objects;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int loyaltyPoints;
    private String registrationDate;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, String email, int loyaltyPoints, String registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
        this.registrationDate = registrationDate;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "Customer{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               ", loyaltyPoints=" + loyaltyPoints +
               ", registrationDate='" + registrationDate + '\'' +
               '}';
    }
}
