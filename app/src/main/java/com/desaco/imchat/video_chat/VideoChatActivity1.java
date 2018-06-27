package com.desaco.imchat.video_chat;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.desaco.imchat.R;
import com.desaco.imchat.video.CameraGLSurfaceView;

import java.io.IOException;


/**
 * <p>
 * Android OpenGL渲染双视频（类微信视频聊天）- https://github.com/296777513/AndroidOpenGL
 * 视频聊天的推流和拉流，两人视频和多人视频聊天实现
 *
 * 一个窗口播放视频，一个视频窗口推流(预览视频，推流)
 *
 * 大窗口播放视频，小视频窗口推流(预览视频，推流)
 */
public class VideoChatActivity1 extends Activity implements View.OnClickListener {

    CameraGLSurfaceView1 mCameraGLSurfaceView;
    Button mSwitchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mCameraGLSurfaceView = (CameraGLSurfaceView1) findViewById(R.id.camera_gl_surface_view);
        mSwitchBtn = (Button) findViewById(R.id.switch_camera);
        mSwitchBtn.setOnClickListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mCameraGLSurfaceView.bringToFront();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCameraGLSurfaceView.onPause();
        mCameraGLSurfaceView.pauseVideo();
        mCameraGLSurfaceView.startVideo();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCameraGLSurfaceView.stopAndReleaseVideo();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.switch_camera:
                mCameraGLSurfaceView.switchCamera();
                break;
            default:
                break;
        }
    }

}
