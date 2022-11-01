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
public class Staff extends Person{
    
    private String staff_ref;
    
    @Override
    public void setRef(String staff_ref) {
        this.staff_ref = staff_ref;
    }
    
    @Override
    public String toString() {
        return "'" + staff_ref + "'," + super.toStringStaff();
    }
}