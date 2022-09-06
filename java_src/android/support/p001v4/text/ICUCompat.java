package android.support.p001v4.text;

import android.os.Build;
/* renamed from: android.support.v4.text.ICUCompat */
/* loaded from: classes.dex */
public class ICUCompat {
    private static final ICUCompatImpl IMPL;

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImpl */
    /* loaded from: classes.dex */
    interface ICUCompatImpl {
        String addLikelySubtags(String str);

        String getScript(String str);
    }

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImplBase */
    /* loaded from: classes.dex */
    static class ICUCompatImplBase implements ICUCompatImpl {
        ICUCompatImplBase() {
        }

        @Override // android.support.p001v4.text.ICUCompat.ICUCompatImpl
        public String addLikelySubtags(String str) {
            return str;
        }

        @Override // android.support.p001v4.text.ICUCompat.ICUCompatImpl
        public String getScript(String str) {
            return null;
        }
    }

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImplIcs */
    /* loaded from: classes.dex */
    static class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
        }

        @Override // android.support.p001v4.text.ICUCompat.ICUCompatImpl
        public String addLikelySubtags(String str) {
            return ICUCompatIcs.addLikelySubtags(str);
        }

        @Override // android.support.p001v4.text.ICUCompat.ICUCompatImpl
        public String getScript(String str) {
            return ICUCompatIcs.getScript(str);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new ICUCompatImplIcs();
        } else {
            IMPL = new ICUCompatImplBase();
        }
    }

    public static String addLikelySubtags(String str) {
        return IMPL.addLikelySubtags(str);
    }

    public static String getScript(String str) {
        return IMPL.getScript(str);
    }
}
