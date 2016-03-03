package com.example.kahheng.smartchat;

import android.app.ActionBar;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.content.Context;
import android.widget.AbsListView;



public class MainActivity extends Activity {
    ListView listview;
    EditText chat_text;
    Button SEND;
    boolean position = false;
    ChatAdapter adapter;
    Context ctx = this;
    //ActionBar actionBar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_draw:
                Intent newActivity = new Intent(MainActivity.this, DrawingActivity.class);
                startActivity(newActivity);
                break;

        }


        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //actionBar = getActionBar();
        //actionBar.setTitle("");
        listview = (ListView) findViewById(R.id.chat_list_view);
        chat_text = (EditText) findViewById(R.id.chatTxt);
        SEND = (Button) findViewById(R.id.send_button);
        adapter = new ChatAdapter(ctx,R.layout.single_message_layout);
        listview.setAdapter(adapter);
        registerForContextMenu(listview);
        listview.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        adapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listview.setSelection(adapter.getCount() - 1);
            }
        });
        SEND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add(new DataProvider(position, chat_text.getText().toString()));
               // position = !position;
                chat_text.setText("");
            }
        }
        );


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
    }
}