package com.furkilic.tpfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * Blank is blank
 */
public class SampleFragment extends Fragment {

    public static final String SAMPLE_FRAGMENT = "SAMPLE_FRAGMENT";

    public SampleFragment(){
        super();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(SAMPLE_FRAGMENT,"onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(SAMPLE_FRAGMENT,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(SAMPLE_FRAGMENT,"onCreateView");
        return inflater.inflate(R.layout.fragment_sample,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(SAMPLE_FRAGMENT,"onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(SAMPLE_FRAGMENT,"onStart");
        Button button = (Button) getView().findViewById(R.id.fragmentButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((OnChangeActivityTextView)getActivity()).changeActivityTextView("TOTO");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(SAMPLE_FRAGMENT,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(SAMPLE_FRAGMENT,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(SAMPLE_FRAGMENT,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(SAMPLE_FRAGMENT,"onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(SAMPLE_FRAGMENT,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(SAMPLE_FRAGMENT,"onDetach");
    }

    public void changeSampleTextView(String string) {
        TextView textView = (TextView) getView().findViewById(R.id.fragmentTextView);
        textView.setText(string);
    }
}
