package org.p248a.p249a.p268i.p276h;

import java.io.IOException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p280m.AbstractC5334e;
@AbstractC5007d
/* renamed from: org.a.a.i.h.c */
/* loaded from: classes2.dex */
public class C5313c extends AbstractC5334e<HttpHost, HttpClientConnection> {
    public C5313c(String str, HttpHost httpHost, HttpClientConnection httpClientConnection) {
        super(str, httpHost, httpClientConnection);
    }

    @Override // org.p248a.p249a.p280m.AbstractC5334e
    /* renamed from: e */
    public boolean mo1393e() {
        return !i().isOpen();
    }

    @Override // org.p248a.p249a.p280m.AbstractC5334e
    /* renamed from: f */
    public void mo1392f() {
        try {
            i().close();
        } catch (IOException e) {
        }
    }
}
