package com.kanak.emptylayoutsample;

import java.util.ArrayList;
import java.util.Arrays;

import com.kanak.emptylayout.EmptyLayout;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.app.ListActivity;

public class MainActivity extends ListActivity {

	private EmptyLayout mEmptyLayout; // this is required to show different layouts (loading or empty or error)
	private ArrayAdapter<String> mAdapter;
	private View.OnClickListener mErrorClickListener = new OnClickListener() {			
		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this, "Try again button clicked", Toast.LENGTH_LONG).show();			
		}
	};
	
	// the list items
	static final String[] MOVIES = new String[] { 
		"Forrest Gump", 
		"Toy Story", 
		"Saving Private Ryan", 
		"Toy Story 2", 
		"The Green Mile", 
		"Cast Away", 
		"Road to Perdition", 
		"Catch Me If You Can", 
		"The Terminal", 
		"The Polar Express", 
		"The Da Vinci Code", 
		"Angels & Demons", 
		"Toy Story 3", 
		"Extremely Loud & Incredibly Close", 
		"Cloud Atlas", 
		"Captain Phillips", 
		"Toy Story 4",
		"The Lost Symbol" 
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// initialize the empty view
		mEmptyLayout = new EmptyLayout(this, getListView());
		mEmptyLayout.setErrorButtonClickListener(mErrorClickListener);
		
		// populate the list view
		populateList();
	}

	// Triggered when "Empty" button is clicked
	public void onShowEmpty(View view) {
		// clear the list and show the empty layout
		mAdapter.clear();
		mEmptyLayout.showEmpty();
	}

	// Triggered when "Loading" button is clicked
	public void onShowLoading(View view) {
		// clear the list and show the loading layout
		mAdapter.clear();
		mEmptyLayout.showLoading();
	}

	// Triggered when "Error" button is clicked
	public void onShowError(View view) {
		// clear the list and show the error layout
		mAdapter.clear();
		mEmptyLayout.showError();
	}
	
	// Triggered when "List" button is clicked
	public void onShowList(View view) {
		// show the list
		populateList();
	}

	private void populateList() {
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(MOVIES));
		mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		setListAdapter(mAdapter);
	}
}
