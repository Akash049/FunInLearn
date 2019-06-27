package com.example.administrator.storyapp.Quiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.storyapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 08-06-2016.
 */
public class ReadData extends AppCompatActivity {

  private TextView textView;
  public StringBuilder text = new StringBuilder();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.read_txt);
    BufferedReader reader = null;

    textView = (TextView)findViewById(R.id.txt);
    try {
      reader = new BufferedReader(
        new InputStreamReader(getAssets().open("data.txt")));

      // do reading, usually loop until end of file reading
      String mLine ;
      while ((mLine = reader.readLine()) != null) {
        text.append(mLine);
        text.append('\n');
      }
    } catch (IOException e) {
      Toast.makeText(getApplicationContext(), "Error reading file!", Toast.LENGTH_LONG).show();
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          //log the exception
        }
      }

    }
    textView.setText(text);


  }
}
