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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ThirdPage extends AppCompatActivity {

        private TextView move;


        EditText aUsername, aPassword, aEmail;
        TextView logRedirectText;
        Button aButton;
        DatabaseReference reference;

        DatabaseReference ref;

        Intent inte;

        FirebaseDatabase database;

        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_third_page);

            move = findViewById(R.id.textView3);
            move.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ThirdPage.this, SignUpa.class);
                    startActivity(intent);


                }
            });

            ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://nila-13ced-default-rtdb.firebaseio.com/");


            aUsername=findViewById(R.id.a_username);
            aPassword=findViewById(R.id.a_password);
            aEmail=findViewById(R.id.a_email);
            aButton=findViewById(R.id.a_button);


            aButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                database = FirebaseDatabase.getInstance();
//                reference = database.getReference("users");

                    ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://nila-13ced-default-rtdb.firebaseio.com/");

                    String username = aUsername.getText().toString();
                    String password = aPassword.getText().toString();
                    String email = aEmail.getText().toString();


                    ref.child("nila_db");
                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            ref.child("nila_db").child(username).child("username").setValue(username);
                            ref.child("nila_db").child(username).child("password").setValue(password);
                            ref.child("nila_db").child(username).child("email").setValue(email);
                            Toast.makeText(ThirdPage.this, "success", Toast.LENGTH_SHORT).show();
                            inte = new Intent(ThirdPage.this, AdminIcon.class);
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

                    //aButton.setOnClickListener(new View.OnClickListener() {
                       // @Override
                        //public void onClick(View view) {




                          //  Intent intent=new Intent(ThirdPage.this, IconPage.class);
                           // startActivity(intent);
                }
         });

              }
            }