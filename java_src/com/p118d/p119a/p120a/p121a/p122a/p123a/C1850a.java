package com.p118d.p119a.p120a.p121a.p122a.p123a;

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
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.d.a.a.a.a.a.a */
/* loaded from: classes.dex */
public final class C1850a implements Closeable {

    /* renamed from: a */
    static final String f6540a = "journal";

    /* renamed from: b */
    static final String f6541b = "journal.tmp";

    /* renamed from: c */
    static final String f6542c = "journal.bkp";

    /* renamed from: d */
    static final String f6543d = "libcore.io.DiskLruCache";

    /* renamed from: e */
    static final String f6544e = "1";

    /* renamed from: f */
    static final long f6545f = -1;

    /* renamed from: i */
    private static final String f6547i = "CLEAN";

    /* renamed from: j */
    private static final String f6548j = "DIRTY";

    /* renamed from: k */
    private static final String f6549k = "REMOVE";

    /* renamed from: l */
    private static final String f6550l = "READ";

    /* renamed from: m */
    private final File f6553m;

    /* renamed from: n */
    private final File f6554n;

    /* renamed from: o */
    private final File f6555o;

    /* renamed from: p */
    private final File f6556p;

    /* renamed from: q */
    private final int f6557q;

    /* renamed from: r */
    private long f6558r;

    /* renamed from: s */
    private int f6559s;

    /* renamed from: t */
    private final int f6560t;

    /* renamed from: w */
    private Writer f6563w;

    /* renamed from: y */
    private int f6565y;

    /* renamed from: g */
    static final Pattern f6546g = Pattern.compile("[a-z0-9_-]{1,64}");

    /* renamed from: B */
    private static final OutputStream f6539B = new OutputStream() { // from class: com.d.a.a.a.a.a.a.2
        @Override // java.io.OutputStream
        public void write(int i) {
        }
    };

    /* renamed from: u */
    private long f6561u = 0;

    /* renamed from: v */
    private int f6562v = 0;

    /* renamed from: x */
    private final LinkedHashMap<String, C1855b> f6564x = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: z */
    private long f6566z = 0;

    /* renamed from: h */
    final ThreadPoolExecutor f6552h = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: A */
    private final Callable<Void> f6551A = new Callable<Void>() { // from class: com.d.a.a.a.a.a.a.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            synchronized (C1850a.this) {
                if (C1850a.this.f6563w != null) {
                    C1850a.this.m14266o();
                    C1850a.this.m14265p();
                    if (C1850a.this.m14268m()) {
                        C1850a.this.m14269l();
                        C1850a.this.f6565y = 0;
                    }
                }
            }
            return null;
        }
    };

    /* renamed from: com.d.a.a.a.a.a.a$a */
    /* loaded from: classes.dex */
    public final class C1853a {

        /* renamed from: b */
        private final C1855b f6569b;

        /* renamed from: c */
        private final boolean[] f6570c;

        /* renamed from: d */
        private boolean f6571d;

        /* renamed from: e */
        private boolean f6572e;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.d.a.a.a.a.a.a$a$a */
        /* loaded from: classes.dex */
        public class C1854a extends FilterOutputStream {
            private C1854a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C1853a.this.f6571d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C1853a.this.f6571d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    C1853a.this.f6571d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    C1853a.this.f6571d = true;
                }
            }
        }

        private C1853a(C1855b c1855b) {
            this.f6569b = c1855b;
            this.f6570c = c1855b.f6577d ? null : new boolean[C1850a.this.f6560t];
        }

        /* renamed from: a */
        public InputStream m14262a(int i) {
            synchronized (C1850a.this) {
                if (this.f6569b.f6578e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f6569b.f6577d) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f6569b.m14252a(i));
                } catch (FileNotFoundException e) {
                    return null;
                }
            }
        }

        /* renamed from: a */
        public void m14263a() {
            if (this.f6571d) {
                C1850a.this.m14301a(this, false);
                C1850a.this.m14284c(this.f6569b.f6575b);
            } else {
                C1850a.this.m14301a(this, true);
            }
            this.f6572e = true;
        }

        /* renamed from: a */
        public void m14261a(int i, String str) {
            OutputStreamWriter outputStreamWriter;
            try {
                outputStreamWriter = new OutputStreamWriter(m14254c(i), C1860d.f6606b);
            } catch (Throwable th) {
                th = th;
                outputStreamWriter = null;
            }
            try {
                outputStreamWriter.write(str);
                C1860d.m14224a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                C1860d.m14224a(outputStreamWriter);
                throw th;
            }
        }

        /* renamed from: b */
        public String m14257b(int i) {
            InputStream m14262a = m14262a(i);
            if (m14262a != null) {
                return C1850a.m14288b(m14262a);
            }
            return null;
        }

        /* renamed from: b */
        public void m14258b() {
            C1850a.this.m14301a(this, false);
        }

        /* renamed from: c */
        public OutputStream m14254c(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            synchronized (C1850a.this) {
                if (this.f6569b.f6578e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f6569b.f6577d) {
                    this.f6570c[i] = true;
                }
                File m14245b = this.f6569b.m14245b(i);
                try {
                    fileOutputStream = new FileOutputStream(m14245b);
                } catch (FileNotFoundException e) {
                    C1850a.this.f6553m.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(m14245b);
                    } catch (FileNotFoundException e2) {
                        outputStream = C1850a.f6539B;
                    }
                }
                outputStream = new C1854a(fileOutputStream);
            }
            return outputStream;
        }

        /* renamed from: c */
        public void m14255c() {
            if (!this.f6572e) {
                try {
                    m14258b();
                } catch (IOException e) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.d.a.a.a.a.a.a$b */
    /* loaded from: classes.dex */
    public final class C1855b {

        /* renamed from: b */
        private final String f6575b;

        /* renamed from: c */
        private final long[] f6576c;

        /* renamed from: d */
        private boolean f6577d;

        /* renamed from: e */
        private C1853a f6578e;

        /* renamed from: f */
        private long f6579f;

        private C1855b(String str) {
            this.f6575b = str;
            this.f6576c = new long[C1850a.this.f6560t];
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m14246a(String[] strArr) {
            if (strArr.length != C1850a.this.f6560t) {
                throw m14243b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f6576c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw m14243b(strArr);
                }
            }
        }

        /* renamed from: b */
        private IOException m14243b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public File m14252a(int i) {
            return new File(C1850a.this.f6553m, this.f6575b + "." + i);
        }

        /* renamed from: a */
        public String m14253a() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f6576c) {
                sb.append(C5122l.f21763c).append(j);
            }
            return sb.toString();
        }

        /* renamed from: b */
        public File m14245b(int i) {
            return new File(C1850a.this.f6553m, this.f6575b + "." + i + ".tmp");
        }
    }

    /* renamed from: com.d.a.a.a.a.a.a$c */
    /* loaded from: classes.dex */
    public final class C1856c implements Closeable {

        /* renamed from: b */
        private final String f6581b;

        /* renamed from: c */
        private final long f6582c;

        /* renamed from: d */
        private File[] f6583d;

        /* renamed from: e */
        private final InputStream[] f6584e;

        /* renamed from: f */
        private final long[] f6585f;

        private C1856c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.f6581b = str;
            this.f6582c = j;
            this.f6583d = fileArr;
            this.f6584e = inputStreamArr;
            this.f6585f = jArr;
        }

        /* renamed from: a */
        public C1853a m14239a() {
            return C1850a.this.m14291a(this.f6581b, this.f6582c);
        }

        /* renamed from: a */
        public File m14238a(int i) {
            return this.f6583d[i];
        }

        /* renamed from: b */
        public InputStream m14237b(int i) {
            return this.f6584e[i];
        }

        /* renamed from: c */
        public String m14236c(int i) {
            return C1850a.m14288b(m14237b(i));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f6584e) {
                C1860d.m14224a(inputStream);
            }
        }

        /* renamed from: d */
        public long m14235d(int i) {
            return this.f6585f[i];
        }
    }

    private C1850a(File file, int i, int i2, long j, int i3) {
        this.f6553m = file;
        this.f6557q = i;
        this.f6554n = new File(file, f6540a);
        this.f6555o = new File(file, f6541b);
        this.f6556p = new File(file, f6542c);
        this.f6560t = i2;
        this.f6558r = j;
        this.f6559s = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized C1853a m14291a(String str, long j) {
        C1855b c1855b;
        C1853a c1853a;
        m14267n();
        m14278e(str);
        C1855b c1855b2 = this.f6564x.get(str);
        if (j == f6545f || (c1855b2 != null && c1855b2.f6579f == j)) {
            if (c1855b2 == null) {
                C1855b c1855b3 = new C1855b(str);
                this.f6564x.put(str, c1855b3);
                c1855b = c1855b3;
            } else if (c1855b2.f6578e != null) {
                c1853a = null;
            } else {
                c1855b = c1855b2;
            }
            c1853a = new C1853a(c1855b);
            c1855b.f6578e = c1853a;
            this.f6563w.write("DIRTY " + str + '\n');
            this.f6563w.flush();
        } else {
            c1853a = null;
        }
        return c1853a;
    }

    /* renamed from: a */
    public static C1850a m14295a(File file, int i, int i2, long j, int i3) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, f6542c);
        if (file2.exists()) {
            File file3 = new File(file, f6540a);
            if (file3.exists()) {
                file2.delete();
            } else {
                m14294a(file2, file3, false);
            }
        }
        C1850a c1850a = new C1850a(file, i, i2, j, i3);
        if (c1850a.f6554n.exists()) {
            try {
                c1850a.m14271j();
                c1850a.m14270k();
                c1850a.f6563w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c1850a.f6554n, true), C1860d.f6605a));
                return c1850a;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                c1850a.m14273h();
            }
        }
        file.mkdirs();
        C1850a c1850a2 = new C1850a(file, i, i2, j, i3);
        c1850a2.m14269l();
        return c1850a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m14301a(C1853a c1853a, boolean z) {
        synchronized (this) {
            C1855b c1855b = c1853a.f6569b;
            if (c1855b.f6578e != c1853a) {
                throw new IllegalStateException();
            }
            if (z && !c1855b.f6577d) {
                for (int i = 0; i < this.f6560t; i++) {
                    if (!c1853a.f6570c[i]) {
                        c1853a.m14258b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!c1855b.m14245b(i).exists()) {
                        c1853a.m14258b();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.f6560t; i2++) {
                File m14245b = c1855b.m14245b(i2);
                if (!z) {
                    m14296a(m14245b);
                } else if (m14245b.exists()) {
                    File m14252a = c1855b.m14252a(i2);
                    m14245b.renameTo(m14252a);
                    long j = c1855b.f6576c[i2];
                    long length = m14252a.length();
                    c1855b.f6576c[i2] = length;
                    this.f6561u = (this.f6561u - j) + length;
                    this.f6562v++;
                }
            }
            this.f6565y++;
            c1855b.f6578e = null;
            if (c1855b.f6577d || z) {
                c1855b.f6577d = true;
                this.f6563w.write("CLEAN " + c1855b.f6575b + c1855b.m14253a() + '\n');
                if (z) {
                    long j2 = this.f6566z;
                    this.f6566z = 1 + j2;
                    c1855b.f6579f = j2;
                }
            } else {
                this.f6564x.remove(c1855b.f6575b);
                this.f6563w.write("REMOVE " + c1855b.f6575b + '\n');
            }
            this.f6563w.flush();
            if (this.f6561u > this.f6558r || this.f6562v > this.f6559s || m14268m()) {
                this.f6552h.submit(this.f6551A);
            }
        }
    }

    /* renamed from: a */
    private static void m14296a(File file) {
        if (!file.exists() || file.delete()) {
            return;
        }
        throw new IOException();
    }

    /* renamed from: a */
    private static void m14294a(File file, File file2, boolean z) {
        if (z) {
            m14296a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m14288b(InputStream inputStream) {
        return C1860d.m14222a((Reader) new InputStreamReader(inputStream, C1860d.f6606b));
    }

    /* renamed from: d */
    private void m14281d(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring2 = str.substring(i);
            if (indexOf == f6549k.length() && str.startsWith(f6549k)) {
                this.f6564x.remove(substring2);
                return;
            }
            substring = substring2;
        } else {
            substring = str.substring(i, indexOf2);
        }
        C1855b c1855b = this.f6564x.get(substring);
        if (c1855b == null) {
            c1855b = new C1855b(substring);
            this.f6564x.put(substring, c1855b);
        }
        if (indexOf2 != -1 && indexOf == f6547i.length() && str.startsWith(f6547i)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            c1855b.f6577d = true;
            c1855b.f6578e = null;
            c1855b.m14246a(split);
        } else if (indexOf2 == -1 && indexOf == f6548j.length() && str.startsWith(f6548j)) {
            c1855b.f6578e = new C1853a(c1855b);
        } else if (indexOf2 != -1 || indexOf != f6550l.length() || !str.startsWith(f6550l)) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: e */
    private void m14278e(String str) {
        if (!f6546g.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }

    /* renamed from: j */
    private void m14271j() {
        C1858c c1858c = new C1858c(new FileInputStream(this.f6554n), C1860d.f6605a);
        try {
            String m14227a = c1858c.m14227a();
            String m14227a2 = c1858c.m14227a();
            String m14227a3 = c1858c.m14227a();
            String m14227a4 = c1858c.m14227a();
            String m14227a5 = c1858c.m14227a();
            if (!f6543d.equals(m14227a) || !"1".equals(m14227a2) || !Integer.toString(this.f6557q).equals(m14227a3) || !Integer.toString(this.f6560t).equals(m14227a4) || !"".equals(m14227a5)) {
                throw new IOException("unexpected journal header: [" + m14227a + ", " + m14227a2 + ", " + m14227a4 + ", " + m14227a5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m14281d(c1858c.m14227a());
                    i++;
                } catch (EOFException e) {
                    this.f6565y = i - this.f6564x.size();
                    C1860d.m14224a(c1858c);
                    return;
                }
            }
        } catch (Throwable th) {
            C1860d.m14224a(c1858c);
            throw th;
        }
    }

    /* renamed from: k */
    private void m14270k() {
        m14296a(this.f6555o);
        Iterator<C1855b> it2 = this.f6564x.values().iterator();
        while (it2.hasNext()) {
            C1855b next = it2.next();
            if (next.f6578e == null) {
                for (int i = 0; i < this.f6560t; i++) {
                    this.f6561u += next.f6576c[i];
                    this.f6562v++;
                }
            } else {
                next.f6578e = null;
                for (int i2 = 0; i2 < this.f6560t; i2++) {
                    m14296a(next.m14252a(i2));
                    m14296a(next.m14245b(i2));
                }
                it2.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public synchronized void m14269l() {
        if (this.f6563w != null) {
            this.f6563w.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f6555o), C1860d.f6605a));
        bufferedWriter.write(f6543d);
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f6557q));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f6560t));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (C1855b c1855b : this.f6564x.values()) {
            if (c1855b.f6578e != null) {
                bufferedWriter.write("DIRTY " + c1855b.f6575b + '\n');
            } else {
                bufferedWriter.write("CLEAN " + c1855b.f6575b + c1855b.m14253a() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f6554n.exists()) {
            m14294a(this.f6554n, this.f6556p, true);
        }
        m14294a(this.f6555o, this.f6554n, false);
        this.f6556p.delete();
        this.f6563w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f6554n, true), C1860d.f6605a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public boolean m14268m() {
        return this.f6565y >= 2000 && this.f6565y >= this.f6564x.size();
    }

    /* renamed from: n */
    private void m14267n() {
        if (this.f6563w == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m14266o() {
        while (this.f6561u > this.f6558r) {
            m14284c(this.f6564x.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m14265p() {
        while (this.f6562v > this.f6559s) {
            m14284c(this.f6564x.entrySet().iterator().next().getKey());
        }
    }

    /* renamed from: a */
    public synchronized C1856c m14292a(String str) {
        C1856c c1856c = null;
        synchronized (this) {
            m14267n();
            m14278e(str);
            C1855b c1855b = this.f6564x.get(str);
            if (c1855b != null && c1855b.f6577d) {
                File[] fileArr = new File[this.f6560t];
                InputStream[] inputStreamArr = new InputStream[this.f6560t];
                for (int i = 0; i < this.f6560t; i++) {
                    try {
                        File m14252a = c1855b.m14252a(i);
                        fileArr[i] = m14252a;
                        inputStreamArr[i] = new FileInputStream(m14252a);
                    } catch (FileNotFoundException e) {
                        for (int i2 = 0; i2 < this.f6560t && inputStreamArr[i2] != null; i2++) {
                            C1860d.m14224a(inputStreamArr[i2]);
                        }
                    }
                }
                this.f6565y++;
                this.f6563w.append((CharSequence) ("READ " + str + '\n'));
                if (m14268m()) {
                    this.f6552h.submit(this.f6551A);
                }
                c1856c = new C1856c(str, c1855b.f6579f, fileArr, inputStreamArr, c1855b.f6576c);
            }
        }
        return c1856c;
    }

    /* renamed from: a */
    public File m14303a() {
        return this.f6553m;
    }

    /* renamed from: a */
    public synchronized void m14302a(long j) {
        this.f6558r = j;
        this.f6552h.submit(this.f6551A);
    }

    /* renamed from: b */
    public synchronized long m14290b() {
        return this.f6558r;
    }

    /* renamed from: b */
    public C1853a m14287b(String str) {
        return m14291a(str, f6545f);
    }

    /* renamed from: c */
    public synchronized int m14286c() {
        return this.f6559s;
    }

    /* renamed from: c */
    public synchronized boolean m14284c(String str) {
        boolean z;
        synchronized (this) {
            m14267n();
            m14278e(str);
            C1855b c1855b = this.f6564x.get(str);
            if (c1855b == null || c1855b.f6578e != null) {
                z = false;
            } else {
                for (int i = 0; i < this.f6560t; i++) {
                    File m14252a = c1855b.m14252a(i);
                    if (m14252a.exists() && !m14252a.delete()) {
                        throw new IOException("failed to delete " + m14252a);
                    }
                    this.f6561u -= c1855b.f6576c[i];
                    this.f6562v--;
                    c1855b.f6576c[i] = 0;
                }
                this.f6565y++;
                this.f6563w.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f6564x.remove(str);
                if (m14268m()) {
                    this.f6552h.submit(this.f6551A);
                }
                z = true;
            }
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f6563w != null) {
            Iterator it2 = new ArrayList(this.f6564x.values()).iterator();
            while (it2.hasNext()) {
                C1855b c1855b = (C1855b) it2.next();
                if (c1855b.f6578e != null) {
                    c1855b.f6578e.m14258b();
                }
            }
            m14266o();
            m14265p();
            this.f6563w.close();
            this.f6563w = null;
        }
    }

    /* renamed from: d */
    public synchronized long m14283d() {
        return this.f6561u;
    }

    /* renamed from: e */
    public synchronized long m14280e() {
        return this.f6562v;
    }

    /* renamed from: f */
    public synchronized boolean m14277f() {
        return this.f6563w == null;
    }

    /* renamed from: g */
    public synchronized void m14275g() {
        m14267n();
        m14266o();
        m14265p();
        this.f6563w.flush();
    }

    /* renamed from: h */
    public void m14273h() {
        close();
        C1860d.m14223a(this.f6553m);
    }
}
