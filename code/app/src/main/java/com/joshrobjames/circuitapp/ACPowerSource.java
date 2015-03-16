package com.joshrobjames.circuitapp;

/**
 * Created by James on 3/16/2015.
 */
public class ACPowerSource extends PowerSource {
    private int hertz;

    public ACPowerSource (int V, float A, int H, int leads){
        super (V, A, leads);
        hertz = H;
    }

    public int getHertz (){
        return hertz;
    }
}
