package fi.uta.riippuvaisapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SetGoalActivity extends AppCompatActivity {
    TextView dayTitle;
    TextView timeTitle;
    EditText goal1;
    EditText goal2;
    EditText goal3;
    EditText goal4;
    EditText goal5;
    Button previousButton;
    Button nextButton;
    Button readyButton;

    String[] timeList;
    String[] dayList;

    int timeNumber;
    int dayNumber;
    int values;
    String[] valueList;
    int help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);

        dayTitle = (TextView) findViewById(R.id.set_goal_weekday);
        timeTitle = (TextView) findViewById(R.id.set_goal_title1);
        goal1 = (EditText) findViewById(R.id.set_goal1);
        goal2 = (EditText) findViewById(R.id.set_goal2);
        goal3 = (EditText) findViewById(R.id.set_goal3);
        goal4 = (EditText) findViewById(R.id.set_goal4);
        goal5 = (EditText) findViewById(R.id.set_goal5);
        previousButton = (Button) findViewById(R.id.previous_button);
        nextButton = (Button) findViewById(R.id.next_button);
        readyButton = (Button) findViewById(R.id.ready_button);

        timeList = new String[]{"Klo 06-09", "Klo 09-12", "Klo 12-15", "Klo 15-18", "Klo 18-21", "Klo 21-00", "Klo 00-06"};
        dayList = new String[]{"Arkipäivät ma-pe", "Viikonloppu la-su"};

        timeNumber = 0;
        dayNumber = 0;

        previousButton.setEnabled(false);

        readyButton.setVisibility(View.INVISIBLE);
        timeTitle.setText(timeList[timeNumber]);


        dayTitle.setText(dayList[dayNumber]);

        values = 70;
        valueList = new String[values];
        help = 0;

        showHelpDialog("Aloita");
    }

    public void showHelp(View v) {
        showHelpDialog("Sulje");
    }

    public void previous(View v) {
        help--; // edellinen 5 -> 4
        goal5.setText(valueList[help]);
        help--;
        goal4.setText(valueList[help]);
        help--;
        goal3.setText(valueList[help]);
        help--;
        goal2.setText(valueList[help]);
        help--;
        goal1.setText(valueList[help]);

        timeNumber--;

        if (timeNumber < timeList.length - 1) {
            nextButton.setEnabled(true);
            readyButton.setVisibility(View.INVISIBLE);
        }

        if (timeNumber < 0 && dayNumber == 1) {
            dayNumber--;
            dayTitle.setText(dayList[dayNumber]);
            timeNumber = timeList.length - 1;
        }

        if (timeNumber == 0 && dayNumber == 0) {
            previousButton.setEnabled(false);
        }

        timeTitle.setText(timeList[timeNumber]);
    }

    public void next(View v) {
        String s1 = goal1.getText().toString();
        String s2 = goal2.getText().toString();
        String s3 = goal3.getText().toString();
        String s4 = goal4.getText().toString();
        String s5 = goal5.getText().toString();

        // help on aivan alussa 0
        valueList[help] = s1;
        help++;
        valueList[help] = s2;
        help++;
        valueList[help] = s3;
        help++;
        valueList[help] = s4;
        help++;
        valueList[help] = s5;
        help++;

        goal1.setText("0");
        goal2.setText("0");
        goal3.setText("0");
        goal4.setText("0");
        goal5.setText("0");

        timeNumber++;
        if (timeNumber > 0) {
            previousButton.setEnabled(true);
        }

        if (timeNumber == timeList.length && dayNumber == 0) {
            dayNumber++;
            dayTitle.setText(dayList[dayNumber]);
            timeNumber = 0;
        }

        if (timeNumber == timeList.length - 1 && dayNumber == 1) {
            nextButton.setEnabled(false);
            readyButton.setVisibility(View.VISIBLE);
        }

        timeTitle.setText(timeList[timeNumber]);
    }

    public void ready(View v) {
        System.out.println("Valmis!");
        finish();
    }

    private void showHelpDialog(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Arvioi puhelimen käytön tarpeesi");
        builder.setMessage(R.string.set_goal_help_dialog_text);
        builder.setPositiveButton(s, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }
}
