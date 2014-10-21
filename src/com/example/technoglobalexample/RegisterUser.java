package com.example.technoglobalexample;

import com.example.technoglobalexample.data.AccessModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUser extends Activity implements OnClickListener {
	
	EditText name;
	EditText lname;
	EditText username;
	EditText pass;
	EditText cell;
	EditText email;
	Button btnsave;
	private AccessModel data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.register);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		data = new AccessModel(this);
		name = (EditText) findViewById(R.id.txtname);
		lname = (EditText) findViewById(R.id.txtlname);
		username = (EditText) findViewById(R.id.txtuser);
		pass = (EditText) findViewById(R.id.txtpass);
		cell = (EditText) findViewById(R.id.txtcell);
		email = (EditText) findViewById(R.id.txtemail);
		btnsave = (Button) findViewById(R.id.btsave);
				
		btnsave.setOnClickListener(this);
	}
	
	
	private void registerUser(){
		try{
			data.registerUser(name.getText().toString(), lname.getText().toString(), username.getText().toString(), pass.getText().toString(), cell.getText().toString(), email.getText().toString());			
			Toast.makeText(this, getString(R.string.good), Toast.LENGTH_LONG).show();			
		}catch(Exception e){
			Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show();
		}
		back();
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.btsave:
				registerUser();
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
