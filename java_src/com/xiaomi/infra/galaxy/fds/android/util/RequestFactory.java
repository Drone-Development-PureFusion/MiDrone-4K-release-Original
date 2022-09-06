package com.xiaomi.infra.galaxy.fds.android.util;

import com.xiaomi.infra.galaxy.fds.android.auth.GalaxyFDSCredential;
import com.xiaomi.infra.galaxy.fds.android.model.HttpMethod;
import java.util.Date;
import java.util.Map;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
/* loaded from: classes2.dex */
public class RequestFactory {
    public static HttpUriRequest createRequest(String str, GalaxyFDSCredential galaxyFDSCredential, HttpMethod httpMethod, Map<String, String> map) {
        HttpUriRequest httpHead;
        String addParam = galaxyFDSCredential.addParam(str);
        switch (httpMethod) {
            case GET:
                httpHead = new HttpGet(addParam);
                break;
            case PUT:
                httpHead = new HttpPut(addParam);
                break;
            case POST:
                httpHead = new HttpPost(addParam);
                break;
            case DELETE:
                httpHead = new HttpDelete(addParam);
                break;
            case HEAD:
                httpHead = new HttpHead(addParam);
                break;
            default:
                httpHead = null;
                break;
        }
        if (httpHead != null) {
            if (map != null) {
                map.remove("Content-Length");
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpHead.addHeader(entry.getKey(), entry.getValue());
                }
            }
            httpHead.addHeader("Date", Util.formatDateString(new Date()));
            galaxyFDSCredential.addHeader(httpHead);
        }
        return httpHead;
    }
}
