package com.example.bilaizi.basicandroidaccessibility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;

public class ExpandTouchAreaActivity extends AppCompatActivity {
    private boolean mPlaying = false;
    private ImageButton mToggleImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_touch_area);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mToggleImageButton = (ImageButton) findViewById(R.id.play_pause_toggle_view);
        if (mToggleImageButton != null) {
            setUI();
            mToggleImageButton.setOnClickListener(
                    v -> {
                        mPlaying = !mPlaying;
                        setUI();
                    }
            );
        }
    }

    private void setUI() {
        if (mPlaying) {
            mToggleImageButton.setImageResource(R.drawable.ic_cancel);
            mToggleImageButton.setContentDescription("Cancel");
        } else {
            mToggleImageButton.setImageResource(R.drawable.ic_play_circle_outline);
            mToggleImageButton.setContentDescription("Refresh");
        }
    }
}