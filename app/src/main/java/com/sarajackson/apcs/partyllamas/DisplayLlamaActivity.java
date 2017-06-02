package com.sarajackson.apcs.partyllamas;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.*;

public class DisplayLlamaActivity extends AppCompatActivity {
    public static final String SLEEPY_LLAMA = "sleepy";
    public static final String BUSINESS_LLAMA = "business";
    public static final String PARTY_LLAMA = "party";

    private String llama;
    private MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_llama);

        llama = getCurrentLlama();
        setResponseAndLlama();
        beginMusic();
        llamaAction(findViewById(R.id.imageButton));
    }

    public void llamaAction(View view) {
        if (llama.equals(SLEEPY_LLAMA)) {
            animateSleepyLlama(view);
        } else if (llama.equals(BUSINESS_LLAMA)) {
            animateBusinessLlama(view);
        } else { // PARTY_LLAMA
            animatePartyLlama(view);
        }
    }

    private void animateSleepyLlama(View view) {
        YoYo.with(Techniques.Swing)
                .duration(500)
                .repeat(3)
                .playOn(view);
    }

    private void animateBusinessLlama(View view) {
        YoYo.with(Techniques.ZoomIn)
                .duration(2000)
                .repeat(1)
                .playOn(view);
    }

    private void animatePartyLlama(View view) {
        YoYo.with(Techniques.Bounce)
                .duration(500)
                .repeat(3)
                .playOn(view);

        YoYo.with(Techniques.Swing)
                .duration(500)
                .repeat(3)
                .playOn(view);

        YoYo.with(Techniques.Shake)
                .duration(500)
                .repeat(3)
                .playOn(view);
    }

    public void returnToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        music.stop();
        startActivity(intent);
    }

    private String getCurrentLlama() {
        int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hours >= 2 && hours < 10) {
            return SLEEPY_LLAMA;
        } else if (hours >= 10 && hours < 18) {
            return BUSINESS_LLAMA;
        } else {
            return PARTY_LLAMA;
        }
    }

    private void setResponseAndLlama() {
        TextView partyResponse = (TextView) findViewById(R.id.party_response);
        ImageView llamaImage = (ImageView) findViewById(R.id.imageButton);
        if (llama.equals(SLEEPY_LLAMA)) {
            partyResponse.setText(R.string.no_party_llama);
            llamaImage.setBackgroundResource(R.drawable.sleepy_llama);
        } else if (llama.equals(BUSINESS_LLAMA)) {
            partyResponse.setText(R.string.no_party_llama);
            llamaImage.setBackgroundResource(R.drawable.business_llama);
        } else { // PARTY_LLAMA
            partyResponse.setText(R.string.yes_party_llama);
            llamaImage.setBackgroundResource(R.drawable.party_llama);
        }
    }

    private void beginMusic() {
        if (llama.equals(SLEEPY_LLAMA)) {
            music = MediaPlayer.create(this, R.raw.sleepy_loop);
        } else if (llama.equals(BUSINESS_LLAMA)) {
            music = MediaPlayer.create(this, R.raw.business_loop);
        } else { // PARTY_LLAMA
            music = MediaPlayer.create(this, R.raw.party_loop);
        }

        music.setLooping(true);
        music.start();
    }
}
