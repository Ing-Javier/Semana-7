/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semama7.git.mvc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import semama7.git.mvc.modelo.Clientes;
import semama7.git.mvc.modelo.ClientesDAO;
import semama7.git.mvc.modelo.Login;
import semama7.git.mvc.modelo.LoginDAO;
import semama7.git.mvc.vista.INLogin;
import semama7.git.mvc.vista.INpaginaPrincipal;


/**
 *
 * @author uniri
 */
public class Controlador implements ActionListener {
    Login l;
    INLogin inLogin;
    LoginDAO lDao;
    INpaginaPrincipal inPrincipal;
    Clientes cli;
    ClientesDAO cliDAO;

    public Controlador() {
        
        //Modelos
        this.l = new Login();
        this.lDao = new LoginDAO();
        this.cli = new Clientes();
        this.cliDAO = new ClientesDAO();
        
        // Vistas
        this.inLogin = new INLogin();
        this.inPrincipal = new INpaginaPrincipal();
        
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
        

        
        
        
        // Si se presiono el boton crear usuario
        if (ae.getSource().equals(inPrincipal.getBtnCrear() )){
            // Se llama el metodo crear cliente
            creaCliente();
            
        }
     
        // Si se presiono el boton consultar usuario
        if (ae.getSource().equals(inPrincipal.getBtnConsultar() )){
            // Se llama el metodo crear cliente
            consultaCliente();
            
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
            //JOptionPane.showMessageDialog(null, "Usuario correcto" + l.getPerfil());
            
            iniciarPrincipal();
        }
       
    }
    
    public void iniciarPrincipal(){  
        
        // Se agrega el action a los botones
        inPrincipal.getBtnCrear().addActionListener(this);
        inPrincipal.getBtnConsultar().addActionListener(this);
        //inLogin.getBtnLogin().addActionListener(this);
        // Se posiciona la ventana en el centro de la patalla
        inPrincipal.setLocationRelativeTo(null);
        
        if (l.getPerfil().equals("1") || l.getPerfil().equals("2")){
            inPrincipal.btnCrear.setEnabled(true);
            inPrincipal.btnConsultar.setEnabled(true);
        }else{
            inPrincipal.btnCrear.setEnabled(false);
            inPrincipal.btnConsultar.setEnabled(true);
        }       
        // Se hace vidible la ventana
        inPrincipal.setVisible(true);
        inLogin.dispose();

    }

    private void creaCliente() {
        // Se obtiene captura la información del cliente
        
        cli.setCedula(inPrincipal.getTxtCedula().getText());
        cli.setNombres(inPrincipal.getTxtNombre().getText());
        cli.setTelefono(inPrincipal.getTxtTelefono().getText());
        cli.setEmail(inPrincipal.getTxtEmail().getText());
         
        // Se invoca el metodo para crear el cliente
        Object[] data = cliDAO.creaCliente(cli);
        
        if (data[0].toString().equals("1")){   
            JOptionPane.showMessageDialog(null, "Cliente Creado con Exito");

        }else{
            
            JOptionPane.showMessageDialog(null, "Error al crear el Cliente");
            
        }
    }

    private void consultaCliente() {
        // Se captura la información de la cedula y se asigna al atributo del cliente.
        cli.setCedula(inPrincipal.getTxtCedula().getText());
        
        // Se invoca el metodo para consultar el cliente
        Object[] data = cliDAO.consultaCliente(cli);  
        
        if (data[3].toString().equals("0")){   
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }else{
            //Se envian los datos obtenidos al front
            inPrincipal.txtNombre.setText(data[0].toString());
            inPrincipal.txtTelefono.setText(data[1].toString());
            inPrincipal.txtEmail.setText(data[2].toString());
        }
    }


    
    
}