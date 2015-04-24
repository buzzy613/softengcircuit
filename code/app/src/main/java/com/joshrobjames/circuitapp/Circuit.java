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
        do {
            for (int i = 0; i < components.size(); i++) {
                if ((components.get(i).type.equals("power source")) || (components.get(i).type.equals("AC power source"))) {
                    powercheck = i;
                }
            }
        } while ( powercheck < 0 );
        if ( powercheck < 0 ){
            status = "Unpowered";
        }


        Component branches[][] = new Component[components.size()][components.size()];//how to make this smaller?
        //the following makes sure there is a complete circuit and marks offline components
        Component circuitcheck = components.get(powercheck);
        if ( status.equals( "Valid" )) {
            if ( circuitcheck.getConnected().isEmpty() )//if there is nothing connected to the battery...
                status = "Incomplete";

            else {//this actually checks things
                Component[] checked;
                checked = new Component[components.size()];
                circuitcheck = circuitcheck.getConnected().get(0);

                int branchy = 0;
                int branchx = 0;

                do{
                    int contains = 0;
                    for (int i = 0; i < checked.length; i++){
                        if ( checked[i] == circuitcheck )
                            contains = 1;
                    }
                    if ( circuitcheck.getConnected().size() <= 2 ){
                        branches[branchy][branchx] = circuitcheck;
                        branchx++;
                    }
                    else{
                        branchy++;
                        branchx = 0;
                        branches[branchy][branchx] = circuitcheck;
                    }
                    
                }while ( circuitcheck != components.get(powercheck) );
            }
        }


        //the following does voltage and amperage calculations, assigns relevant values
        //to components, and marks burn-outs
        //INSERT CODE HERE


        return status;
    }
}
