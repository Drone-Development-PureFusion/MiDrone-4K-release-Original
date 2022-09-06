package com.tencent.p227mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.util.Map;
/* renamed from: com.tencent.mm.sdk.platformtools.ChannelUtil */
/* loaded from: classes.dex */
public final class ChannelUtil {
    public static final int FLAG_NULL = 0;
    public static final int FLAG_UPDATE_EXTERNAL = 1;
    public static final int FLAG_UPDATE_NOTIP = 2;
    public static int channelId = 0;
    public static String profileDeviceType = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
    public static int updateMode = 0;
    public static int buildRev = 0;
    public static String marketURL = "market://details?id=" + MMApplicationContext.getPackageName();
    public static boolean fullVersionInfo = false;

    private ChannelUtil() {
    }

    public static String formatVersion(Context context, int i) {
        String str = ((i >> 24) & 15) + "." + ((i >> 16) & 255);
        int i2 = 65535 & i;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
                if (packageInfo != null) {
                    i2 = packageInfo.versionCode;
                    str = packageInfo.versionName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (fullVersionInfo) {
            String str2 = str + " r" + i2 + "(build." + buildRev + ")";
            Log.m5649d("MicroMsg.SDK.ChannelUtil", "full version: " + str2);
            return str2;
        }
        return str;
    }

    public static void loadProfile(Context context) {
        try {
            Map<String, String> parseIni = KVConfig.parseIni(Util.convertStreamToString(context.getAssets().open("profile.ini")));
            String nullAsNil = Util.nullAsNil(parseIni.get("PROFILE_DEVICE_TYPE"));
            profileDeviceType = nullAsNil;
            if (nullAsNil.length() <= 0) {
                profileDeviceType = new StringBuilder().append(Build.VERSION.SDK_INT).toString();
            }
            updateMode = Integer.parseInt(parseIni.get("UPDATE_MODE"));
            buildRev = Integer.parseInt(parseIni.get("BUILD_REVISION"));
            Log.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + profileDeviceType);
            Log.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + updateMode);
            String str = parseIni.get("MARKET_URL");
            if (str != null && str.trim().length() != 0 && Uri.parse(str) != null) {
                marketURL = str;
            }
            Log.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + marketURL);
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
            e.printStackTrace();
        }
    }

    public static void setupChannelId(Context context) {
        try {
            channelId = Integer.parseInt(KVConfig.parseIni(Util.convertStreamToString(context.getAssets().open("channel.ini"))).get("CHANNEL"));
        } catch (Exception e) {
            Log.m5647e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
            e.printStackTrace();
        }
    }
}
