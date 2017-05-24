package com.sarajackson.apcs.partyllamas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Pick the appropriate llama to show based on time

        // TODO: Animate once at the start
    }

    public void checkPartyStatus(View view) {
        Intent intent = new Intent(this, DisplayLlamaActivity.class);
        startActivity(intent);
    }
}
