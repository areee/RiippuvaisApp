package fi.uta.riippuvaisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

//        Intent activityThatCalled = getIntent();
        Button exercise1 = (Button) findViewById(R.id.exercise_button1);
        Button exercise2 = (Button) findViewById(R.id.exercise_button2);

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
    }
}
