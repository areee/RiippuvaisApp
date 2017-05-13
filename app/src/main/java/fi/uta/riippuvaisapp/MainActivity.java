package fi.uta.riippuvaisapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String PREFS_NAME = "FileForSharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // hampurilaisvalikko:
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // oikean alanurkan kalenterinappi:
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Tästä pääsee kalenteriin (ei toteutettu demo-versioon!)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // lisää juttuja hampurilaisvalikkoon:
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    // hampurilaisvalikon juttuja:
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // action bar -valikko:
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // action bar -valikossa valittu kohteita:
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            System.out.println("Tietoja on painettu.");

            new AlertDialog.Builder(this)
                    .setTitle(R.string.app_name)
                    .setMessage(R.string.about_app_message)
                    .setIcon(R.mipmap.ic_launcher_phone_icon)
                    .setNegativeButton("Sovelluksen lähdekoodi", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("https://github.com/areee/RiippuvaisApp"));
                            startActivity(intent);
                        }
                    })
                    .setPositiveButton("Sulje", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // hampurilaisvalikon kohteita valittu:
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation timeNumber item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

//        if (id == R.id.nav_home) {
//            System.out.println("Kotiin valittu");
//
//        } else

        if (id == R.id.nav_facts) {
            Intent intent = new Intent(getApplicationContext(), FactActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_exercises) {
            Intent intent = new Intent(getApplicationContext(), ExerciseActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_read_data) {
            Intent intent = new Intent(getApplicationContext(), ReadDataActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_go_to_summary) {
            SharedPreferences exerciseStatus = getSharedPreferences(PREFS_NAME, 0);
            boolean setGoalDone = exerciseStatus.getBoolean("setGoalDone", false);

            if (setGoalDone) {
                startActivity(new Intent(getApplicationContext(), SummaryActivity.class));
            } else {
                Toast.makeText(getApplicationContext(), "Aseta tavoite ennen kuin pääset tarkastelemaan suoraan yhteenvetoa!", Toast.LENGTH_LONG).show();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void exercisesClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), ExerciseActivity.class);
        startActivity(intent);
    }

    public void setGoalClicked(View v) {
        SharedPreferences exerciseStatus = getSharedPreferences(PREFS_NAME, 0);
        boolean exercise1Done = exerciseStatus.getBoolean("exercise1Done", false);
        boolean exercise2Done = exerciseStatus.getBoolean("exercise2Done", false);
        boolean exercise3Done = exerciseStatus.getBoolean("exercise3Done", false);
        boolean exercise4Done = exerciseStatus.getBoolean("exercise4Done", false); // not necessary in the demo version

        if (exercise1Done && exercise2Done && exercise3Done) {

            Intent intent = new Intent(getApplicationContext(), RecallActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Tee tehtävät 1-3 ennen kuin asetat tavoitteen!", Toast.LENGTH_LONG).show();
        }
    }

    public void factsCliked(View view) {
        Intent intent = new Intent(getApplicationContext(), FactActivity.class);
        startActivity(intent);
    }

    public void settingsClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(intent);
    }
}
