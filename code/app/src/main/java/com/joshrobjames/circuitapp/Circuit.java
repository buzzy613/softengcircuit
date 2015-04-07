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


}
