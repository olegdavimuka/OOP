package com.example.android.test2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ResponseAdapter extends ArrayAdapter {

    ResponseAdapter(Activity context, ArrayList<Response> responses) {
        super(context, 0, responses);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Response currentResponse = (Response) getItem(position);

        TextView idTextView = listItemView.findViewById(R.id.id);

        idTextView.setText("№ " + currentResponse.getNumber());

        TextView responseTextView = listItemView.findViewById(R.id.responseCode);

        responseTextView.setText("Response code: " + currentResponse.getResponseCode());

        return listItemView;
    }
}
