package fi.uta.riippuvaisapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ExerciseActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "FileForSharedPreferences";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        Button exercise1 = (Button) findViewById(R.id.exercise_button1);
        Button exercise2 = (Button) findViewById(R.id.exercise_button2);
        Button exercise3 = (Button) findViewById(R.id.exercise_button3);
        Button exercise4 = (Button) findViewById(R.id.exercise_button4);

        SharedPreferences buttonsStatus = getSharedPreferences(PREFS_NAME, 0);
        boolean button1 = buttonsStatus.getBoolean("button1", false);
        boolean button2 = buttonsStatus.getBoolean("button2", false);
        boolean button3 = buttonsStatus.getBoolean("button3", false);
        boolean button4 = buttonsStatus.getBoolean("button4", false);

        if (!button1) { // exercise 1 is not done -> another exercises disabled
            exercise1.setBackgroundColor(Color.argb(100, 251, 23, 0));
            exercise2.setEnabled(false);
            exercise3.setEnabled(false);
            exercise4.setEnabled(false);
        } else { // exercise 1 is done
            exercise1.setBackgroundColor(Color.argb(100, 15, 251, 0));
            exercise2.setEnabled(true);

            if (!button2) { // exercise 2 is not done -> exercises 3 and 4 disabled
                exercise2.setBackgroundColor(Color.argb(100, 251, 23, 0));
                exercise3.setEnabled(false);
                exercise4.setEnabled(false);
            } else { // exercise 2 is done
                exercise2.setBackgroundColor(Color.argb(100, 15, 251, 0));
                exercise3.setEnabled(true);

                if (!button3) { // exercise 3 is not done -> exercise 4 disabled
                    exercise3.setBackgroundColor(Color.argb(100, 251, 23, 0));
                    exercise4.setEnabled(false);
                } else { // exercise 3 is done
                    exercise3.setBackgroundColor(Color.argb(100, 15, 251, 0));
                    exercise4.setEnabled(true);
                }
            }
        }

        exercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Exercise1Activity.class);
                startActivity(intent);
            }
        });

        exercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Exercise2Activity.class);
                startActivity(intent);
            }
        });

        exercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Exercise3Activity.class);
                startActivity(intent);
            }
        });

        exercise4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Tehtävää 4 ei ole toteutettu demoversioon!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
