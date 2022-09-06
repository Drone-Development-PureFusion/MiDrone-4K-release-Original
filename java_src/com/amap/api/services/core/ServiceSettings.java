package com.amap.api.services.core;
/* loaded from: classes.dex */
public class ServiceSettings {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;

    /* renamed from: c */
    private static ServiceSettings f3969c;

    /* renamed from: a */
    private String f3970a = "zh-CN";

    /* renamed from: b */
    private int f3971b = 1;

    /* renamed from: d */
    private int f3972d = 20000;

    /* renamed from: e */
    private int f3973e = 20000;

    private ServiceSettings() {
    }

    public static ServiceSettings getInstance() {
        if (f3969c == null) {
            f3969c = new ServiceSettings();
        }
        return f3969c;
    }

    public int getConnectionTimeOut() {
        return this.f3972d;
    }

    public String getLanguage() {
        return this.f3970a;
    }

    public int getProtocol() {
        return this.f3971b;
    }

    public int getSoTimeOut() {
        return this.f3973e;
    }

    public void setApiKey(String str) {
        C1260x.m16918a(str);
    }

    public void setConnectionTimeOut(int i) {
        if (i < 5000) {
            this.f3972d = 5000;
        } else if (i > 30000) {
            this.f3972d = 30000;
        } else {
            this.f3972d = i;
        }
    }

    public void setLanguage(String str) {
        if ("en".equals(str) || "zh-CN".equals(str)) {
            this.f3970a = str;
        }
    }

    public void setProtocol(int i) {
        this.f3971b = i;
    }

    public void setSoTimeOut(int i) {
        if (i < 5000) {
            this.f3973e = 5000;
        } else if (i > 30000) {
            this.f3973e = 30000;
        } else {
            this.f3973e = i;
        }
    }
}
