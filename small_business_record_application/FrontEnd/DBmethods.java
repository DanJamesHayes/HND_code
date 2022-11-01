/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoothsGarage;

import java.sql.*;
import static BoothsGarage.LoginGUI.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Hayes
 */
public class DBmethods {
    
    public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            String dbURL = "jdbc:oracle:thin:sys@//localhost:1521/xe";
            dbConnection = DriverManager.getConnection(dbURL, username, 
                    password);
            return dbConnection;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        return dbConnection;
    }
    
    public static void searchFullTable(String from) throws SQLException{
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultset = null;
        String lock = "LOCK TABLE sys." + from + " IN EXCLUSIVE MODE NOWAIT";
        String query = "SELECT * FROM sys." + from;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.executeUpdate(lock);
            System.out.println(lock);
            resultset = statement.executeQuery(query);
            System.out.println(query);
            ResultSetMetaData metaData = resultset.getMetaData();
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (resultset.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(resultset.getObject(i));
                }
                data.add(vector);
            }
            statement.executeUpdate("COMMIT");
            System.out.println("COMMIT");
            SearchResults.tableModel.setDataVector(data, columnNames);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (resultset != null) {
                resultset.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public static void searchWhere(String from, String where) 
            throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultset = null;
        String lock = "LOCK TABLE sys." + from + " IN EXCLUSIVE MODE NOWAIT";
        String query = "SELECT * FROM sys." + from + " WHERE " + where;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.executeUpdate(lock);
            System.out.println(lock);
            resultset = statement.executeQuery(query);
            System.out.println(query);
            ResultSetMetaData metaData = resultset.getMetaData();
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (resultset.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(resultset.getObject(i));
                }
                data.add(vector);
            }
            statement.executeUpdate("COMMIT");
            System.out.println("COMMIT");
            SearchResults.tableModel.setDataVector(data, columnNames);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (resultset != null) {
                resultset.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public static void insertRecord(String table, String entities, 
            String values) throws SQLException{
        Connection dbConnection = null;
        Statement statement = null;
        String lock = "LOCK TABLE sys." + table + " IN EXCLUSIVE MODE NOWAIT";
        String query = "INSERT INTO sys." + table + " (" + entities 
                + ") VALUES (" + values + ")";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.executeUpdate(lock);
            System.out.println(lock);
            statement.executeUpdate(query);
            System.out.println(query);
            statement.executeUpdate("COMMIT");
            System.out.println("COMMIT");
            JOptionPane.showMessageDialog(null, table + " record added", null, 
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public static void searchWhereLI(String from, String where) 
            throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultset = null;
        String lock = "LOCK TABLE sys." + from + " IN EXCLUSIVE MODE NOWAIT";
        String query = "SELECT * FROM sys." + from + " WHERE " + where;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.executeUpdate(lock);
            System.out.println(lock);
            resultset = statement.executeQuery(query);
            System.out.println(query);
            ResultSetMetaData metaData = resultset.getMetaData();
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (resultset.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(resultset.getObject(i));
                }
                data.add(vector);
            }
            statement.executeUpdate("COMMIT");
            System.out.println("COMMIT");
            LineItemsGUI.tableModel.setDataVector(data, columnNames);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (resultset != null) {
                resultset.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public static void updateStringRecord(String update, String set, 
            String where) throws SQLException{
        Connection dbConnection = null;
        Statement statement = null;
        String lock = "LOCK TABLE sys." + update + " IN EXCLUSIVE MODE NOWAIT";
        String query = "UPDATE sys." + update + " SET " + set 
                + " WHERE " + where;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.executeUpdate(lock);
            System.out.println(lock);
            statement.executeUpdate(query);
            System.out.println(query);
            statement.executeUpdate("COMMIT");
            System.out.println("COMMIT");
            JOptionPane.showMessageDialog(null, update 
                    + " record amended", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public static void deleteRecord(String from, String where) throws SQLException{
        Connection dbConnection = null;
        Statement statement = null;
        String lock = "LOCK TABLE sys." + from + " IN EXCLUSIVE MODE NOWAIT";
        String query = "DELETE FROM sys." + from + " WHERE " + where;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.executeUpdate(lock);
            System.out.println(lock);
            statement.executeUpdate(query);
            System.out.println(query);
            statement.executeUpdate("COMMIT");
            System.out.println("COMMIT");
            JOptionPane.showMessageDialog(null, from + " record deleted", 
                    null, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public static String countWhere(String from, String where) 
            throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet resultset = null;
        String lock = "LOCK TABLE sys." + from + " IN EXCLUSIVE MODE NOWAIT";
        String query = "SELECT COUNT(*) FROM sys." + from + " WHERE " + where;
        String records = "0";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.executeUpdate(lock);
            System.out.println(lock);
            resultset = statement.executeQuery(query);
            System.out.println(query);
            while (resultset.next()) {
                records = resultset.getString(1);
            }
            statement.executeUpdate("COMMIT");
            System.out.println("COMMIT");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (resultset != null) {
                resultset.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return records;
    }
}
