package com.sarajackson.apcs.partyllamas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class DisplayLlamaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_llama);
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
}
