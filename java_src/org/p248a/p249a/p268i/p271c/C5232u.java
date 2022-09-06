package org.p248a.p249a.p268i.p271c;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.c.u */
/* loaded from: classes2.dex */
public class C5232u {

    /* renamed from: a */
    private static final String f22121a = "Wire";

    /* renamed from: b */
    private final String f22122b;

    public C5232u(String str) {
        this.f22122b = str;
    }

    /* renamed from: a */
    private void m1576a(String str, InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            } else if (read == 13) {
                sb.append("[\\r]");
            } else if (read == 10) {
                sb.append("[\\n]\"");
                sb.insert(0, "\"");
                sb.insert(0, str);
                Log.d(f22121a, this.f22122b + " " + sb.toString());
                sb.setLength(0);
            } else if (read < 32 || read > 127) {
                sb.append("[0x");
                sb.append(Integer.toHexString(read));
                sb.append("]");
            } else {
                sb.append((char) read);
            }
        }
        if (sb.length() > 0) {
            sb.append('\"');
            sb.insert(0, '\"');
            sb.insert(0, str);
            Log.d(f22121a, this.f22122b + " " + sb.toString());
        }
    }

    /* renamed from: a */
    public void m1579a(int i) {
        m1575a(new byte[]{(byte) i});
    }

    /* renamed from: a */
    public void m1578a(InputStream inputStream) {
        C5351a.m1321a(inputStream, "Output");
        m1576a(">> ", inputStream);
    }

    /* renamed from: a */
    public void m1577a(String str) {
        C5351a.m1321a(str, "Output");
        m1575a(str.getBytes());
    }

    /* renamed from: a */
    public void m1575a(byte[] bArr) {
        C5351a.m1321a(bArr, "Output");
        m1576a(">> ", new ByteArrayInputStream(bArr));
    }

    /* renamed from: a */
    public void m1574a(byte[] bArr, int i, int i2) {
        C5351a.m1321a(bArr, "Output");
        m1576a(">> ", new ByteArrayInputStream(bArr, i, i2));
    }

    /* renamed from: a */
    public boolean m1580a() {
        return Log.isLoggable(f22121a, 3);
    }

    /* renamed from: b */
    public void m1573b(int i) {
        m1570b(new byte[]{(byte) i});
    }

    /* renamed from: b */
    public void m1572b(InputStream inputStream) {
        C5351a.m1321a(inputStream, "Input");
        m1576a("<< ", inputStream);
    }

    /* renamed from: b */
    public void m1571b(String str) {
        C5351a.m1321a(str, "Input");
        m1570b(str.getBytes());
    }

    /* renamed from: b */
    public void m1570b(byte[] bArr) {
        C5351a.m1321a(bArr, "Input");
        m1576a("<< ", new ByteArrayInputStream(bArr));
    }

    /* renamed from: b */
    public void m1569b(byte[] bArr, int i, int i2) {
        C5351a.m1321a(bArr, "Input");
        m1576a("<< ", new ByteArrayInputStream(bArr, i, i2));
    }
}
