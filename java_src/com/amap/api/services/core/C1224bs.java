package com.amap.api.services.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.apache.http.HttpEntity;
/* renamed from: com.amap.api.services.core.bs */
/* loaded from: classes.dex */
public class C1224bs {

    /* renamed from: a */
    private static C1224bs f4142a;

    /* renamed from: b */
    private C1186av f4143b;

    /* renamed from: c */
    private Handler f4144c;

    /* renamed from: com.amap.api.services.core.bs$1 */
    /* loaded from: classes.dex */
    class C12251 extends AbstractRunnableC1188ax {

        /* renamed from: b */
        final /* synthetic */ AbstractC1227bt f4145b;

        /* renamed from: c */
        final /* synthetic */ AbstractC1228bu f4146c;

        /* renamed from: d */
        final /* synthetic */ C1224bs f4147d;

        @Override // com.amap.api.services.core.AbstractRunnableC1188ax
        /* renamed from: a */
        public void mo17046a() {
            try {
                this.f4147d.m17053a(this.f4147d.m17048b(this.f4145b, false), this.f4146c);
            } catch (C1258v e) {
                this.f4147d.m17052a(e, this.f4146c);
            }
        }
    }

    /* renamed from: com.amap.api.services.core.bs$a */
    /* loaded from: classes.dex */
    static class HandlerC1226a extends Handler {
        public HandlerC1226a() {
        }

        private HandlerC1226a(Looper looper) {
            super(looper);
        }

        /* synthetic */ HandlerC1226a(Looper looper, C12251 c12251) {
            this(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        ((C1231bx) message.obj).f4154b.m17041a();
                        break;
                    case 1:
                        C1231bx c1231bx = (C1231bx) message.obj;
                        c1231bx.f4154b.m17040a(c1231bx.f4153a);
                        break;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private C1224bs(boolean z, int i) {
        if (z) {
            try {
                this.f4143b = C1186av.m17187a(i);
            } catch (Throwable th) {
                C1190ay.m17177a(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.f4144c = new HandlerC1226a(Looper.getMainLooper(), null);
        } else {
            this.f4144c = new HandlerC1226a();
        }
    }

    /* renamed from: a */
    public static C1224bs m17051a(boolean z) {
        return m17050a(z, 5);
    }

    /* renamed from: a */
    private static synchronized C1224bs m17050a(boolean z, int i) {
        C1224bs c1224bs;
        synchronized (C1224bs.class) {
            if (f4142a == null) {
                f4142a = new C1224bs(z, i);
            } else if (z && f4142a.f4143b == null) {
                f4142a.f4143b = C1186av.m17187a(i);
            }
            c1224bs = f4142a;
        }
        return c1224bs;
    }

    /* renamed from: a */
    private C1229bv m17054a(AbstractC1227bt abstractC1227bt, boolean z) {
        HttpEntity mo16934e = abstractC1227bt.mo16934e();
        byte[] mo17042e_ = abstractC1227bt.mo17042e_();
        try {
            m17047c(abstractC1227bt);
            C1222bq c1222bq = new C1222bq(abstractC1227bt.f4148e, abstractC1227bt.f4149f, abstractC1227bt.f4150g == null ? null : new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(abstractC1227bt.f4150g.getHostName(), abstractC1227bt.f4150g.getPort())), z);
            return (mo16934e == null && mo17042e_ == null) ? c1222bq.m17060b(abstractC1227bt.mo16813b(), abstractC1227bt.mo16935d_(), abstractC1227bt.mo16937c_()) : mo17042e_ != null ? c1222bq.m17066a(abstractC1227bt.mo16813b(), abstractC1227bt.mo16935d_(), abstractC1227bt.mo16937c_(), mo17042e_) : c1222bq.m17067a(abstractC1227bt.mo16813b(), abstractC1227bt.mo16935d_(), abstractC1227bt.mo16937c_(), mo16934e);
        } catch (C1258v e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new C1258v("未知的错误");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17053a(C1229bv c1229bv, AbstractC1228bu abstractC1228bu) {
        abstractC1228bu.m17039a(c1229bv.f4152b, c1229bv.f4151a);
        C1231bx c1231bx = new C1231bx();
        c1231bx.f4154b = abstractC1228bu;
        Message obtain = Message.obtain();
        obtain.obj = c1231bx;
        obtain.what = 0;
        this.f4144c.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17052a(C1258v c1258v, AbstractC1228bu abstractC1228bu) {
        C1231bx c1231bx = new C1231bx();
        c1231bx.f4153a = c1258v;
        c1231bx.f4154b = abstractC1228bu;
        Message obtain = Message.obtain();
        obtain.obj = c1231bx;
        obtain.what = 1;
        this.f4144c.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public C1229bv m17048b(AbstractC1227bt abstractC1227bt, boolean z) {
        try {
            m17047c(abstractC1227bt);
            return new C1222bq(abstractC1227bt.f4148e, abstractC1227bt.f4149f, abstractC1227bt.f4150g == null ? null : new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(abstractC1227bt.f4150g.getHostName(), abstractC1227bt.f4150g.getPort())), z).m17068a(abstractC1227bt.mo16813b(), abstractC1227bt.mo16935d_(), abstractC1227bt.mo16937c_());
        } catch (C1258v e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new C1258v("未知的错误");
        }
    }

    /* renamed from: c */
    private void m17047c(AbstractC1227bt abstractC1227bt) {
        if (abstractC1227bt == null) {
            throw new C1258v("requeust is null");
        }
        if (abstractC1227bt.mo16813b() != null && !"".equals(abstractC1227bt.mo16813b())) {
            return;
        }
        throw new C1258v("request url is empty");
    }

    /* renamed from: a */
    public byte[] m17055a(AbstractC1227bt abstractC1227bt) {
        try {
            C1229bv m17054a = m17054a(abstractC1227bt, false);
            if (m17054a == null) {
                return null;
            }
            return m17054a.f4151a;
        } catch (C1258v e) {
            throw e;
        } catch (Throwable th) {
            throw new C1258v("未知的错误");
        }
    }

    /* renamed from: b */
    public byte[] m17049b(AbstractC1227bt abstractC1227bt) {
        try {
            C1229bv m17054a = m17054a(abstractC1227bt, true);
            if (m17054a == null) {
                return null;
            }
            return m17054a.f4151a;
        } catch (C1258v e) {
            throw e;
        } catch (Throwable th) {
            throw new C1258v("未知的错误");
        }
    }
}
