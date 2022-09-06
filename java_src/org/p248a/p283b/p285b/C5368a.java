package org.p248a.p283b.p285b;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.codehaus.jackson.smile.SmileConstants;
import org.p248a.p283b.C5389f;
import org.p248a.p283b.p286c.AbstractC5385d;
/* renamed from: org.a.b.b.a */
/* loaded from: classes2.dex */
public class C5368a extends AbstractC5373e {

    /* renamed from: f */
    private static final C5378j f22420f = new C5378j();

    /* renamed from: a */
    protected boolean f22421a;

    /* renamed from: b */
    protected boolean f22422b;

    /* renamed from: c */
    protected int f22423c;

    /* renamed from: d */
    protected boolean f22424d = false;

    /* renamed from: g */
    private byte[] f22425g = new byte[1];

    /* renamed from: h */
    private byte[] f22426h = new byte[2];

    /* renamed from: i */
    private byte[] f22427i = new byte[4];

    /* renamed from: j */
    private byte[] f22428j = new byte[8];

    /* renamed from: k */
    private byte[] f22429k = new byte[1];

    /* renamed from: l */
    private byte[] f22430l = new byte[2];

    /* renamed from: m */
    private byte[] f22431m = new byte[4];

    /* renamed from: n */
    private byte[] f22432n = new byte[8];

    /* renamed from: org.a.b.b.a$a */
    /* loaded from: classes2.dex */
    public static class C5369a implements AbstractC5375g {

        /* renamed from: a */
        protected boolean f22433a;

        /* renamed from: b */
        protected boolean f22434b;

        /* renamed from: c */
        protected int f22435c;

        public C5369a() {
            this(false, true);
        }

        public C5369a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public C5369a(boolean z, boolean z2, int i) {
            this.f22433a = false;
            this.f22434b = true;
            this.f22433a = z;
            this.f22434b = z2;
            this.f22435c = i;
        }

        @Override // org.p248a.p283b.p285b.AbstractC5375g
        /* renamed from: a */
        public AbstractC5373e mo1221a(AbstractC5385d abstractC5385d) {
            C5368a c5368a = new C5368a(abstractC5385d, this.f22433a, this.f22434b);
            if (this.f22435c != 0) {
                c5368a.m1263c(this.f22435c);
            }
            return c5368a;
        }
    }

    public C5368a(AbstractC5385d abstractC5385d, boolean z, boolean z2) {
        super(abstractC5385d);
        this.f22421a = false;
        this.f22422b = true;
        this.f22421a = z;
        this.f22422b = z2;
    }

    /* renamed from: a */
    private int m1265a(byte[] bArr, int i, int i2) {
        m1262d(i2);
        return this.f22444e.m1211d(bArr, i, i2);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1261a() {
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1260a(byte b) {
        this.f22425g[0] = b;
        this.f22444e.mo1213b(this.f22425g, 0, 1);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1259a(double d) {
        mo1257a(Double.doubleToLongBits(d));
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1258a(int i) {
        this.f22427i[0] = (byte) ((i >> 24) & 255);
        this.f22427i[1] = (byte) ((i >> 16) & 255);
        this.f22427i[2] = (byte) ((i >> 8) & 255);
        this.f22427i[3] = (byte) (i & 255);
        this.f22444e.mo1213b(this.f22427i, 0, 4);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1257a(long j) {
        this.f22428j[0] = (byte) ((j >> 56) & 255);
        this.f22428j[1] = (byte) ((j >> 48) & 255);
        this.f22428j[2] = (byte) ((j >> 40) & 255);
        this.f22428j[3] = (byte) ((j >> 32) & 255);
        this.f22428j[4] = (byte) ((j >> 24) & 255);
        this.f22428j[5] = (byte) ((j >> 16) & 255);
        this.f22428j[6] = (byte) ((j >> 8) & 255);
        this.f22428j[7] = (byte) (255 & j);
        this.f22444e.mo1213b(this.f22428j, 0, 8);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1256a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo1258a(bytes.length);
            this.f22444e.mo1213b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new C5389f("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1255a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo1258a(limit);
        this.f22444e.mo1213b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1254a(C5370b c5370b) {
        mo1260a(c5370b.f22437b);
        mo1249a(c5370b.f22438c);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1253a(C5371c c5371c) {
        mo1260a(c5371c.f22439a);
        mo1258a(c5371c.f22440b);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1252a(C5372d c5372d) {
        mo1260a(c5372d.f22441a);
        mo1260a(c5372d.f22442b);
        mo1258a(c5372d.f22443c);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1251a(C5377i c5377i) {
        mo1260a(c5377i.f22447a);
        mo1258a(c5377i.f22448b);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1250a(C5378j c5378j) {
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1249a(short s) {
        this.f22426h[0] = (byte) ((s >> 8) & 255);
        this.f22426h[1] = (byte) (s & 255);
        this.f22444e.mo1213b(this.f22426h, 0, 2);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: a */
    public void mo1248a(boolean z) {
        mo1260a(z ? (byte) 1 : (byte) 0);
    }

    /* renamed from: b */
    public String m1264b(int i) {
        try {
            m1262d(i);
            byte[] bArr = new byte[i];
            this.f22444e.m1211d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new C5389f("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: b */
    public void mo1247b() {
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: c */
    public void mo1246c() {
        mo1260a((byte) 0);
    }

    /* renamed from: c */
    public void m1263c(int i) {
        this.f22423c = i;
        this.f22424d = true;
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: d */
    public void mo1245d() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void m1262d(int i) {
        if (i < 0) {
            throw new C5389f("Negative length: " + i);
        }
        if (!this.f22424d) {
            return;
        }
        this.f22423c -= i;
        if (this.f22423c >= 0) {
            return;
        }
        throw new C5389f("Message length exceeded: " + i);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: e */
    public void mo1244e() {
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: f */
    public void mo1243f() {
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: g */
    public C5378j mo1242g() {
        return f22420f;
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: h */
    public void mo1241h() {
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: i */
    public C5370b mo1240i() {
        byte mo1234r = mo1234r();
        return new C5370b("", mo1234r, mo1234r == 0 ? (short) 0 : mo1233s());
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: j */
    public void mo1239j() {
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: k */
    public C5372d mo1226k() {
        return new C5372d(mo1234r(), mo1234r(), mo1232t());
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: l */
    public void mo1238l() {
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: m */
    public C5371c mo1225m() {
        return new C5371c(mo1234r(), mo1232t());
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: n */
    public void mo1237n() {
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: o */
    public C5377i mo1224o() {
        return new C5377i(mo1234r(), mo1232t());
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: p */
    public void mo1236p() {
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: q */
    public boolean mo1235q() {
        return mo1234r() == 1;
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: r */
    public byte mo1234r() {
        if (this.f22444e.mo1212c() < 1) {
            m1265a(this.f22429k, 0, 1);
            return this.f22429k[0];
        }
        byte b = this.f22444e.mo1217a()[this.f22444e.mo1214b()];
        this.f22444e.mo1216a(1);
        return b;
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: s */
    public short mo1233s() {
        int i = 0;
        byte[] bArr = this.f22430l;
        if (this.f22444e.mo1212c() >= 2) {
            bArr = this.f22444e.mo1217a();
            i = this.f22444e.mo1214b();
            this.f22444e.mo1216a(2);
        } else {
            m1265a(this.f22430l, 0, 2);
        }
        return (short) ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | ((bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8));
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: t */
    public int mo1232t() {
        int i = 0;
        byte[] bArr = this.f22431m;
        if (this.f22444e.mo1212c() >= 4) {
            bArr = this.f22444e.mo1217a();
            i = this.f22444e.mo1214b();
            this.f22444e.mo1216a(4);
        } else {
            m1265a(this.f22431m, 0, 4);
        }
        return (bArr[i + 3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | ((bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24) | ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((bArr[i + 2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: u */
    public long mo1231u() {
        int i = 0;
        byte[] bArr = this.f22432n;
        if (this.f22444e.mo1212c() >= 8) {
            bArr = this.f22444e.mo1217a();
            i = this.f22444e.mo1214b();
            this.f22444e.mo1216a(8);
        } else {
            m1265a(this.f22432n, 0, 8);
        }
        return (bArr[i + 7] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | ((bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 56) | ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 48) | ((bArr[i + 2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 40) | ((bArr[i + 3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 32) | ((bArr[i + 4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24) | ((bArr[i + 5] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((bArr[i + 6] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: v */
    public double mo1230v() {
        return Double.longBitsToDouble(mo1231u());
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: w */
    public String mo1223w() {
        int mo1232t = mo1232t();
        if (this.f22444e.mo1212c() >= mo1232t) {
            try {
                String str = new String(this.f22444e.mo1217a(), this.f22444e.mo1214b(), mo1232t, "UTF-8");
                this.f22444e.mo1216a(mo1232t);
                return str;
            } catch (UnsupportedEncodingException e) {
                throw new C5389f("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return m1264b(mo1232t);
    }

    @Override // org.p248a.p283b.p285b.AbstractC5373e
    /* renamed from: x */
    public ByteBuffer mo1222x() {
        int mo1232t = mo1232t();
        m1262d(mo1232t);
        if (this.f22444e.mo1212c() >= mo1232t) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f22444e.mo1217a(), this.f22444e.mo1214b(), mo1232t);
            this.f22444e.mo1216a(mo1232t);
            return wrap;
        }
        byte[] bArr = new byte[mo1232t];
        this.f22444e.m1211d(bArr, 0, mo1232t);
        return ByteBuffer.wrap(bArr);
    }
}
