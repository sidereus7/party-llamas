package com.sarajackson.apcs.partyllamas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.*;

public class DisplayLlamaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_llama);

        setResponseAndLlama();
    }

    public void llamaAction(View view) {
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
        startActivity(intent);
    }

    private void setResponseAndLlama() {
        TextView partyResponse = (TextView) findViewById(R.id.party_response);
        ImageView llama = (ImageView) findViewById(R.id.imageButton);

        int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hours >= 2 && hours < 10) {
            partyResponse.setText(R.string.no_party_llama);
            llama.setBackgroundResource(R.drawable.sleepy_llama);
        } else if (hours >= 10 && hours < 18) {
            partyResponse.setText(R.string.no_party_llama);
            llama.setBackgroundResource(R.drawable.business_llama);
        } else {
            partyResponse.setText(R.string.yes_party_llama);
            llama.setBackgroundResource(R.drawable.party_llama);
        }
    }
}
