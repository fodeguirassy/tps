package com.furkilic.tpasync;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void updateTextView(long current) {
        TextView textView= (TextView) findViewById(R.id.textView);
        textView.setText("Current number  = "+current);
    }

    public void updateContent(String content) {
        TextView textView= (TextView) findViewById(R.id.content);
        textView.setText(content);
    }

    public void goIncrementer(View view){
        //EditText editText = (EditText) findViewById(R.id.maxNumber);
        //long max = Long.valueOf(editText.getText().toString());
        //Incrementer incrementer = new Incrementer(this,max);
        //incrementer.start();
        //MyAsyncTask myAsyncTask = new MyAsyncTask(this);
        //myAsyncTask.execute(max);

        MyHttpAsyncTask myHttpAsyncTask = new MyHttpAsyncTask(this);
        myHttpAsyncTask.execute("http://jsonplaceholder.typicode.com/users");
    }
}
