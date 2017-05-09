package fi.uta.riippuvaisapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

public class SummaryActivity extends AppCompatActivity {
    TextView cell1;
    TextView cell2;
    TextView cell3;
    TextView cell4;
    TextView cell5;
    TextView cell6;
    TextView cell7;
    TextView cell8;
    TextView cell9;

    EditText editTextNumber1;
    EditText editTextNumber2;

    String FILENAME1 = "set_goal";
    String FILENAME2 = "summary_values";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        cell1 = (TextView) findViewById(R.id.table_need_to_use_cell1);
        cell2 = (TextView) findViewById(R.id.table_need_to_use_cell2);
        cell3 = (TextView) findViewById(R.id.table_need_to_use_cell3);
        cell4 = (TextView) findViewById(R.id.table_need_to_use_cell4);
        cell5 = (TextView) findViewById(R.id.table_need_to_use_cell5);
        cell6 = (TextView) findViewById(R.id.table_need_to_use_cell6);
        cell7 = (TextView) findViewById(R.id.table_need_to_use_cell7);
        cell8 = (TextView) findViewById(R.id.table_need_to_use_cell8);
        cell9 = (TextView) findViewById(R.id.table_need_to_use_cell9);

        editTextNumber1 = (EditText) findViewById(R.id.summary_edit_text1);
        editTextNumber2 = (EditText) findViewById(R.id.summary_edit_text2);

        int ch;
        StringBuffer fileContent = new StringBuffer("");
        FileInputStream fis;

        try {
            fis = openFileInput(FILENAME1);
            while ((ch = fis.read()) != -1) {
                fileContent.append((char) ch);
            }
            fis.close();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Tähän toimintoon ei ole vielä tallennettu arvoja", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        String data = new String(fileContent);
        String[] splitValues = data.split("\n");

        System.out.println("splitValues-listan koko: " + splitValues.length);
        double sum = 0;

        for (int i = 0; i < 35; i++) {
            String s = splitValues[i];
            double parseDouble = Double.parseDouble(s);
            System.out.println(i);
            sum += parseDouble;
        }

        System.out.println("Summa: " + sum);
        double d = sum / 16;

        DecimalFormat df = new DecimalFormat("#.#");

        String s = df.format(d);

        cell1.setText((int) sum + " = " + s + "/vt");
        cell2.setText((int) sum + " = " + s + "/vt");
        cell3.setText((int) sum + " = " + s + "/vt");
        cell4.setText((int) sum + " = " + s + "/vt");
        cell5.setText((int) sum + " = " + s + "/vt");
        cell6.setText((int) sum + " = " + s + "/vt");

        double sum2 = 0;
        for (int i = 35; i < splitValues.length; i++) {
            String s1 = splitValues[i];
            double parseDouble = Double.parseDouble(s1);
            System.out.println(i);
            sum2 += parseDouble;
        }
        System.out.println("Summa: " + sum2);
        double d2 = sum2 / 2 / 16;

        String format = df.format(d2);

        cell7.setText((int) sum2 + " = " + format + "/vt");
        cell8.setText((int) sum2 + " = " + format + "/vt");
        cell9.setText((int) sum2 + " = " + format + "/vt");

    }

    public void closeSummary(View view) {
        String s1 = editTextNumber1.getText().toString();
        String s2 = editTextNumber2.getText().toString();

        String s = "";

        s = s.concat(s1 + "\n");
        s = s.concat(s2 + "\n");

        System.out.println(s);

        try {
            FileOutputStream outputStream = openFileOutput(FILENAME2, Context.MODE_PRIVATE);
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Tallennettu tiedostoon " + FILENAME2);

        Toast toast = Toast.makeText(getApplicationContext(), "Tavoite tallennettu!", Toast.LENGTH_LONG);
        toast.show();

        finish();
    }
}
