package com.example.chamath.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_rock, b_scissors, b_paper;
    TextView tv_Score;
    ImageView iv_computerChoice, iv_humanChoice;
    int userScore, computerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_rock=(Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors= (Button) findViewById(R.id.b_scissors);

        tv_Score = (TextView) findViewById(R.id.tv_Score);
        iv_computerChoice = (ImageView) findViewById(R.id.iv_computerChoice);
        iv_humanChoice= (ImageView) findViewById(R.id.iv_humanChoice);


        b_rock.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                iv_humanChoice.setImageResource(R.drawable.rock);
                String response = letsPlay(1);
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                tv_Score.setText("Score: You " + Integer.toString(userScore) + " Computer " + Integer.toString(computerScore) );
            }
        });

        b_paper.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                iv_humanChoice.setImageResource(R.drawable.paper);
                String response = letsPlay(2);
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                tv_Score.setText("Score: You " + Integer.toString(userScore) + " Computer " + Integer.toString(computerScore) );

            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                iv_humanChoice.setImageResource(R.drawable.scissors);
                String response = letsPlay(3);
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                tv_Score.setText("Score: You " + Integer.toString(userScore) + " Computer " + Integer.toString(computerScore) );

            }
        });

    }

    public String letsPlay(int uChoice){
        Random rand = new Random();
        int choice = rand.nextInt(3) + 1;
        if(choice == 1) iv_computerChoice.setImageResource(R.drawable.rock);
        else if(choice == 2)iv_computerChoice.setImageResource(R.drawable.paper);
        else if(choice == 3) iv_computerChoice.setImageResource(R.drawable.scissors);
        if(choice == uChoice) return "Draw, looks like nobody wins...";
        else if(uChoice == 1 && choice == 2){
            computerScore++;
            return "Paper smothers rock, you lose!";

        }
        else if(uChoice == 1 && choice == 3){
            userScore++;
            return "Rock smashes scissors, you win!";
        }
        else if(uChoice == 2 && choice == 1){
            userScore++;
            return "Paper smothers rock, you win!";
        }
        else if(uChoice == 2 && choice == 3){
            computerScore++;
            return "Paper is slashed by scissors, you lose";
        }
        else if(uChoice == 3 && choice == 1){
            computerScore++;
            return "Rock smashes scissors, you lose!";
        }
        else if(uChoice == 3 && choice == 2){
            userScore++;
            return "Scissors slashes paper, you win!";
        }
        else return "";


    }
}
