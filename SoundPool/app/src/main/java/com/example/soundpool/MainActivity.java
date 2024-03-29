package com.example.soundpool;

import android.app.Activity;

import android.content.Loader.OnLoadCompleteListener;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity implements OnTouchListener {
    private SoundPool soundPool;
    private int id;
    boolean flag = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.textView1);
        view.setOnTouchListener(this);
        // Set the hardware buttons to control the music
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new
                                                    SoundPool.OnLoadCompleteListener() {


                                                        @Override
                                                        public void onLoadComplete(SoundPool soundPool, int sampleId,
                                                                                   int status) {
                                                            flag = true;
                                                        }
                                                    });
        id = soundPool.load(this, R.raw.bonbon, 1);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
            float actualVolume = (float) audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC);
            float maxVolume = (float) audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
            float volume = actualVolume / maxVolume;
            if (flag) {
                soundPool.play(id, volume, volume, 1, 0, 1f);
            }
        }
        return false;
    }
}
