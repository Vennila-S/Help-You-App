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

public class SignUpu extends AppCompatActivity {


    EditText signupUsername, signupPassword, signupEmail;
    TextView loginRedirectText;
    Button signupButton;
    DatabaseReference reference;

    DatabaseReference ref;

    Intent inte;

    FirebaseDatabase database;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upu);



        signupUsername=findViewById(R.id.signup_username);
        signupPassword=findViewById(R.id.signup_password);
        signupEmail=findViewById(R.id.signup_email);
        signupButton=findViewById(R.id.signup_button);
        loginRedirectText=findViewById(R.id.signup_redirecttext);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                database = FirebaseDatabase.getInstance();
//                reference = database.getReference("users");

                ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://nila-13ced-default-rtdb.firebaseio.com/");

                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String email = signupEmail.getText().toString();


                ref.child("nila_db");
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        ref.child("mobical_db").child(username).child("username").setValue(username);
                        ref.child("mobical_db").child(username).child("password").setValue(password);
                        ref.child("mobical_db").child(username).child("email").setValue(email);
                        Toast.makeText(SignUpu.this, "success", Toast.LENGTH_SHORT).show();

                        inte = new Intent(SignUpu.this, LoginUser.class);
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

                signupButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {




//
//
          Intent intent=new Intent(SignUpu.this, LoginUser.class);
        startActivity(intent);

           }
       });


                    }
                });}}



//package com.example.mobical;
//
//        import androidx.annotation.NonNull;
//        import androidx.appcompat.app.AppCompatActivity;
//        import android.content.Intent;
//        import android.os.Bundle;
//        import android.view.View;
//        import android.widget.Button;
//        import android.widget.EditText;
//        import android.widget.Toast;
//        import com.google.firebase.FirebaseApp;
//        import com.google.firebase.database.DataSnapshot;
//        import com.google.firebase.database.DatabaseError;
//        import com.google.firebase.database.DatabaseReference;
//        import com.google.firebase.database.FirebaseDatabase;
//        import com.google.firebase.database.ValueEventListener;
//
//public class main_page extends AppCompatActivity {
//
//    EditText e1,e2,e3,e4;
//
//    Button submit;
//
//    String s1,s2,s3,s4;
//
//    DatabaseReference ref;
//
//    Intent inte;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_page);
//
//        FirebaseApp.initializeApp(this);
//
//        ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://mobical-project-default-rtdb.firebaseio.com/");
//
//        e1 = findViewById(R.id.hos_id);
//        e2 = findViewById(R.id.patient_id);
//        e3 = findViewById(R.id.mn);
//        e4 = (EditText) findViewById(R.id.dte);
//        submit = findViewById(R.id.submit);
//
//
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                s1 = e1.getText().toString().trim();
//                s2 = e2.getText().toString().trim();
//                s3 = e3.getText().toString().trim();
//                s4 = e4.getText().toString().trim();
//
//                ref.child("mobical_db").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        ref.child("mobical_db").child(s1).child("Hospital_id").setValue(s1);
//                        ref.child("mobical_db").child(s1).child("Patient_id").setValue(s2);
//                        ref.child("mobical_db").child(s1).child("Mobile_number").setValue(s3);
//                        ref.child("mobical_db").child(s1).child("Date").setValue(s4);
//                        Toast.makeText(main_page.this,"success",Toast.LENGTH_SHORT).show();
//
//                        inte = new Intent(main_page.this,receive_page.class);
//                        startActivity(inte);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//
//
//
//
//
//            }
//        });
//
//
//
//    }
//} THIS IS MY CODE