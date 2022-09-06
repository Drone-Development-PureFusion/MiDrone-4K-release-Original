package com.fimi.soul.media.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.media.player.IFermiMediaPlayer;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
final class FermiPlayerViewBuilder {
    private Button btnClose;
    private Button btnFullscreen;
    private Button btnPause;
    private Button btnPlay;
    private GestureDetector gestureDetector;
    private Handler handler;
    private long lastTouchTime;
    private View.OnClickListener onClickFullscreenListener;
    private IFermiMediaPlayer player;
    private View popupView;
    private SeekBar seekBar;
    private SurfaceView sfThumbnail;
    private SurfaceView surfaceView;
    private TextView tvCurrentPosition;
    private TextView tvDuration;
    private OnDoubleTapListener onDoubleTapListener = null;
    private OnClickCloseListener onClickCloseListenner = null;
    private OnDisappearButtonListener onDisappearButtonListener = null;
    private Context context = null;
    private int layoutID = -1;
    private long dismissTime = 3000;
    private boolean isAutoPlay = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class InnerHandler extends Handler {
        InnerHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (System.currentTimeMillis() - FermiPlayerViewBuilder.this.lastTouchTime >= FermiPlayerViewBuilder.this.dismissTime) {
                FermiPlayerViewBuilder.this.btnPlay.setVisibility(4);
                FermiPlayerViewBuilder.this.btnClose.setVisibility(4);
                FermiPlayerViewBuilder.this.btnPause.setVisibility(4);
                FermiPlayerViewBuilder.this.seekBar.setVisibility(4);
                FermiPlayerViewBuilder.this.btnFullscreen.setVisibility(4);
                if (FermiPlayerViewBuilder.this.tvCurrentPosition != null && FermiPlayerViewBuilder.this.tvDuration != null) {
                    FermiPlayerViewBuilder.this.tvCurrentPosition.setVisibility(4);
                    FermiPlayerViewBuilder.this.tvDuration.setVisibility(4);
                }
                if (FermiPlayerViewBuilder.this.onDisappearButtonListener != null) {
                    FermiPlayerViewBuilder.this.onDisappearButtonListener.onDisappearButton(true);
                }
            }
            if (message.what == InnerHandlerType.HiddenMessage.ordinal()) {
                FermiPlayerViewBuilder.this.hiddenLoadingImage(true);
            }
            if (message.what == InnerHandlerType.ShowMessage.ordinal()) {
                FermiPlayerViewBuilder.this.hiddenLoadingImage(false);
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum InnerHandlerType {
        TouchMessage,
        HiddenMessage,
        ShowMessage,
        MediaSizeChangeMessage
    }

    /* loaded from: classes.dex */
    public interface OnClickCloseListener {
        void onClose(View view);
    }

    /* loaded from: classes.dex */
    public interface OnDisappearButtonListener {
        void onDisappearButton(boolean z);
    }

    /* loaded from: classes.dex */
    public interface OnDoubleTapListener {
        void onDoubleTap(MotionEvent motionEvent);
    }

    private FermiPlayerViewBuilder() {
    }

    public static FermiPlayerViewBuilder Builder(Context context, int i) {
        FermiPlayerViewBuilder fermiPlayerViewBuilder = new FermiPlayerViewBuilder();
        fermiPlayerViewBuilder.context = context;
        fermiPlayerViewBuilder.layoutID = i;
        fermiPlayerViewBuilder.buildWindow();
        return fermiPlayerViewBuilder;
    }

    private void buildWindow() {
        this.handler = new InnerHandler();
        this.popupView = LayoutInflater.from(getContext()).inflate(this.layoutID, (ViewGroup) null);
        this.btnPlay = (Button) this.popupView.findViewById(C2300R.C2302id.iv_play);
        this.btnClose = (Button) this.popupView.findViewById(C2300R.C2302id.iv_close);
        this.btnPause = (Button) this.popupView.findViewById(C2300R.C2302id.iv_pause);
        this.btnFullscreen = (Button) this.popupView.findViewById(C2300R.C2302id.btn_fullScreen);
        this.seekBar = (SeekBar) this.popupView.findViewById(C2300R.C2302id.sb_seekbar);
        this.tvCurrentPosition = (TextView) this.popupView.findViewById(C2300R.C2302id.tv_position);
        this.tvDuration = (TextView) this.popupView.findViewById(C2300R.C2302id.tv_duration);
        this.surfaceView = (SurfaceView) this.popupView.findViewById(C2300R.C2302id.sf_video);
        this.surfaceView.setZOrderMediaOverlay(true);
        this.sfThumbnail = (SurfaceView) this.popupView.findViewById(C2300R.C2302id.sf_video_thumbnail);
        this.popupView.setOnTouchListener(new View.OnTouchListener() { // from class: com.fimi.soul.media.player.FermiPlayerViewBuilder.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FermiPlayerViewBuilder.this.sendTouchMessage();
                return FermiPlayerViewBuilder.this.gestureDetector.onTouchEvent(motionEvent);
            }
        });
        this.gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.fimi.soul.media.player.FermiPlayerViewBuilder.4
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (FermiPlayerViewBuilder.this.onDoubleTapListener != null) {
                    FermiPlayerViewBuilder.this.onDoubleTapListener.onDoubleTap(motionEvent);
                    return true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }
        });
        this.btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.player.FermiPlayerViewBuilder.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FermiPlayerViewBuilder.this.sendTouchMessage();
                if (FermiPlayerViewBuilder.this.onClickCloseListenner != null) {
                    FermiPlayerViewBuilder.this.onClickCloseListenner.onClose(view);
                }
            }
        });
        this.btnPlay.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.player.FermiPlayerViewBuilder.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FermiPlayerViewBuilder.this.sendTouchMessage();
                if (!FermiPlayerViewBuilder.this.player.isPlaying()) {
                    FermiPlayerViewBuilder.this.player.play();
                }
                FermiPlayerViewBuilder.this.changePlayState(true);
            }
        });
        this.btnPause.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.player.FermiPlayerViewBuilder.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FermiPlayerViewBuilder.this.player.isPlaying()) {
                    FermiPlayerViewBuilder.this.player.pause();
                }
                FermiPlayerViewBuilder.this.changePlayState(false);
            }
        });
        this.btnFullscreen.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.player.FermiPlayerViewBuilder.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FermiPlayerViewBuilder.this.onClickFullscreenListener != null) {
                    FermiPlayerViewBuilder.this.onClickFullscreenListener.onClick(view);
                }
            }
        });
        this.surfaceView.setOnTouchListener(new View.OnTouchListener() { // from class: com.fimi.soul.media.player.FermiPlayerViewBuilder.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FermiPlayerViewBuilder.this.surfaceView.setZOrderMediaOverlay(true);
                FermiPlayerViewBuilder.this.surfaceView.setZOrderOnTop(false);
                FermiPlayerViewBuilder.this.changePlayState();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changePlayState() {
        changePlayState(this.player.isPlaying());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changePlayState(boolean z) {
        if (!z) {
            this.btnPause.setVisibility(4);
            this.btnPlay.bringToFront();
            this.btnPlay.setVisibility(0);
            return;
        }
        this.sfThumbnail.setVisibility(8);
        this.btnPlay.setVisibility(4);
        this.btnPause.bringToFront();
        this.btnPause.setVisibility(0);
    }

    private Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTouchMessage() {
        this.lastTouchTime = System.currentTimeMillis();
        this.btnClose.setVisibility(0);
        this.seekBar.setVisibility(0);
        this.btnFullscreen.setVisibility(0);
        if (this.tvCurrentPosition != null && this.tvDuration != null) {
            this.tvCurrentPosition.setVisibility(0);
            this.tvDuration.setVisibility(0);
        }
        if (this.onDisappearButtonListener != null) {
            this.onDisappearButtonListener.onDisappearButton(false);
        }
        new Message().what = InnerHandlerType.TouchMessage.ordinal();
        this.handler.sendMessageDelayed(new Message(), this.dismissTime);
    }

    private void setSurfaceViewSize(int i, int i2) {
        boolean z = true;
        if (getContext().getResources().getConfiguration().orientation != 1) {
            z = false;
        }
        if (!z) {
            int width = (this.surfaceView.getWidth() - ((this.surfaceView.getHeight() * i) / i2)) / 2;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(width, 0, width, 0);
            this.surfaceView.setLayoutParams(layoutParams);
        }
    }

    public View create() {
        return this.popupView;
    }

    public FermiPlayerViewBuilder hiddenLoadingImage(boolean z) {
        if (z) {
            this.sfThumbnail.setVisibility(8);
        } else {
            this.sfThumbnail.setVisibility(0);
        }
        return this;
    }

    public FermiPlayerViewBuilder setContentView(int i) {
        this.layoutID = i;
        return this;
    }

    public FermiPlayerViewBuilder setControlDisplayDuration(int i) {
        this.dismissTime = i;
        return this;
    }

    public FermiPlayerViewBuilder setFermiMediaPlayer(IFermiMediaPlayer iFermiMediaPlayer) {
        this.player = iFermiMediaPlayer;
        this.player.setSurfaceView(this.surfaceView);
        this.player.setSeekBar(this.seekBar);
        this.player.setOnProgressChangedListener(new OnProgressChangedListener() { // from class: com.fimi.soul.media.player.FermiPlayerViewBuilder.1
            @Override // com.fimi.soul.media.player.OnProgressChangedListener
            public void onProgressChanged(long j, long j2) {
                FermiPlayerViewBuilder.this.seekBar.setMax((int) j2);
                FermiPlayerViewBuilder.this.seekBar.setProgress((int) j);
                FermiPlayerViewBuilder.this.seekBar.setEnabled(j2 != 0);
                if (FermiPlayerViewBuilder.this.tvDuration == null || FermiPlayerViewBuilder.this.tvCurrentPosition == null) {
                    return;
                }
                FermiPlayerViewBuilder.this.tvDuration.setText(FermiPlayerUtils.getTimelineString(j2));
                FermiPlayerViewBuilder.this.tvCurrentPosition.setText(FermiPlayerUtils.getTimelineString(j));
            }
        });
        this.player.addOnPlayerStateChangedListener(new OnPlayerStateChangedListener() { // from class: com.fimi.soul.media.player.FermiPlayerViewBuilder.2
            @Override // com.fimi.soul.media.player.OnPlayerStateChangedListener
            public void OnPlayerStateChanged(IFermiMediaPlayer.FermiPlyaerState fermiPlyaerState, IFermiMediaPlayer iFermiMediaPlayer2) {
                Message message = new Message();
                if (fermiPlyaerState == IFermiMediaPlayer.FermiPlyaerState.Playing) {
                    message.what = InnerHandlerType.HiddenMessage.ordinal();
                } else {
                    message.what = InnerHandlerType.ShowMessage.ordinal();
                }
                FermiPlayerViewBuilder.this.handler.sendMessage(message);
            }
        });
        return this;
    }

    public FermiPlayerViewBuilder setNoSeekBar() {
        this.btnPlay.setVisibility(0);
        this.btnPause.setVisibility(4);
        this.btnClose.setVisibility(0);
        this.seekBar.setVisibility(8);
        return this;
    }

    public FermiPlayerViewBuilder setOnClickCloseListenner(OnClickCloseListener onClickCloseListener) {
        this.onClickCloseListenner = onClickCloseListener;
        return this;
    }

    public FermiPlayerViewBuilder setOnClickFullscreenListener(View.OnClickListener onClickListener) {
        this.onClickFullscreenListener = onClickListener;
        return this;
    }

    public FermiPlayerViewBuilder setOnDisappearButtonListener(OnDisappearButtonListener onDisappearButtonListener) {
        this.onDisappearButtonListener = onDisappearButtonListener;
        return this;
    }

    public FermiPlayerViewBuilder setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.onDoubleTapListener = onDoubleTapListener;
        return this;
    }
}
