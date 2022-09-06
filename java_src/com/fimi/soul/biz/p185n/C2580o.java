package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2521n;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.PlaneMsg;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.o */
/* loaded from: classes.dex */
public class C2580o implements Handler.Callback {

    /* renamed from: a */
    private static C2580o f8908a = null;

    /* renamed from: b */
    private static final int f8909b = 0;

    /* renamed from: c */
    private static final int f8910c = 1;

    /* renamed from: d */
    private static final int f8911d = 2;

    /* renamed from: e */
    private static final int f8912e = 3;

    /* renamed from: g */
    private C2521n f8914g;

    /* renamed from: h */
    private Handler f8915h = new Handler(this);

    /* renamed from: f */
    private HashMap<Integer, AbstractC2538k> f8913f = new HashMap<>();

    /* renamed from: com.fimi.soul.biz.n.o$a */
    /* loaded from: classes.dex */
    class RunnableC2581a implements Runnable {

        /* renamed from: a */
        String f8916a;

        /* renamed from: b */
        String f8917b;

        /* renamed from: d */
        private int f8919d;

        public RunnableC2581a(int i, String str, String str2) {
            this.f8919d = i;
            this.f8917b = str2;
            this.f8916a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2580o.this.f8915h.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f8919d == 0) {
                planeMsg = C2580o.this.f8914g.mo11769c();
                if (planeMsg.isSuccess()) {
                    planeMsg = C2580o.this.f8914g.mo11770b();
                }
            } else if (this.f8919d == 1) {
                planeMsg = C2580o.this.f8914g.mo11771a(this.f8916a, this.f8917b);
            } else if (this.f8919d == 2) {
                planeMsg = C2580o.this.f8914g.mo11769c();
            } else if (this.f8919d == 3) {
                planeMsg = C2580o.this.f8914g.mo11768d();
            }
            obtainMessage.what = this.f8919d;
            obtainMessage.obj = planeMsg;
            C2580o.this.f8915h.sendMessage(obtainMessage);
        }
    }

    public C2580o(Context context) {
        this.f8914g = new C2521n(context);
    }

    /* renamed from: a */
    public static C2580o m11621a(Context context) {
        if (f8908a == null) {
            f8908a = new C2580o(context);
        }
        return f8908a;
    }

    /* renamed from: a */
    public String m11622a() {
        return this.f8914g.m11803a();
    }

    /* renamed from: a */
    public void m11620a(AbstractC2538k abstractC2538k) {
        this.f8913f.put(0, abstractC2538k);
        C2281x.m12702b(new RunnableC2581a(0, null, null));
    }

    /* renamed from: a */
    public void m11618a(String str) {
        this.f8914g.m11802a(str);
    }

    /* renamed from: a */
    public void m11617a(String str, String str2, AbstractC2538k abstractC2538k) {
        this.f8913f.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2581a(1, str, str2));
    }

    /* renamed from: b */
    public void m11616b(AbstractC2538k abstractC2538k) {
        this.f8913f.put(2, abstractC2538k);
        C2281x.m12702b(new RunnableC2581a(2, null, null));
    }

    /* renamed from: c */
    public void m11614c(AbstractC2538k abstractC2538k) {
        this.f8913f.put(3, abstractC2538k);
        C2281x.m12702b(new RunnableC2581a(3, null, null));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8913f.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return true;
        }
        return true;
    }
}
