package com.example.loyalty.model;

public class CustomerRegistrationDto {

    private String firstName;
    private String lastName;
    private String email;
    private int loyaltyPoints;
    private String registrationDate; // Optional: could be auto-generated

    public CustomerRegistrationDto() {
    }

    public CustomerRegistrationDto(String firstName, String lastName, String email, int loyaltyPoints, String registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
        this.registrationDate = registrationDate;
    }

    // Getters
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
}
