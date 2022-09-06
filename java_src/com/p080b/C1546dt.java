package com.p080b;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
/* renamed from: com.b.dt */
/* loaded from: classes.dex */
public class C1546dt {
    /* renamed from: a */
    private static String m15590a() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            C1450b.m16187a(th, "ProxyUtil", "getDefHost");
            str = null;
        }
        return str == null ? "null" : str;
    }

    /* renamed from: a */
    public static java.net.Proxy m15589a(Context context) {
        java.net.Proxy proxy = null;
        try {
            proxy = Build.VERSION.SDK_INT >= 11 ? m15588a(context, new URI("http://restapi.amap.com")) : m15585b(context);
        } catch (URISyntaxException e) {
            C1450b.m16187a(e, "ProxyUtil", "getProxy");
        } catch (Throwable th) {
            C1450b.m16187a(th, "ProxyUtil", "getProxy");
        }
        return proxy;
    }

    /* renamed from: a */
    private static java.net.Proxy m15588a(Context context, URI uri) {
        if (C1542dq.m15619m(context) == 0) {
            try {
                List<java.net.Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty()) {
                    return null;
                }
                java.net.Proxy proxy = select.get(0);
                if (proxy != null) {
                    if (proxy.type() != Proxy.Type.DIRECT) {
                        return proxy;
                    }
                }
                return null;
            } catch (Throwable th) {
                C1450b.m16187a(th, "ProxyUtil", "getProxySelectorCfg");
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m15587a(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    /* renamed from: b */
    private static int m15586b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            C1450b.m16187a(th, "ProxyUtil", "getDefPort");
            return -1;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:36:0x016d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:82)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: b */
    private static java.net.Proxy m15585b(android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p080b.C1546dt.m15585b(android.content.Context):java.net.Proxy");
    }
}
