package com.p078a.p079a;

import com.p078a.p079a.C0725d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
/* renamed from: com.a.a.w */
/* loaded from: classes.dex */
public class C0748w extends ZipEntry implements Cloneable {

    /* renamed from: a */
    public static final int f1884a = 3;

    /* renamed from: b */
    public static final int f1885b = 0;

    /* renamed from: c */
    private static final int f1886c = 65535;

    /* renamed from: d */
    private static final int f1887d = 16;

    /* renamed from: e */
    private static final byte[] f1888e = new byte[0];

    /* renamed from: f */
    private int f1889f;

    /* renamed from: g */
    private long f1890g;

    /* renamed from: h */
    private int f1891h;

    /* renamed from: i */
    private int f1892i;

    /* renamed from: j */
    private long f1893j;

    /* renamed from: k */
    private LinkedHashMap<C0721ab, AbstractC0749x> f1894k;

    /* renamed from: l */
    private C0736m f1895l;

    /* renamed from: m */
    private String f1896m;

    /* renamed from: n */
    private byte[] f1897n;

    /* renamed from: o */
    private C0728f f1898o;

    /* JADX INFO: Access modifiers changed from: protected */
    public C0748w() {
        this("");
    }

    public C0748w(C0748w c0748w) {
        this((ZipEntry) c0748w);
        m19193a(c0748w.m19194a());
        m19192a(c0748w.m19182b());
        m19184a(c0748w.m19186a(true));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0748w(File file, String str) {
        this(str);
        if (file.isDirectory() && !str.endsWith("/")) {
            str = String.valueOf(str) + "/";
        }
        if (file.isFile()) {
            setSize(file.length());
        }
        setTime(file.lastModified());
    }

    public C0748w(String str) {
        super(str);
        this.f1889f = -1;
        this.f1890g = -1L;
        this.f1891h = 0;
        this.f1892i = 0;
        this.f1893j = 0L;
        this.f1894k = null;
        this.f1895l = null;
        this.f1896m = null;
        this.f1897n = null;
        this.f1898o = new C0728f();
        m19188a(str);
    }

    public C0748w(ZipEntry zipEntry) {
        super(zipEntry);
        this.f1889f = -1;
        this.f1890g = -1L;
        this.f1891h = 0;
        this.f1892i = 0;
        this.f1893j = 0L;
        this.f1894k = null;
        this.f1895l = null;
        this.f1896m = null;
        this.f1897n = null;
        this.f1898o = new C0728f();
        m19188a(zipEntry.getName());
        byte[] extra = zipEntry.getExtra();
        if (extra != null) {
            m19184a(C0725d.m19248a(extra, true, C0725d.C0726a.f1788f));
        } else {
            m19171h();
        }
        setMethod(zipEntry.getMethod());
        this.f1890g = zipEntry.getSize();
    }

    /* renamed from: a */
    private void m19183a(AbstractC0749x[] abstractC0749xArr, boolean z) {
        if (this.f1894k == null) {
            m19184a(abstractC0749xArr);
            return;
        }
        for (AbstractC0749x abstractC0749x : abstractC0749xArr) {
            AbstractC0749x m19179b = abstractC0749x instanceof C0736m ? this.f1895l : m19179b(abstractC0749x.mo19165a());
            if (m19179b == null) {
                m19189a(abstractC0749x);
            } else if (z || !(m19179b instanceof AbstractC0724c)) {
                byte[] mo19161e = abstractC0749x.mo19161e();
                m19179b.mo19164a(mo19161e, 0, mo19161e.length);
            } else {
                byte[] mo19163c = abstractC0749x.mo19163c();
                ((AbstractC0724c) m19179b).mo19217b(mo19163c, 0, mo19163c.length);
            }
        }
        m19171h();
    }

    /* renamed from: a */
    public int m19194a() {
        return this.f1891h;
    }

    /* renamed from: a */
    public void m19193a(int i) {
        this.f1891h = i;
    }

    /* renamed from: a */
    public void m19192a(long j) {
        this.f1893j = j;
    }

    /* renamed from: a */
    public void m19191a(C0721ab c0721ab) {
        if (this.f1894k == null) {
            throw new NoSuchElementException();
        }
        if (this.f1894k.remove(c0721ab) == null) {
            throw new NoSuchElementException();
        }
        m19171h();
    }

    /* renamed from: a */
    public void m19190a(C0728f c0728f) {
        this.f1898o = c0728f;
    }

    /* renamed from: a */
    public void m19189a(AbstractC0749x abstractC0749x) {
        if (abstractC0749x instanceof C0736m) {
            this.f1895l = (C0736m) abstractC0749x;
        } else {
            if (this.f1894k == null) {
                this.f1894k = new LinkedHashMap<>();
            }
            this.f1894k.put(abstractC0749x.mo19165a(), abstractC0749x);
        }
        m19171h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m19188a(String str) {
        if (str != null && m19175d() == 0 && str.indexOf("/") == -1) {
            str = str.replace('\\', '/');
        }
        this.f1896m = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m19187a(String str, byte[] bArr) {
        m19188a(str);
        this.f1897n = bArr;
    }

    /* renamed from: a */
    public void m19185a(byte[] bArr) {
        try {
            m19183a(C0725d.m19248a(bArr, false, C0725d.C0726a.f1788f), false);
        } catch (ZipException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: a */
    public void m19184a(AbstractC0749x[] abstractC0749xArr) {
        this.f1894k = new LinkedHashMap<>();
        for (AbstractC0749x abstractC0749x : abstractC0749xArr) {
            if (abstractC0749x instanceof C0736m) {
                this.f1895l = (C0736m) abstractC0749x;
            } else {
                this.f1894k.put(abstractC0749x.mo19165a(), abstractC0749x);
            }
        }
        m19171h();
    }

    /* renamed from: a */
    public AbstractC0749x[] m19186a(boolean z) {
        if (this.f1894k == null) {
            return (!z || this.f1895l == null) ? new AbstractC0749x[0] : new AbstractC0749x[]{this.f1895l};
        }
        ArrayList arrayList = new ArrayList(this.f1894k.values());
        if (z && this.f1895l != null) {
            arrayList.add(this.f1895l);
        }
        return (AbstractC0749x[]) arrayList.toArray(new AbstractC0749x[0]);
    }

    /* renamed from: b */
    public long m19182b() {
        return this.f1893j;
    }

    /* renamed from: b */
    public AbstractC0749x m19179b(C0721ab c0721ab) {
        if (this.f1894k != null) {
            return this.f1894k.get(c0721ab);
        }
        return null;
    }

    /* renamed from: b */
    public void m19181b(int i) {
        int i2 = 0;
        int i3 = ((i & 128) == 0 ? 1 : 0) | (i << 16);
        if (isDirectory()) {
            i2 = 16;
        }
        m19192a(i3 | i2);
        this.f1892i = 3;
    }

    /* renamed from: b */
    public void m19180b(long j) {
        setCompressedSize(j);
    }

    /* renamed from: b */
    public void m19178b(AbstractC0749x abstractC0749x) {
        if (abstractC0749x instanceof C0736m) {
            this.f1895l = (C0736m) abstractC0749x;
        } else {
            LinkedHashMap<C0721ab, AbstractC0749x> linkedHashMap = this.f1894k;
            this.f1894k = new LinkedHashMap<>();
            this.f1894k.put(abstractC0749x.mo19165a(), abstractC0749x);
            if (linkedHashMap != null) {
                linkedHashMap.remove(abstractC0749x.mo19165a());
                this.f1894k.putAll(linkedHashMap);
            }
        }
        m19171h();
    }

    /* renamed from: c */
    public int m19177c() {
        if (this.f1892i != 3) {
            return 0;
        }
        return (int) ((m19182b() >> 16) & 65535);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m19176c(int i) {
        this.f1892i = i;
    }

    @Override // java.util.zip.ZipEntry
    public Object clone() {
        C0748w c0748w = (C0748w) super.clone();
        c0748w.m19193a(m19194a());
        c0748w.m19192a(m19182b());
        c0748w.m19184a(m19186a(true));
        return c0748w;
    }

    /* renamed from: d */
    public int m19175d() {
        return this.f1892i;
    }

    /* renamed from: e */
    public AbstractC0749x[] m19174e() {
        return m19186a(false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0748w c0748w = (C0748w) obj;
        String name = getName();
        String name2 = c0748w.getName();
        if (name == null) {
            if (name2 != null) {
                return false;
            }
        } else if (!name.equals(name2)) {
            return false;
        }
        String comment = getComment();
        String comment2 = c0748w.getComment();
        if (comment == null) {
            comment = "";
        }
        if (comment2 == null) {
            comment2 = "";
        }
        return getTime() == c0748w.getTime() && comment.equals(comment2) && m19194a() == c0748w.m19194a() && m19175d() == c0748w.m19175d() && m19182b() == c0748w.m19182b() && getMethod() == c0748w.getMethod() && getSize() == c0748w.getSize() && getCrc() == c0748w.getCrc() && getCompressedSize() == c0748w.getCompressedSize() && Arrays.equals(m19169j(), c0748w.m19169j()) && Arrays.equals(m19170i(), c0748w.m19170i()) && this.f1898o.equals(c0748w.f1898o);
    }

    /* renamed from: f */
    public void m19173f() {
        if (this.f1895l == null) {
            throw new NoSuchElementException();
        }
        this.f1895l = null;
        m19171h();
    }

    /* renamed from: g */
    public C0736m m19172g() {
        return this.f1895l;
    }

    @Override // java.util.zip.ZipEntry
    public int getMethod() {
        return this.f1889f;
    }

    @Override // java.util.zip.ZipEntry
    public String getName() {
        return this.f1896m == null ? super.getName() : this.f1896m;
    }

    @Override // java.util.zip.ZipEntry
    public long getSize() {
        return this.f1890g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void m19171h() {
        super.setExtra(C0725d.m19247a(m19186a(true)));
    }

    @Override // java.util.zip.ZipEntry
    public int hashCode() {
        return getName().hashCode();
    }

    /* renamed from: i */
    public byte[] m19170i() {
        byte[] extra = getExtra();
        return extra != null ? extra : f1888e;
    }

    @Override // java.util.zip.ZipEntry
    public boolean isDirectory() {
        return getName().endsWith("/");
    }

    /* renamed from: j */
    public byte[] m19169j() {
        return C0725d.m19246b(m19186a(true));
    }

    /* renamed from: k */
    public byte[] m19168k() {
        if (this.f1897n != null) {
            byte[] bArr = new byte[this.f1897n.length];
            System.arraycopy(this.f1897n, 0, bArr, 0, this.f1897n.length);
            return bArr;
        }
        return null;
    }

    /* renamed from: l */
    public C0728f m19167l() {
        return this.f1898o;
    }

    /* renamed from: m */
    public Date m19166m() {
        return new Date(getTime());
    }

    @Override // java.util.zip.ZipEntry
    public void setExtra(byte[] bArr) {
        try {
            m19183a(C0725d.m19248a(bArr, true, C0725d.C0726a.f1788f), true);
        } catch (ZipException e) {
            throw new RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + e.getMessage(), e);
        }
    }

    @Override // java.util.zip.ZipEntry
    public void setMethod(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("ZIP compression method can not be negative: " + i);
        }
        this.f1889f = i;
    }

    @Override // java.util.zip.ZipEntry
    public void setSize(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid entry size");
        }
        this.f1890g = j;
    }
}
