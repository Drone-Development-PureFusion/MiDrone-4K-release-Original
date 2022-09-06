package org.p248a.p249a.p261f;

import java.net.Socket;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpInetConnection;
/* renamed from: org.a.a.f.h */
/* loaded from: classes2.dex */
public interface AbstractC5130h extends HttpClientConnection, HttpInetConnection {
    /* renamed from: a */
    String mo1633a();

    /* renamed from: a */
    void mo1644a(Socket socket);

    /* renamed from: b */
    Socket mo1632b();

    /* renamed from: c */
    SSLSession mo1631c();
}
