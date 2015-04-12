package com.joshrobjames.circuitapp;

/**
 * Created by James on 3/16/2015.
 */
public class ACPowerSource extends PowerSource {
    private int frequency;// in hertz

    public ACPowerSource (int V, float A, int H){
        super (V, A);
        frequency = H;
        type = "AC power source";
    }

    public int getfrequency (){
        return frequency;
    }
}
