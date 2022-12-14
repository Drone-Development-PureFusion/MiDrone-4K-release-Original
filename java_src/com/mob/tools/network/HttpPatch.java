package com.mob.tools.network;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
/* loaded from: classes.dex */
public class HttpPatch extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "PATCH";

    public HttpPatch() {
    }

    public HttpPatch(String str) {
        setURI(URI.create(str));
    }

    public HttpPatch(URI uri) {
        setURI(uri);
    }

    public String getMethod() {
        return "PATCH";
    }
}
