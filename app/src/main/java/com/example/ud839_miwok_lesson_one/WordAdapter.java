package com.example.ud839_miwok_lesson_one;

import android.content.Context;
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
    public WordAdapter(@NonNull Context context,  int textViewResourceId, @NonNull ArrayList<Word> objects) {
        super(context, textViewResourceId, objects);
        wordList=objects;
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

        TextView defaultText=(TextView)listViewItem.findViewById(R.id.text1);
        defaultText.setText(currentWord.getDefaultTranslation());
        TextView miwokTextView =(TextView) listViewItem.findViewById(R.id.text2);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        if(currentWord.getmImageResourceId()!=-1){
            ImageView iconImage=(ImageView)listViewItem.findViewById(R.id.icon_image);
            iconImage.setImageResource(currentWord.getmImageResourceId());
        }

        return listViewItem;

    }
}
