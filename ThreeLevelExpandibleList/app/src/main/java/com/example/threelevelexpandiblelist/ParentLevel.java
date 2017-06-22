package com.example.threelevelexpandiblelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

public class ParentLevel extends BaseExpandableListAdapter
{
	
	String[] parent;
	List<String[]> secondLevel;
	private Context context;
	
	public ParentLevel( Context context, String[] parent, List<String[]> secondLevel )
	{
		this.context = context;
		
		this.parent = parent;
		
		this.secondLevel = secondLevel;
	}
	
	@Override
	public int getGroupCount()
	{
		return parent.length;
	}
	
	@Override
	public int getChildrenCount( int groupPosition )
	{
		return secondLevel.get( groupPosition ).length;
	}
	
	@Override
	public Object getGroup( int groupPosition )
	{
		return groupPosition;
	}
	
	@Override
	public Object getChild( int arg0, int arg1 )
	{
		return arg1;
	}
	
	@Override
	public long getGroupId( int groupPosition )
	{
		return groupPosition;
	}
	
	@Override
	public long getChildId( int groupPosition, int childPosition )
	{
		return childPosition;
	}
	
	@Override
	public boolean hasStableIds()
	{
		return true;
	}
	
	@Override
	public View getGroupView( int groupPosition, boolean isExpanded, View convertView, ViewGroup parent )
	{
		if ( convertView == null )
		{
			LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			convertView = inflater.inflate( R.layout.row_first, null );
			TextView text = (TextView) convertView.findViewById( R.id.eventsListEventRowText );
			text.setText( "FIRST LEVEL" );
		}
		return convertView;
	}
	
	@Override
	public View getChildView( int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent )
	{
		SecondLevelExpandableListView secondLevelELV = new SecondLevelExpandableListView( context );
		secondLevelELV.setAdapter( new SecondLevelAdapter( context ) );
		secondLevelELV.setGroupIndicator( null );
		return secondLevelELV;
	}
	
	@Override
	public boolean isChildSelectable( int groupPosition, int childPosition )
	{
		return true;
	}
}
