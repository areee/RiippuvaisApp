package fi.uta.riippuvaisapp;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;

public class ReadDataActivity extends AppCompatActivity {
    TextView title;
    TextView textContent;
    Button previousButton;
    Button nextButton;

    int countView;

    String[] titleList;
    String[] fileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);

        title = (TextView) findViewById(R.id.read_data_title);
        textContent = (TextView) findViewById(R.id.read_data_textview);
        previousButton = (Button) findViewById(R.id.read_data_previous_button);
        nextButton = (Button) findViewById(R.id.read_data_next_button);

        countView = 0;

        titleList = new String[]{"Arvio käyttötarpeesta:", "Lopullinen käyttötavoite:", "Tehtävän 1 liukusäätimet:", "Tehtävän 2 liukusäätimet:", "Tehtävän 3 liukusäätimet:"};
        fileList = new String[]{"set_goal", "summary_values", "seekbar_values_exercise1", "seekbar_values_exercise2", "seekbar_values_exercise3"};

        title.setText(titleList[countView]);
        previousButton.setEnabled(false);

        readAndViewData();
    }

    private void readAndViewData() {
        int ch;
        StringBuffer fileContent = new StringBuffer("");
        FileInputStream fis;

        try {
            fis = openFileInput(fileList[countView]);
            while ((ch = fis.read()) != -1) {
                fileContent.append((char) ch);
            }
            fis.close();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Tähän osioon ei ole vielä tallennettu arvoja!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        String data = new String(fileContent);
        System.out.println(data);
        System.out.println("Data luettu!");

        title.setText(titleList[countView]);
        textContent.setText(data);
    }

    public void nextPressed(View v) {
        countView++;

        if (countView > 0) {
            previousButton.setEnabled(true);
        }

        if (countView == titleList.length - 1) {
            nextButton.setEnabled(false);
        }
        readAndViewData();
    }

    public void previousPressed(View v) {
        countView--;

        if (countView < titleList.length - 1) {
            nextButton.setEnabled(true);
        }

        if (countView == 0) {
            previousButton.setEnabled(false);
        }
        readAndViewData();
    }
}
