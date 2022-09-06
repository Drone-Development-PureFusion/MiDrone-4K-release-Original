package com.p078a.p079a;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;
/* renamed from: com.a.a.y */
/* loaded from: classes.dex */
public class C0750y {

    /* renamed from: A */
    private static final int f1899A = 48;

    /* renamed from: B */
    private static final long f1900B = 26;

    /* renamed from: a */
    static final int f1901a = 15;

    /* renamed from: b */
    static final int f1902b = 8;

    /* renamed from: c */
    private static final int f1903c = 509;

    /* renamed from: d */
    private static final int f1904d = 0;

    /* renamed from: e */
    private static final int f1905e = 1;

    /* renamed from: f */
    private static final int f1906f = 2;

    /* renamed from: g */
    private static final int f1907g = 3;

    /* renamed from: t */
    private static final int f1908t = 42;

    /* renamed from: u */
    private static final long f1909u = C0756z.m19128a(C0718aa.f1730j);

    /* renamed from: v */
    private static final int f1910v = 22;

    /* renamed from: w */
    private static final int f1911w = 65557;

    /* renamed from: x */
    private static final int f1912x = 16;

    /* renamed from: y */
    private static final int f1913y = 20;

    /* renamed from: z */
    private static final int f1914z = 8;

    /* renamed from: C */
    private final Comparator<C0748w> f1915C;

    /* renamed from: h */
    private final Map<C0748w, C0755c> f1916h;

    /* renamed from: i */
    private final Map<String, C0748w> f1917i;

    /* renamed from: j */
    private final String f1918j;

    /* renamed from: k */
    private final AbstractC0745u f1919k;

    /* renamed from: l */
    private final String f1920l;

    /* renamed from: m */
    private final RandomAccessFile f1921m;

    /* renamed from: n */
    private final boolean f1922n;

    /* renamed from: o */
    private boolean f1923o;

    /* renamed from: p */
    private final byte[] f1924p;

    /* renamed from: q */
    private final byte[] f1925q;

    /* renamed from: r */
    private final byte[] f1926r;

    /* renamed from: s */
    private final byte[] f1927s;

    /* renamed from: com.a.a.y$a */
    /* loaded from: classes.dex */
    private class C0753a extends InputStream {

        /* renamed from: b */
        private long f1932b;

        /* renamed from: c */
        private long f1933c;

        /* renamed from: d */
        private boolean f1934d = false;

        C0753a(long j, long j2) {
            this.f1932b = j2;
            this.f1933c = j;
        }

        /* renamed from: a */
        void m19137a() {
            this.f1934d = true;
        }

        @Override // java.io.InputStream
        public int read() {
            int read;
            long j = this.f1932b;
            this.f1932b = j - 1;
            if (j <= C0750y.f1909u) {
                if (!this.f1934d) {
                    return -1;
                }
                this.f1934d = false;
                return 0;
            }
            synchronized (C0750y.this.f1921m) {
                RandomAccessFile randomAccessFile = C0750y.this.f1921m;
                long j2 = this.f1933c;
                this.f1933c = j2 + 1;
                randomAccessFile.seek(j2);
                read = C0750y.this.f1921m.read();
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read;
            if (this.f1932b <= C0750y.f1909u) {
                if (!this.f1934d) {
                    return -1;
                }
                this.f1934d = false;
                bArr[i] = 0;
                return 1;
            } else if (i2 <= 0) {
                return 0;
            } else {
                if (i2 > this.f1932b) {
                    i2 = (int) this.f1932b;
                }
                synchronized (C0750y.this.f1921m) {
                    C0750y.this.f1921m.seek(this.f1933c);
                    read = C0750y.this.f1921m.read(bArr, i, i2);
                }
                if (read <= 0) {
                    return read;
                }
                this.f1933c += read;
                this.f1932b -= read;
                return read;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.a.a.y$b */
    /* loaded from: classes.dex */
    public static final class C0754b {

        /* renamed from: a */
        private final byte[] f1935a;

        /* renamed from: b */
        private final byte[] f1936b;

        private C0754b(byte[] bArr, byte[] bArr2) {
            this.f1935a = bArr;
            this.f1936b = bArr2;
        }

        /* synthetic */ C0754b(byte[] bArr, byte[] bArr2, C0754b c0754b) {
            this(bArr, bArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.a.a.y$c */
    /* loaded from: classes.dex */
    public static final class C0755c {

        /* renamed from: a */
        private long f1937a;

        /* renamed from: b */
        private long f1938b;

        private C0755c() {
            this.f1937a = -1L;
            this.f1938b = -1L;
        }

        /* synthetic */ C0755c(C0755c c0755c) {
            this();
        }
    }

    public C0750y(File file) {
        this(file, (String) null);
    }

    public C0750y(File file, String str) {
        this(file, str, true);
    }

    public C0750y(File file, String str, boolean z) {
        this.f1916h = new LinkedHashMap((int) f1903c);
        this.f1917i = new HashMap((int) f1903c);
        this.f1924p = new byte[8];
        this.f1925q = new byte[4];
        this.f1926r = new byte[42];
        this.f1927s = new byte[2];
        this.f1915C = new Comparator<C0748w>() { // from class: com.a.a.y.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(C0748w c0748w, C0748w c0748w2) {
                if (c0748w == c0748w2) {
                    return 0;
                }
                C0755c c0755c = (C0755c) C0750y.this.f1916h.get(c0748w);
                C0755c c0755c2 = (C0755c) C0750y.this.f1916h.get(c0748w2);
                if (c0755c == null) {
                    return 1;
                }
                if (c0755c2 == null) {
                    return -1;
                }
                long j = c0755c.f1937a - c0755c2.f1937a;
                return j == C0750y.f1909u ? 0 : j < C0750y.f1909u ? -1 : 1;
            }
        };
        this.f1920l = file.getAbsolutePath();
        this.f1918j = str;
        this.f1919k = AbstractC0746v.m19199a(str);
        this.f1922n = z;
        this.f1921m = new RandomAccessFile(file, "r");
        try {
            m19148b(m19144e());
        } catch (Throwable th) {
            try {
                this.f1923o = true;
                this.f1921m.close();
            } catch (IOException e) {
            }
            throw th;
        }
    }

    public C0750y(String str) {
        this(new File(str), (String) null);
    }

    public C0750y(String str, String str2) {
        this(new File(str), str2, true);
    }

    /* renamed from: a */
    private void m19158a(int i) {
        int i2 = 0;
        while (i2 < i) {
            int skipBytes = this.f1921m.skipBytes(i - i2);
            if (skipBytes <= 0) {
                throw new EOFException();
            }
            i2 += skipBytes;
        }
    }

    /* renamed from: a */
    private void m19155a(C0748w c0748w, C0755c c0755c, int i) {
        boolean z = true;
        C0740p c0740p = (C0740p) c0748w.m19179b(C0740p.f1829a);
        if (c0740p != null) {
            boolean z2 = c0748w.getSize() == 4294967295L;
            boolean z3 = c0748w.getCompressedSize() == 4294967295L;
            boolean z4 = c0755c.f1937a == 4294967295L;
            if (i != 65535) {
                z = false;
            }
            c0740p.m19221a(z2, z3, z4, z);
            if (z2) {
                c0748w.setSize(c0740p.m19219b().m19206b());
            } else if (z3) {
                c0740p.m19223a(new C0744t(c0748w.getSize()));
            }
            if (z3) {
                c0748w.setCompressedSize(c0740p.m19215g().m19206b());
            } else if (z2) {
                c0740p.m19218b(new C0744t(c0748w.getCompressedSize()));
            }
            if (!z4) {
                return;
            }
            c0755c.f1937a = c0740p.m19214h().m19206b();
        }
    }

    /* renamed from: a */
    public static void m19154a(C0750y c0750y) {
        if (c0750y != null) {
            try {
                c0750y.m19151b();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    private void m19152a(Map<C0748w, C0754b> map) {
        this.f1921m.readFully(this.f1926r);
        C0748w c0748w = new C0748w();
        c0748w.m19176c((C0721ab.m19278a(this.f1926r, 0) >> 8) & 15);
        C0728f m19242a = C0728f.m19242a(this.f1926r, 4);
        boolean m19244a = m19242a.m19244a();
        AbstractC0745u abstractC0745u = m19244a ? AbstractC0746v.f1878b : this.f1919k;
        c0748w.m19190a(m19242a);
        c0748w.setMethod(C0721ab.m19278a(this.f1926r, 6));
        c0748w.setTime(AbstractC0722ac.m19268b(C0756z.m19127a(this.f1926r, 8)));
        c0748w.setCrc(C0756z.m19127a(this.f1926r, 12));
        c0748w.setCompressedSize(C0756z.m19127a(this.f1926r, 16));
        c0748w.setSize(C0756z.m19127a(this.f1926r, 20));
        int m19278a = C0721ab.m19278a(this.f1926r, 24);
        int m19278a2 = C0721ab.m19278a(this.f1926r, 26);
        int m19278a3 = C0721ab.m19278a(this.f1926r, 28);
        int m19278a4 = C0721ab.m19278a(this.f1926r, 30);
        c0748w.m19193a(C0721ab.m19278a(this.f1926r, 32));
        c0748w.m19192a(C0756z.m19127a(this.f1926r, 34));
        byte[] bArr = new byte[m19278a];
        this.f1921m.readFully(bArr);
        c0748w.m19187a(abstractC0745u.mo19201a(bArr), bArr);
        C0755c c0755c = new C0755c(null);
        c0755c.f1937a = C0756z.m19127a(this.f1926r, 38);
        this.f1916h.put(c0748w, c0755c);
        this.f1917i.put(c0748w.getName(), c0748w);
        byte[] bArr2 = new byte[m19278a2];
        this.f1921m.readFully(bArr2);
        c0748w.m19185a(bArr2);
        m19155a(c0748w, c0755c, m19278a4);
        byte[] bArr3 = new byte[m19278a3];
        this.f1921m.readFully(bArr3);
        c0748w.setComment(abstractC0745u.mo19201a(bArr3));
        if (m19244a || !this.f1922n) {
            return;
        }
        map.put(c0748w, new C0754b(bArr, bArr3, null));
    }

    /* renamed from: a */
    private boolean m19157a(long j, long j2, byte[] bArr) {
        boolean z = false;
        long length = this.f1921m.length() - j;
        long max = Math.max((long) f1909u, this.f1921m.length() - j2);
        if (length >= f1909u) {
            while (true) {
                if (length >= max) {
                    this.f1921m.seek(length);
                    int read = this.f1921m.read();
                    if (read != -1) {
                        if (read == bArr[0] && this.f1921m.read() == bArr[1] && this.f1921m.read() == bArr[2] && this.f1921m.read() == bArr[3]) {
                            z = true;
                            break;
                        }
                        length--;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            this.f1921m.seek(length);
        }
        return z;
    }

    /* renamed from: b */
    private void m19148b(Map<C0748w, C0754b> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f1916h);
        this.f1916h.clear();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            C0748w c0748w = (C0748w) entry.getKey();
            C0755c c0755c = (C0755c) entry.getValue();
            long j = c0755c.f1937a;
            this.f1921m.seek(j + f1900B);
            this.f1921m.readFully(this.f1927s);
            int m19279a = C0721ab.m19279a(this.f1927s);
            this.f1921m.readFully(this.f1927s);
            int m19279a2 = C0721ab.m19279a(this.f1927s);
            int i = m19279a;
            while (i > 0) {
                int skipBytes = this.f1921m.skipBytes(i);
                if (skipBytes <= 0) {
                    throw new IOException("failed to skip file name in local file header");
                }
                i -= skipBytes;
            }
            byte[] bArr = new byte[m19279a2];
            this.f1921m.readFully(bArr);
            c0748w.setExtra(bArr);
            c0755c.f1938b = m19279a + j + f1900B + 2 + 2 + m19279a2;
            if (map.containsKey(c0748w)) {
                String name = c0748w.getName();
                C0754b c0754b = map.get(c0748w);
                AbstractC0722ac.m19272a(c0748w, c0754b.f1935a, c0754b.f1936b);
                if (!name.equals(c0748w.getName())) {
                    this.f1917i.remove(name);
                    this.f1917i.put(c0748w.getName(), c0748w);
                }
            }
            this.f1916h.put(c0748w, c0755c);
        }
    }

    /* renamed from: e */
    private Map<C0748w, C0754b> m19144e() {
        HashMap hashMap = new HashMap();
        m19143f();
        this.f1921m.readFully(this.f1925q);
        long m19128a = C0756z.m19128a(this.f1925q);
        if (m19128a == f1909u || !m19139j()) {
            while (m19128a == f1909u) {
                m19152a(hashMap);
                this.f1921m.readFully(this.f1925q);
                m19128a = C0756z.m19128a(this.f1925q);
            }
            return hashMap;
        }
        throw new IOException("central directory is empty, can't expand corrupt archive.");
    }

    /* renamed from: f */
    private void m19143f() {
        boolean z = false;
        m19140i();
        boolean z2 = this.f1921m.getFilePointer() > 20;
        if (z2) {
            this.f1921m.seek(this.f1921m.getFilePointer() - 20);
            this.f1921m.readFully(this.f1925q);
            z = Arrays.equals(C0718aa.f1733m, this.f1925q);
        }
        if (z) {
            m19142g();
            return;
        }
        if (z2) {
            m19158a(16);
        }
        m19141h();
    }

    /* renamed from: g */
    private void m19142g() {
        m19158a(4);
        this.f1921m.readFully(this.f1924p);
        this.f1921m.seek(C0744t.m19208a(this.f1924p));
        this.f1921m.readFully(this.f1925q);
        if (!Arrays.equals(this.f1925q, C0718aa.f1732l)) {
            throw new ZipException("archive's ZIP64 end of central directory locator is corrupt.");
        }
        m19158a(44);
        this.f1921m.readFully(this.f1924p);
        this.f1921m.seek(C0744t.m19208a(this.f1924p));
    }

    /* renamed from: h */
    private void m19141h() {
        m19158a(16);
        this.f1921m.readFully(this.f1925q);
        this.f1921m.seek(C0756z.m19128a(this.f1925q));
    }

    /* renamed from: i */
    private void m19140i() {
        if (!m19157a(22L, 65557L, C0718aa.f1731k)) {
            throw new ZipException("archive is not a ZIP archive");
        }
    }

    /* renamed from: j */
    private boolean m19139j() {
        this.f1921m.seek(f1909u);
        this.f1921m.readFully(this.f1925q);
        return Arrays.equals(this.f1925q, C0718aa.f1728h);
    }

    /* renamed from: a */
    public C0748w m19153a(String str) {
        return this.f1917i.get(str);
    }

    /* renamed from: a */
    public String m19159a() {
        return this.f1918j;
    }

    /* renamed from: a */
    public boolean m19156a(C0748w c0748w) {
        return AbstractC0722ac.m19273a(c0748w);
    }

    /* renamed from: b */
    public InputStream m19150b(C0748w c0748w) {
        C0755c c0755c = this.f1916h.get(c0748w);
        if (c0755c == null) {
            return null;
        }
        AbstractC0722ac.m19267b(c0748w);
        C0753a c0753a = new C0753a(c0755c.f1938b, c0748w.getCompressedSize());
        switch (c0748w.getMethod()) {
            case 0:
                return c0753a;
            case 8:
                c0753a.m19137a();
                final Inflater inflater = new Inflater(true);
                return new InflaterInputStream(c0753a, inflater) { // from class: com.a.a.y.2
                    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                        super.close();
                        inflater.end();
                    }
                };
            default:
                throw new ZipException("Found unsupported compression method " + c0748w.getMethod());
        }
    }

    /* renamed from: b */
    public void m19151b() {
        this.f1923o = true;
        this.f1921m.close();
    }

    /* renamed from: c */
    public Enumeration<C0748w> m19147c() {
        return Collections.enumeration(this.f1916h.keySet());
    }

    /* renamed from: d */
    public Enumeration<C0748w> m19145d() {
        C0748w[] c0748wArr = (C0748w[]) this.f1916h.keySet().toArray(new C0748w[0]);
        Arrays.sort(c0748wArr, this.f1915C);
        return Collections.enumeration(Arrays.asList(c0748wArr));
    }

    protected void finalize() {
        try {
            if (!this.f1923o) {
                System.err.println("Cleaning up unclosed ZipFile for archive " + this.f1920l);
                m19151b();
            }
        } finally {
            super.finalize();
        }
    }
}
