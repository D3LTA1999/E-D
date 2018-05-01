/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.Random;

/**
 *
 * @author daalb
 */
public class Usuario {

    private String nombres;
    private String apellidos;
    private String cedula;
    private String pass;
    private String tipo;
    private String user;
    FileWriter fr;
    PrintWriter pw;

    public Usuario() {
        nombres = null;
        apellidos = null;
        cedula = null;
        pass = null;
        tipo = null;
        user = null;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String crearUser(String nombres, String apellidos) {
        String n = "", a = "", user = "";
//        int j = 0;
//        boolean sw = true;
//        for (int i = 0; i < 1; i++) {
//            n = n + nombres.substring(0, i + 1);
//        }
//        while (j < apellidos.length() && sw == true) {
//            if (apellidos.substring(0, j).equals(" ")) {
//                sw = false;
//            } else {
//                a = a + apellidos.substring(0, j + 1);
//            }
//            j++;
//        }
//        user = n + a;
        if (apellidos.length() < 4) {
            user = nombres.substring(0, 1) + apellidos.substring(0, apellidos.length());
        } else {
            user = nombres.substring(0, 1) + apellidos.substring(0, 4);
        }
        user = user.toUpperCase();
        return user;
    }

    public String crearPass() {
        int contra;
        contra = (int) (Math.random() * 9999) + 1000;
        return String.valueOf(contra);
    }

    public void llenado(String nombres, String apellidos, String cedula, String pass, String tipo, String user) throws IOException {//Metodo para llenar
        File users = new File("usuarios.txt");
        try {
            FileWriter fw = new FileWriter(users, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(user + ";" + pass + ";" + tipo + ";" + cedula + ";" + nombres + ";" + apellidos + ";");
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("");
        }

    }
}
