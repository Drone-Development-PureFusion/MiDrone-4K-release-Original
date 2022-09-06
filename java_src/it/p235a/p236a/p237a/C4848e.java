package it.p235a.p236a.p237a;

import it.p235a.p236a.AbstractC4863e;
import it.p235a.p236a.AbstractC4866h;
import it.p235a.p236a.C4864f;
import it.p235a.p236a.C4873o;
import java.io.IOException;
import java.net.Socket;
/* renamed from: it.a.a.a.e */
/* loaded from: classes2.dex */
public class C4848e extends AbstractC4866h {

    /* renamed from: d */
    public static int f20698d = 0;

    /* renamed from: e */
    public static int f20699e = 1;

    /* renamed from: f */
    public int f20700f;

    /* renamed from: g */
    private String f20701g;

    /* renamed from: h */
    private int f20702h;

    /* renamed from: i */
    private String f20703i;

    /* renamed from: j */
    private String f20704j;

    public C4848e(String str, int i) {
        this(str, i, "anonymous", "ftp4j");
    }

    public C4848e(String str, int i, String str2, String str3) {
        super(true);
        this.f20700f = f20698d;
        this.f20701g = str;
        this.f20702h = i;
        this.f20703i = str2;
        this.f20704j = str3;
    }

    @Override // it.p235a.p236a.AbstractC4866h
    /* renamed from: c */
    public Socket mo3004c(String str, int i) {
        boolean z;
        Socket a = a(this.f20701g, this.f20702h);
        C4864f c4864f = new C4864f(a, "ASCII");
        try {
            if (c4864f.m3016c().m2982a() != 220) {
                throw new IOException("Invalid proxy response");
            }
            if (this.f20700f == f20698d) {
                c4864f.m3021a(new StringBuffer().append("USER ").append(this.f20703i).toString());
                try {
                    switch (c4864f.m3016c().m2982a()) {
                        case AbstractC4863e.f20785F /* 230 */:
                            z = false;
                            break;
                        case AbstractC4863e.f20808q /* 331 */:
                            z = true;
                            break;
                        default:
                            throw new IOException("Proxy authentication failed");
                    }
                    if (z) {
                        c4864f.m3021a(new StringBuffer().append("PASS ").append(this.f20704j).toString());
                        try {
                            if (c4864f.m3016c().m2982a() != 230) {
                                throw new IOException("Proxy authentication failed");
                            }
                        } catch (C4873o e) {
                            throw new IOException("Invalid proxy response");
                        }
                    }
                    c4864f.m3021a(new StringBuffer().append("SITE ").append(str).append(":").append(i).toString());
                } catch (C4873o e2) {
                    throw new IOException("Invalid proxy response");
                }
            } else if (this.f20700f == f20699e) {
                c4864f.m3021a(new StringBuffer().append("OPEN ").append(str).append(":").append(i).toString());
            }
            return a;
        } catch (C4873o e3) {
            throw new IOException("Invalid proxy response");
        }
    }

    @Override // it.p235a.p236a.AbstractC4866h
    /* renamed from: d */
    public Socket mo3003d(String str, int i) {
        return b(str, i);
    }

    /* renamed from: d */
    public void m3130d(int i) {
        if (i == f20699e || i == f20698d) {
            this.f20700f = i;
            return;
        }
        throw new IllegalArgumentException("Invalid style");
    }
}
