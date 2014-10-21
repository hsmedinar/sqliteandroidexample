package com.example.technoglobalexample.data;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.technoglobalexample.R;
import com.example.technoglobalexample.objects.User;



public class ListAdapter extends BaseAdapter {

    private Context context;
    public ArrayList<User> users;

    
    public ListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder holder;

        final User user = (User) users.get(position);    

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row_user, null);
            
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.user_row);          
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        holder.name.setText(user.getName() + " " + user.getLastName());
        
        return convertView;
    }


    static class ViewHolder {
    	TextView name;
    }

}
