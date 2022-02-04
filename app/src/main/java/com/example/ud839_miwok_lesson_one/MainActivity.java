package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView numberActivity=(TextView) findViewById(R.id.numbers);
        numberActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),NumbersActivity.class);
                startActivity(intent);
            }
        });
        TextView familyActivity =(TextView) findViewById(R.id.family);
        TextView colorsActivity =(TextView) findViewById(R.id.colors);
        TextView phrasesActivity=(TextView) findViewById(R.id.phrases);
        familyActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),FamilyActivity.class);
                startActivity(intent);
            }
        });
        colorsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ColorsActivity.class);
                startActivity(intent);
            }
        });
        phrasesActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),PhrasesActivity.class);
                startActivity(intent);
            }
        });
    }
//    public void openNumbersView(View view){
//        Intent intent = new Intent(this,NumbersActivity.class);
//        startActivity(intent);
//
//    }
}