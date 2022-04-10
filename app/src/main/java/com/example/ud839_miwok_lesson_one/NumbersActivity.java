package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.media.AudioManager;
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

    MediaPlayer mplayer=null;
    private AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener=new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange==AudioManager.AUDIOFOCUS_GAIN || focusChange==AudioManager.AUDIOFOCUS_GAIN_TRANSIENT){
                mplayer.start();
                mplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });
            }
            else if(focusChange==AudioManager.AUDIOFOCUS_LOSS){
                mplayer.stop();
                releaseMediaPlayer();
            }else if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mplayer.pause();
                mplayer.seekTo(0);
            }else{
                mplayer.stop();
                releaseMediaPlayer();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        // my_child_toolbar is defined in the layout file
        



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
                releaseMediaPlayer();
                Word currentWord=(Word) parent.getAdapter().getItem(position);
                releaseMediaPlayer();
                mplayer=MediaPlayer.create(view.getContext(),currentWord.getmAudioResourceId());
                audioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
                int result =audioManager.requestAudioFocus(audioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result ==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    //Audio Focus Gained
                    mplayer.start();
                    mplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });

    }
    private void releaseMediaPlayer(){
        if(mplayer!=null){
            mplayer.release();
            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
        mplayer=null;


    }
    //To stop the playback when the app is not visible
    @Override
    protected void onPause() {
        super.onPause();
        if(mplayer!=null){
            mplayer.stop();
        }
    }
    //To Release the resources when app stops
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}