package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    MediaPlayer player=null;

    private AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener=new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange==AudioManager.AUDIOFOCUS_GAIN || focusChange==AudioManager.AUDIOFOCUS_GAIN_TRANSIENT){
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });
            }
            else if(focusChange==AudioManager.AUDIOFOCUS_LOSS){
                Log.e("Checking on focus","pause worked");

                player.stop();
                releaseMediaPlayer();
            }else if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                player.pause();
                player.seekTo(0);
            }else{
                player.stop();
                releaseMediaPlayer();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        ArrayList<Word> words =new ArrayList<>();
        int backgroundColor= R.color.category_family;
        words.add(new Word("father","әpә",getResources().getIdentifier("family_father", "drawable", getPackageName()),R.raw.family_father));
        words.add(new Word("mother","әṭa",getResources().getIdentifier("family_mother", "drawable", getPackageName()),R.raw.family_mother));
        words.add(new Word("son","angsi",getResources().getIdentifier("family_son", "drawable", getPackageName()),R.raw.family_son));
        words.add(new Word("daughter","tune",getResources().getIdentifier("family_daughter", "drawable", getPackageName()),R.raw.family_daughter));
        words.add(new Word("older brother","taachi",getResources().getIdentifier("family_older_brother", "drawable", getPackageName()),R.raw.family_older_brother));
        words.add(new Word("younger brother","chalitti",getResources().getIdentifier("family_younger_brother", "drawable", getPackageName()),R.raw.family_younger_brother));
        words.add(new Word("older sister","teṭe",getResources().getIdentifier("family_older_sister", "drawable", getPackageName()),R.raw.family_older_sister));
        words.add(new Word("younger sister","kolliti",getResources().getIdentifier("family_younger_sister", "drawable", getPackageName()),R.raw.family_younger_sister));
        words.add(new Word("grandmother","ama",getResources().getIdentifier("family_grandmother", "drawable", getPackageName()),R.raw.family_grandmother));
        words.add(new Word("grandfather","paapa",getResources().getIdentifier("family_grandfather", "drawable", getPackageName()),R.raw.family_grandfather));
        
        WordAdapter adapter =new WordAdapter(this,R.layout.list_item,words,backgroundColor);
        ListView listView =(ListView) findViewById(R.id.list);
        listView.setAdapter((adapter));

        //On Item Click listener for item click and preserve resources
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord=(Word) parent.getAdapter().getItem(position);
                releaseMediaPlayer();
                player=MediaPlayer.create(view.getContext(),currentWord.getmAudioResourceId());
                audioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
                int result =audioManager.requestAudioFocus(audioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result ==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    //Audio Focus Gained
                    player.start();
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                        }
                    });
                }

            }
        });

    }
    // Function to release the media resources
    private void releaseMediaPlayer(){
        if(player!=null){
            player.release();
            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
        player=null;



    }

    //To stop the playback when the app is not visible
    @Override
    protected void onPause() {
        super.onPause();
        if(player!=null){
            Log.e("Checking on pause","pause worked");
            player.stop();
        }
    }
    //To Release the resources when app stops
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Checking on pause","pause worked");
        releaseMediaPlayer();
    }
}