package org.p248a.p249a.p267h;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.h.j */
/* loaded from: classes.dex */
public class C5145j extends AbstractC5136a implements Cloneable {

    /* renamed from: e */
    protected final byte[] f21810e;

    public C5145j(String str) {
        this(str, C5140e.f21799m);
    }

    public C5145j(String str, String str2) {
        this(str, C5140e.m1945a(C5140e.f21796j.m1947a(), str2));
    }

    @Deprecated
    public C5145j(String str, String str2, String str3) {
        C5351a.m1321a(str, "Source string");
        str2 = str2 == null ? "text/plain" : str2;
        str3 = str3 == null ? "ISO-8859-1" : str3;
        this.f21810e = str.getBytes(str3);
        a(str2 + "; charset=" + str3);
    }

    public C5145j(String str, Charset charset) {
        this(str, C5140e.m1944a(C5140e.f21796j.m1947a(), charset));
    }

    public C5145j(String str, C5140e c5140e) {
        C5351a.m1321a(str, "Source string");
        Charset m1940b = c5140e != null ? c5140e.m1940b() : null;
        m1940b = m1940b == null ? Charset.forName("ISO-8859-1") : m1940b;
        try {
            this.f21810e = str.getBytes(m1940b.name());
            if (c5140e == null) {
                return;
            }
            a(c5140e.toString());
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedCharsetException(m1940b.name());
        }
    }

    public Object clone() {
        return super.clone();
    }

    public InputStream getContent() {
        return new ByteArrayInputStream(this.f21810e);
    }

    public long getContentLength() {
        return this.f21810e.length;
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        C5351a.m1321a(outputStream, "Output stream");
        outputStream.write(this.f21810e);
        outputStream.flush();
    }
}
