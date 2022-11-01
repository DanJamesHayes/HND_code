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
public class controller {
    
    public static void main(String[] args){
        
        Person p1 = PersonFactory.getInstance("customer");
        p1.setRef("C00001");
        p1.setFirst_name(null);
        p1.setSurname(null);
        p1.setAddress(null);
        p1.setPostcode(null);
        p1.setPhone_no(null);
        String values = p1.toString();
        System.out.println(values);
        
        Person p2 = PersonFactory.getInstance("staff");
        p1.setRef("S001");
        p1.setFirst_name(null);
        p1.setSurname(null);
        p1.setAddress(null);
        p1.setPostcode(null);
        p1.setPhone_no(null);
        p1.setDob(null);
        String p2values = p2.toString();
        System.out.println(p2values);
        
    }
}
