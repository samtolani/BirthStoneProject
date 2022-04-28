package com.example.birthstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText user_name,user_birthday_date;
    Database database;
    final Calendar myCalendar= Calendar.getInstance();
    DatePickerDialog datePicker;

    int selectedMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_birthday_date=findViewById(R.id.user_birthday_date);
        user_name=findViewById(R.id.user_name);
        database=new Database(this);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                selectedMonth  = month;
                user_birthday_date.setText(month+1+"/"+day+"/"+year);
            }
        };
        user_birthday_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker =  new DatePickerDialog(MainActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                datePicker.getDatePicker().setMaxDate(System.currentTimeMillis()- 1000);
                datePicker.show();
            }
        });
    }

    public void checkBirthStone(View view) {

        if(user_name.getText().toString().trim().isEmpty()){
            user_name.setError("required");
        }
        else if(user_birthday_date.getText().toString().trim().isEmpty()){
            user_birthday_date.setError("required");
        }
        else {
            database.addData(new Birthday1(user_name.getText().toString().trim(),user_birthday_date.getText().toString().trim()));
            startActivity(new Intent(MainActivity.this, BirthstoneInfo.class)
                    .putExtra("selectedMonth",selectedMonth));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                startActivity(new Intent(MainActivity.this, Profile.class));
                return true;
            case R.id.item2:
                startActivity(new Intent(MainActivity.this, ContactUs.class));

                return true;
            case R.id.item3:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}