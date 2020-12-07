package com.example.servicenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomePageAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page_admin);
    }

    public void UsersBtn(View view) {

        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), admin_manage_users.class);
        startActivityForResult (intent,0);
    }

    public void ServicesBtn(View view) {

        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), admin_manage_services.class);
        startActivityForResult (intent,0);
    }

    public void logOutBtn(View view) {

        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult (intent,0);
    }
}