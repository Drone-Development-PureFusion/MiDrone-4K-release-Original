package com.fimi.soul.media.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.fimi.kernel.utils.C2258f;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes.dex */
public class FermiPlayerUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat();

    public static boolean createRemoteVideoThumbnail(String str, String str2) {
        return FimiMediaPlayer.getIntance().videoToJpg(str, str2);
    }

    public static Bitmap createVideoThumbnail(String str) {
        return ThumbnailUtils.createVideoThumbnail(str.replace("file://", ""), 1);
    }

    public static Bitmap createVideoThumbnail(String str, int i) {
        String replace = str.replace("file://", "");
        if (Build.VERSION.SDK_INT >= 14) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(replace);
            return mediaMetadataRetriever.getFrameAtTime(i * 1000, 2);
        }
        return createVideoThumbnail(replace);
    }

    public static Bitmap createVideoThumbnail(String str, int i, int i2) {
        Bitmap createVideoThumbnail = createVideoThumbnail(str);
        return createVideoThumbnail != null ? ThumbnailUtils.extractThumbnail(createVideoThumbnail, i, i2) : createVideoThumbnail;
    }

    public static Bitmap createVideoThumbnail(String str, int i, int i2, int i3) {
        Bitmap createVideoThumbnail = createVideoThumbnail(str, i3);
        return createVideoThumbnail != null ? ThumbnailUtils.extractThumbnail(createVideoThumbnail, i, i2) : createVideoThumbnail;
    }

    public static String getTimelineString(long j) {
        return getTimelineString(j, C2258f.f7532g);
    }

    public static String getTimelineString(long j, String str) {
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        sdf.applyPattern(str);
        return sdf.format(new Date(j));
    }

    public static long getVideoDuration(Context context, String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            try {
                long duration = MediaPlayer.create(context, Uri.fromFile(file)).getDuration();
                Log.d("Good", "time:" + duration);
                return duration;
            } catch (Exception e) {
            }
        }
        return 0L;
    }

    public static String getVideoDurationString(Context context, String str) {
        return getTimelineString(getVideoDuration(context, str));
    }

    public static String getVideoDurationString(Context context, String str, String str2) {
        return getTimelineString(getVideoDuration(context, str), str2);
    }
}
