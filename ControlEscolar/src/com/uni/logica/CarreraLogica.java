
package com.uni.logica;

import com.uni.conexiones.ConnectorMysql;
import com.uni.modelos.Carrera;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarreraLogica {
    ConnectorMysql conector;
    
    public CarreraLogica(){
        conector = new ConnectorMysql();
    }
    
    public void insertarCarrera(Carrera carrera){
        try (Connection conn = DriverManager.getConnection(conector.dbURL, conector.username, conector.password)) {

            String sql = "INSERT INTO carrera (Nombre, Clave, CreatedBy) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, carrera.Nombre);
            statement.setString(2, carrera.Clave);
            statement.setInt(3, 1);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Carrera insertada correctamente!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }
    
}
