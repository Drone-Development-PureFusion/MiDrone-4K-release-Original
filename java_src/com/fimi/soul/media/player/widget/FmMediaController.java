package com.fimi.soul.media.player.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.p001v4.view.accessibility.AccessibilityEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
import java.lang.reflect.Method;
import java.util.Formatter;
import java.util.Locale;
import p004b.p005a.p006a.p028b.C0359h;
import p244m.framework.p247ui.widget.asyncview.AsyncImageView;
/* loaded from: classes.dex */
public class FmMediaController extends FrameLayout {
    private static final int FADE_OUT = 1;
    private static final int SHOW_PROGRESS = 2;
    private static final int sDefaultTimeout = 3000;
    private static final int updatePause = 0;
    private View mAnchor;
    private Context mContext;
    private TextView mCurrentTime;
    private View mDecor;
    private WindowManager.LayoutParams mDecorLayoutParams;
    private boolean mDragging;
    private TextView mEndTime;
    private ImageButton mFfwdButton;
    private View.OnClickListener mFfwdListener;
    StringBuilder mFormatBuilder;
    Formatter mFormatter;
    private boolean mFromXml;
    private Handler mHandler;
    private View.OnLayoutChangeListener mLayoutChangeListener;
    private boolean mListenersSet;
    private ImageButton mNextButton;
    private View.OnClickListener mNextListener;
    private ImageButton mPauseButton;
    private View.OnClickListener mPauseListener;
    private MediaPlayerControl mPlayer;
    private ImageButton mPrevButton;
    private View.OnClickListener mPrevListener;
    private SeekBar mProgress;
    private ImageButton mRewButton;
    private View.OnClickListener mRewListener;
    private View mRoot;
    private SeekBar.OnSeekBarChangeListener mSeekListener;
    private boolean mShowing;
    private View.OnTouchListener mTouchListener;
    private boolean mUseFastForward;
    private Window mWindow;
    private WindowManager mWindowManager;

    /* loaded from: classes.dex */
    public interface MediaPlayerControl {
        boolean canPause();

        boolean canSeekBackward();

        boolean canSeekForward();

        int getAudioSessionId();

        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();

        boolean isPlaying();

        void pause();

        void seekTo(int i);

        void start();
    }

    public FmMediaController(Context context) {
        this(context, true);
    }

    public FmMediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.fimi.soul.media.player.widget.FmMediaController.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                FmMediaController.this.updateFloatingWindowLayout();
                if (FmMediaController.this.mShowing) {
                    FmMediaController.this.mWindowManager.updateViewLayout(FmMediaController.this.mDecor, FmMediaController.this.mDecorLayoutParams);
                }
            }
        };
        this.mTouchListener = new View.OnTouchListener() { // from class: com.fimi.soul.media.player.widget.FmMediaController.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0 || !FmMediaController.this.mShowing) {
                    return false;
                }
                FmMediaController.this.hide();
                return false;
            }
        };
        this.mHandler = new Handler() { // from class: com.fimi.soul.media.player.widget.FmMediaController.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        if (FmMediaController.this.mPlayer.isPlaying()) {
                            FmMediaController.this.mPauseButton.setBackgroundResource(C2300R.C2301drawable.drone_stop);
                            return;
                        } else {
                            FmMediaController.this.mPauseButton.setBackgroundResource(C2300R.C2301drawable.drone_play);
                            return;
                        }
                    case 1:
                        FmMediaController.this.hide();
                        return;
                    case 2:
                        Log.d("player", "handle SHOW_PROGRESS");
                        int progress = FmMediaController.this.setProgress();
                        if (FmMediaController.this.mDragging || !FmMediaController.this.mShowing || !FmMediaController.this.mPlayer.isPlaying()) {
                            return;
                        }
                        sendMessageDelayed(obtainMessage(2), 1000 - (progress % 1000));
                        return;
                    default:
                        return;
                }
            }
        };
        this.mPauseListener = new View.OnClickListener() { // from class: com.fimi.soul.media.player.widget.FmMediaController.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FmMediaController.this.doPauseResume();
                FmMediaController.this.show(FmMediaController.sDefaultTimeout);
            }
        };
        this.mSeekListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.fimi.soul.media.player.widget.FmMediaController.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                Log.d("player", "onProgressChanged");
                if (!z) {
                    return;
                }
                long duration = (FmMediaController.this.mPlayer.getDuration() * i) / 1000;
                FmMediaController.this.mPlayer.seekTo((int) duration);
                if (FmMediaController.this.mCurrentTime == null) {
                    return;
                }
                FmMediaController.this.mCurrentTime.setText(FmMediaController.this.stringForTime((int) duration));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("player", "onStartTrackingTouch");
                FmMediaController.this.show(C0359h.f695Y);
                FmMediaController.this.mDragging = true;
                FmMediaController.this.mHandler.removeMessages(2);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("player", "onStopTrackingTouch");
                FmMediaController.this.mDragging = false;
                FmMediaController.this.setProgress();
                FmMediaController.this.updatePausePlay();
                FmMediaController.this.show(FmMediaController.sDefaultTimeout);
                FmMediaController.this.mHandler.sendEmptyMessage(2);
            }
        };
        this.mRewListener = new View.OnClickListener() { // from class: com.fimi.soul.media.player.widget.FmMediaController.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FmMediaController.this.mPlayer.seekTo(FmMediaController.this.mPlayer.getCurrentPosition() - 5000);
                FmMediaController.this.setProgress();
                FmMediaController.this.show(FmMediaController.sDefaultTimeout);
            }
        };
        this.mFfwdListener = new View.OnClickListener() { // from class: com.fimi.soul.media.player.widget.FmMediaController.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FmMediaController.this.mPlayer.seekTo(FmMediaController.this.mPlayer.getCurrentPosition() + 15000);
                FmMediaController.this.setProgress();
                FmMediaController.this.show(FmMediaController.sDefaultTimeout);
            }
        };
        this.mRoot = this;
        this.mContext = context;
        this.mUseFastForward = true;
        this.mFromXml = true;
    }

    public FmMediaController(Context context, boolean z) {
        super(context);
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.fimi.soul.media.player.widget.FmMediaController.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                FmMediaController.this.updateFloatingWindowLayout();
                if (FmMediaController.this.mShowing) {
                    FmMediaController.this.mWindowManager.updateViewLayout(FmMediaController.this.mDecor, FmMediaController.this.mDecorLayoutParams);
                }
            }
        };
        this.mTouchListener = new View.OnTouchListener() { // from class: com.fimi.soul.media.player.widget.FmMediaController.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0 || !FmMediaController.this.mShowing) {
                    return false;
                }
                FmMediaController.this.hide();
                return false;
            }
        };
        this.mHandler = new Handler() { // from class: com.fimi.soul.media.player.widget.FmMediaController.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        if (FmMediaController.this.mPlayer.isPlaying()) {
                            FmMediaController.this.mPauseButton.setBackgroundResource(C2300R.C2301drawable.drone_stop);
                            return;
                        } else {
                            FmMediaController.this.mPauseButton.setBackgroundResource(C2300R.C2301drawable.drone_play);
                            return;
                        }
                    case 1:
                        FmMediaController.this.hide();
                        return;
                    case 2:
                        Log.d("player", "handle SHOW_PROGRESS");
                        int progress = FmMediaController.this.setProgress();
                        if (FmMediaController.this.mDragging || !FmMediaController.this.mShowing || !FmMediaController.this.mPlayer.isPlaying()) {
                            return;
                        }
                        sendMessageDelayed(obtainMessage(2), 1000 - (progress % 1000));
                        return;
                    default:
                        return;
                }
            }
        };
        this.mPauseListener = new View.OnClickListener() { // from class: com.fimi.soul.media.player.widget.FmMediaController.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FmMediaController.this.doPauseResume();
                FmMediaController.this.show(FmMediaController.sDefaultTimeout);
            }
        };
        this.mSeekListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.fimi.soul.media.player.widget.FmMediaController.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
                Log.d("player", "onProgressChanged");
                if (!z2) {
                    return;
                }
                long duration = (FmMediaController.this.mPlayer.getDuration() * i) / 1000;
                FmMediaController.this.mPlayer.seekTo((int) duration);
                if (FmMediaController.this.mCurrentTime == null) {
                    return;
                }
                FmMediaController.this.mCurrentTime.setText(FmMediaController.this.stringForTime((int) duration));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("player", "onStartTrackingTouch");
                FmMediaController.this.show(C0359h.f695Y);
                FmMediaController.this.mDragging = true;
                FmMediaController.this.mHandler.removeMessages(2);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("player", "onStopTrackingTouch");
                FmMediaController.this.mDragging = false;
                FmMediaController.this.setProgress();
                FmMediaController.this.updatePausePlay();
                FmMediaController.this.show(FmMediaController.sDefaultTimeout);
                FmMediaController.this.mHandler.sendEmptyMessage(2);
            }
        };
        this.mRewListener = new View.OnClickListener() { // from class: com.fimi.soul.media.player.widget.FmMediaController.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FmMediaController.this.mPlayer.seekTo(FmMediaController.this.mPlayer.getCurrentPosition() - 5000);
                FmMediaController.this.setProgress();
                FmMediaController.this.show(FmMediaController.sDefaultTimeout);
            }
        };
        this.mFfwdListener = new View.OnClickListener() { // from class: com.fimi.soul.media.player.widget.FmMediaController.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FmMediaController.this.mPlayer.seekTo(FmMediaController.this.mPlayer.getCurrentPosition() + 15000);
                FmMediaController.this.setProgress();
                FmMediaController.this.show(FmMediaController.sDefaultTimeout);
            }
        };
        this.mContext = context;
        this.mUseFastForward = z;
        initFloatingWindowLayout();
        initFloatingWindow();
    }

    private void disableUnsupportedButtons() {
        try {
            if (this.mPauseButton != null && !this.mPlayer.canPause()) {
                this.mPauseButton.setEnabled(false);
            }
            if (this.mRewButton != null && !this.mPlayer.canSeekBackward()) {
                this.mRewButton.setEnabled(false);
            }
            if (this.mFfwdButton == null || this.mPlayer.canSeekForward()) {
                return;
            }
            this.mFfwdButton.setEnabled(false);
        } catch (IncompatibleClassChangeError e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPauseResume() {
        if (this.mPlayer.isPlaying()) {
            this.mPlayer.pause();
        } else {
            this.mPlayer.start();
        }
        updatePausePlay();
    }

    private void initControllerView(View view) {
        this.mPauseButton = (ImageButton) view.findViewById(C2300R.C2302id.pause);
        if (this.mPauseButton != null) {
            this.mPauseButton.requestFocus();
            this.mPauseButton.setOnClickListener(this.mPauseListener);
        }
        this.mFfwdButton = (ImageButton) view.findViewById(C2300R.C2302id.ffwd);
        if (this.mFfwdButton != null) {
            this.mFfwdButton.setOnClickListener(this.mFfwdListener);
            if (!this.mFromXml) {
                this.mFfwdButton.setVisibility(this.mUseFastForward ? 0 : 8);
            }
        }
        this.mRewButton = (ImageButton) view.findViewById(C2300R.C2302id.rew);
        if (this.mRewButton != null) {
            this.mRewButton.setOnClickListener(this.mRewListener);
            if (!this.mFromXml) {
                this.mRewButton.setVisibility(this.mUseFastForward ? 0 : 8);
            }
        }
        this.mNextButton = (ImageButton) view.findViewById(C2300R.C2302id.next);
        if (this.mNextButton != null && !this.mFromXml && !this.mListenersSet) {
            this.mNextButton.setVisibility(8);
        }
        this.mPrevButton = (ImageButton) view.findViewById(C2300R.C2302id.prev);
        if (this.mPrevButton != null && !this.mFromXml && !this.mListenersSet) {
            this.mPrevButton.setVisibility(8);
        }
        this.mProgress = (SeekBar) view.findViewById(C2300R.C2302id.fmmediacontroller_progress);
        if (this.mProgress != null) {
            if (this.mProgress instanceof SeekBar) {
                this.mProgress.setOnSeekBarChangeListener(this.mSeekListener);
            }
            this.mProgress.setMax(1000);
        }
        this.mEndTime = (TextView) view.findViewById(C2300R.C2302id.time);
        this.mCurrentTime = (TextView) view.findViewById(C2300R.C2302id.time_current);
        this.mFormatBuilder = new StringBuilder();
        this.mFormatter = new Formatter(this.mFormatBuilder, Locale.getDefault());
        C3658ar.m7612a(((Activity) this.mContext).getAssets(), this.mEndTime, this.mCurrentTime);
        installPrevNextListeners();
    }

    private void initFloatingWindow() {
        this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
        initWindow();
        this.mWindow.setWindowManager(this.mWindowManager, null, null);
        this.mWindow.requestFeature(1);
        this.mDecor = this.mWindow.getDecorView();
        this.mDecor.setOnTouchListener(this.mTouchListener);
        this.mWindow.setContentView(this);
        this.mWindow.setBackgroundDrawableResource(AsyncImageView.f21295a);
        this.mWindow.setVolumeControlStream(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        requestFocus();
    }

    private void initFloatingWindowLayout() {
        this.mDecorLayoutParams = new WindowManager.LayoutParams();
        WindowManager.LayoutParams layoutParams = this.mDecorLayoutParams;
        layoutParams.gravity = 51;
        layoutParams.height = -2;
        layoutParams.x = 0;
        layoutParams.format = -3;
        layoutParams.type = 1000;
        layoutParams.flags |= 8519712;
        layoutParams.token = null;
        layoutParams.windowAnimations = 0;
    }

    private void initWindow() {
        try {
            Method[] methods = Class.forName("com.android.internal.policy.PolicyManager").getMethods();
            Method method = null;
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().endsWith("makeNewWindow")) {
                    method = methods[i];
                }
            }
            this.mWindow = (Window) method.invoke(null, this.mContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void installPrevNextListeners() {
        boolean z = true;
        if (this.mNextButton != null) {
            this.mNextButton.setOnClickListener(this.mNextListener);
            this.mNextButton.setEnabled(this.mNextListener != null);
        }
        if (this.mPrevButton != null) {
            this.mPrevButton.setOnClickListener(this.mPrevListener);
            ImageButton imageButton = this.mPrevButton;
            if (this.mPrevListener == null) {
                z = false;
            }
            imageButton.setEnabled(z);
        }
    }

    public static void main(String[] strArr) {
        System.out.println(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setProgress() {
        Log.d("player", "setProgress");
        if (this.mPlayer == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.mPlayer.getCurrentPosition();
        int duration = this.mPlayer.getDuration();
        Log.d("player", "position" + currentPosition + " duration" + duration);
        if (this.mProgress != null && duration > 0) {
            if (duration / 1000 > 0) {
                this.mProgress.setProgress((int) ((1000 * (currentPosition / 1000)) / (duration / 1000)));
            } else {
                this.mProgress.setProgress(0);
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    public String stringForTime(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.mFormatBuilder.setLength(0);
        return i5 > 0 ? this.mFormatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.mFormatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFloatingWindowLayout() {
        int[] iArr = new int[2];
        this.mAnchor.getLocationOnScreen(iArr);
        this.mDecor.measure(View.MeasureSpec.makeMeasureSpec(this.mAnchor.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.mAnchor.getHeight(), Integer.MIN_VALUE));
        WindowManager.LayoutParams layoutParams = this.mDecorLayoutParams;
        layoutParams.width = this.mAnchor.getWidth();
        layoutParams.x = iArr[0] + ((this.mAnchor.getWidth() - layoutParams.width) / 2);
        layoutParams.y = (iArr[1] + this.mAnchor.getHeight()) - this.mDecor.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePausePlay() {
        if (this.mRoot == null || this.mPauseButton == null) {
            return;
        }
        if (this.mPlayer.isPlaying()) {
            this.mPauseButton.setBackgroundResource(C2300R.C2301drawable.drone_stop);
        } else {
            this.mPauseButton.setBackgroundResource(C2300R.C2301drawable.drone_play);
        }
        this.mHandler.sendEmptyMessageDelayed(0, 200L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        boolean z = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        if (keyCode == 79 || keyCode == 85 || keyCode == 62) {
            if (z) {
                doPauseResume();
                show(sDefaultTimeout);
                if (this.mPauseButton != null) {
                    this.mPauseButton.requestFocus();
                }
            }
            return true;
        } else if (keyCode == 126) {
            if (z && !this.mPlayer.isPlaying()) {
                this.mPlayer.start();
                updatePausePlay();
                show(sDefaultTimeout);
            }
            return true;
        } else if (keyCode == 86 || keyCode == 127) {
            if (z && this.mPlayer.isPlaying()) {
                this.mPlayer.pause();
                updatePausePlay();
                show(sDefaultTimeout);
            }
            return true;
        } else if (keyCode == 25 || keyCode == 24 || keyCode == 164 || keyCode == 27) {
            return super.dispatchKeyEvent(keyEvent);
        } else {
            if (keyCode == 4) {
                if (z) {
                    hide();
                    ((Activity) this.mContext).finish();
                }
                return true;
            } else if (keyCode != 82) {
                show(sDefaultTimeout);
                return super.dispatchKeyEvent(keyEvent);
            } else {
                if (z) {
                    hide();
                }
                return true;
            }
        }
    }

    public void hide() {
        if (this.mAnchor != null && this.mShowing) {
            try {
                this.mHandler.removeMessages(2);
                this.mWindowManager.removeView(this.mDecor);
            } catch (IllegalArgumentException e) {
                Log.w("MediaController", "already removed");
            }
            this.mShowing = false;
        }
    }

    public boolean isShowing() {
        return this.mShowing;
    }

    protected View makeControllerView() {
        this.mRoot = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(C2300R.layout.fm_media_controller, (ViewGroup) null);
        initControllerView(this.mRoot);
        return this.mRoot;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        if (this.mRoot != null) {
            initControllerView(this.mRoot);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(FmMediaController.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(FmMediaController.class.getName());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        show(sDefaultTimeout);
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        show(sDefaultTimeout);
        return false;
    }

    public void setAnchorView(View view) {
        if (this.mAnchor != null) {
            this.mAnchor.removeOnLayoutChangeListener(this.mLayoutChangeListener);
        }
        this.mAnchor = view;
        if (this.mAnchor != null) {
            this.mAnchor.addOnLayoutChangeListener(this.mLayoutChangeListener);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        removeAllViews();
        addView(makeControllerView(), layoutParams);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        boolean z2 = true;
        if (this.mPauseButton != null) {
            this.mPauseButton.setEnabled(z);
        }
        if (this.mFfwdButton != null) {
            this.mFfwdButton.setEnabled(z);
        }
        if (this.mRewButton != null) {
            this.mRewButton.setEnabled(z);
        }
        if (this.mNextButton != null) {
            this.mNextButton.setEnabled(z && this.mNextListener != null);
        }
        if (this.mPrevButton != null) {
            ImageButton imageButton = this.mPrevButton;
            if (!z || this.mPrevListener == null) {
                z2 = false;
            }
            imageButton.setEnabled(z2);
        }
        if (this.mProgress != null) {
            this.mProgress.setEnabled(z);
        }
        disableUnsupportedButtons();
        super.setEnabled(z);
    }

    public void setMediaPlayer(MediaPlayerControl mediaPlayerControl) {
        this.mPlayer = mediaPlayerControl;
        updatePausePlay();
    }

    public void setPrevNextListeners(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mNextListener = onClickListener;
        this.mPrevListener = onClickListener2;
        this.mListenersSet = true;
        if (this.mRoot != null) {
            installPrevNextListeners();
            if (this.mNextButton != null && !this.mFromXml) {
                this.mNextButton.setVisibility(0);
            }
            if (this.mPrevButton == null || this.mFromXml) {
                return;
            }
            this.mPrevButton.setVisibility(0);
        }
    }

    public void show() {
        show(sDefaultTimeout);
    }

    public void show(int i) {
        Log.d("player", "show");
        if (!this.mShowing && this.mAnchor != null) {
            setProgress();
            if (this.mPauseButton != null) {
                this.mPauseButton.requestFocus();
            }
            disableUnsupportedButtons();
            updateFloatingWindowLayout();
            try {
                this.mWindowManager.addView(this.mDecor, this.mDecorLayoutParams);
            } catch (Exception e) {
                Log.e("player", "mWindowManager addview error");
            }
            this.mShowing = true;
        }
        updatePausePlay();
        this.mHandler.sendEmptyMessage(2);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        if (i != 0) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(obtainMessage, i);
        }
    }

    public void update() {
        updatePausePlay();
    }
}
