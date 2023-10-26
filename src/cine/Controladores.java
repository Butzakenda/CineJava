/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine;

import cine.Modelos;
import cine.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SENA
 */
public class Controladores {

    private static Controladores instance;
    private Conectar conectar;
    private Modelos modelo;
    private Connection con;

    public Controladores() {
        conectar = new Conectar();
        modelo = new Modelos();
        con = conectar.getConexion();
    }

    public static Controladores getInstance() {
        if (instance == null) {
            instance = new Controladores();
        }
        return instance;
    }

    public void insertar(String Nombres, String Apellidos,String CorreoElectronico, String TipoDocumento, String NumDocumento  ) {
        PreparedStatement ps;
        String sql;
        modelo.setNombre(Nombres);
        modelo.setApellido(Apellidos);
        modelo.setTipoDocumento(TipoDocumento);
        modelo.setNumDocumento(NumDocumento);
        
        modelo.setEmail(CorreoElectronico);

        try {
            if (con != null) {
                sql = "insert into clientes(Nombres, Apellidos, TipoDocumento, NumDocumento, CorreoElectronico) values(?, ?, ?, ?, ?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, modelo.getNombre());
                ps.setString(2, modelo.getApellido());
                ps.setString(3, modelo.getTipoDocumento());
                ps.setString(4, modelo.getNumDocumento());
                ps.setString(5, modelo.getEmail());

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha registrado el Cliente");
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
                sql = "DELETE FROM clientes WHERE idCliente = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, clienteId);
                int resultado = ps.executeUpdate();
                if (resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el cliente con el ID especificado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error de conexión: la conexión es nula");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
    }
}
