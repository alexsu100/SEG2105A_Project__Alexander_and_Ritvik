package com.example.servicenovigrad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.servicenovigrad.data.Class.UserHelperClass;
import com.example.servicenovigrad.data.Class.UserList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class admin_manage_users extends AppCompatActivity {

    ListView listViewUsers;

    List<UserHelperClass> usersList;
    DatabaseReference databaseUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage_users);

        listViewUsers = (ListView) findViewById(R.id.listViewUsers);

        usersList = new ArrayList<>();

        databaseUsers = FirebaseDatabase.getInstance().getReference("users");

        listViewUsers.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                UserHelperClass users = usersList.get(i);
                showDeleteDialog(users.getUsername());
                return true;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseUsers.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                usersList.clear();

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    UserHelperClass users = postSnapshot.getValue(UserHelperClass.class);
                    usersList.add(users);
                }

                UserList usersAdaptor = new UserList(admin_manage_users.this, usersList);
                listViewUsers.setAdapter(usersAdaptor);

            }
            @Override
            public void onCancelled(DatabaseError databaseError){

            }
        });
    }

    private void showDeleteDialog(final String UserName) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.users_update_dialog, null);
        dialogBuilder.setView(dialogView);

        final Button buttonDelete = (Button) dialogView.findViewById(R.id.btnDeleteUsers);

        dialogBuilder.setTitle(UserName);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUsers(UserName);
                b.dismiss();
            }
        });
    }

    private boolean deleteUsers(String UserName) {

        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("users").child(UserName);

        dR.removeValue();
        Toast.makeText(getApplicationContext(), "User Deleted", Toast.LENGTH_LONG).show();
        return true;
    }

    public void backAdminBtn(View view) {

        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), WelcomePageAdmin.class);
        startActivityForResult (intent,0);
    }
}