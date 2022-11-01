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
public class WorkOrder {
    
    private final String job_no;
    private final String cust_ref;
    private final String staff_ref;
    private final String job_desc;
    private final String completion_date;
    private final String garage_name;
    private final String net_total;
    private final String vat;
    private final String total;

    public WorkOrder(String job_no, String cust_ref, String staff_ref, 
            String job_desc, String completion_date, String garage_name, 
            String net_total, String vat, String total) {
        this.job_no = job_no;
        this.cust_ref = cust_ref;
        this.staff_ref = staff_ref;
        this.job_desc = job_desc;
        this.completion_date = completion_date;
        this.garage_name = garage_name;
        this.net_total = net_total;
        this.vat = vat;
        this.total = total;
    }
    
    @Override
    public String toString() {
        return "'" + job_no + "','" + cust_ref + "','" + staff_ref + "','" 
                + job_desc + "'," + completion_date + ",'" + garage_name 
                + "','" + net_total + "','" + vat + "','" + total + "'";
    }
}