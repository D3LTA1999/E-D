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
public class Interval {

    Interval in;
    Month mon;
    String info;

    public Interval(String info, Interval in, Month mon) {
        this.in = in;
        this.mon = mon;
        this.info = info;
    }

    public Interval getIn() {
        return in;
    }

    public void setIn(Interval in) {
        this.in = in;
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
