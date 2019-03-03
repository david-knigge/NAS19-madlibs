package com.example.nas19_madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StoryWriterActivity extends AppCompatActivity {

    Story story;

    /** Retrieve selected story, or restore from bundle. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_writer);

        if (savedInstanceState != null) {
            story = (Story) savedInstanceState.getSerializable("story");
        } else {
            Intent intent = getIntent();
            story = (Story) intent.getSerializableExtra("clicked_story");
        }

        setTitle("MAD LIBS");
        renderStoryInfo();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("story", story);
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    /** Update GUI elements to reflect updates in Story object. */
    public void renderStoryInfo() {
        TextView wordsLeft = findViewById(R.id.wordsLeft);
        TextView wordType = findViewById(R.id.wordType);
        TextView textInput = findViewById(R.id.textInput);

        int remaining = story.getPlaceholderRemainingCount();
        wordsLeft.setText(remaining + " word(s) left");

        String placeholder = story.getNextPlaceholder();
        wordType.setText("please type a/an " + placeholder);
        textInput.setText("");
        textInput.setHint(placeholder);
    }

    /** Validates user input, adds input to Story object. */
    public void okClicked(View view) {
        String input = ((EditText) findViewById(R.id.textInput)).getText().toString();

        if (!input.equals("")) {
            story.fillInPlaceholder(input);

            if (story.getPlaceholderRemainingCount() < 1) {
                Intent intent = new Intent(StoryWriterActivity.this, StoryActivity.class);
                intent.putExtra("clicked_story", story);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Good job. Keep going!", Toast.LENGTH_SHORT).show();
                renderStoryInfo();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Please enter something!", Toast.LENGTH_SHORT).show();
            renderStoryInfo();
        }

    }
}
