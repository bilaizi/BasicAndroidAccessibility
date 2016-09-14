package com.example.bilaizi.basicandroidaccessibility;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InsufficientContrastActivity extends AppCompatActivity {

    private RelativeLayout mLoremIpsumContainer;
    private TextView mLoremIpsumTitle;
    private TextView mLoremIpsumText;
    private FloatingActionButton mAddItemFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insufficient_contrast);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mLoremIpsumContainer = (RelativeLayout) findViewById(R.id.lorem_ipsum_container);
        mLoremIpsumTitle = (TextView) findViewById(R.id.lorem_ipsum_title);
        mLoremIpsumText = (TextView) findViewById(R.id.lorem_ipsum_text);
        mAddItemFab = (FloatingActionButton) findViewById(R.id.add_item_fab);

        CheckBox colorContrastCheckbox = (CheckBox) findViewById(R.id.color_contrast_checkbox);
        if (colorContrastCheckbox != null)
            colorContrastCheckbox.setOnCheckedChangeListener(
                    (buttonView, isChecked) -> {
                        if (isChecked) {
                            useHighContrast();
                        } else {
                            useLowContrast();
                        }
                    });
    }

    private void useHighContrast() {
        mLoremIpsumContainer.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        mLoremIpsumTitle.setTextColor(ContextCompat.getColor(this, R.color.medium_grey));
        mLoremIpsumText.setTextColor(ContextCompat.getColor(this, R.color.dark_grey));
        mAddItemFab.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimaryDark));
    }

    private void useLowContrast() {
        mLoremIpsumContainer.setBackgroundColor(ContextCompat.getColor(this, R.color.very_light_grey));
        mLoremIpsumTitle.setTextColor(ContextCompat.getColor(this, R.color.light_grey));
        mLoremIpsumText.setTextColor(ContextCompat.getColor(this, R.color.medium_grey));
        mAddItemFab.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimaryLight));
    }
}
