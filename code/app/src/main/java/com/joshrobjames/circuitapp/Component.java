package com.joshrobjames.circuitapp;

/**
 * Created by James on 3/15/2015.
 */
public class Component {
    private int numLeads;

    public Component (int num){
        numLeads = num;
    }
    public int getNumLeads (){
        return numLeads;
    }
    public void addLeads ( int L ) {
        numLeads = numLeads + L;
    }
}
