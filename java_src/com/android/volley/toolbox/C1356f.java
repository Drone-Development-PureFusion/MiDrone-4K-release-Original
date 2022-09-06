package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AbstractC1317b;
import com.android.volley.C1385v;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* renamed from: com.android.volley.toolbox.f */
/* loaded from: classes.dex */
public class C1356f implements AbstractC1317b {

    /* renamed from: e */
    private static final int f4647e = 5242880;

    /* renamed from: f */
    private static final float f4648f = 0.9f;

    /* renamed from: g */
    private static final int f4649g = 538247942;

    /* renamed from: a */
    private final Map<String, C1358a> f4650a;

    /* renamed from: b */
    private long f4651b;

    /* renamed from: c */
    private final File f4652c;

    /* renamed from: d */
    private final int f4653d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.android.volley.toolbox.f$a */
    /* loaded from: classes.dex */
    public static class C1358a {

        /* renamed from: a */
        public long f4654a;

        /* renamed from: b */
        public String f4655b;

        /* renamed from: c */
        public String f4656c;

        /* renamed from: d */
        public long f4657d;

        /* renamed from: e */
        public long f4658e;

        /* renamed from: f */
        public long f4659f;

        /* renamed from: g */
        public long f4660g;

        /* renamed from: h */
        public Map<String, String> f4661h;

        private C1358a() {
        }

        public C1358a(String str, AbstractC1317b.C1318a c1318a) {
            this.f4655b = str;
            this.f4654a = c1318a.f4530a.length;
            this.f4656c = c1318a.f4531b;
            this.f4657d = c1318a.f4532c;
            this.f4658e = c1318a.f4533d;
            this.f4659f = c1318a.f4534e;
            this.f4660g = c1318a.f4535f;
            this.f4661h = c1318a.f4536g;
        }

        /* renamed from: a */
        public static C1358a m16645a(InputStream inputStream) {
            C1358a c1358a = new C1358a();
            if (C1356f.m16659a(inputStream) != C1356f.f4649g) {
                throw new IOException();
            }
            c1358a.f4655b = C1356f.m16651c(inputStream);
            c1358a.f4656c = C1356f.m16651c(inputStream);
            if (c1358a.f4656c.equals("")) {
                c1358a.f4656c = null;
            }
            c1358a.f4657d = C1356f.m16652b(inputStream);
            c1358a.f4658e = C1356f.m16652b(inputStream);
            c1358a.f4659f = C1356f.m16652b(inputStream);
            c1358a.f4660g = C1356f.m16652b(inputStream);
            c1358a.f4661h = C1356f.m16649d(inputStream);
            return c1358a;
        }

        /* renamed from: a */
        public AbstractC1317b.C1318a m16643a(byte[] bArr) {
            AbstractC1317b.C1318a c1318a = new AbstractC1317b.C1318a();
            c1318a.f4530a = bArr;
            c1318a.f4531b = this.f4656c;
            c1318a.f4532c = this.f4657d;
            c1318a.f4533d = this.f4658e;
            c1318a.f4534e = this.f4659f;
            c1318a.f4535f = this.f4660g;
            c1318a.f4536g = this.f4661h;
            return c1318a;
        }

        /* renamed from: a */
        public boolean m16644a(OutputStream outputStream) {
            try {
                C1356f.m16657a(outputStream, (int) C1356f.f4649g);
                C1356f.m16655a(outputStream, this.f4655b);
                C1356f.m16655a(outputStream, this.f4656c == null ? "" : this.f4656c);
                C1356f.m16656a(outputStream, this.f4657d);
                C1356f.m16656a(outputStream, this.f4658e);
                C1356f.m16656a(outputStream, this.f4659f);
                C1356f.m16656a(outputStream, this.f4660g);
                C1356f.m16653a(this.f4661h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                C1385v.m16565b("%s", e.toString());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.android.volley.toolbox.f$b */
    /* loaded from: classes.dex */
    public static class C1359b extends FilterInputStream {

        /* renamed from: a */
        private int f4662a;

        private C1359b(InputStream inputStream) {
            super(inputStream);
            this.f4662a = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f4662a++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f4662a += read;
            }
            return read;
        }
    }

    public C1356f(File file) {
        this(file, f4647e);
    }

    public C1356f(File file, int i) {
        this.f4650a = new LinkedHashMap(16, 0.75f, true);
        this.f4651b = 0L;
        this.f4652c = file;
        this.f4653d = i;
    }

    /* renamed from: a */
    static int m16659a(InputStream inputStream) {
        return 0 | (m16647e(inputStream) << 0) | (m16647e(inputStream) << 8) | (m16647e(inputStream) << 16) | (m16647e(inputStream) << 24);
    }

    /* renamed from: a */
    private void m16660a(int i) {
        int i2;
        if (this.f4651b + i < this.f4653d) {
            return;
        }
        if (C1385v.f4718b) {
            C1385v.m16567a("Pruning old cache entries.", new Object[0]);
        }
        long j = this.f4651b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, C1358a>> it2 = this.f4650a.entrySet().iterator();
        int i3 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i2 = i3;
                break;
            }
            C1358a value = it2.next().getValue();
            if (m16650c(value.f4655b).delete()) {
                this.f4651b -= value.f4654a;
            } else {
                C1385v.m16565b("Could not delete cache entry for key=%s, filename=%s", value.f4655b, m16648d(value.f4655b));
            }
            it2.remove();
            i2 = i3 + 1;
            if (((float) (this.f4651b + i)) < this.f4653d * f4648f) {
                break;
            }
            i3 = i2;
        }
        if (!C1385v.f4718b) {
            return;
        }
        C1385v.m16567a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f4651b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
    }

    /* renamed from: a */
    static void m16657a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    /* renamed from: a */
    static void m16656a(OutputStream outputStream, long j) {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    /* renamed from: a */
    static void m16655a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m16656a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* renamed from: a */
    private void m16654a(String str, C1358a c1358a) {
        if (!this.f4650a.containsKey(str)) {
            this.f4651b += c1358a.f4654a;
        } else {
            this.f4651b = (c1358a.f4654a - this.f4650a.get(str).f4654a) + this.f4651b;
        }
        this.f4650a.put(str, c1358a);
    }

    /* renamed from: a */
    static void m16653a(Map<String, String> map, OutputStream outputStream) {
        if (map == null) {
            m16657a(outputStream, 0);
            return;
        }
        m16657a(outputStream, map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            m16655a(outputStream, entry.getKey());
            m16655a(outputStream, entry.getValue());
        }
    }

    /* renamed from: a */
    private static byte[] m16658a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 != i) {
            throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
        }
        return bArr;
    }

    /* renamed from: b */
    static long m16652b(InputStream inputStream) {
        return 0 | ((m16647e(inputStream) & 255) << 0) | ((m16647e(inputStream) & 255) << 8) | ((m16647e(inputStream) & 255) << 16) | ((m16647e(inputStream) & 255) << 24) | ((m16647e(inputStream) & 255) << 32) | ((m16647e(inputStream) & 255) << 40) | ((m16647e(inputStream) & 255) << 48) | ((m16647e(inputStream) & 255) << 56);
    }

    /* renamed from: c */
    static String m16651c(InputStream inputStream) {
        return new String(m16658a(inputStream, (int) m16652b(inputStream)), "UTF-8");
    }

    /* renamed from: d */
    private String m16648d(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    /* renamed from: d */
    static Map<String, String> m16649d(InputStream inputStream) {
        int m16659a = m16659a(inputStream);
        Map<String, String> emptyMap = m16659a == 0 ? Collections.emptyMap() : new HashMap<>(m16659a);
        for (int i = 0; i < m16659a; i++) {
            emptyMap.put(m16651c(inputStream).intern(), m16651c(inputStream).intern());
        }
        return emptyMap;
    }

    /* renamed from: e */
    private static int m16647e(InputStream inputStream) {
        int read = inputStream.read();
        if (read == -1) {
            throw new EOFException();
        }
        return read;
    }

    /* renamed from: e */
    private void m16646e(String str) {
        C1358a c1358a = this.f4650a.get(str);
        if (c1358a != null) {
            this.f4651b -= c1358a.f4654a;
            this.f4650a.remove(str);
        }
    }

    @Override // com.android.volley.AbstractC1317b
    /* renamed from: a */
    public synchronized AbstractC1317b.C1318a mo16585a(String str) {
        C1359b c1359b;
        AbstractC1317b.C1318a c1318a;
        File m16650c;
        C1358a c1358a = this.f4650a.get(str);
        if (c1358a == null) {
            c1318a = null;
        } else {
            try {
                m16650c = m16650c(str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                c1359b = new C1359b(new BufferedInputStream(new FileInputStream(m16650c)));
                try {
                    C1358a.m16645a(c1359b);
                    c1318a = c1358a.m16643a(m16658a(c1359b, (int) (m16650c.length() - c1359b.f4662a)));
                    if (c1359b != null) {
                        try {
                            c1359b.close();
                        } catch (IOException e) {
                            c1318a = null;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    C1385v.m16565b("%s: %s", m16650c.getAbsolutePath(), e.toString());
                    mo16581b(str);
                    if (c1359b != null) {
                        try {
                            c1359b.close();
                        } catch (IOException e3) {
                            c1318a = null;
                        }
                    }
                    c1318a = null;
                    return c1318a;
                } catch (NegativeArraySizeException e4) {
                    e = e4;
                    C1385v.m16565b("%s: %s", m16650c.getAbsolutePath(), e.toString());
                    mo16581b(str);
                    if (c1359b != null) {
                        try {
                            c1359b.close();
                        } catch (IOException e5) {
                            c1318a = null;
                        }
                    }
                    c1318a = null;
                    return c1318a;
                }
            } catch (IOException e6) {
                e = e6;
                c1359b = null;
            } catch (NegativeArraySizeException e7) {
                e = e7;
                c1359b = null;
            } catch (Throwable th2) {
                th = th2;
                c1359b = null;
                if (c1359b != null) {
                    try {
                        c1359b.close();
                    } catch (IOException e8) {
                        c1318a = null;
                    }
                }
                throw th;
            }
        }
        return c1318a;
    }

    @Override // com.android.volley.AbstractC1317b
    /* renamed from: a */
    public synchronized void mo16586a() {
        BufferedInputStream bufferedInputStream;
        if (this.f4652c.exists()) {
            File[] listFiles = this.f4652c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            try {
                                C1358a m16645a = C1358a.m16645a(bufferedInputStream);
                                m16645a.f4654a = file.length();
                                m16654a(m16645a.f4655b, m16645a);
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e) {
                                    }
                                }
                            } catch (IOException e2) {
                                if (file != null) {
                                    file.delete();
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e3) {
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            bufferedInputStream2 = bufferedInputStream;
                            th = th;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        } else if (!this.f4652c.mkdirs()) {
            C1385v.m16563c("Unable to create cache dir %s", this.f4652c.getAbsolutePath());
        }
    }

    @Override // com.android.volley.AbstractC1317b
    /* renamed from: a */
    public synchronized void mo16584a(String str, AbstractC1317b.C1318a c1318a) {
        BufferedOutputStream bufferedOutputStream;
        C1358a c1358a;
        m16660a(c1318a.f4530a.length);
        File m16650c = m16650c(str);
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(m16650c));
            c1358a = new C1358a(str, c1318a);
        } catch (IOException e) {
            if (!m16650c.delete()) {
                C1385v.m16565b("Could not clean up file %s", m16650c.getAbsolutePath());
            }
        }
        if (!c1358a.m16644a(bufferedOutputStream)) {
            bufferedOutputStream.close();
            C1385v.m16565b("Failed to write header for %s", m16650c.getAbsolutePath());
            throw new IOException();
        }
        bufferedOutputStream.write(c1318a.f4530a);
        bufferedOutputStream.close();
        m16654a(str, c1358a);
    }

    @Override // com.android.volley.AbstractC1317b
    /* renamed from: a */
    public synchronized void mo16583a(String str, boolean z) {
        AbstractC1317b.C1318a mo16585a = mo16585a(str);
        if (mo16585a != null) {
            mo16585a.f4535f = 0L;
            if (z) {
                mo16585a.f4534e = 0L;
            }
            mo16584a(str, mo16585a);
        }
    }

    @Override // com.android.volley.AbstractC1317b
    /* renamed from: b */
    public synchronized void mo16582b() {
        synchronized (this) {
            File[] listFiles = this.f4652c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
            this.f4650a.clear();
            this.f4651b = 0L;
            C1385v.m16565b("Cache cleared.", new Object[0]);
        }
    }

    @Override // com.android.volley.AbstractC1317b
    /* renamed from: b */
    public synchronized void mo16581b(String str) {
        boolean delete = m16650c(str).delete();
        m16646e(str);
        if (!delete) {
            C1385v.m16565b("Could not delete cache entry for key=%s, filename=%s", str, m16648d(str));
        }
    }

    /* renamed from: c */
    public File m16650c(String str) {
        return new File(this.f4652c, m16648d(str));
    }
}
