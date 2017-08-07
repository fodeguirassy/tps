package com.furkilic.tpcalc;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.furkilic.tpcalc.calcul.Calcul;
import com.furkilic.tpcalc.calcul.CalculFactory;
import com.furkilic.tpcalc.interfaces.CalculationRequest;

import java.math.BigDecimal;

public class MainActivity extends FragmentActivity implements CalculationRequest {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void calculate(String number1, String op, String number2) {
        Calcul calcul=CalculFactory.getCalcul(op);
        BigDecimal response = calcul.calcul(new BigDecimal(number1), new BigDecimal(number2));
        String result = number1+" "+op+" "+number2+ " = "+response.toString();
        ResultFragment resultFragment=
                (ResultFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_result);
        resultFragment.addResultInList(result);
    }
}
