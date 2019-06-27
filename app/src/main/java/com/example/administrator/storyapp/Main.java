package com.example.administrator.storyapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.storyapp.Facebook_Data.User;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by Administrator on 10-06-2016.
 */
public class Main extends Activity {
  private CallbackManager callbackManager;
  private LoginButton loginButton;
  private TextView btnLogin;
  private ProgressDialog progressDialog;
  FacebookActivity facebook;

  User user;
  // Your Facebook APP ID
  private static String APP_ID = "1707992566116490"; // Replace your App ID here

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Initialize SDK before setContentView(Layout ID)
    FacebookSdk.sdkInitialize(getApplicationContext());
    setContentView(R.layout.main);

    loginButton = (LoginButton) findViewById(R.id.login_button);

    loginButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        // Call private method
        onFblogin();
      }
    });
  }


  // Private method to handle Facebook login and callback
  private void onFblogin() {
    callbackManager = CallbackManager.Factory.create();

    // Set permissions
    LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "user_photos", "public_profile"));

    LoginManager.getInstance().registerCallback(callbackManager,
      new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {

          System.out.println("Success");
          GraphRequest.newMeRequest(
            loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
              @Override
              public void onCompleted(JSONObject json, GraphResponse response) {
                if (response.getError() != null) {
                  // handle error
                  System.out.println("ERROR");
                } else {
                  System.out.println("Success");
                  try {

                    String jsonresult = String.valueOf(json);
                    System.out.println("JSON Result" + jsonresult);

                    String str_email = json.getString("email");
                    String str_id = json.getString("id");
                    String str_firstname = json.getString("first_name");
                    String str_lastname = json.getString("last_name");

                  } catch (JSONException e) {
                    e.printStackTrace();
                  }
                }
              }

            }).executeAsync();

        }

        @Override
        public void onCancel() {
          // Log.d(TAG_CANCEL,"On cancel");
        }

        @Override
        public void onError(FacebookException error) {
          // Log.d(TAG_ERROR,error.toString());
        }
      });
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    callbackManager.onActivityResult(requestCode, resultCode, data);
  }
}
