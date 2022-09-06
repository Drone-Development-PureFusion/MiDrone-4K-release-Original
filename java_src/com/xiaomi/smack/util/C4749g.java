package com.xiaomi.smack.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4488h;
import com.xiaomi.push.providers.C4579a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* renamed from: com.xiaomi.smack.util.g */
/* loaded from: classes.dex */
public class C4749g {

    /* renamed from: a */
    private static C4488h f19516a = new C4488h(true);

    /* renamed from: b */
    private static int f19517b = -1;

    /* renamed from: c */
    private static final Object f19518c = new Object();

    /* renamed from: d */
    private static List<C4750a> f19519d = Collections.synchronizedList(new ArrayList());

    /* renamed from: e */
    private static String f19520e = "";

    /* renamed from: f */
    private static C4579a f19521f = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.smack.util.g$a */
    /* loaded from: classes2.dex */
    public static class C4750a {

        /* renamed from: a */
        public String f19522a;

        /* renamed from: b */
        public long f19523b;

        /* renamed from: c */
        public int f19524c;

        /* renamed from: d */
        public int f19525d;

        /* renamed from: e */
        public String f19526e;

        /* renamed from: f */
        public long f19527f;

        public C4750a(String str, long j, int i, int i2, String str2, long j2) {
            this.f19522a = "";
            this.f19523b = 0L;
            this.f19524c = -1;
            this.f19525d = -1;
            this.f19526e = "";
            this.f19527f = 0L;
            this.f19522a = str;
            this.f19523b = j;
            this.f19524c = i;
            this.f19525d = i2;
            this.f19526e = str2;
            this.f19527f = j2;
        }

        /* renamed from: a */
        public boolean m3818a(C4750a c4750a) {
            return TextUtils.equals(c4750a.f19522a, this.f19522a) && TextUtils.equals(c4750a.f19526e, this.f19526e) && c4750a.f19524c == this.f19524c && c4750a.f19525d == this.f19525d && Math.abs(c4750a.f19523b - this.f19523b) <= 5000;
        }
    }

    /* renamed from: a */
    private static int m3828a(Context context) {
        if (f19517b == -1) {
            f19517b = m3822b(context);
        }
        return f19517b;
    }

    /* renamed from: a */
    public static int m3824a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e) {
            return str.getBytes().length;
        }
    }

    /* renamed from: a */
    private static long m3829a(int i, long j) {
        return ((i == 0 ? 13 : 11) * j) / 10;
    }

    /* renamed from: a */
    public static void m3827a(Context context, String str, long j, boolean z, long j2) {
        int m3828a;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (m3828a = m3828a(context))) {
            return;
        }
        synchronized (f19518c) {
            isEmpty = f19519d.isEmpty();
            m3825a(new C4750a(str, j2, m3828a, z ? 1 : 0, m3828a == 0 ? m3820c(context) : "", m3829a(m3828a, j)));
        }
        if (!isEmpty) {
            return;
        }
        f19516a.m5014a(new C4751h(context), 5000L);
    }

    /* renamed from: a */
    private static void m3825a(C4750a c4750a) {
        for (C4750a c4750a2 : f19519d) {
            if (c4750a2.m3818a(c4750a)) {
                c4750a2.f19527f += c4750a.f19527f;
                return;
            }
        }
        f19519d.add(c4750a);
    }

    /* renamed from: b */
    private static int m3822b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.getType();
                }
                return -1;
            } catch (Exception e) {
                return -1;
            }
        } catch (Exception e2) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m3821b(Context context, List<C4750a> list) {
        try {
            synchronized (C4579a.f18878a) {
                SQLiteDatabase writableDatabase = m3819d(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (C4750a c4750a : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", c4750a.f19522a);
                    contentValues.put("message_ts", Long.valueOf(c4750a.f19523b));
                    contentValues.put("network_type", Integer.valueOf(c4750a.f19524c));
                    contentValues.put("bytes", Long.valueOf(c4750a.f19527f));
                    contentValues.put("rcv", Integer.valueOf(c4750a.f19525d));
                    contentValues.put("imsi", c4750a.f19526e);
                    writableDatabase.insert("traffic", null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (SQLiteException e) {
            AbstractC4478b.m5039a(e);
        }
    }

    /* renamed from: c */
    private static synchronized String m3820c(Context context) {
        String str;
        synchronized (C4749g.class) {
            if (!TextUtils.isEmpty(f19520e)) {
                str = f19520e;
            } else {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        f19520e = telephonyManager.getSubscriberId();
                    }
                } catch (Exception e) {
                }
                str = f19520e;
            }
        }
        return str;
    }

    /* renamed from: d */
    private static C4579a m3819d(Context context) {
        if (f19521f != null) {
            return f19521f;
        }
        f19521f = new C4579a(context);
        return f19521f;
    }
}
