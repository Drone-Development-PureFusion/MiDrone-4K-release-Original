package com.fimi.soul.media.player;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.connect.common.Constants;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* loaded from: classes.dex */
public class FimiMediaCodecInfo {
    private static final String TAG = "FimiMediaCodecInfo";
    private static Map<String, Integer> sKnownCodecList;
    public MediaCodecInfo mCodecInfo;
    public String mMimeType;
    public int mRank = 0;
    public static int RANK_MAX = 1000;
    public static int RANK_TESTED = IMediaPlayer.MEDIA_INFO_BAD_INTERLEAVING;
    public static int RANK_ACCEPTABLE = IMediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING;
    public static int RANK_LAST_CHANCE = 600;
    public static int RANK_SECURE = 300;
    public static int RANK_SOFTWARE = 200;
    public static int RANK_NON_STANDARD = 100;
    public static int RANK_NO_SENSE = 0;

    private static synchronized Map<String, Integer> getKnownCodecList() {
        Map<String, Integer> map;
        synchronized (FimiMediaCodecInfo.class) {
            if (sKnownCodecList != null) {
                map = sKnownCodecList;
            } else {
                sKnownCodecList = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                sKnownCodecList.put("OMX.Nvidia.h264.decode", Integer.valueOf(RANK_TESTED));
                sKnownCodecList.put("OMX.Nvidia.h264.decode.secure", Integer.valueOf(RANK_SECURE));
                sKnownCodecList.put("OMX.Intel.hw_vd.h264", Integer.valueOf(RANK_TESTED + 1));
                sKnownCodecList.put("OMX.Intel.VideoDecoder.AVC", Integer.valueOf(RANK_TESTED));
                sKnownCodecList.put("OMX.qcom.video.decoder.avc", Integer.valueOf(RANK_TESTED));
                sKnownCodecList.put("OMX.ittiam.video.decoder.avc", Integer.valueOf(RANK_NO_SENSE));
                sKnownCodecList.put("OMX.SEC.avc.dec", Integer.valueOf(RANK_TESTED));
                sKnownCodecList.put("OMX.SEC.AVC.Decoder", Integer.valueOf(RANK_TESTED - 1));
                sKnownCodecList.put("OMX.SEC.avcdec", Integer.valueOf(RANK_TESTED - 2));
                sKnownCodecList.put("OMX.SEC.avc.sw.dec", Integer.valueOf(RANK_SOFTWARE));
                sKnownCodecList.put("OMX.Exynos.avc.dec", Integer.valueOf(RANK_TESTED));
                sKnownCodecList.put("OMX.Exynos.AVC.Decoder", Integer.valueOf(RANK_TESTED - 1));
                sKnownCodecList.put("OMX.k3.video.decoder.avc", Integer.valueOf(RANK_TESTED));
                sKnownCodecList.put("OMX.IMG.MSVDX.Decoder.AVC", Integer.valueOf(RANK_TESTED));
                sKnownCodecList.put("OMX.TI.DUCATI1.VIDEO.DECODER", Integer.valueOf(RANK_TESTED));
                sKnownCodecList.put("OMX.rk.video_decoder.avc", Integer.valueOf(RANK_TESTED));
                sKnownCodecList.put("OMX.amlogic.avc.decoder.awesome", Integer.valueOf(RANK_TESTED));
                sKnownCodecList.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", Integer.valueOf(RANK_TESTED));
                sKnownCodecList.put("OMX.MARVELL.VIDEO.H264DECODER", Integer.valueOf(RANK_SOFTWARE));
                sKnownCodecList.remove("OMX.BRCM.vc4.decoder.avc");
                sKnownCodecList.remove("OMX.brcm.video.h264.hw.decoder");
                sKnownCodecList.remove("OMX.brcm.video.h264.decoder");
                sKnownCodecList.remove("OMX.ST.VFM.H264Dec");
                sKnownCodecList.remove("OMX.allwinner.video.decoder.avc");
                sKnownCodecList.remove("OMX.MS.AVC.Decoder");
                sKnownCodecList.remove("OMX.hantro.81x0.video.decoder");
                sKnownCodecList.remove("OMX.hisi.video.decoder");
                sKnownCodecList.remove("OMX.cosmo.video.decoder.avc");
                sKnownCodecList.remove("OMX.duos.h264.decoder");
                sKnownCodecList.remove("OMX.bluestacks.hw.decoder");
                sKnownCodecList.put("OMX.google.h264.decoder", Integer.valueOf(RANK_SOFTWARE));
                sKnownCodecList.put("OMX.google.h264.lc.decoder", Integer.valueOf(RANK_SOFTWARE));
                sKnownCodecList.put("OMX.k3.ffmpeg.decoder", Integer.valueOf(RANK_SOFTWARE));
                sKnownCodecList.put("OMX.ffmpeg.video.decoder", Integer.valueOf(RANK_SOFTWARE));
                map = sKnownCodecList;
            }
        }
        return map;
    }

    public static String getLevelName(int i) {
        switch (i) {
            case 1:
                return "1";
            case 2:
                return "1b";
            case 4:
                return "11";
            case 8:
                return "12";
            case 16:
                return "13";
            case 32:
                return "2";
            case 64:
                return Constants.VIA_REPORT_TYPE_QQFAVORITES;
            case 128:
                return Constants.VIA_REPORT_TYPE_DATALINE;
            case 256:
                return "3";
            case 512:
                return C0413a.f925e;
            case 1024:
                return "32";
            case 2048:
                return "4";
            case 4096:
                return "41";
            case 8192:
                return "42";
            case 16384:
                return "5";
            case 32768:
                return "51";
            case 65536:
                return "52";
            default:
                return "0";
        }
    }

    public static String getProfileLevelName(int i, int i2) {
        return String.format(Locale.US, " %s Profile Level %s (%d,%d)", getProfileName(i), getLevelName(i2), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static String getProfileName(int i) {
        switch (i) {
            case 1:
                return "Baseline";
            case 2:
                return "Main";
            case 4:
                return "Extends";
            case 8:
                return "High";
            case 16:
                return "High10";
            case 32:
                return "High422";
            case 64:
                return "High444";
            default:
                return "Unknown";
        }
    }

    @TargetApi(16)
    public static FimiMediaCodecInfo setupCandidate(MediaCodecInfo mediaCodecInfo, String str) {
        int i;
        if (mediaCodecInfo == null || Build.VERSION.SDK_INT < 16) {
            return null;
        }
        String name = mediaCodecInfo.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        String lowerCase = name.toLowerCase(Locale.US);
        int i2 = RANK_NO_SENSE;
        if (!lowerCase.startsWith("omx.")) {
            i = RANK_NON_STANDARD;
        } else if (lowerCase.startsWith("omx.pv")) {
            i = RANK_SOFTWARE;
        } else if (lowerCase.startsWith("omx.google.")) {
            i = RANK_SOFTWARE;
        } else if (lowerCase.startsWith("omx.ffmpeg.")) {
            i = RANK_SOFTWARE;
        } else if (lowerCase.startsWith("omx.k3.ffmpeg.")) {
            i = RANK_SOFTWARE;
        } else if (lowerCase.startsWith("omx.avcodec.")) {
            i = RANK_SOFTWARE;
        } else if (lowerCase.startsWith("omx.ittiam.")) {
            i = RANK_NO_SENSE;
        } else if (lowerCase.startsWith("omx.mtk.")) {
            i = Build.VERSION.SDK_INT < 18 ? RANK_NO_SENSE : RANK_TESTED;
        } else {
            Integer num = getKnownCodecList().get(lowerCase);
            if (num != null) {
                i = num.intValue();
            } else {
                try {
                    i = mediaCodecInfo.getCapabilitiesForType(str) != null ? RANK_ACCEPTABLE : RANK_LAST_CHANCE;
                } catch (Throwable th) {
                    i = RANK_LAST_CHANCE;
                }
            }
        }
        FimiMediaCodecInfo fimiMediaCodecInfo = new FimiMediaCodecInfo();
        fimiMediaCodecInfo.mCodecInfo = mediaCodecInfo;
        fimiMediaCodecInfo.mRank = i;
        fimiMediaCodecInfo.mMimeType = str;
        return fimiMediaCodecInfo;
    }

    @TargetApi(16)
    public void dumpProfileLevels(String str) {
        int i;
        int i2 = 0;
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = this.mCodecInfo.getCapabilitiesForType(str);
            if (capabilitiesForType == null || capabilitiesForType.profileLevels == null) {
                i = 0;
            } else {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                i = 0;
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                    if (codecProfileLevel != null) {
                        i = Math.max(i, codecProfileLevel.profile);
                        i2 = Math.max(i2, codecProfileLevel.level);
                    }
                }
            }
            Log.i(TAG, String.format(Locale.US, "%s", getProfileLevelName(i, i2)));
        } catch (Throwable th) {
            Log.i(TAG, "profile-level: exception");
        }
    }
}
