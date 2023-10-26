/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine;
import java.sql.Date;
/**
 *
 * @author SENA
 */
public class ModelosPeliculas {

    private int IdPelicula;
    
    private String Nombre;
    private String Genero;
    private String Tipo;
    private Date FechaEmision;
    private String Categoria;
    private String Imagen;
    private String Precio;

    public int getIdPelicula() {
        return IdPelicula;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getGenero() {
        return Genero;
    }

    public String getTipo() {
        return Tipo;
    }

    public Date getFechaEmision() {
        return FechaEmision;
    }

    public String getCategoria() {
        return Categoria;
    }

    public String getImagen() {
        return Imagen;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setIdPelicula(int IdPelicula) {
        this.IdPelicula = IdPelicula;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setFechaEmision(Date FechaEmision) {
        this.FechaEmision = FechaEmision;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    
}
