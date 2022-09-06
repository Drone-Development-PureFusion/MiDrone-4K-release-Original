package com.fimi.kernel.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
/* renamed from: com.fimi.kernel.utils.z */
/* loaded from: classes.dex */
public class C2284z {

    /* renamed from: a */
    public static final int f7605a = 0;

    /* renamed from: e */
    private static Toast f7609e;

    /* renamed from: i */
    private static Toast f7613i;

    /* renamed from: d */
    private static Context f7608d = null;

    /* renamed from: b */
    public static int f7606b = 1;

    /* renamed from: c */
    public static int f7607c = 0;

    /* renamed from: f */
    private static Handler f7610f = null;

    /* renamed from: g */
    private static Runnable f7611g = new Runnable() { // from class: com.fimi.kernel.utils.z.1
        @Override // java.lang.Runnable
        public void run() {
            C2284z.f7609e.cancel();
        }
    };

    /* renamed from: h */
    private static Handler f7612h = new Handler() { // from class: com.fimi.kernel.utils.z.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    C2284z.m12694a(C2284z.f7608d, message.getData().getString("TEXT"), 1000);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: a */
    public static void m12697a(Context context, int i) {
        f7608d = context;
        Toast.makeText(context, "" + ((Object) context.getResources().getText(i)), 0).show();
    }

    /* renamed from: a */
    public static void m12696a(Context context, int i, int i2) {
        m12694a(context, context.getResources().getString(i), i2);
    }

    /* renamed from: a */
    public static void m12695a(Context context, String str) {
        f7608d = context;
        if (!C2269n.m12889b(str)) {
            Toast.makeText(context, str, 0).show();
        }
    }

    /* renamed from: a */
    public static void m12694a(Context context, String str, int i) {
        if (context == null) {
            return;
        }
        f7610f = new Handler(context.getMainLooper());
        f7610f.removeCallbacks(f7611g);
        if (f7609e != null) {
            f7609e.setText(str);
        } else if (i == 0) {
            f7609e = Toast.makeText(context, str, 0);
        } else {
            f7609e = Toast.makeText(context, str, 1);
        }
        if (1 == i) {
            f7610f.postDelayed(f7611g, 3500L);
        } else if (i == 0) {
            f7610f.postDelayed(f7611g, 2000L);
        } else {
            f7610f.postDelayed(f7611g, i);
        }
        f7609e.show();
    }

    /* renamed from: b */
    public static void m12692b(Context context, int i) {
        f7608d = context;
        Message obtainMessage = f7612h.obtainMessage(0);
        Bundle bundle = new Bundle();
        if (context == null || bundle == null) {
            return;
        }
        bundle.putString("TEXT", context.getResources().getString(i));
        obtainMessage.setData(bundle);
        f7612h.sendMessage(obtainMessage);
    }

    /* renamed from: b */
    public static void m12691b(Context context, int i, int i2) {
        if (context != null) {
            m12689b(context, context.getString(i), i2);
        }
    }

    /* renamed from: b */
    public static void m12690b(Context context, String str) {
        f7608d = context;
        Message obtainMessage = f7612h.obtainMessage(0);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT", str);
        obtainMessage.setData(bundle);
        f7612h.sendMessage(obtainMessage);
    }

    /* renamed from: b */
    public static void m12689b(Context context, String str, int i) {
        if (context == null) {
            return;
        }
        if (f7613i != null) {
            f7613i.setText(str);
        } else if (i == 0) {
            f7613i = Toast.makeText(context, str, 0);
        } else if (i == 1) {
            f7613i = Toast.makeText(context, str, 1);
        }
        f7613i.show();
    }
}
