package it.p235a.p236a;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
/* renamed from: it.a.a.u */
/* loaded from: classes.dex */
class C4879u extends Reader {

    /* renamed from: a */
    private static final String f20848a = System.getProperty("line.separator");

    /* renamed from: b */
    private InputStream f20849b;

    /* renamed from: c */
    private Reader f20850c;

    public C4879u(InputStream inputStream, String str) {
        this.f20849b = inputStream;
        this.f20850c = new InputStreamReader(inputStream, str);
    }

    /* renamed from: a */
    public String m2978a() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = -1;
        while (true) {
            int read = this.f20850c.read();
            if (read == -1) {
                if (stringBuffer.length() != 0) {
                    return stringBuffer.toString();
                }
                return null;
            } else if (read == 10) {
                return stringBuffer.toString();
            } else {
                if (i == 13 && read == 0) {
                    stringBuffer.append(f20848a);
                } else if (read != 0 && read != 13) {
                    stringBuffer.append((char) read);
                }
                i = read;
            }
        }
    }

    /* renamed from: a */
    public void m2977a(String str) {
        synchronized (this) {
            this.f20850c = new InputStreamReader(this.f20849b, str);
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            this.f20850c.close();
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) {
        int read;
        synchronized (this) {
            read = this.f20850c.read(cArr, i, i2);
        }
        return read;
    }
}
