package com.example.loyalty.model;

public class CustomerPatchDto {

    private String email;
    private Integer loyaltyPoints;

    public CustomerPatchDto() {
    }

    public CustomerPatchDto(String email, Integer loyaltyPoints) {
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
