package org.p248a.p249a.p268i.p271c;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p261f.AbstractC5131i;
@AbstractC5005b
/* renamed from: org.a.a.i.c.t */
/* loaded from: classes2.dex */
public class C5230t extends C5217j {

    /* renamed from: a */
    private final ProxySelector f22119a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.a.a.i.c.t$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C52311 {

        /* renamed from: a */
        static final /* synthetic */ int[] f22120a = new int[Proxy.Type.values().length];

        static {
            try {
                f22120a[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22120a[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22120a[Proxy.Type.SOCKS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public C5230t(ProxySelector proxySelector) {
        this(null, proxySelector);
    }

    public C5230t(AbstractC5131i abstractC5131i, ProxySelector proxySelector) {
        super(abstractC5131i);
        this.f22119a = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
    }

    /* renamed from: a */
    private String m1583a(InetSocketAddress inetSocketAddress) {
        return inetSocketAddress.isUnresolved() ? inetSocketAddress.getHostName() : inetSocketAddress.getAddress().getHostAddress();
    }

    /* renamed from: a */
    private Proxy m1582a(List<Proxy> list) {
        Proxy proxy = null;
        int i = 0;
        while (proxy == null && i < list.size()) {
            Proxy proxy2 = list.get(i);
            switch (C52311.f22120a[proxy2.type().ordinal()]) {
                case 1:
                case 2:
                    break;
                default:
                    proxy2 = proxy;
                    break;
            }
            i++;
            proxy = proxy2;
        }
        return proxy == null ? Proxy.NO_PROXY : proxy;
    }

    @Override // org.p248a.p249a.p268i.p271c.C5217j
    /* renamed from: a */
    protected HttpHost mo1581a(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        try {
            Proxy m1582a = m1582a(this.f22119a.select(new URI(httpHost.toURI())));
            if (m1582a.type() != Proxy.Type.HTTP) {
                return null;
            }
            if (!(m1582a.address() instanceof InetSocketAddress)) {
                throw new HttpException("Unable to handle non-Inet proxy address: " + m1582a.address());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) m1582a.address();
            return new HttpHost(m1583a(inetSocketAddress), inetSocketAddress.getPort());
        } catch (URISyntaxException e) {
            throw new HttpException("Cannot convert host to URI: " + httpHost, e);
        }
    }
}
