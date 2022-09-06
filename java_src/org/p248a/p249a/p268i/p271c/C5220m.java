package org.p248a.p249a.p268i.p271c;

import android.util.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.p248a.p249a.p261f.AbstractC5103b;
import org.p248a.p249a.p282o.C5351a;
/* renamed from: org.a.a.i.c.m */
/* loaded from: classes2.dex */
public class C5220m implements AbstractC5103b {

    /* renamed from: a */
    private static final String f22092a = "HttpClient";

    /* renamed from: b */
    private final Map<String, InetAddress[]> f22093b = new ConcurrentHashMap();

    /* renamed from: a */
    public void m1625a(String str, InetAddress... inetAddressArr) {
        C5351a.m1321a(str, "Host name");
        C5351a.m1321a(inetAddressArr, "Array of IP addresses");
        this.f22093b.put(str, inetAddressArr);
    }

    @Override // org.p248a.p249a.p261f.AbstractC5103b
    /* renamed from: a */
    public InetAddress[] mo1584a(String str) {
        InetAddress[] inetAddressArr = this.f22093b.get(str);
        if (Log.isLoggable(f22092a, 4)) {
            Log.i(f22092a, "Resolving " + str + " to " + Arrays.deepToString(inetAddressArr));
        }
        if (inetAddressArr == null) {
            throw new UnknownHostException(str + " cannot be resolved");
        }
        return inetAddressArr;
    }
}
