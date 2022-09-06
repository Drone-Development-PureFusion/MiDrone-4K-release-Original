package com.mob.commons;

import android.content.Context;
import com.mob.tools.utils.SharePrefrenceHelper;
/* renamed from: com.mob.commons.f */
/* loaded from: classes.dex */
public class C4151f {

    /* renamed from: a */
    private static SharePrefrenceHelper f17319a;

    /* renamed from: a */
    public static synchronized String m6026a(Context context) {
        String string;
        synchronized (C4151f.class) {
            m6011h(context);
            string = f17319a.getString("key_ext_info");
        }
        return string;
    }

    /* renamed from: a */
    public static synchronized void m6025a(Context context, long j) {
        synchronized (C4151f.class) {
            m6011h(context);
            f17319a.putLong("wifi_last_time", Long.valueOf(j));
        }
    }

    /* renamed from: a */
    public static synchronized void m6024a(Context context, String str) {
        synchronized (C4151f.class) {
            m6011h(context);
            f17319a.putString("key_ext_info", str);
        }
    }

    /* renamed from: b */
    public static synchronized long m6023b(Context context) {
        long j;
        synchronized (C4151f.class) {
            m6011h(context);
            j = f17319a.getLong("wifi_last_time");
        }
        return j;
    }

    /* renamed from: b */
    public static synchronized void m6022b(Context context, long j) {
        synchronized (C4151f.class) {
            m6011h(context);
            f17319a.putLong("key_cellinfo_next_total", Long.valueOf(j));
        }
    }

    /* renamed from: b */
    public static synchronized void m6021b(Context context, String str) {
        synchronized (C4151f.class) {
            m6011h(context);
            f17319a.putString("wifi_last_info", str);
        }
    }

    /* renamed from: c */
    public static synchronized String m6020c(Context context) {
        String string;
        synchronized (C4151f.class) {
            m6011h(context);
            string = f17319a.getString("wifi_last_info");
        }
        return string;
    }

    /* renamed from: c */
    public static synchronized void m6019c(Context context, String str) {
        synchronized (C4151f.class) {
            m6011h(context);
            f17319a.putString("key_cellinfo", str);
        }
    }

    /* renamed from: d */
    public static synchronized String m6018d(Context context) {
        String string;
        synchronized (C4151f.class) {
            m6011h(context);
            string = f17319a.getString("key_cellinfo");
        }
        return string;
    }

    /* renamed from: d */
    public static synchronized void m6017d(Context context, String str) {
        synchronized (C4151f.class) {
            m6011h(context);
            f17319a.putString("key_switches", str);
        }
    }

    /* renamed from: e */
    public static synchronized String m6016e(Context context) {
        String string;
        synchronized (C4151f.class) {
            m6011h(context);
            string = f17319a.getString("key_switches");
        }
        return string;
    }

    /* renamed from: e */
    public static synchronized void m6015e(Context context, String str) {
        synchronized (C4151f.class) {
            m6011h(context);
            if (str == null) {
                f17319a.remove("key_data_url");
            } else {
                f17319a.putString("key_data_url", str);
            }
        }
    }

    /* renamed from: f */
    public static synchronized String m6014f(Context context) {
        String string;
        synchronized (C4151f.class) {
            m6011h(context);
            string = f17319a.getString("key_data_url");
        }
        return string;
    }

    /* renamed from: f */
    public static synchronized void m6013f(Context context, String str) {
        synchronized (C4151f.class) {
            m6011h(context);
            if (str == null) {
                f17319a.remove("key_conf_url");
            } else {
                f17319a.putString("key_conf_url", str);
            }
        }
    }

    /* renamed from: g */
    public static synchronized String m6012g(Context context) {
        String string;
        synchronized (C4151f.class) {
            m6011h(context);
            string = f17319a.getString("key_conf_url");
        }
        return string;
    }

    /* renamed from: h */
    private static synchronized void m6011h(Context context) {
        synchronized (C4151f.class) {
            if (f17319a == null) {
                f17319a = new SharePrefrenceHelper(context.getApplicationContext());
                f17319a.open("mob_commons", 1);
            }
        }
    }
}
