package com.fimi.soul.media.player;

import android.os.Bundle;
import android.text.TextUtils;
import com.fimi.soul.module.setting.newhand.C3530b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes.dex */
public class FimiMediaMeta {
    public static final long AV_CH_BACK_CENTER = 256;
    public static final long AV_CH_BACK_LEFT = 16;
    public static final long AV_CH_BACK_RIGHT = 32;
    public static final long AV_CH_FRONT_CENTER = 4;
    public static final long AV_CH_FRONT_LEFT = 1;
    public static final long AV_CH_FRONT_LEFT_OF_CENTER = 64;
    public static final long AV_CH_FRONT_RIGHT = 2;
    public static final long AV_CH_FRONT_RIGHT_OF_CENTER = 128;
    public static final long AV_CH_LAYOUT_2POINT1 = 11;
    public static final long AV_CH_LAYOUT_2_1 = 259;
    public static final long AV_CH_LAYOUT_2_2 = 1539;
    public static final long AV_CH_LAYOUT_3POINT1 = 15;
    public static final long AV_CH_LAYOUT_4POINT0 = 263;
    public static final long AV_CH_LAYOUT_4POINT1 = 271;
    public static final long AV_CH_LAYOUT_5POINT0 = 1543;
    public static final long AV_CH_LAYOUT_5POINT0_BACK = 55;
    public static final long AV_CH_LAYOUT_5POINT1 = 1551;
    public static final long AV_CH_LAYOUT_5POINT1_BACK = 63;
    public static final long AV_CH_LAYOUT_6POINT0 = 1799;
    public static final long AV_CH_LAYOUT_6POINT0_FRONT = 1731;
    public static final long AV_CH_LAYOUT_6POINT1 = 1807;
    public static final long AV_CH_LAYOUT_6POINT1_BACK = 319;
    public static final long AV_CH_LAYOUT_6POINT1_FRONT = 1739;
    public static final long AV_CH_LAYOUT_7POINT0 = 1591;
    public static final long AV_CH_LAYOUT_7POINT0_FRONT = 1735;
    public static final long AV_CH_LAYOUT_7POINT1 = 1599;
    public static final long AV_CH_LAYOUT_7POINT1_WIDE = 1743;
    public static final long AV_CH_LAYOUT_7POINT1_WIDE_BACK = 255;
    public static final long AV_CH_LAYOUT_HEXAGONAL = 311;
    public static final long AV_CH_LAYOUT_MONO = 4;
    public static final long AV_CH_LAYOUT_OCTAGONAL = 1847;
    public static final long AV_CH_LAYOUT_QUAD = 51;
    public static final long AV_CH_LAYOUT_STEREO = 3;
    public static final long AV_CH_LAYOUT_STEREO_DOWNMIX = 1610612736;
    public static final long AV_CH_LAYOUT_SURROUND = 7;
    public static final long AV_CH_LOW_FREQUENCY = 8;
    public static final long AV_CH_LOW_FREQUENCY_2 = 34359738368L;
    public static final long AV_CH_SIDE_LEFT = 512;
    public static final long AV_CH_SIDE_RIGHT = 1024;
    public static final long AV_CH_STEREO_LEFT = 536870912;
    public static final long AV_CH_STEREO_RIGHT = 1073741824;
    public static final long AV_CH_SURROUND_DIRECT_LEFT = 8589934592L;
    public static final long AV_CH_SURROUND_DIRECT_RIGHT = 17179869184L;
    public static final long AV_CH_TOP_BACK_CENTER = 65536;
    public static final long AV_CH_TOP_BACK_LEFT = 32768;
    public static final long AV_CH_TOP_BACK_RIGHT = 131072;
    public static final long AV_CH_TOP_CENTER = 2048;
    public static final long AV_CH_TOP_FRONT_CENTER = 8192;
    public static final long AV_CH_TOP_FRONT_LEFT = 4096;
    public static final long AV_CH_TOP_FRONT_RIGHT = 16384;
    public static final long AV_CH_WIDE_LEFT = 2147483648L;
    public static final long AV_CH_WIDE_RIGHT = 4294967296L;
    public static final String IJKM_KEY_AUDIO_STREAM = "audio";
    public static final String IJKM_KEY_BITRATE = "bitrate";
    public static final String IJKM_KEY_CHANNEL_LAYOUT = "channel_layout";
    public static final String IJKM_KEY_CODEC_LONG_NAME = "codec_long_name";
    public static final String IJKM_KEY_CODEC_NAME = "codec_name";
    public static final String IJKM_KEY_CODEC_PROFILE = "codec_profile";
    public static final String IJKM_KEY_DURATION_US = "duration_us";
    public static final String IJKM_KEY_FORMAT = "format";
    public static final String IJKM_KEY_FPS_DEN = "fps_den";
    public static final String IJKM_KEY_FPS_NUM = "fps_num";
    public static final String IJKM_KEY_HEIGHT = "height";
    public static final String IJKM_KEY_SAMPLE_RATE = "sample_rate";
    public static final String IJKM_KEY_SAR_DEN = "sar_den";
    public static final String IJKM_KEY_SAR_NUM = "sar_num";
    public static final String IJKM_KEY_START_US = "start_us";
    public static final String IJKM_KEY_STREAMS = "streams";
    public static final String IJKM_KEY_TBR_DEN = "tbr_den";
    public static final String IJKM_KEY_TBR_NUM = "tbr_num";
    public static final String IJKM_KEY_TYPE = "type";
    public static final String IJKM_KEY_VIDEO_STREAM = "video";
    public static final String IJKM_KEY_WIDTH = "width";
    public static final String IJKM_VAL_TYPE__AUDIO = "audio";
    public static final String IJKM_VAL_TYPE__UNKNOWN = "unknown";
    public static final String IJKM_VAL_TYPE__VIDEO = "video";
    public IjkStreamMeta mAudioStream;
    public long mBitrate;
    public long mDurationUS;
    public String mFormat;
    public Bundle mMediaMeta;
    public long mStartUS;
    public ArrayList<IjkStreamMeta> mStreams;
    public IjkStreamMeta mVideoStream;

    /* loaded from: classes.dex */
    public static class IjkStreamMeta {
        public long mBitrate;
        public long mChannelLayout;
        public String mCodecLongName;
        public String mCodecName;
        public String mCodecProfile;
        public int mFpsDen;
        public int mFpsNum;
        public int mHeight;
        public int mIndex;
        public Bundle mMeta;
        public int mSampleRate;
        public int mSarDen;
        public int mSarNum;
        public int mTbrDen;
        public int mTbrNum;
        public String mType;
        public int mWidth;

        public IjkStreamMeta(int i) {
            this.mIndex = i;
        }

        public String getBitrateInline() {
            return this.mBitrate <= 0 ? C3530b.f14164ao : this.mBitrate < 1000 ? String.format(Locale.US, "%d bit/s", Long.valueOf(this.mBitrate)) : String.format(Locale.US, "%d kb/s", Long.valueOf(this.mBitrate / 1000));
        }

        public String getChannelLayoutInline() {
            return this.mChannelLayout <= 0 ? C3530b.f14164ao : this.mChannelLayout == 4 ? "mono" : this.mChannelLayout == 3 ? "stereo" : String.format(Locale.US, "%x", Long.valueOf(this.mChannelLayout));
        }

        public String getCodecLongNameInline() {
            return !TextUtils.isEmpty(this.mCodecLongName) ? this.mCodecLongName : !TextUtils.isEmpty(this.mCodecName) ? this.mCodecName : C3530b.f14164ao;
        }

        public String getFpsInline() {
            return (this.mFpsNum <= 0 || this.mFpsDen <= 0) ? C3530b.f14164ao : String.valueOf(this.mFpsNum / this.mFpsDen);
        }

        public int getInt(String str) {
            return getInt(str, 0);
        }

        public int getInt(String str, int i) {
            String string = getString(str);
            if (TextUtils.isEmpty(string)) {
                return i;
            }
            try {
                return Integer.parseInt(string);
            } catch (NumberFormatException e) {
                return i;
            }
        }

        public long getLong(String str) {
            return getLong(str, 0L);
        }

        public long getLong(String str, long j) {
            String string = getString(str);
            if (TextUtils.isEmpty(string)) {
                return j;
            }
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException e) {
                return j;
            }
        }

        public String getResolutionInline() {
            return (this.mWidth <= 0 || this.mHeight <= 0) ? C3530b.f14164ao : (this.mSarNum <= 0 || this.mSarDen <= 0) ? String.format(Locale.US, "%d x %d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)) : String.format(Locale.US, "%d x %d [SAR %d:%d]", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mSarNum), Integer.valueOf(this.mSarDen));
        }

        public String getSampleRateInline() {
            return this.mSampleRate <= 0 ? C3530b.f14164ao : String.format(Locale.US, "%d Hz", Integer.valueOf(this.mSampleRate));
        }

        public String getString(String str) {
            return this.mMeta.getString(str);
        }
    }

    public static FimiMediaMeta parse(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        FimiMediaMeta fimiMediaMeta = new FimiMediaMeta();
        fimiMediaMeta.mMediaMeta = bundle;
        fimiMediaMeta.mFormat = fimiMediaMeta.getString(IJKM_KEY_FORMAT);
        fimiMediaMeta.mDurationUS = fimiMediaMeta.getLong(IJKM_KEY_DURATION_US);
        fimiMediaMeta.mStartUS = fimiMediaMeta.getLong(IJKM_KEY_START_US);
        fimiMediaMeta.mBitrate = fimiMediaMeta.getLong(IJKM_KEY_BITRATE);
        int i = fimiMediaMeta.getInt("video", -1);
        int i2 = fimiMediaMeta.getInt("audio", -1);
        ArrayList<Bundle> parcelableArrayList = fimiMediaMeta.getParcelableArrayList(IJKM_KEY_STREAMS);
        if (parcelableArrayList == null) {
            return fimiMediaMeta;
        }
        Iterator<Bundle> it2 = parcelableArrayList.iterator();
        int i3 = -1;
        while (it2.hasNext()) {
            Bundle next = it2.next();
            i3++;
            if (next != null) {
                IjkStreamMeta ijkStreamMeta = new IjkStreamMeta(i3);
                ijkStreamMeta.mMeta = next;
                ijkStreamMeta.mType = ijkStreamMeta.getString("type");
                if (!TextUtils.isEmpty(ijkStreamMeta.mType)) {
                    ijkStreamMeta.mCodecName = ijkStreamMeta.getString(IJKM_KEY_CODEC_NAME);
                    ijkStreamMeta.mCodecProfile = ijkStreamMeta.getString(IJKM_KEY_CODEC_PROFILE);
                    ijkStreamMeta.mCodecLongName = ijkStreamMeta.getString(IJKM_KEY_CODEC_LONG_NAME);
                    ijkStreamMeta.mBitrate = ijkStreamMeta.getInt(IJKM_KEY_BITRATE);
                    if (ijkStreamMeta.mType.equalsIgnoreCase("video")) {
                        ijkStreamMeta.mWidth = ijkStreamMeta.getInt(IJKM_KEY_WIDTH);
                        ijkStreamMeta.mHeight = ijkStreamMeta.getInt(IJKM_KEY_HEIGHT);
                        ijkStreamMeta.mFpsNum = ijkStreamMeta.getInt(IJKM_KEY_FPS_NUM);
                        ijkStreamMeta.mFpsDen = ijkStreamMeta.getInt(IJKM_KEY_FPS_DEN);
                        ijkStreamMeta.mTbrNum = ijkStreamMeta.getInt(IJKM_KEY_TBR_NUM);
                        ijkStreamMeta.mTbrDen = ijkStreamMeta.getInt(IJKM_KEY_TBR_DEN);
                        ijkStreamMeta.mSarNum = ijkStreamMeta.getInt(IJKM_KEY_SAR_NUM);
                        ijkStreamMeta.mSarDen = ijkStreamMeta.getInt(IJKM_KEY_SAR_DEN);
                        if (i == i3) {
                            fimiMediaMeta.mVideoStream = ijkStreamMeta;
                        }
                    } else if (ijkStreamMeta.mType.equalsIgnoreCase("audio")) {
                        ijkStreamMeta.mSampleRate = ijkStreamMeta.getInt(IJKM_KEY_SAMPLE_RATE);
                        ijkStreamMeta.mChannelLayout = ijkStreamMeta.getLong(IJKM_KEY_CHANNEL_LAYOUT);
                        if (i2 == i3) {
                            fimiMediaMeta.mAudioStream = ijkStreamMeta;
                        }
                    }
                }
            }
        }
        return fimiMediaMeta;
    }

    public String getDurationInline() {
        long j = (this.mDurationUS + 5000) / 1000000;
        long j2 = j / 60;
        return String.format(Locale.US, "%02d:%02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60), Long.valueOf(j % 60));
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return i;
        }
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public long getLong(String str) {
        return getLong(str, 0L);
    }

    public long getLong(String str, long j) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return j;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            return j;
        }
    }

    public ArrayList<Bundle> getParcelableArrayList(String str) {
        return this.mMediaMeta.getParcelableArrayList(str);
    }

    public String getString(String str) {
        return this.mMediaMeta.getString(str);
    }
}
