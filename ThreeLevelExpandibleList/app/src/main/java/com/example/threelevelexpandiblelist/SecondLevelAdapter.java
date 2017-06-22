package com.example.threelevelexpandiblelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;


public class SecondLevelAdapter extends BaseExpandableListAdapter {

    private Context context;


    HashMap<String, String[]> data;

    String[] headers;


    public SecondLevelAdapter(Context context, String[] headers, HashMap<String, String[]> data) {
        this.context = context;
        this.data = data;
        this.headers = headers;
    }

    @Override
    public Object getGroup(int groupPosition) {

        return headers[groupPosition];
    }

    @Override
    public int getGroupCount() {

        return headers.length;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_second, null);
            TextView text = (TextView) convertView.findViewById(R.id.rowSecondText);
            text.setText(getGroup(groupPosition).toString());
        }
        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_third, null);
            TextView text = (TextView) convertView.findViewById(R.id.rowThirdText);

            String[] children = data.get(headers[groupPosition]);

            text.setText(children[childPosition]);
        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(headers[groupPosition]).length;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}