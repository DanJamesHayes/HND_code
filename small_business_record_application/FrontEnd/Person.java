/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoothsGarage;

/**
 *
 * @author haz
 */
public abstract class Person {
    
    private String first_name;
    private String surname;
    private String address;
    private String postcode;
    private String phone_no;
    private String dob;
    
    
    public abstract void setRef(String ref);
    
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public String toStringCust() {
        return "'" + first_name + "','" + surname 
                + "','" + address + "','" + postcode 
                + "','" + phone_no + "'";
    }
    
    public String toStringStaff() {
        return "'" + first_name + "','" + surname 
                + "','" + address + "','" + postcode 
                + "','" + phone_no + "'," + dob;
    }
}