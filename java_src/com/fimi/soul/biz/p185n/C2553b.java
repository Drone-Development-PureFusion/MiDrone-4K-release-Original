package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2508b;
import com.fimi.soul.biz.p183l.AbstractC2530c;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.BroadcastMode;
import com.fimi.soul.entity.PlaneMsg;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.b */
/* loaded from: classes.dex */
public class C2553b implements Handler.Callback {

    /* renamed from: a */
    private static C2553b f8760a = null;

    /* renamed from: b */
    private static final int f8761b = 0;

    /* renamed from: c */
    private static final int f8762c = 3;

    /* renamed from: d */
    private static final int f8763d = 5;

    /* renamed from: e */
    private static final int f8764e = 6;

    /* renamed from: f */
    private static final int f8765f = 7;

    /* renamed from: g */
    private static final int f8766g = 9;

    /* renamed from: h */
    private static final int f8767h = 10;

    /* renamed from: i */
    private static final int f8768i = 8;

    /* renamed from: j */
    private static final int f8769j = 1;

    /* renamed from: k */
    private static final int f8770k = 4;

    /* renamed from: l */
    private static final int f8771l = 2;

    /* renamed from: o */
    private Context f8774o;

    /* renamed from: m */
    private AbstractC2530c f8772m = new C2508b();

    /* renamed from: n */
    private Handler f8773n = new Handler(this);

    /* renamed from: p */
    private HashMap<Integer, AbstractC2538k> f8775p = new HashMap<>();

    /* renamed from: com.fimi.soul.biz.n.b$a */
    /* loaded from: classes.dex */
    class RunnableC2554a implements Runnable {

        /* renamed from: b */
        private int f8777b;

        /* renamed from: c */
        private BroadcastMode f8778c;

        /* renamed from: d */
        private String f8779d;

        /* renamed from: e */
        private int f8780e;

        public RunnableC2554a(int i, String str, int i2, BroadcastMode broadcastMode) {
            this.f8777b = i;
            this.f8778c = broadcastMode;
            this.f8779d = str;
            this.f8780e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2553b.this.f8773n.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f8777b == 0) {
                planeMsg = C2553b.this.f8772m.a(C2553b.this.f8774o);
            } else if (this.f8777b == 1) {
                planeMsg = C2553b.this.f8772m.mo11790a(this.f8778c, C2553b.this.f8774o);
            } else if (this.f8777b == 3) {
                planeMsg = C2553b.this.f8772m.mo11792a(C2553b.this.f8774o, this.f8779d, this.f8780e);
            } else if (this.f8777b == 6) {
                planeMsg = C2553b.this.f8772m.mo11794a(C2553b.this.f8774o, this.f8780e);
            } else if (this.f8777b == 5) {
                planeMsg = C2553b.this.f8772m.mo11789b(C2553b.this.f8774o, this.f8780e);
            } else if (this.f8777b == 7) {
                planeMsg = C2553b.this.f8772m.mo11785c(C2553b.this.f8774o, this.f8779d, this.f8780e);
            } else if (this.f8777b == 8) {
                planeMsg = C2553b.this.f8772m.mo11786b(this.f8778c, C2553b.this.f8774o);
            } else if (this.f8777b == 9) {
                planeMsg = C2553b.this.f8772m.mo11784c(this.f8778c, C2553b.this.f8774o);
            } else if (this.f8777b == 10) {
                planeMsg = C2553b.this.f8772m.mo11783c(this.f8778c.getBroadcastID(), C2553b.this.f8774o);
            }
            obtainMessage.what = this.f8777b;
            obtainMessage.obj = planeMsg;
            C2553b.this.f8773n.sendMessage(obtainMessage);
        }
    }

    /* renamed from: com.fimi.soul.biz.n.b$b */
    /* loaded from: classes.dex */
    public enum EnumC2555b {
        BYUSERID,
        RECENT,
        HOT,
        FOLLOW
    }

    public C2553b(Context context) {
        this.f8774o = null;
        this.f8774o = context;
    }

    /* renamed from: a */
    public static C2553b m11715a(Context context) {
        if (f8760a == null) {
            f8760a = new C2553b(context);
        }
        return f8760a;
    }

    /* renamed from: a */
    public void m11714a(AbstractC2538k abstractC2538k) {
        this.f8775p.put(0, abstractC2538k);
        C2281x.m12702b(new RunnableC2554a(0, null, 1, null));
    }

    /* renamed from: a */
    public void m11712a(BroadcastMode broadcastMode, AbstractC2538k abstractC2538k) {
        this.f8775p.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2554a(1, null, 1, broadcastMode));
    }

    /* renamed from: a */
    public void m11711a(String str, int i, EnumC2555b enumC2555b, AbstractC2538k abstractC2538k) {
        if (enumC2555b == EnumC2555b.BYUSERID) {
            this.f8775p.put(3, abstractC2538k);
            C2281x.m12702b(new RunnableC2554a(3, str, i, null));
        } else if (enumC2555b == EnumC2555b.FOLLOW) {
            this.f8775p.put(7, abstractC2538k);
            C2281x.m12702b(new RunnableC2554a(7, str, i, null));
        } else if (enumC2555b == EnumC2555b.HOT) {
            this.f8775p.put(5, abstractC2538k);
            C2281x.m12702b(new RunnableC2554a(5, str, i, null));
        } else if (enumC2555b != EnumC2555b.RECENT) {
        } else {
            this.f8775p.put(6, abstractC2538k);
            C2281x.m12702b(new RunnableC2554a(6, str, i, null));
        }
    }

    /* renamed from: a */
    public void m11710a(String str, AbstractC2538k abstractC2538k) {
        BroadcastMode broadcastMode = new BroadcastMode();
        broadcastMode.setBroadcastID(str);
        this.f8775p.put(10, abstractC2538k);
        C2281x.m12702b(new RunnableC2554a(10, null, 1, broadcastMode));
    }

    /* renamed from: b */
    public void m11708b(BroadcastMode broadcastMode, AbstractC2538k abstractC2538k) {
        this.f8775p.put(8, abstractC2538k);
        C2281x.m12702b(new RunnableC2554a(8, null, 1, broadcastMode));
    }

    /* renamed from: c */
    public void m11706c(BroadcastMode broadcastMode, AbstractC2538k abstractC2538k) {
        this.f8775p.put(9, abstractC2538k);
        C2281x.m12702b(new RunnableC2554a(9, null, 1, broadcastMode));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8775p.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return false;
        }
        return false;
    }
}
