package com.furkilic.tpfragment;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnChangeActivityTextView{

    public static final String MAIN_ACTIVITY = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(MAIN_ACTIVITY,"onCreate");

        Fragment sampleFragment = new SampleFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       // fragmentTransaction.add(R.id.fragmentPlaceHolder,sampleFragment);
        fragmentTransaction.replace(R.id.fragmentPlaceHolder,sampleFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        Button button = (Button) findViewById(R.id.activityButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateFragments();
            }
        });

    }

    private void updateFragments() {
        for(Fragment fragment : getSupportFragmentManager().getFragments()){
            SampleFragment sf = (SampleFragment) fragment;
            sf.changeSampleTextView("TITI");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(MAIN_ACTIVITY,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(MAIN_ACTIVITY,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MAIN_ACTIVITY,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(MAIN_ACTIVITY,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(MAIN_ACTIVITY,"onDestroy");
    }


    @Override
    public void changeActivityTextView(String string){
        TextView textView = (TextView) findViewById(R.id.activityTextView);
        textView.setText(string);
    }


}
