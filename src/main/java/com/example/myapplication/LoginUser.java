package com.example.myapplication;



import static java.lang.Integer.valueOf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginUser extends AppCompatActivity {
    private TextView move;
    EditText uUsername, uPassword, uEmail;

    TextView logRedirectText;
    Button uButton;
    DatabaseReference reference;

    DatabaseReference ref;

    Intent inte;

    FirebaseDatabase database;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        move = findViewById(R.id.signup_redirecttext);
        move.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginUser.this, SignUpu.class);
                startActivity(intent);


            }
        });

        ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://nila-13ced-default-rtdb.firebaseio.com/");


        uUsername=findViewById(R.id.u_username);
        uPassword=findViewById(R.id.u_password);
        uEmail=findViewById(R.id.u_email);
        uButton=findViewById(R.id.u_button);


        uButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                database = FirebaseDatabase.getInstance();
//                reference = database.getReference("users");

                ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://nila-13ced-default-rtdb.firebaseio.com/");

                String username = uUsername.getText().toString();
                String password = uPassword.getText().toString();
                String email = uEmail.getText().toString();


                ref.child("nila_db");
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        ref.child("nila_db").child(username).child("username").setValue(username);
                        ref.child("nila_db").child(username).child("password").setValue(password);
                        ref.child("nila_db").child(username).child("email").setValue(email);
                        Toast.makeText(LoginUser.this, "success", Toast.LENGTH_SHORT).show();
                        inte = new Intent(LoginUser.this,IconPage.class);
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