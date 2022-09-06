package p004b.p005a.p006a.p028b.p041h.p043b;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import p004b.p005a.p006a.p028b.p057r.C0588t;
/* renamed from: b.a.a.b.h.b.d */
/* loaded from: classes.dex */
public class C0382d {

    /* renamed from: a */
    private String f789a;

    /* renamed from: b */
    private String f790b;

    /* renamed from: c */
    private String f791c;

    /* renamed from: d */
    private String f792d;

    /* renamed from: f */
    private KeyStore m20698f() {
        return m20701d() != null ? KeyStore.getInstance(m20703c(), m20701d()) : KeyStore.getInstance(m20703c());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public KeyStore m20707a() {
        InputStream inputStream;
        Throwable th;
        Exception exc;
        if (m20705b() == null) {
            throw new IllegalArgumentException("location is required");
        }
        try {
            try {
                try {
                    try {
                        InputStream openStream = C0588t.m20071a(m20705b()).openStream();
                        try {
                            KeyStore m20698f = m20698f();
                            m20698f.load(openStream, m20699e().toCharArray());
                            if (openStream != null) {
                                try {
                                    openStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace(System.err);
                                }
                            }
                            return m20698f;
                        } catch (Exception e2) {
                            inputStream = openStream;
                            exc = e2;
                            try {
                                throw new KeyStoreException(m20705b() + ": " + exc.getMessage(), exc);
                            } catch (Throwable th2) {
                                th = th2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace(System.err);
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        inputStream = null;
                        th = th3;
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                } catch (NoSuchAlgorithmException e4) {
                    throw new NoSuchAlgorithmException("no such keystore type: " + m20703c());
                }
            } catch (FileNotFoundException e5) {
                throw new KeyStoreException(m20705b() + ": file not found");
            } catch (NoSuchProviderException e6) {
                throw new NoSuchProviderException("no such keystore provider: " + m20701d());
            }
        } catch (Exception e7) {
            inputStream = null;
            exc = e7;
        } catch (Throwable th4) {
            inputStream = null;
            th = th4;
            if (inputStream != null) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    public void m20706a(String str) {
        this.f789a = str;
    }

    /* renamed from: b */
    public String m20705b() {
        return this.f789a;
    }

    /* renamed from: b */
    public void m20704b(String str) {
        this.f791c = str;
    }

    /* renamed from: c */
    public String m20703c() {
        return this.f791c == null ? AbstractC0383e.f794b : this.f791c;
    }

    /* renamed from: c */
    public void m20702c(String str) {
        this.f790b = str;
    }

    /* renamed from: d */
    public String m20701d() {
        return this.f790b;
    }

    /* renamed from: d */
    public void m20700d(String str) {
        this.f792d = str;
    }

    /* renamed from: e */
    public String m20699e() {
        return this.f792d == null ? AbstractC0383e.f795c : this.f792d;
    }
}
