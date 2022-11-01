/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoothsGarage;

import static BoothsGarage.DBmethods.*;
import static BoothsGarage.LoginGUI.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Daniel Hayes
 */
public class LineItemsGUI extends JFrame{
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new LineItemsGUI(job_no).setVisible(true);
        });
    }
    
    private final JButton btnAddItem;
    private final JButton btnShowCatalogue;
    private static JTable lineItems;
    public static DefaultTableModel tableModel = new DefaultTableModel();
    private static String job_no;
    
    public LineItemsGUI(String won) {
        job_no = won;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        tableModel = new DefaultTableModel();
        lineItems = new JTable(tableModel);
        btnAddItem = new JButton("Add Item");
        btnShowCatalogue = new JButton("Show Catalogue");
        add(new JScrollPane(lineItems), BorderLayout.CENTER);
        add(btnAddItem, BorderLayout.PAGE_START);
        add(btnShowCatalogue, BorderLayout.PAGE_END);
        btnAddItem.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnAddItemActionPerformed(evt);
        });
        btnShowCatalogue.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnShowCatalogueActionPerformed(evt);
        });
        setSize(640, 480);
    }
    
    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt){
        ali.dispose();
        ali = new AddLineItemGUI();
        ali.setWorkOrderNumber(job_no);
        ali.setVisible(true);
    }
    
    private void btnShowCatalogueActionPerformed(java.awt.event.ActionEvent evt){
        sr.dispose();
        sr = new SearchResults();
        try {
            searchFullTable("items");
        } catch (SQLException ex) {
            Logger.getLogger(ItemsGUI.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        sr.setVisible(true);
    }
}
