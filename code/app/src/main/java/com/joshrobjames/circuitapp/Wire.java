package com.joshrobjames.circuitapp;

/**
 * Created by James on 3/21/2015.
 */
public class Wire extends Component {

    public Wire(){
        super (2);
        type = "wire";
    }

    public void addParallel( Component connect ) {
        addLeads( 1 );
        addConnected ( connect );
        //FURTHER THINGS?
    }
}

