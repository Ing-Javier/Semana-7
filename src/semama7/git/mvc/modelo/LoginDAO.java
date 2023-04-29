/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semama7.git.mvc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juang
 */
public class LoginDAO {
        //Atributos
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion();

    
    //Metodo para consultar el usuario
    public  Object[] validacredenciales (Login log) {
    
        
        String sp = "call sp_login (?,?)";
        try {
            String data[] = new String[2];
            con = conectar.getConnection();
            ps = con.prepareStatement(sp);
            ps.setString(1,log.getUsuario());
            ps.setString(2,log.getPwt());
            rs = ps.executeQuery();
            
            while (rs.next()) {
                //Object[] data = null;
                data[0] = rs.getString("Nom_usuario");
                data[1] = rs.getString("perfil");
            }

            return data;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new Object[0];
        }
        

}
}
