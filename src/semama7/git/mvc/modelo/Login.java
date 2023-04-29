/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semama7.git.mvc.modelo;

/**
 *
 * @author juang
 */
public class Login {
    
    private String usuario;
    private String pwt;
    private String perfil;
    private String nombre;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Contructor con parametros
    public Login(String usuario, String pwt) {
        this.usuario = usuario;
        this.pwt = pwt;
    }
    
    //Constructor para iniciar variables vacias
    public Login() {
        this.usuario = "";
        this.pwt = "";
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPwt() {
        return pwt;
    }

    public void setPwt(String pwt) {
        this.pwt = pwt;
    }
    

    
    
}
