package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;




import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class IconPage extends AppCompatActivity {

 //   public TextView m1 ,m2 ,m3 ,m4;


public Button bu,bu1,bu2,bu3;
@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_icon_page);
    bu = findViewById(R.id.button3);


    bu.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(IconPage.this, Details.class);
            startActivity(intent);


        }
    });

    bu1 = findViewById(R.id.c_button);


    bu1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(IconPage.this, Details.class);
            startActivity(intent);


        }
    });
    bu2 = findViewById(R.id.p_button);


    bu2.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(IconPage.this, Details.class);
            startActivity(intent);


        }
    });
    bu3 = findViewById(R.id.t_button);


    bu3.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(IconPage.this, Details.class);
            startActivity(intent);


        }
    });
}}