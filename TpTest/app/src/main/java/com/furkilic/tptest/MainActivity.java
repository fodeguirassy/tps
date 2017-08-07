package com.furkilic.tptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String ERROR_MESSAGE = "ERROR";
    public static final String SUCCESS_MESSAGE = "SUCCESS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.validatorButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void validate() {
        EditText firstEditText = (EditText) findViewById(R.id.firstEditText);
        EditText secondEditText = (EditText) findViewById(R.id.secondEditText);

        TextView result = (TextView) findViewById(R.id.resultTextView);
        if(isTwoStringEqual(firstEditText.getText().toString(), secondEditText.getText().toString())){
            result.setText(SUCCESS_MESSAGE);
        }else{
            result.setText(ERROR_MESSAGE);
        }

    }

    public boolean isTwoStringEqual(String firstString, String secondString) {
        //throw new RuntimeException("Not implemented");
        if (null == firstString && null == secondString) {
            return true;
        } else if (null == firstString || null == secondString) {
            return false;
        }
        return firstString.equals(secondString);
    }
}
