package com.onsolve.exercise.model;

import com.onsolve.exercise.common.Helper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
        this.firstName = "Barrel ";
        this.lastName = "Tristan" + Helper.generateRandomNumber();
        this.streetAddress = "20395 Harvard Way";
        this.addressLine2 = "Address line2";
        this.city = "Riverside";
        this.state = "California";
        this.zipCode = "92507";
        this.phoneNumber = "209-200-6974";
        this.email = "onsolve.sample@gmail.com";
    }
}
