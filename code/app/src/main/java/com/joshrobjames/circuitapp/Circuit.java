package com.joshrobjames.circuitapp;

import java.util.Vector;

/**
 * Created by James on 3/30/2015.
 */
public class Circuit {
    private Vector<Component> components;

    public Circuit(){}

    public void addComponent ( Component C ) {
        components.add( C );
    }//IS THIS SUFFICIENT?


    public String simulation () {
        String status;//This should be shown on the screen each time the sim runs
        status = "Valid";


        //the following makes sure there's a power supply in the circuit
        int powercheck = -1;
        for ( int i = 0; i < components.size(); i++ ) {
            if ( ( components.get( i ).type.equals( "power source" ) ) || ( components.get( i ).type.equals( "AC power source" ) ) ) {
                powercheck = i;
                break;
            }
        }
        if ( powercheck < 0 ){
            status = "Unpowered";
        }

        //the following makes sure there is a complete circuit and marks offline components
        int circuitcheck = powercheck;
        if ( status.equals( "Valid" )) {
            if (components.elementAt(circuitcheck).getConnected().isEmpty())//why is java stupid?
                status = "Incomplete";

            //LOOPish HERE
        }


        //the following does voltage and amperage calculations, assigns relevant values
        //to components, and marks burn-outs
        //INSERT CODE HERE


        return status;
    }
}
