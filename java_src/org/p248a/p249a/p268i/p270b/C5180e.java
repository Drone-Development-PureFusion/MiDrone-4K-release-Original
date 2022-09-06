package org.p248a.p249a.p268i.p270b;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5007d
/* renamed from: org.a.a.i.b.e */
/* loaded from: classes2.dex */
public class C5180e implements CredentialsProvider {

    /* renamed from: a */
    private final ConcurrentHashMap<AuthScope, Credentials> f21950a = new ConcurrentHashMap<>();

    /* renamed from: a */
    private static Credentials m1773a(Map<AuthScope, Credentials> map, AuthScope authScope) {
        int i;
        Credentials credentials = map.get(authScope);
        if (credentials == null) {
            int i2 = -1;
            AuthScope authScope2 = null;
            for (AuthScope authScope3 : map.keySet()) {
                int match = authScope.match(authScope3);
                if (match > i2) {
                    i = match;
                } else {
                    authScope3 = authScope2;
                    i = i2;
                }
                i2 = i;
                authScope2 = authScope3;
            }
            return authScope2 != null ? map.get(authScope2) : credentials;
        }
        return credentials;
    }

    public void clear() {
        this.f21950a.clear();
    }

    public Credentials getCredentials(AuthScope authScope) {
        C5351a.m1321a(authScope, "Authentication scope");
        return m1773a(this.f21950a, authScope);
    }

    public void setCredentials(AuthScope authScope, Credentials credentials) {
        C5351a.m1321a(authScope, "Authentication scope");
        this.f21950a.put(authScope, credentials);
    }

    public String toString() {
        return this.f21950a.toString();
    }
}
