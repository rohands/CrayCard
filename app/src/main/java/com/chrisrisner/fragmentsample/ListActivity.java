package com.chrisrisner.fragmentsample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListActivity extends AppCompatActivity {

    ListView lv;
    Context context;
    SearchView search;
    CustomAdapter mAdapter;



    //Integer[] ids = {R.drawable.starbucks,R.drawable.pizzahut,R.drawable.pandaexpress,R.drawable.burgerking,R.drawable.blaze,R.drawable.baskinrobins};
    Integer[] food_id = {R.drawable.starbucks,R.drawable.pizzahut,R.drawable.pandaexpress,R.drawable.burgerking,R.drawable.blaze,R.drawable.baskinrobins};
    Integer[] food_dollars = {20,50,50,30,50,20};
    String[] food_names = {"Starbucks","Pizza Hut","Panda Express","Burger King","Blaze","Baskin Robins"};

    Integer[] tech_id = {R.drawable.nokia,R.drawable.apple,R.drawable.dell,R.drawable.hp,R.drawable.panasonic,R.drawable.samsung};
    Integer[] tech_dollars = {250,500,100,300,50,150};
    String[] tech_names = {"Nokia","Apple","Dell","HP","Panasonic","Samsung"};

    Integer[] travel_id ={R.drawable.delta,R.drawable.lyft,R.drawable.uber,R.drawable.emirates,R.drawable.singapore,R.drawable.supershuttle};
    Integer[] travel_dollars = {200,20,50,500,500,100};
    String[] travel_names = {"Delta","Lyft","Uber","Emirates","Singapore","SuperShuttle"};

    Integer[] shop_id = {R.drawable.hm,R.drawable.forever21,R.drawable.nike,R.drawable.adidas,R.drawable.zara};
    Integer[] shop_dollars = {25,25,100,75,100};
    String[] shop_names = {"H&M","Forever21","Nike","Adidas","Zara"};

    Integer[] ids;
    Integer[] dollars;
    String[] names;

    Integer type;
    public static ArrayList<Integer> prgmImages;
    public static ArrayList<Integer> moneyArray;
    public static ArrayList<String> prgmNameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv=(ListView) findViewById(R.id.listView);
        prgmImages = new ArrayList<>();
        moneyArray = new ArrayList<>();
        prgmNameList = new ArrayList<>();


        Intent intent = getIntent();
        ArrayList<Integer> tempMoneyList = new ArrayList<Integer>();
        ArrayList<String> tempNamesList = new ArrayList<>();
        ArrayList<Integer> tempImageIds = new ArrayList<>();

        mAdapter = new CustomAdapter(ListActivity.this, tempMoneyList,tempNamesList,tempImageIds);
        lv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        type = intent.getIntExtra("type",0);
        type = type.intValue();
        Log.d("Type:",String.valueOf(type));
        if(type==0 || type==6)
        {
            ids = food_id;
            names = food_names;
            dollars = food_dollars;
            Log.d("Food","Entered food");
        }
        else if(type==1 || type== 7)
        {
            ids= tech_id;
            names = tech_names;
            dollars = tech_dollars;
        }
        else if(type==2 || type==4)
        {
            ids = shop_id;
            names = shop_names;
            dollars = shop_dollars;
        }
        else if(type==3 || type==5)
        {
            ids= travel_id;
            names= travel_names;
            dollars = travel_dollars;
        }
        prgmImages.addAll(Arrays.asList(ids));
        moneyArray.addAll(Arrays.asList(dollars));
        prgmNameList.addAll(Arrays.asList(names));
        Log.d("101",String.valueOf(prgmNameList.size()));
        lv.setAdapter(new CustomAdapter(this, moneyArray,prgmNameList,prgmImages));
        context=this;
        search = (SearchView) findViewById(R.id.searchme);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);

        myFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this,MainActivity.class);
                intent.putExtra("goto",3);
                startActivity(intent);
            }
        });
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.e("101","Submit");
                int textlength = s.length();
                ArrayList<Integer> tempMoneyList = new ArrayList<Integer>();
                ArrayList<String> tempNamesList = new ArrayList<>();
                ArrayList<Integer> tempImageIds = new ArrayList<>();
                for(int i=0;i<prgmNameList.size();++i){
                    if (textlength <= prgmNameList.get(i).length()) {
                        if (prgmNameList.get(i).toLowerCase().contains(s.toString().toLowerCase())) {
                            tempMoneyList.add(moneyArray.get(i));
                            tempNamesList.add(prgmNameList.get(i));
                            tempImageIds.add(prgmImages.get(i));
                        }
                    }
                }
                mAdapter = new CustomAdapter(ListActivity.this, tempMoneyList,tempNamesList,tempImageIds);
                lv.setAdapter(mAdapter);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                int textlength = s.length();
                ArrayList<Integer> tempMoneyList = new ArrayList<Integer>();
                ArrayList<String> tempNamesList = new ArrayList<>();
                ArrayList<Integer> tempImageIds = new ArrayList<>();
                for(int i=0;i<prgmNameList.size();++i){
                    if (textlength <= prgmNameList.get(i).length()) {
                        if (prgmNameList.get(i).toLowerCase().contains(s.toString().toLowerCase())) {
                            tempMoneyList.add(moneyArray.get(i));
                            tempNamesList.add(prgmNameList.get(i));
                            tempImageIds.add(prgmImages.get(i));
                        }
                    }
                }
                mAdapter = new CustomAdapter(ListActivity.this, tempMoneyList,tempNamesList,tempImageIds);
                lv.setAdapter(mAdapter);
                return true;

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        finish();
    }

    @Override
    public void onResume()
    {
        super.onResume();

    }

}
