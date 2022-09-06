package com.fimi.soul.media.player;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.fimi.soul.media.player.annotations.AccessedByNative;
import com.fimi.soul.media.player.annotations.CalledByNative;
import com.fimi.soul.media.player.pragma.DebugLog;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public final class FimiMediaPlayer extends AbstractMediaPlayer {
    public static final int IJK_LOG_DEBUG = 3;
    public static final int IJK_LOG_DEFAULT = 1;
    public static final int IJK_LOG_ERROR = 6;
    public static final int IJK_LOG_FATAL = 7;
    public static final int IJK_LOG_INFO = 4;
    public static final int IJK_LOG_SILENT = 8;
    public static final int IJK_LOG_UNKNOWN = 0;
    public static final int IJK_LOG_VERBOSE = 2;
    public static final int IJK_LOG_WARN = 5;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_ERROR = 100;
    private static final int MEDIA_INFO = 200;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PLAYBACK_START_STREAM = 7;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    protected static final int MEDIA_SET_VIDEO_SAR = 10001;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_TIMED_TEXT = 99;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int SDL_FCC_RV16 = 909203026;
    public static final int SDL_FCC_RV32 = 842225234;
    public static final int SDL_FCC_YV12 = 842094169;
    private static FimiMediaPlayer fimiMediaPlayer;
    private String mDataSource;
    private EventHandler mEventHandler;
    @AccessedByNative
    private int mListenerContext;
    @AccessedByNative
    private long mNativeMediaPlayer;
    @AccessedByNative
    private int mNativeSurfaceTexture;
    private OnControlMessageListener mOnControlMessageListener;
    private OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    private OnNativeInvokeListener mOnNativeInvokeListener;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private PowerManager.WakeLock mWakeLock;
    private static final String TAG = FimiMediaPlayer.class.getName();
    private static FimiLibLoader sLocalLibLoader = new FimiLibLoader() { // from class: com.fimi.soul.media.player.FimiMediaPlayer.1
        @Override // com.fimi.soul.media.player.FimiLibLoader
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    };
    private static volatile boolean mIsLibLoaded = false;
    private static volatile boolean mIsNativeInitialized = false;

    /* loaded from: classes.dex */
    public static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();

        @Override // com.fimi.soul.media.player.FimiMediaPlayer.OnMediaCodecSelectListener
        @TargetApi(16)
        public String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2) {
            FimiMediaCodecInfo fimiMediaCodecInfo;
            String[] supportedTypes;
            FimiMediaCodecInfo fimiMediaCodecInfo2;
            if (Build.VERSION.SDK_INT >= 16 && !TextUtils.isEmpty(str)) {
                Log.i(FimiMediaPlayer.TAG, String.format(Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", str, Integer.valueOf(i), Integer.valueOf(i2)));
                ArrayList arrayList = new ArrayList();
                int codecCount = MediaCodecList.getCodecCount();
                for (int i3 = 0; i3 < codecCount; i3++) {
                    MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                    Log.d(FimiMediaPlayer.TAG, String.format(Locale.US, "  found codec: %s", codecInfoAt.getName()));
                    if (!codecInfoAt.isEncoder() && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                        for (String str2 : supportedTypes) {
                            if (!TextUtils.isEmpty(str2)) {
                                Log.d(FimiMediaPlayer.TAG, String.format(Locale.US, "    mime: %s", str2));
                                if (str2.equalsIgnoreCase(str) && (fimiMediaCodecInfo2 = FimiMediaCodecInfo.setupCandidate(codecInfoAt, str)) != null) {
                                    arrayList.add(fimiMediaCodecInfo2);
                                    Log.i(FimiMediaPlayer.TAG, String.format(Locale.US, "candidate codec: %s rank=%d", codecInfoAt.getName(), Integer.valueOf(fimiMediaCodecInfo2.mRank)));
                                    fimiMediaCodecInfo2.dumpProfileLevels(str);
                                }
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                FimiMediaCodecInfo fimiMediaCodecInfo3 = (FimiMediaCodecInfo) arrayList.get(0);
                Iterator it2 = arrayList.iterator();
                while (true) {
                    fimiMediaCodecInfo = fimiMediaCodecInfo3;
                    if (!it2.hasNext()) {
                        break;
                    }
                    fimiMediaCodecInfo3 = (FimiMediaCodecInfo) it2.next();
                    if (fimiMediaCodecInfo3.mRank <= fimiMediaCodecInfo.mRank) {
                        fimiMediaCodecInfo3 = fimiMediaCodecInfo;
                    }
                }
                if (fimiMediaCodecInfo.mRank < FimiMediaCodecInfo.RANK_LAST_CHANCE) {
                    Log.w(FimiMediaPlayer.TAG, String.format(Locale.US, "unaccetable codec: %s", fimiMediaCodecInfo.mCodecInfo.getName()));
                    return null;
                }
                Log.i(FimiMediaPlayer.TAG, String.format(Locale.US, "selected codec: %s rank=%d", fimiMediaCodecInfo.mCodecInfo.getName(), Integer.valueOf(fimiMediaCodecInfo.mRank)));
                return fimiMediaCodecInfo.mCodecInfo.getName();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class EventHandler extends Handler {
        private WeakReference<FimiMediaPlayer> mWeakPlayer;

        public EventHandler(FimiMediaPlayer fimiMediaPlayer, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(fimiMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FimiMediaPlayer fimiMediaPlayer = this.mWeakPlayer.get();
            if (fimiMediaPlayer == null || fimiMediaPlayer.mNativeMediaPlayer == 0) {
                DebugLog.m9910w(FimiMediaPlayer.TAG, "FimiMediaPlayer went away with unhandled events");
                return;
            }
            switch (message.what) {
                case 0:
                case 99:
                    return;
                case 1:
                    fimiMediaPlayer.notifyOnPrepared();
                    return;
                case 2:
                    fimiMediaPlayer.notifyOnCompletion(2);
                    fimiMediaPlayer.stayAwake(false);
                    return;
                case 3:
                    long j = message.arg1;
                    if (j < 0) {
                        j = 0;
                    }
                    long duration = fimiMediaPlayer.getDuration();
                    long j2 = duration > 0 ? (j * 100) / duration : 0L;
                    if (j2 >= 100) {
                        j2 = 100;
                    }
                    fimiMediaPlayer.notifyOnBufferingUpdate((int) j2);
                    return;
                case 4:
                    fimiMediaPlayer.notifyOnSeekComplete();
                    return;
                case 5:
                    fimiMediaPlayer.mVideoWidth = message.arg1;
                    fimiMediaPlayer.mVideoHeight = message.arg2;
                    fimiMediaPlayer.notifyOnVideoSizeChanged(fimiMediaPlayer.mVideoWidth, fimiMediaPlayer.mVideoHeight, fimiMediaPlayer.mVideoSarNum, fimiMediaPlayer.mVideoSarDen);
                    return;
                case 7:
                    fimiMediaPlayer.notifyOnStartStream();
                    return;
                case 100:
                    DebugLog.m9916e(FimiMediaPlayer.TAG, "Error (" + message.arg1 + Constants.ACCEPT_TIME_SEPARATOR_SP + message.arg2 + ")");
                    if (!fimiMediaPlayer.notifyOnError(message.arg1, message.arg2)) {
                        fimiMediaPlayer.notifyOnCompletion(100);
                    }
                    fimiMediaPlayer.stayAwake(false);
                    return;
                case 200:
                    switch (message.arg1) {
                        case 3:
                            DebugLog.m9914i(FimiMediaPlayer.TAG, "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
                            break;
                    }
                    fimiMediaPlayer.notifyOnInfo(message.arg1, message.arg2);
                    return;
                case 10001:
                    fimiMediaPlayer.mVideoSarNum = message.arg1;
                    fimiMediaPlayer.mVideoSarDen = message.arg2;
                    fimiMediaPlayer.notifyOnVideoSizeChanged(fimiMediaPlayer.mVideoWidth, fimiMediaPlayer.mVideoHeight, fimiMediaPlayer.mVideoSarNum, fimiMediaPlayer.mVideoSarDen);
                    return;
                default:
                    DebugLog.m9916e(FimiMediaPlayer.TAG, "Unknown message type " + message.what);
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnControlMessageListener {
        String onControlResolveSegmentUrl(int i);
    }

    /* loaded from: classes.dex */
    public interface OnMediaCodecSelectListener {
        String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnNativeInvokeListener {
        boolean onNativeInvoke(int i, Bundle bundle);
    }

    public FimiMediaPlayer() {
        this(sLocalLibLoader);
    }

    public FimiMediaPlayer(FimiLibLoader fimiLibLoader) {
        this.mWakeLock = null;
        initPlayer(fimiLibLoader);
    }

    private native String _getAudioCodecInfo();

    private static native String _getColorFormatName(int i);

    private native Bundle _getMediaMeta();

    private native String _getVideoCodecInfo();

    private native void _pause();

    private native void _release();

    private native void _reset();

    private native void _setDataSource(String str, String[] strArr, String[] strArr2);

    private native void _setDataSourceFd(int i);

    private native void _setOption(int i, String str, long j);

    private native void _setOption(int i, String str, String str2);

    private native void _setVideoSurface(Surface surface);

    private native void _start();

    private native void _stop();

    private native int _stream2jpg(String str, String str2);

    public static String getColorFormatName(int i) {
        return _getColorFormatName(i);
    }

    public static FimiMediaPlayer getIntance() {
        return fimiMediaPlayer == null ? new FimiMediaPlayer() : fimiMediaPlayer;
    }

    private static void initNativeOnce() {
        synchronized (FimiMediaPlayer.class) {
            long lastModified = new File("FimiMediaPlayer.java").lastModified();
            if (!mIsNativeInitialized) {
                native_init();
                mIsNativeInitialized = true;
                DebugLog.m9910w(TAG, "aizj version=" + lastModified);
            }
        }
    }

    private void initPlayer(FimiLibLoader fimiLibLoader) {
        loadLibrariesOnce(fimiLibLoader);
        initNativeOnce();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new EventHandler(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        native_setup(new WeakReference(this));
    }

    public static void loadLibrariesOnce(FimiLibLoader fimiLibLoader) {
        synchronized (FimiMediaPlayer.class) {
            if (!mIsLibLoaded) {
                if (fimiLibLoader == null) {
                    fimiLibLoader = sLocalLibLoader;
                }
                fimiLibLoader.loadLibrary("fmffmpeg");
                fimiLibLoader.loadLibrary("fmsdl");
                fimiLibLoader.loadLibrary("fmplayer");
                mIsLibLoaded = true;
            }
        }
    }

    private native void native_finalize();

    private static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    public static native void native_setLogLevel(int i);

    private native void native_setup(Object obj);

    @CalledByNative
    private static String onControlResolveSegmentUrl(Object obj, int i) {
        OnControlMessageListener onControlMessageListener;
        DebugLog.ifmt(TAG, "onControlResolveSegmentUrl %d", Integer.valueOf(i));
        if (obj == null || !(obj instanceof WeakReference)) {
            return null;
        }
        FimiMediaPlayer fimiMediaPlayer2 = (FimiMediaPlayer) ((WeakReference) obj).get();
        if (fimiMediaPlayer2 != null && (onControlMessageListener = fimiMediaPlayer2.mOnControlMessageListener) != null) {
            return onControlMessageListener.onControlResolveSegmentUrl(i);
        }
        return null;
    }

    @CalledByNative
    private static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        OnNativeInvokeListener onNativeInvokeListener;
        DebugLog.ifmt(TAG, "onNativeInvoke %d", Integer.valueOf(i));
        if (obj == null || !(obj instanceof WeakReference)) {
            return false;
        }
        FimiMediaPlayer fimiMediaPlayer2 = (FimiMediaPlayer) ((WeakReference) obj).get();
        if (fimiMediaPlayer2 != null && (onNativeInvokeListener = fimiMediaPlayer2.mOnNativeInvokeListener) != null) {
            return onNativeInvokeListener.onNativeInvoke(i, bundle);
        }
        return false;
    }

    @CalledByNative
    private static String onSelectCodec(Object obj, String str, int i, int i2) {
        if (obj == null || !(obj instanceof WeakReference)) {
            return null;
        }
        FimiMediaPlayer fimiMediaPlayer2 = (FimiMediaPlayer) ((WeakReference) obj).get();
        if (fimiMediaPlayer2 == null) {
            return null;
        }
        OnMediaCodecSelectListener onMediaCodecSelectListener = fimiMediaPlayer2.mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onMediaCodecSelect(fimiMediaPlayer2, str, i, i2);
    }

    @CalledByNative
    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        FimiMediaPlayer fimiMediaPlayer2;
        if (obj == null || (fimiMediaPlayer2 = (FimiMediaPlayer) ((WeakReference) obj).get()) == null) {
            return;
        }
        if (i == 200 && i2 == 2) {
            fimiMediaPlayer2.start();
        }
        if (fimiMediaPlayer2.mEventHandler == null) {
            return;
        }
        fimiMediaPlayer2.mEventHandler.sendMessage(fimiMediaPlayer2.mEventHandler.obtainMessage(i, i2, i3, obj2));
    }

    private void setDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        setDataSource(fileDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Wakelock"})
    public void stayAwake(boolean z) {
        if (this.mWakeLock != null) {
            if (z && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        if (this.mSurfaceHolder != null) {
            this.mSurfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
    }

    public void RtmpStatusCB(int i, int i2, int i3) {
        notifyRtmpStatusCBOnLiveVideoListener(i, i2, i3);
    }

    public native void _prepareAsync();

    public native int _recEmergencySave(String str, int i);

    public native int _recStart(String str, int i, int i2);

    public native int _recStop();

    public native int _setDeviceInfo(int i, int i2);

    public native void _setPreview(int i);

    public int concatVedio(String str, String str2) {
        return fm_avp_concatVid(str, str2);
    }

    protected void finalize() {
        native_finalize();
    }

    public native int fm_avp_concatVid(String str, String str2);

    public native int fm_avp_mergeAV(String str, String str2, String str3);

    public native int fm_avp_splitVid(String str, String str2, int i, int i2);

    public native int fm_avp_vid2img(String str, String str2);

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public native int getAudioSessionId();

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public native long getCurrentPosition();

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public String getDataSource() {
        return this.mDataSource;
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public native long getDuration();

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.mMediaPlayerName = "ijkplayer";
        String _getVideoCodecInfo = _getVideoCodecInfo();
        if (!TextUtils.isEmpty(_getVideoCodecInfo)) {
            String[] split = _getVideoCodecInfo.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length >= 2) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = split[1];
            } else if (split.length >= 1) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = "";
            }
        }
        String _getAudioCodecInfo = _getAudioCodecInfo();
        if (!TextUtils.isEmpty(_getAudioCodecInfo)) {
            String[] split2 = _getAudioCodecInfo.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split2.length >= 2) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = split2[1];
            } else if (split2.length >= 1) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = "";
            }
        }
        try {
            mediaInfo.mMeta = FimiMediaMeta.parse(_getMediaMeta());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return mediaInfo;
    }

    public Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public native boolean isPlaying();

    public int mergeAudio2Vedio(String str, String str2, String str3) {
        return fm_avp_mergeAV(str, str2, str3);
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void pause() {
        stayAwake(false);
        _pause();
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public int playerRtmpStart(String str, int i) {
        return rtmpStart(str, i);
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public int playerRtmpStop(int i) {
        return rtmpStop(i);
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void prepareAsync() {
        _prepareAsync();
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public int recEmergencySave(String str, int i) {
        Log.i("peter", "recEmergencySave;");
        return _recEmergencySave(str, i);
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public int recStart(String str, int i, int i2) {
        Log.i("peter", "rec_start;");
        return _recStart(str, i, i2);
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public int recStop() {
        return _recStop();
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void release() {
        stayAwake(false);
        updateSurfaceScreenOn();
        resetListeners();
        _release();
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void reset() {
        stayAwake(false);
        _reset();
        this.mEventHandler.removeCallbacksAndMessages(null);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    @Override // com.fimi.soul.media.player.AbstractMediaPlayer
    public void resetListeners() {
        super.resetListeners();
        this.mOnMediaCodecSelectListener = null;
    }

    public native int rtmpStart(String str, int i);

    public native int rtmpStop(int i);

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public native void seekTo(long j);

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void setAudioStreamType(int i) {
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void setDataSource(Context context, Uri uri) {
        setDataSource(context, uri, (Map<String, String>) null);
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    @TargetApi(14)
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        AssetFileDescriptor assetFileDescriptor;
        Throwable th;
        if (uri == null) {
            return;
        }
        String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            setDataSource(uri.getPath());
        } else if ("content".equals(scheme) && "settings".equals(uri.getAuthority()) && (uri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri))) == null) {
            throw new FileNotFoundException("Failed to resolve default ringtone");
        } else {
            AssetFileDescriptor assetFileDescriptor2 = null;
            try {
                assetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
                if (assetFileDescriptor == null) {
                    if (assetFileDescriptor == null) {
                        return;
                    }
                    assetFileDescriptor.close();
                    return;
                }
                try {
                    if (assetFileDescriptor.getDeclaredLength() < 0) {
                        setDataSource(assetFileDescriptor.getFileDescriptor());
                    } else {
                        setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getDeclaredLength());
                    }
                    if (assetFileDescriptor == null) {
                        return;
                    }
                    assetFileDescriptor.close();
                } catch (IOException e) {
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    Log.d(TAG, "Couldn't open file on client side, trying server side");
                    setDataSource(uri.toString(), map);
                } catch (SecurityException e2) {
                    assetFileDescriptor2 = assetFileDescriptor;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    Log.d(TAG, "Couldn't open file on client side, trying server side");
                    setDataSource(uri.toString(), map);
                } catch (Throwable th2) {
                    th = th2;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                assetFileDescriptor = null;
            } catch (SecurityException e4) {
            } catch (Throwable th3) {
                assetFileDescriptor = null;
                th = th3;
            }
        }
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    @TargetApi(13)
    public void setDataSource(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 12) {
            ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
            try {
                _setDataSourceFd(dup.getFd());
                return;
            } finally {
                dup.close();
            }
        }
        try {
            Field declaredField = fileDescriptor.getClass().getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            _setDataSourceFd(declaredField.getInt(fileDescriptor));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void setDataSource(String str) {
        this.mDataSource = str;
        _setDataSource(str, null, null);
    }

    public void setDataSource(String str, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":");
                if (!TextUtils.isEmpty(entry.getValue())) {
                    sb.append(entry.getValue());
                }
                sb.append(C3947a.f16890a);
            }
        }
        setDataSource(str);
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public int setDeviceInfo(int i, int i2) {
        _setDeviceInfo(i, i2);
        return 0;
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        _setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        updateSurfaceScreenOn();
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    public void setOnControlMessageListener(OnControlMessageListener onControlMessageListener) {
        this.mOnControlMessageListener = onControlMessageListener;
    }

    public void setOnMediaCodecSelectListener(OnMediaCodecSelectListener onMediaCodecSelectListener) {
        this.mOnMediaCodecSelectListener = onMediaCodecSelectListener;
    }

    public void setOnNativeInvokeListener(OnNativeInvokeListener onNativeInvokeListener) {
        this.mOnNativeInvokeListener = onNativeInvokeListener;
    }

    public void setOption(int i, String str, long j) {
        _setOption(i, str, j);
    }

    public void setOption(int i, String str, String str2) {
        _setOption(i, str, str2);
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void setPreview(int i) {
        _setPreview(i);
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                DebugLog.m9910w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void setSurface(Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            DebugLog.m9910w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public native void setVolume(float f, float f2);

    @Override // com.fimi.soul.media.player.IMediaPlayer
    @SuppressLint({"Wakelock"})
    public void setWakeMode(Context context, int i) {
        boolean z;
        boolean z2;
        if (this.mWakeLock != null) {
            if (this.mWakeLock.isHeld()) {
                z2 = true;
                this.mWakeLock.release();
            } else {
                z2 = false;
            }
            this.mWakeLock = null;
            z = z2;
        } else {
            z = false;
        }
        this.mWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(536870912 | i, FimiMediaPlayer.class.getName());
        this.mWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    public int spliteVedio(String str, String str2, int i, int i2) {
        return fm_avp_splitVid(str, str2, i, i2);
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void start() {
        stayAwake(true);
        _start();
    }

    @Override // com.fimi.soul.media.player.IMediaPlayer
    public void stop() {
        stayAwake(false);
        _stop();
    }

    public int vid2imgArray(String str, String str2) {
        return fm_avp_vid2img(str, str2);
    }

    public boolean videoToJpg(String str, String str2) {
        return str != null && !"".equals(str) && _stream2jpg(str, str2) == 0;
    }
}
