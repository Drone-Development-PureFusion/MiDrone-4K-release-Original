package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.gi */
/* loaded from: classes.dex */
public class C1031gi {

    /* renamed from: a */
    String f3223a;

    /* renamed from: b */
    String f3224b;

    /* renamed from: c */
    String f3225c;

    /* renamed from: d */
    String f3226d;

    /* renamed from: e */
    String f3227e;

    /* renamed from: f */
    int f3228f;

    /* renamed from: g */
    int f3229g;

    /* renamed from: h */
    private String f3230h;

    /* renamed from: i */
    private String f3231i;

    public C1031gi(String str, String str2, String str3) {
        this.f3230h = str;
        this.f3231i = str2;
        try {
            String[] split = str.split("/");
            int length = split.length;
            if (length <= 1) {
                return;
            }
            this.f3223a = split[length - 1];
            String[] split2 = this.f3223a.split("_");
            this.f3224b = split2[0];
            this.f3225c = split2[2];
            this.f3226d = split2[1];
            this.f3228f = Integer.parseInt(split2[3]);
            this.f3229g = Integer.parseInt(split2[4].split("\\.")[0]);
        } catch (Throwable th) {
            C1045gs.m17831a(th, "DexDownloadItem", "DexDownloadItem");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m17908a() {
        return this.f3230h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public String m17907b() {
        return this.f3231i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public String m17906c() {
        return this.f3225c;
    }
}
