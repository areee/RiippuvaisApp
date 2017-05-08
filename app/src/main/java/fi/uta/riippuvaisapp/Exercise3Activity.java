package fi.uta.riippuvaisapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.io.FileOutputStream;

public class Exercise3Activity extends AppCompatActivity {
    RadioGroup radioGroup1;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;

    RadioGroup radioGroup2;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    SeekBar seekBar1;
    SeekBar seekBar2;
    SeekBar seekBar3;
    SeekBar seekBar4;

    String FILENAME = "seekbar_values_exercise3";

    public static final String PREFS_NAME = "FileForSharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);

        radioGroup1 = (RadioGroup) findViewById(R.id.exercise3_radioGroup1);
        radioButton1 = (RadioButton) findViewById(R.id.exercise3_radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.exercise3_radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.exercise3_radioButton3);

        radioGroup2 = (RadioGroup) findViewById(R.id.exercise3_radioGroup2);
        radioButton4 = (RadioButton) findViewById(R.id.exercise3_radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.exercise3_radioButton5);
        radioButton6 = (RadioButton) findViewById(R.id.exercise3_radioButton6);

        textView1 = (TextView) findViewById(R.id.seekBar_text_exercise3_1);
        seekBar1 = (SeekBar) findViewById(R.id.seekBar_exercise3_1);

        textView2 = (TextView) findViewById(R.id.seekBar_text_exercise3_2);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar_exercise3_2);

        textView3 = (TextView) findViewById(R.id.seekBar_text_exercise3_3);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar_exercise3_3);

        textView4 = (TextView) findViewById(R.id.seekBar_text_exercise3_4);
        seekBar4 = (SeekBar) findViewById(R.id.seekBar_exercise3_4);

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

    public void startReading(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://lifehacker.com/5974976/research-shows-how-much-a-three-second-distraction-can-derail-your-work"));
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

        if (checkedRadioButtonId1 == id2 &&
                checkedRadioButtonId2 == id6) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Vastaukset oikein");
            builder.setMessage("Kaikki vastaukset olivat oikein! Hyvä!");
            builder.setPositiveButton("Jatka", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    // Saving to SharedPreferences that the exercise is done:
                    SharedPreferences exerciseStatus = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor edit = exerciseStatus.edit();
                    edit.putBoolean("exercise3Done", true);
                    edit.commit();

                    String s = "";
                    s = s.concat(textView1.getText() + "\n");
                    s = s.concat(textView2.getText() + "\n");
                    s = s.concat(textView3.getText() + "\n");
                    s = s.concat(textView4.getText() + "\n");

                    System.out.println(s);

                    try {
                        FileOutputStream outputStream = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                        outputStream.write(s.getBytes());
                        outputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println("Tallennettu tiedostoon " + FILENAME);

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
