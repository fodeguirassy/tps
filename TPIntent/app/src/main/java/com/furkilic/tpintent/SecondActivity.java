package com.furkilic.tpintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public static final String RETURN_TEXT = "RETURN_TEXT";
    public static final String RETURN_OBJECT = "RETURN_OBJECT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String intentValue = getIntent().getStringExtra(MainActivity.INTENT_EXTRA_KEY);
        TextView textView = (TextView) findViewById(R.id.mainText);
        textView.setText(intentValue);



        Button sendButton = (Button) findViewById(R.id.mainButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMainActivity();
            }
        });
    }

    private void returnToMainActivity() {
        EditText editText = (EditText) findViewById(R.id.mainEditText);

        Intent data = new Intent();
        MessageHolder messageHolder = new MessageHolder("Hello from the other side");
        data.putExtra(RETURN_OBJECT, messageHolder);
        data.putExtra(RETURN_TEXT, editText.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }


}
