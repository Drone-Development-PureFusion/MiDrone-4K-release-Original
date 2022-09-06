package org.p248a.p249a.p261f.p262a;

import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.http.params.HttpParams;
@Deprecated
/* renamed from: org.a.a.f.a.e */
/* loaded from: classes.dex */
class C5099e implements AbstractC5097c {

    /* renamed from: a */
    private final AbstractC5095a f21725a;

    C5099e(AbstractC5095a abstractC5095a) {
        this.f21725a = abstractC5095a;
    }

    @Override // org.p248a.p249a.p261f.p262a.AbstractC5097c
    /* renamed from: a */
    public Socket mo2024a(Socket socket, String str, int i, HttpParams httpParams) {
        return this.f21725a.m2025a(socket, str, i, true);
    }

    @Override // org.p248a.p249a.p261f.p262a.AbstractC5100f
    /* renamed from: a */
    public Socket mo2021a(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpParams httpParams) {
        return this.f21725a.a(socket, inetSocketAddress, inetSocketAddress2, httpParams);
    }

    @Override // org.p248a.p249a.p261f.p262a.AbstractC5100f
    /* renamed from: a */
    public Socket mo2020a(HttpParams httpParams) {
        return this.f21725a.a(httpParams);
    }

    @Override // org.p248a.p249a.p261f.p262a.AbstractC5100f
    /* renamed from: a */
    public boolean mo2022a(Socket socket) {
        return this.f21725a.a(socket);
    }
}
