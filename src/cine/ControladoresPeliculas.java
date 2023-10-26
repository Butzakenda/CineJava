/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine;

import cine.ModelosPeliculas;
import cine.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 *
 * @author SENA
 */
public class ControladoresPeliculas {

    private static ControladoresPeliculas instance;
    private Conectar conectar;
    private ModelosPeliculas modelo;
    private Connection con;

    public ControladoresPeliculas() {
        conectar = new Conectar();
        modelo = new ModelosPeliculas();
        con = conectar.getConexion();
    }

    public static ControladoresPeliculas getInstance() {
        if (instance == null) {
            instance = new ControladoresPeliculas();
        }
        return instance;
    }

    public void insertar(String Nombre, String Genero, String Tipo, String FechaEmision, String Categoria, String Precio) {
        PreparedStatement ps;
        String sql;
        modelo.setNombre(Nombre);
        modelo.setGenero(Genero);
        modelo.setTipo(Tipo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date fechaEmision = sdf.parse(FechaEmision);
            modelo.setFechaEmision(new java.sql.Date(fechaEmision.getTime())); 
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Utilice el formato yyyy-MM-dd.");
            return; 
        }
        modelo.setCategoria(Categoria);
        modelo.setPrecio(Precio);

        try {
            if (con != null) {
                sql = "insert into peliculas(Nombre, Genero, Tipo, FechaEmision, Categoria, Precio) values(?, ?, ?, ?, ?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, modelo.getNombre());
                ps.setString(2, modelo.getGenero());
                ps.setString(3, modelo.getTipo());
                ps.setDate(4, modelo.getFechaEmision());
                ps.setString(5, modelo.getCategoria());
                ps.setString(6, modelo.getPrecio());

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha registrado la película");
            } else {
                JOptionPane.showMessageDialog(null, "Error de conexión: la conexión es nula");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e);
        }
    }

    public void eliminar(int clienteId) {
        PreparedStatement ps;
        String sql;

        try {
            if (con != null) {
                sql = "DELETE FROM peliculas WHERE IdPelicula = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, clienteId);
                int resultado = ps.executeUpdate();
                if (resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Película eliminada correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró la película con el ID especificado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de conexión: la conexión es nula");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
    }
}
