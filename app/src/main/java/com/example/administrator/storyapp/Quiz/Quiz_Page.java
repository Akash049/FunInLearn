package com.example.administrator.storyapp.Quiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.administrator.storyapp.Login.Description;
import com.example.administrator.storyapp.R;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 07-06-2016.
 */
public class Quiz_Page extends AppCompatActivity implements View.OnClickListener{

  @Bind(R.id.question)
  TextView Question;
  @Bind(R.id.o1)
  Button Option1;
  @Bind(R.id.o2)
  Button Option2;
  @Bind(R.id.o3)
  Button Option3;
  @Bind(R.id.o4)
  Button Option4;
  @Bind(R.id.prev_button)
  ImageButton previous;
  @Bind(R.id.next_button)
  ImageButton next;
  @Bind(R.id.total)
  TextView total;
  @Bind(R.id.timer)
  TextView count;

  String Answer;
  int Answer_id;
  String sec;
  Quiz_Data_Model quest;
  int ques_num = 1;
  int Total = 0;
  Animation shake;
  Animation in_from_left,in_from_right,in_from_top;
  String Subject_Name;
  String Level;
  int No_of_Ques;
  int time;
  DataBaseHandler db;
  String Table_Name = "Level_1";
  Timer timer;
  public int second = 20;
  public int min = 10;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
      WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.quiz_game_screen);
    ButterKnife.bind(this);
    //Defining Functions for different purposes
    Set_animations();
    Set_Fonts();

    Intent data = getIntent();
    Subject_Name = data.getStringExtra("NAME");
    Level = data.getStringExtra("LEVEL");
    time = Integer.parseInt(data.getStringExtra("TIME"));
    No_of_Ques = Integer.parseInt(data.getStringExtra("QUES_NUM"));
    second = time;
    if(Subject_Name.equals("ECONOMICS"))
    {
      Table_Name = "ECONOMICS_Level_1";
    }
    else if(Subject_Name.equals("PROGRAMMING"))
    {
      Table_Name = "PROGRAMMING_Level_1";
    }

    //Registering for the Onclicklisterner to respond
    Option1.setOnClickListener(this);
    Option2.setOnClickListener(this);
    Option3.setOnClickListener(this);
    Option4.setOnClickListener(this);

    //------------------------------------------------

    db = new DataBaseHandler(this);
    final FillQuestions obj = new FillQuestions(db);

    Log.d("Insert","Inserting...");
    //SetQuizQuestions(db);

    // Setting up the first question for the screen
    quest = db.GetQuestion_From_Table(ques_num,Table_Name);
    Question.setText(quest.getQuestion());
    Answer = quest.getAnswer();
    Option1.setText(quest.getQ_Opt_1());
    if(quest.getQ_Opt_1().equals(Answer))
    {

      Answer_id = Option1.getId();
    }
    Option2.setText(quest.getQ_Opt_2());
    if(quest.getQ_Opt_2().equals(Answer))
    {

      Answer_id = Option2.getId();
    }
    Option3.setText(quest.getQ_Opt_3());
    if(quest.getQ_Opt_3().equals(Answer))
    {
      Answer_id = Option3.getId();

    }
    Option4.setText(quest.getQ_Opt_4());
    if(quest.getQ_Opt_3().equals(Answer))
    {
      Answer_id = Option4.getId();

    }


    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        runOnUiThread(new Runnable() {
          @Override
          public void run() {
            sec = second/10 >= 1 ? (String.valueOf(second)) : ("0"+String.valueOf(second));
            count.setText("00:" + sec);

            if(second == 0)
            {
              second=time;
              Toast.makeText(Quiz_Page.this,"Time`s Up",Toast.LENGTH_SHORT).show();
              Change_Question_Next();

            }
            second-=1;
          }
        });
      }
    },0,1000);


    next.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Change_Question_Next();
      }
    });
    previous.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Change_Question_Prev();
      }
    });


  }

  private void Change_Question_Prev() {
    Option1.setBackgroundResource(R.drawable.purple_button);
    Option2.setBackgroundResource(R.drawable.purple_button);
    Option3.setBackgroundResource(R.drawable.purple_button);
    Option4.setBackgroundResource(R.drawable.purple_button);

    if((ques_num - 1) >0) {
      second = time;
      ques_num--;
      quest = db.GetQuestion_From_Table(ques_num,Table_Name);
      Question.setText(quest.getQuestion());
      Answer = quest.getAnswer();
      Option1.setText(quest.getQ_Opt_1());
      if(quest.getQ_Opt_1().equals(Answer))
      {

        Answer_id = Option1.getId();
      }
      Option2.setText(quest.getQ_Opt_2());
      if(quest.getQ_Opt_2().equals(Answer))
      {

        Answer_id = Option2.getId();
      }
      Option3.setText(quest.getQ_Opt_3());
      if(quest.getQ_Opt_3().equals(Answer))
      {

        Answer_id = Option3.getId();
      }
      Option4.setText(quest.getQ_Opt_4());
      if(quest.getQ_Opt_4().equals(Answer))
      {

        Answer_id = Option4.getId();
      }
    }
    else
    {
      Toast.makeText(getApplicationContext(),"No More Questios before",Toast.LENGTH_SHORT).show();
    }
  }

  private void Set_Fonts() {
    //Setting up the font style
    Typeface custom_font = Typeface.createFromAsset(getAssets(),"font/strawberry_muffins.ttf");
    Question.setTypeface(custom_font);
    Option1.setTypeface(custom_font);
    Option2.setTypeface(custom_font);
    Option3.setTypeface(custom_font);
    Option4.setTypeface(custom_font);
  }

  private void Set_animations() {
    in_from_left = AnimationUtils.loadAnimation(Quiz_Page.this,R.anim.anim_translate_in_left);
    in_from_right = AnimationUtils.loadAnimation(Quiz_Page.this,R.anim.anim_translate_in_right);
    in_from_top = AnimationUtils.loadAnimation(Quiz_Page.this,R.anim.anim_translate_in_up);
    shake = AnimationUtils.loadAnimation(Quiz_Page.this,R.anim.shake_2);
  }

  private void Change_Question_Next() {

    Toast.makeText(getApplicationContext(),"Function Called",Toast.LENGTH_SHORT).show();
    Option1.setBackgroundResource(R.drawable.purple_button);
    Option2.setBackgroundResource(R.drawable.purple_button);
    Option3.setBackgroundResource(R.drawable.purple_button);
    Option4.setBackgroundResource(R.drawable.purple_button);
    if((ques_num + 1) < 10) {

      Option1.startAnimation(in_from_left);
      Option2.startAnimation(in_from_right);
      Option3.startAnimation(in_from_left);
      Option4.startAnimation(in_from_right);
      Question.startAnimation(in_from_top);

      ques_num++;
      second=time;
      quest = db.GetQuestion_From_Table(ques_num,Table_Name);
      Question.setText(quest.getQuestion());
      Answer = quest.getAnswer();
      Option1.setText(quest.getQ_Opt_1());
      if(quest.getQ_Opt_1().equals(Answer))
      {

        Answer_id = Option1.getId();
      }
      Option2.setText(quest.getQ_Opt_2());
      if(quest.getQ_Opt_2().equals(Answer))
      {

        Answer_id = Option2.getId();
      }
      Option3.setText(quest.getQ_Opt_3());
      if(quest.getQ_Opt_3().equals(Answer))
      {

        Answer_id = Option3.getId();
      }
      Option4.setText(quest.getQ_Opt_4());
      if(quest.getQ_Opt_4().equals(Answer))
      {

        Answer_id = Option4.getId();
      }
    }
    else
    {
      Toast.makeText(getApplicationContext(),"No More Questios ahead",Toast.LENGTH_SHORT).show();
      timer.cancel();
      Intent score = new Intent(Quiz_Page.this,Score_Board.class);
      score.putExtra("TOTAL_SCORE",String.valueOf(Total));
      score.putExtra("TOTAL_QUESTION","10");
      startActivity(score);
    }

  }




  @Override
  public void onClick(View v) {
    final int id = v.getId();
    if(id == Answer_id) {
      Total++;
      total.setText("Total : " + Total);
      v.setBackgroundResource(R.drawable.green_button);
      Timer buttonTimer = new Timer();
      buttonTimer.schedule(new TimerTask() {

        @Override
        public void run() {
          runOnUiThread(new Runnable() {

            @Override
            public void run() {
              Change_Question_Next();
            }
          });
        }
      }, 1500);


    }
    else
    {
      Button wrong = (Button)findViewById(id);
      wrong.startAnimation(shake);
      v.setBackgroundResource(R.drawable.red_button);
      Button right = (Button)findViewById(Answer_id);
      right.setBackgroundResource(R.drawable.green_button);
      Timer buttonTimer = new Timer();
      buttonTimer.schedule(new TimerTask() {

        @Override
        public void run() {
          runOnUiThread(new Runnable() {

            @Override
            public void run() {
              Change_Question_Next();
            }
          });
        }
      }, 1500);


    }

  }

  @Override
  protected void onPause() {
    super.onPause();
    finish();
  }
}
