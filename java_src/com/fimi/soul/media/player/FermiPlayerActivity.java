package com.fimi.soul.media.player;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.fimi.kernel.utils.C2274s;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.biz.camera.entity.X11FileInfo;
import com.fimi.soul.media.player.IMediaPlayer;
import com.fimi.soul.media.player.widget.FimiVideoView;
import java.io.File;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes.dex */
public class FermiPlayerActivity extends BaseActivity implements View.OnClickListener {
    public static final String ONLINEFILE = "online_file";
    public static final String PLAY_NOW = "play_start";
    public static final String SP_KEY_PLAYER_ADDR = "SP_KEY_PLAYER_ADDR_VideoDialogFragment";
    public static final String SP_KEY_PLAYER_IS_REMOTE_ADDR = "SP_KEY_PLAYER_IS_REMOTE_ADDR_VideoDialogFragment";
    private Bitmap bitmap;
    private PercentRelativeLayout bottom_layout;
    private ImageButton btnClose;
    private int current_position;
    private boolean isPlay;
    private TextView mCurrentTime;
    private TextView mEndTime;
    StringBuilder mFormatBuilder;
    Formatter mFormatter;
    private TextView mNameText;
    private SeekBar mProgress;
    boolean onlineFile;
    private ImageButton playBtn;
    boolean play_start;
    private FimiVideoView player;
    private View top_layout;
    private ImageView videoThumbnail;
    public String url = null;
    public String onlineUrl = null;
    boolean isShow = false;
    boolean finishPlay = false;
    boolean isPause = false;
    private boolean isExit = false;
    private final int PROGRESS_MSG = 1;
    private final int BOTTOM_MSG_SHOW = 2;
    private final int BOTTOM_MSG_GONE = 3;
    Handler handler = new Handler() { // from class: com.fimi.soul.media.player.FermiPlayerActivity.5
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    super.handleMessage(message);
                    return;
                case 1:
                    if (FermiPlayerActivity.this.player == null || !FermiPlayerActivity.this.player.isPlaying()) {
                        return;
                    }
                    FermiPlayerActivity.this.videoThumbnail.setVisibility(4);
                    FermiPlayerActivity.this.setProgress();
                    return;
                case 2:
                    FermiPlayerActivity.this.top_layout.setVisibility(0);
                    FermiPlayerActivity.this.bottom_layout.setVisibility(0);
                    FermiPlayerActivity.this.handler.sendEmptyMessageDelayed(3, 3000L);
                    FermiPlayerActivity.this.isShow = true;
                    return;
                case 3:
                    FermiPlayerActivity.this.top_layout.setVisibility(8);
                    FermiPlayerActivity.this.bottom_layout.setVisibility(8);
                    FermiPlayerActivity.this.isShow = false;
                    return;
                default:
                    return;
            }
        }
    };
    Thread thread = new Thread() { // from class: com.fimi.soul.media.player.FermiPlayerActivity.6
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!FermiPlayerActivity.this.isExit) {
                try {
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (FermiPlayerActivity.this.isPlay()) {
                    if (FermiPlayerActivity.this.player != null && FermiPlayerActivity.this.player.getCurrentPosition() != FermiPlayerActivity.this.player.getDuration()) {
                        if (FermiPlayerActivity.this.player.isPlaying()) {
                            FermiPlayerActivity.this.handler.sendMessageDelayed(FermiPlayerActivity.this.handler.obtainMessage(1), 1L);
                        }
                    }
                }
                sleep(1000L);
            }
        }
    };

    private void initMediaContoller() {
        this.bottom_layout = (PercentRelativeLayout) findViewById(C2300R.C2302id.bottom_layout);
        this.mEndTime = (TextView) this.bottom_layout.findViewById(C2300R.C2302id.time);
        this.mCurrentTime = (TextView) this.bottom_layout.findViewById(C2300R.C2302id.time_current);
        this.playBtn = (ImageButton) this.bottom_layout.findViewById(C2300R.C2302id.pause);
        this.mProgress = (SeekBar) this.bottom_layout.findViewById(C2300R.C2302id.fmmediacontroller_progress);
        this.mFormatBuilder = new StringBuilder();
        this.mFormatter = new Formatter(this.mFormatBuilder, Locale.getDefault());
        this.playBtn.setOnClickListener(this);
        this.mProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.fimi.soul.media.player.FermiPlayerActivity.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    FermiPlayerActivity.this.bottom_layout.setVisibility(0);
                    FermiPlayerActivity.this.top_layout.setVisibility(0);
                    FermiPlayerActivity.this.isPause = true;
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                FermiPlayerActivity.this.player.seekTo(progress);
                if (FermiPlayerActivity.this.player.isPlaying()) {
                    FermiPlayerActivity.this.setProgress();
                } else {
                    FermiPlayerActivity.this.preferencesUtil.m12785a(progress);
                    if (FermiPlayerActivity.this.mCurrentTime != null) {
                        FermiPlayerActivity.this.mCurrentTime.setText(FermiPlayerActivity.this.stringForTime(progress));
                    }
                }
                FermiPlayerActivity.this.isPause = false;
            }
        });
    }

    private void initPlay() {
        this.player.setDecodeType(0);
        this.player.setVideoPath(this.url);
        this.player.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: com.fimi.soul.media.player.FermiPlayerActivity.4
            @Override // com.fimi.soul.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                FermiPlayerActivity.this.handler.sendEmptyMessageDelayed(2, 500L);
                FermiPlayerActivity.this.mProgress.setMax(FermiPlayerActivity.this.player.getDuration());
                FermiPlayerActivity.this.player.seekTo((int) FermiPlayerActivity.this.preferencesUtil.m12747n());
            }

            @Override // com.fimi.soul.media.player.IMediaPlayer.OnPreparedListener
            public void onStartStream() {
            }
        });
    }

    private void play() {
        if (!this.player.isPlaying()) {
            this.player.start();
            this.playBtn.setBackgroundResource(C2300R.C2301drawable.drone_stop);
            setPlay(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setProgress() {
        if (this.player == null || this.isPause) {
            return 0;
        }
        int currentPosition = this.player.getCurrentPosition();
        int duration = this.player.getDuration();
        if (this.mProgress != null) {
            this.mProgress.setProgress(currentPosition);
        }
        if (this.mEndTime != null) {
            this.mEndTime.setText(stringForTime(duration));
        }
        if (this.mCurrentTime != null && !this.mCurrentTime.getText().toString().equals(this.mEndTime.getText().toString())) {
            this.mCurrentTime.setText(stringForTime(currentPosition));
        }
        if (currentPosition != 0) {
            return currentPosition;
        }
        this.mCurrentTime.setText(stringForTime(currentPosition));
        return currentPosition;
    }

    @TargetApi(16)
    private void showVideoThumbnail(Bitmap bitmap) {
        if (bitmap != null) {
            this.videoThumbnail.setBackground(C2274s.m12826a(bitmap));
            this.videoThumbnail.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String stringForTime(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.mFormatBuilder.setLength(0);
        return i5 > 0 ? this.mFormatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.mFormatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public synchronized boolean isPlay() {
        return this.isPlay;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.mBplayButton /* 2131493113 */:
                play();
                return;
            case C2300R.C2302id.iv_close /* 2131493115 */:
                finish();
                return;
            case C2300R.C2302id.pause /* 2131493510 */:
                if (this.player.isPlaying()) {
                    this.player.pause();
                    this.playBtn.setBackgroundResource(C2300R.C2301drawable.drone_play);
                    setPlay(false);
                    return;
                }
                if (this.finishPlay) {
                    if (this.mCurrentTime != null) {
                        this.mCurrentTime.setText(stringForTime(0));
                    }
                    this.finishPlay = false;
                }
                this.player.start();
                this.playBtn.setBackgroundResource(C2300R.C2301drawable.drone_stop);
                setPlay(true);
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.soul.base.BaseFimiActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_player);
        initMediaContoller();
        this.videoThumbnail = (ImageView) findViewById(C2300R.C2302id.videoThumbnail);
        this.btnClose = (ImageButton) getWindow().findViewById(C2300R.C2302id.iv_close);
        this.btnClose.setOnClickListener(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.url = intent.getStringExtra("SP_KEY_PLAYER_ADDR_VideoDialogFragment");
            this.onlineUrl = intent.getStringExtra(SP_KEY_PLAYER_IS_REMOTE_ADDR);
        }
        this.preferencesUtil.m12785a(0L);
        this.top_layout = findViewById(C2300R.C2302id.rl_topView);
        this.mNameText = (TextView) findViewById(C2300R.C2302id.iv_name);
        this.play_start = getIntent().getBooleanExtra(PLAY_NOW, false);
        this.onlineFile = getIntent().getBooleanExtra(ONLINEFILE, false);
        int lastIndexOf = this.url.lastIndexOf("/");
        if (lastIndexOf > 1) {
            String substring = this.url.substring(lastIndexOf + 1);
            if (substring.contains("_THM.MP4")) {
                substring = substring.replaceFirst("_THM.MP4", X11FileInfo.FILE_TYPE_MP4);
            }
            this.mNameText.setText(substring);
            if (this.onlineUrl == null || !new File(this.onlineUrl).exists()) {
                this.bitmap = FermiPlayerUtils.createVideoThumbnail(this.url);
            } else {
                this.bitmap = BitmapFactory.decodeFile(this.onlineUrl);
            }
            showVideoThumbnail(this.bitmap);
        }
        this.player = (FimiVideoView) findViewById(C2300R.C2302id.video_view);
        this.player.setOnClickListener(this);
        this.player.setOnTouchListener(new View.OnTouchListener() { // from class: com.fimi.soul.media.player.FermiPlayerActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        FermiPlayerActivity.this.handler.removeMessages(2);
                        FermiPlayerActivity.this.handler.removeMessages(3);
                        FermiPlayerActivity.this.bottom_layout.setVisibility(0);
                        FermiPlayerActivity.this.top_layout.setVisibility(0);
                        return true;
                    case 1:
                        if (FermiPlayerActivity.this.isShow) {
                            FermiPlayerActivity.this.handler.sendEmptyMessage(3);
                            return true;
                        }
                        FermiPlayerActivity.this.handler.sendEmptyMessage(2);
                        return true;
                    default:
                        return true;
                }
            }
        });
        initPlay();
        this.player.setOnErrorListener(new IMediaPlayer.OnErrorListener() { // from class: com.fimi.soul.media.player.FermiPlayerActivity.2
            @Override // com.fimi.soul.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                FermiPlayerActivity.this.player.stopPlayback();
                C2284z.m12697a(FermiPlayerActivity.this, (int) C2300R.C2303string.file_error);
                FermiPlayerActivity.this.finish();
                return false;
            }
        });
        this.player.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() { // from class: com.fimi.soul.media.player.FermiPlayerActivity.3
            @Override // com.fimi.soul.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer, int i) {
                FermiPlayerActivity.this.player.seekTo(0);
                FermiPlayerActivity.this.preferencesUtil.m12785a(0L);
                FermiPlayerActivity.this.playBtn.setBackgroundResource(C2300R.C2301drawable.drone_play);
                FermiPlayerActivity.this.finishPlay = true;
                FermiPlayerActivity.this.setPlay(false);
                if (FermiPlayerActivity.this.mCurrentTime != null) {
                    FermiPlayerActivity.this.mCurrentTime.setText(FermiPlayerActivity.this.mEndTime.getText().toString());
                }
            }
        });
        setPlay(true);
        this.thread.start();
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.isExit = true;
        super.onDestroy();
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            this.bitmap.recycle();
            Log.d("player", "bitmap recycle");
        }
        this.bitmap = null;
        this.player.release(true);
        this.player = null;
        getIntent().putExtra(PLAY_NOW, false);
        System.gc();
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.player.setDecodeType(0);
        this.player.setVideoPath(this.url);
        if (this.play_start) {
            play();
        }
        showVideoThumbnail(this.bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.preferencesUtil.m12785a(this.current_position);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.fimi.soul.base.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.player.pause();
        this.current_position = this.player.getCurrentPosition();
        this.preferencesUtil.m12785a(this.current_position);
        this.playBtn.setBackgroundResource(C2300R.C2301drawable.drone_play);
        this.play_start = false;
        setPlay(false);
    }

    public synchronized void setPlay(boolean z) {
        this.isPlay = z;
    }
}
