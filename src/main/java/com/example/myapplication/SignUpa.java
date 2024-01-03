package com.example.myapplication;





import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpa extends AppCompatActivity {



    EditText signUsername, signPassword, signEmail;
    TextView logRedirectText;
    Button signButton;
    DatabaseReference reference;

    DatabaseReference ref;

    Intent inte;

    FirebaseDatabase database;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upa);



        signUsername=findViewById(R.id.sign_username);
        signPassword=findViewById(R.id.sign_password);
        signEmail=findViewById(R.id.sign_email);
        signButton=findViewById(R.id.sign_button);


        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                database = FirebaseDatabase.getInstance();
//                reference = database.getReference("users");

                ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://nila-13ced-default-rtdb.firebaseio.com/");

                String username = signUsername.getText().toString();
                String password = signPassword.getText().toString();
                String email = signEmail.getText().toString();


                ref.child("nila_db");
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        ref.child("mobical_db").child(username).child("username").setValue(username);
                        ref.child("mobical_db").child(username).child("password").setValue(password);
                        ref.child("mobical_db").child(username).child("email").setValue(email);
                        Toast.makeText(SignUpa.this, "success", Toast.LENGTH_SHORT).show();

                        inte = new Intent(SignUpa.this, ThirdPage.class);
                        startActivity(inte);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

//                HelperClass helperclass;
//                helperclass = new HelperClass(username, password,email);
//                reference.child(username).setValue(helperclass);
//
//                Toast.makeText(SignUpu.this,
//                        "You have signup successfully",
//                        Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(SignUpu.this, LoginUser.class);
//                startActivity(intent);
//            }
//        });

                signButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {




Intent intent=new Intent(SignUpa.this, ThirdPage.class);
               startActivity(intent);

                    }
                });


            }
        });}}