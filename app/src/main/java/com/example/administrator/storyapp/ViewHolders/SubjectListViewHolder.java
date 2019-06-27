package com.example.administrator.storyapp.ViewHolders;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.storyapp.Model.SubjectData;
import com.example.administrator.storyapp.R;

/**
 * Created by Administrator on 01-07-2016.
 */
public class SubjectListViewHolder extends LinearLayout {

  SubjectData data;
  Context context;

  public SubjectListViewHolder(Context context) {
    super(context);
    this.context = context;
    setup();
  }

  public SubjectListViewHolder(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.context = context;
    setup();
  }

  private void setup() {
    LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.subject_display_box,this);
  }

  public void Set_Subject(SubjectData data)
  {
    ImageView img = (ImageView)findViewById(R.id.subject_image);
    TextView Name = (TextView)findViewById(R.id.SubjectName);
    TextView Level = (TextView)findViewById(R.id.Level);

    Name.setText(data.getSubjectName());
    Level.setText("Level : "+ data.getSubjectLevel());
    img.setImageResource(data.getImageId());

  }

}
