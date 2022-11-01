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
public class Items {
    
    private final String item_code;
    private final String item_desc;
    private final String item_cost_ex_vat;

    public Items(String item_code, String item_desc, String item_cost_ex_vat) {
        this.item_code = item_code;
        this.item_desc = item_desc;
        this.item_cost_ex_vat = item_cost_ex_vat;
    }
    
    @Override
    public String toString() {
        return "'" + item_code + "', '" + item_desc + "', " + item_cost_ex_vat;
    }
}
