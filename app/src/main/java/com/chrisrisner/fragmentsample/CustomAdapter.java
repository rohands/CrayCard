package com.chrisrisner.fragmentsample;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter
{

    ArrayList<String> names;
    ArrayList<Integer> money;
    Context context;
    ArrayList<Integer> imageId;

    private static LayoutInflater inflater=null;


    public CustomAdapter(ListActivity mainActivity, ArrayList<Integer> moneyArray, ArrayList<String> names, ArrayList<Integer> prgmImages) {
        // TODO Auto-generated constructor stub
        this.names=names;
        context=mainActivity;
        this.money = moneyArray;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView name;
        TextView money;
        ImageView logo;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.row_item, null);
        holder.name=(TextView) rowView.findViewById(R.id.name);
        holder.money=(TextView) rowView.findViewById(R.id.money);
        holder.logo=(ImageView) rowView.findViewById(R.id.logo);
        holder.name.setText(names.get(position));
        Log.e("101",position + " " + money.get(position));
        holder.money.setText("$"+ String.valueOf(money.get(position)));
        holder.logo.setImageResource(imageId.get(position));
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+names.get(position), Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }


}

