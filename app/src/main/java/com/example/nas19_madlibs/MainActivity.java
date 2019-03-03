package com.example.nas19_madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("MAD LIBS");
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    public void getStartedClicked(View view) {
        Intent intent = new Intent(MainActivity.this, StoryPickerActivity.class);
        startActivity(intent);
    }
}
