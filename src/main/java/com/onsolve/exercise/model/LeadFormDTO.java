package com.onsolve.exercise.model;

import com.onsolve.exercise.common.Helper;

public class LeadFormDTO {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    private String formId;

    public LeadFormDTO() {
        //Default Test Data
        this.firstName = "Cratebarrel " + Helper.generateRandomNumber();
        this.lastName = "Tristan";
        this.streetAddress = "20395 Harvard Way";
        this.addressLine2 = "Address line2";
        this.city = "Riverside";
        this.state = "California";
        this.zipCode = "92507";
        this.phoneNumber = "209-200-6974";
        this.email = "onsolve.sample@gmail.com";
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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }
}
