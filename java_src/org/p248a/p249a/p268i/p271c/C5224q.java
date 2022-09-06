package org.p248a.p249a.p268i.p271c;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.conn.routing.HttpRoute;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p260e.C5084a;
import org.p248a.p249a.p261f.AbstractC5127e;
import org.p248a.p249a.p261f.AbstractC5130h;
import org.p248a.p249a.p268i.p275g.C5301j;
import org.p248a.p249a.p277j.AbstractC5318b;
import org.p248a.p249a.p277j.AbstractC5319c;
@AbstractC5005b
/* renamed from: org.a.a.i.c.q */
/* loaded from: classes2.dex */
public class C5224q implements AbstractC5127e<HttpRoute, AbstractC5130h> {

    /* renamed from: c */
    private final AbstractC5319c<HttpRequest> f22103c;

    /* renamed from: d */
    private final AbstractC5318b<HttpResponse> f22104d;

    /* renamed from: b */
    private static final AtomicLong f22102b = new AtomicLong();

    /* renamed from: a */
    public static final C5224q f22101a = new C5224q();

    public C5224q() {
        this(null, null);
    }

    public C5224q(AbstractC5318b<HttpResponse> abstractC5318b) {
        this(null, abstractC5318b);
    }

    public C5224q(AbstractC5319c<HttpRequest> abstractC5319c, AbstractC5318b<HttpResponse> abstractC5318b) {
        this.f22103c = abstractC5319c == null ? C5301j.f22279a : abstractC5319c;
        this.f22104d = abstractC5318b == null ? C5214g.f22078a : abstractC5318b;
    }

    @Override // org.p248a.p249a.p261f.AbstractC5127e
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public AbstractC5130h mo1620a(HttpRoute httpRoute, C5084a c5084a) {
        CharsetEncoder charsetEncoder;
        CharsetDecoder charsetDecoder;
        if (c5084a == null) {
            c5084a = C5084a.f21692a;
        }
        Charset m2065c = c5084a.m2065c();
        CodingErrorAction m2064d = c5084a.m2064d() != null ? c5084a.m2064d() : CodingErrorAction.REPORT;
        CodingErrorAction m2063e = c5084a.m2063e() != null ? c5084a.m2063e() : CodingErrorAction.REPORT;
        if (m2065c != null) {
            charsetDecoder = m2065c.newDecoder();
            charsetDecoder.onMalformedInput(m2064d);
            charsetDecoder.onUnmappableCharacter(m2063e);
            charsetEncoder = m2065c.newEncoder();
            charsetEncoder.onMalformedInput(m2064d);
            charsetEncoder.onUnmappableCharacter(m2063e);
        } else {
            charsetEncoder = null;
            charsetDecoder = null;
        }
        return new C5222o("http-outgoing-" + Long.toString(f22102b.getAndIncrement()), c5084a.m2068a(), c5084a.m2066b(), charsetDecoder, charsetEncoder, c5084a.m2062f(), null, null, this.f22103c, this.f22104d);
    }
}
