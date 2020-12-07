package com.example.servicenovigrad.data.Class;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.servicenovigrad.R;

import java.util.List;

public class UserList extends ArrayAdapter<UserHelperClass> {
private Activity context;
    List<UserHelperClass> users;

    public UserList(Activity context, List<UserHelperClass> users) {
        super(context, R.layout.activity_layout_users_list, users);
        this.context = context;
        this.users = users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_layout_users_list, null, true);

        TextView TextViewUserName = (TextView) listViewItem.findViewById(R.id.TextViewUserName);
        TextView TextViewUserEmail = (TextView) listViewItem.findViewById(R.id.TextViewUserEmail);
        TextView TextViewUserType = (TextView) listViewItem.findViewById(R.id.TextViewUserType);

        UserHelperClass currentUser = users.get(position);
        TextViewUserName.setText(String.valueOf(currentUser.getUsername()));
        TextViewUserEmail.setText(String.valueOf(currentUser.getEmail()));

        String usersType;

        if (currentUser.isEmployee()){
            usersType = "Employee";
        } else if (currentUser.isAdmin()) {
            usersType = "Admin";
        } else{
            usersType = "Customer";
        };

        TextViewUserType.setText(String.valueOf(usersType));

        return listViewItem;
    }

}
