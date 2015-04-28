package com.joshrobjames.circuitapp;

import java.util.Vector;

/**
 * Created by James on 3/15/2015.
 */
public class Component {
    private int numLeads;//connected should not exceed this
    protected String type;
    private Vector<Component> connected;//stores directly connected components
    private int index;


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

    public void setIndex ( int I ) {
        index = I;
    }

    public int getIndex () {
        return index;
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

    public boolean isConnected () {
        if ( type == "power source" )
            return true;

        else {
            Vector<Component> branches;//Components w/ more than 2 attached
            branches = new Vector<Component> ();

            Component checking = connected.get (0);//iterator pretty much
            //while we're not checking a battery, a dead end, or our self
            while (( checking.type != "power source" ) && ( checking.getIndex() != index ) && ( checking.getConnected().size() > 1 )){
                checking = checking.getConnected().get(0);//checking changes to the first thing it's connected to

                if (checking.getConnected().size() > 2)
                    branches.add( checking );
            }

            //...
            return true;
        }
    }

}
