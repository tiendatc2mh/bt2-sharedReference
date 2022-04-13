package com.example.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    String editTextAge;
    public static final String fileName = "configure";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave = findViewById(R.id.btnSave);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        String text = mySpinner.getSelectedItem().toString();
        editTextAge = text;

        SharedPreferences sharedPreferences = getSharedPreferences(fileName, MODE_PRIVATE);
        String language = sharedPreferences.getString("language","none");
        ImageView view = findViewById(R.id.imageView);
        TextView ngonngu = (TextView) findViewById(R.id.textView3);
       if(language.equals("Japan")) {
           mySpinner.setSelection(0);
           view.setImageResource(R.drawable.imgnhat);
           ngonngu.setText("こんにちは");
       }
       if(language.equals("China")){
           mySpinner.setSelection(1);
           view.setImageResource(R.drawable.imgtrungquosc);
           ngonngu.setText("你好");
       }
       if(language.equals("England")){
           mySpinner.setSelection(2);
           view.setImageResource(R.drawable.imganh);
           ngonngu.setText("Hello");
       }
       if(language.equals("France")){
           mySpinner.setSelection(3);
           view.setImageResource(R.drawable.imgphap);
           ngonngu.setText("Bonjour");
       }


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ngonngu = mySpinner.getSelectedItem().toString().trim();
                SharedPreferences.Editor editor = getSharedPreferences(fileName, MODE_PRIVATE).edit();

                editor.putString("language", ngonngu);
                editor.commit();
            }
        });

    }
}