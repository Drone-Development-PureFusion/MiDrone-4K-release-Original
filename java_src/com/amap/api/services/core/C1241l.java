package com.amap.api.services.core;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* renamed from: com.amap.api.services.core.l */
/* loaded from: classes.dex */
public class C1241l {

    /* renamed from: a */
    public static C1166ad f4158a;

    /* renamed from: b */
    private static C1241l f4159b;

    /* renamed from: c */
    private static Context f4160c;

    /* renamed from: d */
    private HandlerC1242a f4161d;

    /* renamed from: e */
    private HandlerThread f4162e = new HandlerThreadC1243m(this, "manifestThread");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.services.core.l$a */
    /* loaded from: classes.dex */
    public class HandlerC1242a extends Handler {

        /* renamed from: a */
        String f4163a = "handleMessage";

        public HandlerC1242a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            switch (message.what) {
                case 3:
                    try {
                        C1245o c1245o = (C1245o) message.obj;
                        if (c1245o == null) {
                            c1245o = new C1245o(false, false);
                        }
                        C1190ay.m17181a(C1241l.f4160c, C1232c.m17037a(c1245o.m16953a()));
                        C1241l.f4158a = C1232c.m17037a(c1245o.m16953a());
                        return;
                    } catch (Throwable th) {
                        C1233d.m17031a(th, "ManifestConfig", this.f4163a);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private C1241l(Context context) {
        f4160c = context;
        f4158a = C1232c.m17037a(false);
        try {
            this.f4162e.start();
            this.f4161d = new HandlerC1242a(Looper.getMainLooper());
        } catch (Throwable th) {
            C1233d.m17031a(th, "ManifestConfig", "ManifestConfig");
        }
    }

    /* renamed from: a */
    public static C1241l m16960a(Context context) {
        if (f4159b == null) {
            f4159b = new C1241l(context);
        }
        return f4159b;
    }
}
