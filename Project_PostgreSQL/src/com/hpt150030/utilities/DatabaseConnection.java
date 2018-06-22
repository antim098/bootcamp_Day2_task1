/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hpt150030.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hardik
 */
public class DatabaseConnection {

    public Connection connect = null;
    private Statement statement = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    public DatabaseConnection() {
    }

    public void openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver"); 
        connect = DriverManager.getConnection(
        		   "jdbc:postgresql://hostname:port/dbname","username", "password");
    }

    public void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception exp) {

        }
    }
}
