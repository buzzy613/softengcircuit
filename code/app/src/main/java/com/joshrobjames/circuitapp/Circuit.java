package com.joshrobjames.circuitapp;

import java.util.Vector;
import java.util.Arrays;
import java.util.List;

/**
 * Created by James on 3/30/2015.
 */
public class Circuit {
    private Vector<Component> components;

    public Circuit(){}

    public void addComponent ( Component C ) {
        components.add( C );
        components.lastElement().setIndex( components.size() - 1 );
    }//IS THIS SUFFICIENT? prolly


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
                int checkedsum = 0;

                Component[] checked;
                checked = new Component[components.size()];
                circuitcheck = circuitcheck.getConnected().get(0);


                int branchy = 0;
                int branchx = 0;

                do{//LOOP TIME!
                    List<Component> checkList = Arrays.asList(checked);

                    //if we're not at the end and we haven't checked it already...
                    if (( circuitcheck.getConnected().size() > 1 ) && !( checkList.contains(circuitcheck) )){
                        int next = 0;
                        //until we haven't checked get(i) yet...
                        for ( int i = 1; !checkList.contains(circuitcheck.getConnected().get(i-1)); i++){//still needs changes
                            next = i;
                        }
                    }

                }while ( checkedsum <= components.size() );

            }
        }


        //the following does voltage and amperage calculations, assigns relevant values
        //to components, and marks burn-outs
        //INSERT CODE HERE


        return status;
    }
}
