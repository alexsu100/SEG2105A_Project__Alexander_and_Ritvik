package com.example.servicenovigrad;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.servicenovigrad.data.Class.Address;
import com.example.servicenovigrad.data.Class.Branch;
import com.example.servicenovigrad.data.Class.NovService;
import com.example.servicenovigrad.data.Class.UserHelperClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class create_new_service extends AppCompatActivity {

    private EditText editTextServiceName;
    private Switch expirationSwitch, Branch1Switch, Branch2Switch;
    private Button btnCreateService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_service);

        btnCreateService = findViewById(R.id.btnCreateService);
        editTextServiceName = findViewById(R.id.editTextServiceName);
        expirationSwitch = findViewById(R.id.ExpirationSwitch);
        Branch1Switch = findViewById(R.id.switch2);
        Branch2Switch = findViewById(R.id.switch3);


        btnCreateService.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("services");


                if (editTextServiceName.getText().toString().isEmpty()) {
                    editTextServiceName.setError("Please Enter a Service Name");
                }
                else {
                    List<Branch> branchList = new ArrayList<Branch>();

                    if (Branch1Switch.isChecked() == true) {
                        branchList.add(new Branch(new Address("street", "123", "Ottawa", "255132")));
                    };
                    if (Branch2Switch.isChecked() == true) {
                        branchList.add(new Branch(new Address("street", "333", "Toronto", "123213")));
                    }

                    if (branchList.isEmpty() == true) {
                        Branch1Switch.setError("Please Select A Branch");
                        Branch2Switch.setError("Please Select A Branch");
                    } else {
                        String id = ref.push().getKey();

                        boolean expiration = (expirationSwitch.isChecked() == true);

                        final NovService service = new NovService(editTextServiceName.getText().toString(), branchList, expiration, id);

                        DatabaseReference serviceData = ref.child(id);

                        ValueEventListener eventListener = new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (!dataSnapshot.exists()) {
                                    ref.child(service.getId()).setValue(service);

                                    Toast.makeText(create_new_service.this, "Service successfully created",
                                            Toast.LENGTH_SHORT).show();
                                    finish();

                                } else {
                                    Toast.makeText(create_new_service.this, "Service is created already",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }

                        };

                        serviceData.addListenerForSingleValueEvent(eventListener);
                    }


                }



            };



    });
    }
}