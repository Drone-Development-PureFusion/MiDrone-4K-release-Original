package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.string.C4504a;
/* renamed from: com.xiaomi.push.service.aq */
/* loaded from: classes.dex */
public class C4624aq {

    /* renamed from: a */
    private static int f19016a = 8;

    /* renamed from: e */
    private int f19020e = -666;

    /* renamed from: b */
    private byte[] f19017b = new byte[256];

    /* renamed from: d */
    private int f19019d = 0;

    /* renamed from: c */
    private int f19018c = 0;

    /* renamed from: a */
    public static int m4352a(byte b) {
        return b >= 0 ? b : b + 256;
    }

    /* renamed from: a */
    public static String m4347a(byte[] bArr, String str) {
        return String.valueOf(C4504a.m4958a(m4346a(bArr, str.getBytes())));
    }

    /* renamed from: a */
    private void m4351a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i2 = 0; i2 < 256; i2++) {
            this.f19017b[i2] = (byte) i2;
        }
        this.f19019d = 0;
        this.f19018c = 0;
        while (this.f19018c < i) {
            this.f19019d = ((this.f19019d + m4352a(this.f19017b[this.f19018c])) + m4352a(bArr[this.f19018c % length])) % 256;
            m4348a(this.f19017b, this.f19018c, this.f19019d);
            this.f19018c++;
        }
        if (i != 256) {
            this.f19020e = ((this.f19019d + m4352a(this.f19017b[i])) + m4352a(bArr[i % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_").append(i - 1).append(":");
            for (int i3 = 0; i3 <= i; i3++) {
                sb.append(" ").append(m4352a(this.f19017b[i3]));
            }
            sb.append("   j_").append(i - 1).append("=").append(this.f19019d);
            sb.append("   j_").append(i).append("=").append(this.f19020e);
            sb.append("   S_").append(i - 1).append("[j_").append(i - 1).append("]=").append(m4352a(this.f19017b[this.f19019d]));
            sb.append("   S_").append(i - 1).append("[j_").append(i).append("]=").append(m4352a(this.f19017b[this.f19020e]));
            if (this.f19017b[1] != 0) {
                sb.append("   S[1]!=0");
            }
            AbstractC4478b.m5041a(sb.toString());
        }
    }

    /* renamed from: a */
    private void m4349a(byte[] bArr) {
        m4351a(256, bArr, false);
    }

    /* renamed from: a */
    private static void m4348a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    /* renamed from: a */
    public static byte[] m4350a(String str, String str2) {
        byte[] m4959a = C4504a.m4959a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[m4959a.length + 1 + bytes.length];
        for (int i = 0; i < m4959a.length; i++) {
            bArr[i] = m4959a[i];
        }
        bArr[m4959a.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[m4959a.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m4346a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        C4624aq c4624aq = new C4624aq();
        c4624aq.m4349a(bArr);
        c4624aq.m4345b();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ c4624aq.m4353a());
        }
        return bArr3;
    }

    /* renamed from: b */
    private void m4345b() {
        this.f19019d = 0;
        this.f19018c = 0;
    }

    /* renamed from: b */
    public static byte[] m4344b(byte[] bArr, String str) {
        return m4346a(bArr, C4504a.m4959a(str));
    }

    /* renamed from: a */
    byte m4353a() {
        this.f19018c = (this.f19018c + 1) % 256;
        this.f19019d = (this.f19019d + m4352a(this.f19017b[this.f19018c])) % 256;
        m4348a(this.f19017b, this.f19018c, this.f19019d);
        return this.f19017b[(m4352a(this.f19017b[this.f19018c]) + m4352a(this.f19017b[this.f19019d])) % 256];
    }
}
