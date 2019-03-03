package com.example.nas19_madlibs;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StoryPickerActivity extends AppCompatActivity {

    ArrayList<Story> stories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_picker);

        setTitle("MAD LIBS");
        setStories();
        setAdapter();
    }

    public void setStories() {
        stories = new ArrayList<>();
        stories.add(new Story(this.getResources().openRawResource(R.raw.madlib0_simple), "Simple"));
        stories.add(new Story(this.getResources().openRawResource(R.raw.madlib1_tarzan), "Tarzan"));
        stories.add(new Story(this.getResources().openRawResource(R.raw.madlib2_university), "University"));
        stories.add(new Story(this.getResources().openRawResource(R.raw.madlib3_clothes), "Clothes"));
        stories.add(new Story(this.getResources().openRawResource(R.raw.madlib4_dance), "Dance"));
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Story clickedStory = (Story) parent.getItemAtPosition(position);
            Intent intent = new Intent(StoryPickerActivity.this, StoryWriterActivity.class);
            intent.putExtra("clicked_story", clickedStory);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    public void setAdapter() {
        StoriesAdapter adapter = new StoriesAdapter(this, R.layout.story_grid_item, stories);
        GridView view = findViewById(R.id.storyPickerGrid);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new GridItemClickListener());
    }
}
