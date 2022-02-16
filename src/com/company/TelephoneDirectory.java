package com.company;

import java.io.Serializable;

public class TelephoneDirectory implements Serializable {
    private String phoneNumber;
    private String groupOfDirectory;
    private String name;
    private String gender;
    private String address;
    private String dateOfBirth;
    private String email;

    public TelephoneDirectory() {
    }

    public TelephoneDirectory(String phoneNumber, String groupOfDirectory, String name, String gender, String address, String dateOfBirth, String email) {
        this.phoneNumber = phoneNumber;
        this.groupOfDirectory = groupOfDirectory;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroupOfDirectory() {
        return groupOfDirectory;
    }

    public void setGroupOfDirectory(String groupOfDirectory) {
        this.groupOfDirectory = groupOfDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return phoneNumber +
                ", " + groupOfDirectory +
                ", " + name +
                ", " + gender +
                ", " + address +
                ", " + dateOfBirth +
                ", " + email;

    }
}
