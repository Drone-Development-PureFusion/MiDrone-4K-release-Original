package com.tencent.stat;
/* renamed from: com.tencent.stat.h */
/* loaded from: classes2.dex */
/* synthetic */ class C4430h {

    /* renamed from: a */
    static final /* synthetic */ int[] f18480a = new int[StatReportStrategy.values().length];

    static {
        try {
            f18480a[StatReportStrategy.INSTANT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f18480a[StatReportStrategy.ONLY_WIFI.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f18480a[StatReportStrategy.APP_LAUNCH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f18480a[StatReportStrategy.DEVELOPER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f18480a[StatReportStrategy.BATCH.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f18480a[StatReportStrategy.PERIOD.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f18480a[StatReportStrategy.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
    }
}
