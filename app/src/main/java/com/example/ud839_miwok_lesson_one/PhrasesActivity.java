package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class PhrasesActivity extends AppCompatActivity {

//    public class completionListener implements MediaPlayer.OnCompletionListener{
//
//
//        @Override
//        public void onCompletion(MediaPlayer mp) {
//            releaseMediaPlayer();
//        }
//    };
//

    // Create once and use every where instead of creating instance for each item
    MediaPlayer.OnCompletionListener mOnCompletionListener=new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
        releaseMediaPlayer();
    }
};
    MediaPlayer player=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        ArrayList<Word> words =new ArrayList<>();
        words.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
        words.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));

        WordAdapter adapter =new WordAdapter(this,R.layout.list_item,words,R.color.category_phrases);
        ListView listView =(ListView) findViewById(R.id.list);
        listView.setAdapter((adapter));

        //SetOnItemCLickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWord=(Word) parent.getAdapter().getItem(position);
                releaseMediaPlayer();
                player=MediaPlayer.create(view.getContext(),currentWord.getmAudioResourceId());
                player.start();
                player.setOnCompletionListener(mOnCompletionListener);
            }
        });
    }
    private void releaseMediaPlayer(){
        if(player!=null){
            player.release();
        }
        player=null;


    }
    //To stop the playback when the app is not visible
    @Override
    protected void onPause() {
        super.onPause();
        if(player!=null){
            player.stop();
        }
    }
    //To Release the resources when app stops
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}