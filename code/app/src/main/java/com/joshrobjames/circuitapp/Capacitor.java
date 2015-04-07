package com.joshrobjames.circuitapp;

/**
 * Created by James on 3/16/2015.
 */
public class Capacitor extends Component {
    private float capacitance; // C = Q / V, in farads
    private float breakVoltage;

    public Capacitor (float C, float B, int leads){
        super (leads);
        capacitance = C;
        breakVoltage = B;
    }

    public float getCapacitance(){
        return capacitance;
    }

    public float getBreakVoltage(){
        return breakVoltage;
    }
}
