package com.p118d.p119a.p136c;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* renamed from: com.d.a.c.c */
/* loaded from: classes.dex */
public final class C1947c {

    /* renamed from: a */
    public static final int f6939a = 32768;

    /* renamed from: b */
    public static final int f6940b = 512000;

    /* renamed from: c */
    public static final int f6941c = 75;

    /* renamed from: com.d.a.c.c$a */
    /* loaded from: classes.dex */
    public interface AbstractC1948a {
        /* renamed from: a */
        boolean mo13857a(int i, int i2);
    }

    private C1947c() {
    }

    /* renamed from: a */
    public static void m13861a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static void m13860a(InputStream inputStream) {
        do {
            try {
            } catch (IOException e) {
                return;
            } finally {
                m13861a((Closeable) inputStream);
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
    }

    /* renamed from: a */
    private static boolean m13862a(AbstractC1948a abstractC1948a, int i, int i2) {
        return abstractC1948a != null && !abstractC1948a.mo13857a(i, i2) && (i * 100) / i2 < 75;
    }

    /* renamed from: a */
    public static boolean m13859a(InputStream inputStream, OutputStream outputStream, AbstractC1948a abstractC1948a) {
        return m13858a(inputStream, outputStream, abstractC1948a, 32768);
    }

    /* renamed from: a */
    public static boolean m13858a(InputStream inputStream, OutputStream outputStream, AbstractC1948a abstractC1948a, int i) {
        int available = inputStream.available();
        if (available <= 0) {
            available = f6940b;
        }
        byte[] bArr = new byte[i];
        if (m13862a(abstractC1948a, 0, available)) {
            return false;
        }
        int i2 = 0;
        do {
            int read = inputStream.read(bArr, 0, i);
            if (read == -1) {
                outputStream.flush();
                return true;
            }
            outputStream.write(bArr, 0, read);
            i2 += read;
        } while (!m13862a(abstractC1948a, i2, available));
        return false;
    }
}
