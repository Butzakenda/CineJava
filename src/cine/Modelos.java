/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine;

/**
 *
 * @author SENA
 */
public class Modelos {

    private int IdCliente;
    private int IdAcompaniantes;
    private String Nombres;
    private String Apellidos;
    private String TipoDocumento;
    private String NumDocumento;
    private String FechaNacimiento;
    private String CorreoElectronico;

    public int getId() {
        return IdCliente;
    }

    public void setId(int id) {
        this.IdCliente = id;
    }

    public int getIdAcompaniantes() {
        return IdAcompaniantes;
    }

    public void setIdAcompaniantes(int id) {
        this.IdAcompaniantes = id;
    }

    public String getBirthDate() {
        return FechaNacimiento;
    }

    public void setBirthDate(String telefono) {
        this.FechaNacimiento = telefono;
    }

    public String getNumDocumento() {
        return NumDocumento;
    }

    public void setNumDocumento(String telefono) {
        this.NumDocumento = telefono;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String telefono) {
        this.TipoDocumento = telefono;
    }

    public String getEmail() {
        return CorreoElectronico;
    }

    public void setEmail(String email) {
        this.CorreoElectronico = email;
    }

    public String getNombre() {
        return Nombres;
    }

    public void setNombre(String nombre) {
        this.Nombres = nombre;
    }

    public String getApellido() {
        return Apellidos;
    }

    public void setApellido(String nombre) {
        this.Apellidos = nombre;
    }
}
