package com.tencent.stat;
/* loaded from: classes2.dex */
public class StatAppMonitor implements Cloneable {
    public static final int FAILURE_RESULT_TYPE = 1;
    public static final int LOGIC_FAILURE_RESULT_TYPE = 2;
    public static final int SUCCESS_RESULT_TYPE = 0;

    /* renamed from: a */
    private String f18297a;

    /* renamed from: b */
    private long f18298b;

    /* renamed from: c */
    private long f18299c;

    /* renamed from: d */
    private int f18300d;

    /* renamed from: e */
    private long f18301e;

    /* renamed from: f */
    private int f18302f;

    /* renamed from: g */
    private int f18303g;

    public StatAppMonitor(String str) {
        this.f18297a = null;
        this.f18298b = 0L;
        this.f18299c = 0L;
        this.f18300d = 0;
        this.f18301e = 0L;
        this.f18302f = 0;
        this.f18303g = 1;
        this.f18297a = str;
    }

    public StatAppMonitor(String str, int i, int i2, long j, long j2, long j3, int i3) {
        this.f18297a = null;
        this.f18298b = 0L;
        this.f18299c = 0L;
        this.f18300d = 0;
        this.f18301e = 0L;
        this.f18302f = 0;
        this.f18303g = 1;
        this.f18297a = str;
        this.f18298b = j;
        this.f18299c = j2;
        this.f18300d = i;
        this.f18301e = j3;
        this.f18302f = i2;
        this.f18303g = i3;
    }

    /* renamed from: clone */
    public StatAppMonitor m21864clone() {
        try {
            return (StatAppMonitor) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getInterfaceName() {
        return this.f18297a;
    }

    public long getMillisecondsConsume() {
        return this.f18301e;
    }

    public long getReqSize() {
        return this.f18298b;
    }

    public long getRespSize() {
        return this.f18299c;
    }

    public int getResultType() {
        return this.f18300d;
    }

    public int getReturnCode() {
        return this.f18302f;
    }

    public int getSampling() {
        return this.f18303g;
    }

    public void setInterfaceName(String str) {
        this.f18297a = str;
    }

    public void setMillisecondsConsume(long j) {
        this.f18301e = j;
    }

    public void setReqSize(long j) {
        this.f18298b = j;
    }

    public void setRespSize(long j) {
        this.f18299c = j;
    }

    public void setResultType(int i) {
        this.f18300d = i;
    }

    public void setReturnCode(int i) {
        this.f18302f = i;
    }

    public void setSampling(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.f18303g = i;
    }
}
