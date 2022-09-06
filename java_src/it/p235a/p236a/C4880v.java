package it.p235a.p236a;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;
import org.p248a.p249a.p261f.p264c.C5122l;
/* renamed from: it.a.a.v */
/* loaded from: classes.dex */
class C4880v extends Writer {

    /* renamed from: a */
    private static final String f20851a = "\r\n";

    /* renamed from: b */
    private OutputStream f20852b;

    /* renamed from: c */
    private Writer f20853c;

    public C4880v(OutputStream outputStream, String str) {
        this.f20852b = outputStream;
        this.f20853c = new OutputStreamWriter(outputStream, str);
    }

    /* renamed from: a */
    public void m2976a(String str) {
        synchronized (this) {
            this.f20853c = new OutputStreamWriter(this.f20852b, str);
        }
    }

    /* renamed from: b */
    public void m2975b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "\r\n");
        int countTokens = stringTokenizer.countTokens();
        boolean z = false;
        for (int i = 0; i < countTokens; i++) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() > 0) {
                if (z) {
                    stringBuffer.append(C5122l.f21761a);
                    stringBuffer.append((char) 0);
                }
                stringBuffer.append(nextToken);
                z = true;
            }
        }
        if (stringBuffer.length() > 0) {
            this.f20853c.write(stringBuffer.toString());
            this.f20853c.write("\r\n");
            this.f20853c.flush();
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            this.f20853c.close();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        synchronized (this) {
            this.f20853c.flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        synchronized (this) {
            this.f20853c.write(cArr, i, i2);
        }
    }
}
