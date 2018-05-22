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
    Interval in;
    String info;

    public Year(Year yea, Interval in, String info) {
        this.linkyea = yea;
        this.in = in;
        this.info = info;
    }

    public Year getLinkyea() {
        return linkyea;
    }

    public void setLinkyea(Year linkyea) {
        this.linkyea = linkyea;
    }

    public Interval getIn() {
        return in;
    }

    public void setIn(Interval in) {
        this.in = in;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
}
