package fi.uta.riippuvaisapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ReadDataActivity extends AppCompatActivity {
    String FILENAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);

        TextView textView = (TextView) findViewById(R.id.read_data_textview);

        FILENAME = "set_goal";
        int ch;
        StringBuffer fileContent = new StringBuffer("");
        FileInputStream fis;

        try {
            fis = openFileInput(FILENAME);
            while ((ch = fis.read()) != -1) {
                fileContent.append((char) ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String data = new String(fileContent);
        System.out.println(data);
        System.out.println("Data luettu!");
        textView.setText(data);

//        StringBuilder stringBuilder = new StringBuilder();

//        try {
//            fileInputStream = openFileInput(FILENAME);
//            fileInputStream.read();
//
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
//            String s = null;
//            while ((s = bufferedReader.readLine()) != null) {
//                stringBuilder.append(s).append("\n");
//            }
//            fileInputStream.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        String result = stringBuilder.toString();

//        textView.setText(result);
//        System.out.println(result);
    }
}
