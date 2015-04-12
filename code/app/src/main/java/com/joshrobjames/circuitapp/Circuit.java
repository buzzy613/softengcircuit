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
    }

    public String simulation () {
        String status;//This should be shown on the screen each time the sim runs
        status = "Valid";


        //the following makes sure there's a power supply in the circuit
        int powercheck = 0;
        for ( int i = 0; i < components.size(); i++ ) {
            if ( ( components.get( i ).type.equals( "power source" ) ) || (components.get( i ).type.equals( "AC power source" ) ) ) {
                powercheck = 1;
            }
        }
        if ( powercheck != 1 ){
            status = "Unpowered";
        }



        return status;
    }
}