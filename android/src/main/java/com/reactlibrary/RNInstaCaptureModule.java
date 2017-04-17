
package com.reactlibrary;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.view.View;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactlibrary.instacapture.InstaCapture;
import com.reactlibrary.instacapture.ShowScreenShotActivity;
import com.reactlibrary.instacapture.listener.SimpleScreenCapturingListener;
import com.reactlibrary.instacapture.utility.Utility;

import java.io.File;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

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

//    Toast.makeText(reactContext,"Screenshot saved to ",Toast.LENGTH_LONG).show();
    InstaCapture.getInstance(getCurrentActivity()).capture().setScreenCapturingListener(new SimpleScreenCapturingListener() {
      @Override public void onCaptureStarted() {
        super.onCaptureStarted();
      }

      @Override public void onCaptureComplete(Bitmap bitmap) {
//        Activity activity = getCurrentActivity();
        File file = Utility.saveBitmapToFile(getCurrentActivity(), bitmap);
        tookScreenShot(file.getAbsolutePath());
//        Toast.makeText(reactContext,"Screenshot saved to " + file.getAbsolutePath(),Toast.LENGTH_LONG).show();
      }
    });
  }

  private void tookScreenShot(String file) {
    WritableMap event = Arguments.createMap();
    event.putString("file_path", file);
    ReactContext reactContext = (ReactContext)getReactApplicationContext();
    reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit("ScreenShot", event);
  }
}

