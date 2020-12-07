package com.example.servicenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


import com.example.servicenovigrad.data.Class.Customer;
import com.example.servicenovigrad.data.Class.Employee;
import com.example.servicenovigrad.data.Class.UserHelperClass;
import com.example.servicenovigrad.data.Class.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {

    private Button btnSignUp;
    private EditText editTextUserNameSign, editTextTextPasswordSign, editTextTextEmailSign;
    private Switch switchEmployee;
    private DatabaseReference databaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSignUp = findViewById(R.id.btnSignUp);
        editTextUserNameSign = findViewById(R.id.editTextUserNameSign);
        editTextTextPasswordSign = findViewById(R.id.editTextTextPasswordSign);
        editTextTextEmailSign = findViewById(R.id.editTextTextEmailAddressSign);

        switchEmployee = findViewById(R.id.switchEmployee);
        databaseUser = FirebaseDatabase.getInstance().getReference("users");

        btnSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if (editTextUserNameSign.getText().toString().isEmpty() ||
                        editTextUserNameSign.getText().toString().length()<6) {
                    editTextUserNameSign.setError("Please Enter Valid User Name Min 6 Character");
                }
                else if (editTextTextPasswordSign.getText().toString().isEmpty() ||
                        editTextTextPasswordSign.getText().toString().length()<6) {
                    editTextTextPasswordSign.setError("Please Enter Password Min 6 Character");
                }
                else if (editTextTextEmailSign.getText().toString().isEmpty() ||
                        !(editTextTextEmailSign.getText().toString().contains("@"))) {
                    editTextTextEmailSign.setError("Please Enter Email");
                }
                else {

                    if (switchEmployee.isChecked() == true){

                        try {
                            final Employee employee = new Employee(editTextUserNameSign.getText().toString(),
                                    editTextTextPasswordSign.getText().toString(),
                                    editTextTextEmailSign.getText().toString()
                            );

                            DatabaseReference userData = FirebaseDatabase.getInstance().getReference("users").child(employee.getUsername());


                            ValueEventListener eventListener = new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(!dataSnapshot.exists()) {
                                        String id = databaseUser.push().getKey();

                                        UserHelperClass employeeData = new UserHelperClass(false, employee.getEmail(),
                                                true, id, employee.getUsername(), employee.getPassword()
                                        );
                                        databaseUser.child(employee.getUsername()).setValue(employeeData);

                                        Toast.makeText(SignUp.this, "Account successfully created",
                                                Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(SignUp.this, "Account is created already",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }


                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                }
                            };

                            userData.addListenerForSingleValueEvent(eventListener);

                        } catch (Exception e) {
                            Toast.makeText(SignUp.this, "Error creating users",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {

                        try {
                            final Customer customer = new Customer(editTextUserNameSign.getText().toString(),
                                    editTextTextPasswordSign.getText().toString(),
                                    editTextTextEmailSign.getText().toString()
                            );

                            DatabaseReference userData = FirebaseDatabase.getInstance().getReference("users").child(customer.getUsername());


                            ValueEventListener eventListener = new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if(!dataSnapshot.exists()) {
                                        String id = databaseUser.push().getKey();

                                        UserHelperClass customerData = new UserHelperClass(false,customer.getEmail(),
                                                false, id, customer.getUsername(), customer.getPassword());
                                        databaseUser.child(customer.getUsername()).setValue(customerData);

                                        Toast.makeText(SignUp.this, "Account successfully created",
                                                Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(SignUp.this, "Account is created already",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                }
                            };

                            userData.addListenerForSingleValueEvent(eventListener);

                        } catch (Exception e) {
                            Toast.makeText(SignUp.this, "Error creating users",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }


                }

            }
        });
    }
}