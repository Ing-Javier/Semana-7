/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author CONTROL CAEM
 */
public class ClientesDAO {
    //Atributos
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion();

    //Metodo para crear el usuario
    public  Object[] creaCliente (Clientes cli) {
    
        
        String sp = "call sp_crea_cliente (?,?,?,?)";
        try {
            String data[] = new String[2];
            con = conectar.getConnection();
            ps = con.prepareStatement(sp);
            ps.setString(1,cli.getCedula());
            ps.setString(2,cli.getNombres());
            ps.setString(3,cli.getTelefono());
            ps.setString(4,cli.getEmail());
            rs = ps.executeQuery();
            
//            while (rs.next()) {
//                //Object[] data = null;
//                data[0] = rs.getString("Nom_usuario");
//                data[1] = rs.getString("perfil");
//            }
            data[0] = "1";
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new Object[0];
        }
        

}
    
    
    //Metodo para consultar el usuario
    public  Object[] consultaCliente (Clientes cli) {
    
        
        String sp = "call sp_consulta_cliente (?)";
        try {
            
            //Object[] resultado = new Object[];
            String data[] = new String[4];
            con = conectar.getConnection();
            ps = con.prepareStatement(sp);
            ps.setString(1,cli.getCedula());

            rs = ps.executeQuery();
            
            while (rs.next()) {
                //Object[] data = null;
                data[0] = rs.getString("nombres");
                data[1] = rs.getString("telefono");
                data[2] = rs.getString("email");
                data[3] = rs.getString("cont");
            }
            

            return data;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new Object[0];
        }
        

}
    
}
