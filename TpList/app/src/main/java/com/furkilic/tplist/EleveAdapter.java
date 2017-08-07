package com.furkilic.tplist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by furki on 05/05/2017.
 */

public class EleveAdapter extends ArrayAdapter<Eleve> {

    public EleveAdapter(Context context, List<Eleve> eleves){
        super(context,0,eleves);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.row,null);

        TextView lastname= (TextView) row.findViewById(R.id.lastname);
        TextView firstname= (TextView) row.findViewById(R.id.firstname);
        TextView age= (TextView) row.findViewById(R.id.age);

        Eleve eleve = getItem(position);
        lastname.setText(eleve.getLastname());
        firstname.setText(eleve.getFirstname());
        age.setText(eleve.getAge().toString());

        return row;
    }
}
