package com.example.mathtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView TV_MainText1;
    ImageButton btn_share1,btn_play1,btn_rate1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TV_MainText1=(TextView)findViewById(R.id.TV_title2);
        btn_share1=(ImageButton)findViewById(R.id.btn_share2);
        btn_play1=(ImageButton)findViewById(R.id.btn_play2);
        btn_rate1=(ImageButton)findViewById(R.id.btn_star2);






        btn_share1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"Just Maths - Fun way to learn Maths. http://www.play.google.com");
                startActivity(intent);


            }
        });


        btn_play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),gameplay.class);

                startActivity(intent);

            }
        });



        btn_rate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Thnakyou for rating us :)",Toast.LENGTH_LONG).show();
            }
        });

    }










}
