package com.joshrobjames.circuitapp;

/**
 * Created by James on 3/15/2015.
 */
public class Resistor extends Component {
    private int ohms;
    private float tolerance;

    public Resistor (int R, float  T, int leads){
        super (leads);
        ohms = R;
        tolerance = T;
    }

    public int getResistance (){
        return ohms;
    }

    public float getTolerance (){
        return tolerance;
    }


}
