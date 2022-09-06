package com.fimi.p139b.p144e;

import com.fimi.p139b.p145f.C2112b;
import com.fimi.p148e.p149a.C2122a;
import com.fimi.p148e.p149a.C2123b;
import com.fimi.p148e.p149a.C2124c;
import com.fimi.p148e.p149a.C2125d;
import com.fimi.p148e.p149a.C2126e;
import com.fimi.p148e.p149a.C2127f;
import com.fimi.p148e.p149a.C2128g;
import com.fimi.p148e.p149a.C2129h;
import com.fimi.p148e.p149a.C2130i;
import java.io.Serializable;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.fimi.b.e.c */
/* loaded from: classes.dex */
public class C2104c implements Serializable {

    /* renamed from: a */
    public static final int f7027a = 254;
    private static final long serialVersionUID = 2095947771227815314L;

    /* renamed from: b */
    public C2105d f7028b;

    /* renamed from: c */
    public C2102a f7029c;

    /* renamed from: d */
    private int f7030d;

    /* renamed from: e */
    private int f7031e;

    /* renamed from: f */
    private int f7032f;

    /* renamed from: g */
    private byte[] f7033g;

    public C2104c() {
        this.f7033g = new byte[6];
        this.f7028b = new C2105d();
        this.f7033g[0] = -2;
    }

    public C2104c(C2105d c2105d) {
        this.f7033g = new byte[6];
        this.f7028b = c2105d;
    }

    /* renamed from: a */
    private void m13710a(byte[] bArr) {
        this.f7029c = new C2102a();
        for (int i = 1; i < bArr.length - 2; i++) {
            this.f7029c.m13728a(bArr[i]);
        }
    }

    /* renamed from: a */
    public int m13714a() {
        return this.f7030d;
    }

    /* renamed from: a */
    public void m13713a(int i) {
        this.f7030d = i;
    }

    /* renamed from: a */
    public void m13712a(int i, int i2) {
        this.f7033g[i] = (byte) i2;
        switch (i) {
            case 1:
                m13708b(i2);
                return;
            case 5:
                this.f7032f = i2;
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void m13711a(int i, int i2, int i3, int i4, int i5) {
        this.f7033g[1] = (byte) (i + 4);
        this.f7030d = i;
        this.f7033g[2] = (byte) i2;
        this.f7033g[3] = (byte) i3;
        this.f7033g[4] = (byte) i4;
        this.f7033g[5] = (byte) i5;
        this.f7032f = i5;
    }

    /* renamed from: b */
    public int m13709b() {
        return this.f7031e;
    }

    /* renamed from: b */
    public void m13708b(int i) {
        this.f7031e = i;
    }

    /* renamed from: c */
    public int m13707c() {
        return this.f7032f;
    }

    /* renamed from: c */
    public void m13706c(int i) {
        this.f7032f = i;
    }

    /* renamed from: d */
    public boolean m13705d() {
        return this.f7028b.m13692b() >= 511 || this.f7028b.m13692b() == (this.f7033g[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) + (-4);
    }

    /* renamed from: e */
    public void m13704e() {
        this.f7029c = new C2102a();
        for (int i = 1; i < this.f7033g.length; i++) {
            this.f7029c.m13728a(this.f7033g[i]);
        }
        this.f7028b.m13688c();
        for (int i2 = 0; i2 < this.f7028b.m13692b(); i2++) {
            this.f7029c.m13728a(this.f7028b.m13686d());
        }
    }

    /* renamed from: f */
    public byte[] m13703f() {
        int i = 6;
        int i2 = 0;
        byte[] bArr = new byte[this.f7030d + 6 + 2];
        System.arraycopy(this.f7033g, 0, bArr, 0, 6);
        while (i2 < this.f7028b.m13692b()) {
            bArr[i] = this.f7028b.f7035b.get(i2);
            i2++;
            i++;
        }
        m13710a(bArr);
        int i3 = i + 1;
        bArr[i] = (byte) this.f7029c.m13725c();
        int i4 = i3 + 1;
        bArr[i3] = (byte) this.f7029c.m13727b();
        System.out.println("encodePacket " + C2112b.m13657a(bArr));
        return bArr;
    }

    /* renamed from: g */
    public AbstractC2103b m13702g() {
        switch (this.f7033g[5] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) {
            case 25:
                C2124c c2124c = new C2124c();
                c2124c.b(25);
                c2124c.mo13475a(this.f7028b);
                return c2124c;
            case 65:
                C2122a c2122a = new C2122a();
                c2122a.b(65);
                c2122a.mo13475a(this.f7028b);
                return c2122a;
            case 125:
                C2123b c2123b = new C2123b();
                c2123b.b(125);
                c2123b.mo13475a(this.f7028b);
                return c2123b;
            case 193:
                C2125d c2125d = new C2125d();
                c2125d.b(193);
                c2125d.mo13475a(this.f7028b);
                return c2125d;
            case 199:
                C2126e c2126e = new C2126e();
                c2126e.b(199);
                c2126e.mo13475a(this.f7028b);
                return c2126e;
            case 201:
                C2127f c2127f = new C2127f();
                c2127f.b(201);
                c2127f.mo13475a(this.f7028b);
                return c2127f;
            case 202:
                C2128g c2128g = new C2128g();
                c2128g.b(202);
                c2128g.mo13475a(this.f7028b);
                return c2128g;
            case 203:
                C2129h c2129h = new C2129h();
                c2129h.b(203);
                c2129h.mo13475a(this.f7028b);
                return c2129h;
            case 204:
                C2130i c2130i = new C2130i();
                c2130i.b(204);
                c2130i.mo13475a(this.f7028b);
                return c2130i;
            default:
                return null;
        }
    }
}
