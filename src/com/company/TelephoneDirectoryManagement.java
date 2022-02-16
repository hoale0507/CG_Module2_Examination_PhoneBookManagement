package com.company;

import java.util.ArrayList;

public class TelephoneDirectoryManagement {
    private ArrayList<TelephoneDirectory> telephoneDirectories = new ArrayList<>();

    public TelephoneDirectoryManagement() {
    }

    public TelephoneDirectoryManagement(ArrayList<TelephoneDirectory> telephoneDirectories) {
        this.telephoneDirectories = telephoneDirectories;
    }

    public ArrayList<TelephoneDirectory> getTelephoneDirectories() {
        return telephoneDirectories;
    }

    public void setTelephoneDirectories(ArrayList<TelephoneDirectory> telephoneDirectories) {
        this.telephoneDirectories = telephoneDirectories;
    }

    public int size(){
        return telephoneDirectories.size();
    }

    public void displayAllDirectory(){
        for (int i = 0; i < telephoneDirectories.size(); i++) {
            System.out.println(telephoneDirectories.get(i));
        }
    }

    public void add(TelephoneDirectory telephoneDirectory){
        telephoneDirectories.add(telephoneDirectory);
    }

    public boolean isExitedPhoneNumber(String phonenumber){
        for (int i = 0; i < telephoneDirectories.size(); i++) {
            if(phonenumber.equals(telephoneDirectories.get(i).getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    public int indexFoundByPhoneNumber(String phoneNumber){
        for (int i = 0; i < telephoneDirectories.size(); i++) {
            if(phoneNumber.equals(telephoneDirectories.get(i).getPhoneNumber())){
                return i;
            }
        }
        return -1;
    }

    public void update(String phonenumber, String group, String name, String gender, String address, String dateOfBirth, String email){
        telephoneDirectories.get(indexFoundByPhoneNumber(phonenumber)).setGroupOfDirectory(group);
        telephoneDirectories.get(indexFoundByPhoneNumber(phonenumber)).setName(name);
        telephoneDirectories.get(indexFoundByPhoneNumber(phonenumber)).setAddress(address);
        telephoneDirectories.get(indexFoundByPhoneNumber(phonenumber)).setGender(gender);
        telephoneDirectories.get(indexFoundByPhoneNumber(phonenumber)).setDateOfBirth(dateOfBirth);
        telephoneDirectories.get(indexFoundByPhoneNumber(phonenumber)).setEmail(email);
    }

    public void delete(String phonenumber){
        telephoneDirectories.remove(indexFoundByPhoneNumber(phonenumber));
    }

    public TelephoneDirectory searchByPhone(String phoneNumber){
        return telephoneDirectories.get(indexFoundByPhoneNumber(phoneNumber));
    }

    public int indexFoundByName(String name) {
        for (int i = 0; i < telephoneDirectories.size(); i++) {
            if(name.equals(telephoneDirectories.get(i).getName())){
                return i;
            }
        }
        return -1;
    }

    public TelephoneDirectory searchByName(String name){
        return telephoneDirectories.get(indexFoundByPhoneNumber(name));
    }
}
