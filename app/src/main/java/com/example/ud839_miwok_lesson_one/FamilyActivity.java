package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        ArrayList<Word> words =new ArrayList<>();
        words.add(new Word("father","әpә",getResources().getIdentifier("family_father", "drawable", getPackageName())));
        words.add(new Word("mother","әṭa",getResources().getIdentifier("family_mother", "drawable", getPackageName())));
        words.add(new Word("son","angsi",getResources().getIdentifier("family_son", "drawable", getPackageName())));
        words.add(new Word("daughter","tune",getResources().getIdentifier("family_daughter", "drawable", getPackageName())));
        words.add(new Word("older brother","taachi",getResources().getIdentifier("family_older_brother", "drawable", getPackageName())));
        words.add(new Word("younger brother","chalitti",getResources().getIdentifier("family_younger_brother", "drawable", getPackageName())));
        words.add(new Word("older sister","teṭe",getResources().getIdentifier("family_older_sister", "drawable", getPackageName())));
        words.add(new Word("younger sister","kolliti",getResources().getIdentifier("family_younger_sister", "drawable", getPackageName())));
        words.add(new Word("grandmother","ama",getResources().getIdentifier("family_grandmother", "drawable", getPackageName())));
        words.add(new Word("grandfather","paapa",getResources().getIdentifier("family_grandfather", "drawable", getPackageName())));
        
        WordAdapter adapter =new WordAdapter(this,R.layout.list_item,words);
        ListView listView =(ListView) findViewById(R.id.list);
        listView.setAdapter((adapter));

    }
}