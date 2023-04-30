/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semama7.git.mvc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import semama7.git.mvc.modelo.Login;
import semama7.git.mvc.modelo.LoginDAO;
import semama7.git.mvc.vista.INLogin;

/**
 *
 * @author uniri
 */
public class Controlador implements ActionListener{
    
    Login l;
    INLogin inLogin;
    LoginDAO lDao;
    
    
        public Controlador() {
        
        //Modelos
        this.l = new Login();
        this.lDao = new LoginDAO();

        
        // Vistas
        this.inLogin = new INLogin();

        
    }

        
    public void iniciar(){
        
        // Se agrega el action listener al boton login
        inLogin.getBtnLogin().addActionListener(this);
        // Se posiciona la ventana en el centro de la patalla
        inLogin.setLocationRelativeTo(null);
        // Se hace vidible la ventana
        inLogin.setVisible(true);
        
    }
    
          
        
    @Override
    public void actionPerformed(ActionEvent ae) {
                    // Se verifican las acciones generadas
        
        // Si se presiono el boton login
        if (ae.getSource().equals(inLogin.getBtnLogin() )){
            // Se llama el metodo login.
            login();
            
        }
    }
    
    
    private void login() {
        
        // Se obtiene captura la información de usuario y contraseña y se asigna al objeto login.
        l.setUsuario(inLogin.getTxtUsuario().getText());
        l.setPwt(inLogin.getTxtPwt().getText());
        
        // Se invoca el metodo para validar las credenciales
        Object[] data = lDao.validacredenciales(l);
        l.setNombre(data[0].toString());
        l.setPerfil(data[1].toString());
        
        if (l.getNombre().equals("") && l.getPerfil().equals("")){
            
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            
        
        }else{
            JOptionPane.showMessageDialog(null, "Usuario correcto" + l.getPerfil());
            
            
        }
       
    }
    
    
    
}
