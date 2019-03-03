package com.example.nas19_madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StoryActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("clicked_story");

        setTitle("MAD LIBS");
        renderStory();
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    /** Shows created story. */
    public void renderStory() {
        TextView storyTitle = findViewById(R.id.storyViewTitle);
        TextView storyText = findViewById(R.id.storyViewText);

        storyTitle.setText("Your " + story.getTitle() + " story!");
        storyText.setText(Html.fromHtml(story.toString(), Html.FROM_HTML_MODE_LEGACY));
    }

    public void newStoryClicked(View view) {
        onBackPressed();
    }
}
