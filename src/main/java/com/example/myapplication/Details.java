package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView name,occupation,email,mobile,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name=findViewById(R.id.user_name);
        occupation=findViewById(R.id.user_occupation);
        email=findViewById(R.id.user_email);
        mobile=findViewById(R.id.user_mobile);
        address=findViewById(R.id.user_address);

        String username=getIntent().getStringExtra("keyname");
        String useroccupation=getIntent().getStringExtra("keyoccupation");
        String useremail=getIntent().getStringExtra("keyemail");
        String usermobile=getIntent().getStringExtra("keymobile");
        String useraddress=getIntent().getStringExtra("keyaddress");

        name.setText(username);
        occupation.setText(useroccupation);
        email.setText(useremail);
        mobile.setText(usermobile);
        address.setText(useraddress);



    }
}