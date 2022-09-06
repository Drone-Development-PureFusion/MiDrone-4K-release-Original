package com.mob.tools.network;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpConnectionImpl23 implements HttpConnection {
    private HttpURLConnection conn;

    public HttpConnectionImpl23(HttpURLConnection httpURLConnection) {
        this.conn = httpURLConnection;
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getErrorStream() {
        return this.conn.getErrorStream();
    }

    @Override // com.mob.tools.network.HttpConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.conn.getHeaderFields();
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getInputStream() {
        return this.conn.getInputStream();
    }

    @Override // com.mob.tools.network.HttpConnection
    public int getResponseCode() {
        return this.conn.getResponseCode();
    }
}
