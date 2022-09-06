package com.amap.api.services.core;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import com.facebook.common.util.UriUtil;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.HttpHost;
/* renamed from: com.amap.api.services.core.ac */
/* loaded from: classes.dex */
public class C1165ac {
    /* renamed from: a */
    private static String m17270a() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            th.printStackTrace();
            C1190ay.m17177a(th, "ProxyUtil", "getDefHost");
            str = null;
        }
        return str == null ? "null" : str;
    }

    /* renamed from: a */
    public static HttpHost m17269a(Context context) {
        HttpHost httpHost = null;
        try {
            httpHost = Build.VERSION.SDK_INT >= 11 ? m17268a(context, new URI("http://restapi.amap.com")) : m17265b(context);
        } catch (URISyntaxException e) {
            C1190ay.m17177a(e, "ProxyUtil", "getProxy");
            e.printStackTrace();
        } catch (Throwable th) {
            C1190ay.m17177a(th, "ProxyUtil", "getProxy");
            th.printStackTrace();
        }
        return httpHost;
    }

    /* renamed from: a */
    private static HttpHost m17268a(Context context, URI uri) {
        java.net.Proxy proxy;
        String str;
        InetSocketAddress inetSocketAddress;
        if (C1262z.m16898g(context) == 0) {
            try {
                int i = -1;
                List<java.net.Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty()) {
                    proxy = null;
                } else {
                    proxy = select.get(0);
                    if (proxy == null || proxy.type() == Proxy.Type.DIRECT) {
                        proxy = null;
                    }
                }
                if (proxy == null || (inetSocketAddress = (InetSocketAddress) proxy.address()) == null) {
                    str = null;
                } else {
                    str = inetSocketAddress.getHostName();
                    i = inetSocketAddress.getPort();
                }
                if (m17267a(str, i)) {
                    return new HttpHost(str, i, UriUtil.HTTP_SCHEME);
                }
            } catch (Exception e) {
                C1190ay.m17177a(e, "ProxyUtil", "getProxySelectorCfg");
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m17267a(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    /* renamed from: b */
    private static int m17266b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            C1190ay.m17177a(th, "ProxyUtil", "getDefPort");
            th.printStackTrace();
            return -1;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:37:0x017e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:82)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: b */
    private static org.apache.http.HttpHost m17265b(android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.core.C1165ac.m17265b(android.content.Context):org.apache.http.HttpHost");
    }
}
