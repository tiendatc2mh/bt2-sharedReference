package com.example.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    EditText editTextAge;
    public static final String fileName = "configure";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave = findViewById(R.id.btnSave);
        editTextAge = findViewById(R.id.editTextAge);

        SharedPreferences sharedPreferences = getSharedPreferences(fileName, MODE_PRIVATE);
        int ageFromShared = sharedPreferences.getInt("age",0);
        View view = findViewById(R.id.mainLayput);
       if(ageFromShared<=10 && ageFromShared>=1){
            view.setBackgroundResource(R.drawable.imgthieunhi);
       }else if(ageFromShared<=17 && ageFromShared>=11){
           view.setBackgroundResource(R.drawable.imgteen);
       }else if(ageFromShared>=18){
           view.setBackgroundResource(R.drawable.imgadult);
       }


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = Integer.parseInt(editTextAge.getText().toString().trim());
                SharedPreferences.Editor editor = getSharedPreferences(fileName, MODE_PRIVATE).edit();

                editor.putInt("age", age);
                editor.commit();
            }
        });

    }
}