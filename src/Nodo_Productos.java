/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erick Solano
 */
public class Nodo_Productos {

    String Nombre;
    int Cantidad;
    float Precio;
    int Ramdom;
    Nodo_Productos Rlink;
    Nodo_Productos Llink;

    public Nodo_Productos(String Nombre, int Cantidad, float Precio, int Ramdom, Nodo_Productos Rlink, Nodo_Productos Llink) {
        this.Nombre = Nombre;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Ramdom = Ramdom;
        this.Rlink = Rlink;
        this.Llink = Llink;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public int getRamdom() {
        return Ramdom;
    }

    public void setRamdom(int Ramdom) {
        this.Ramdom = Ramdom;
    }

    public Nodo_Productos getRlink() {
        return Rlink;
    }

    public void setRlink(Nodo_Productos Rlink) {
        this.Rlink = Rlink;
    }

    public Nodo_Productos getLlink() {
        return Llink;
    }

    public void setLlink(Nodo_Productos Llink) {
        this.Llink = Llink;
    }
    
    
}
