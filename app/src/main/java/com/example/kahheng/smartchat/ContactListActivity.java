package com.example.kahheng.smartchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Ryan on 2/29/2016.
 */
public class ContactListActivity extends Activity {
    ListView listView;
    int[]contact_resource = {R.drawable.dp_1,R.drawable.dp_2,R.drawable.dp_3,R.drawable.dp_4,R.drawable.dp_5};
    String[] contact_name;
    ContactAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);
        listView = (ListView)findViewById(R.id.list_view);
        contact_name= getResources().getStringArray(R.array.contact_names);
        int i = 0;
        adapter = new ContactAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newActivity = new Intent(ContactListActivity.this, MainActivity.class);
                startActivity(newActivity);
            }
        });
                //Toast.makeText(getBaseContext(),"I am selected",Toast.LENGTH_LONG).show();




        for(String name:contact_name){

            ContactDataProvider dataProvider = new ContactDataProvider(contact_resource[i],name);
            adapter.add(dataProvider);
            i++;

        }
    }
}
