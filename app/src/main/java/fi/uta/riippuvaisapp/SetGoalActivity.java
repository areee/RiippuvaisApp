package fi.uta.riippuvaisapp;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

    int dayNumber;
    int timeNumber;

    int values;
    String[] valueList;
    int helpValue;

    String FILENAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);

        timeList = new String[]{"Klo 06-09", "Klo 09-12", "Klo 12-15", "Klo 15-18", "Klo 18-21", "Klo 21-00", "Klo 00-06"};
        dayList = new String[]{"Arkipäivät ma-pe", "Viikonloppu la-su"};

        dayTitle = (TextView) findViewById(R.id.set_goal_weekday);
        dayNumber = 0;
        dayTitle.setText(dayList[dayNumber]);

        timeTitle = (TextView) findViewById(R.id.set_goal_title1);
        timeNumber = 0;
        timeTitle.setText(timeList[timeNumber]);

        goal1 = (EditText) findViewById(R.id.set_goal1);
        goal2 = (EditText) findViewById(R.id.set_goal2);
        goal3 = (EditText) findViewById(R.id.set_goal3);
        goal4 = (EditText) findViewById(R.id.set_goal4);
        goal5 = (EditText) findViewById(R.id.set_goal5);

        previousButton = (Button) findViewById(R.id.previous_button);
        previousButton.setEnabled(false);

        nextButton = (Button) findViewById(R.id.next_button);

        readyButton = (Button) findViewById(R.id.ready_button);
        readyButton.setVisibility(View.INVISIBLE);

        // 7 times in timeList * 5 goals to set * 2 day categories = 70 values
        values = 70;
        valueList = new String[values];

        helpValue = 0;

        FILENAME = "set_goal";

        showHelpDialog("Aloita");
    }

    // Question mark button that shows a help dialog when the button is clicked:
    public void showHelp(View v) {
        showHelpDialog("Sulje");
    }

    // When the next button is clicked, do several things:
    public void next(View v) {
        readAndSaveGoalValues();


        // When the values of goal text fields are in safe, the fields are cleared:
        goal1.setText(valueList[helpValue]);
        goal2.setText(valueList[helpValue + 1]);
        goal3.setText(valueList[helpValue + 2]);
        goal4.setText(valueList[helpValue + 3]);
        goal5.setText(valueList[helpValue + 4]);

        // 2) The set of goals is different (=a new time), so grow it with 1:
        timeNumber++;

        // 3) If timeNumber is not the 0th, a user can click previousButton:
        if (timeNumber > 0) {
            previousButton.setEnabled(true);
        }

        // 4) If timeNumber has grown over the last index of timeList and dayNumber is still 0:
        if (goingToAnotherSet()) {
            dayNumber++; // grow dayNumber
            dayTitle.setText(dayList[dayNumber]); // set a new title for dayTitle
            timeNumber = 0; // reset the value of timeNumber
        }

        // 5) If timeNumber equals the last index of timeList and dayNumber is 1,
        // the view should be the last:
        if (isLastView()) {
            nextButton.setEnabled(false); // nextButton can't be selected anymore (the last view)
            readyButton.setVisibility(View.VISIBLE); // readyButton is shown
        }

        // 6) Set the timeTitle according to the timeNumber index in timeList:
        // For example: the another set of goals -> timeNumber = 2, timeList[2] = "Klo 09-12"
        timeTitle.setText(timeList[timeNumber]);

        setFocusAndOpenSoftKeyboard();
    }

    private void setFocusAndOpenSoftKeyboard() {
        // Set the first text field ("goal1") focused and trigger the soft keyboard:
        goal1.requestFocus();

        final InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(goal1, InputMethodManager.SHOW_IMPLICIT);
    }

    private void readAndSaveGoalValues() {
        // 1.1) Collect values from goal text fields...:
        String s1 = goal1.getText().toString();
        String s2 = goal2.getText().toString();
        String s3 = goal3.getText().toString();
        String s4 = goal4.getText().toString();
        String s5 = goal5.getText().toString();

        // 1.2) ...and save them to valueList:
        valueList[helpValue] = s1; // in the beginning helpValue is 0
        helpValue++; // grow helpValue
        valueList[helpValue] = s2; // helpValue is 1
        helpValue++;
        valueList[helpValue] = s3; // helpValue is 2
        helpValue++;
        valueList[helpValue] = s4; // helpValue is 3
        helpValue++;
        valueList[helpValue] = s5; // helpValue is 4
        helpValue++; // next time helpValue is 5 etc.
    }

    private boolean goingToAnotherSet() {
        return timeNumber == timeList.length && dayNumber == 0;
    }

    private boolean isLastView() {
        return timeNumber == timeList.length - 1 && dayNumber == 1;
    }

    // When the previous button is clicked, do several things:
    public void previous(View v) {
        // "0") If a user has set new values to the goal text fields and presses the previous button,
        // the app still saves the values:

        // 0.1) Get the values of the goal text fields:
        String s1 = goal1.getText().toString();
        String s2 = goal2.getText().toString();
        String s3 = goal3.getText().toString();
        String s4 = goal4.getText().toString();
        String s5 = goal5.getText().toString();

        // 0.2) If some value(s) of the goal text fields is not empty, save these values to valueList:
        if (!s1.isEmpty() || !s2.isEmpty() || !s3.isEmpty() || !s4.isEmpty() || !s5.isEmpty()) {
            valueList[helpValue] = s1; // helpValue is for example 5
            valueList[helpValue + 1] = s2;// -"-                   6
            valueList[helpValue + 2] = s3;// -"-                   7
            valueList[helpValue + 3] = s4;// -"-                   8
            valueList[helpValue + 4] = s5;// -"-                   9
        }

        // 1) Shrink helpValue, get values from valueList and set that value to the goal text fields
        helpValue--; // for example 5 -> 4
        goal5.setText(valueList[helpValue]);
        helpValue--; // for example 4 -> 3
        goal4.setText(valueList[helpValue]);
        helpValue--; // for example 3 -> 2
        goal3.setText(valueList[helpValue]);
        helpValue--; // for example 2 -> 1
        goal2.setText(valueList[helpValue]);
        helpValue--; // for example 1 -> 0
        goal1.setText(valueList[helpValue]);

        // 2) The set of goals is different (=a new time), so shrink it with 1:
        timeNumber--;

        // 3) If the timeNumber is smaller than the last index of the timelist:
        if (timeNumber < timeList.length - 1) {
            nextButton.setEnabled(true); // nextButton is enabled
            readyButton.setVisibility(View.INVISIBLE); // readyButton is invisible
        }

        // 4) If timenumber has shrunk under zero and dayNumber is 1:
        if (timeNumber < 0 && dayNumber == 1) {
            dayNumber--; // shrink dayNumber to 0
            // set the dayTitle according to the index of the dayNumber in the dayList:
            dayTitle.setText(dayList[dayNumber]);
            timeNumber = timeList.length - 1; // set the timeNumber to the last index of the timeList
        }

        // 5) If the timeNumber equals 0 and the dayNumber equals also 0, we have returned in a very
        // first index of the views:
        if (timeNumber == 0 && dayNumber == 0) {
            previousButton.setEnabled(false); // the previousButton is disabled
        }
        // 6) The last thing: set the timeTitle according to the index of timeNumber in the timeList:
        timeTitle.setText(timeList[timeNumber]);

        setFocusAndOpenSoftKeyboard();
    }

    // When setting a goal is ready, readyButton can be clicked.
    // This means also saving the results in valueList to the internal storage using FileOutputStream:
    public void ready(View v) {
        readAndSaveGoalValues();

        String s = "";

        // This for-loop goes through the valueList
        // and saves each value to a string "s" in a single line:
        for (int i = 0; i < valueList.length; i++) {
            String s1 = valueList[i];
            s = s.concat(s1 + "\n"); // + "\n"
        }

        System.out.println(s);

        // Saves/writes the content in string "s" to the FILENAME ("set_goal") using FileOutputStream:
        try {
            FileOutputStream outputStream = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Tallennettu tiedostoon!");

        Toast toast = Toast.makeText(getApplicationContext(), "Tavoite tallennettu!", Toast.LENGTH_SHORT);
        toast.show();

        finish();
    }

    // A method for showing a help dialog:
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
