package fi.uta.riippuvaisapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RecallActivity extends AppCompatActivity {
    TextView number1;
    TextView number2;
    TextView number3;

    SeekBar seekBar1;
    SeekBar seekBar2;
    SeekBar seekBar3;

    String FILENAME1 = "seekbar_values_exercise2";
    String FILENAME2 = "seekbar_values_exercise3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recall);

        number1 = (TextView) findViewById(R.id.recall_seekBar_number1);
        number2 = (TextView) findViewById(R.id.recall_seekBar_number2);
        number3 = (TextView) findViewById(R.id.recall_seekBar_number3);

        seekBar1 = (SeekBar) findViewById(R.id.recall_seekBar1);
        seekBar1.setEnabled(false);
        seekBar2 = (SeekBar) findViewById(R.id.recall_seekBar2);
        seekBar2.setEnabled(false);
        seekBar3 = (SeekBar) findViewById(R.id.recall_seekBar3);
        seekBar3.setEnabled(false);

        StringBuffer fileContent = readContent(FILENAME1);
        String data = new String(fileContent);
        String[] splitValues1 = data.split("\n");

        System.out.println("splitValues1-listan koko: " + splitValues1.length);

//        int value1 = Integer.parseInt(splitValues1[2]);

        number1.setText(splitValues1[2]);
        seekBar1.setProgress(Integer.parseInt(splitValues1[2]));
//
//        StringBuffer fileContent2 = readContent(FILENAME2);
//        String s = new String(fileContent2);
//        String[] splitValues2 = s.split("\n");
//
//        System.out.println("splitValues2-listan koko: " + splitValues2.length);
//
//        int value2 = Integer.parseInt(splitValues2[3]);
//        number2.setText(value2);
////        seekBar2.setProgress(value2);
////
//        int value3 = Integer.parseInt(splitValues2[1]);
//        number3.setText(value3);
//        seekBar3.setProgress(value3);


    }

    @NonNull
    private StringBuffer readContent(String filename) {
        int ch;
        StringBuffer fileContent = new StringBuffer("");
        FileInputStream fis;

        try {
            fis = openFileInput(filename);
            while ((ch = fis.read()) != -1) {
                fileContent.append((char) ch);
            }
            fis.close();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Tähän toimintoon ei ole vielä tallennettu arvoja", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        return fileContent;
    }


    public void recallContinueButtonClicked(View view) {
        finish(); // quit the current view

        // Start a new intent (=view) called SetGoalActivity:
        Intent intent = new Intent(getApplicationContext(), SetGoalActivity.class);
        startActivity(intent);
    }
}
