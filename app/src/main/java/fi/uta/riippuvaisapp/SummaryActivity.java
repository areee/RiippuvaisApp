package fi.uta.riippuvaisapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

        
    }

    public void closeSummary(View view) {
        finish();
    }
}
