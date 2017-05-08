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

public class Exercise1Activity extends AppCompatActivity {
    RadioGroup radioGroup1;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;

    RadioGroup radioGroup2;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        radioGroup1 = (RadioGroup) findViewById(R.id.exercise1_radioGroup1);
        radioButton1 = (RadioButton) findViewById(R.id.exercise1_radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.exercise1_radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.exercise1_radioButton3);

        radioGroup2 = (RadioGroup) findViewById(R.id.exercise1_radioGroup2);
        radioButton4 = (RadioButton) findViewById(R.id.exercise1_radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.exercise1_radioButton5);
        radioButton6 = (RadioButton) findViewById(R.id.exercise1_radioButton6);

        final TextView textView1 = (TextView) findViewById(R.id.seekBar_text_exercise1_1);
        SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar_exercise1_1);

        final TextView textView2 = (TextView) findViewById(R.id.seekBar_text_exercise1_2);
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar_exercise1_2);

        final TextView textView3 = (TextView) findViewById(R.id.seekBar_text_exercise1_3);
        SeekBar seekBar3 = (SeekBar) findViewById(R.id.seekBar_exercise1_3);

        final TextView textView4 = (TextView) findViewById(R.id.seekBar_text_exercise1_4);
        SeekBar seekBar4 = (SeekBar) findViewById(R.id.seekBar_exercise1_4);


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

    public void startReadPage(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.stoori.fi/hilmamaria/kasipuhelin-keskittyminen-kadoksissa/"));
        startActivity(intent);
    }

    public void checkAnswers(View v) {

        final int checkedRadioButtonId1 = radioGroup1.getCheckedRadioButtonId();
        final int checkedRadioButtonId2 = radioGroup2.getCheckedRadioButtonId();


        int id1 = radioButton1.getId();
        int id2 = radioButton2.getId();
        int id3 = radioButton3.getId();

        int id4 = radioButton4.getId();
        int id5 = radioButton5.getId();
        int id6 = radioButton6.getId();

        if (checkedRadioButtonId1 == id2 && checkedRadioButtonId2 == id6) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Vastaukset oikein");
            builder.setMessage("Molemmat vastaukset olivat oikein! Hyvä!");
            builder.setPositiveButton("Jatka", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO: add memory parts here!


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

            if (checkedRadioButtonId2 == id4) {
                radioButton4.setTextColor(Color.RED);
            } else {
                radioButton4.setTextColor(Color.BLACK);
            }
            if (checkedRadioButtonId2 == id5) {
                radioButton5.setTextColor(Color.RED);
            } else {
                radioButton5.setTextColor(Color.BLACK);
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Vastauksissa korjattavaa");
            builder.setMessage("Korjaa punaisella värillä merkityt väärät vastaukset ja tarkista uudelleen.");
            builder.setPositiveButton("Korjaa", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
        }
    }


}
