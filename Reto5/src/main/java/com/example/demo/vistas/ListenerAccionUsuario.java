/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.vistas;

import com.example.demo.Repositorios.RepositorioUsuario;
import com.example.demo.modelos.contenido;
import com.example.demo.modelos.serie;
import com.example.demo.modelos.usuario;


import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author olgat
 */


class ListenerAccionUsuario implements ActionListener{
    
    JRadioButton RadioButtonConsultar;
    JRadioButton RadioButtonActualizar;
    JRadioButton RadioButtonEliminar;
    JRadioButton RadioButtonInsertar;
    JTextField JTextFieldNombre;
    JTextField JTextFieldApellido;
    JTextField JTextFieldEmail;
    JTextField JTextFieldUsuario;
    JTextField JTextFieldContrasena;
    JTextField JTextFieldCelular;
    com.toedter.calendar.JDateChooser jDateChooserFechaNacimiento;
    JTextArea JTextAreaResultado;
    ButtonGroup buttonGroupDireccion;
    String botonSeleccionado="";
    RepositorioUsuario RepositorioUsuario;
   
    
 

    ListenerAccionUsuario(RepositorioUsuario RepositorioUsuario, ButtonGroup buttonGroupDireccion, JTextField JTextFieldNombre, JTextField JTextFieldApellido, JDateChooser jDateChooserFechaNacimiento, JTextField JTextFieldEmail, JTextField JTextFieldCelular, JTextField JTextFieldUsuario, JTextField JTextFieldContrasena, JTextArea JTextAreaResultado) {
     
        this.JTextFieldNombre = JTextFieldNombre;
        this.JTextFieldApellido = JTextFieldApellido;
        this.JTextFieldEmail = JTextFieldEmail;
        this.JTextFieldUsuario = JTextFieldUsuario;
        this.JTextFieldContrasena = JTextFieldContrasena;
        this.JTextFieldCelular = JTextFieldCelular;
        this.jDateChooserFechaNacimiento = jDateChooserFechaNacimiento;
        this.JTextAreaResultado = JTextAreaResultado;
        this.buttonGroupDireccion = buttonGroupDireccion;
        this.RepositorioUsuario = RepositorioUsuario;
    }

  

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        AbstractButton nextElement ;
        Enumeration<AbstractButton> e = buttonGroupDireccion.getElements();
        System.out.println(buttonGroupDireccion.getButtonCount());
        while (e.hasMoreElements()) {
            
            nextElement = e.nextElement();
            if(nextElement.isSelected()){
               
               botonSeleccionado = nextElement.getText();
            } else {
              
               
            }
             
        }
        String Usuario = this.JTextFieldUsuario.getText();
        Integer usuarioId = null;
        List<usuario> usuario = RepositorioUsuario.findAll();
        switch (botonSeleccionado){
            case "Consultar":
         
            
            for(int i =0; i< usuario.size(); i++){
                
                usuario usuario1 = usuario.get(i);
                if(usuario1.getUsuario().equals(Usuario)){
                    usuarioId = usuario1.getUsuarioId();
                    System.out.println(usuarioId); 
                    i = usuario.size();
                
                System.out.println(Usuario);
                    Optional<usuario> Resultado = RepositorioUsuario.findById(usuarioId);
                    if (Resultado.isPresent()) {
                        usuario usuarioEncontrado = Resultado.get();

                        JTextFieldNombre.setText(usuarioEncontrado.getNombre());
                        JTextFieldApellido.setText(usuarioEncontrado.getApellido());
                        JTextFieldCelular.setText(usuarioEncontrado.getCelular());
                        JTextFieldEmail.setText(usuarioEncontrado.getEmail());
                        jDateChooserFechaNacimiento.setDate(usuarioEncontrado.getFechaNacimiento());
                       
                        JTextAreaResultado.setText("Encontrado");

                    } else {
                        JTextAreaResultado.setText("No encontrado");
                        JTextFieldNombre.setText("");
                        JTextFieldApellido.setText("");
                 
                    }

                }else{
                }
            }
            
            break;
             case "Actualizar":
           
                 for (int i = 0; i < usuario.size(); i++) {

                     usuario usuario1 = usuario.get(i);
                     if (usuario1.getUsuario().equals(Usuario)) {
                         usuarioId = usuario1.getUsuarioId();
                         System.out.println(usuarioId);
                         i = usuario.size();
                                Optional<usuario> Resultado = RepositorioUsuario.findById(usuarioId);
                                if (Resultado.isPresent()) {
                                    usuario usuarioEncontrada = Resultado.get();

                                    String Nombre =this.JTextFieldNombre.getText();
                                    String Apellido =this.JTextFieldApellido.getText();
                                    String Email =this.JTextFieldEmail.getText();
                                    String Contrasena =this.JTextFieldContrasena.getText();
                                    String Celular =this.JTextFieldCelular.getText();
                                    Date FechaNacimiento =this.jDateChooserFechaNacimiento.getDate();
                                   
                                    usuarioEncontrada.setNombre(Nombre);
                                    usuarioEncontrada.setApellido(Apellido); 
                                    usuarioEncontrada.setEmail(Email);
                                    usuarioEncontrada.setContrasena(Contrasena);
                                    usuarioEncontrada.setCelular(Celular);
                                    usuarioEncontrada.setFechaNacimiento(FechaNacimiento);
                                    RepositorioUsuario.save(usuarioEncontrada);
                                    JTextAreaResultado.setText("Se actualizó el usuario");


                                } else {
                                    JTextAreaResultado.setText("No encontrado");
                                    this.JTextFieldNombre.setText("");
                                    this.JTextFieldApellido.setText("");
                                    this.JTextFieldEmail.setText("");
                                    this.JTextFieldContrasena.setText("");
                                    this.JTextFieldCelular.setText("");
                                    this.jDateChooserFechaNacimiento.setDate(null);
                                    
                                }

                            }
                        }
            break;
             case "Eliminar":
                 
                    for (int i = 0; i < usuario.size(); i++) {

                        usuario usuario2 = usuario.get(i);
                        if (usuario2.getUsuario().equals(Usuario)) {
                            usuarioId = usuario2.getUsuarioId();
                             System.out.println(usuarioId);
                            i = usuario.size();
                            Optional<usuario> Resultado = RepositorioUsuario.findById(usuarioId);
                            if (Resultado.isPresent()) {
                                usuario usuarioEncontrada = Resultado.get();

                                RepositorioUsuario.deleteById(usuarioEncontrada.getUsuarioId());
                                
                                JTextAreaResultado.setText("Eliminado");

                            } else {
                                JTextAreaResultado.setText("No encontrado");
                                 this.JTextFieldNombre.setText("");
                                    this.JTextFieldApellido.setText("");
                                    this.JTextFieldEmail.setText("");
                                    this.JTextFieldContrasena.setText("");
                                    this.JTextFieldCelular.setText("");
                                    this.jDateChooserFechaNacimiento.setDate(null);
                               
                            }

                        }
                    }
            break;
             case "Insertar":
                    String Nombre =this.JTextFieldNombre.getText();
                    String Apellido =this.JTextFieldApellido.getText();
                    String Email =this.JTextFieldEmail.getText();
                    String Contrasena =this.JTextFieldContrasena.getText();
                    String Celular =this.JTextFieldCelular.getText();
                    Date FechaNacimiento =this.jDateChooserFechaNacimiento.getDate();
                    
                    usuario u = new usuario();
                    u.setNombre(Nombre);
                    u.setApellido(Apellido); 
                    u.setEmail(Email);
                    u.setContrasena(Contrasena);
                    u.setCelular(Celular);
                    u.setUsuario(Usuario);
                    u.setFechaNacimiento(FechaNacimiento);
                    RepositorioUsuario.save(u);
                    
              
                    JTextAreaResultado.setText("Se agregó un Usuario");
            break;
            default:
            break;
        
        }
       

     
   
    }
 }
    

