package com.londonappbrewery.destini;

import android.media.session.MediaSession;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    public TextView mStoryTextView;
    public Button mButtonTop;
    public Button mButtonBottom;
    public int mPathIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mPathIndex = 1;

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateButtons(1);
                UpdateTextView(1);
                mPathIndex = UpdatePath(1);

            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateButtons(2);
                UpdateTextView(2);
                mPathIndex = UpdatePath(2);
            }
        });


    }

    public void UpdateButtons(int buttonNumber) {
        if (buttonNumber == 1) {
            if (mPathIndex == 1 || mPathIndex == 2) {
                mButtonTop.setText(R.string.T3_Ans1);
                mButtonBottom.setText(R.string.T3_Ans2);
            }
        }
        else {
            if (mPathIndex == 1) {
                mButtonTop.setText(R.string.T2_Ans1);
                mButtonBottom.setText(R.string.T2_Ans2);
            }
        }
    }

    public void UpdateTextView(int buttonNumber){
        if (buttonNumber == 1) {
            if (mPathIndex == 1 || mPathIndex == 2) {
                mStoryTextView.setText(R.string.T3_Story);
            }
            if (mPathIndex == 3){
                mStoryTextView.setText(R.string.T6_End);
                mButtonBottom.setVisibility(View.INVISIBLE);
                mButtonTop.setVisibility(View.INVISIBLE);
            }
        } else {
            if (mPathIndex == 1) {
                mStoryTextView.setText(R.string.T2_Story);
            }
            if (mPathIndex == 2){
                mStoryTextView.setText(R.string.T4_End);
                mButtonBottom.setVisibility(View.INVISIBLE);
                mButtonTop.setVisibility(View.INVISIBLE);
            }
            if (mPathIndex == 3){
                mStoryTextView.setText(R.string.T5_End);
                mButtonBottom.setVisibility(View.INVISIBLE);
                mButtonTop.setVisibility(View.INVISIBLE);
            }
        }
    }

    public int UpdatePath (int buttonNumber){
        int tempPath = 1;

        if (buttonNumber == 1){
            if (mPathIndex == 1 || mPathIndex == 2){
                tempPath = 3;
            }
            if (mPathIndex == 3){
                tempPath = 6;
            }
        }
        else {
            if (mPathIndex == 1){
                tempPath = 2;
            }
            if (mPathIndex == 2){
                tempPath = 4;
            }
            if (mPathIndex == 3){
                tempPath = 5;
            }
        }
        return tempPath;
     }
}
