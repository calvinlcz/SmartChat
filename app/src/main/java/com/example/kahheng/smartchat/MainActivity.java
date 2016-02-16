package com.example.kahheng.smartchat;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.chat_list_view);
        chat_text = (EditText) findViewById(R.id.chatTxt);
        SEND = (Button) findViewById(R.id.send_button);
        adapter = new ChatAdapter(ctx,R.layout.single_message_layout);
        listview.setAdapter(adapter);
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
                position = !position;
                chat_text.setText("");
            }
        }
        );
    }
}