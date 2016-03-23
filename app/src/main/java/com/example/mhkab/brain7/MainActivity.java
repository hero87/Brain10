package com.example.mhkab.brain7;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;
    GridLayout gridLayout;
    TextView textViewStart;
    TextView textViewMath;
    TextView textViewResulte;
    Button button0, button1, button2, button3, button4, button5;
    int x;
    int y;
    char[] math = {'+', '-', '*', '/'};
    int randomIndex;

    int currcetLocation;

    int inCurrectAwnser;

    int resulte;

    ArrayList<Integer> arrayListAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        random = new Random();
        arrayListAnswer = new ArrayList<Integer>();
        gridLayout = (GridLayout) findViewById(R.id.gridlayout_id);
        textViewStart = (TextView) findViewById(R.id.textView_start);
        textViewMath = (TextView) findViewById(R.id.textViewMath);
        textViewResulte = (TextView) findViewById(R.id.textView_result);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);

        x = random.nextInt(10);
        y = random.nextInt(10);
        randomIndex = random.nextInt(3);
        currcetLocation = random.nextInt(5);



        createQuestion();
        startGame();


    }


    public void startGame() {

        textViewStart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                gridLayout.setVisibility(View.VISIBLE);
                textViewStart.setVisibility(View.INVISIBLE);
                return false;
            }
        });
    }

    public void createQuestion() {


        textViewMath.setText(x + "" + math[randomIndex] + y);

        switch (randomIndex) {
            case 0:
                resulte = y + x;
                break;
            case 1:
                resulte = y - x;
                break;
            case 2:
                resulte = y * x;
                break;
            case 3:
                resulte = y / x;
                break;


        }
        textViewResulte.setText("Resulte is : " + resulte);


        for (int i = 0; i < 6; i++) {

            if (currcetLocation == i) {

                arrayListAnswer.add(resulte);

            } else {

                inCurrectAwnser=random.nextInt(100);

                arrayListAnswer.add(inCurrectAwnser);
                if (inCurrectAwnser == resulte) {


                    arrayListAnswer.add(inCurrectAwnser);
                }

            }

        }

        button0.setText(String.valueOf(arrayListAnswer.get(0)));
        button1.setText(String.valueOf(arrayListAnswer.get(1)));
        button2.setText(String.valueOf(arrayListAnswer.get(2)));
        button3.setText(String.valueOf(arrayListAnswer.get(3)));
        button4.setText(String.valueOf(arrayListAnswer.get(4)));
       button5.setText(String.valueOf(arrayListAnswer.get(5)));


    }
}
