package com.example.technoglobalexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.technoglobalexample.data.AccessModel;
import com.example.technoglobalexample.objects.User;

public class ManagerActivity extends Activity implements OnClickListener {
	
	EditText name;
	EditText lname;
	EditText username;
	EditText pass;
	EditText cell;
	EditText email;
	Button btnedit;
	Button btndelete;
	private AccessModel data;
	private String userId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.manager);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		data = new AccessModel(this);
		
		name = (EditText) findViewById(R.id.mn_name);
		lname = (EditText) findViewById(R.id.mn_lname);
		username = (EditText) findViewById(R.id.mn_user);
		pass = (EditText) findViewById(R.id.mn_pass);
		cell = (EditText) findViewById(R.id.mn_cell);
		email = (EditText) findViewById(R.id.mn_email);
		
		btnedit = (Button) findViewById(R.id.btedit);
		btndelete = (Button) findViewById(R.id.btdelete);				
		
		btnedit.setOnClickListener(this);
		btndelete.setOnClickListener(this);
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		Bundle v = getIntent().getExtras();
				
		if(v==null){
			back();
			return;
		}
		
		userId = v.getString(getString(R.string.valuesId));		
		loadData(userId);
				
	}
	
	private void loadData(String id){
		
			User u = (User) data.getUser(id);
			Toast.makeText(this, u.getName(), Toast.LENGTH_LONG).show();			
			name.setText(u.getName().toString());			
			lname.setText(u.getLastName());
			username.setText(u.getUserName());
			pass.setText(u.getPassword());
			cell.setText(u.getCell());
			email.setText(u.getEmail());
			
	}

	
	private void updateUser(String id){
		String[] ids = {id};
		try{
			data.updateUser(ids,name.getText().toString(), lname.getText().toString(), username.getText().toString(), pass.getText().toString(), cell.getText().toString(), email.getText().toString());						
			Toast.makeText(this, getString(R.string.good), Toast.LENGTH_LONG).show();			
		}catch(Exception e){
			Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show();
		}	
	}
	
	private void deleteUser(String id){
		String[] ids = {id};
		try{
			data.deleteUser(ids);						
			Toast.makeText(this, getString(R.string.good), Toast.LENGTH_LONG).show();
			back();
		}catch(Exception e){
			Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show();
		}	
	}
	
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btedit:
			updateUser(userId);
			break;
		case R.id.btdelete:
			deleteUser(userId);
			break;
		}
	}
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case android.R.id.home:
            	back();
                return true;                
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    
    private void back(){
    	Intent i = new Intent(this, UserActivity.class);
        startActivity(i);
    }

}
