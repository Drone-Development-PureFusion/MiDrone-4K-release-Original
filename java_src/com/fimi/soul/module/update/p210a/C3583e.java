package com.fimi.soul.module.update.p210a;

import java.io.Serializable;
/* renamed from: com.fimi.soul.module.update.a.e */
/* loaded from: classes.dex */
public class C3583e implements Serializable {

    /* renamed from: a */
    private int f14512a;

    /* renamed from: b */
    private int f14513b;

    /* renamed from: c */
    private String f14514c;

    /* renamed from: d */
    private int f14515d;

    /* renamed from: e */
    private long f14516e;

    /* renamed from: f */
    private long f14517f;

    /* renamed from: g */
    private long f14518g;

    /* renamed from: h */
    private long f14519h;

    /* renamed from: i */
    private byte[] f14520i;

    /* renamed from: j */
    private byte[] f14521j;

    /* renamed from: k */
    private byte[] f14522k;

    /* renamed from: l */
    private byte[] f14523l;

    /* renamed from: m */
    private String f14524m;

    public C3583e() {
        this.f14520i = new byte[4];
        this.f14521j = new byte[4];
        this.f14522k = new byte[4];
        this.f14523l = new byte[4];
    }

    public C3583e(int i, int i2, int i3, String str, long j, long j2, long j3, long j4) {
        this.f14520i = new byte[4];
        this.f14521j = new byte[4];
        this.f14522k = new byte[4];
        this.f14523l = new byte[4];
        this.f14512a = i2;
        this.f14513b = i3;
        this.f14514c = str;
        this.f14515d = i;
        this.f14516e = j;
        this.f14517f = j2;
        this.f14518g = j3;
        this.f14519h = j4;
        if (i == 5) {
            this.f14524m = Long.toString(((65535 & j) << 32) | ((65535 & j2) << 16) | (65535 & j3));
        } else {
            this.f14524m = String.valueOf(j) + String.valueOf(j2) + String.valueOf(j3) + String.valueOf(j4);
        }
    }

    public C3583e(int i, int i2, int i3, String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.f14520i = new byte[4];
        this.f14521j = new byte[4];
        this.f14522k = new byte[4];
        this.f14523l = new byte[4];
        this.f14512a = i2;
        this.f14513b = i3;
        this.f14514c = str;
        this.f14515d = i;
        this.f14520i = bArr;
        this.f14521j = bArr2;
        this.f14522k = bArr3;
        this.f14523l = bArr4;
    }

    public C3583e(String str, int i, int i2) {
        this.f14520i = new byte[4];
        this.f14521j = new byte[4];
        this.f14522k = new byte[4];
        this.f14523l = new byte[4];
        this.f14514c = str;
        this.f14515d = i;
        this.f14513b = i2;
    }

    /* renamed from: a */
    public int m7926a() {
        return this.f14512a;
    }

    /* renamed from: a */
    public void m7925a(int i) {
        this.f14512a = i;
    }

    /* renamed from: a */
    public void m7924a(long j) {
        this.f14516e = j;
    }

    /* renamed from: a */
    public void m7923a(String str) {
        this.f14514c = str;
    }

    /* renamed from: a */
    public void m7922a(byte[] bArr) {
        this.f14520i = bArr;
    }

    /* renamed from: b */
    public int m7921b() {
        return this.f14513b;
    }

    /* renamed from: b */
    public void m7920b(int i) {
        this.f14513b = i;
    }

    /* renamed from: b */
    public void m7919b(long j) {
        this.f14517f = j;
    }

    /* renamed from: b */
    public void m7918b(String str) {
        this.f14524m = str;
    }

    /* renamed from: b */
    public void m7917b(byte[] bArr) {
        this.f14521j = bArr;
    }

    /* renamed from: c */
    public String m7916c() {
        return this.f14514c;
    }

    /* renamed from: c */
    public void m7915c(int i) {
        this.f14515d = i;
    }

    /* renamed from: c */
    public void m7914c(long j) {
        this.f14518g = j;
    }

    /* renamed from: c */
    public void m7913c(byte[] bArr) {
        this.f14522k = bArr;
    }

    /* renamed from: d */
    public int m7912d() {
        return this.f14515d;
    }

    /* renamed from: d */
    public void m7911d(long j) {
        this.f14519h = j;
    }

    /* renamed from: d */
    public void m7910d(byte[] bArr) {
        this.f14523l = bArr;
    }

    /* renamed from: e */
    public long m7909e() {
        return this.f14516e;
    }

    /* renamed from: f */
    public long m7908f() {
        return this.f14517f;
    }

    /* renamed from: g */
    public long m7907g() {
        return this.f14518g;
    }

    /* renamed from: h */
    public long m7906h() {
        return this.f14519h;
    }

    /* renamed from: i */
    public String m7905i() {
        return this.f14524m;
    }

    /* renamed from: j */
    public byte[] m7904j() {
        return this.f14520i;
    }

    /* renamed from: k */
    public byte[] m7903k() {
        return this.f14521j;
    }

    /* renamed from: l */
    public byte[] m7902l() {
        return this.f14522k;
    }

    /* renamed from: m */
    public byte[] m7901m() {
        return this.f14523l;
    }
}
