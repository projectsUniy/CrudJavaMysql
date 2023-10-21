
package com.uni.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorMysql {
    public String dbURL = "jdbc:mysql://localhost:3306/controlescolaruniang";
    public String username = "root";
    public String password = "";
    public Connection conn;
    
    public ConnectorMysql(){
        try {

            conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Connection getConexion(){
        return conn;
    }
}
