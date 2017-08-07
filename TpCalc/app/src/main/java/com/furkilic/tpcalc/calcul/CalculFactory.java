package com.furkilic.tpcalc.calcul;

/**
 * Created by furki on 13/06/2017.
 */

public class CalculFactory {

    public static Calcul getCalcul(String operation){
        switch (operation){
            case "+":
                return new Addition();
            default:
                return null;
        }
    }
}
