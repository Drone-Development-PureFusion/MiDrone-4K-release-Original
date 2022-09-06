package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2524q;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p183l.AbstractC2544q;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.UpgradeResultInfo;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.x */
/* loaded from: classes.dex */
public class C2609x implements Handler.Callback {

    /* renamed from: a */
    private static C2609x f9023a = null;

    /* renamed from: b */
    private static final int f9024b = 0;

    /* renamed from: c */
    private static final int f9025c = 1;

    /* renamed from: d */
    private static final int f9026d = 2;

    /* renamed from: e */
    private static final int f9027e = 3;

    /* renamed from: g */
    private Handler f9029g;

    /* renamed from: i */
    private Context f9031i;

    /* renamed from: f */
    private AbstractC2544q f9028f = new C2524q();

    /* renamed from: h */
    private HashMap<Integer, AbstractC2538k> f9030h = new HashMap<>();

    /* renamed from: com.fimi.soul.biz.n.x$a */
    /* loaded from: classes.dex */
    class RunnableC2610a implements Runnable {

        /* renamed from: b */
        private int f9033b;

        /* renamed from: c */
        private String f9034c;

        /* renamed from: d */
        private UpgradeResultInfo f9035d;

        public RunnableC2610a(int i) {
            this.f9033b = i;
        }

        public RunnableC2610a(int i, UpgradeResultInfo upgradeResultInfo) {
            this.f9033b = i;
            this.f9035d = upgradeResultInfo;
        }

        public RunnableC2610a(int i, String str) {
            this.f9033b = i;
            this.f9034c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2609x.this.f9029g.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f9033b == 0) {
                planeMsg = C2609x.this.f9028f.mo11739a(C2609x.this.f9031i);
            } else if (this.f9033b == 1) {
                planeMsg = C2609x.this.f9028f.mo11737a(C2609x.this.f9031i, this.f9034c);
            } else if (this.f9033b == 2) {
                planeMsg = C2609x.this.f9028f.mo11736b(C2609x.this.f9031i);
            } else if (this.f9033b == 3) {
                planeMsg = C2609x.this.f9028f.mo11738a(C2609x.this.f9031i, this.f9035d);
            }
            obtainMessage.what = this.f9033b;
            obtainMessage.obj = planeMsg;
            C2609x.this.f9029g.sendMessage(obtainMessage);
        }
    }

    public C2609x(Context context) {
        this.f9031i = null;
        this.f9029g = new Handler(context.getMainLooper(), this);
        this.f9031i = context;
    }

    /* renamed from: a */
    public static C2609x m11537a(Context context) {
        if (f9023a == null) {
            f9023a = new C2609x(context);
        }
        return f9023a;
    }

    /* renamed from: a */
    public void m11536a(AbstractC2538k abstractC2538k) {
        this.f9030h.put(0, abstractC2538k);
        C2281x.m12702b(new RunnableC2610a(0));
    }

    /* renamed from: a */
    public void m11535a(AbstractC2538k abstractC2538k, UpgradeResultInfo upgradeResultInfo) {
        this.f9030h.put(3, abstractC2538k);
        C2281x.m12702b(new RunnableC2610a(3, upgradeResultInfo));
    }

    /* renamed from: a */
    public void m11534a(AbstractC2538k abstractC2538k, String str) {
        this.f9030h.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2610a(1, str));
    }

    /* renamed from: b */
    public void m11532b(AbstractC2538k abstractC2538k) {
        this.f9030h.put(2, abstractC2538k);
        C2281x.m12702b(new RunnableC2610a(2));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj == null || this.f9030h.get(Integer.valueOf(message.what)) == null) {
            return false;
        }
        this.f9030h.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
        return false;
    }
}
