/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semama7.git.mvc.modelo;

/**
 *
 * @author juang
 */
public class Clientes {
    
    //Atributos
    private String cedula;
    private String nombres;
    private String telefono;
    private String email;

    
    // Contructor con parametros
    public Clientes(String nombre, String telefono, String email) {
        this.nombres = nombre;
        this.telefono = telefono;
        this.email = email;
    }
    
    //Constructor para iniciar variables vacias
    public Clientes() {
        this.nombres = "";
        this.telefono = "";
        this.email = "";
    }
    
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
}

