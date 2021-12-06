package com.example.numplay;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.number.R;

public class MainActivity extends AppCompatActivity {

    private int number = 29;
    private int turn = 0;
    private TextView mShowCount;
    private TextView playerTurn;
    String player1 = "Игрок 1 отнимает";
    String player2 = "Игрок 2 отнимает";
    String win1 = "Игрок 1 победил!";
    String win2 = "Игрок 2 победил!";
    String ficha = "фича";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.textView_Remaining);
        playerTurn = (TextView) findViewById(R.id.textView_Turn);
    }

    public void pop(View view){
        TextView image = (TextView)findViewById(R.id.textView_Remaining);
        @SuppressLint("ResourceType") Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.anim);
        image.startAnimation(animation1);
    }

    public void go1(View view) {
        if (number >= 1) {
            number = number - 1;
            if (mShowCount != null) {
                mShowCount.setText(Integer.toString(number));
            }
            switch (number) {
                case 0:
                    victory(view);
                    pop(view);
                    break;
                default:
                    turn(view);
                    pop(view);
            }
        } else {
            Toast toast = Toast.makeText(this, R.string.toast_warning, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void go2(View view) {
        if (number >= 2) {
            number = number - 2;
            if (mShowCount != null)
                mShowCount.setText(Integer.toString(number));
            switch (number) {
                case 0:
                    victory(view);
                    pop(view);
                    break;
                default:
                    turn(view);
                    pop(view);
            }
        } else {
            Toast toast = Toast.makeText(this, R.string.toast_warning, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void go3(View view) {
        if (number >= 3) {
            number = number - 3;
            if (mShowCount != null)
                mShowCount.setText(Integer.toString(number));
            switch (number) {
                case 0:
                    victory(view);
                    pop(view);
                    break;
                default:
                    turn(view);
                    pop(view);
            }
        } else {
            Toast toast = Toast.makeText(this, R.string.toast_warning, Toast.LENGTH_SHORT);
            toast.show();
        }
    }



    public void turn(View view) {
        if (playerTurn != null) {
            switch (turn) {
                case 1:
                    playerTurn.setText(player1);
                    turn = turn - 1;
                    break;
                case 0:
                    playerTurn.setText(player2);
                    turn = turn + 1;
                    break;
                default:
                    playerTurn.setText(ficha);
                    break;
            }
        }

    }



    public void turn_reset(View view) {
        if (playerTurn != null)
            playerTurn.setText(player1);
        turn = 0;
    }

    public void victory(View view) {
        if (playerTurn != null) {
            switch (turn) {
                case 0:
                    playerTurn.setText(win1);
                    break;
                case 1:
                    playerTurn.setText(win2);
                    break;
                default:
                    playerTurn.setText(ficha);
                    break;

            }
        }
    }


    public void restart(View view) {
        number = 29;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(number));
        turn_reset(view);
        pop(view);
    }





    public void help(View view) {
        Toast toast = Toast.makeText(this,R.string.toast_help,Toast.LENGTH_LONG );
        toast.show();
    }
}
