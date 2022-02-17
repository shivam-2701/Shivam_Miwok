package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<Word> words =new ArrayList<>();
        words.add(new Word("one","lutti",getResources().getIdentifier("number_one", "drawable", getPackageName())));
        words.add(new Word("two","otiiko",getResources().getIdentifier("number_two", "drawable", getPackageName())));
        words.add(new Word("three","tolookosu",getResources().getIdentifier("number_three", "drawable", getPackageName())));
        words.add(new Word("four","oyyisa",getResources().getIdentifier("number_four", "drawable", getPackageName())));
        words.add(new Word("five","massokka",getResources().getIdentifier("number_five", "drawable", getPackageName())));
        words.add(new Word("six","temmokka",getResources().getIdentifier("number_six", "drawable", getPackageName())));
        words.add(new Word("seven","kenekaku",getResources().getIdentifier("number_seven", "drawable", getPackageName())));
        words.add(new Word("eight","kawinta",getResources().getIdentifier("number_eight", "drawable", getPackageName())));
        words.add(new Word("nine","wo'e",getResources().getIdentifier("number_nine", "drawable", getPackageName())));
        words.add(new Word("ten","na'aacha",getResources().getIdentifier("number_ten", "drawable", getPackageName())));
//        for(int i=0;i< words.size();i++){
//            Log.i("image id",i+" "+words.get(i).getmImageResourceId());
//        }
        WordAdapter adapter =new WordAdapter(this,R.layout.list_item,words);
        ListView listView =(ListView) findViewById(R.id.list);
        listView.setAdapter((adapter));

    }
}