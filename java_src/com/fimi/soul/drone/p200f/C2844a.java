package com.fimi.soul.drone.p200f;

import java.io.Serializable;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.f.a */
/* loaded from: classes.dex */
public class C2844a implements Serializable {

    /* renamed from: a */
    private int f10467a;

    /* renamed from: b */
    private int f10468b;

    /* renamed from: c */
    private int f10469c;

    /* renamed from: d */
    private long f10470d;

    /* renamed from: e */
    private long f10471e;

    /* renamed from: f */
    private long f10472f;

    /* renamed from: g */
    private long f10473g;

    /* renamed from: h */
    private char f10474h;

    public C2844a() {
    }

    public C2844a(int i, int i2, int i3, char c, long j, long j2, long j3, long j4) {
        this.f10469c = i;
        this.f10467a = i2;
        this.f10468b = i3;
        this.f10474h = c;
        this.f10470d = j;
        this.f10471e = j2;
        this.f10472f = j3;
        this.f10473g = j4;
    }

    /* renamed from: a */
    public int m10833a() {
        return this.f10467a;
    }

    /* renamed from: a */
    public void m10832a(char c) {
        this.f10474h = c;
    }

    /* renamed from: a */
    public void m10831a(int i) {
        this.f10467a = i;
    }

    /* renamed from: a */
    public void m10830a(long j) {
        this.f10470d = j;
    }

    /* renamed from: a */
    public void m10829a(short s) {
        this.f10468b = s;
    }

    /* renamed from: b */
    public int m10828b() {
        return this.f10469c;
    }

    /* renamed from: b */
    public void m10827b(int i) {
        this.f10469c = i;
    }

    /* renamed from: b */
    public void m10826b(long j) {
        this.f10471e = j;
    }

    /* renamed from: c */
    public int m10825c() {
        return this.f10468b;
    }

    /* renamed from: c */
    public void m10824c(long j) {
        this.f10473g = j;
    }

    /* renamed from: d */
    public long m10823d() {
        return this.f10470d;
    }

    /* renamed from: d */
    public void m10822d(long j) {
        this.f10472f = j;
    }

    /* renamed from: e */
    public long m10821e() {
        return this.f10471e;
    }

    /* renamed from: f */
    public long m10820f() {
        return this.f10473g;
    }

    /* renamed from: g */
    public long m10819g() {
        return this.f10472f;
    }

    /* renamed from: h */
    public long m10818h() {
        return Long.valueOf(this.f10474h).longValue();
    }

    public String toString() {
        return "DroneUpdateInfo{model=" + this.f10467a + ", version=" + this.f10468b + ", type=" + this.f10469c + ", IDA=" + this.f10470d + ", IDB=" + this.f10471e + ", IDC=" + this.f10472f + ", IDD=" + this.f10473g + ", hwVersion=" + this.f10474h + C0359h.f726w;
    }
}
