package com.furkilic.tpappwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Date;

/**
 * Created by furki on 04/07/2017.
 */

public class MyWidget extends AppWidgetProvider {

    public static final String MY_WIDGET = "MyWidget";
    public static final String IS_MANUAL = "IS_MANUAL";

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if(AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(intent.getAction())){
            if(intent.getBooleanExtra(IS_MANUAL,false)){
                int appwidgetId=intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,-1);
                if(-1!=appwidgetId){
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                    updateWidget(context,appWidgetManager,appwidgetId,new Date().toString());
                }
            }
        }
    }
    public static void updateWidget(Context context,
                                    AppWidgetManager appWidgetManager,
                                    int appWidgetId,
                                    String text){
        RemoteViews widgetView = new RemoteViews(context.getPackageName(),R.layout.widget_layout);
        widgetView.setTextViewText(R.id.myButton,text);

        Intent refreshIntent = new Intent(context,MyWidget.class);
        refreshIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        refreshIntent.putExtra(IS_MANUAL,true);
        refreshIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        PendingIntent refreshPI =
                PendingIntent.getBroadcast(context,appWidgetId,refreshIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        widgetView.setOnClickPendingIntent(R.id.myButton,refreshPI);

        Intent intent = new Intent(context,WidgetConfigureActivity.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(context,appWidgetId,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        widgetView.setOnClickPendingIntent(R.id.configure,pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId,widgetView);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.i(MY_WIDGET,"onUpdate");
        for (int appWidgetId : appWidgetIds){
            updateWidget(context,appWidgetManager,appWidgetId,new Date().toString());
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.i(MY_WIDGET,"onDeleted");
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.i(MY_WIDGET,"onEnabled");
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.i(MY_WIDGET,"onDisabled");
    }
}
