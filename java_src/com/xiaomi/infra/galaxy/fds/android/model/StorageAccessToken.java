package com.xiaomi.infra.galaxy.fds.android.model;
/* loaded from: classes2.dex */
public class StorageAccessToken {
    private long expireTime;
    private String token;

    public StorageAccessToken() {
    }

    public StorageAccessToken(String str, long j) {
        this.token = str;
        this.expireTime = j;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getToken() {
        return this.token;
    }

    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
