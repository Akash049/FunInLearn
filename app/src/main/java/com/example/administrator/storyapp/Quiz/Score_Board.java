package com.example.administrator.storyapp.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.storyapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 07-06-2016.
 */
public class Score_Board extends AppCompatActivity {
  @Bind(R.id.no_of_ques)
  TextView no_of_ques;
  @Bind(R.id.no_of_ques_attempted)
  TextView attempted;
  @Bind(R.id.no_of_ques_correct)
  TextView correct;
  @Bind(R.id.no_of_ques_wrong)
  TextView wrong;
  @Bind(R.id.Accuracy)
  TextView accuracy;

  Animation in_from_top;

  int Total_score;
  int Total_question;
  float accu;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.quiz_score_board);
    ButterKnife.bind(this);

    in_from_top = AnimationUtils.loadAnimation(this,R.anim.anim_translate_in_up);


    Intent data =  getIntent();
    Total_score = Integer.parseInt(data.getStringExtra("TOTAL_SCORE"));
    Total_question = Integer.parseInt(data.getStringExtra("TOTAL_QUESTION"));
    accu = (int)Total_score/Total_question*100;

    Toast.makeText(getApplicationContext(),"Accuracy : " + String.valueOf(accu),Toast.LENGTH_SHORT ).show();




    no_of_ques.setText(String.valueOf(Total_question));
    attempted.setText(String.valueOf(Total_question));
    correct.setText(String.valueOf(Total_score));
    wrong.setText(String.valueOf(Total_question-Total_score));
    accuracy.setText(String.valueOf((accu))  + "%");



  }
}
