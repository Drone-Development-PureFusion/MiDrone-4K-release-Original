package com.xiaomi.infra.galaxy.fds.android.auth;

import com.xiaomi.infra.galaxy.fds.android.util.Args;
import org.apache.http.client.methods.HttpRequestBase;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
/* loaded from: classes.dex */
public class SSOCredential implements GalaxyFDSCredential {
    private final String APP_ID;
    private final String HEADER_VALUE;
    private final String SERVICE_TOKEN_PARAM;
    private final String appId;
    private final String serviceToken;

    @Deprecated
    public SSOCredential(String str) {
        this.HEADER_VALUE = "SSO";
        this.SERVICE_TOKEN_PARAM = "serviceToken";
        this.APP_ID = "appId";
        Args.notNull(str, "Service token");
        Args.notEmpty(str, "Service token");
        this.serviceToken = str;
        this.appId = null;
    }

    public SSOCredential(String str, String str2) {
        this.HEADER_VALUE = "SSO";
        this.SERVICE_TOKEN_PARAM = "serviceToken";
        this.APP_ID = "appId";
        Args.notNull(str, "Service token");
        Args.notEmpty(str, "Service token");
        Args.notNull(str2, "App id");
        Args.notEmpty(str2, "App id");
        this.serviceToken = str;
        this.appId = str2;
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.auth.GalaxyFDSCredential
    public void addHeader(HttpRequestBase httpRequestBase) {
        httpRequestBase.addHeader("Authorization", "SSO");
    }

    @Override // com.xiaomi.infra.galaxy.fds.android.auth.GalaxyFDSCredential
    public String addParam(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf(63) == -1) {
            sb.append('?');
        } else {
            sb.append('&');
        }
        sb.append("serviceToken");
        sb.append(SignatureVisitor.INSTANCEOF);
        sb.append(this.serviceToken);
        if (this.appId != null) {
            sb.append('&');
            sb.append("appId");
            sb.append(SignatureVisitor.INSTANCEOF);
            sb.append(this.appId);
        }
        return sb.toString();
    }
}
