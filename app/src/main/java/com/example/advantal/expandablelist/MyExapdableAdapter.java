package com.example.advantal.expandablelist;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by advantal on 1/20/2016.
 */
public class MyExapdableAdapter extends BaseExpandableListAdapter {

    private Activity activity;
    private ArrayList<Object> childitems;
    private LayoutInflater inflater;
    private ArrayList<String > parentsitems, child;


    public MyExapdableAdapter(ArrayList<String> parents, ArrayList<Object> children)
    {
        this.parentsitems=parents;
        this.childitems=children;
    }

    public void setInflater(LayoutInflater inflater, Activity activity)
    {
        this.inflater=inflater;
        this.activity=activity;

    }

    @Override
    public View getChildView(int grouppos, final int childpos, boolean isLastChild, View convertView, ViewGroup parent)
    {
        child=(ArrayList<String>)childitems.get(grouppos);
        TextView textView=null;
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.expandablelistview,null);
        }
        textView=(TextView)convertView.findViewById(R.id.textView1);
        textView.setText(child.get(childpos));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,child.get(childpos),Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }


    @Override
    public int getGroupCount() {
        return parentsitems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ((ArrayList<String>)childitems.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
                convertView = inflater.inflate(R.layout.layoutofchild,null);
        }
        ((CheckedTextView) convertView).setText(parentsitems.get(groupPosition));
        ((CheckedTextView) convertView).setChecked(isExpanded);

        return convertView;
    }



    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public void onGroupCollapsed(int groupPosition)
    {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition)
    {
        super.onGroupExpanded(groupPosition);
    }
}
