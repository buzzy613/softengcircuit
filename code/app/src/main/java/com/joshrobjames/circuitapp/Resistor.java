package com.joshrobjames.circuitapp;

/**
 * Created by James on 3/15/2015.
 */
public class Resistor extends Component {
    private float resistance;// in ohms
    private float tolerance;// a percentage

    //simulation values
    private float volt;
    private float amp;

    public Resistor (int R, float  T){
        super (2);
        resistance = R;
        tolerance = T;
        type = "resistor";
    }

    public float getResistance (){
        return resistance;
    }

    public float getTolerance (){
        return tolerance;
    }

    public void setResistance ( float R ) {
        resistance = R;
    }

    public void setTolerance ( float T ) {
        tolerance = T;
    }


    public float getVolt () {
        return volt;
    }

    public float getAmp () {
        return amp;
    }

    public void setVolt ( float V ) {
        volt = V;
    }

    public void setAmp ( float A ) {
        amp = A;
    }

    /*public String[] getColors () {//not finished
        String R = new String();
        R = Integer.toString(resistance);

        String[] colors;

        int multiplier = 0;
        for (int i = R.length(); R.charAt(i) == 0; i--) {

        }
        return colors;
    }*/
}
