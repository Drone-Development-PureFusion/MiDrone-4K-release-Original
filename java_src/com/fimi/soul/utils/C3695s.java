package com.fimi.soul.utils;

import android.os.Environment;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* renamed from: com.fimi.soul.utils.s */
/* loaded from: classes.dex */
public class C3695s {
    /* renamed from: a */
    public static String m7432a() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss", Locale.US).format(new Date());
    }

    /* renamed from: b */
    public static boolean m7431b() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
