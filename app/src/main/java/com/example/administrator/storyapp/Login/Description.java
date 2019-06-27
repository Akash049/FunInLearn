package com.example.administrator.storyapp.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

import com.example.administrator.storyapp.R;

/**
 * Created by Administrator on 05-06-2016.
 */
public class Description extends AppCompatActivity {
  private ViewFlipper mViewFlipper;
  private float initialX;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.description_screen);
    mViewFlipper = (ViewFlipper)findViewById(R.id.flipper);
  }

  @Override
  public boolean onTouchEvent(MotionEvent touchevent) {
    switch (touchevent.getAction()) {
      case MotionEvent.ACTION_DOWN:
        initialX = touchevent.getX();
        break;
      case MotionEvent.ACTION_UP:
        float finalX = touchevent.getX();
        if (initialX > finalX) {
          if (mViewFlipper.getDisplayedChild() == 1)
            break;

 /*TruitonFlipper.setInAnimation(this, R.anim.in_right);
 TruitonFlipper.setOutAnimation(this, R.anim.out_left);*/

          mViewFlipper.showNext();
        } else {
          if (mViewFlipper.getDisplayedChild() == 0)
            break;

 /*TruitonFlipper.setInAnimation(this, R.anim.in_left);
 TruitonFlipper.setOutAnimation(this, R.anim.out_right);*/

          mViewFlipper.showPrevious();
        }
        break;
    }
    return false;
  }
}
