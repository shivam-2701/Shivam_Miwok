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
        words.add(new Word("red","weṭeṭṭi"));
        words.add(new Word("green","chokokki"));
        words.add(new Word("brown","ṭakaakki"));
        words.add(new Word("gray","ṭopoppi"));
        words.add(new Word("black","kululli"));
        words.add(new Word("white","kelelli"));
        words.add(new Word("dusty yellow","ṭopiisә"));
        words.add(new Word("mustard yellow","chiwiiṭә"));

        WordAdapter adapter =new WordAdapter(this,R.layout.list_item,words);
        ListView listView =(ListView) findViewById(R.id.list);
        listView.setAdapter((adapter));
    }
}