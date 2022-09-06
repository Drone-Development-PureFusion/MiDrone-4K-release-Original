package com.p080b;

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
/* renamed from: com.b.ai */
/* loaded from: classes.dex */
public final class C1411ai implements Closeable {

    /* renamed from: a */
    static final Pattern f4846a = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: q */
    private static final OutputStream f4847q = new C1417e();

    /* renamed from: c */
    private final File f4849c;

    /* renamed from: d */
    private final File f4850d;

    /* renamed from: e */
    private final File f4851e;

    /* renamed from: f */
    private final File f4852f;

    /* renamed from: g */
    private final int f4853g;

    /* renamed from: h */
    private long f4854h;

    /* renamed from: i */
    private final int f4855i;

    /* renamed from: k */
    private Writer f4857k;

    /* renamed from: m */
    private int f4859m;

    /* renamed from: n */
    private AbstractC1418aj f4860n;

    /* renamed from: j */
    private long f4856j = 0;

    /* renamed from: l */
    private final LinkedHashMap<String, C1415c> f4858l = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: o */
    private long f4861o = 0;

    /* renamed from: b */
    final ThreadPoolExecutor f4848b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: p */
    private final Callable<Void> f4862p = new CallableC1416d();

    /* renamed from: com.b.ai$a */
    /* loaded from: classes.dex */
    public final class C1412a {

        /* renamed from: b */
        private final C1415c f4864b;

        /* renamed from: c */
        private final boolean[] f4865c;

        /* renamed from: d */
        private boolean f4866d;

        /* renamed from: e */
        private boolean f4867e;

        /* renamed from: com.b.ai$a$a */
        /* loaded from: classes.dex */
        private class C1413a extends FilterOutputStream {
            private C1413a(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ C1413a(C1412a c1412a, OutputStream outputStream, CallableC1416d callableC1416d) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    C1412a.this.f4866d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    C1412a.this.f4866d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    C1412a.this.f4866d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    C1412a.this.f4866d = true;
                }
            }
        }

        private C1412a(C1415c c1415c) {
            this.f4864b = c1415c;
            this.f4865c = c1415c.f4877d ? null : new boolean[C1411ai.this.f4855i];
        }

        /* synthetic */ C1412a(C1411ai c1411ai, C1415c c1415c, CallableC1416d callableC1416d) {
            this(c1415c);
        }

        /* renamed from: a */
        public OutputStream m16371a(int i) {
            OutputStream outputStream;
            FileOutputStream fileOutputStream;
            if (i < 0 || i >= C1411ai.this.f4855i) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + C1411ai.this.f4855i);
            }
            synchronized (C1411ai.this) {
                if (this.f4864b.f4878e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f4864b.f4877d) {
                    this.f4865c[i] = true;
                }
                File m16357b = this.f4864b.m16357b(i);
                try {
                    fileOutputStream = new FileOutputStream(m16357b);
                } catch (FileNotFoundException e) {
                    C1411ai.this.f4849c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(m16357b);
                    } catch (FileNotFoundException e2) {
                        outputStream = C1411ai.f4847q;
                    }
                }
                outputStream = new C1413a(this, fileOutputStream, null);
            }
            return outputStream;
        }

        /* renamed from: a */
        public void m16372a() {
            if (this.f4866d) {
                C1411ai.this.m16400a(this, false);
                C1411ai.this.m16385c(this.f4864b.f4875b);
            } else {
                C1411ai.this.m16400a(this, true);
            }
            this.f4867e = true;
        }

        /* renamed from: b */
        public void m16368b() {
            C1411ai.this.m16400a(this, false);
        }
    }

    /* renamed from: com.b.ai$b */
    /* loaded from: classes.dex */
    public final class C1414b implements Closeable {

        /* renamed from: b */
        private final String f4870b;

        /* renamed from: c */
        private final long f4871c;

        /* renamed from: d */
        private final InputStream[] f4872d;

        /* renamed from: e */
        private final long[] f4873e;

        private C1414b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f4870b = str;
            this.f4871c = j;
            this.f4872d = inputStreamArr;
            this.f4873e = jArr;
        }

        /* synthetic */ C1414b(C1411ai c1411ai, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC1416d callableC1416d) {
            this(str, j, inputStreamArr, jArr);
        }

        /* renamed from: a */
        public InputStream m16366a(int i) {
            return this.f4872d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f4872d) {
                C1421al.m16347a(inputStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.b.ai$c */
    /* loaded from: classes.dex */
    public final class C1415c {

        /* renamed from: b */
        private final String f4875b;

        /* renamed from: c */
        private final long[] f4876c;

        /* renamed from: d */
        private boolean f4877d;

        /* renamed from: e */
        private C1412a f4878e;

        /* renamed from: f */
        private long f4879f;

        private C1415c(String str) {
            this.f4875b = str;
            this.f4876c = new long[C1411ai.this.f4855i];
        }

        /* synthetic */ C1415c(C1411ai c1411ai, String str, CallableC1416d callableC1416d) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m16358a(String[] strArr) {
            if (strArr.length != C1411ai.this.f4855i) {
                throw m16355b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f4876c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException e) {
                    throw m16355b(strArr);
                }
            }
        }

        /* renamed from: b */
        private IOException m16355b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public File m16364a(int i) {
            return new File(C1411ai.this.f4849c, this.f4875b + "." + i);
        }

        /* renamed from: a */
        public String m16365a() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f4876c) {
                sb.append(C5122l.f21763c).append(j);
            }
            return sb.toString();
        }

        /* renamed from: b */
        public File m16357b(int i) {
            return new File(C1411ai.this.f4849c, this.f4875b + "." + i + ".tmp");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.b.ai$d */
    /* loaded from: classes.dex */
    public class CallableC1416d implements Callable<Void> {
        CallableC1416d() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            synchronized (C1411ai.this) {
                if (C1411ai.this.f4857k != null) {
                    C1411ai.this.m16373j();
                    if (C1411ai.this.m16375h()) {
                        C1411ai.this.m16376g();
                        C1411ai.this.f4859m = 0;
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: com.b.ai$e */
    /* loaded from: classes.dex */
    static class C1417e extends OutputStream {
        C1417e() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    private C1411ai(File file, int i, int i2, long j) {
        this.f4849c = file;
        this.f4853g = i;
        this.f4850d = new File(file, "journal");
        this.f4851e = new File(file, "journal.tmp");
        this.f4852f = new File(file, "journal.bkp");
        this.f4855i = i2;
        this.f4854h = j;
    }

    /* renamed from: a */
    private synchronized C1412a m16391a(String str, long j) {
        C1415c c1415c;
        C1412a c1412a;
        m16374i();
        m16379e(str);
        C1415c c1415c2 = this.f4858l.get(str);
        if (j == -1 || (c1415c2 != null && c1415c2.f4879f == j)) {
            if (c1415c2 == null) {
                C1415c c1415c3 = new C1415c(this, str, null);
                this.f4858l.put(str, c1415c3);
                c1415c = c1415c3;
            } else if (c1415c2.f4878e != null) {
                c1412a = null;
            } else {
                c1415c = c1415c2;
            }
            c1412a = new C1412a(this, c1415c, null);
            c1415c.f4878e = c1412a;
            this.f4857k.write("DIRTY " + str + '\n');
            this.f4857k.flush();
        } else {
            c1412a = null;
        }
        return c1412a;
    }

    /* renamed from: a */
    public static C1411ai m16394a(File file, int i, int i2, long j) {
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
                m16393a(file2, file3, false);
            }
        }
        C1411ai c1411ai = new C1411ai(file, i, i2, j);
        if (c1411ai.f4850d.exists()) {
            try {
                c1411ai.m16381e();
                c1411ai.m16378f();
                c1411ai.f4857k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c1411ai.f4850d, true), C1421al.f4887a));
                return c1411ai;
            } catch (IOException e) {
                c1411ai.m16387c();
            }
        }
        file.mkdirs();
        C1411ai c1411ai2 = new C1411ai(file, i, i2, j);
        c1411ai2.m16376g();
        return c1411ai2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m16400a(C1412a c1412a, boolean z) {
        synchronized (this) {
            C1415c c1415c = c1412a.f4864b;
            if (c1415c.f4878e != c1412a) {
                throw new IllegalStateException();
            }
            if (z && !c1415c.f4877d) {
                for (int i = 0; i < this.f4855i; i++) {
                    if (!c1412a.f4865c[i]) {
                        c1412a.m16368b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    } else if (!c1415c.m16357b(i).exists()) {
                        c1412a.m16368b();
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < this.f4855i; i2++) {
                File m16357b = c1415c.m16357b(i2);
                if (!z) {
                    m16395a(m16357b);
                } else if (m16357b.exists()) {
                    File m16364a = c1415c.m16364a(i2);
                    m16357b.renameTo(m16364a);
                    long j = c1415c.f4876c[i2];
                    long length = m16364a.length();
                    c1415c.f4876c[i2] = length;
                    this.f4856j = (this.f4856j - j) + length;
                }
            }
            this.f4859m++;
            c1415c.f4878e = null;
            if (c1415c.f4877d || z) {
                c1415c.f4877d = true;
                this.f4857k.write("CLEAN " + c1415c.f4875b + c1415c.m16365a() + '\n');
                if (z) {
                    long j2 = this.f4861o;
                    this.f4861o = 1 + j2;
                    c1415c.f4879f = j2;
                }
            } else {
                this.f4858l.remove(c1415c.f4875b);
                this.f4857k.write("REMOVE " + c1415c.f4875b + '\n');
            }
            this.f4857k.flush();
            if (this.f4856j > this.f4854h || m16375h()) {
                this.f4848b.submit(this.f4862p);
            }
        }
    }

    /* renamed from: a */
    private static void m16395a(File file) {
        if (!file.exists() || file.delete()) {
            return;
        }
        throw new IOException();
    }

    /* renamed from: a */
    private static void m16393a(File file, File file2, boolean z) {
        if (z) {
            m16395a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: d */
    private void m16382d(String str) {
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
                this.f4858l.remove(substring2);
                return;
            }
            substring = substring2;
        } else {
            substring = str.substring(i, indexOf2);
        }
        C1415c c1415c = this.f4858l.get(substring);
        if (c1415c == null) {
            c1415c = new C1415c(this, substring, null);
            this.f4858l.put(substring, c1415c);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            c1415c.f4877d = true;
            c1415c.f4878e = null;
            c1415c.m16358a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c1415c.f4878e = new C1412a(this, c1415c, null);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: e */
    private void m16381e() {
        C1419ak c1419ak = new C1419ak(new FileInputStream(this.f4850d), C1421al.f4887a);
        try {
            String m16350a = c1419ak.m16350a();
            String m16350a2 = c1419ak.m16350a();
            String m16350a3 = c1419ak.m16350a();
            String m16350a4 = c1419ak.m16350a();
            String m16350a5 = c1419ak.m16350a();
            if (!"libcore.io.DiskLruCache".equals(m16350a) || !"1".equals(m16350a2) || !Integer.toString(this.f4853g).equals(m16350a3) || !Integer.toString(this.f4855i).equals(m16350a4) || !"".equals(m16350a5)) {
                throw new IOException("unexpected journal header: [" + m16350a + ", " + m16350a2 + ", " + m16350a4 + ", " + m16350a5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m16382d(c1419ak.m16350a());
                    i++;
                } catch (EOFException e) {
                    this.f4859m = i - this.f4858l.size();
                    C1421al.m16347a(c1419ak);
                    return;
                }
            }
        } catch (Throwable th) {
            C1421al.m16347a(c1419ak);
            throw th;
        }
    }

    /* renamed from: e */
    private void m16379e(String str) {
        if (!f4846a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* renamed from: f */
    private void m16378f() {
        m16395a(this.f4851e);
        Iterator<C1415c> it2 = this.f4858l.values().iterator();
        while (it2.hasNext()) {
            C1415c next = it2.next();
            if (next.f4878e == null) {
                for (int i = 0; i < this.f4855i; i++) {
                    this.f4856j += next.f4876c[i];
                }
            } else {
                next.f4878e = null;
                for (int i2 = 0; i2 < this.f4855i; i2++) {
                    m16395a(next.m16364a(i2));
                    m16395a(next.m16357b(i2));
                }
                it2.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public synchronized void m16376g() {
        if (this.f4857k != null) {
            this.f4857k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4851e), C1421al.f4887a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f4853g));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f4855i));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (C1415c c1415c : this.f4858l.values()) {
            if (c1415c.f4878e != null) {
                bufferedWriter.write("DIRTY " + c1415c.f4875b + '\n');
            } else {
                bufferedWriter.write("CLEAN " + c1415c.f4875b + c1415c.m16365a() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f4850d.exists()) {
            m16393a(this.f4850d, this.f4852f, true);
        }
        m16393a(this.f4851e, this.f4850d, false);
        this.f4852f.delete();
        this.f4857k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4850d, true), C1421al.f4887a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m16375h() {
        return this.f4859m >= 2000 && this.f4859m >= this.f4858l.size();
    }

    /* renamed from: i */
    private void m16374i() {
        if (this.f4857k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m16373j() {
        while (this.f4856j > this.f4854h) {
            String key = this.f4858l.entrySet().iterator().next().getKey();
            m16385c(key);
            if (this.f4860n != null) {
                this.f4860n.mo15506a(key);
            }
        }
    }

    /* renamed from: a */
    public synchronized C1414b m16392a(String str) {
        C1414b c1414b = null;
        synchronized (this) {
            m16374i();
            m16379e(str);
            C1415c c1415c = this.f4858l.get(str);
            if (c1415c != null && c1415c.f4877d) {
                InputStream[] inputStreamArr = new InputStream[this.f4855i];
                for (int i = 0; i < this.f4855i; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(c1415c.m16364a(i));
                    } catch (FileNotFoundException e) {
                        for (int i2 = 0; i2 < this.f4855i && inputStreamArr[i2] != null; i2++) {
                            C1421al.m16347a(inputStreamArr[i2]);
                        }
                    }
                }
                this.f4859m++;
                this.f4857k.append((CharSequence) ("READ " + str + '\n'));
                if (m16375h()) {
                    this.f4848b.submit(this.f4862p);
                }
                c1414b = new C1414b(this, str, c1415c.f4879f, inputStreamArr, c1415c.f4876c, null);
            }
        }
        return c1414b;
    }

    /* renamed from: a */
    public void m16396a(AbstractC1418aj abstractC1418aj) {
        this.f4860n = abstractC1418aj;
    }

    /* renamed from: a */
    public synchronized boolean m16401a() {
        return this.f4857k == null;
    }

    /* renamed from: b */
    public C1412a m16388b(String str) {
        return m16391a(str, -1L);
    }

    /* renamed from: b */
    public synchronized void m16390b() {
        m16374i();
        m16373j();
        this.f4857k.flush();
    }

    /* renamed from: c */
    public void m16387c() {
        close();
        C1421al.m16346a(this.f4849c);
    }

    /* renamed from: c */
    public synchronized boolean m16385c(String str) {
        boolean z;
        synchronized (this) {
            m16374i();
            m16379e(str);
            C1415c c1415c = this.f4858l.get(str);
            if (c1415c == null || c1415c.f4878e != null) {
                z = false;
            } else {
                for (int i = 0; i < this.f4855i; i++) {
                    File m16364a = c1415c.m16364a(i);
                    if (m16364a.exists() && !m16364a.delete()) {
                        throw new IOException("failed to delete " + m16364a);
                    }
                    this.f4856j -= c1415c.f4876c[i];
                    c1415c.f4876c[i] = 0;
                }
                this.f4859m++;
                this.f4857k.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f4858l.remove(str);
                if (m16375h()) {
                    this.f4848b.submit(this.f4862p);
                }
                z = true;
            }
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f4857k != null) {
            Iterator it2 = new ArrayList(this.f4858l.values()).iterator();
            while (it2.hasNext()) {
                C1415c c1415c = (C1415c) it2.next();
                if (c1415c.f4878e != null) {
                    c1415c.f4878e.m16368b();
                }
            }
            m16373j();
            this.f4857k.close();
            this.f4857k = null;
        }
    }
}
