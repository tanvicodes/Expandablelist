package com.example.advantal.expandablelist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

/**
 * Created by advantal on 1/20/2016.
*/

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
import java.util.zip.Inflater;


public class main_activity extends ExpandableListActivity {
    Cursor cur;
    Bundle bundle;
    private ArrayList<String> parentItems = new ArrayList<String>();
    private ArrayList<Object> childItems = new ArrayList<Object>();
    ArrayList<String> child;// = new ArrayList<String>();
    private LayoutInflater inflater;
    View cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        bundle=getIntent().getExtras();
        String name=bundle.getString("key");
        Context c = getApplicationContext();
        ExpandableListView expandableList = getExpandableListView();
        expandableList.setDividerHeight(2);
        expandableList.setGroupIndicator(null);
        Uri smsurl = Uri.parse("content://sms/inbox");
        cur = getContentResolver().query(smsurl, null, null, null, null);
        expandableList.setClickable(true);
        MyExapdableAdapter adapter = new MyExapdableAdapter(parentItems, childItems);
        LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.layout_main, null);
        adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
        expandableList.setAdapter(adapter);
        expandableList.setOnChildClickListener(this);
        if(name.equalsIgnoreCase("Read Inbox")) {
            while (cur.moveToNext()) {
                parentItems.add(cur.getString(2));
                child = new ArrayList<String>();
                child.add(cur.getString(12));
                childItems.add(child);

            }
            cur.close();
        }
        else if (name.equalsIgnoreCase("Read Contacts"))
        {
            cur = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            while (cur.moveToNext())
            {

                String ContactName = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String PhoneNumber = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                parentItems.add(ContactName);
                child = new ArrayList<String>();
                child.add(PhoneNumber);
                childItems.add(child);

            }
            cur.close();
        }

    }

}
