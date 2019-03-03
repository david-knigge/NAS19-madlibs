package com.example.nas19_madlibs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StoriesAdapter extends ArrayAdapter<Story> {

    private ArrayList<Story> stories;

    public StoriesAdapter(Context context, int resource, ArrayList<Story> objects) {
        super(context, resource, objects);
        stories = objects;
    }

    /** Update or create view from story adapter. */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.story_grid_item, parent, false);
        }

        Story story = stories.get(position);
        TextView title = convertView.findViewById(R.id.gridTitle);
        TextView numWords = convertView.findViewById(R.id.gridNumWords);

        title.setText(story.getTitle());
        numWords.setText(story.getPlaceholderCount() + " customizable words!");

        return convertView;
    }


}
