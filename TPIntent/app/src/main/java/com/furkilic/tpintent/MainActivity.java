package com.furkilic.tpintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String INTENT_EXTRA_KEY = "INTENT_EXTRA_KEY";
    public static final int REQUEST_CODE_SECOND_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mainButton = (Button) findViewById(R.id.mainButton);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivity();
            }
        });
    }

    private void startSecondActivity() {
        EditText editText = (EditText) findViewById(R.id.mainEditText);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(INTENT_EXTRA_KEY,editText.getText().toString());
        //startActivity(intent);
        startActivityForResult(intent, REQUEST_CODE_SECOND_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_SECOND_ACTIVITY){
            if(resultCode == RESULT_OK){
                String textFromSecondActivity = data.getStringExtra(SecondActivity.RETURN_TEXT);
                Toast.makeText(this, textFromSecondActivity, Toast.LENGTH_SHORT).show();
                MessageHolder messageHolder = (MessageHolder) data.getSerializableExtra(SecondActivity.RETURN_OBJECT);
                Toast.makeText(this, messageHolder.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
