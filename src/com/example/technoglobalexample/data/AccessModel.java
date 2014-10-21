package com.example.technoglobalexample.data;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.MediaStore.Audio;
import android.text.format.DateFormat;
import android.util.Log;

import com.example.technoglobalexample.R;
import com.example.technoglobalexample.objects.User;

public class AccessModel extends SQLiteOpenHelper {

    private static final int version = 1;
    private SQLiteDatabase db;
    Context context;

    public AccessModel(Context context) {
        super(context, context.getString(R.string.databasenamer), null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();

        try {           
        	db.execSQL("CREATE TABLE User(id Integer primary key autoincrement,name TEXT,lastname TEXT,username TEXT,password TEXT,cellphone TEXT, email TEXT)");			
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            throw e;
        } finally {
            db.endTransaction();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    	onCreate(db);
    }

    public void registerUser(String name,String lastname, String username, String password, String cellphone, String email) throws SQLException {
        try {
            db = getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("lastname", lastname);
            values.put("username", username);
            values.put("password", password);
            values.put("cellphone", cellphone);
            values.put("email", email);
            db.insert("User", null, values);
            db.close();

        } catch (SQLException e) {
            
        }
    }

    public ArrayList<User> listUser() {
        ArrayList<User> values = new ArrayList<User>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from User order by id desc", null);
        if (c.getCount() != 0) {
            c.moveToFirst();
            do {
                User data = new User(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6));
                values.add(data);
            } while (c.moveToNext());
        }
        db.close();
        c.close();
        return values;
    }
    
    public User getUser(String id) {
    	User u=null; 
    	String[] param = {id};
        db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from User where id=?", param);
        Log.i("total"," is " + String.valueOf(c.getCount()));
        if (c.getCount() != 0) {
            c.moveToFirst();
            do {
                u = new User(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6));
            } while (c.moveToNext());
        }
        db.close();
        c.close();
        return u;
    }

    public void updateUser(String[] id,String name,String lastname, String username, String password, String cellphone, String email) throws SQLException {    	
    	 db = getReadableDatabase();
         ContentValues values = new ContentValues();
         values.put("name", name);
         values.put("lastname", lastname);
         values.put("username", username);
         values.put("password", password);
         values.put("cellphone", cellphone);
         values.put("email", email);
         db.update("User", values, "id=?", id);
         db.close();
    }

    public void deleteUser(String[] id) {
        db = getReadableDatabase();
        db.delete("User", "id=?", id);
        db.close();
    }

  
}
