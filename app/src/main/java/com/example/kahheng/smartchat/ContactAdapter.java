package com.example.kahheng.smartchat;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Ryan on 3/1/2016.
 */
public class ContactAdapter extends ArrayAdapter{

    List list = new ArrayList();
    public ContactAdapter(Context context, int resource) {
        super(context, resource);
    }
    static class DataHandler
    {
        ImageView display;
        TextView name;

    }
    public void add(Object object){
        super.add(object);
        list.add(object);

    }
    public int getCount(){
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        DataHandler handler;
        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout,parent,false);
            handler = new DataHandler();
            handler.display = (ImageView)row.findViewById(R.id.display_pic);
            handler.name = (TextView)row.findViewById(R.id.name);
            row.setTag(handler);

        }
        else
        {
            handler = (DataHandler)row.getTag();
        }

        ContactDataProvider dataProvider;
        dataProvider = (ContactDataProvider)this.getItem(position);
        handler.display.setImageResource(dataProvider.getContact_image());
        handler.name.setText(dataProvider.getContact_name());

        return row;


    }
}
