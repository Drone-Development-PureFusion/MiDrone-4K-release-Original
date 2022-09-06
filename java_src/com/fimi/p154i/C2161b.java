package com.fimi.p154i;

import android.util.Log;
import com.fimi.p139b.p140a.C2088d;
import java.util.Arrays;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.i.b */
/* loaded from: classes.dex */
public class C2161b {

    /* renamed from: a */
    private int f7262a;

    /* renamed from: b */
    private int f7263b;

    /* renamed from: c */
    private int f7264c;

    /* renamed from: d */
    private int f7265d;

    /* renamed from: e */
    private byte[] f7266e;

    /* renamed from: f */
    private byte[] f7267f;

    /* renamed from: g */
    private byte[] f7268g;

    /* renamed from: h */
    private byte[] f7269h;

    /* renamed from: i */
    private int f7270i;

    public C2161b(int i, int i2, int i3, int i4, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.f7262a = i;
        this.f7263b = i2;
        this.f7264c = i3;
        this.f7265d = i4;
        this.f7266e = bArr;
        this.f7267f = bArr2;
        this.f7268g = bArr3;
        this.f7269h = bArr4 == null ? new byte[4] : bArr4;
    }

    /* renamed from: a */
    public int m13378a() {
        return this.f7270i;
    }

    /* renamed from: a */
    public void m13377a(int i) {
        this.f7270i = i;
    }

    /* renamed from: b */
    public byte m13376b() {
        return (byte) this.f7262a;
    }

    /* renamed from: c */
    public int m13375c() {
        return this.f7263b;
    }

    /* renamed from: d */
    public int m13374d() {
        return this.f7264c;
    }

    /* renamed from: e */
    public int m13373e() {
        return this.f7265d;
    }

    /* renamed from: f */
    public byte[] m13372f() {
        return this.f7266e;
    }

    /* renamed from: g */
    public byte[] m13371g() {
        return this.f7267f;
    }

    /* renamed from: h */
    public byte[] m13370h() {
        return this.f7268g;
    }

    /* renamed from: i */
    public byte[] m13369i() {
        return this.f7269h;
    }

    /* renamed from: j */
    public void m13368j() {
        if (this.f7262a == 3 && this.f7263b == 3) {
            this.f7270i = C2088d.f6980a;
        } else if (this.f7262a == 8 && this.f7263b == 3) {
            this.f7270i = C2088d.f6981b;
        } else if (this.f7262a == 6 && this.f7263b == 2) {
            this.f7270i = C2088d.f6982c;
        }
        Log.d("zhej", "sysId:" + this.f7270i);
    }

    public String toString() {
        return "FirmwareBean{type=" + this.f7262a + ", model=" + this.f7263b + ", hardwareVersion=" + this.f7264c + ", softwareVersion=" + this.f7265d + ", idA=" + Arrays.toString(this.f7266e) + ", idB=" + Arrays.toString(this.f7267f) + ", idC=" + Arrays.toString(this.f7268g) + ", idD=" + Arrays.toString(this.f7269h) + ", sysId=" + this.f7270i + C0359h.f726w;
    }
}
