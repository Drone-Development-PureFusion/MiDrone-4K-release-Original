package com.fimi.soul.media.player.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.p001v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.fimi.p139b.C2110f;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.media.player.FimiMediaPlayer;
import com.fimi.soul.media.player.IMediaPlayer;
import com.fimi.soul.media.player.widget.FmMediaController;
import com.fimi.soul.media.player.widget.IRenderView;
import com.fimi.soul.module.droneFragment.View$OnTouchListenerC3156b;
import com.fimi.soul.utils.C3676e;
import com.fimi.soul.utils.C3681j;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class FimiVideoView extends FrameLayout implements FmMediaController.MediaPlayerControl {
    public static final int RENDER_NONE = 0;
    public static final int RENDER_SURFACE_VIEW = 1;
    public static final int RENDER_TEXTURE_VIEW = 2;
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private static final int[] s_allAspectRatio = {0, 1, 2, 3, 4, 5};
    private String liveUrl;
    private Context mAppContext;
    private boolean mCanSeekBack;
    private boolean mCanSeekForward;
    private int mCurrentBufferPercentage;
    private OnFimiFileCallBackListener mFimiFileCallBackListener;
    private Map<String, String> mHeaders;
    private IMediaController mMediaController;
    private IMediaPlayer.OnCompletionListener mOnCompletionListener;
    private IMediaPlayer.OnErrorListener mOnErrorListener;
    private IMediaPlayer.OnInfoListener mOnInfoListener;
    View$OnTouchListenerC3156b.AbstractC3162c mOnLiveVideoCallBackListener;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener;
    private OnFimiPreviewCallBackListener mPreviewCallBackListener;
    private IRenderView mRenderView;
    private int mSeekWhenPrepared;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private Paint paint;
    private String TAG = "IjkVideoView";
    private int mCurrentState = 0;
    private int mTargetState = 0;
    private IRenderView.ISurfaceHolder mSurfaceHolder = null;
    private IMediaPlayer mMediaPlayer = null;
    private boolean mCanPause = true;
    private int decodeType = 0;
    IMediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.fimi.soul.media.player.widget.FimiVideoView.1
        @Override // com.fimi.soul.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            FimiVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
            FimiVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
            FimiVideoView.this.mVideoSarNum = iMediaPlayer.getVideoSarNum();
            FimiVideoView.this.mVideoSarDen = iMediaPlayer.getVideoSarDen();
            if (FimiVideoView.this.mVideoWidth == 0 || FimiVideoView.this.mVideoHeight == 0) {
                return;
            }
            if (FimiVideoView.this.mRenderView != null) {
                FimiVideoView.this.mRenderView.setVideoSize(FimiVideoView.this.mVideoWidth, FimiVideoView.this.mVideoHeight);
                FimiVideoView.this.mRenderView.setVideoSampleAspectRatio(FimiVideoView.this.mVideoSarNum, FimiVideoView.this.mVideoSarDen);
            }
            FimiVideoView.this.requestLayout();
        }
    };
    IMediaPlayer.OnPreparedListener mPreparedListener = new IMediaPlayer.OnPreparedListener() { // from class: com.fimi.soul.media.player.widget.FimiVideoView.2
        @Override // com.fimi.soul.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            FimiVideoView.this.mCurrentState = 2;
            if (FimiVideoView.this.mOnPreparedListener != null) {
                FimiVideoView.this.mOnPreparedListener.onPrepared(FimiVideoView.this.mMediaPlayer);
            }
            if (FimiVideoView.this.mMediaController != null) {
                FimiVideoView.this.mMediaController.setEnabled(true);
            }
            FimiVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
            FimiVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
            int i = FimiVideoView.this.mSeekWhenPrepared;
            if (i != 0) {
                FimiVideoView.this.seekTo(i);
            }
            if (FimiVideoView.this.mVideoWidth == 0 || FimiVideoView.this.mVideoHeight == 0) {
                if (FimiVideoView.this.mTargetState == 3) {
                    FimiVideoView.this.start();
                }
            } else if (FimiVideoView.this.mRenderView != null) {
                FimiVideoView.this.mRenderView.setVideoSize(FimiVideoView.this.mVideoWidth, FimiVideoView.this.mVideoHeight);
                FimiVideoView.this.mRenderView.setVideoSampleAspectRatio(FimiVideoView.this.mVideoSarNum, FimiVideoView.this.mVideoSarDen);
                if (!FimiVideoView.this.mRenderView.shouldWaitForResize() || (FimiVideoView.this.mSurfaceWidth == FimiVideoView.this.mVideoWidth && FimiVideoView.this.mSurfaceHeight == FimiVideoView.this.mVideoHeight)) {
                    if (FimiVideoView.this.mTargetState == 3) {
                        FimiVideoView.this.start();
                        if (FimiVideoView.this.mMediaController != null) {
                            FimiVideoView.this.mMediaController.show();
                        }
                    } else if (!FimiVideoView.this.isPlaying() && ((i != 0 || FimiVideoView.this.getCurrentPosition() > 0) && FimiVideoView.this.mMediaController != null)) {
                        FimiVideoView.this.mMediaController.show(0);
                    }
                }
            }
            if (iMediaPlayer.getDataSource().contains("rtsp:")) {
                FimiVideoView.this.getHandler().sendEmptyMessage(0);
                Intent intent = new Intent("resetRTSP");
                intent.putExtra("rtsp", 0);
                FimiVideoView.this.mAppContext.sendBroadcast(intent);
            }
            if (FimiVideoView.this.mPreviewCallBackListener != null) {
                FimiVideoView.this.startFlightVideo(C3681j.m7464o(), 5, 10);
            }
        }

        @Override // com.fimi.soul.media.player.IMediaPlayer.OnPreparedListener
        public void onStartStream() {
            if (FimiVideoView.this.mOnPreparedListener != null) {
                FimiVideoView.this.mOnPreparedListener.onStartStream();
            }
        }
    };
    private IMediaPlayer.OnCompletionListener mCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: com.fimi.soul.media.player.widget.FimiVideoView.3
        @Override // com.fimi.soul.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer, int i) {
            FimiVideoView.this.mCurrentState = 5;
            FimiVideoView.this.mTargetState = 5;
            if (FimiVideoView.this.mMediaController != null) {
                FimiVideoView.this.mMediaController.hide();
            }
            if (FimiVideoView.this.mOnCompletionListener != null) {
                FimiVideoView.this.mOnCompletionListener.onCompletion(FimiVideoView.this.mMediaPlayer, i);
            }
            if (FimiVideoView.this.mPreviewCallBackListener != null) {
                FimiVideoView.this.mPreviewCallBackListener.onCompletion(i);
            }
        }
    };
    private IMediaPlayer.OnInfoListener mInfoListener = new IMediaPlayer.OnInfoListener() { // from class: com.fimi.soul.media.player.widget.FimiVideoView.4
        @Override // com.fimi.soul.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            if (FimiVideoView.this.mOnInfoListener != null) {
                FimiVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, i, i2);
            }
            switch (i) {
                case IMediaPlayer.MEDIA_INFO_VIDEO_ROTATION_CHANGED /* 10001 */:
                    FimiVideoView.this.mVideoRotationDegree = i2;
                    Log.d(FimiVideoView.this.TAG, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                    if (FimiVideoView.this.mRenderView == null) {
                        return true;
                    }
                    FimiVideoView.this.mRenderView.setVideoRotation(i2);
                    return true;
                default:
                    return true;
            }
        }
    };
    private IMediaPlayer.OnErrorListener mErrorListener = new IMediaPlayer.OnErrorListener() { // from class: com.fimi.soul.media.player.widget.FimiVideoView.5
        @Override // com.fimi.soul.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            Log.d(FimiVideoView.this.TAG, "Error: " + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
            FimiVideoView.this.mCurrentState = -1;
            FimiVideoView.this.mTargetState = -1;
            if (FimiVideoView.this.mMediaController != null) {
                FimiVideoView.this.mMediaController.hide();
            }
            if (iMediaPlayer.getDataSource().contains("rtsp:")) {
                Intent intent = new Intent("resetRTSP");
                intent.putExtra("rtsp", 1);
                FimiVideoView.this.mAppContext.sendBroadcast(intent);
            }
            return FimiVideoView.this.mOnErrorListener != null && FimiVideoView.this.mOnErrorListener.onError(FimiVideoView.this.mMediaPlayer, i, i2);
        }
    };
    private IMediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.fimi.soul.media.player.widget.FimiVideoView.6
        @Override // com.fimi.soul.media.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            FimiVideoView.this.mCurrentBufferPercentage = i;
        }
    };
    IRenderView.IRenderCallback mSHCallback = new IRenderView.IRenderCallback() { // from class: com.fimi.soul.media.player.widget.FimiVideoView.7
        @Override // com.fimi.soul.media.player.widget.IRenderView.IRenderCallback
        public void onSurfaceChanged(@NonNull IRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2, int i3) {
            boolean z = false;
            if (iSurfaceHolder.getRenderView() != FimiVideoView.this.mRenderView) {
                Log.e(FimiVideoView.this.TAG, "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            FimiVideoView.this.mSurfaceWidth = i2;
            FimiVideoView.this.mSurfaceHeight = i3;
            boolean z2 = FimiVideoView.this.mTargetState == 3;
            if (!FimiVideoView.this.mRenderView.shouldWaitForResize() || (FimiVideoView.this.mVideoWidth == i2 && FimiVideoView.this.mVideoHeight == i3)) {
                z = true;
            }
            if (FimiVideoView.this.mMediaPlayer == null || !z2 || !z) {
                return;
            }
            if (FimiVideoView.this.mSeekWhenPrepared != 0) {
                FimiVideoView.this.seekTo(FimiVideoView.this.mSeekWhenPrepared);
            }
            FimiVideoView.this.mMediaPlayer.setPreview(1);
            FimiVideoView.this.start();
        }

        @Override // com.fimi.soul.media.player.widget.IRenderView.IRenderCallback
        public void onSurfaceCreated(@NonNull IRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2) {
            if (iSurfaceHolder.getRenderView() != FimiVideoView.this.mRenderView) {
                Log.e(FimiVideoView.this.TAG, "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            FimiVideoView.this.mSurfaceHolder = iSurfaceHolder;
            FimiVideoView.this.bindSurfaceHolder(FimiVideoView.this.mMediaPlayer, iSurfaceHolder);
            if (FimiVideoView.this.mCurrentState == 0) {
                FimiVideoView.this.openVideo(FimiVideoView.this.decodeType);
                if (FimiVideoView.this.mMediaPlayer != null) {
                    FimiVideoView.this.mMediaPlayer.setPreview(1);
                }
            } else if (FimiVideoView.this.mMediaPlayer != null) {
                FimiVideoView.this.mMediaPlayer.setPreview(1);
            }
            if (FimiVideoView.this.mPreviewCallBackListener != null) {
                FimiVideoView.this.mPreviewCallBackListener.onSurfaceState(1);
            }
            if (FimiVideoView.this.mFimiFileCallBackListener == null) {
                return;
            }
            FimiVideoView.this.mFimiFileCallBackListener.onSurfaceState(1);
        }

        @Override // com.fimi.soul.media.player.widget.IRenderView.IRenderCallback
        public void onSurfaceDestroyed(@NonNull IRenderView.ISurfaceHolder iSurfaceHolder) {
            if (iSurfaceHolder.getRenderView() != FimiVideoView.this.mRenderView) {
                Log.e(FimiVideoView.this.TAG, "onSurfaceDestroyed: unmatched render callback\n");
                return;
            }
            if (FimiVideoView.this.mMediaPlayer != null) {
                FimiVideoView.this.mMediaPlayer.setPreview(0);
            }
            FimiVideoView.this.mSurfaceHolder = null;
            if (FimiVideoView.this.mPreviewCallBackListener == null) {
                return;
            }
            FimiVideoView.this.mPreviewCallBackListener.onSurfaceState(0);
        }
    };
    private int mCurrentAspectRatioIndex = 0;
    private int mCurrentAspectRatio = s_allAspectRatio[0];
    private List<Integer> mAllRenders = new ArrayList();
    private int mCurrentRenderIndex = 0;
    private int mCurrentRender = 0;
    public IMediaPlayer.OnLiveVideoListener liveVideoListener = new IMediaPlayer.OnLiveVideoListener() { // from class: com.fimi.soul.media.player.widget.FimiVideoView.8
        @Override // com.fimi.soul.media.player.IMediaPlayer.OnLiveVideoListener
        public void onRtmpStatusCB(int i, int i2, int i3) {
            if (FimiVideoView.this.mOnLiveVideoCallBackListener != null) {
                FimiVideoView.this.mOnLiveVideoCallBackListener.mo9401a(i, i2, i3);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface OnFimiFileCallBackListener {
        void onSurfaceState(int i);
    }

    /* loaded from: classes.dex */
    public interface OnFimiPreviewCallBackListener {
        void onCompletion(int i);

        void onSurfaceState(int i);
    }

    public FimiVideoView(Context context) {
        super(context);
        initVideoView(context);
    }

    public FimiVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initVideoView(context);
    }

    public FimiVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initVideoView(context);
    }

    public FimiVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        initVideoView(context);
    }

    private void attachMediaController() {
        if (this.mMediaPlayer == null || this.mMediaController == null) {
            return;
        }
        this.mMediaController.setMediaPlayer(this);
        this.mMediaController.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
        this.mMediaController.setEnabled(isInPlaybackState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindSurfaceHolder(IMediaPlayer iMediaPlayer, IRenderView.ISurfaceHolder iSurfaceHolder) {
        if (iMediaPlayer == null) {
            return;
        }
        if (iSurfaceHolder == null) {
            iMediaPlayer.setDisplay(null);
        } else {
            iSurfaceHolder.bindToMediaPlayer(iMediaPlayer);
        }
    }

    private void initRenders() {
        this.mAllRenders.clear();
        this.mAllRenders.add(1);
        if (this.mAllRenders.isEmpty()) {
            this.mAllRenders.add(1);
        }
        this.mCurrentRender = this.mAllRenders.get(this.mCurrentRenderIndex).intValue();
        setRender(this.mCurrentRender);
    }

    private void initVideoView(Context context) {
        this.mAppContext = context.getApplicationContext();
        initRenders();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    private boolean isInPlaybackState() {
        return (this.mMediaPlayer == null || this.mCurrentState == -1 || this.mCurrentState == 0 || this.mCurrentState == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openVideo(int i) {
        C3676e.m7493a().m7492a(" " + this.mUri);
        if (this.mUri == null || this.mSurfaceHolder == null || this.mMediaPlayer != null) {
            return;
        }
        ((AudioManager) this.mAppContext.getSystemService("audio")).requestAudioFocus(null, 3, 1);
        FimiMediaPlayer fimiMediaPlayer = null;
        try {
            try {
                if (this.mUri != null) {
                    fimiMediaPlayer = FimiMediaPlayer.getIntance();
                    FimiMediaPlayer.native_setLogLevel(3);
                    fimiMediaPlayer.setOption(4, "mediacodec", i);
                    fimiMediaPlayer.setOption(4, "framedrop", 20L);
                    fimiMediaPlayer.setOption(4, "start-on-prepared", 0L);
                    fimiMediaPlayer.setOption(1, "http-detect-range-support", 0L);
                    fimiMediaPlayer.setOption(2, "skip_loop_filter", 0L);
                    fimiMediaPlayer.setOption(1, "analyzeduration", "20000");
                    fimiMediaPlayer.setOption(1, "probsize", "4096");
                }
                this.mMediaPlayer = fimiMediaPlayer;
                getContext();
                this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
                this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
                this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
                this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
                this.mCurrentBufferPercentage = 0;
                this.mMediaPlayer.setOnLiveVideoListener(this.liveVideoListener);
                if (C2110f.m13670a().m13668b() != EnumC2091b.DRONE) {
                    this.mMediaPlayer.setDeviceInfo(0, 6);
                } else if (C2367d.m12459a().m12438k()) {
                    this.mMediaPlayer.setDeviceInfo(1, 3);
                } else {
                    this.mMediaPlayer.setDeviceInfo(0, 3);
                }
                if (Build.VERSION.SDK_INT > 14) {
                    this.mMediaPlayer.setDataSource(this.mAppContext, this.mUri, this.mHeaders);
                } else {
                    this.mMediaPlayer.setDataSource(this.mUri.toString());
                }
                bindSurfaceHolder(this.mMediaPlayer, this.mSurfaceHolder);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                this.mMediaPlayer.prepareAsync();
                this.mCurrentState = 1;
                attachMediaController();
            } catch (IOException e) {
                Log.w(this.TAG, "Unable to open content: " + this.mUri, e);
                this.mCurrentState = -1;
                this.mTargetState = -1;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            }
        } catch (IllegalArgumentException e2) {
            Log.w(this.TAG, "Unable to open content: " + this.mUri, e2);
            this.mCurrentState = -1;
            this.mTargetState = -1;
            this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
        }
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        this.mUri = uri;
        this.mHeaders = map;
        this.mSeekWhenPrepared = 0;
        if (this.mCurrentState == 0 && this.mMediaPlayer == null) {
            openVideo(this.decodeType);
        }
        requestLayout();
        invalidate();
    }

    private void toggleMediaControlsVisiblity() {
        if (this.mMediaController.isShowing()) {
            this.mMediaController.hide();
        } else {
            this.mMediaController.show();
        }
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController.MediaPlayerControl
    public boolean canPause() {
        return this.mCanPause;
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.mCanSeekBack;
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.mCanSeekForward;
    }

    public void clearUri() {
        this.mUri = null;
    }

    public void drawBackground(IRenderView.ISurfaceHolder iSurfaceHolder) {
        if (this.paint == null) {
            this.paint = new Paint();
        }
        Canvas lockCanvas = iSurfaceHolder.getSurfaceHolder().lockCanvas();
        if (lockCanvas != null) {
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            Log.i("peter", "get canvas");
            this.paint.setAntiAlias(true);
            this.paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            lockCanvas.drawRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.paint);
            iSurfaceHolder.getSurfaceHolder().unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return (int) this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController.MediaPlayerControl
    public int getDuration() {
        Log.d("player", "getDuration");
        if (isInPlaybackState()) {
            return (int) this.mMediaPlayer.getDuration();
        }
        return -1;
    }

    public int getmCurrentState() {
        return this.mCurrentState;
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController.MediaPlayerControl
    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Log.d("player", "onFinishInflate");
        super.onFinishInflate();
        if (isPlaying()) {
            pause();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (isInPlaybackState() && z && this.mMediaController != null) {
            if (i == 79 || i == 85) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                    this.mMediaController.show();
                    return true;
                }
                start();
                this.mMediaController.hide();
                return true;
            } else if (i == 126) {
                if (this.mMediaPlayer.isPlaying()) {
                    return true;
                }
                start();
                this.mMediaController.hide();
                return true;
            } else if (i == 86 || i == 127) {
                if (!this.mMediaPlayer.isPlaying()) {
                    return true;
                }
                pause();
                this.mMediaController.show();
                return true;
            } else {
                toggleMediaControlsVisiblity();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isInPlaybackState() || this.mMediaController == null) {
            return false;
        }
        toggleMediaControlsVisiblity();
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!isInPlaybackState() || this.mMediaController == null) {
            return false;
        }
        toggleMediaControlsVisiblity();
        return false;
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController.MediaPlayerControl
    public void pause() {
        Log.d("player", "pause");
        if (this.mMediaPlayer == null) {
            return;
        }
        this.mMediaPlayer.pause();
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
        }
        this.mTargetState = 4;
    }

    public void release(boolean z) {
        try {
            try {
                if (this.mMediaPlayer != null) {
                    this.mMediaPlayer.playerRtmpStop(0);
                    this.mMediaPlayer.stop();
                    this.mMediaPlayer.release();
                    this.mMediaPlayer = null;
                }
                this.mCurrentState = 0;
                if (z) {
                    this.mTargetState = 0;
                }
                ((AudioManager) this.mAppContext.getSystemService("audio")).abandonAudioFocus(null);
            } catch (Exception e) {
                e.printStackTrace();
                this.mCurrentState = 0;
                if (z) {
                    this.mTargetState = 0;
                }
                ((AudioManager) this.mAppContext.getSystemService("audio")).abandonAudioFocus(null);
            }
        } catch (Throwable th) {
            this.mCurrentState = 0;
            if (z) {
                this.mTargetState = 0;
            }
            ((AudioManager) this.mAppContext.getSystemService("audio")).abandonAudioFocus(null);
            throw th;
        }
    }

    public void releaseWithoutStop() {
        if (this.mMediaPlayer != null) {
            release(true);
        }
    }

    public synchronized void restart() {
        if (this.mMediaPlayer != null) {
            C3676e.m7493a().m7492a("restart release");
            release(false);
        }
        openVideo(this.decodeType);
        C3676e.m7493a().m7492a("mUri = || mSurfaceHolder = || mMediaPlayer =" + this.mUri + " " + this.mSurfaceHolder + " " + this.mMediaPlayer);
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setPreview(1);
            start();
        }
    }

    public void resume() {
        Log.d("Good", "resume");
        openVideo(this.decodeType);
    }

    public void saveEmergencyFlightVideo(String str, int i) {
        C3676e.m7493a().m7492a("FimiView saveEmergencyFlightVideo " + str);
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.recEmergencySave(str, i);
        }
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController.MediaPlayerControl
    public void seekTo(int i) {
        Log.d("player", "seekto");
        if (!isInPlaybackState()) {
            this.mSeekWhenPrepared = i;
            return;
        }
        this.mMediaPlayer.seekTo(i);
        this.mSeekWhenPrepared = 0;
    }

    public void setDecodeType(int i) {
        this.decodeType = i;
    }

    public void setHideSurfaceView(boolean z) {
        if (this.mRenderView instanceof SurfaceRenderView) {
            ((SurfaceRenderView) this.mRenderView).getHolder().setFormat(z ? -2 : 4);
        }
    }

    public void setLiveVideoCallBackListener(View$OnTouchListenerC3156b.AbstractC3162c abstractC3162c) {
        this.mOnLiveVideoCallBackListener = abstractC3162c;
    }

    public void setMediaController(IMediaController iMediaController) {
        if (this.mMediaController != null) {
            this.mMediaController.hide();
        }
        this.mMediaController = iMediaController;
        attachMediaController();
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnFileCallBackListener(OnFimiFileCallBackListener onFimiFileCallBackListener) {
        this.mFimiFileCallBackListener = onFimiFileCallBackListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnPreviewCallBackListener(OnFimiPreviewCallBackListener onFimiPreviewCallBackListener) {
        this.mPreviewCallBackListener = onFimiPreviewCallBackListener;
    }

    public void setPreview() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setPreview(1);
        }
    }

    public void setRender(int i) {
        switch (i) {
            case 0:
                setRenderView(null);
                return;
            case 1:
                setRenderView(new SurfaceRenderView(getContext()));
                return;
            case 2:
                TextureRenderView textureRenderView = new TextureRenderView(getContext());
                if (this.mMediaPlayer != null) {
                    textureRenderView.getSurfaceHolder().bindToMediaPlayer(this.mMediaPlayer);
                    textureRenderView.setVideoSize(this.mMediaPlayer.getVideoWidth(), this.mMediaPlayer.getVideoHeight());
                    textureRenderView.setVideoSampleAspectRatio(this.mMediaPlayer.getVideoSarNum(), this.mMediaPlayer.getVideoSarDen());
                    textureRenderView.setAspectRatio(this.mCurrentAspectRatio);
                }
                setRenderView(textureRenderView);
                return;
            default:
                Log.e(this.TAG, String.format(Locale.getDefault(), "invalid render %d\n", Integer.valueOf(i)));
                return;
        }
    }

    public void setRenderView(IRenderView iRenderView) {
        if (this.mRenderView != null) {
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setDisplay(null);
            }
            View view = this.mRenderView.getView();
            this.mRenderView.removeRenderCallback(this.mSHCallback);
            this.mRenderView = null;
            removeView(view);
        }
        if (iRenderView == null) {
            return;
        }
        this.mRenderView = iRenderView;
        iRenderView.setAspectRatio(this.mCurrentAspectRatio);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            iRenderView.setVideoSize(this.mVideoWidth, this.mVideoHeight);
        }
        if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
            iRenderView.setVideoSampleAspectRatio(this.mVideoSarNum, this.mVideoSarDen);
        }
        View view2 = this.mRenderView.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(view2);
        this.mRenderView.addRenderCallback(this.mSHCallback);
        this.mRenderView.setVideoRotation(this.mVideoRotationDegree);
    }

    public void setUri(String str) {
        this.mUri = Uri.parse(str);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public void setZOrderMediaOverlay(boolean z) {
        if (this.mRenderView instanceof SurfaceRenderView) {
            ((SurfaceRenderView) this.mRenderView).setZOrderMediaOverlay(z);
        }
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController.MediaPlayerControl
    public void start() {
        if (this.mCurrentState == 5) {
            setVideoURI(this.mUri);
        }
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
    }

    public void startFlightVideo(String str, int i, int i2) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.recStart(str, i, i2);
        }
    }

    public void startLiveVideo(String str) {
        this.liveUrl = str;
        if (this.liveUrl == null || this.mMediaPlayer == null) {
            return;
        }
        this.mMediaPlayer.playerRtmpStart(this.liveUrl, 1);
        this.liveUrl = null;
    }

    public void startPlay() {
        if (this.mMediaPlayer == null) {
            openVideo(this.decodeType);
            if (this.mMediaPlayer == null) {
                return;
            }
            this.mMediaPlayer.setPreview(1);
            start();
        }
    }

    public void startPreview() {
        if (this.mMediaPlayer == null || this.mSurfaceHolder == null) {
            return;
        }
        C3676e.m7493a().m7492a("---startPreview----mMediaPlayer " + this.mMediaPlayer);
        this.mMediaPlayer.setPreview(1);
        C3676e.m7493a().m7492a("---startPreview----start ");
        start();
    }

    public void stopFlightVideo() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.recStop();
        }
    }

    public void stopLiveVideo() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.playerRtmpStop(0);
            this.liveUrl = null;
        }
    }

    public void stopPlay() {
        if (this.mMediaPlayer != null) {
            C3676e.m7493a().m7492a("---stopPlay----release");
            release(false);
        }
    }

    public void stopPlayback() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
            ((AudioManager) this.mAppContext.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void suspend() {
        Log.d("Good", "suspend");
        release(false);
    }

    public int toggleAspectRatio() {
        this.mCurrentAspectRatioIndex++;
        this.mCurrentAspectRatioIndex %= s_allAspectRatio.length;
        this.mCurrentAspectRatio = 1;
        if (this.mRenderView != null) {
            this.mRenderView.setAspectRatio(this.mCurrentAspectRatio);
        }
        return this.mCurrentAspectRatio;
    }

    public int toggleAspectRatioPOi() {
        this.mCurrentAspectRatioIndex++;
        this.mCurrentAspectRatioIndex %= s_allAspectRatio.length;
        this.mCurrentAspectRatio = 3;
        if (this.mRenderView != null) {
            this.mRenderView.setAspectRatio(this.mCurrentAspectRatio);
        }
        return this.mCurrentAspectRatio;
    }

    public int toggleRender() {
        this.mCurrentRenderIndex++;
        this.mCurrentRenderIndex %= this.mAllRenders.size();
        this.mCurrentRender = this.mAllRenders.get(this.mCurrentRenderIndex).intValue();
        setRender(this.mCurrentRender);
        return this.mCurrentRender;
    }
}
