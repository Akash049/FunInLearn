package com.example.administrator.storyapp.GCM;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by Administrator on 28-07-2016.
 */
public class GCMTokenRefreshListenerService extends InstanceIDListenerService {
  //If the token is changed registering the device again
  @Override
  public void onTokenRefresh() {
    Intent intent = new Intent(this, GCMRegistrationIntentService.class);
    startService(intent);
  }
}
