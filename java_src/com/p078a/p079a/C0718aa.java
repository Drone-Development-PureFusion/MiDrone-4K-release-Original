package com.p078a.p079a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
/* renamed from: com.a.a.aa */
/* loaded from: classes.dex */
public class C0718aa extends FilterOutputStream {

    /* renamed from: a */
    public static final int f1723a = 8;

    /* renamed from: b */
    public static final int f1724b = -1;

    /* renamed from: c */
    public static final int f1725c = 0;
    @Deprecated

    /* renamed from: e */
    public static final int f1727e = 2048;

    /* renamed from: n */
    private static final int f1734n = 512;

    /* renamed from: p */
    private static final int f1735p = 8192;

    /* renamed from: A */
    private long f1737A;

    /* renamed from: D */
    private final Map<ZipEntry, Long> f1738D;

    /* renamed from: E */
    private String f1739E;

    /* renamed from: F */
    private AbstractC0745u f1740F;

    /* renamed from: G */
    private final RandomAccessFile f1741G;

    /* renamed from: H */
    private boolean f1742H;

    /* renamed from: I */
    private boolean f1743I;

    /* renamed from: J */
    private C0720b f1744J;

    /* renamed from: K */
    private boolean f1745K;

    /* renamed from: L */
    private EnumC0741q f1746L;

    /* renamed from: f */
    protected final Deflater f1747f;

    /* renamed from: g */
    protected byte[] f1748g;

    /* renamed from: o */
    private boolean f1749o;

    /* renamed from: r */
    private C0719a f1750r;

    /* renamed from: s */
    private String f1751s;

    /* renamed from: t */
    private int f1752t;

    /* renamed from: u */
    private boolean f1753u;

    /* renamed from: v */
    private int f1754v;

    /* renamed from: w */
    private final List<C0748w> f1755w;

    /* renamed from: x */
    private final CRC32 f1756x;

    /* renamed from: y */
    private long f1757y;

    /* renamed from: z */
    private long f1758z;

    /* renamed from: d */
    static final String f1726d = null;

    /* renamed from: q */
    private static final byte[] f1736q = new byte[0];

    /* renamed from: B */
    private static final byte[] f1720B = new byte[2];

    /* renamed from: C */
    private static final byte[] f1721C = new byte[4];

    /* renamed from: h */
    protected static final byte[] f1728h = C0756z.f1940b.m19130a();

    /* renamed from: i */
    protected static final byte[] f1729i = C0756z.f1941c.m19130a();

    /* renamed from: j */
    protected static final byte[] f1730j = C0756z.f1939a.m19130a();

    /* renamed from: k */
    protected static final byte[] f1731k = C0756z.m19129a(101010256);

    /* renamed from: l */
    static final byte[] f1732l = C0756z.m19129a(101075792);

    /* renamed from: m */
    static final byte[] f1733m = C0756z.m19129a(117853008);

    /* renamed from: M */
    private static final byte[] f1722M = C0756z.m19129a(1);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.a.a.aa$a */
    /* loaded from: classes.dex */
    public static final class C0719a {

        /* renamed from: a */
        private final C0748w f1759a;

        /* renamed from: b */
        private long f1760b;

        /* renamed from: c */
        private long f1761c;

        /* renamed from: d */
        private long f1762d;

        /* renamed from: e */
        private boolean f1763e;

        /* renamed from: f */
        private boolean f1764f;

        private C0719a(C0748w c0748w) {
            this.f1760b = 0L;
            this.f1761c = 0L;
            this.f1762d = 0L;
            this.f1763e = false;
            this.f1759a = c0748w;
        }

        /* synthetic */ C0719a(C0748w c0748w, C0719a c0719a) {
            this(c0748w);
        }
    }

    /* renamed from: com.a.a.aa$b */
    /* loaded from: classes.dex */
    public static final class C0720b {

        /* renamed from: a */
        public static final C0720b f1765a = new C0720b("always");

        /* renamed from: b */
        public static final C0720b f1766b = new C0720b("never");

        /* renamed from: c */
        public static final C0720b f1767c = new C0720b("not encodeable");

        /* renamed from: d */
        private final String f1768d;

        private C0720b(String str) {
            this.f1768d = str;
        }

        public String toString() {
            return this.f1768d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0718aa(File file) {
        super(null);
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        this.f1749o = false;
        this.f1751s = "";
        this.f1752t = -1;
        this.f1753u = false;
        this.f1754v = 8;
        this.f1755w = new LinkedList();
        this.f1756x = new CRC32();
        this.f1757y = 0L;
        this.f1758z = 0L;
        this.f1737A = 0L;
        this.f1738D = new HashMap();
        this.f1739E = null;
        this.f1740F = AbstractC0746v.m19199a(f1726d);
        this.f1747f = new Deflater(this.f1752t, true);
        this.f1748g = new byte[512];
        this.f1742H = true;
        this.f1743I = false;
        this.f1744J = C0720b.f1766b;
        this.f1745K = false;
        this.f1746L = EnumC0741q.AsNeeded;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (IOException e) {
            randomAccessFile = null;
        }
        try {
            randomAccessFile.setLength(0L);
            randomAccessFile2 = randomAccessFile;
        } catch (IOException e2) {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e3) {
                }
            } else {
                randomAccessFile2 = randomAccessFile;
            }
            this.out = new FileOutputStream(file);
            this.f1741G = randomAccessFile2;
        }
        this.f1741G = randomAccessFile2;
    }

    public C0718aa(OutputStream outputStream) {
        super(outputStream);
        this.f1749o = false;
        this.f1751s = "";
        this.f1752t = -1;
        this.f1753u = false;
        this.f1754v = 8;
        this.f1755w = new LinkedList();
        this.f1756x = new CRC32();
        this.f1757y = 0L;
        this.f1758z = 0L;
        this.f1737A = 0L;
        this.f1738D = new HashMap();
        this.f1739E = null;
        this.f1740F = AbstractC0746v.m19199a(f1726d);
        this.f1747f = new Deflater(this.f1752t, true);
        this.f1748g = new byte[512];
        this.f1742H = true;
        this.f1743I = false;
        this.f1744J = C0720b.f1766b;
        this.f1745K = false;
        this.f1746L = EnumC0741q.AsNeeded;
        this.f1741G = null;
    }

    /* renamed from: a */
    protected static C0756z m19324a(Date date) {
        return AbstractC0722ac.m19270a(date);
    }

    /* renamed from: a */
    private void m19333a(int i, boolean z, boolean z2) {
        int i2;
        C0728f c0728f = new C0728f();
        c0728f.m19243a(this.f1742H || z);
        if (i == 8 && this.f1741G == null) {
            i2 = 20;
            c0728f.m19240b(true);
        } else {
            i2 = 10;
        }
        if (z2) {
            i2 = 45;
        }
        m19320a(C0721ab.m19280a(i2));
        m19320a(c0728f.m19235e());
    }

    /* renamed from: a */
    private void m19327a(C0748w c0748w, long j, boolean z) {
        if (z) {
            C0740p m19298f = m19298f(c0748w);
            if (c0748w.getCompressedSize() >= 4294967295L || c0748w.getSize() >= 4294967295L) {
                m19298f.m19218b(new C0744t(c0748w.getCompressedSize()));
                m19298f.m19223a(new C0744t(c0748w.getSize()));
            } else {
                m19298f.m19218b(null);
                m19298f.m19223a((C0744t) null);
            }
            if (j >= 4294967295L) {
                m19298f.m19216c(new C0744t(j));
            }
            c0748w.m19171h();
        }
    }

    /* renamed from: a */
    private void m19326a(C0748w c0748w, boolean z, ByteBuffer byteBuffer) {
        if (this.f1744J == C0720b.f1765a || !z) {
            c0748w.m19189a(new C0734k(c0748w.getName(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position()));
        }
        String comment = c0748w.getComment();
        if (comment == null || "".equals(comment)) {
            return;
        }
        boolean mo19202a = this.f1740F.mo19202a(comment);
        if (this.f1744J != C0720b.f1765a && mo19202a) {
            return;
        }
        ByteBuffer mo19200b = m19306c((ZipEntry) c0748w).mo19200b(comment);
        c0748w.m19189a(new C0733j(comment, mo19200b.array(), mo19200b.arrayOffset(), mo19200b.limit() - mo19200b.position()));
    }

    /* renamed from: a */
    private void m19323a(ZipEntry zipEntry) {
        if (zipEntry.getMethod() == -1) {
            zipEntry.setMethod(this.f1754v);
        }
        if (zipEntry.getTime() == -1) {
            zipEntry.setTime(System.currentTimeMillis());
        }
    }

    /* renamed from: a */
    private boolean m19331a(long j, long j2, EnumC0741q enumC0741q) {
        if (this.f1750r.f1759a.getMethod() == 8) {
            this.f1750r.f1759a.setSize(this.f1750r.f1762d);
            this.f1750r.f1759a.setCompressedSize(j);
            this.f1750r.f1759a.setCrc(j2);
            this.f1747f.reset();
        } else if (this.f1741G != null) {
            this.f1750r.f1759a.setSize(j);
            this.f1750r.f1759a.setCompressedSize(j);
            this.f1750r.f1759a.setCrc(j2);
        } else if (this.f1750r.f1759a.getCrc() != j2) {
            throw new ZipException("bad CRC checksum for entry " + this.f1750r.f1759a.getName() + ": " + Long.toHexString(this.f1750r.f1759a.getCrc()) + " instead of " + Long.toHexString(j2));
        } else {
            if (this.f1750r.f1759a.getSize() != j) {
                throw new ZipException("bad size for entry " + this.f1750r.f1759a.getName() + ": " + this.f1750r.f1759a.getSize() + " instead of " + j);
            }
        }
        boolean z = enumC0741q == EnumC0741q.Always || this.f1750r.f1759a.getSize() >= 4294967295L || this.f1750r.f1759a.getCompressedSize() >= 4294967295L;
        if (!z || enumC0741q != EnumC0741q.Never) {
            return z;
        }
        throw new C0742r(C0742r.m19212a(this.f1750r.f1759a));
    }

    /* renamed from: a */
    private boolean m19322a(ZipEntry zipEntry, EnumC0741q enumC0741q) {
        return enumC0741q == EnumC0741q.Always || zipEntry.getSize() >= 4294967295L || zipEntry.getCompressedSize() >= 4294967295L || !(zipEntry.getSize() != -1 || this.f1741G == null || enumC0741q == EnumC0741q.Never);
    }

    /* renamed from: a */
    protected static byte[] m19332a(long j) {
        return AbstractC0722ac.m19275a(j);
    }

    /* renamed from: b */
    private EnumC0741q m19313b(ZipEntry zipEntry) {
        return (this.f1746L == EnumC0741q.AsNeeded && this.f1741G == null && zipEntry.getMethod() == 8 && zipEntry.getSize() == -1) ? EnumC0741q.Never : this.f1746L;
    }

    /* renamed from: b */
    private void m19316b(EnumC0741q enumC0741q) {
        if (this.f1750r.f1759a.getMethod() == 0 && this.f1741G == null) {
            if (this.f1750r.f1759a.getSize() == -1) {
                throw new ZipException("uncompressed size is required for STORED method when not writing to a file");
            }
            if (this.f1750r.f1759a.getCrc() == -1) {
                throw new ZipException("crc checksum is required for STORED method when not writing to a file");
            }
            this.f1750r.f1759a.setCompressedSize(this.f1750r.f1759a.getSize());
        }
        if ((this.f1750r.f1759a.getSize() >= 4294967295L || this.f1750r.f1759a.getCompressedSize() >= 4294967295L) && enumC0741q == EnumC0741q.Never) {
            throw new C0742r(C0742r.m19212a(this.f1750r.f1759a));
        }
    }

    /* renamed from: b */
    private void m19311b(byte[] bArr, int i, int i2) {
        if (i2 <= 0 || this.f1747f.finished()) {
            return;
        }
        this.f1750r.f1762d += i2;
        if (i2 <= 8192) {
            this.f1747f.setInput(bArr, i, i2);
            m19293j();
            return;
        }
        int i3 = i2 / 8192;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f1747f.setInput(bArr, (i4 * 8192) + i, 8192);
            m19293j();
        }
        int i5 = i3 * 8192;
        if (i5 >= i2) {
            return;
        }
        this.f1747f.setInput(bArr, i + i5, i2 - i5);
        m19293j();
    }

    /* renamed from: c */
    protected static long m19309c(int i) {
        return AbstractC0722ac.m19276a(i);
    }

    /* renamed from: c */
    private AbstractC0745u m19306c(ZipEntry zipEntry) {
        return (this.f1740F.mo19202a(zipEntry.getName()) || !this.f1743I) ? this.f1740F : AbstractC0746v.f1878b;
    }

    /* renamed from: c */
    private void m19305c(boolean z) {
        long filePointer = this.f1741G.getFilePointer();
        this.f1741G.seek(this.f1750r.f1760b);
        m19320a(C0756z.m19129a(this.f1750r.f1759a.getCrc()));
        if (!m19296g(this.f1750r.f1759a) || !z) {
            m19320a(C0756z.m19129a(this.f1750r.f1759a.getCompressedSize()));
            m19320a(C0756z.m19129a(this.f1750r.f1759a.getSize()));
        } else {
            m19320a(C0756z.f1942d.m19130a());
            m19320a(C0756z.f1942d.m19130a());
        }
        if (m19296g(this.f1750r.f1759a)) {
            this.f1741G.seek(this.f1750r.f1760b + 12 + 4 + m19302d((ZipEntry) this.f1750r.f1759a).limit() + 4);
            m19320a(C0744t.m19210a(this.f1750r.f1759a.getSize()));
            m19320a(C0744t.m19210a(this.f1750r.f1759a.getCompressedSize()));
            if (!z) {
                this.f1741G.seek(this.f1750r.f1760b - 10);
                m19320a(C0721ab.m19280a(10));
                this.f1750r.f1759a.m19191a(C0740p.f1829a);
                this.f1750r.f1759a.m19171h();
                if (this.f1750r.f1763e) {
                    this.f1745K = false;
                }
            }
        }
        this.f1741G.seek(filePointer);
    }

    /* renamed from: d */
    private ByteBuffer m19302d(ZipEntry zipEntry) {
        return m19306c(zipEntry).mo19200b(zipEntry.getName());
    }

    /* renamed from: f */
    private C0740p m19298f(C0748w c0748w) {
        if (this.f1750r != null) {
            this.f1750r.f1763e = !this.f1745K;
        }
        this.f1745K = true;
        C0740p c0740p = (C0740p) c0748w.m19179b(C0740p.f1829a);
        if (c0740p == null) {
            c0740p = new C0740p();
        }
        c0748w.m19178b(c0740p);
        return c0740p;
    }

    /* renamed from: g */
    private boolean m19296g(C0748w c0748w) {
        return c0748w.m19179b(C0740p.f1829a) != null;
    }

    /* renamed from: i */
    private void m19294i() {
        if (this.f1750r.f1759a.getMethod() == 8) {
            this.f1747f.finish();
            while (!this.f1747f.finished()) {
                m19301e();
            }
        }
    }

    /* renamed from: j */
    private void m19293j() {
        while (!this.f1747f.needsInput()) {
            m19301e();
        }
    }

    /* renamed from: a */
    public void m19334a(int i) {
        if (i < -1 || i > 9) {
            throw new IllegalArgumentException("Invalid compression level: " + i);
        }
        this.f1753u = this.f1752t != i;
        this.f1752t = i;
    }

    /* renamed from: a */
    public void m19330a(C0720b c0720b) {
        this.f1744J = c0720b;
    }

    /* renamed from: a */
    public void m19329a(EnumC0741q enumC0741q) {
        this.f1746L = enumC0741q;
    }

    /* renamed from: a */
    public void m19328a(C0748w c0748w) {
        if (this.f1749o) {
            throw new IOException("Stream has already been finished");
        }
        if (this.f1750r != null) {
            m19304d();
        }
        this.f1750r = new C0719a(c0748w, null);
        this.f1755w.add(this.f1750r.f1759a);
        m19323a((ZipEntry) this.f1750r.f1759a);
        EnumC0741q m19313b = m19313b((ZipEntry) this.f1750r.f1759a);
        m19316b(m19313b);
        if (m19322a(this.f1750r.f1759a, m19313b)) {
            C0740p m19298f = m19298f(this.f1750r.f1759a);
            C0744t c0744t = C0744t.f1852a;
            if (this.f1750r.f1759a.getMethod() == 0 && this.f1750r.f1759a.getSize() != -1) {
                c0744t = new C0744t(this.f1750r.f1759a.getSize());
            }
            m19298f.m19223a(c0744t);
            m19298f.m19218b(c0744t);
            this.f1750r.f1759a.m19171h();
        }
        if (this.f1750r.f1759a.getMethod() == 8 && this.f1753u) {
            this.f1747f.setLevel(this.f1752t);
            this.f1753u = false;
        }
        m19308c(this.f1750r.f1759a);
    }

    /* renamed from: a */
    public void m19325a(String str) {
        this.f1739E = str;
        this.f1740F = AbstractC0746v.m19199a(str);
        if (!this.f1742H || AbstractC0746v.m19196b(str)) {
            return;
        }
        this.f1742H = false;
    }

    /* renamed from: a */
    public void m19321a(boolean z) {
        this.f1742H = z && AbstractC0746v.m19196b(this.f1739E);
    }

    /* renamed from: a */
    protected final void m19320a(byte[] bArr) {
        m19319a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    protected final void m19319a(byte[] bArr, int i, int i2) {
        if (this.f1741G != null) {
            this.f1741G.write(bArr, i, i2);
        } else {
            this.out.write(bArr, i, i2);
        }
    }

    /* renamed from: a */
    public boolean m19335a() {
        return this.f1741G != null;
    }

    /* renamed from: b */
    public String m19318b() {
        return this.f1739E;
    }

    /* renamed from: b */
    public void m19317b(int i) {
        this.f1754v = i;
    }

    /* renamed from: b */
    public void m19314b(String str) {
        this.f1751s = str;
    }

    /* renamed from: b */
    public void m19312b(boolean z) {
        this.f1743I = z;
    }

    /* renamed from: b */
    public boolean m19315b(C0748w c0748w) {
        return AbstractC0722ac.m19273a(c0748w);
    }

    /* renamed from: c */
    public void m19310c() {
        if (this.f1749o) {
            throw new IOException("This archive has already been finished");
        }
        if (this.f1750r != null) {
            m19304d();
        }
        this.f1758z = this.f1757y;
        for (C0748w c0748w : this.f1755w) {
            m19300e(c0748w);
        }
        this.f1737A = this.f1757y - this.f1758z;
        m19297g();
        m19299f();
        this.f1738D.clear();
        this.f1755w.clear();
        this.f1747f.end();
        this.f1749o = true;
    }

    /* renamed from: c */
    protected void m19308c(C0748w c0748w) {
        boolean mo19202a = this.f1740F.mo19202a(c0748w.getName());
        ByteBuffer m19302d = m19302d((ZipEntry) c0748w);
        if (this.f1744J != C0720b.f1766b) {
            m19326a(c0748w, mo19202a, m19302d);
        }
        this.f1738D.put(c0748w, Long.valueOf(this.f1757y));
        m19320a(f1728h);
        this.f1757y += 4;
        int method = c0748w.getMethod();
        m19333a(method, !mo19202a && this.f1743I, m19296g(c0748w));
        this.f1757y += 4;
        m19320a(C0721ab.m19280a(method));
        this.f1757y += 2;
        m19320a(AbstractC0722ac.m19275a(c0748w.getTime()));
        this.f1757y += 4;
        this.f1750r.f1760b = this.f1757y;
        if (method == 8 || this.f1741G != null) {
            m19320a(f1721C);
            if (m19296g(this.f1750r.f1759a)) {
                m19320a(C0756z.f1942d.m19130a());
                m19320a(C0756z.f1942d.m19130a());
            } else {
                m19320a(f1721C);
                m19320a(f1721C);
            }
        } else {
            m19320a(C0756z.m19129a(c0748w.getCrc()));
            byte[] m19130a = C0756z.f1942d.m19130a();
            if (!m19296g(c0748w)) {
                m19130a = C0756z.m19129a(c0748w.getSize());
            }
            m19320a(m19130a);
            m19320a(m19130a);
        }
        this.f1757y += 12;
        m19320a(C0721ab.m19280a(m19302d.limit()));
        this.f1757y += 2;
        byte[] m19170i = c0748w.m19170i();
        m19320a(C0721ab.m19280a(m19170i.length));
        this.f1757y += 2;
        m19319a(m19302d.array(), m19302d.arrayOffset(), m19302d.limit() - m19302d.position());
        this.f1757y += m19302d.limit();
        m19320a(m19170i);
        this.f1757y = m19170i.length + this.f1757y;
        this.f1750r.f1761c = this.f1757y;
    }

    /* renamed from: c */
    protected byte[] m19307c(String str) {
        try {
            ByteBuffer mo19200b = AbstractC0746v.m19199a(this.f1739E).mo19200b(str);
            byte[] bArr = new byte[mo19200b.limit()];
            System.arraycopy(mo19200b.array(), mo19200b.arrayOffset(), bArr, 0, bArr.length);
            return bArr;
        } catch (IOException e) {
            throw new ZipException("Failed to encode name: " + e.getMessage());
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f1749o) {
            m19310c();
        }
        m19295h();
    }

    /* renamed from: d */
    public void m19304d() {
        if (this.f1749o) {
            throw new IOException("Stream has already been finished");
        }
        if (this.f1750r == null) {
            throw new IOException("No current entry to close");
        }
        if (!this.f1750r.f1764f) {
            write(f1736q, 0, 0);
        }
        m19294i();
        EnumC0741q m19313b = m19313b((ZipEntry) this.f1750r.f1759a);
        long j = this.f1757y - this.f1750r.f1761c;
        long value = this.f1756x.getValue();
        this.f1756x.reset();
        boolean m19331a = m19331a(j, value, m19313b);
        if (this.f1741G != null) {
            m19305c(m19331a);
        }
        m19303d(this.f1750r.f1759a);
        this.f1750r = null;
    }

    /* renamed from: d */
    protected void m19303d(C0748w c0748w) {
        if (c0748w.getMethod() == 8 && this.f1741G == null) {
            m19320a(f1729i);
            m19320a(C0756z.m19129a(c0748w.getCrc()));
            int i = 4;
            if (!m19296g(c0748w)) {
                m19320a(C0756z.m19129a(c0748w.getCompressedSize()));
                m19320a(C0756z.m19129a(c0748w.getSize()));
            } else {
                m19320a(C0744t.m19210a(c0748w.getCompressedSize()));
                m19320a(C0744t.m19210a(c0748w.getSize()));
                i = 8;
            }
            this.f1757y = (i * 2) + 8 + this.f1757y;
        }
    }

    /* renamed from: e */
    protected final void m19301e() {
        int deflate = this.f1747f.deflate(this.f1748g, 0, this.f1748g.length);
        if (deflate > 0) {
            m19319a(this.f1748g, 0, deflate);
            this.f1757y = deflate + this.f1757y;
        }
    }

    /* renamed from: e */
    protected void m19300e(C0748w c0748w) {
        m19320a(f1730j);
        this.f1757y += 4;
        long longValue = this.f1738D.get(c0748w).longValue();
        boolean z = m19296g(c0748w) || c0748w.getCompressedSize() >= 4294967295L || c0748w.getSize() >= 4294967295L || longValue >= 4294967295L;
        if (!z || this.f1746L != EnumC0741q.Never) {
            m19327a(c0748w, longValue, z);
            m19320a(C0721ab.m19280a((!this.f1745K ? 20 : 45) | (c0748w.m19175d() << 8)));
            this.f1757y += 2;
            int method = c0748w.getMethod();
            m19333a(method, !this.f1740F.mo19202a(c0748w.getName()) && this.f1743I, z);
            this.f1757y += 4;
            m19320a(C0721ab.m19280a(method));
            this.f1757y += 2;
            m19320a(AbstractC0722ac.m19275a(c0748w.getTime()));
            this.f1757y += 4;
            m19320a(C0756z.m19129a(c0748w.getCrc()));
            if (c0748w.getCompressedSize() >= 4294967295L || c0748w.getSize() >= 4294967295L) {
                m19320a(C0756z.f1942d.m19130a());
                m19320a(C0756z.f1942d.m19130a());
            } else {
                m19320a(C0756z.m19129a(c0748w.getCompressedSize()));
                m19320a(C0756z.m19129a(c0748w.getSize()));
            }
            this.f1757y += 12;
            ByteBuffer m19302d = m19302d((ZipEntry) c0748w);
            m19320a(C0721ab.m19280a(m19302d.limit()));
            this.f1757y += 2;
            byte[] m19169j = c0748w.m19169j();
            m19320a(C0721ab.m19280a(m19169j.length));
            this.f1757y += 2;
            String comment = c0748w.getComment();
            if (comment == null) {
                comment = "";
            }
            ByteBuffer mo19200b = m19306c((ZipEntry) c0748w).mo19200b(comment);
            m19320a(C0721ab.m19280a(mo19200b.limit()));
            this.f1757y += 2;
            m19320a(f1720B);
            this.f1757y += 2;
            m19320a(C0721ab.m19280a(c0748w.m19194a()));
            this.f1757y += 2;
            m19320a(C0756z.m19129a(c0748w.m19182b()));
            this.f1757y += 4;
            m19320a(C0756z.m19129a(Math.min(longValue, 4294967295L)));
            this.f1757y += 4;
            m19319a(m19302d.array(), m19302d.arrayOffset(), m19302d.limit() - m19302d.position());
            this.f1757y += m19302d.limit();
            m19320a(m19169j);
            this.f1757y = m19169j.length + this.f1757y;
            m19319a(mo19200b.array(), mo19200b.arrayOffset(), mo19200b.limit() - mo19200b.position());
            this.f1757y = mo19200b.limit() + this.f1757y;
            return;
        }
        throw new C0742r("archive's size exceeds the limit of 4GByte.");
    }

    /* renamed from: f */
    protected void m19299f() {
        m19320a(f1731k);
        m19320a(f1720B);
        m19320a(f1720B);
        int size = this.f1755w.size();
        if (size <= 65535 || this.f1746L != EnumC0741q.Never) {
            if (this.f1758z > 4294967295L && this.f1746L == EnumC0741q.Never) {
                throw new C0742r("archive's size exceeds the limit of 4GByte.");
            }
            byte[] m19280a = C0721ab.m19280a(Math.min(size, 65535));
            m19320a(m19280a);
            m19320a(m19280a);
            m19320a(C0756z.m19129a(Math.min(this.f1737A, 4294967295L)));
            m19320a(C0756z.m19129a(Math.min(this.f1758z, 4294967295L)));
            ByteBuffer mo19200b = this.f1740F.mo19200b(this.f1751s);
            m19320a(C0721ab.m19280a(mo19200b.limit()));
            m19319a(mo19200b.array(), mo19200b.arrayOffset(), mo19200b.limit() - mo19200b.position());
            return;
        }
        throw new C0742r("archive contains more than 65535 entries.");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        if (this.out != null) {
            this.out.flush();
        }
    }

    /* renamed from: g */
    protected void m19297g() {
        if (this.f1746L == EnumC0741q.Never) {
            return;
        }
        if (!this.f1745K && (this.f1758z >= 4294967295L || this.f1737A >= 4294967295L || this.f1755w.size() >= 65535)) {
            this.f1745K = true;
        }
        if (!this.f1745K) {
            return;
        }
        long j = this.f1757y;
        m19320a(f1732l);
        m19320a(C0744t.m19210a(44L));
        m19320a(C0721ab.m19280a(45));
        m19320a(C0721ab.m19280a(45));
        m19320a(f1721C);
        m19320a(f1721C);
        byte[] m19210a = C0744t.m19210a(this.f1755w.size());
        m19320a(m19210a);
        m19320a(m19210a);
        m19320a(C0744t.m19210a(this.f1737A));
        m19320a(C0744t.m19210a(this.f1758z));
        m19320a(f1733m);
        m19320a(f1721C);
        m19320a(C0744t.m19210a(j));
        m19320a(f1722M);
    }

    /* renamed from: h */
    void m19295h() {
        if (this.f1741G != null) {
            this.f1741G.close();
        }
        if (this.out != null) {
            this.out.close();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        AbstractC0722ac.m19267b(this.f1750r.f1759a);
        this.f1750r.f1764f = true;
        if (this.f1750r.f1759a.getMethod() == 8) {
            m19311b(bArr, i, i2);
        } else {
            m19319a(bArr, i, i2);
            this.f1757y += i2;
        }
        this.f1756x.update(bArr, i, i2);
    }
}
