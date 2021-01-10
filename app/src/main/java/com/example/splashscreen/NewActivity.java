package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class NewActivity extends AppCompatActivity {
    TextView timertext,winmsg, scorecard;
    TextView question;
    TextView rounds;
    Button o1,o2,o3,o4,pagain;
    int rn1,rn2,ans,cao;
    int userWin=0,totalRound=0;
    boolean optionCorrect[] = new boolean[4];
    Random rd = new Random();


    public void pAClicked(View view){
        winmsg.setBackgroundColor(Color.alpha(0));
        userWin=0;
        totalRound=0;
        winmsg.setText("");
        pagain.setVisibility(View.INVISIBLE);
        scorecard.setVisibility(View.INVISIBLE);

        o1.setEnabled(true);
        o2.setEnabled(true);
        o3.setEnabled(true);
        o4.setEnabled(true);

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                updateTimer((int)l/1000);
            }

            @Override
            public void onFinish() {
                Log.i("Time's Up!","Done!");
                winmsg.setText("Times Up!");
                scorecard.setVisibility(View.VISIBLE);
                scorecard.setBackgroundColor(Color.WHITE);
                scorecard.setTextColor(Color.BLACK);
                scorecard.setText("Your Score:"+ String.valueOf((userWin/totalRound)*100)+"%");
                userWin=0;
                totalRound=0;
                pagain.setVisibility(View.VISIBLE);
                rounds.setText(userWin+"/"+totalRound);
                o1.setEnabled(false);
                o2.setEnabled(false);
                o3.setEnabled(false);
                o4.setEnabled(false);

                for(int j=0; j<optionCorrect.length;j++){
                    optionCorrect[j]=false;
                }

            }
        }.start();


        Random rd = new Random();

        // generating random numbers between 0 to 99
        rn1 = rd.nextInt(100);
        rn2 = rd.nextInt(100);
        ans = rn1+ rn2;
        question.setText(String.valueOf(rn1)+" + "+String.valueOf(rn2));

        // 0 to 3
        cao = rd.nextInt(4);
        switch(cao){
            case 0:
                o1.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
            case 1:
                o2.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
            case 2:
                o3.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
            case 3:
                o4.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
        }
        for(int i=0; i<optionCorrect.length; i++){
            if(optionCorrect[i]==false){
                switch (i){
                    case 0:
                        o1.setText(String.valueOf(rd.nextInt(100)));
                        break;
                    case 1:
                        o2.setText(String.valueOf(rd.nextInt(100)));
                        break;
                    case 2:
                        o3.setText(String.valueOf(rd.nextInt(100)));
                        break;
                    case 3:
                        o4.setText(String.valueOf(rd.nextInt(100)));
                        break;
                }
            }
        }
    }

    public void newGame(){

        Random rd = new Random();

        // generating random numbers between 0 to 99
        rn1 = rd.nextInt(100);
        rn2 = rd.nextInt(100);
        ans = rn1+ rn2;
        question.setText(String.valueOf(rn1)+" + "+String.valueOf(rn2));

        // 0 to 3
        cao = rd.nextInt(4);
        switch(cao){
            case 0:
                o1.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
            case 1:
                o2.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
            case 2:
                o3.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
            case 3:
                o4.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
        }
        for(int i=0; i<optionCorrect.length; i++){
            if(optionCorrect[i]==false){
                switch (i){
                    case 0:
                        o1.setText(String.valueOf(rd.nextInt(100)));
                        break;
                    case 1:
                        o2.setText(String.valueOf(rd.nextInt(100)));
                        break;
                    case 2:
                        o3.setText(String.valueOf(rd.nextInt(100)));
                        break;
                    case 3:
                        o4.setText(String.valueOf(rd.nextInt(100)));
                        break;
                }
            }
        }
    }


    public void o1Clicked(View view){
        winmsg.setBackgroundColor(Color.WHITE);
        if(Integer.parseInt(o1.getText().toString())==ans){
            Log.i("Answer: ","Correct!");
            winmsg.setText("Correct!");
            winmsg.setTextColor(Color.GREEN);
            userWin++;
            totalRound++;
            rounds.setText(String.valueOf(userWin)+"/"+String.valueOf(totalRound));
        }
        else{
            Log.i("Answer: ","Incorrect!");
            winmsg.setText("Wrong :(");
            winmsg.setTextColor(Color.RED);
            totalRound++;
            rounds.setText(String.valueOf(userWin)+"/"+String.valueOf(totalRound));

        }
        selectRandomNumbers(rd);
        newGame();
    }

    public void o2Clicked(View view){
        winmsg.setBackgroundColor(Color.WHITE);
        if(Integer.parseInt(o2.getText().toString())==ans){
            Log.i("Answer: ","Correct!");
            winmsg.setTextColor(Color.GREEN);
            winmsg.setText("Correct!");
            userWin++;
            totalRound++;
            rounds.setText(String.valueOf(userWin)+"/"+String.valueOf(totalRound));

        }
        else{
            Log.i("Answer: ","Incorrect!");
            winmsg.setTextColor(Color.RED);
            winmsg.setText("Wrong :(");
            totalRound++;
            rounds.setText(String.valueOf(userWin)+"/"+String.valueOf(totalRound));
        }
        selectRandomNumbers(rd);
        newGame();
    }

    public void o3Clicked(View view){
        winmsg.setBackgroundColor(Color.WHITE);
        if(Integer.parseInt(o3.getText().toString())==ans){
            Log.i("Answer: ","Correct!");
            winmsg.setTextColor(Color.GREEN);
            winmsg.setText("Correct!");
            userWin++;
            totalRound++;
            rounds.setText(String.valueOf(userWin)+"/"+String.valueOf(totalRound));
        }
        else{
            Log.i("Answer: ","Incorrect!");
            winmsg.setTextColor(Color.RED);
            winmsg.setText("Wrong :(");
            totalRound++;
            rounds.setText(String.valueOf(userWin)+"/"+String.valueOf(totalRound));
        }
        selectRandomNumbers(rd);
        newGame();
    }

    public void o4Clicked(View view){
        winmsg.setBackgroundColor(Color.WHITE);
        if(Integer.parseInt(o4.getText().toString())==ans){
            Log.i("Answer: ","Correct!");
            winmsg.setTextColor(Color.GREEN);
            winmsg.setText("Correct!");
            userWin++;
            totalRound++;
            rounds.setText(String.valueOf(userWin)+"/"+String.valueOf(totalRound));

        }
        else{
            Log.i("Answer: ","Incorrect!");
            winmsg.setTextColor(Color.RED);
            winmsg.setText("Wrong :(");
            totalRound++;
            rounds.setText(String.valueOf(userWin)+"/"+String.valueOf(totalRound));

        }
        selectRandomNumbers(rd);
        newGame();
    }



    public void goClicked(View view){
        Button gobtn = (Button) findViewById(R.id.goButton);
        gobtn.setVisibility(View.INVISIBLE);

        timertext.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        rounds.setVisibility(View.VISIBLE);

        o1.setVisibility(View.VISIBLE);
        o2.setVisibility(View.VISIBLE);
        o3.setVisibility(View.VISIBLE);
        o4.setVisibility(View.VISIBLE);

        CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                updateTimer((int)l/1000);
            }

            @Override
            public void onFinish() {
                Log.i("Time's Up!","Done!");
                winmsg.setText("Times Up!");
                scorecard.setVisibility(View.VISIBLE);
                scorecard.setBackgroundColor(Color.WHITE);
                scorecard.setTextColor(Color.BLACK);
                scorecard.setText("Your Score:"+ String.valueOf( ((float) userWin/totalRound)*100)+"%");
                userWin=0;
                totalRound=0;
                rounds.setText(userWin+"/"+totalRound);
                o1.setEnabled(false);
                o2.setEnabled(false);
                o3.setEnabled(false);
                o4.setEnabled(false);
                pagain.setVisibility(View.VISIBLE);

                for(int j=0; j<optionCorrect.length;j++){
                    optionCorrect[j]=false;
                }
            }
        }.start();


        // generating random numbers between 0 to 99
        rn1 = rd.nextInt(100);
        rn2 = rd.nextInt(100);
        ans = rn1+ rn2;
        question.setText(String.valueOf(rn1)+" + "+String.valueOf(rn2));

        // 0 to 3
        cao = rd.nextInt(4);
        switch(cao){
            case 0:
                o1.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
            case 1:
                o2.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
            case 2:
                o3.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
            case 3:
                o4.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
        }
        selectRandomNumbers(rd);

    }

    public void selectRandomNumbers(Random rd){
        for(int j=0; j<optionCorrect.length;j++){
            optionCorrect[j]=false;
        }


        // generating random numbers between 0 to 99
        rn1 = rd.nextInt(100);
        rn2 = rd.nextInt(100);
        ans = rn1+ rn2;
        question.setText(String.valueOf(rn1)+" + "+String.valueOf(rn2));

        // 0 to 3
        cao = rd.nextInt(4);
        switch(cao){
            case 0:
                o1.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
            case 1:
                o2.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
            case 2:
                o3.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
            case 3:
                o4.setText(String.valueOf(ans));
                optionCorrect[cao] = true;
                break;
        }

        for(int i=0; i<optionCorrect.length; i++){
            if(optionCorrect[i]==false){
                switch (i){
                    case 0:
                        o1.setText(String.valueOf(rd.nextInt(100)));
                        break;
                    case 1:
                        o2.setText(String.valueOf(rd.nextInt(100)));
                        break;
                    case 2:
                        o3.setText(String.valueOf(rd.nextInt(100)));
                        break;
                    case 3:
                        o4.setText(String.valueOf(rd.nextInt(100)));
                        break;
                }
            }
        }
    }

    public void updateTimer(int secondsleft){

        int seconds = secondsleft;

        String secondsString = String.valueOf(seconds);

        timertext.setText(secondsString+"s");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);


        timertext = (TextView) findViewById(R.id.timerText);
        question = (TextView) findViewById(R.id.quesText);
        rounds  = (TextView) findViewById(R.id.roundsText);
        winmsg = (TextView) findViewById(R.id.winText);
        scorecard =(TextView) findViewById(R.id.score);

        o1 = (Button) findViewById(R.id.option1);
        o2 = (Button) findViewById(R.id.option2);
        o3 = (Button) findViewById(R.id.option3);
        o4 = (Button) findViewById(R.id.option4);
        pagain = (Button) findViewById(R.id.playagain);

        timertext.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);
        rounds.setVisibility(View.INVISIBLE);
        scorecard.setVisibility(View.INVISIBLE);

        o1.setVisibility(View.INVISIBLE);
        o2.setVisibility(View.INVISIBLE);
        o3.setVisibility(View.INVISIBLE);
        o4.setVisibility(View.INVISIBLE);
        pagain.setVisibility(View.INVISIBLE);
    }
}