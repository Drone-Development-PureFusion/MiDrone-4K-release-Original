package com.fimi.soul.utils;

import android.app.Activity;
import android.os.Vibrator;
/* renamed from: com.fimi.soul.utils.as */
/* loaded from: classes.dex */
public class C3662as {
    /* renamed from: a */
    public static void m7563a(Activity activity, long j) {
        ((Vibrator) activity.getSystemService("vibrator")).vibrate(j);
    }

    /* renamed from: a */
    public static void m7562a(Activity activity, long[] jArr, boolean z) {
        ((Vibrator) activity.getSystemService("vibrator")).vibrate(jArr, z ? 1 : -1);
    }
}
