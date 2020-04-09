package com.example.mathtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {

    TextView TV_title;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TV_title=(TextView)findViewById(R.id.TV_result_title);

        Intent i=getIntent();
        int result = i.getExtras().getInt("score");

        TV_title.setText(TV_title.getText()+""+result);

    }
}
