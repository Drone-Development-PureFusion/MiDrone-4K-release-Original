package com.tencent.open.p229b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.open.p228a.C4331f;
/* renamed from: com.tencent.open.b.a */
/* loaded from: classes2.dex */
public class C4337a {

    /* renamed from: a */
    protected static final String f18128a = C4337a.class.getName();

    /* renamed from: b */
    protected static final Uri f18129b = Uri.parse("content://telephony/carriers/preferapn");

    /* renamed from: a */
    public static String m5425a(Context context) {
        int m5422d = m5422d(context);
        if (m5422d == 2) {
            return "wifi";
        }
        if (m5422d == 1) {
            return "cmwap";
        }
        if (m5422d == 4) {
            return "cmnet";
        }
        if (m5422d == 16) {
            return "uniwap";
        }
        if (m5422d == 8) {
            return "uninet";
        }
        if (m5422d == 64) {
            return "wap";
        }
        if (m5422d == 32) {
            return "net";
        }
        if (m5422d == 512) {
            return "ctwap";
        }
        if (m5422d == 256) {
            return "ctnet";
        }
        if (m5422d == 2048) {
            return "3gnet";
        }
        if (m5422d == 1024) {
            return "3gwap";
        }
        String m5424b = m5424b(context);
        return (m5424b == null || m5424b.length() == 0) ? "none" : m5424b;
    }

    /* renamed from: b */
    public static String m5424b(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f18129b, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            String string = query.getString(query.getColumnIndex("apn"));
            if (query == null) {
                return string;
            }
            query.close();
            return string;
        } catch (SecurityException e) {
            C4331f.m5439e(f18128a, "getApn has exception: " + e.getMessage());
            return "";
        }
    }

    /* renamed from: c */
    public static String m5423c(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f18129b, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            String string = query.getString(query.getColumnIndex("proxy"));
            if (query == null) {
                return string;
            }
            query.close();
            return string;
        } catch (SecurityException e) {
            C4331f.m5439e(f18128a, "getApnProxy has exception: " + e.getMessage());
            return "";
        }
    }

    /* renamed from: d */
    public static int m5422d(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            C4331f.m5439e(f18128a, "getMProxyType has exception: " + e.getMessage());
        }
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            if (activeNetworkInfo.getTypeName().toUpperCase().equals("WIFI")) {
                return 2;
            }
            String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
            if (lowerCase.startsWith("cmwap")) {
                return 1;
            }
            if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("epc.tmobile.com")) {
                return 4;
            }
            if (lowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (lowerCase.startsWith("uninet")) {
                return 8;
            }
            if (lowerCase.startsWith("wap")) {
                return 64;
            }
            if (lowerCase.startsWith("net")) {
                return 32;
            }
            if (lowerCase.startsWith("ctwap")) {
                return 512;
            }
            if (lowerCase.startsWith("ctnet")) {
                return 256;
            }
            if (lowerCase.startsWith("3gwap")) {
                return 1024;
            }
            if (lowerCase.startsWith("3gnet")) {
                return 2048;
            }
            if (lowerCase.startsWith("#777")) {
                String m5423c = m5423c(context);
                if (m5423c != null) {
                    if (m5423c.length() > 0) {
                        return 512;
                    }
                }
                return 256;
            }
            return 128;
        }
        return 128;
    }

    /* renamed from: e */
    public static String m5421e(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "MOBILE" : activeNetworkInfo.getTypeName();
    }
}
