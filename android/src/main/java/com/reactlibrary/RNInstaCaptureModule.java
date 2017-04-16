
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.reactlibrary.instacapture.InstaCapture;

public class RNInstaCaptureModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNInstaCaptureModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNInstaCapture";
  }

  @ReactMethod
  public void takeScreenShot() {

    InstaCapture.getInstance(getCurrentActivity()).capture();
  }
}

