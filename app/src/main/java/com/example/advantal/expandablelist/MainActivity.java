package com.example.advantal.expandablelist;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Objects;



import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.SortedList;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {
    ListView list;
    Button loadbtn;
    RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rl=(RelativeLayout)findViewById(R.id.RelativeLayout);
    }

    public void sms(View v)
    {
        Bundle bun = new Bundle();
        loadbtn=(Button)v;
        final String str=loadbtn.getText().toString();
        bun.putString("key",str);
        Context c=getApplicationContext();
        Intent i = new Intent(c,main_activity.class);
        i.putExtras(bun);
        startActivity(i);

    }

    public void loadbutton(View v)
    {
        Bundle bun=new Bundle();
        Context c=getApplicationContext();
        loadbtn=(Button)v;
        final String str=loadbtn.getText().toString();
        bun.putString("key",str);
        Intent i = new Intent(c,main_activity.class);
        i.putExtras(bun);
        startActivity(i);
    }

}


