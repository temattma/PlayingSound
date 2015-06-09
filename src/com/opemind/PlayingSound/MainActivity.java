package com.opemind.PlayingSound;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends Activity implements View.OnClickListener {

    private SoundPool soundPool;
    int sample1 = -1;
    int sample2 = -1;
    int sample3 = -1;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);

        try {
            // Create objects of 2 required classes
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;

            // Create out three fx in memory ready to use
            descriptor = assetManager.openFd("sample1.ogg");
            sample1 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("sample2.ogg");
            sample2 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("sample3.ogg");
            sample3 = soundPool.load(descriptor, 0);



        } catch (IOException e) {
            e.printStackTrace();
        }

        // Make a button from each of the buttons in our layout
        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        //Make each of them listen for clicks
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button : // When the first button is pressed
                //Play sample1
                soundPool.play(sample1, 1, 1, 0, 0, 1);
                break;
            // Now the other buttons
            case R.id.button2 :
                //Play sample2
                soundPool.play(sample2, 1, 1, 0, 0, 1);
                break;
            case R.id.button3 :
                //Play sample3
                soundPool.play(sample3, 1, 1, 0, 0, 1);
                break;
        }

    }
}
