package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    /** Handles playback of all the sound files */
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("father","әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother","әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("son","angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("daughter","tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother","taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother","chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister","teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister","kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grandmother","ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather","paapa", R.drawable.family_grandfather, R.raw.family_grandfather));




        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mediaPlayer = MediaPlayer.create(FamilyActivity.this,word.getmAudioResourceId());

                //start the audio file
                mediaPlayer.start(); // no need to call prepare, create does that for you
            }
        });
    }
}
