/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.camera;

import android.graphics.Rect;
import android.view.View;

import com.android.camera.ShutterButton.OnShutterButtonListener;


public interface PhotoController extends OnShutterButtonListener {
    int INIT = -1;
    int PREVIEW_STOPPED = 0;
    int IDLE = 1;  // preview is active
    // Focus is in progress. The exact focus state is in Focus.java.
    int FOCUSING = 2;
    int SNAPSHOT_IN_PROGRESS = 3;
    // Switching between cameras.
    int SWITCHING_CAMERA = 4;
    // Longshot mode
    int LONGSHOT = 5;

    // returns the actual set zoom value
    int onZoomChanged(int requestedZoom);

    void onZoomChanged(float requestedZoom);

    boolean isImageCaptureIntent();

    boolean isCameraIdle();

    void onCaptureDone();

    void onCaptureCancelled();

    void onCaptureRetake();

    void cancelAutoFocus();

    void stopPreview();

    int getCameraState();

    void onSingleTapUp(View view, int x, int y);

    void onCountDownFinished();

    void onScreenSizeChanged(int width, int height);

    void onPreviewRectChanged(Rect previewRect);

    void updateCameraOrientation();

    void enableRecordingLocation(boolean enable);

    /**
     * This is the callback when the UI or buffer holder for camera preview,
     * such as {@link android.graphics.SurfaceTexture}, is ready to be used.
     * The controller can start the camera preview after or in this callback.
     */
    void onPreviewUIReady();


    /**
     * This is the callback when the UI or buffer holder for camera preview,
     * such as {@link android.graphics.SurfaceTexture}, is being destroyed.
     * The controller should try to stop the preview in this callback.
     */
    void onPreviewUIDestroyed();
}
