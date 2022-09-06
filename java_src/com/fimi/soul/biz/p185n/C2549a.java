package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2507a;
import com.fimi.soul.biz.p183l.AbstractC2528a;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.AddPlane;
import com.fimi.soul.entity.PlaneMsg;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.a */
/* loaded from: classes.dex */
public class C2549a implements Handler.Callback {

    /* renamed from: a */
    private static C2549a f8740a = null;

    /* renamed from: e */
    private static final int f8741e = 1;

    /* renamed from: f */
    private Context f8745f;

    /* renamed from: c */
    private AbstractC2528a f8743c = new C2507a();

    /* renamed from: b */
    private Handler f8742b = new Handler(this);

    /* renamed from: d */
    private HashMap<Integer, AbstractC2538k> f8744d = new HashMap<>();

    /* renamed from: com.fimi.soul.biz.n.a$a */
    /* loaded from: classes.dex */
    class RunnableC2550a implements Runnable {

        /* renamed from: b */
        private int f8747b;

        /* renamed from: c */
        private AddPlane f8748c;

        public RunnableC2550a(int i, AddPlane addPlane) {
            this.f8747b = i;
            this.f8748c = addPlane;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2549a.this.f8742b.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f8747b == 1) {
                planeMsg = C2549a.this.f8743c.mo11797a(this.f8748c, C2549a.this.f8745f);
            }
            obtainMessage.what = this.f8747b;
            obtainMessage.obj = planeMsg;
            C2549a.this.f8742b.sendMessage(obtainMessage);
        }
    }

    public C2549a(Context context) {
        this.f8745f = null;
        this.f8745f = context;
    }

    /* renamed from: a */
    public static C2549a m11725a(Context context) {
        if (f8740a == null) {
            f8740a = new C2549a(context);
        }
        return f8740a;
    }

    /* renamed from: a */
    public void m11723a(AddPlane addPlane, AbstractC2538k abstractC2538k) {
        this.f8744d.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2550a(1, addPlane));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8744d.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return false;
        }
        return false;
    }
}
