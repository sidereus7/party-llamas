package com.sarajackson.apcs.partyllamas;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music = MediaPlayer.create(this, R.raw.main_loop);
        music.setLooping(true);
        music.start();
    }

    public void checkPartyStatus(View view) {
        Intent intent = new Intent(this, DisplayLlamaActivity.class);
        music.stop();
        startActivity(intent);
    }
}
