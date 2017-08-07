package com.furkilic.tplist;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    String[] week = {"LUNDI","MARDI","MERCREDI","JEUDI","VENDREDI","SAMEDI","DIMANCHE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,week);
        setListAdapter(adapter);*/

       List<Eleve> eleves = new ArrayList<>();
        for(int i=0;i<20;i++){
            Eleve eleve = new Eleve();
            eleve.setLastname("CHAUDEY_"+i);
            eleve.setFirstname("CAROLINE_"+i);
            eleve.setAge(i);
            eleves.add(eleve);
        }
        /*ArrayAdapter<Eleve> adapter = new ArrayAdapter<Eleve>(this,
                android.R.layout.simple_list_item_1,eleves);*/
        EleveAdapter adapter = new EleveAdapter(this,eleves);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Eleve eleve = (Eleve) getListAdapter().getItem(position);
        Toast.makeText(this, eleve.toString(), Toast.LENGTH_SHORT).show();
        super.onListItemClick(l, v, position, id);
    }
    
}
