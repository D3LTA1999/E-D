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
public class Month {
    Month mon;
    String info;

    public Month(Month mon, String info) {
        this.mon = mon;
        this.info = info;
    }

    public Month getMon() {
        return mon;
    }

    public void setMon(Month mon) {
        this.mon = mon;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
}
