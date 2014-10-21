package com.example.technoglobalexample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.technoglobalexample.data.AccessModel;
import com.example.technoglobalexample.data.ListAdapter;
import com.example.technoglobalexample.objects.User;


public class UserActivity extends Activity implements OnItemClickListener {

	private ListAdapter users;
	private ListView lista;
	private AccessModel data;
	private ArrayList<User> query;
	private LinearLayout empty_data;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		requestWindowFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.listusers);
		lista = (ListView) findViewById(R.id.lstusers);
		empty_data= (LinearLayout) findViewById(R.id.empty_data);
		data = new AccessModel(this);		
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();		
		 query = data.listUser();
		 
	     if(query.size()>0)
	       empty_data.setVisibility(View.GONE);
	     else
	       empty_data.setVisibility(View.VISIBLE);
	        
		 users = new ListAdapter(this, query);
		 lista.setAdapter(users);
		 lista.setOnItemClickListener(this);
		 		 
	}
	
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
    	// TODO Auto-generated method stub
    	getMenuInflater().inflate(R.menu.optionsbar, menu);
    	return super.onPrepareOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.adduser:
            	Intent i = new Intent(this, RegisterUser.class);
                startActivity(i);
                return true;                
            default:
                return super.onOptionsItemSelected(item);
        }

    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub		
		User u = (User) query.get(position);
		Intent i = new Intent(UserActivity.this, ManagerActivity.class);
		i.putExtra(getString(R.string.valuesId), String.valueOf(u.getId()));
		startActivity(i);		
	}
    
    

}
