package cine;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {
    
    public static final String URL = "jdbc:mysql://localhost:3306/cine2";
    public static final String USUARIO = "root";
    public static final String CLAVE = "";
    
    public Connection getConexion () {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        return con;
    }
    
}