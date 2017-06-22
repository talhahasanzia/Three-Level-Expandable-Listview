package com.example.threelevelexpandiblelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
	
	ExpandableListView expandableListView;
	
	String[] parent = new String[]{"Category 1", "Category 2"};
	
	
	String[] category1List = new String[]{"1 one", "1 two", "1 three"};
	String[] category2List = new String[]{"2 one", "2 two", "2 three", "2 four"};
	
	
	List<String[]> secondLevel = new ArrayList<>();
	
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );
		
		expandableListView=(ExpandableListView)findViewById( R.id.expandible_listview );
		
		ParentLevel parentLevelAdapter=new ParentLevel(this, parent,secondLevel);
		
		expandableListView.setAdapter(parentLevelAdapter);
		
		
	}
}
