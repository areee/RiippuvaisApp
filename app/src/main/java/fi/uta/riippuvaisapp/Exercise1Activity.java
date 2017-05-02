package fi.uta.riippuvaisapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Exercise1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.exercise1_radioGroup1);
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.exercise1_radioButton1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.exercise1_radioButton2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.exercise1_radioButton3);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.exercise1_radioGroup2);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.exercise1_radioButton4);
        RadioButton radioButton5 = (RadioButton) findViewById(R.id.exercise1_radioButton5);
        RadioButton radioButton6 = (RadioButton) findViewById(R.id.exercise1_radioButton6);


//        Button read = (Button) findViewById(R.id.read_exercise1_button);
//
//        read.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.stoori.fi/hilmamaria/kasipuhelin-keskittyminen-kadoksissa/"));
//                startActivity(intent);
//            }
//        });
    }

    public void startReadPage(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.stoori.fi/hilmamaria/kasipuhelin-keskittyminen-kadoksissa/"));
        startActivity(intent);
    }

    public void checkAnswers(View v) {


    }

}
