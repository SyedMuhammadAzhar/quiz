package com.example.mathtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class gameplay extends AppCompatActivity {


    TextView TV_time1,TV_score1,TV_question1,TV_answer1;
    Button btn_correct1,btn_wrong2;
    boolean IsCorrectAnswer=true;
    int score=0;
    int seconds=20;
    boolean stoptime=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        TV_time1=(TextView)findViewById(R.id.TV_game_timer2);
        TV_score1=(TextView)findViewById(R.id.TV_game_score2);
        TV_question1=(TextView)findViewById(R.id.TV_game_question2);
        TV_answer1=(TextView)findViewById(R.id.TV_game_answer2);
        btn_correct1=(Button)findViewById(R.id.btn_game_true2);
        btn_wrong2=(Button)findViewById(R.id.btn_game_false2);

        GameTime();
        GenerateQuestion();
        Answering();




    }


    public void GenerateQuestion()
    {
        IsCorrectAnswer=true;

        int a,b;
        int result;

        Random rand = new Random();
        a=rand.nextInt(100);
        b=rand.nextInt(100);
        result=a+b;

        float checker;

        checker=rand.nextFloat();

        if(checker<=0.5f)
        {
            result=rand.nextInt(100);
            IsCorrectAnswer=false;

        }

        TV_question1.setText(a+"+"+b);
        TV_answer1.setText("="+result);



    }

    public void Answering()
    {
        btn_correct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              boolean answer=true;

              if(IsCorrectAnswer==answer)
              {
                  Toast.makeText(getApplicationContext(),"Correct +5",Toast.LENGTH_SHORT).show();
                  score=score+5;
                  TV_score1.setText("Score: "+score);
                  GenerateQuestion();


              }
              else if(IsCorrectAnswer!=answer)
              {
                  Toast.makeText(getApplicationContext(),"Wrong answer -2",Toast.LENGTH_SHORT).show();
                  score=score-3;
                  TV_score1.setText("Score: "+score);
                  GenerateQuestion();
              }

            }


        });


        btn_wrong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean answer=false;

                if(IsCorrectAnswer==answer)
                {

                    Toast.makeText(getApplicationContext(),"Correct +5",Toast.LENGTH_SHORT).show();
                    score=score+5;
                    TV_score1.setText("Score: "+score);
                    GenerateQuestion();
                }

                else if(IsCorrectAnswer!=answer)
                {
                   Toast.makeText(getApplicationContext(),"Wrong answer -2",Toast.LENGTH_SHORT).show();

                    score=score-3;
                    TV_score1.setText("Score: "+score);
                    GenerateQuestion();

                }

            }
        });



    }

   public void GameTime()
    {

        final Handler hand = new Handler();
        hand.post(new Runnable() {
            @Override
            public void run() {

                if(seconds<=0)
                {
                    Intent i = new Intent(getApplicationContext(),result.class);
                    i.putExtra("score",score);
                    startActivity(i);


                }
                else
                {
                    seconds--;
                    TV_time1.setText("Timer: "+seconds);
                  hand.postDelayed(this,1000);


                }



            }
        });



    }


}



