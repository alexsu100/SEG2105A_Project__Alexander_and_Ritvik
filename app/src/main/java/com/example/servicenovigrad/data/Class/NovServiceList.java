package com.example.servicenovigrad.data.Class;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.servicenovigrad.R;

import java.util.List;

public class NovServiceList extends ArrayAdapter<NovService> {
private Activity context;
    List<NovService> NovService;

    public NovServiceList(Activity context, List<NovService> NovService) {
        super(context, R.layout.activity_layout_service_list, NovService);
        this.context = context;
        this.NovService = NovService;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_layout_service_list, null, true);

        TextView textViewServiceName = (TextView) listViewItem.findViewById(R.id.textViewServiceName);

        NovService currentService = NovService.get(position);
        textViewServiceName.setText(String.valueOf(currentService.getServiceName()));

        return listViewItem;
    }
}
