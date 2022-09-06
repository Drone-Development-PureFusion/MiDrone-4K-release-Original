package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2508b;
import com.fimi.soul.biz.p183l.AbstractC2530c;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.BroadcastComment;
import com.fimi.soul.entity.PlaneMsg;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.c */
/* loaded from: classes.dex */
public class C2556c implements Handler.Callback {

    /* renamed from: a */
    private static C2556c f8786a = null;

    /* renamed from: b */
    private static final int f8787b = 1;

    /* renamed from: c */
    private static final int f8788c = 2;

    /* renamed from: d */
    private static final int f8789d = 4;

    /* renamed from: e */
    private static final int f8790e = 3;

    /* renamed from: h */
    private Context f8793h;

    /* renamed from: f */
    private AbstractC2530c f8791f = new C2508b();

    /* renamed from: g */
    private Handler f8792g = new Handler(this);

    /* renamed from: i */
    private HashMap<Integer, AbstractC2538k> f8794i = new HashMap<>();

    /* renamed from: com.fimi.soul.biz.n.c$a */
    /* loaded from: classes.dex */
    class RunnableC2557a implements Runnable {

        /* renamed from: b */
        private int f8796b;

        /* renamed from: c */
        private BroadcastComment f8797c;

        /* renamed from: d */
        private String f8798d;

        /* renamed from: e */
        private int f8799e;

        public RunnableC2557a(int i, String str, int i2, BroadcastComment broadcastComment) {
            this.f8796b = i;
            this.f8797c = broadcastComment;
            this.f8798d = str;
            this.f8799e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2556c.this.f8792g.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f8796b == 1) {
                planeMsg = C2556c.this.f8791f.mo11793a(C2556c.this.f8793h, this.f8797c);
            } else if (this.f8796b == 3) {
                planeMsg = C2556c.this.f8791f.mo11788b(C2556c.this.f8793h, this.f8798d, this.f8799e);
            } else if (this.f8796b == 2) {
                planeMsg = C2556c.this.f8791f.mo11791a(C2556c.this.f8793h, this.f8798d, this.f8797c.getUserID());
            } else if (this.f8796b == 4) {
                planeMsg = C2556c.this.f8791f.mo11787b(C2556c.this.f8793h, this.f8798d, this.f8797c.getUserID());
            }
            obtainMessage.what = this.f8796b;
            obtainMessage.obj = planeMsg;
            C2556c.this.f8792g.sendMessage(obtainMessage);
        }
    }

    public C2556c(Context context) {
        this.f8793h = null;
        this.f8793h = context;
    }

    /* renamed from: a */
    public static C2556c m11705a(Context context) {
        if (f8786a == null) {
            f8786a = new C2556c(context);
        }
        return f8786a;
    }

    /* renamed from: a */
    public void m11703a(BroadcastComment broadcastComment, AbstractC2538k abstractC2538k) {
        this.f8794i.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2557a(1, null, 1, broadcastComment));
    }

    /* renamed from: a */
    public void m11702a(String str, int i, AbstractC2538k abstractC2538k) {
        this.f8794i.put(3, abstractC2538k);
        C2281x.m12702b(new RunnableC2557a(3, str, i, null));
    }

    /* renamed from: a */
    public void m11701a(String str, String str2, AbstractC2538k abstractC2538k) {
        BroadcastComment broadcastComment = new BroadcastComment();
        broadcastComment.setUserID(str2);
        this.f8794i.put(2, abstractC2538k);
        C2281x.m12702b(new RunnableC2557a(2, str, 1, broadcastComment));
    }

    /* renamed from: b */
    public void m11699b(String str, String str2, AbstractC2538k abstractC2538k) {
        BroadcastComment broadcastComment = new BroadcastComment();
        broadcastComment.setUserID(str2);
        this.f8794i.put(4, abstractC2538k);
        C2281x.m12702b(new RunnableC2557a(4, str, 1, broadcastComment));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8794i.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return false;
        }
        return false;
    }
}
