package com.example.administrator.storyapp.Facebook_Data;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.storyapp.Main;
import com.example.administrator.storyapp.R;
import com.facebook.login.LoginManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 13-06-2016.
 */
public class LogoutActivity extends AppCompatActivity {
  private TextView btnLogout;
  private User user;
  private ImageView profileImage;
  Bitmap bitmap;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.logout_button);
    user=PrefUtils.getCurrentUser(LogoutActivity.this);
    profileImage= (ImageView) findViewById(R.id.profileImage);
// fetching facebook's profile picture
    new AsyncTask<Void,Void,Void>(){
      @Override
      protected Void doInBackground(Void... params) {
        URL imageURL = null;
        try {
          imageURL = new URL("https://graph.facebook.com/" + "1435767690067161" + "/picture?type=large");
        } catch (MalformedURLException e) {
          e.printStackTrace();
        }
        try {
          bitmap  = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());

        } catch (IOException e) {
          e.printStackTrace();
        }
        return null;
      }

      @Override
      protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        profileImage.setImageBitmap(bitmap);
      }
    }.execute();


    btnLogout = (TextView) findViewById(R.id.btnLogout);
    btnLogout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        PrefUtils.clearCurrentUser(LogoutActivity.this);


        // We can logout from facebook by calling following method
        LoginManager.getInstance().logOut();


        Intent i= new Intent(LogoutActivity.this,Main.class);
        startActivity(i);
        finish();
      }
    });
  }
}
