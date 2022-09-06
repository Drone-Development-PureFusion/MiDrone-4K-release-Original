package com.amap.api.mapcore.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.Locale;
/* renamed from: com.amap.api.mapcore.util.ff */
/* loaded from: classes.dex */
public class C0993ff {
    /* renamed from: a */
    private static String m18086a() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            C1002fl.m18028a(th, "ProxyUtil", "getDefHost");
            str = null;
        }
        return str == null ? "null" : str;
    }

    /* renamed from: a */
    public static String m18083a(String str) {
        return C0999fi.m18040c(str);
    }

    /* renamed from: a */
    public static java.net.Proxy m18085a(Context context) {
        java.net.Proxy proxy = null;
        try {
            proxy = Build.VERSION.SDK_INT >= 11 ? m18084a(context, new URI("http://restapi.amap.com")) : m18080b(context);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "ProxyUtil", "getProxy");
        }
        return proxy;
    }

    /* renamed from: a */
    private static java.net.Proxy m18084a(Context context, URI uri) {
        if (m18079c(context)) {
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
                C1002fl.m18028a(th, "ProxyUtil", "getProxySelectorCfg");
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m18082a(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    /* renamed from: b */
    private static int m18081b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            C1002fl.m18028a(th, "ProxyUtil", "getDefPort");
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0070 A[Catch: Throwable -> 0x0162, TRY_LEAVE, TryCatch #6 {Throwable -> 0x0162, blocks: (B:10:0x006a, B:12:0x0070), top: B:9:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c6 A[Catch: all -> 0x0172, TryCatch #12 {all -> 0x0172, blocks: (B:49:0x00b9, B:51:0x00c6, B:53:0x00dc, B:55:0x00e2, B:59:0x00ee, B:68:0x010b, B:70:0x0113, B:72:0x0119, B:76:0x0124), top: B:48:0x00b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.net.Proxy m18080b(Context context) {
        Cursor cursor;
        String str;
        Cursor cursor2;
        int i;
        String m18115o;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        int i2 = -1;
        if (m18079c(context)) {
            Cursor cursor3 = null;
            try {
                try {
                    cursor = context.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                } catch (Throwable th) {
                    th = th;
                    if (cursor3 != null) {
                        try {
                            cursor3.close();
                        } catch (Throwable th2) {
                            C1002fl.m18028a(th2, "ProxyUtil", "getHostProxy2");
                            th2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (SecurityException e) {
                e = e;
                cursor2 = null;
                i = -1;
                str = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                str = null;
            }
            try {
                if (cursor != null) {
                    try {
                    } catch (SecurityException e2) {
                        e = e2;
                        cursor2 = cursor;
                        str = null;
                        i = -1;
                    } catch (Throwable th4) {
                        th = th4;
                        str = null;
                    }
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndex("apn"));
                        if (string != null) {
                            string = string.toLowerCase(Locale.US);
                        }
                        if (string != null && string.contains("ctwap")) {
                            str = m18086a();
                            int m18081b = m18081b();
                            try {
                                if (!TextUtils.isEmpty(str)) {
                                    if (!str.equals("null")) {
                                        z3 = true;
                                        if (!z3) {
                                            try {
                                                str = m18083a("QMTAuMC4wLjIwMA==");
                                            } catch (SecurityException e3) {
                                                cursor2 = cursor;
                                                i = m18081b;
                                                e = e3;
                                                C1002fl.m18028a(e, "ProxyUtil", "getHostProxy");
                                                m18115o = C0989fc.m18115o(context);
                                                if (m18115o != null) {
                                                    String lowerCase = m18115o.toLowerCase(Locale.US);
                                                    String m18086a = m18086a();
                                                    i = m18081b();
                                                    if (lowerCase.indexOf("ctwap") != -1) {
                                                        if (!TextUtils.isEmpty(m18086a) && !m18086a.equals("null")) {
                                                            z4 = true;
                                                            str = m18086a;
                                                        }
                                                        if (!z4) {
                                                            str = m18083a("QMTAuMC4wLjIwMA==");
                                                        }
                                                        if (i == -1) {
                                                            i2 = 80;
                                                        }
                                                    } else if (lowerCase.indexOf("wap") != -1) {
                                                        if (TextUtils.isEmpty(m18086a) || m18086a.equals("null")) {
                                                            z = false;
                                                            m18086a = str;
                                                        } else {
                                                            z = true;
                                                        }
                                                        if (!z) {
                                                            m18086a = m18083a("QMTAuMC4wLjE3Mg==");
                                                        }
                                                        i2 = 80;
                                                        str = m18086a;
                                                    }
                                                    if (cursor2 != null) {
                                                        try {
                                                            cursor2.close();
                                                        } catch (Throwable th5) {
                                                            C1002fl.m18028a(th5, "ProxyUtil", "getHostProxy2");
                                                            th5.printStackTrace();
                                                        }
                                                    }
                                                    if (m18082a(str, i2)) {
                                                    }
                                                    return null;
                                                }
                                                i2 = i;
                                                if (cursor2 != null) {
                                                }
                                                if (m18082a(str, i2)) {
                                                }
                                                return null;
                                            } catch (Throwable th6) {
                                                i2 = m18081b;
                                                th = th6;
                                                C1002fl.m18028a(th, "ProxyUtil", "getHostProxy1");
                                                th.printStackTrace();
                                                if (cursor != null) {
                                                    try {
                                                        cursor.close();
                                                    } catch (Throwable th7) {
                                                        C1002fl.m18028a(th7, "ProxyUtil", "getHostProxy2");
                                                        th7.printStackTrace();
                                                    }
                                                }
                                                if (m18082a(str, i2)) {
                                                }
                                                return null;
                                            }
                                        }
                                        if (m18081b == -1) {
                                            m18081b = 80;
                                        }
                                        i2 = m18081b;
                                    }
                                }
                                z3 = false;
                                str = null;
                                if (!z3) {
                                }
                                if (m18081b == -1) {
                                }
                                i2 = m18081b;
                            } catch (SecurityException e4) {
                                str = null;
                                i = m18081b;
                                e = e4;
                                cursor2 = cursor;
                            } catch (Throwable th8) {
                                i2 = m18081b;
                                str = null;
                                th = th8;
                            }
                        } else if (string != null && string.contains("wap")) {
                            str = m18086a();
                            int m18081b2 = m18081b();
                            try {
                                if (!TextUtils.isEmpty(str)) {
                                    if (!str.equals("null")) {
                                        z2 = true;
                                        if (!z2) {
                                            try {
                                                str = m18083a("QMTAuMC4wLjE3Mg==");
                                            } catch (SecurityException e5) {
                                                e = e5;
                                                i = m18081b2;
                                                cursor2 = cursor;
                                                try {
                                                    C1002fl.m18028a(e, "ProxyUtil", "getHostProxy");
                                                    m18115o = C0989fc.m18115o(context);
                                                    if (m18115o != null) {
                                                    }
                                                    i2 = i;
                                                    if (cursor2 != null) {
                                                    }
                                                    if (m18082a(str, i2)) {
                                                    }
                                                    return null;
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    cursor3 = cursor2;
                                                    if (cursor3 != null) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th10) {
                                                th = th10;
                                                i2 = m18081b2;
                                                C1002fl.m18028a(th, "ProxyUtil", "getHostProxy1");
                                                th.printStackTrace();
                                                if (cursor != null) {
                                                }
                                                if (m18082a(str, i2)) {
                                                }
                                                return null;
                                            }
                                        }
                                        i2 = m18081b2 != -1 ? 80 : m18081b2;
                                    }
                                }
                                z2 = false;
                                str = null;
                                if (!z2) {
                                }
                                if (m18081b2 != -1) {
                                }
                            } catch (SecurityException e6) {
                                e = e6;
                                str = null;
                                cursor2 = cursor;
                                i = m18081b2;
                            } catch (Throwable th11) {
                                th = th11;
                                i2 = m18081b2;
                                str = null;
                            }
                        }
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th12) {
                                C1002fl.m18028a(th12, "ProxyUtil", "getHostProxy2");
                                th12.printStackTrace();
                            }
                        }
                        if (m18082a(str, i2)) {
                            return new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i2));
                        }
                    }
                }
                if (m18082a(str, i2)) {
                }
            } catch (Throwable th13) {
                C1002fl.m18028a(th13, "ProxyUtil", "getHostProxy2");
                th13.printStackTrace();
            }
            str = null;
            if (cursor != null) {
            }
        }
        return null;
    }

    /* renamed from: c */
    private static boolean m18079c(Context context) {
        return C0989fc.m18117m(context) == 0;
    }
}
