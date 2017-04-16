
package com.reactlibrary;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.view.View;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
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
  public void takeScreenShot(@Nullable View... views) {

    InstaCapture.getInstance(getCurrentActivity()).capture(views).setScreenCapturingListener(new SimpleScreenCapturingListener() {
      @Override public void onCaptureStarted() {
        super.onCaptureStarted();
      }

      @Override public void onCaptureComplete(Bitmap bitmap) {

        Utility.getScreenshotFileObservable(getCurrentActivity(), bitmap)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<File>() {
                  @Override public void call(File file) {
                    getCurrentActivity().startActivity(ShowScreenShotActivity.buildIntent(getCurrentActivity(),
                            file.getAbsolutePath()));
                  }
                });
      }
    });
  }
}

