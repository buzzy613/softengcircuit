package com.joshrobjames.circuitapp;

import java.util.Vector;

/**
 * Created by James on 3/15/2015.
 */
public class Component {
    private int numLeads;//connected should not exceed this
    protected String type;
    private Vector<Component> connected;//stores directly connected components

    //simulation values
    private float volt;
    private float amp;
    private String status;//"offline", "online", "burnt"

    public Component (int num){
        numLeads = num;
    }

    public int getNumLeads (){
        return numLeads;
    }

    protected void addLeads ( int L ) {
        numLeads = numLeads + L;
    }

    public boolean addConnected ( Component C ) {
        if ( connected.size() < numLeads ) {
            connected.add(C);
            return true;
        }
        else
            return false;
    }

    public Vector<Component> getConnected () {
        return connected;
    }


    //simulation value functions
    public float getVolt () {
        return volt;
    }

    public float getAmp () {
        return amp;
    }

    public String getStatus() {
        return status;
    }

    public void setVolt ( float V ) {
        volt = V;
    }

    public void setAmp ( float A ) {
        amp = A;
    }

    public void setStatus ( String S ) {
        status = S;
    }

}
