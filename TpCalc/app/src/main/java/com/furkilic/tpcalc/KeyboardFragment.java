package com.furkilic.tpcalc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.furkilic.tpcalc.interfaces.CalculationRequest;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class KeyboardFragment extends Fragment {

    private final int[] buttons = {R.id.one,R.id.two,R.id.three,R.id.four,R.id.five,R.id.six,
                                    R.id.seven,R.id.eight,R.id.nine,R.id.zero,R.id.dot,
            R.id.equal,R.id.substract,R.id.addition,R.id.divide,R.id.multiply};

    private String number1="";
    private String number2="";
    private String operation;


    public KeyboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_keyboard,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        for(int buttonId : buttons){
            Button button = (Button) getView().findViewById(buttonId);
            registerOnclickListener(button);
        }
    }

    private void registerOnclickListener(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnClick(((Button)v).getText().toString());
            }
        });
    }

    private void myOnClick(String text) {
        if ("=".equals(text)){
            sendCalculationRequest();
            return;
        }
        if("+".equals(text)){
            operation=text;
            return;
        }
        if (operation==null){
            number1+=text;
        }else{
            number2+=text;
        }
    }

    private void sendCalculationRequest() {
        ((CalculationRequest)getActivity()).calculate(number1,operation,number2);
        number1="";
        number2="";
        operation=null;
    }
}
