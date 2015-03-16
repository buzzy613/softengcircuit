package com.joshrobjames.circuitapp;

/**
 * Created by James on 3/16/2015.
 */
public class PowerSource extends Component{
    private int voltage;
    private float maxAmps;

    public PowerSource (int V, float A, int leads){
        super (leads);
        voltage = V;
        maxAmps = A;
    }

    public int getVoltage (){
        return voltage;
    }

    public float getMaxAmps (){
        return maxAmps;
    }
}
