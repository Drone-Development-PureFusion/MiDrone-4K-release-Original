package com.p118d.p119a.p120a.p121a.p122a;

import android.graphics.Bitmap;
import com.p118d.p119a.p120a.p121a.AbstractC1848a;
import com.p118d.p119a.p120a.p121a.p124b.AbstractC1863a;
import com.p118d.p119a.p127b.C1877a;
import com.p118d.p119a.p136c.C1947c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* renamed from: com.d.a.a.a.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1849a implements AbstractC1848a {

    /* renamed from: a */
    public static final int f6528a = 32768;

    /* renamed from: b */
    public static final Bitmap.CompressFormat f6529b = Bitmap.CompressFormat.PNG;

    /* renamed from: c */
    public static final int f6530c = 100;

    /* renamed from: j */
    private static final String f6531j = " argument must be not null";

    /* renamed from: k */
    private static final String f6532k = ".tmp";

    /* renamed from: d */
    protected final File f6533d;

    /* renamed from: e */
    protected final File f6534e;

    /* renamed from: f */
    protected final AbstractC1863a f6535f;

    /* renamed from: g */
    protected int f6536g;

    /* renamed from: h */
    protected Bitmap.CompressFormat f6537h;

    /* renamed from: i */
    protected int f6538i;

    public AbstractC1849a(File file) {
        this(file, null);
    }

    public AbstractC1849a(File file, File file2) {
        this(file, file2, C1877a.m14194b());
    }

    public AbstractC1849a(File file, File file2, AbstractC1863a abstractC1863a) {
        this.f6536g = 32768;
        this.f6537h = f6529b;
        this.f6538i = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (abstractC1863a == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        this.f6533d = file;
        this.f6534e = file2;
        this.f6535f = abstractC1863a;
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: a */
    public File mo14234a() {
        return this.f6533d;
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: a */
    public File mo14221a(String str) {
        return m14304c(str);
    }

    /* renamed from: a */
    public void m14307a(int i) {
        this.f6536g = i;
    }

    /* renamed from: a */
    public void m14306a(Bitmap.CompressFormat compressFormat) {
        this.f6537h = compressFormat;
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: a */
    public boolean mo14220a(String str, Bitmap bitmap) {
        File m14304c = m14304c(str);
        File file = new File(m14304c.getAbsolutePath() + f6532k);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f6536g);
        try {
            boolean compress = bitmap.compress(this.f6537h, this.f6538i, bufferedOutputStream);
            C1947c.m13861a(bufferedOutputStream);
            if (compress && !file.renameTo(m14304c)) {
                compress = false;
            }
            if (!compress) {
                file.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th) {
            C1947c.m13861a(bufferedOutputStream);
            file.delete();
            throw th;
        }
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: a */
    public boolean mo14219a(String str, InputStream inputStream, C1947c.AbstractC1948a abstractC1948a) {
        boolean z;
        BufferedOutputStream bufferedOutputStream;
        File m14304c = m14304c(str);
        File file = new File(m14304c.getAbsolutePath() + f6532k);
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f6536g);
            z = C1947c.m13858a(inputStream, bufferedOutputStream, abstractC1948a, this.f6536g);
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        try {
            C1947c.m13861a(bufferedOutputStream);
            if (z && !file.renameTo(m14304c)) {
                z = false;
            }
            if (!z) {
                file.delete();
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            if (z && !file.renameTo(m14304c)) {
                z = false;
            }
            if (!z) {
                file.delete();
            }
            throw th;
        }
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: b */
    public void mo14230b() {
    }

    /* renamed from: b */
    public void m14305b(int i) {
        this.f6538i = i;
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: b */
    public boolean mo14218b(String str) {
        return m14304c(str).delete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public File m14304c(String str) {
        String mo14215a = this.f6535f.mo14215a(str);
        File file = this.f6533d;
        if (!this.f6533d.exists() && !this.f6533d.mkdirs() && this.f6534e != null && (this.f6534e.exists() || this.f6534e.mkdirs())) {
            file = this.f6534e;
        }
        return new File(file, mo14215a);
    }

    @Override // com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: c */
    public void mo14217c() {
        File[] listFiles = this.f6533d.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }
}
