package com.joshrobjames.circuitapp;

/**
 * Created by James on 3/16/2015.
 */
public class PowerSource extends Component{
    private int voltage;
    private float maxAmps;

    public PowerSource (int V, float A){
        super (2);
        voltage = V;
        maxAmps = A;
        type = "power source";
    }

    public int getVoltage (){
        return voltage;
    }

    public float getMaxAmps (){
        return maxAmps;
    }
}
