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
    TextView weekday;
    TextView title1;
    EditText text1;
    EditText text2;
    EditText text3;
    EditText text4;
    EditText text5;
    Button previous;
    Button next;
    Button ready;
    String[] list1;
    int view;
    String[] list2;
    int view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);

        weekday = (TextView) findViewById(R.id.set_goal_weekday);
        title1 = (TextView) findViewById(R.id.set_goal_title1);
        text1 = (EditText) findViewById(R.id.set_goal1);
        text2 = (EditText) findViewById(R.id.set_goal2);
        text3 = (EditText) findViewById(R.id.set_goal3);
        text4 = (EditText) findViewById(R.id.set_goal4);
        text5 = (EditText) findViewById(R.id.set_goal5);
        previous = (Button) findViewById(R.id.previous_button);
        next = (Button) findViewById(R.id.next_button);
        ready = (Button) findViewById(R.id.ready_button);

        list1 = new String[]{"Klo 06-09", "Klo 09-12", "Klo 12-15", "Klo 15-18", "Klo 18-21", "Klo 21-00", "Klo 00-06"};
        list2 = new String[]{"Arkipäivät ma-pe", "Viikonloppu la-su"};
        view = 0;
        previous.setEnabled(false);
        ready.setVisibility(View.INVISIBLE);
        title1.setText(list1[view]);
        view2 = 0;
        weekday.setText(list2[view2]);

        showHelpDialog("Aloita");
    }

    public void showHelp(View view) {
        showHelpDialog("Sulje");
    }

    public void previous(View v) {
        view--;

        if (view < list1.length - 1) {
            next.setEnabled(true);
            ready.setVisibility(View.INVISIBLE);
        }

        if (view < 0 && view2 == 1) {
            view2--;
            weekday.setText(list2[view2]);
            view = list1.length - 1;
        }

        if (view == 0 && view2 == 0) {
            previous.setEnabled(false);
        }

        title1.setText(list1[view]);
    }

    public void next(View v) {
        view++;
        if (view > 0) {
            previous.setEnabled(true);
        }

        if (view == list1.length && view2 == 0) {
            view2++;
            weekday.setText(list2[view2]);
            view = 0;
        }

        if (view == list1.length - 1 && view2 == 1) {
            next.setEnabled(false);
            ready.setVisibility(View.VISIBLE);
        }

        title1.setText(list1[view]);
    }

    public void ready(View v) {
        System.out.println("Valmis!");
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
