/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author SENA
 */
public class Cine extends JButton{
    


    /**
     * @param args the command line arguments
     */
    int aforo;
    double precioEntrada;
    String tituloPelicula;
    int SillasOcupadas;
    
    public Cine() {
    aforo=100;
    precioEntrada = 1;
    tituloPelicula = "";
    SillasOcupadas = 0;
    };
     
    
    //Setters para Cine
    
    public void setAforo(int afor){
      aforo = afor;  
    };
    
    public void setPrecioEntrada(double Precio){
      precioEntrada = Precio;  
    };
    
    public void setTituloPelicula(String titulo){
      tituloPelicula = titulo;  
    };
    
    public void setSillasOcupadas(int sillas){
      SillasOcupadas = sillas;  
    };
    
    //Getters para cine

    public int getAforo() {
        return aforo;
    }

    
    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public int getSillasOcupadas() {
        return SillasOcupadas;
    }    
    public int getSillasLibres(){
        return aforo - SillasOcupadas;
    };
    public  double getIngresosSala(){
        return precioEntrada * SillasOcupadas;
    };
    public void boleta(){
        SillasOcupadas++;
    };
    public int ActualizarSillas(){
        return SillasOcupadas++;
    };
    public void VaciarSala(){
        tituloPelicula = "";
        SillasOcupadas = 0;
    };
    //Base de datos
    public static void DB(String[] args) {
        Connection connection = null;
        try {
            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "abelarxo.2019");

            // Consulta SQL para obtener el nombre de la película
            String query = "SELECT Nombre FROM PELICULA";

            // Crear una declaración
            Statement statement = connection.createStatement();

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery(query);

            // Verificar si se encontró un resultado
            if (resultSet.next()) {
                String nombrePelicula = resultSet.getString("Nombre");
                System.out.println("Nombre de la película: " + nombrePelicula);

                // Aquí puedes asignar el nombre de la película a tu elemento JForm (JLabel)
            }

            // Cerrar la conexión y liberar recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
    public static List<String> NombresPeliculas(Connection connection ){
        List<String> nombresPeliculas = new ArrayList<>();
        try{
            // Consulta SQL para obtener el nombre de la película
            String query = "SELECT Nombre FROM PELICULA";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //Recorrer la consulta y agregarlas en la arraylist
            while (resultSet.next()) {
                String nombrePelicula = resultSet.getString("Nombre");
                nombresPeliculas.add(nombrePelicula);
        }
            // Cerrar recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return nombresPeliculas;                   
    }
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "abelarxo.2019");

            // Ejecutar una consulta de prueba
            String query = "SELECT 1";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Verificar si se obtuvieron resultados
            if (resultSet.next()) {
                System.out.println("La conexión a la base de datos funciona correctamente.");
            } else {
                System.out.println("No se obtuvieron resultados de la consulta.");
            }

            // Cerrar recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
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

