package org.p248a.p249a.p261f.p262a;

import java.net.Socket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.params.HttpParams;
@Deprecated
/* renamed from: org.a.a.f.a.d */
/* loaded from: classes.dex */
class C5098d extends C5101g implements AbstractC5097c {

    /* renamed from: a */
    private final LayeredSocketFactory f21724a;

    C5098d(LayeredSocketFactory layeredSocketFactory) {
        super(layeredSocketFactory);
        this.f21724a = layeredSocketFactory;
    }

    @Override // org.p248a.p249a.p261f.p262a.AbstractC5097c
    /* renamed from: a */
    public Socket mo2024a(Socket socket, String str, int i, HttpParams httpParams) {
        return this.f21724a.createSocket(socket, str, i, true);
    }
}
