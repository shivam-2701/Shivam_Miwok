package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        ArrayList<Word> words =new ArrayList<>();
        words.add(new Word("red","weṭeṭṭi",R.drawable.color_red));
        words.add(new Word("green","chokokki",getResources().getIdentifier("color_green", "drawable", getPackageName())));
        words.add(new Word("brown","ṭakaakki",getResources().getIdentifier("color_brown", "drawable", getPackageName())));
        words.add(new Word("gray","ṭopoppi",getResources().getIdentifier("color_gray", "drawable", getPackageName())));
        words.add(new Word("black","kululli",getResources().getIdentifier("color_black", "drawable", getPackageName())));
        words.add(new Word("white","kelelli",getResources().getIdentifier("color_white", "drawable", getPackageName())));
        words.add(new Word("dusty yellow","ṭopiisә",getResources().getIdentifier("color_dusty_yellow", "drawable", getPackageName())));
        words.add(new Word("mustard yellow","chiwiiṭә",getResources().getIdentifier("color_mustard_yellow", "drawable", getPackageName())));

        WordAdapter adapter =new WordAdapter(this,R.layout.list_item,words);
        ListView listView =(ListView) findViewById(R.id.list);
        listView.setAdapter((adapter));
    }
}