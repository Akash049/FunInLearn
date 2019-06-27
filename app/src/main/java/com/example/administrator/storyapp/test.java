package com.example.administrator.storyapp;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.storyapp.Quiz.DataBaseHandler;
import com.example.administrator.storyapp.Quiz.FillQuestions;
import com.example.administrator.storyapp.Quiz.Quiz_Data_Model;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 05-07-2016.
 */
public class test extends AppCompatActivity {
  @Bind(R.id.textView2)
  TextView ques;
  @Bind(R.id.textView3)
  TextView option1;
  @Bind(R.id.textView4)
  TextView option2;
  @Bind(R.id.textView5)
  TextView option3;
  @Bind(R.id.textView6)
  TextView option4;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test);
    ButterKnife.bind(this);
    DataBaseHandler db = new DataBaseHandler(this);
    final FillQuestions obj = new FillQuestions(db);
    Quiz_Data_Model quest;
    quest =db.GetQuestion_From_Table(1,"ECONOMICS_Level_1");
    ques.setText(quest.getQuestion());
    option1.setText(quest.getQ_Opt_1());
    option2.setText(quest.getQ_Opt_2());
    option3.setText(quest.getQ_Opt_3());
    option4.setText(quest.getQ_Opt_4());
  }
}
