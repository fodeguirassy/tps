package com.furkilic.tpfragment;

/**
 * Created by furki on 13/06/2017.
 */

public class CalculFactory {

    public static ICalcul getCalcul(String operation){
        switch (operation){
            case "+":
                return new Somme();
            case "-":
                return new Substract();
            ......
            default:
                throw Exception("Not implemented yet");
        }
    }
}
