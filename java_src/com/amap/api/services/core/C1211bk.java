package com.amap.api.services.core;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.p248a.p249a.p261f.p264c.C5122l;
/* renamed from: com.amap.api.services.core.bk */
/* loaded from: classes.dex */
public final class C1211bk implements Closeable {

    /* renamed from: a */
    static final Pattern f4092a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: q */
    private static final OutputStream f4093q = new C1217bm();

    /* renamed from: c */
    private final File f4095c;

    /* renamed from: d */
    private final File f4096d;

    /* renamed from: e */
    private final File f4097e;

    /* renamed from: f */
    private final File f4098f;

    /* renamed from: g */
    private final int f4099g;

    /* renamed from: h */
    private long f4100h;

    /* renamed from: i */
    private final int f4101i;

    /* renamed from: k */
    private Writer f4103k;

    /* renamed from: m */
    private int f4105m;

    /* renamed from: n */
    private AbstractC1218bn f4106n;

    /* renamed from: j */
    private long f4102j = 0;

    /* renamed from: l */
    private final LinkedHashMap<String, C1215c> f4104l = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: o */
    private long f4107o = 0;

    /* renamed from: b */
    final ThreadPoolExecutor f4094b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: p */
    private final Callable<Void> f4108p = new CallableC1216bl(this);

    /* renamed from: com.amap.api.services.core.bk$a */
    /* loaded from: classes.dex */
    public final class C1212a {

        /* renamed from: b */
        private final C1215c f4110b;

        /* renamed from: c */
        private final boolean[] f4111c;

        /* renamed from: d */
        private boolean f4112d;

        /* renamed from: e */
        private boolean f4113e;

        /* renamed from: com.amap.api.services.core.bk$a$a */
        /* loaded from: classes.dex */
        private class C1213a extends FilterOutputStream {
            private C1213a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C1213a(C1212a c1212a, OutputStream outputStream, CallableC1216bl callableC1216bl) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C1212a.this.f4112d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C1212a.this.f4112d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    C1212a.this.f4112d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    C1212a.this.f4112d = true;
                }
            }
        }

        private C1212a(C1215c c1215c) {
            this.f4110b = c1215c;
            this.f4111c = c1215c.f4123d ? null : new boolean[C1211bk.this.f4101i];
        }

        /* synthetic */ C1212a(C1211bk c1211bk, C1215c c1215c, CallableC1216bl callableC1216bl) {
            this(c1215c);
        }

        /* renamed from: a */
        public OutputStream m17096a(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i < 0 || i >= C1211bk.this.f4101i) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + C1211bk.this.f4101i);
            }
            synchronized (C1211bk.this) {
                if (this.f4110b.f4124e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f4110b.f4123d) {
                    this.f4111c[i] = true;
                }
                File m17082b = this.f4110b.m17082b(i);
                try {
                    fileOutputStream = new FileOutputStream(m17082b);
                } catch (FileNotFoundException e) {
                    C1211bk.this.f4095c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(m17082b);
                    } catch (FileNotFoundException e2) {
                        outputStream = C1211bk.f4093q;
                    }
                }
                outputStream = new C1213a(this, fileOutputStream, null);
            }
            return outputStream;
        }

        /* renamed from: a */
        public void m17097a() {
            if (this.f4112d) {
                C1211bk.this.m17125a(this, false);
                C1211bk.this.m17110c(this.f4110b.f4121b);
            } else {
                C1211bk.this.m17125a(this, true);
            }
            this.f4113e = true;
        }

        /* renamed from: b */
        public void m17093b() {
            C1211bk.this.m17125a(this, false);
        }
    }

    /* renamed from: com.amap.api.services.core.bk$b */
    /* loaded from: classes.dex */
    public final class C1214b implements Closeable {

        /* renamed from: b */
        private final String f4116b;

        /* renamed from: c */
        private final long f4117c;

        /* renamed from: d */
        private final InputStream[] f4118d;

        /* renamed from: e */
        private final long[] f4119e;

        private C1214b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f4116b = str;
            this.f4117c = j;
            this.f4118d = inputStreamArr;
            this.f4119e = jArr;
        }

        /* synthetic */ C1214b(C1211bk c1211bk, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC1216bl callableC1216bl) {
            this(str, j, inputStreamArr, jArr);
        }

        /* renamed from: a */
        public InputStream m17091a(int i) {
            return this.f4118d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f4118d) {
                C1221bp.m17071a(inputStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.services.core.bk$c */
    /* loaded from: classes.dex */
    public final class C1215c {

        /* renamed from: b */
        private final String f4121b;

        /* renamed from: c */
        private final long[] f4122c;

        /* renamed from: d */
        private boolean f4123d;

        /* renamed from: e */
        private C1212a f4124e;

        /* renamed from: f */
        private long f4125f;

        private C1215c(String str) {
            this.f4121b = str;
            this.f4122c = new long[C1211bk.this.f4101i];
        }

        /* synthetic */ C1215c(C1211bk c1211bk, String str, CallableC1216bl callableC1216bl) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m17083a(String[] strArr) {
            if (strArr.length != C1211bk.this.f4101i) {
                throw m17080b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f4122c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw m17080b(strArr);
                }
            }
        }

        /* renamed from: b */
        private IOException m17080b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public File m17089a(int i) {
            return new File(C1211bk.this.f4095c, this.f4121b + "." + i);
        }

        /* renamed from: a */
        public String m17090a() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f4122c) {
                sb.append(C5122l.f21763c).append(j);
            }
            return sb.toString();
        }

        /* renamed from: b */
        public File m17082b(int i) {
            return new File(C1211bk.this.f4095c, this.f4121b + "." + i + ".tmp");
        }
    }

    private C1211bk(File file, int i, int i2, long j) {
        this.f4095c = file;
        this.f4099g = i;
        this.f4096d = new File(file, "journal");
        this.f4097e = new File(file, "journal.tmp");
        this.f4098f = new File(file, "journal.bkp");
        this.f4101i = i2;
        this.f4100h = j;
    }

    /* renamed from: a */
    private synchronized C1212a m17116a(String str, long j) {
        C1215c c1215c;
        C1212a c1212a;
        m17099i();
        m17104e(str);
        C1215c c1215c2 = this.f4104l.get(str);
        if (j == -1 || (c1215c2 != null && c1215c2.f4125f == j)) {
            if (c1215c2 == null) {
                C1215c c1215c3 = new C1215c(this, str, null);
                this.f4104l.put(str, c1215c3);
                c1215c = c1215c3;
            } else if (c1215c2.f4124e != null) {
                c1212a = null;
            } else {
                c1215c = c1215c2;
            }
            c1212a = new C1212a(this, c1215c, null);
            c1215c.f4124e = c1212a;
            this.f4103k.write("DIRTY " + str + '\n');
            this.f4103k.flush();
        } else {
            c1212a = null;
        }
        return c1212a;
    }

    /* renamed from: a */
    public static C1211bk m17119a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                m17118a(file2, file3, false);
            }
        }
        C1211bk c1211bk = new C1211bk(file, i, i2, j);
        if (c1211bk.f4096d.exists()) {
            try {
                c1211bk.m17106e();
                c1211bk.m17103f();
                c1211bk.f4103k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c1211bk.f4096d, true), C1221bp.f4133a));
                return c1211bk;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                c1211bk.m17112c();
            }
        }
        file.mkdirs();
        C1211bk c1211bk2 = new C1211bk(file, i, i2, j);
        c1211bk2.m17101g();
        return c1211bk2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m17125a(C1212a c1212a, boolean z) {
        synchronized (this) {
            C1215c c1215c = c1212a.f4110b;
            if (c1215c.f4124e != c1212a) {
                throw new IllegalStateException();
            }
            if (z && !c1215c.f4123d) {
                for (int i = 0; i < this.f4101i; i++) {
                    if (!c1212a.f4111c[i]) {
                        c1212a.m17093b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!c1215c.m17082b(i).exists()) {
                        c1212a.m17093b();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.f4101i; i2++) {
                File m17082b = c1215c.m17082b(i2);
                if (!z) {
                    m17120a(m17082b);
                } else if (m17082b.exists()) {
                    File m17089a = c1215c.m17089a(i2);
                    m17082b.renameTo(m17089a);
                    long j = c1215c.f4122c[i2];
                    long length = m17089a.length();
                    c1215c.f4122c[i2] = length;
                    this.f4102j = (this.f4102j - j) + length;
                }
            }
            this.f4105m++;
            c1215c.f4124e = null;
            if (c1215c.f4123d || z) {
                c1215c.f4123d = true;
                this.f4103k.write("CLEAN " + c1215c.f4121b + c1215c.m17090a() + '\n');
                if (z) {
                    long j2 = this.f4107o;
                    this.f4107o = 1 + j2;
                    c1215c.f4125f = j2;
                }
            } else {
                this.f4104l.remove(c1215c.f4121b);
                this.f4103k.write("REMOVE " + c1215c.f4121b + '\n');
            }
            this.f4103k.flush();
            if (this.f4102j > this.f4100h || m17100h()) {
                this.f4094b.submit(this.f4108p);
            }
        }
    }

    /* renamed from: a */
    private static void m17120a(File file) {
        if (!file.exists() || file.delete()) {
            return;
        }
        throw new IOException();
    }

    /* renamed from: a */
    private static void m17118a(File file, File file2, boolean z) {
        if (z) {
            m17120a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: d */
    private void m17107d(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring2 = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.f4104l.remove(substring2);
                return;
            }
            substring = substring2;
        } else {
            substring = str.substring(i, indexOf2);
        }
        C1215c c1215c = this.f4104l.get(substring);
        if (c1215c == null) {
            c1215c = new C1215c(this, substring, null);
            this.f4104l.put(substring, c1215c);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            c1215c.f4123d = true;
            c1215c.f4124e = null;
            c1215c.m17083a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c1215c.f4124e = new C1212a(this, c1215c, null);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: e */
    private void m17106e() {
        C1219bo c1219bo = new C1219bo(new FileInputStream(this.f4096d), C1221bp.f4133a);
        try {
            String m17074a = c1219bo.m17074a();
            String m17074a2 = c1219bo.m17074a();
            String m17074a3 = c1219bo.m17074a();
            String m17074a4 = c1219bo.m17074a();
            String m17074a5 = c1219bo.m17074a();
            if (!"libcore.io.DiskLruCache".equals(m17074a) || !"1".equals(m17074a2) || !Integer.toString(this.f4099g).equals(m17074a3) || !Integer.toString(this.f4101i).equals(m17074a4) || !"".equals(m17074a5)) {
                throw new IOException("unexpected journal header: [" + m17074a + ", " + m17074a2 + ", " + m17074a4 + ", " + m17074a5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m17107d(c1219bo.m17074a());
                    i++;
                } catch (EOFException e) {
                    this.f4105m = i - this.f4104l.size();
                    C1221bp.m17071a(c1219bo);
                    return;
                }
            }
        } catch (Throwable th) {
            C1221bp.m17071a(c1219bo);
            throw th;
        }
    }

    /* renamed from: e */
    private void m17104e(String str) {
        if (!f4092a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* renamed from: f */
    private void m17103f() {
        m17120a(this.f4097e);
        Iterator<C1215c> it2 = this.f4104l.values().iterator();
        while (it2.hasNext()) {
            C1215c next = it2.next();
            if (next.f4124e == null) {
                for (int i = 0; i < this.f4101i; i++) {
                    this.f4102j += next.f4122c[i];
                }
            } else {
                next.f4124e = null;
                for (int i2 = 0; i2 < this.f4101i; i2++) {
                    m17120a(next.m17089a(i2));
                    m17120a(next.m17082b(i2));
                }
                it2.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public synchronized void m17101g() {
        if (this.f4103k != null) {
            this.f4103k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4097e), C1221bp.f4133a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f4099g));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f4101i));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (C1215c c1215c : this.f4104l.values()) {
            if (c1215c.f4124e != null) {
                bufferedWriter.write("DIRTY " + c1215c.f4121b + '\n');
            } else {
                bufferedWriter.write("CLEAN " + c1215c.f4121b + c1215c.m17090a() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f4096d.exists()) {
            m17118a(this.f4096d, this.f4098f, true);
        }
        m17118a(this.f4097e, this.f4096d, false);
        this.f4098f.delete();
        this.f4103k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4096d, true), C1221bp.f4133a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m17100h() {
        return this.f4105m >= 2000 && this.f4105m >= this.f4104l.size();
    }

    /* renamed from: i */
    private void m17099i() {
        if (this.f4103k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m17098j() {
        while (this.f4102j > this.f4100h) {
            String key = this.f4104l.entrySet().iterator().next().getKey();
            m17110c(key);
            if (this.f4106n != null) {
                this.f4106n.mo17075a(key);
            }
        }
    }

    /* renamed from: a */
    public synchronized C1214b m17117a(String str) {
        C1214b c1214b = null;
        synchronized (this) {
            m17099i();
            m17104e(str);
            C1215c c1215c = this.f4104l.get(str);
            if (c1215c != null && c1215c.f4123d) {
                InputStream[] inputStreamArr = new InputStream[this.f4101i];
                for (int i = 0; i < this.f4101i; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(c1215c.m17089a(i));
                    } catch (FileNotFoundException e) {
                        for (int i2 = 0; i2 < this.f4101i && inputStreamArr[i2] != null; i2++) {
                            C1221bp.m17071a(inputStreamArr[i2]);
                        }
                    }
                }
                this.f4105m++;
                this.f4103k.append((CharSequence) ("READ " + str + '\n'));
                if (m17100h()) {
                    this.f4094b.submit(this.f4108p);
                }
                c1214b = new C1214b(this, str, c1215c.f4125f, inputStreamArr, c1215c.f4122c, null);
            }
        }
        return c1214b;
    }

    /* renamed from: a */
    public void m17121a(AbstractC1218bn abstractC1218bn) {
        this.f4106n = abstractC1218bn;
    }

    /* renamed from: a */
    public synchronized boolean m17126a() {
        return this.f4103k == null;
    }

    /* renamed from: b */
    public C1212a m17113b(String str) {
        return m17116a(str, -1L);
    }

    /* renamed from: b */
    public synchronized void m17115b() {
        m17099i();
        m17098j();
        this.f4103k.flush();
    }

    /* renamed from: c */
    public void m17112c() {
        close();
        C1221bp.m17070a(this.f4095c);
    }

    /* renamed from: c */
    public synchronized boolean m17110c(String str) {
        boolean z;
        synchronized (this) {
            m17099i();
            m17104e(str);
            C1215c c1215c = this.f4104l.get(str);
            if (c1215c == null || c1215c.f4124e != null) {
                z = false;
            } else {
                for (int i = 0; i < this.f4101i; i++) {
                    File m17089a = c1215c.m17089a(i);
                    if (m17089a.exists() && !m17089a.delete()) {
                        throw new IOException("failed to delete " + m17089a);
                    }
                    this.f4102j -= c1215c.f4122c[i];
                    c1215c.f4122c[i] = 0;
                }
                this.f4105m++;
                this.f4103k.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f4104l.remove(str);
                if (m17100h()) {
                    this.f4094b.submit(this.f4108p);
                }
                z = true;
            }
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f4103k != null) {
            Iterator it2 = new ArrayList(this.f4104l.values()).iterator();
            while (it2.hasNext()) {
                C1215c c1215c = (C1215c) it2.next();
                if (c1215c.f4124e != null) {
                    c1215c.f4124e.m17093b();
                }
            }
            m17098j();
            this.f4103k.close();
            this.f4103k = null;
        }
    }
}
