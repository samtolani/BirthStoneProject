package com.example.birthstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView user_name,user_birthday_date;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        user_birthday_date=findViewById(R.id.user_birthday_date);
        user_name=findViewById(R.id.user_name);
        database=new Database(this);
    }

    @Override
    protected void onStart() {
        Birthday1 birthday =database.getUserData();
        user_name.setText("Name : "+birthday.getName());
        user_birthday_date.setText("Birthday : "+birthday.getDate());
        super.onStart();
    }
}