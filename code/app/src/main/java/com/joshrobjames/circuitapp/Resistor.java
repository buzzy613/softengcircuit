package com.joshrobjames.circuitapp;

/**
 * Created by James on 3/15/2015.
 */
public class Resistor extends Component {
    private int resistance;// in ohms
    private float tolerance;// a percentage

    public Resistor (int R, float  T){
        super (2);
        resistance = R;
        tolerance = T;
    }

    public int getResistance (){
        return resistance;
    }

    public float getTolerance (){
        return tolerance;
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
