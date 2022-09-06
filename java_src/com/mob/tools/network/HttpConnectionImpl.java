package com.mob.tools.network;

import com.xiaomi.mipush.sdk.Constants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
/* loaded from: classes.dex */
public class HttpConnectionImpl implements HttpConnection {
    private HttpResponse response;

    public HttpConnectionImpl(HttpResponse httpResponse) {
        this.response = httpResponse;
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getErrorStream() {
        return this.response.getEntity().getContent();
    }

    @Override // com.mob.tools.network.HttpConnection
    public Map<String, List<String>> getHeaderFields() {
        HashMap hashMap = null;
        Header[] allHeaders = this.response.getAllHeaders();
        if (allHeaders != null) {
            hashMap = new HashMap();
            for (Header header : allHeaders) {
                ArrayList arrayList = new ArrayList();
                hashMap.put(header.getName(), arrayList);
                String[] split = header.getValue().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null) {
                    for (String str : split) {
                        arrayList.add(str.trim());
                    }
                }
            }
        }
        return hashMap;
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getInputStream() {
        return this.response.getEntity().getContent();
    }

    @Override // com.mob.tools.network.HttpConnection
    public int getResponseCode() {
        return this.response.getStatusLine().getStatusCode();
    }
}
