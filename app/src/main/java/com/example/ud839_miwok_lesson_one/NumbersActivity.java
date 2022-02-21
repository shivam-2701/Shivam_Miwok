package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer player=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        final ArrayList<Word> words =new ArrayList<>();
        words.add(new Word("one","lutti",getResources().getIdentifier("number_one", "drawable", getPackageName()),R.raw.number_one));
        words.add(new Word("two","otiiko",getResources().getIdentifier("number_two", "drawable", getPackageName()),R.raw.number_two));
        words.add(new Word("three","tolookosu",getResources().getIdentifier("number_three", "drawable", getPackageName()),R.raw.number_three));
        words.add(new Word("four","oyyisa",getResources().getIdentifier("number_four", "drawable", getPackageName()),R.raw.number_four));
        words.add(new Word("five","massokka",getResources().getIdentifier("number_five", "drawable", getPackageName()),R.raw.number_five));
        words.add(new Word("six","temmokka",getResources().getIdentifier("number_six", "drawable", getPackageName()),R.raw.number_six));
        words.add(new Word("seven","kenekaku",getResources().getIdentifier("number_seven", "drawable", getPackageName()),R.raw.number_seven));
        words.add(new Word("eight","kawinta",getResources().getIdentifier("number_eight", "drawable", getPackageName()),R.raw.number_eight));
        words.add(new Word("nine","wo'e",getResources().getIdentifier("number_nine", "drawable", getPackageName()),R.raw.number_nine));
        words.add(new Word("ten","na'aacha",getResources().getIdentifier("number_ten", "drawable", getPackageName()),R.raw.number_ten));

        WordAdapter adapter =new WordAdapter(this,R.layout.list_item,words,R.color.category_numbers);
        ListView listView =(ListView) findViewById(R.id.list);
        listView.setAdapter((adapter));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord=(Word) parent.getAdapter().getItem(position);
                player=MediaPlayer.create(view.getContext(),currentWord.getmAudioResourceId());
                player.start();
            }
        });

    }
}