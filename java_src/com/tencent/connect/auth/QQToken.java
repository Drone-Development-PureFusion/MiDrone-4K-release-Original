package com.tencent.connect.auth;
/* loaded from: classes.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: a */
    private String f17418a;

    /* renamed from: b */
    private String f17419b;

    /* renamed from: c */
    private String f17420c;

    /* renamed from: d */
    private int f17421d = 1;

    /* renamed from: e */
    private long f17422e = -1;

    public QQToken(String str) {
        this.f17418a = str;
    }

    public String getAccessToken() {
        return this.f17419b;
    }

    public String getAppId() {
        return this.f17418a;
    }

    public int getAuthSource() {
        return this.f17421d;
    }

    public long getExpireTimeInSecond() {
        return this.f17422e;
    }

    public String getOpenId() {
        return this.f17420c;
    }

    public boolean isSessionValid() {
        return this.f17419b != null && System.currentTimeMillis() < this.f17422e;
    }

    public void setAccessToken(String str, String str2) {
        this.f17419b = str;
        this.f17422e = 0L;
        if (str2 != null) {
            this.f17422e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.f17418a = str;
    }

    public void setAuthSource(int i) {
        this.f17421d = i;
    }

    public void setOpenId(String str) {
        this.f17420c = str;
    }
}
