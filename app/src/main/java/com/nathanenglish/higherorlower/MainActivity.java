package com.nathanenglish.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    int r_num;
    int num_a;
    public void makeToast(String string) {
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();

    }
    public void clickGuess(View view) {
        EditText guessText = (EditText) findViewById(R.id.guessText);

        String value = guessText.getText().toString();
        int guess_int =Integer.parseInt(value);

        if (r_num == guess_int) {
            num_a += 1;
            makeToast("Congratulations you got the right number with " + num_a + " attempts. Keep on going!");
            Random rand = new Random();
            r_num = rand.nextInt(20) + 1;
            num_a = 0;
        }
        else if (r_num > guess_int) {
            makeToast("Higher");
            num_a += 1;
        }


        else {
            makeToast("Lower");
            num_a += 1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        r_num = rand.nextInt(20) + 1;
        num_a = 0;
    }
}
