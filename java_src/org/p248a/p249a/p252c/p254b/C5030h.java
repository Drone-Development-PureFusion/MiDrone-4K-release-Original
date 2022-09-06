package org.p248a.p249a.p252c.p254b;

import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.NameValuePair;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p252c.p258f.C5078j;
import org.p248a.p249a.p267h.C5140e;
import org.p248a.p249a.p267h.C5145j;
@AbstractC5006c
/* renamed from: org.a.a.c.b.h */
/* loaded from: classes2.dex */
public class C5030h extends C5145j {
    public C5030h(Iterable<? extends NameValuePair> iterable) {
        this(iterable, (Charset) null);
    }

    public C5030h(Iterable<? extends NameValuePair> iterable, Charset charset) {
        super(C5078j.m2093a(iterable, charset != null ? charset : Charset.forName("ISO-8859-1")), C5140e.m1944a(C5078j.f21618a, charset));
    }

    public C5030h(List<? extends NameValuePair> list) {
        this(list, (Charset) null);
    }

    public C5030h(List<? extends NameValuePair> list, String str) {
        super(C5078j.m2085a(list, str != null ? str : Charset.forName("ISO-8859-1").name()), C5140e.m1945a(C5078j.f21618a, str));
    }
}
