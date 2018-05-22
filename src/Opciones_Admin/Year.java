/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Opciones_Admin;

/**
 *
 * @author daalb
 */
public class Year {

    Year linkyea;
    Interval linkin;
    String info;

    public Year(String info, Year yea, Interval in) {
        this.linkyea = yea;
        this.linkin = in;
        this.info = info;
    }

    public Year getLinkyea() {
        return linkyea;
    }

    public void setLinkyea(Year linkyea) {
        this.linkyea = linkyea;
    }

    public Interval getLinkin() {
        return linkin;
    }

    public void setLinkin(Interval in) {
        this.linkin = in;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
