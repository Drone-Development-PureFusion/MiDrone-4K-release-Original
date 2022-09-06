package com.p118d.p119a.p120a.p121a.p122a.p123a;

import android.graphics.Bitmap;
import com.p118d.p119a.p120a.p121a.AbstractC1848a;
import com.p118d.p119a.p120a.p121a.p122a.p123a.C1850a;
import com.p118d.p119a.p120a.p121a.p124b.AbstractC1863a;
import com.p118d.p119a.p136c.C1947c;
import com.p118d.p119a.p136c.C1949d;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* renamed from: com.d.a.a.a.a.a.b */
/* loaded from: classes.dex */
public class C1857b implements AbstractC1848a {

    /* renamed from: a */
    public static final int f6586a = 32768;

    /* renamed from: b */
    public static final Bitmap.CompressFormat f6587b = Bitmap.CompressFormat.PNG;

    /* renamed from: c */
    public static final int f6588c = 100;

    /* renamed from: i */
    private static final String f6589i = " argument must be not null";

    /* renamed from: j */
    private static final String f6590j = " argument must be positive number";

    /* renamed from: d */
    protected C1850a f6591d;

    /* renamed from: e */
    protected final AbstractC1863a f6592e;

    /* renamed from: f */
    protected int f6593f;

    /* renamed from: g */
    protected Bitmap.CompressFormat f6594g;

    /* renamed from: h */
    protected int f6595h;

    /* renamed from: k */
    private File f6596k;

    public C1857b(File file, AbstractC1863a abstractC1863a, long j) {
        this(file, null, abstractC1863a, j, 0);
    }

    public C1857b(File file, File file2, AbstractC1863a abstractC1863a, long j, int i) {
        this.f6593f = 32768;
        this.f6594g = f6587b;
        this.f6595h = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (abstractC1863a == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        long j2 = j == 0 ? Long.MAX_VALUE : j;
        int i2 = i == 0 ? Integer.MAX_VALUE : i;
        this.f6596k = file2;
        this.f6592e = abstractC1863a;
        m14231a(file, file2, j2, i2);
    }

    /* renamed from: a */
    private void m14231a(File file, File file2, long j, int i) {
        try {
            this.f6591d = C1850a.m14295a(file, 1, 1, j, i);
        } catch (IOException e) {
            C1949d.m13853a(e);
            if (file2 != null) {
                m14231a(file2, null, j, i);
            }
            if (this.f6591d != null) {
                return;
            }
            throw e;
        }
    }

    /* renamed from: c */
    private String m14228c(String str) {
        return this.f6592e.mo14215a(str);
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: a */
    public File mo14234a() {
        return this.f6591d.m14303a();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0029  */
    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File mo14221a(String str) {
        C1850a.C1856c c1856c;
        Throwable th;
        File file = null;
        try {
            c1856c = this.f6591d.m14292a(m14228c(str));
            if (c1856c != null) {
                try {
                    try {
                        file = c1856c.m14238a(0);
                    } catch (IOException e) {
                        e = e;
                        C1949d.m13853a(e);
                        if (c1856c != null) {
                            c1856c.close();
                        }
                        return file;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (c1856c != null) {
                        c1856c.close();
                    }
                    throw th;
                }
            }
            if (c1856c != null) {
                c1856c.close();
            }
        } catch (IOException e2) {
            e = e2;
            c1856c = null;
        } catch (Throwable th3) {
            c1856c = null;
            th = th3;
            if (c1856c != null) {
            }
            throw th;
        }
        return file;
    }

    /* renamed from: a */
    public void m14233a(int i) {
        this.f6593f = i;
    }

    /* renamed from: a */
    public void m14232a(Bitmap.CompressFormat compressFormat) {
        this.f6594g = compressFormat;
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: a */
    public boolean mo14220a(String str, Bitmap bitmap) {
        boolean z = false;
        C1850a.C1853a m14287b = this.f6591d.m14287b(m14228c(str));
        if (m14287b != null) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(m14287b.m14254c(0), this.f6593f);
            try {
                z = bitmap.compress(this.f6594g, this.f6595h, bufferedOutputStream);
                if (z) {
                    m14287b.m14263a();
                } else {
                    m14287b.m14258b();
                }
            } finally {
                C1947c.m13861a(bufferedOutputStream);
            }
        }
        return z;
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: a */
    public boolean mo14219a(String str, InputStream inputStream, C1947c.AbstractC1948a abstractC1948a) {
        boolean z = false;
        C1850a.C1853a m14287b = this.f6591d.m14287b(m14228c(str));
        if (m14287b != null) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(m14287b.m14254c(0), this.f6593f);
            try {
                z = C1947c.m13858a(inputStream, bufferedOutputStream, abstractC1948a, this.f6593f);
                C1947c.m13861a(bufferedOutputStream);
                if (z) {
                    m14287b.m14263a();
                } else {
                    m14287b.m14258b();
                }
            } catch (Throwable th) {
                C1947c.m13861a(bufferedOutputStream);
                m14287b.m14258b();
                throw th;
            }
        }
        return z;
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: b */
    public void mo14230b() {
        try {
            this.f6591d.close();
        } catch (IOException e) {
            C1949d.m13853a(e);
        }
        this.f6591d = null;
    }

    /* renamed from: b */
    public void m14229b(int i) {
        this.f6595h = i;
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: b */
    public boolean mo14218b(String str) {
        try {
            return this.f6591d.m14284c(m14228c(str));
        } catch (IOException e) {
            C1949d.m13853a(e);
            return false;
        }
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: c */
    public void mo14217c() {
        try {
            this.f6591d.m14273h();
        } catch (IOException e) {
            C1949d.m13853a(e);
        }
        try {
            m14231a(this.f6591d.m14303a(), this.f6596k, this.f6591d.m14290b(), this.f6591d.m14286c());
        } catch (IOException e2) {
            C1949d.m13853a(e2);
        }
    }
}
