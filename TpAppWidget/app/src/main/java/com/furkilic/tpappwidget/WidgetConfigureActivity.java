package com.furkilic.tpappwidget;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class WidgetConfigureActivity extends AppCompatActivity {

    int myWidgetId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_configure);

        myWidgetId = getIntent()
                .getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,AppWidgetManager.INVALID_APPWIDGET_ID);

    }


   public void onOkButtonClick(View view){
       //UPDATE VIEW FIRST
       AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
       EditText editText = (EditText) findViewById(R.id.editText);
       String text = editText.getText().toString();
       MyWidget.updateWidget(this,appWidgetManager,myWidgetId,text);

       //QUIT WITH SUCCESS
       Intent intent = new Intent();
       intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, myWidgetId);
       setResult(RESULT_OK,intent);
       finish();
   }
}
