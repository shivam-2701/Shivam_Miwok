package com.example.ud839_miwok_lesson_one;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class WordAdapter extends ArrayAdapter<Word> {

    ArrayList<Word> wordList=new ArrayList<>();
//    Media player class to play sound;
    MediaPlayer player=null;
    private int background= android.R.color.white;
    public WordAdapter(@NonNull Context context,  int textViewResourceId, @NonNull ArrayList<Word> objects,int background_color) {
        super(context, textViewResourceId, objects);
        wordList=objects;
        background=background_color;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem=convertView;
        // Check if the existing view is being reused, otherwise inflate the view
        if(listViewItem==null){
            listViewItem= LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord=wordList.get(position);
        LinearLayout wordGroup =(LinearLayout)listViewItem.findViewById(R.id.word_group);
        wordGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                    player= MediaPlayer.create(v.getContext(),currentWord.getmAudioResourceId());

                player.start();
            }
        });
        if(player!=null){
        player.release();
        player=null;
        }

        wordGroup.setBackgroundColor(listViewItem.getResources().getColor(background));
        TextView defaultText=(TextView)listViewItem.findViewById(R.id.text1);
        defaultText.setText(currentWord.getDefaultTranslation());
        TextView miwokTextView =(TextView) listViewItem.findViewById(R.id.text2);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        ImageView iconImage=(ImageView)listViewItem.findViewById(R.id.icon_image);
        if(currentWord.hasImage()){
            iconImage.setImageResource(currentWord.getmImageResourceId());
        }else{
            iconImage.setVisibility(View.GONE);
        }

        return listViewItem;

    }
}
