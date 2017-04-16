package com.reactlibrary.instacapture.exception;

/**
 * Created by tarek on 5/17/16.
 */

/**
 * Throw this exception to know that screen capturing failed.
 */
public final class ScreenCapturingFailedException extends RuntimeException {

  public ScreenCapturingFailedException(Exception e) {
    super(e);
  }
}
