package com.example.administrator.storyapp.Quiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.storyapp.R;
import com.plattysoft.leonids.ParticleSystem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 07-06-2016.
 */
public class Quiz_Home extends AppCompatActivity implements View.OnClickListener {
  @Bind(R.id.start_button)
  TextView start;
  @Bind(R.id.quiz_heading)
  TextView quiz_head;
  @Bind(R.id.level_select)
  Spinner level;
  @Bind(R.id.Q_no)
  EditText num;
  @Bind(R.id.time)
  EditText time;
  @Bind(R.id.image)
  ImageView image;

  String Table_Name;
  String Level = "Beginner";
  String Ques_No = "10";
  String Time = "30";

  Animation translate;
  Animation in_from_left;
  int second = 5;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.quiz_home_screen);
    ButterKnife.bind(this);

    Intent data = getIntent();
    Table_Name = data.getStringExtra("NAME").toString();
    quiz_head.setText(Table_Name);
   /* if(Table_Name.equals("ECONOMICS"))
    {
      image.setImageResource(R.drawable.economics_icon);
    }
    else if(Table_Name.equals("CURRENT_AFFAIRS"))
    {
      image.setImageResource(R.drawable.current_affairs_icon);
    }
    else if(Table_Name.equals("FAMOUS_FACES"))
    {
      image.setImageResource(R.drawable.famous_faces_icon);
    }
    else if(Table_Name.equals("LOGO"))
    {
      image.setImageResource(R.drawable.logo_icon);
    }
    else if(Table_Name.equals("TECHNOLOGY"))
    {
      image.setImageResource(R.drawable.tech_icon);
    }
    else if(Table_Name.equals("PROGRAMMING"))
    {
      image.setImageResource(R.drawable.programming_icon);
    }*/



    List<String> quiz_level = new ArrayList<>();
    quiz_level.add("Beginner");
    quiz_level.add("Intermediate");
    quiz_level.add("Master");

    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, quiz_level);

    // Drop down layout style - list view with radio button
    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    // attaching data adapter to spinner
    level.setAdapter(arrayAdapter );

    level.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Level = item;
        Toast.makeText(getApplicationContext(),"Selected: " + Table_Name,Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

    in_from_left = AnimationUtils.loadAnimation(Quiz_Home.this,R.anim.anim_translate_in_left);


    Typeface custom_font = Typeface.createFromAsset(getAssets(),"font/ferro_rosso.ttf");
    start.setTypeface(custom_font);

    Typeface custom_font_1 = Typeface.createFromAsset(getAssets(),"font/waltograph_ui.ttf");
    start.setTypeface(custom_font_1);

    quiz_head.setTypeface(custom_font);

    start.setOnClickListener(this);
    Animation fade_anim = AnimationUtils.loadAnimation(Quiz_Home.this,R.anim.fade);
    start.startAnimation(fade_anim);
  }

  @Override
  public void onClick(View v) {
    int id = v.getId();
    switch(id)
    {
      case R.id.start_button :
        Ques_No = num.getText().toString();
        Time = time.getText().toString();
        Toast.makeText(this, "Selected: " + Table_Name +" " + Ques_No + "  "+Time, Toast.LENGTH_SHORT).show();
        Intent quiz_page = new Intent(this,Quiz_Page.class);
        quiz_page.putExtra("NAME",Table_Name);
        quiz_page.putExtra("LEVEL",Level);
        quiz_page.putExtra("QUES_NUM",Ques_No);
        quiz_page.putExtra("TIME",Time);
        startActivity(quiz_page);
    }
  }

  @Override
  protected void onPause() {
    super.onPause();
    finish();
  }
}
