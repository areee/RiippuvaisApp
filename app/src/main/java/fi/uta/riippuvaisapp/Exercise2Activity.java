package fi.uta.riippuvaisapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Exercise2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);


    }

    public void startWatchVideo(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.ted.com/talks/matt_killingsworth_want_to_be_happier_stay_in_the_moment"));
        startActivity(intent);
    }

    public void checkAnswers(View v) {

    }
}
