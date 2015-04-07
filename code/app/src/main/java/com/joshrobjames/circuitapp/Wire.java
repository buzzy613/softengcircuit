package com.joshrobjames.circuitapp;

/**
 * Created by James on 3/21/2015.
 */
public class Wire extends Component {

    public Wire(){
        super (2);
    }

    public void addParallel( Component connect ) {
        addLeads( 1 );
        //FURTHER THINGS
    }
}

