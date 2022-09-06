package com.amap.api.mapcore.util;

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
/* renamed from: com.amap.api.mapcore.util.gt */
/* loaded from: classes.dex */
public final class C1046gt implements Closeable {

    /* renamed from: a */
    static final Pattern f3266a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: q */
    private static final OutputStream f3267q = new OutputStream() { // from class: com.amap.api.mapcore.util.gt.2
        @Override // java.io.OutputStream
        public void write(int i) {
        }
    };

    /* renamed from: c */
    private final File f3269c;

    /* renamed from: d */
    private final File f3270d;

    /* renamed from: e */
    private final File f3271e;

    /* renamed from: f */
    private final File f3272f;

    /* renamed from: g */
    private final int f3273g;

    /* renamed from: h */
    private long f3274h;

    /* renamed from: i */
    private final int f3275i;

    /* renamed from: k */
    private Writer f3277k;

    /* renamed from: m */
    private int f3279m;

    /* renamed from: n */
    private AbstractC1053gu f3280n;

    /* renamed from: j */
    private long f3276j = 0;

    /* renamed from: l */
    private final LinkedHashMap<String, C1052c> f3278l = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: o */
    private long f3281o = 0;

    /* renamed from: b */
    final ThreadPoolExecutor f3268b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: p */
    private final Callable<Void> f3282p = new Callable<Void>() { // from class: com.amap.api.mapcore.util.gt.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            synchronized (C1046gt.this) {
                if (C1046gt.this.f3277k != null) {
                    C1046gt.this.m17800j();
                    if (C1046gt.this.m17802h()) {
                        C1046gt.this.m17803g();
                        C1046gt.this.f3279m = 0;
                    }
                }
            }
            return null;
        }
    };

    /* renamed from: com.amap.api.mapcore.util.gt$a */
    /* loaded from: classes.dex */
    public final class C1049a {

        /* renamed from: b */
        private final C1052c f3285b;

        /* renamed from: c */
        private final boolean[] f3286c;

        /* renamed from: d */
        private boolean f3287d;

        /* renamed from: e */
        private boolean f3288e;

        /* renamed from: com.amap.api.mapcore.util.gt$a$a */
        /* loaded from: classes.dex */
        private class C1050a extends FilterOutputStream {
            private C1050a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C1049a.this.f3287d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C1049a.this.f3287d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    C1049a.this.f3287d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    C1049a.this.f3287d = true;
                }
            }
        }

        private C1049a(C1052c c1052c) {
            this.f3285b = c1052c;
            this.f3286c = c1052c.f3298d ? null : new boolean[C1046gt.this.f3275i];
        }

        /* renamed from: a */
        public OutputStream m17797a(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i < 0 || i >= C1046gt.this.f3275i) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + C1046gt.this.f3275i);
            }
            synchronized (C1046gt.this) {
                if (this.f3285b.f3299e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f3285b.f3298d) {
                    this.f3286c[i] = true;
                }
                File m17783b = this.f3285b.m17783b(i);
                try {
                    fileOutputStream = new FileOutputStream(m17783b);
                } catch (FileNotFoundException e) {
                    C1046gt.this.f3269c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(m17783b);
                    } catch (FileNotFoundException e2) {
                        outputStream = C1046gt.f3267q;
                    }
                }
                outputStream = new C1050a(fileOutputStream);
            }
            return outputStream;
        }

        /* renamed from: a */
        public void m17798a() {
            if (this.f3287d) {
                C1046gt.this.m17827a(this, false);
                C1046gt.this.m17812c(this.f3285b.f3296b);
            } else {
                C1046gt.this.m17827a(this, true);
            }
            this.f3288e = true;
        }

        /* renamed from: b */
        public void m17794b() {
            C1046gt.this.m17827a(this, false);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.gt$b */
    /* loaded from: classes.dex */
    public final class C1051b implements Closeable {

        /* renamed from: b */
        private final String f3291b;

        /* renamed from: c */
        private final long f3292c;

        /* renamed from: d */
        private final InputStream[] f3293d;

        /* renamed from: e */
        private final long[] f3294e;

        private C1051b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f3291b = str;
            this.f3292c = j;
            this.f3293d = inputStreamArr;
            this.f3294e = jArr;
        }

        /* renamed from: a */
        public InputStream m17792a(int i) {
            return this.f3293d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f3293d) {
                C1056gw.m17773a(inputStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.mapcore.util.gt$c */
    /* loaded from: classes.dex */
    public final class C1052c {

        /* renamed from: b */
        private final String f3296b;

        /* renamed from: c */
        private final long[] f3297c;

        /* renamed from: d */
        private boolean f3298d;

        /* renamed from: e */
        private C1049a f3299e;

        /* renamed from: f */
        private long f3300f;

        private C1052c(String str) {
            this.f3296b = str;
            this.f3297c = new long[C1046gt.this.f3275i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m17784a(String[] strArr) {
            if (strArr.length != C1046gt.this.f3275i) {
                throw m17781b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f3297c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw m17781b(strArr);
                }
            }
        }

        /* renamed from: b */
        private IOException m17781b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public File m17790a(int i) {
            return new File(C1046gt.this.f3269c, this.f3296b + "." + i);
        }

        /* renamed from: a */
        public String m17791a() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f3297c) {
                sb.append(C5122l.f21763c).append(j);
            }
            return sb.toString();
        }

        /* renamed from: b */
        public File m17783b(int i) {
            return new File(C1046gt.this.f3269c, this.f3296b + "." + i + ".tmp");
        }
    }

    private C1046gt(File file, int i, int i2, long j) {
        this.f3269c = file;
        this.f3273g = i;
        this.f3270d = new File(file, "journal");
        this.f3271e = new File(file, "journal.tmp");
        this.f3272f = new File(file, "journal.bkp");
        this.f3275i = i2;
        this.f3274h = j;
    }

    /* renamed from: a */
    private synchronized C1049a m17818a(String str, long j) {
        C1052c c1052c;
        C1049a c1049a;
        m17801i();
        m17806e(str);
        C1052c c1052c2 = this.f3278l.get(str);
        if (j == -1 || (c1052c2 != null && c1052c2.f3300f == j)) {
            if (c1052c2 == null) {
                C1052c c1052c3 = new C1052c(str);
                this.f3278l.put(str, c1052c3);
                c1052c = c1052c3;
            } else if (c1052c2.f3299e != null) {
                c1049a = null;
            } else {
                c1052c = c1052c2;
            }
            c1049a = new C1049a(c1052c);
            c1052c.f3299e = c1049a;
            this.f3277k.write("DIRTY " + str + '\n');
            this.f3277k.flush();
        } else {
            c1049a = null;
        }
        return c1049a;
    }

    /* renamed from: a */
    public static C1046gt m17821a(File file, int i, int i2, long j) {
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
                m17820a(file2, file3, false);
            }
        }
        C1046gt c1046gt = new C1046gt(file, i, i2, j);
        if (c1046gt.f3270d.exists()) {
            try {
                c1046gt.m17808e();
                c1046gt.m17805f();
                c1046gt.f3277k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c1046gt.f3270d, true), C1056gw.f3307a));
                return c1046gt;
            } catch (Throwable th) {
                c1046gt.m17814c();
            }
        }
        file.mkdirs();
        C1046gt c1046gt2 = new C1046gt(file, i, i2, j);
        c1046gt2.m17803g();
        return c1046gt2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m17827a(C1049a c1049a, boolean z) {
        synchronized (this) {
            C1052c c1052c = c1049a.f3285b;
            if (c1052c.f3299e != c1049a) {
                throw new IllegalStateException();
            }
            if (z && !c1052c.f3298d) {
                for (int i = 0; i < this.f3275i; i++) {
                    if (!c1049a.f3286c[i]) {
                        c1049a.m17794b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!c1052c.m17783b(i).exists()) {
                        c1049a.m17794b();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.f3275i; i2++) {
                File m17783b = c1052c.m17783b(i2);
                if (!z) {
                    m17822a(m17783b);
                } else if (m17783b.exists()) {
                    File m17790a = c1052c.m17790a(i2);
                    m17783b.renameTo(m17790a);
                    long j = c1052c.f3297c[i2];
                    long length = m17790a.length();
                    c1052c.f3297c[i2] = length;
                    this.f3276j = (this.f3276j - j) + length;
                }
            }
            this.f3279m++;
            c1052c.f3299e = null;
            if (c1052c.f3298d || z) {
                c1052c.f3298d = true;
                this.f3277k.write("CLEAN " + c1052c.f3296b + c1052c.m17791a() + '\n');
                if (z) {
                    long j2 = this.f3281o;
                    this.f3281o = 1 + j2;
                    c1052c.f3300f = j2;
                }
            } else {
                this.f3278l.remove(c1052c.f3296b);
                this.f3277k.write("REMOVE " + c1052c.f3296b + '\n');
            }
            this.f3277k.flush();
            if (this.f3276j > this.f3274h || m17802h()) {
                this.f3268b.submit(this.f3282p);
            }
        }
    }

    /* renamed from: a */
    private static void m17822a(File file) {
        if (!file.exists() || file.delete()) {
            return;
        }
        throw new IOException();
    }

    /* renamed from: a */
    private static void m17820a(File file, File file2, boolean z) {
        if (z) {
            m17822a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: d */
    private void m17809d(String str) {
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
                this.f3278l.remove(substring2);
                return;
            }
            substring = substring2;
        } else {
            substring = str.substring(i, indexOf2);
        }
        C1052c c1052c = this.f3278l.get(substring);
        if (c1052c == null) {
            c1052c = new C1052c(substring);
            this.f3278l.put(substring, c1052c);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            c1052c.f3298d = true;
            c1052c.f3299e = null;
            c1052c.m17784a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c1052c.f3299e = new C1049a(c1052c);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: e */
    private void m17808e() {
        C1054gv c1054gv = new C1054gv(new FileInputStream(this.f3270d), C1056gw.f3307a);
        try {
            String m17776a = c1054gv.m17776a();
            String m17776a2 = c1054gv.m17776a();
            String m17776a3 = c1054gv.m17776a();
            String m17776a4 = c1054gv.m17776a();
            String m17776a5 = c1054gv.m17776a();
            if (!"libcore.io.DiskLruCache".equals(m17776a) || !"1".equals(m17776a2) || !Integer.toString(this.f3273g).equals(m17776a3) || !Integer.toString(this.f3275i).equals(m17776a4) || !"".equals(m17776a5)) {
                throw new IOException("unexpected journal header: [" + m17776a + ", " + m17776a2 + ", " + m17776a4 + ", " + m17776a5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m17809d(c1054gv.m17776a());
                    i++;
                } catch (EOFException e) {
                    this.f3279m = i - this.f3278l.size();
                    C1056gw.m17773a(c1054gv);
                    return;
                }
            }
        } catch (Throwable th) {
            C1056gw.m17773a(c1054gv);
            throw th;
        }
    }

    /* renamed from: e */
    private void m17806e(String str) {
        if (!f3266a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* renamed from: f */
    private void m17805f() {
        m17822a(this.f3271e);
        Iterator<C1052c> it2 = this.f3278l.values().iterator();
        while (it2.hasNext()) {
            C1052c next = it2.next();
            if (next.f3299e == null) {
                for (int i = 0; i < this.f3275i; i++) {
                    this.f3276j += next.f3297c[i];
                }
            } else {
                next.f3299e = null;
                for (int i2 = 0; i2 < this.f3275i; i2++) {
                    m17822a(next.m17790a(i2));
                    m17822a(next.m17783b(i2));
                }
                it2.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public synchronized void m17803g() {
        if (this.f3277k != null) {
            this.f3277k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3271e), C1056gw.f3307a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f3273g));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f3275i));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (C1052c c1052c : this.f3278l.values()) {
            if (c1052c.f3299e != null) {
                bufferedWriter.write("DIRTY " + c1052c.f3296b + '\n');
            } else {
                bufferedWriter.write("CLEAN " + c1052c.f3296b + c1052c.m17791a() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f3270d.exists()) {
            m17820a(this.f3270d, this.f3272f, true);
        }
        m17820a(this.f3271e, this.f3270d, false);
        this.f3272f.delete();
        this.f3277k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3270d, true), C1056gw.f3307a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m17802h() {
        return this.f3279m >= 2000 && this.f3279m >= this.f3278l.size();
    }

    /* renamed from: i */
    private void m17801i() {
        if (this.f3277k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m17800j() {
        while (this.f3276j > this.f3274h) {
            String key = this.f3278l.entrySet().iterator().next().getKey();
            m17812c(key);
            if (this.f3280n != null) {
                this.f3280n.mo17777a(key);
            }
        }
    }

    /* renamed from: a */
    public synchronized C1051b m17819a(String str) {
        C1051b c1051b = null;
        synchronized (this) {
            m17801i();
            m17806e(str);
            C1052c c1052c = this.f3278l.get(str);
            if (c1052c != null && c1052c.f3298d) {
                InputStream[] inputStreamArr = new InputStream[this.f3275i];
                for (int i = 0; i < this.f3275i; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(c1052c.m17790a(i));
                    } catch (FileNotFoundException e) {
                        for (int i2 = 0; i2 < this.f3275i && inputStreamArr[i2] != null; i2++) {
                            C1056gw.m17773a(inputStreamArr[i2]);
                        }
                    }
                }
                this.f3279m++;
                this.f3277k.append((CharSequence) ("READ " + str + '\n'));
                if (m17802h()) {
                    this.f3268b.submit(this.f3282p);
                }
                c1051b = new C1051b(str, c1052c.f3300f, inputStreamArr, c1052c.f3297c);
            }
        }
        return c1051b;
    }

    /* renamed from: a */
    public void m17823a(AbstractC1053gu abstractC1053gu) {
        this.f3280n = abstractC1053gu;
    }

    /* renamed from: a */
    public synchronized boolean m17828a() {
        return this.f3277k == null;
    }

    /* renamed from: b */
    public C1049a m17815b(String str) {
        return m17818a(str, -1L);
    }

    /* renamed from: b */
    public synchronized void m17817b() {
        m17801i();
        m17800j();
        this.f3277k.flush();
    }

    /* renamed from: c */
    public void m17814c() {
        close();
        C1056gw.m17772a(this.f3269c);
    }

    /* renamed from: c */
    public synchronized boolean m17812c(String str) {
        boolean z;
        synchronized (this) {
            m17801i();
            m17806e(str);
            C1052c c1052c = this.f3278l.get(str);
            if (c1052c == null || c1052c.f3299e != null) {
                z = false;
            } else {
                for (int i = 0; i < this.f3275i; i++) {
                    File m17790a = c1052c.m17790a(i);
                    if (m17790a.exists() && !m17790a.delete()) {
                        throw new IOException("failed to delete " + m17790a);
                    }
                    this.f3276j -= c1052c.f3297c[i];
                    c1052c.f3297c[i] = 0;
                }
                this.f3279m++;
                this.f3277k.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f3278l.remove(str);
                if (m17802h()) {
                    this.f3268b.submit(this.f3282p);
                }
                z = true;
            }
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f3277k != null) {
            Iterator it2 = new ArrayList(this.f3278l.values()).iterator();
            while (it2.hasNext()) {
                C1052c c1052c = (C1052c) it2.next();
                if (c1052c.f3299e != null) {
                    c1052c.f3299e.m17794b();
                }
            }
            m17800j();
            this.f3277k.close();
            this.f3277k = null;
        }
    }
}
