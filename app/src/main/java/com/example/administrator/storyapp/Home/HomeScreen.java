package com.example.administrator.storyapp.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.storyapp.Adapters.SubjectListAdapters;
import com.example.administrator.storyapp.Model.SubjectData;
import com.example.administrator.storyapp.Quiz.Quiz_Home;
import com.example.administrator.storyapp.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 05-06-2016.
 */
public class HomeScreen extends AppCompatActivity {

  ArrayList<SubjectData> subject = new ArrayList<>();
  ListView lvList;
  SubjectListAdapters subjectListAdapters;
  SubjectData subject_data;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home_choose_subjects);
    lvList = (ListView)findViewById(R.id.subject_data);
    subjectListAdapters = new SubjectListAdapters(subject,HomeScreen.this);
    lvList.setAdapter(subjectListAdapters);

    subject_data = new SubjectData("Economics","Beginner",R.drawable.economics_icon);
    subject.add(subject_data);
    subject_data = new SubjectData("Current Affairs","Beginner",R.drawable.current_affairs_icon);
    subject.add(subject_data);
    subject_data = new SubjectData("Famous Faces","Beginner",R.drawable.famous_faces_icon);
    subject.add(subject_data);
    subject_data = new SubjectData("Logo","Beginner",R.drawable.logo_icon);
    subject.add(subject_data);
    subject_data = new SubjectData("Technology","Beginner",R.drawable.tech_icon);
    subject.add(subject_data);
    subject_data = new SubjectData("Programming","Beginner",R.drawable.programming_icon);
    subject.add(subject_data);
    subject_data = new SubjectData("Simple Science","Beginner",R.drawable.science_icon);
    subject.add(subject_data);

    subjectListAdapters.notifyDataSetChanged();

    lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView s_name = (TextView)view.findViewById(R.id.SubjectName);
        String subject_name = s_name.getText().toString();
        if(subject_name.equals("Economics"))
        {
          startActivity(new Intent(HomeScreen.this, Quiz_Home.class).putExtra("NAME","ECONOMICS"));
        }
        else if(subject_name.equals("Current Affairs"))
        {
          startActivity(new Intent(HomeScreen.this, Quiz_Home.class).putExtra("NAME","CURRENT_AFFAIRS"));
        }
        else if(subject_name.equals("Famous Faces"))
        {
          startActivity(new Intent(HomeScreen.this, Quiz_Home.class).putExtra("NAME","FAMOUS_FACES"));
        }
        else if(subject_name.equals("Logo")) {
          startActivity(new Intent(HomeScreen.this, Quiz_Home.class).putExtra("NAME","LOGO"));
        }
        else if(subject_name.equals("Technology"))
        {
          startActivity(new Intent(HomeScreen.this, Quiz_Home.class).putExtra("NAME","TECHNOLOGY"));
        }
        else if(subject_name.equals("Programming"))
        {
          startActivity(new Intent(HomeScreen.this, Quiz_Home.class).putExtra("NAME","PROGRAMMING"));
        }

      }
    });

  }
}
