package org.p248a.p283b.p285b;

import com.baidu.android.common.logging.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.p248a.p283b.C5389f;
import org.p248a.p283b.p285b.C5368a;
import org.p248a.p283b.p286c.AbstractC5385d;
/* renamed from: org.a.b.b.k */
/* loaded from: classes2.dex */
public class C5379k extends C5368a {

    /* renamed from: f */
    private static int f22450f = 10000;

    /* renamed from: g */
    private static int f22451g = 10000;

    /* renamed from: h */
    private static int f22452h = 10000;

    /* renamed from: i */
    private static int f22453i = Log.FILE_LIMETE;

    /* renamed from: j */
    private static int f22454j = 104857600;

    /* renamed from: org.a.b.b.k$a */
    /* loaded from: classes2.dex */
    public static class C5380a extends C5368a.C5369a {
        public C5380a() {
            super(false, true);
        }

        public C5380a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // org.p248a.p283b.p285b.C5368a.C5369a, org.p248a.p283b.p285b.AbstractC5375g
        /* renamed from: a */
        public AbstractC5373e mo1221a(AbstractC5385d abstractC5385d) {
            C5379k c5379k = new C5379k(abstractC5385d, this.f22433a, this.f22434b);
            if (this.f22435c != 0) {
                c5379k.m1263c(this.f22435c);
            }
            return c5379k;
        }
    }

    public C5379k(AbstractC5385d abstractC5385d, boolean z, boolean z2) {
        super(abstractC5385d, z, z2);
    }

    @Override // org.p248a.p283b.p285b.C5368a, org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: k */
    public C5372d mo1226k() {
        byte r = r();
        byte r2 = r();
        int t = t();
        if (t > f22450f) {
            throw new C5374f(3, "Thrift map size " + t + " out of range!");
        }
        return new C5372d(r, r2, t);
    }

    @Override // org.p248a.p283b.p285b.C5368a, org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: m */
    public C5371c mo1225m() {
        byte r = r();
        int t = t();
        if (t > f22451g) {
            throw new C5374f(3, "Thrift list size " + t + " out of range!");
        }
        return new C5371c(r, t);
    }

    @Override // org.p248a.p283b.p285b.C5368a, org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: o */
    public C5377i mo1224o() {
        byte r = r();
        int t = t();
        if (t > f22452h) {
            throw new C5374f(3, "Thrift set size " + t + " out of range!");
        }
        return new C5377i(r, t);
    }

    @Override // org.p248a.p283b.p285b.C5368a, org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: w */
    public String mo1223w() {
        int t = t();
        if (t > f22453i) {
            throw new C5374f(3, "Thrift string size " + t + " out of range!");
        }
        if (this.f22444e.mo1212c() < t) {
            return b(t);
        }
        try {
            String str = new String(this.f22444e.mo1217a(), this.f22444e.mo1214b(), t, "UTF-8");
            this.f22444e.mo1216a(t);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new C5389f("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // org.p248a.p283b.p285b.C5368a, org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: x */
    public ByteBuffer mo1222x() {
        int t = t();
        if (t > f22454j) {
            throw new C5374f(3, "Thrift binary size " + t + " out of range!");
        }
        d(t);
        if (this.f22444e.mo1212c() >= t) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f22444e.mo1217a(), this.f22444e.mo1214b(), t);
            this.f22444e.mo1216a(t);
            return wrap;
        }
        byte[] bArr = new byte[t];
        this.f22444e.m1211d(bArr, 0, t);
        return ByteBuffer.wrap(bArr);
    }
}
