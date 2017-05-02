package fi.uta.riippuvaisapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class Exercise2Activity extends AppCompatActivity {
    RadioGroup radioGroup1;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;

    RadioGroup radioGroup2;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;

    RadioGroup radioGroup3;
    RadioButton radioButton7;
    RadioButton radioButton8;
    RadioButton radioButton9;

    RadioGroup radioGroup4;
    RadioButton radioButton10;
    RadioButton radioButton11;
    RadioButton radioButton12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        radioGroup1 = (RadioGroup) findViewById(R.id.exercise2_radioGroup1);
        radioButton1 = (RadioButton) findViewById(R.id.exercise2_radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.exercise2_radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.exercise2_radioButton3);

        radioGroup2 = (RadioGroup) findViewById(R.id.exercise2_radioGroup2);
        radioButton4 = (RadioButton) findViewById(R.id.exercise2_radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.exercise2_radioButton5);
        radioButton6 = (RadioButton) findViewById(R.id.exercise2_radioButton6);

        radioGroup3 = (RadioGroup) findViewById(R.id.exercise2_radioGroup3);
        radioButton7 = (RadioButton) findViewById(R.id.exercise2_radioButton7);
        radioButton8 = (RadioButton) findViewById(R.id.exercise2_radioButton8);
        radioButton9 = (RadioButton) findViewById(R.id.exercise2_radioButton9);

        radioGroup4 = (RadioGroup) findViewById(R.id.exercise2_radioGroup4);
        radioButton10 = (RadioButton) findViewById(R.id.exercise2_radioButton10);
        radioButton11 = (RadioButton) findViewById(R.id.exercise2_radioButton11);
        radioButton12 = (RadioButton) findViewById(R.id.exercise2_radioButton12);

        final TextView textView1 = (TextView) findViewById(R.id.seekBar_text_exercise2_1);
        SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar_exercise2_1);

        final TextView textView2 = (TextView) findViewById(R.id.seekBar_text_exercise2_2);
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar_exercise2_2);

        final TextView textView3 = (TextView) findViewById(R.id.seekBar_text_exercise2_3);
        SeekBar seekBar3 = (SeekBar) findViewById(R.id.seekBar_exercise2_3);

        final TextView textView4 = (TextView) findViewById(R.id.seekBar_text_exercise2_4);
        SeekBar seekBar4 = (SeekBar) findViewById(R.id.seekBar_exercise2_4);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView1.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView2.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView3.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView4.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void startWatchVideo(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.ted.com/talks/matt_killingsworth_want_to_be_happier_stay_in_the_moment"));
        startActivity(intent);
    }

    public void checkAnswers(View v) {

        final int checkedRadioButtonId1 = radioGroup1.getCheckedRadioButtonId();
        final int checkedRadioButtonId2 = radioGroup2.getCheckedRadioButtonId();
        final int checkedRadioButtonId3 = radioGroup3.getCheckedRadioButtonId();
        final int checkedRadioButtonId4 = radioGroup4.getCheckedRadioButtonId();

        int id1 = radioButton1.getId();
        int id2 = radioButton2.getId();
        int id3 = radioButton3.getId();

        int id4 = radioButton4.getId();
        int id5 = radioButton5.getId();
        int id6 = radioButton6.getId();

        int id7 = radioButton7.getId();
        int id8 = radioButton8.getId();
        int id9 = radioButton9.getId();

        int id10 = radioButton10.getId();
        int id11 = radioButton11.getId();
        int id12 = radioButton12.getId();

        if (checkedRadioButtonId1 == id2 &&
                checkedRadioButtonId2 == id4 &&
                checkedRadioButtonId3 == id8 &&
                checkedRadioButtonId4 == id12) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Vastaukset oikein");
            builder.setMessage("Kaikki vastaukset olivat oikein! Hyvä!");
            builder.setPositiveButton("Jatka", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.show();
        } else {

            if (checkedRadioButtonId1 == id1) {
                radioButton1.setTextColor(Color.RED);
            } else {
                radioButton1.setTextColor(Color.BLACK);
            }

            if (checkedRadioButtonId1 == id3) {
                radioButton3.setTextColor(Color.RED);
            } else {
                radioButton3.setTextColor(Color.BLACK);
            }

            if (checkedRadioButtonId2 == id5) {
                radioButton5.setTextColor(Color.RED);
            } else {
                radioButton5.setTextColor(Color.BLACK);
            }

            if (checkedRadioButtonId2 == id6) {
                radioButton6.setTextColor(Color.RED);
            } else {
                radioButton6.setTextColor(Color.BLACK);
            }

            if (checkedRadioButtonId3 == id7) {
                radioButton7.setTextColor(Color.RED);
            } else {
                radioButton7.setTextColor(Color.BLACK);
            }

            if (checkedRadioButtonId3 == id9) {
                radioButton9.setTextColor(Color.RED);
            } else {
                radioButton9.setTextColor(Color.BLACK);
            }

            if (checkedRadioButtonId4 == id10) {
                radioButton10.setTextColor(Color.RED);
            } else {
                radioButton10.setTextColor(Color.BLACK);
            }

            if (checkedRadioButtonId4 == id11) {
                radioButton11.setTextColor(Color.RED);
            } else {
                radioButton11.setTextColor(Color.BLACK);
            }


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Vastauksessa korjattavaa");
            builder.setMessage("Korjaa väärät vastaukset ja tarkista uudelleen.");
            builder.setPositiveButton("Korjaa", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
        }
    }
}
