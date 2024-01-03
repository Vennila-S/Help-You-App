package com.example.myapplication;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class CreatePage extends AppCompatActivity {

private TextView name,occupation,email,mobile,address;
private Button add;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_page);

        name=findViewById(R.id.name);
        occupation=findViewById(R.id.occupation);
        email=findViewById(R.id.email);
        mobile=findViewById(R.id.mobile);
        address=findViewById(R.id.address);
        add=findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String username=name.getText().toString();
                String useroccupation=occupation.getText().toString();
                String useremail=email.getText().toString();
                String usermobile=mobile.getText().toString();
                String useraddress=address.getText().toString();

                Intent intent = new Intent(CreatePage.this, Details.class);
                intent.putExtra("keyname",username);
                intent.putExtra("keyoccupation",useroccupation);
                intent.putExtra("keyemail",useremail);
                intent.putExtra("keymobile",usermobile);
                intent.putExtra("keyaddress",useraddress);
                startActivity(intent);


            }
        });

        }

}

