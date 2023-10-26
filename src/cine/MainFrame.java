/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SENA
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        // Configuración del JFrame
        
        // Establecer el tamaño, título, cierre y otros ajustes según tus necesidades
        
        // Obtener la conexión a la base de datos
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_basedatos", "usuario", "contraseña");
            
            // Ejecutar una consulta de prueba
            String query = "SELECT 1";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            // Verificar si se obtuvieron resultados
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this, "La conexión a la base de datos funciona correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se obtuvieron resultados de la consulta.");
            }
            
            // Cerrar recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            // Cerrar la conexión en el bloque "finally" para asegurarse de que siempre se cierre
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

