/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erick Solano
 */
public class Nodo_Usuario {

    String nombres;
    String apellidos;
    String cedula;
    String pass;
    String tipo;
    String user;
    Nodo_Usuario Link;

    public Nodo_Usuario(String nombres, String apellidos, String cedula, String pass, String tipo, String user, Nodo_Usuario Link) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.pass = pass;
        this.tipo = tipo;
        this.user = user;
        this.Link = Link;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Nodo_Usuario getLink() {
        return Link;
    }

    public void setLink(Nodo_Usuario Link) {
        this.Link = Link;
    }
    

}
