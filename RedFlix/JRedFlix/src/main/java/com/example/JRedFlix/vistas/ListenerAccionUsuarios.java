package com.example.JRedFlix.vistas;

import com.example.JRedFlix.Repositorios.RepositorioUsuario;
import com.example.JRedFlix.modelos.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ListenerAccionUsuarios implements ActionListener {

    RepositorioUsuario repositorioUsuario;
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
    JTextArea jTextAreaResultado;

    public ListenerAccionUsuarios(JTextArea jTextAreaResultado, JRadioButton RadioButtonConsultar, JRadioButton RadioButtonActualizar, JRadioButton RadioButtonEliminar, JRadioButton RadioButtonInsertar, JTextField JTextFieldNombre, JTextField JTextFieldApellido, com.toedter.calendar.JDateChooser jDateChooserFechaNacimiento, JTextField JTextFieldEmail, JTextField JTextFieldCelular, JTextField JTextFieldUsuario, JTextField JTextFieldContrasena, RepositorioUsuario repositorioUsuario) {
        this.RadioButtonConsultar = RadioButtonConsultar;
        this.RadioButtonActualizar = RadioButtonActualizar;
        this.RadioButtonEliminar = RadioButtonEliminar;
        this.RadioButtonInsertar = RadioButtonInsertar;
        this.JTextFieldNombre = JTextFieldNombre;
        this.JTextFieldApellido = JTextFieldApellido;
        this.JTextFieldEmail = JTextFieldEmail;
        this.JTextFieldUsuario = JTextFieldUsuario;
        this.JTextFieldContrasena = JTextFieldContrasena;
        this.jDateChooserFechaNacimiento = jDateChooserFechaNacimiento;
        this.JTextFieldCelular = JTextFieldCelular;
        this.jTextAreaResultado = jTextAreaResultado;
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

//**********************************************************************SELECT
        if (RadioButtonConsultar.isSelected()) {
            System.out.println("consultar");
            String user = this.JTextFieldUsuario.getText();
            if (user == null || user.equals("")) {
                System.out.println("Se consulta por Usuario");
                jTextAreaResultado.setText("Se consulta por Usuario");
            } else {
                System.out.println(user);
                String username = null;
                List<Usuario> usuarios = repositorioUsuario.findAll();
                for (int i = 0; i < usuarios.size(); i++) {
                    Usuario usuario = usuarios.get(i);
                    if (usuario.getUsuario().equals(user)) {
                        username = usuario.getUsuario();
                        Optional<Usuario> resultado = repositorioUsuario.findById(username);
                        if (resultado.isPresent()) {
                            Usuario usuarioEncontrado = resultado.get();
                            JTextFieldNombre.setText((usuarioEncontrado.getNombre()));
                            JTextFieldApellido.setText((usuarioEncontrado.getApellido()));
                            JTextFieldEmail.setText((usuarioEncontrado.getEmail()));
                            JTextFieldCelular.setText((usuarioEncontrado.getCelular()));
                            JTextFieldContrasena.setText((usuarioEncontrado.getContrasena()));
                            jDateChooserFechaNacimiento.setDate(usuarioEncontrado.getFechaNacimiento());

                            System.out.println("Encontrado");
                            jTextAreaResultado.setText("Encontrado");
                        } else {
                            System.out.println("No encontrado");
                            jTextAreaResultado.setText("No Encontrado");
                            JTextFieldNombre.setText("");
                            JTextFieldApellido.setText("");
                            JTextFieldEmail.setText("");
                            JTextFieldCelular.setText("");
                            JTextFieldContrasena.setText("");
                            //jDateChooserFechaNacimiento.setDate("");
                        }
                    }
                }
                if (username == null) {
                    System.out.println("NO encontrado");
                    jTextAreaResultado.setText("No Encontrado");
                    JTextFieldNombre.setText("");
                    JTextFieldApellido.setText("");
                    JTextFieldEmail.setText("");
                    JTextFieldCelular.setText("");
                    JTextFieldContrasena.setText("");
                }
            }
        }
        //**********************************************************************INSERT
        if (RadioButtonInsertar.isSelected()) {
            System.out.println("insertar");
            String user = this.JTextFieldUsuario.getText();
            String nombre = this.JTextFieldNombre.getText();
            String apellido = this.JTextFieldApellido.getText();
            String email = this.JTextFieldEmail.getText();
            String celular = this.JTextFieldCelular.getText();
            String contrasena = this.JTextFieldContrasena.getText();
            Date fecha = this.jDateChooserFechaNacimiento.getDate();
            if (user == null || nombre == null || apellido == null || email == null || celular == null
                    || contrasena == null || fecha == null || user.equals("") || nombre.equals("")
                    || apellido.equals("") || email.equals("") || celular.equals("") || contrasena.equals("")) {
                if (fecha == null && !(user.equals("") || nombre.equals("") || apellido.equals("")
                        || email.equals("") || celular.equals("") || contrasena.equals(""))) {
                    System.out.println("Seleccione Fecha de nacimiento");
                    jTextAreaResultado.setText("Seleccione Fecha de nacimiento");
                } else {
                    System.out.println("Llene todos los campos");
                    jTextAreaResultado.setText("Llene todos los campos");
                }

            } else {
                //int usuarioId = ((int) (this.repositorioUsuario.count())) + 1;
                Usuario usuario = new Usuario(user, nombre, apellido, email, celular, contrasena, fecha);
                repositorioUsuario.save(usuario);
                System.out.println("Se agregó un usuario");
                jTextAreaResultado.setText("Se agregó un usuario");
            }
        }
        //**********************************************************************UPDATE
        if (RadioButtonActualizar.isSelected()) {
            System.out.println("actualizar");
            String user = this.JTextFieldUsuario.getText();
            String nombre = this.JTextFieldNombre.getText();
            String apellido = this.JTextFieldApellido.getText();
            String email = this.JTextFieldEmail.getText();
            String celular = this.JTextFieldCelular.getText();
            String contrasena = this.JTextFieldContrasena.getText();
            Date fecha = this.jDateChooserFechaNacimiento.getDate();
            if (user == null || nombre == null || apellido == null || email == null || celular == null
                    || contrasena == null || fecha == null || user.equals("") || nombre.equals("")
                    || apellido.equals("") || email.equals("") || celular.equals("") || contrasena.equals("")) {
                if (fecha == null && !(user.equals("") || nombre.equals("") || apellido.equals("")
                        || email.equals("") || celular.equals("") || contrasena.equals(""))) {
                    System.out.println("Seleccione Fecha de nacimiento");
                    jTextAreaResultado.setText("Seleccione Fecha de nacimiento");
                } else {
                    System.out.println("Llene todos los campos");
                    jTextAreaResultado.setText("Llene todos los campos");
                }
            } else {
                System.out.println(user);
                String username = null;
                List<Usuario> usuarios = repositorioUsuario.findAll();
                for (int i = 0; i < usuarios.size(); i++) {
                    Usuario usuario = usuarios.get(i);
                    if (usuario.getUsuario().equals(user)) {
                        username = usuario.getUsuario();
                        Optional<Usuario> resultado = repositorioUsuario.findById(username);
                        if (resultado.isPresent()) {
                            Usuario usuarioEncontrada = resultado.get();
                            Usuario usuarioActualizada = new Usuario(usuarioEncontrada.getUsuario(), nombre, apellido, email, celular, contrasena, fecha);
                            repositorioUsuario.save(usuarioActualizada);
                            System.out.println("Usuario Actualizado");
                            jTextAreaResultado.setText("Usuario Actualizado");
                            break;
                        } else {
                            System.out.println("No se encontro usuario para actualizar");
                            jTextAreaResultado.setText("No se encontro usuario para actualizar");
                        }
                    }
                }
                if (username == null) {
                    System.out.println("No se encontro serie para actualizar");
                    jTextAreaResultado.setText("No se encontro serie para actualizar");
                }
            }
        }
        //**********************************************************************DELETE
        if (RadioButtonEliminar.isSelected()) {
            System.out.println("eliminar");
            String user = this.JTextFieldUsuario.getText();
            if (user == null) {
                System.out.println("Se elimina por usuario");
                jTextAreaResultado.setText("Se elimina por usuario");
            } else {
                System.out.println(user);
                String usuarioId = null;
                List<Usuario> usuarios = repositorioUsuario.findAll();
                System.out.println(usuarios.size());
                for (int i = 0; i < usuarios.size(); i++) {
                    Usuario usuario = usuarios.get(i);
                    if (usuario.getUsuario().equals(user)) {
                        usuarioId = usuario.getUsuario();
                        repositorioUsuario.delete(usuario);
                        System.out.println("Usuario Eliminado");
                        jTextAreaResultado.setText("Usuario Eliminado");
                        break;
                    }
                }
                if (usuarioId == null) {
                    System.out.println("No se encontro usuario para eliminar");
                    jTextAreaResultado.setText("No se encontro usuario para eliminar");
                }
            }
        }
        //*************************************************************************        
    }
}
