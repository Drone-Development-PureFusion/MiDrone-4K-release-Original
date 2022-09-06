package org.p248a.p249a.p260e;

import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import org.p248a.p249a.C5008b;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.e.a */
/* loaded from: classes2.dex */
public class C5084a implements Cloneable {

    /* renamed from: a */
    public static final C5084a f21692a = new C5085a().m2059a();

    /* renamed from: b */
    private final int f21693b;

    /* renamed from: c */
    private final int f21694c;

    /* renamed from: d */
    private final Charset f21695d;

    /* renamed from: e */
    private final CodingErrorAction f21696e;

    /* renamed from: f */
    private final CodingErrorAction f21697f;

    /* renamed from: g */
    private final C5087c f21698g;

    /* renamed from: org.a.a.e.a$a */
    /* loaded from: classes2.dex */
    public static class C5085a {

        /* renamed from: a */
        private int f21699a;

        /* renamed from: b */
        private int f21700b = -1;

        /* renamed from: c */
        private Charset f21701c;

        /* renamed from: d */
        private CodingErrorAction f21702d;

        /* renamed from: e */
        private CodingErrorAction f21703e;

        /* renamed from: f */
        private C5087c f21704f;

        C5085a() {
        }

        /* renamed from: a */
        public C5085a m2058a(int i) {
            this.f21699a = i;
            return this;
        }

        /* renamed from: a */
        public C5085a m2057a(Charset charset) {
            this.f21701c = charset;
            return this;
        }

        /* renamed from: a */
        public C5085a m2056a(CodingErrorAction codingErrorAction) {
            this.f21702d = codingErrorAction;
            if (codingErrorAction != null && this.f21701c == null) {
                this.f21701c = C5008b.f21457f;
            }
            return this;
        }

        /* renamed from: a */
        public C5085a m2055a(C5087c c5087c) {
            this.f21704f = c5087c;
            return this;
        }

        /* renamed from: a */
        public C5084a m2059a() {
            Charset charset = this.f21701c;
            if (charset == null && (this.f21702d != null || this.f21703e != null)) {
                charset = C5008b.f21457f;
            }
            int i = this.f21699a > 0 ? this.f21699a : 8192;
            return new C5084a(i, this.f21700b >= 0 ? this.f21700b : i, charset, this.f21702d, this.f21703e, this.f21704f);
        }

        /* renamed from: b */
        public C5085a m2054b(int i) {
            this.f21700b = i;
            return this;
        }

        /* renamed from: b */
        public C5085a m2053b(CodingErrorAction codingErrorAction) {
            this.f21703e = codingErrorAction;
            if (codingErrorAction != null && this.f21701c == null) {
                this.f21701c = C5008b.f21457f;
            }
            return this;
        }
    }

    C5084a(int i, int i2, Charset charset, CodingErrorAction codingErrorAction, CodingErrorAction codingErrorAction2, C5087c c5087c) {
        this.f21693b = i;
        this.f21694c = i2;
        this.f21695d = charset;
        this.f21696e = codingErrorAction;
        this.f21697f = codingErrorAction2;
        this.f21698g = c5087c;
    }

    /* renamed from: a */
    public static C5085a m2067a(C5084a c5084a) {
        C5351a.m1321a(c5084a, "Connection config");
        return new C5085a().m2057a(c5084a.m2065c()).m2056a(c5084a.m2064d()).m2053b(c5084a.m2063e()).m2055a(c5084a.m2062f());
    }

    /* renamed from: h */
    public static C5085a m2060h() {
        return new C5085a();
    }

    /* renamed from: a */
    public int m2068a() {
        return this.f21693b;
    }

    /* renamed from: b */
    public int m2066b() {
        return this.f21694c;
    }

    /* renamed from: c */
    public Charset m2065c() {
        return this.f21695d;
    }

    /* renamed from: d */
    public CodingErrorAction m2064d() {
        return this.f21696e;
    }

    /* renamed from: e */
    public CodingErrorAction m2063e() {
        return this.f21697f;
    }

    /* renamed from: f */
    public C5087c m2062f() {
        return this.f21698g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public C5084a clone() {
        return (C5084a) super.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[bufferSize=").append(this.f21693b).append(", fragmentSizeHint=").append(this.f21694c).append(", charset=").append(this.f21695d).append(", malformedInputAction=").append(this.f21696e).append(", unmappableInputAction=").append(this.f21697f).append(", messageConstraints=").append(this.f21698g).append("]");
        return sb.toString();
    }
}
