package com.example.administrator.storyapp.Login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.storyapp.GCM.GCMRegistrationIntentService;
import com.example.administrator.storyapp.Home.HomeScreen;
import com.example.administrator.storyapp.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import java.util.Timer;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 05-06-2016.
 */
public class splash extends AppCompatActivity{
  //Creating a broadcast receiver for gcm registration
  private BroadcastReceiver mRegistrationBroadcastReceiver;
  @Bind(R.id.textView)
  TextView logo;
  int sec = 1000;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
      WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.splash);
    ButterKnife.bind(this);
    //Initializing our broadcast receiver
    mRegistrationBroadcastReceiver = new BroadcastReceiver() {
      //When the broadcast received
      //We are sending the broadcast from GCMRegistrationIntentService

      @Override
      public void onReceive(Context context, Intent intent) {
        //If the broadcast has received with success
        //that means device is registered successfully
        if(intent.getAction().equals(GCMRegistrationIntentService.REGISTRATION_SUCCESS)){
          //Getting the registration token from the intent
          String token = intent.getStringExtra("token");
          //Displaying the token as toast
          Toast.makeText(getApplicationContext(), "Registration token:" + token, Toast.LENGTH_LONG).show();
          Log.d("Registration token:",token);

          //if the intent is not with success then displaying error messages
        } else if(intent.getAction().equals(GCMRegistrationIntentService.REGISTRATION_ERROR)){
          Toast.makeText(getApplicationContext(), "GCM registration error!", Toast.LENGTH_LONG).show();
        } else {
          Toast.makeText(getApplicationContext(), "Error occurred", Toast.LENGTH_LONG).show();
        }
      }
    };
    //Checking play service is available or not
    int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());

    //if play service is not available
    if(ConnectionResult.SUCCESS != resultCode) {
      //If play service is supported but not installed
      if(GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
        //Displaying message that play service is not installed
        Toast.makeText(getApplicationContext(), "Google Play Service is not install/enabled in this device!", Toast.LENGTH_LONG).show();
        GooglePlayServicesUtil.showErrorNotification(resultCode, getApplicationContext());

        //If play service is not supported
        //Displaying an error message
      } else {
        Toast.makeText(getApplicationContext(), "This device does not support for Google Play Service!", Toast.LENGTH_LONG).show();
      }

      //If play service is available
    } else {
      //Starting intent to register device
      Intent itent = new Intent(this, GCMRegistrationIntentService.class);
      startService(itent);
    }

    Typeface quiz_font = Typeface.createFromAsset(getAssets(),"font/angelina.TTF");
    logo.setTypeface(quiz_font);

    Thread timer = new Thread()
    {
      public void run()
      {
        try{
          // This is to make the thread sleep for 3sec
          sleep(3*sec);

          //Then start the activity
          startActivity(new Intent(splash.this,HomeScreen.class));

          // Remove this activity
          finish();

        }
        catch (Exception e){

        }
      }
    };
    timer.start();
  }

  //Registering receiver on activity resume
  @Override
  protected void onResume() {
    super.onResume();
    Log.w("MainActivity", "onResume");
    LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
      new IntentFilter(GCMRegistrationIntentService.REGISTRATION_SUCCESS));
    LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
      new IntentFilter(GCMRegistrationIntentService.REGISTRATION_ERROR));
  }


  @Override
  protected void onPause() {
    super.onPause();
    Log.w("MainActivity", "onPause");
    LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
  }
}
