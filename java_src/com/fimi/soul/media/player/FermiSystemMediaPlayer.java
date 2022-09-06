package com.fimi.soul.media.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.SeekBar;
import com.fimi.soul.media.player.IFermiMediaPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
class FermiSystemMediaPlayer implements SurfaceHolder.Callback, SeekBar.OnSeekBarChangeListener, IFermiMediaPlayer {
    private Context context;
    private String dataSourceUrl;
    private boolean isAutoPlay;
    private OnMediaSizeChangedListener onMediaSizeChangedListener;
    private OnProgressChangedListener onProgressChangedListener;
    private SeekBar seekBar;
    private SurfaceView surfaceView;
    private MediaPlayer player = null;
    private int startPosition = 0;
    private boolean ischanging = false;
    private List<OnPlayerStateChangedListener> onPlayerStateChangedListenerArray = new ArrayList();
    private Timer timer = new Timer();
    private Handler handler = new InnerHandler();
    private TimerTask timerTask = new TimerTask() { // from class: com.fimi.soul.media.player.FermiSystemMediaPlayer.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (!FermiSystemMediaPlayer.this.ischanging && FermiSystemMediaPlayer.this.player != null && FermiSystemMediaPlayer.this.seekBar != null && !FermiSystemMediaPlayer.this.ischanging) {
                FermiSystemMediaPlayer.this.seekBar.setProgress(FermiSystemMediaPlayer.this.player.getCurrentPosition());
                Message message = new Message();
                message.arg1 = FermiSystemMediaPlayer.this.player.getCurrentPosition();
                message.arg2 = FermiSystemMediaPlayer.this.player.getDuration();
                FermiSystemMediaPlayer.this.handler.sendMessage(message);
            }
        }
    };

    /* loaded from: classes.dex */
    class InnerHandler extends Handler {
        InnerHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (FermiSystemMediaPlayer.this.onProgressChangedListener != null) {
                FermiSystemMediaPlayer.this.onProgressChangedListener.onProgressChanged(message.arg1, message.arg2);
            }
            super.handleMessage(message);
        }
    }

    public FermiSystemMediaPlayer(Context context) {
        this.context = context;
        this.timer.schedule(this.timerTask, 0L, 1000L);
    }

    private Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerStateChange(IFermiMediaPlayer.FermiPlyaerState fermiPlyaerState) {
        if (this.onPlayerStateChangedListenerArray.size() > 0) {
            for (OnPlayerStateChangedListener onPlayerStateChangedListener : this.onPlayerStateChangedListenerArray) {
                onPlayerStateChangedListener.OnPlayerStateChanged(fermiPlyaerState, this);
            }
        }
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void addOnPlayerStateChangedListener(OnPlayerStateChangedListener onPlayerStateChangedListener) {
        if (onPlayerStateChangedListener != null) {
            this.onPlayerStateChangedListenerArray.add(onPlayerStateChangedListener);
        }
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public long getCurrentPosition() {
        return this.player.getCurrentPosition();
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public long getDuration() {
        return this.player.getDuration();
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public int getPosition() {
        return this.player.getCurrentPosition();
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public boolean isPlaying() {
        if (this.player != null) {
            return this.player.isPlaying();
        }
        return false;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            this.player.seekTo(i);
            if (this.onProgressChangedListener == null) {
                return;
            }
            this.onProgressChangedListener.onProgressChanged(i, this.player.getDuration());
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.ischanging = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void pause() {
        if (this.player == null || !this.player.isPlaying()) {
            return;
        }
        this.player.pause();
        onPlayerStateChange(IFermiMediaPlayer.FermiPlyaerState.Pause);
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void play() {
        if (this.player != null) {
            try {
                if (this.player != null && !this.player.isPlaying()) {
                    this.player.stop();
                }
                this.player.prepare();
                if (isAutoPlay()) {
                    return;
                }
                this.player.start();
                onPlayerStateChange(IFermiMediaPlayer.FermiPlyaerState.Playing);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void prepare() {
        if (this.player != null) {
            try {
                this.player.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void seekTo(long j) {
        this.player.seekTo((int) j);
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void setAutoPlay(boolean z) {
        this.isAutoPlay = z;
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void setMediaUri(String str) {
        setMediaUri(str, null, null);
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void setMediaUri(String str, String str2, String str3) {
        this.dataSourceUrl = str;
        if (this.player != null) {
            try {
                this.player.setDataSource(this.dataSourceUrl);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (IllegalStateException e3) {
                e3.printStackTrace();
            } catch (SecurityException e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void setOnMediaSizeChangedListener(OnMediaSizeChangedListener onMediaSizeChangedListener) {
        this.onMediaSizeChangedListener = onMediaSizeChangedListener;
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void setOnProgressChangedListener(OnProgressChangedListener onProgressChangedListener) {
        this.onProgressChangedListener = onProgressChangedListener;
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void setPlayPosition(int i) {
        this.startPosition = i;
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void setSeekBar(SeekBar seekBar) {
        this.seekBar = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void setSurfaceView(SurfaceView surfaceView) {
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.fimi.soul.media.player.IFermiMediaPlayer
    public void stop() {
        if (this.player != null) {
            this.player.stop();
            onPlayerStateChange(IFermiMediaPlayer.FermiPlyaerState.Stop);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.player = new MediaPlayer();
        this.player.setAudioStreamType(3);
        this.player.setDisplay(surfaceHolder);
        this.player.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.fimi.soul.media.player.FermiSystemMediaPlayer.2
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                FermiSystemMediaPlayer.this.ischanging = false;
                mediaPlayer.start();
            }
        });
        try {
            this.player.setDataSource(this.dataSourceUrl);
            this.player.prepare();
            this.player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.fimi.soul.media.player.FermiSystemMediaPlayer.3
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    if (FermiSystemMediaPlayer.this.seekBar != null) {
                        FermiSystemMediaPlayer.this.seekBar.setMax(mediaPlayer.getDuration());
                    }
                    if (FermiSystemMediaPlayer.this.isAutoPlay) {
                        FermiSystemMediaPlayer.this.seekTo(FermiSystemMediaPlayer.this.startPosition);
                        mediaPlayer.start();
                        FermiSystemMediaPlayer.this.onPlayerStateChange(IFermiMediaPlayer.FermiPlyaerState.Playing);
                    }
                }
            });
            this.player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.fimi.soul.media.player.FermiSystemMediaPlayer.4
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                }
            });
            this.player.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.fimi.soul.media.player.FermiSystemMediaPlayer.5
                @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
                public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                    if (FermiSystemMediaPlayer.this.onMediaSizeChangedListener != null) {
                        Log.d("Good", i + ":" + i2);
                        FermiSystemMediaPlayer.this.onMediaSizeChangedListener.onMediaSizeChanged(FermiSystemMediaPlayer.this, i, i2);
                    }
                }
            });
            this.player.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.player.isPlaying()) {
            this.player.stop();
        }
    }
}
