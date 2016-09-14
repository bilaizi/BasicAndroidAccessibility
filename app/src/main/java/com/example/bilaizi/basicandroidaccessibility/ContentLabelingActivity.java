package com.example.bilaizi.basicandroidaccessibility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;

/**
 *
 */
public class ContentLabelingActivity extends AppCompatActivity {

    private boolean mPlaying = false;
    private ImageButton mPlayPauseToggleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_labeling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPlayPauseToggleImageView = (ImageButton) findViewById(R.id.play_pause_toggle_view);
        if (mPlayPauseToggleImageView != null) {
            updateImageButton();
            mPlayPauseToggleImageView.setOnClickListener(
                    v -> {
                        mPlaying = !mPlaying;
                        updateImageButton();
                    }
            );
        }
    }

    private void updateImageButton() {
        if (mPlaying) {
            mPlayPauseToggleImageView.setImageResource(R.drawable.ic_play);
        } else {
            mPlayPauseToggleImageView.setImageResource(R.drawable.ic_pause);
        }
    }
}
