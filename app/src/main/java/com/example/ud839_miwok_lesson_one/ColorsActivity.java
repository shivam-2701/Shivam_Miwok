package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer player = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki", getResources().getIdentifier("color_green", "drawable", getPackageName()), R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki", getResources().getIdentifier("color_brown", "drawable", getPackageName()), R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi", getResources().getIdentifier("color_gray", "drawable", getPackageName()), R.raw.color_gray));
        words.add(new Word("black", "kululli", getResources().getIdentifier("color_black", "drawable", getPackageName()), R.raw.color_black));
        words.add(new Word("white", "kelelli", getResources().getIdentifier("color_white", "drawable", getPackageName()), R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә", getResources().getIdentifier("color_dusty_yellow", "drawable", getPackageName()), R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә", getResources().getIdentifier("color_mustard_yellow", "drawable", getPackageName()), R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, R.layout.list_item, words, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter((adapter));
        // lambda expression in place of anonymous
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord = (Word) parent.getAdapter().getItem(position);
                releaseMediaPlayer();
                player = MediaPlayer.create(view.getContext(), currentWord.getmAudioResourceId());
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
    }
    //To stop the playback when the app is not visible
    @Override
    protected void onPause() {
        super.onPause();
        if(player!=null){
            player.stop();
        }
    }
    //To stop the playback when the app is not visible
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    //To Release the resources when app stops
    private void releaseMediaPlayer() {
        if (player != null) {
            player.release();
        }
        player = null;

    }
}