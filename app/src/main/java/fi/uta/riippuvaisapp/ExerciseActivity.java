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
    Button exercise1;
    Button exercise2;
    Button exercise3;
    Button exercise4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        exercise1 = (Button) findViewById(R.id.exercise_button1);
        exercise2 = (Button) findViewById(R.id.exercise_button2);
        exercise3 = (Button) findViewById(R.id.exercise_button3);
        exercise4 = (Button) findViewById(R.id.exercise_button4);

        checkWhetherExercisesAreDone();

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

    private void checkWhetherExercisesAreDone() {
        // Read values from SharedPreferences:
        SharedPreferences buttonsStatus = getSharedPreferences(PREFS_NAME, 0);
        boolean exercise1Done = buttonsStatus.getBoolean("exercise1Done", false);
        boolean exercise2Done = buttonsStatus.getBoolean("exercise2Done", false);
        boolean exercise3Done = buttonsStatus.getBoolean("exercise3Done", false);
        boolean exercise4Done = buttonsStatus.getBoolean("exercise4Done", false);

        // Check whether exercises are done:
        if (!exercise1Done) { // exercise 1 is not done -> another exercises disabled
            exercise1.setBackgroundColor(Color.argb(100, 251, 23, 0));
            exercise2.setEnabled(false);
            exercise3.setEnabled(false);
            exercise4.setEnabled(false);
        } else { // exercise 1 is done
            exercise1.setBackgroundColor(Color.argb(100, 15, 251, 0));
            exercise2.setEnabled(true);

            if (!exercise2Done) { // exercise 2 is not done -> exercises 3 and 4 disabled
                exercise2.setBackgroundColor(Color.argb(100, 251, 23, 0));
                exercise3.setEnabled(false);
                exercise4.setEnabled(false);
            } else { // exercise 2 is done
                exercise2.setBackgroundColor(Color.argb(100, 15, 251, 0));
                exercise3.setEnabled(true);

                if (!exercise3Done) { // exercise 3 is not done -> exercise 4 disabled
                    exercise3.setBackgroundColor(Color.argb(100, 251, 23, 0));
                    exercise4.setEnabled(false);
                } else { // exercise 3 is done
                    exercise3.setBackgroundColor(Color.argb(100, 15, 251, 0));
                    exercise4.setEnabled(true);

                    if (!exercise4Done) { // exercise 4 is not done
                        exercise4.setBackgroundColor(Color.argb(100, 251, 23, 0));
                    }
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkWhetherExercisesAreDone();
    }
}
