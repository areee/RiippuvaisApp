package fi.uta.riippuvaisapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SetGoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);
    }

    public void showHelp(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Arvioi puhelimen käytön tarpeesi");
        builder.setMessage("Nyt tavoitteena on löytää <b>sinulle</b> sopiva tavoite puhelimen avauskertoihin.\n" +
                "Aloita tekemällä arvio siitä, kuinka paljon tarvitset puhelinta eri vuorokaudenaikoina.\n" +
                "\n" +
                "Mieti päiväsi kulkua. Kuinka monta kertaa tarvitset puhelinta seuraavina ajankohtina?");
        builder.setPositiveButton("Aloita", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }
}
