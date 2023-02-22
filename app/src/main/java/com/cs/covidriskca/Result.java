package com.cs.covidriskca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        v = findViewById(R.id.textView7);
        Intent intent = getIntent();
        String showdata = intent.getStringExtra("showdata").toString();

        v.setText(showdata);
    }
}