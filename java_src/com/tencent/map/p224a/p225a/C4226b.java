package com.tencent.map.p224a.p225a;

import com.tencent.map.p226b.C4257h;
/* renamed from: com.tencent.map.a.a.b */
/* loaded from: classes.dex */
public class C4226b {

    /* renamed from: a */
    private int f17520a;

    /* renamed from: b */
    private int f17521b;

    /* renamed from: c */
    private int f17522c;

    /* renamed from: d */
    private int f17523d;

    public C4226b(int i, int i2, int i3, int i4) {
        this.f17520a = 1;
        this.f17521b = 0;
        this.f17522c = 12;
        this.f17523d = 1;
        C4257h.m5700a("argument: " + this.f17520a + " " + this.f17523d + " " + this.f17521b);
        if (i >= 0 && i <= 1) {
            this.f17520a = i;
        }
        if (i2 >= 0 && i2 <= 1) {
            this.f17523d = i2;
        }
        if (i3 == 0 || i3 == 3 || i3 == 4 || i3 == 7) {
            this.f17521b = i3;
        }
        if (this.f17523d == 0) {
            this.f17521b = 0;
        }
        this.f17522c = i4;
    }

    /* renamed from: a */
    public int m5820a() {
        return this.f17520a;
    }

    /* renamed from: a */
    public void mo5386a(int i) {
    }

    /* renamed from: a */
    public void mo5385a(C4228d c4228d) {
    }

    /* renamed from: a */
    public void mo5384a(byte[] bArr, int i) {
    }

    /* renamed from: b */
    public int m5819b() {
        return this.f17521b;
    }

    /* renamed from: c */
    public int m5818c() {
        return this.f17523d;
    }
}
