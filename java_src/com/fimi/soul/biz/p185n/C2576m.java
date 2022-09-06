package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2519l;
import com.fimi.soul.biz.p183l.AbstractC2536i;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.Plane;
import com.fimi.soul.entity.PlaneMsg;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.m */
/* loaded from: classes.dex */
public class C2576m implements Handler.Callback {

    /* renamed from: a */
    private static C2576m f8888a = null;

    /* renamed from: b */
    private static final int f8889b = 0;

    /* renamed from: c */
    private static final int f8890c = 1;

    /* renamed from: d */
    private static final int f8891d = 2;

    /* renamed from: e */
    private AbstractC2536i f8892e = new C2519l();

    /* renamed from: f */
    private Handler f8893f = new Handler(this);

    /* renamed from: g */
    private Context f8894g;

    /* renamed from: h */
    private HashMap<Integer, AbstractC2538k> f8895h;

    /* renamed from: com.fimi.soul.biz.n.m$a */
    /* loaded from: classes.dex */
    class RunnableC2577a implements Runnable {

        /* renamed from: b */
        private int f8897b;

        /* renamed from: c */
        private Plane f8898c;

        public RunnableC2577a(int i, Plane plane) {
            this.f8897b = i;
            this.f8898c = plane;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2576m.this.f8893f.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f8897b == 0) {
                planeMsg = C2576m.this.f8892e.a(C2576m.this.f8894g);
            } else if (this.f8897b == 1) {
                planeMsg = C2576m.this.f8892e.mo11773a(this.f8898c, C2576m.this.f8894g);
            } else if (this.f8897b == 2) {
            }
            obtainMessage.what = this.f8897b;
            obtainMessage.obj = planeMsg;
            C2576m.this.f8893f.sendMessage(obtainMessage);
        }
    }

    public C2576m(Context context) {
        this.f8894g = null;
        this.f8894g = context;
    }

    /* renamed from: a */
    public static C2576m m11633a(Context context) {
        if (f8888a == null) {
            f8888a = new C2576m(context);
        }
        return f8888a;
    }

    /* renamed from: a */
    public void m11632a(AbstractC2538k abstractC2538k) {
        this.f8895h.put(0, abstractC2538k);
        C2281x.m12702b(new RunnableC2577a(0, null));
    }

    /* renamed from: a */
    public void m11630a(Plane plane, AbstractC2538k abstractC2538k) {
        this.f8895h.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2577a(1, plane));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8895h.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return false;
        }
        return false;
    }
}
