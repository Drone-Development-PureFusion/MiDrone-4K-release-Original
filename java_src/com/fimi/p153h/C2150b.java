package com.fimi.p153h;

import com.fimi.p139b.p140a.C2085a;
import com.fimi.p139b.p145f.C2111a;
import com.fimi.p139b.p145f.C2112b;
import com.fimi.p139b.p145f.C2113c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.h.b */
/* loaded from: classes.dex */
public class C2150b {

    /* renamed from: a */
    public static final int f7213a = 176;

    /* renamed from: b */
    byte[] f7214b;

    /* renamed from: c */
    byte[] f7215c;

    /* renamed from: d */
    byte[] f7216d;

    /* renamed from: e */
    private List<C2085a> f7217e = new ArrayList();

    /* renamed from: f */
    private long f7218f;

    /* renamed from: g */
    private long f7219g;

    /* renamed from: h */
    private int f7220h;

    /* renamed from: a */
    public int m13436a() {
        return this.f7220h;
    }

    /* renamed from: a */
    public int m13431a(String str, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] m13432a = m13432a(str);
        if (m13432a == null) {
            return -1;
        }
        this.f7214b = bArr;
        this.f7215c = bArr2;
        this.f7216d = bArr3;
        m13430a(m13432a);
        m13427b(m13432a);
        m13423f();
        return 1;
    }

    /* renamed from: a */
    public void m13435a(int i) {
        this.f7220h = i;
        m13428b(this.f7217e.get(this.f7220h).f6972c);
        this.f7220h++;
    }

    /* renamed from: a */
    public void m13434a(int i, byte[] bArr, byte[] bArr2) {
        for (int i2 = 0; i2 < 4; i2++) {
            bArr2[i + i2] = bArr[i2];
        }
    }

    /* renamed from: a */
    public void m13433a(long j) {
        this.f7218f = j;
    }

    /* renamed from: a */
    public void m13430a(byte[] bArr) {
        m13434a(16, this.f7214b, bArr);
        m13434a(20, this.f7215c, bArr);
        m13434a(24, this.f7216d, bArr);
        m13434a(48, C2113c.m13633a((int) C2113c.m13630a(C2111a.m13667a(bArr), 12)), bArr);
        int[] m13667a = C2111a.m13667a(bArr);
        m13434a(bArr.length - 4, C2113c.m13633a((int) C2113c.m13630a(m13667a, m13667a.length - 1)), bArr);
    }

    /* renamed from: a */
    public byte[] m13432a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        int length = (int) file.length();
        m13433a(file.length());
        byte[] bArr = new byte[length];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
            return bArr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return bArr;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bArr;
        }
    }

    /* renamed from: b */
    public void m13429b() {
        m13428b(this.f7217e.get(this.f7220h).f6972c);
        this.f7220h++;
    }

    /* renamed from: b */
    public void m13428b(int i) {
        this.f7219g += i;
    }

    /* renamed from: b */
    public void m13427b(byte[] bArr) {
        int length = bArr.length % 176;
        int length2 = bArr.length / 176;
        if (length != 0) {
            length2++;
        }
        for (int i = 0; i < length2; i++) {
            C2085a c2085a = new C2085a();
            if (i != length2 - 1 || length == 0) {
                byte[] bArr2 = new byte[176];
                System.arraycopy(bArr, i * 176, bArr2, 0, 176);
                c2085a.f6970a = bArr2;
                c2085a.f6971b = bArr2.length;
                c2085a.f6972c = bArr2.length;
                this.f7217e.add(c2085a);
            } else {
                byte[] bArr3 = new byte[176];
                System.arraycopy(bArr, i * 176, bArr3, 0, length);
                c2085a.f6970a = bArr3;
                c2085a.f6971b = bArr3.length;
                c2085a.f6972c = length;
                this.f7217e.add(c2085a);
                System.out.println("-----------");
            }
            C2112b.m13657a(c2085a.f6970a);
        }
    }

    /* renamed from: c */
    public boolean m13426c() {
        return this.f7220h == this.f7217e.size();
    }

    /* renamed from: d */
    public long m13425d() {
        return this.f7218f;
    }

    /* renamed from: e */
    public long m13424e() {
        return this.f7219g;
    }

    /* renamed from: f */
    public void m13423f() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f7217e.size()) {
                C2085a c2085a = this.f7217e.get(i2);
                System.out.println(C2112b.m13657a(c2085a.f6970a) + " UpgradeFileData--> " + c2085a.f6971b);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: g */
    public C2085a m13422g() {
        return this.f7217e.get(this.f7220h);
    }

    /* renamed from: h */
    public List<C2085a> m13421h() {
        return this.f7217e;
    }
}
