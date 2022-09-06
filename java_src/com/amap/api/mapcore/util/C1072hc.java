package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* renamed from: com.amap.api.mapcore.util.hc */
/* loaded from: classes.dex */
public class C1072hc extends C1057gx {

    /* renamed from: a */
    private static C1072hc f3361a;

    /* renamed from: b */
    private C1084hl f3362b;

    /* renamed from: c */
    private Handler f3363c;

    /* renamed from: com.amap.api.mapcore.util.hc$1 */
    /* loaded from: classes.dex */
    class C10731 extends AbstractRunnableC1086hm {

        /* renamed from: a */
        final /* synthetic */ AbstractC1075hd f3364a;

        /* renamed from: b */
        final /* synthetic */ AbstractC1076he f3365b;

        /* renamed from: c */
        final /* synthetic */ C1072hc f3366c;

        @Override // com.amap.api.mapcore.util.AbstractRunnableC1086hm
        /* renamed from: a */
        public void mo17658a() {
            try {
                this.f3366c.m17708a(this.f3366c.m17704b(this.f3364a, false), this.f3365b);
            } catch (C0975ex e) {
                this.f3366c.m17711a(e, this.f3365b);
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.hc$a */
    /* loaded from: classes.dex */
    static class HandlerC1074a extends Handler {
        public HandlerC1074a() {
        }

        private HandlerC1074a(Looper looper) {
            super(looper);
        }

        /* synthetic */ HandlerC1074a(Looper looper, C10731 c10731) {
            this(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        ((C1078hg) message.obj).f3374b.m17693a();
                        break;
                    case 1:
                        C1078hg c1078hg = (C1078hg) message.obj;
                        c1078hg.f3374b.m17692a(c1078hg.f3373a);
                        break;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private C1072hc(boolean z, int i) {
        if (z) {
            try {
                this.f3362b = C1084hl.m17665a(i);
            } catch (Throwable th) {
                C1007fo.m18012b(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.f3363c = new HandlerC1074a(Looper.getMainLooper(), null);
        } else {
            this.f3363c = new HandlerC1074a();
        }
    }

    /* renamed from: a */
    public static C1072hc m17707a(boolean z) {
        return m17706a(z, 5);
    }

    /* renamed from: a */
    private static synchronized C1072hc m17706a(boolean z, int i) {
        C1072hc c1072hc;
        synchronized (C1072hc.class) {
            if (f3361a == null) {
                f3361a = new C1072hc(z, i);
            } else if (z && f3361a.f3362b == null) {
                f3361a.f3362b = C1084hl.m17665a(i);
            }
            c1072hc = f3361a;
        }
        return c1072hc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17711a(C0975ex c0975ex, AbstractC1076he abstractC1076he) {
        C1078hg c1078hg = new C1078hg();
        c1078hg.f3373a = c0975ex;
        c1078hg.f3374b = abstractC1076he;
        Message obtain = Message.obtain();
        obtain.obj = c1078hg;
        obtain.what = 1;
        this.f3363c.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17708a(C1077hf c1077hf, AbstractC1076he abstractC1076he) {
        abstractC1076he.m17691a(c1077hf.f3371b, c1077hf.f3370a);
        C1078hg c1078hg = new C1078hg();
        c1078hg.f3374b = abstractC1076he;
        Message obtain = Message.obtain();
        obtain.obj = c1078hg;
        obtain.what = 0;
        this.f3363c.sendMessage(obtain);
    }

    /* renamed from: b */
    public C1077hf m17704b(AbstractC1075hd abstractC1075hd, boolean z) {
        try {
            c(abstractC1075hd);
            return new C1069ha(abstractC1075hd.f3367f, abstractC1075hd.f3368g, abstractC1075hd.f3369h == null ? null : abstractC1075hd.f3369h, z).m17721a(abstractC1075hd.mo17697c(), abstractC1075hd.mo17702a(), abstractC1075hd.mo17699b());
        } catch (C0975ex e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new C0975ex("未知的错误");
        }
    }

    @Override // com.amap.api.mapcore.util.C1057gx
    /* renamed from: b */
    public byte[] mo17705b(AbstractC1075hd abstractC1075hd) {
        try {
            C1077hf a = a(abstractC1075hd, false);
            if (a == null) {
                return null;
            }
            return a.f3370a;
        } catch (C0975ex e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            C1007fo.m18018a().m18010c(th, "NetManager", "makeSyncPostRequest");
            throw new C0975ex("未知的错误");
        }
    }

    /* renamed from: d */
    public byte[] m17703d(AbstractC1075hd abstractC1075hd) {
        try {
            C1077hf m17704b = m17704b(abstractC1075hd, false);
            if (m17704b == null) {
                return null;
            }
            return m17704b.f3370a;
        } catch (C0975ex e) {
            throw e;
        } catch (Throwable th) {
            throw new C0975ex("未知的错误");
        }
    }
}
