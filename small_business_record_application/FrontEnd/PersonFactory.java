/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoothsGarage;

/**
 *
 * @author hazwire
 */
public class PersonFactory {
    public static Person getInstance(String p){
        
        if(p.equalsIgnoreCase("customer")){
            return new Customer();
        }else if(p.equalsIgnoreCase("staff")){
            return new Staff();
        }else{
            System.out.println("No position assigned");
            return null;
        }   
    }
}
