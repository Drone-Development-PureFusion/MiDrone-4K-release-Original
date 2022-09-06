package org.p248a.p249a.p261f.p262a;

import java.net.Socket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
@Deprecated
/* renamed from: org.a.a.f.a.b */
/* loaded from: classes.dex */
class C5096b extends C5102h implements LayeredSocketFactory {

    /* renamed from: a */
    private final AbstractC5095a f21723a;

    C5096b(AbstractC5095a abstractC5095a) {
        super(abstractC5095a);
        this.f21723a = abstractC5095a;
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.f21723a.m2025a(socket, str, i, z);
    }
}
