/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoothsGarage;

/**
 *
 * @author Daniel Hayes
 */
public class Line_items {
    
    private final String job_number;
    private final String item_code;
    private final String quantity;

    public Line_items(String job_number, String item_code, String quantity) {
        this.job_number = job_number;
        this.item_code = item_code;
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "'" + job_number + "','" + item_code + "','" + quantity + "'";
    }
}
