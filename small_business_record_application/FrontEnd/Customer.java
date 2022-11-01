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
public class Customer extends Person{
    
    private String cust_ref;
    
    @Override
    public void setRef(String cust_ref) {
        this.cust_ref = cust_ref;
    }
    
    @Override
    public String toString() {
        return "'" + cust_ref + "'," + super.toStringCust();
    }
}