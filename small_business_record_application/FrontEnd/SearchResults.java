/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoothsGarage;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Daniel Hayes
 */
public class SearchResults extends JFrame {
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new SearchResults().setVisible(true);
        });    
    }
    
    private static JTable results;
    public static DefaultTableModel tableModel = new DefaultTableModel();

    public SearchResults() {
        tableModel = new DefaultTableModel();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        results = new JTable(tableModel);
        add(new JScrollPane(results), BorderLayout.CENTER);
        setSize(640, 480);
    }
}