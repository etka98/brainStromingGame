package com.example.brainstormgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goBtn;
    TextView sumText;
    TextView scoreText;
    TextView timerText;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button playAgainButton;
    GridLayout grid;
    int flag;
    int correct = 0, total = 0;
    ArrayList<Integer> ans = new ArrayList<Integer>();
    public void playAgain(View view){
        correct = 0;
        total = 0;
        timerText.setText("30s");
        scoreText.setText(correct + "/" + total);
        update();
        playAgainButton.setVisibility(View.INVISIBLE);
        new CountDownTimer(30100, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerText.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();
    }
    public void start(View view){
        goBtn.setVisibility(View.VISIBLE);
        sumText.setVisibility(View.VISIBLE);
        scoreText.setVisibility(View.VISIBLE);
        timerText.setVisibility(View.VISIBLE);
        grid.setVisibility(View.VISIBLE);
        playAgain((TextView)findViewById(R.id.timerTextView));
    }
    public void chooseAnswer(View view){
        if(view.getTag().toString().equals(Integer.toString(flag))){
            correct++;
            total++;
            scoreText.setText(correct + "/" + total);
        }
        else {
            total++;
            scoreText.setText(correct + "/" + total);
        }
        update();
    }

    public void update(){
        Random rand = new Random();
        int x = rand.nextInt(21);
        int y = rand.nextInt(21);
        sumText.setText(x + " + " + y);
        flag = rand.nextInt(4);
        ans.clear();
        for(int i = 0; i < 4; i++){
            if(i == flag){
                ans.add(x + y);
            }
            else {
                int wrong = rand.nextInt(41);
                while(wrong == x + y){
                    wrong = rand.nextInt(41);
                }
                ans.add(wrong);
            }
        }
        btn0.setText(ans.get(0) + "");
        btn1.setText(ans.get(1) + "");
        btn2.setText(ans.get(2) + "");
        btn3.setText(ans.get(3) + "");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = (GridLayout)findViewById(R.id.gridLayout);
        goBtn = (Button)findViewById(R.id.goButton);
        scoreText = (TextView)findViewById(R.id.scoreTextView);
        sumText = (TextView)findViewById(R.id.sumTextView);
        timerText = (TextView)findViewById(R.id.timerTextView);
        btn0 = (Button)findViewById(R.id.button0);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        playAgainButton = (Button)findViewById(R.id.playAgainButton);
        goBtn.setVisibility(View.VISIBLE);


    }
}
