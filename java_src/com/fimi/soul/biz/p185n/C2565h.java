package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2516i;
import com.fimi.soul.biz.p183l.AbstractC2533f;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.PlaneMsg;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.h */
/* loaded from: classes.dex */
public class C2565h implements Handler.Callback {

    /* renamed from: a */
    private static final int f8832a = 0;

    /* renamed from: f */
    private static C2565h f8833f;

    /* renamed from: b */
    private Context f8834b;

    /* renamed from: c */
    private Handler f8835c = new Handler(this);

    /* renamed from: d */
    private HashMap<Integer, AbstractC2538k> f8836d = new HashMap<>();

    /* renamed from: e */
    private AbstractC2533f f8837e = new C2516i();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.biz.n.h$a */
    /* loaded from: classes.dex */
    public class RunnableC2566a implements Runnable {

        /* renamed from: a */
        int f8838a;

        public RunnableC2566a(int i) {
            this.f8838a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2565h.this.f8835c.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f8838a == 0) {
                planeMsg = C2565h.this.f8837e.mo11778a(C2565h.this.f8834b);
            }
            obtainMessage.what = this.f8838a;
            obtainMessage.obj = planeMsg;
            C2565h.this.f8835c.sendMessage(obtainMessage);
        }
    }

    private C2565h(Context context) {
        this.f8834b = context;
        this.f8834b = context;
    }

    /* renamed from: a */
    public static C2565h m11668a(Context context) {
        if (f8833f == null) {
            f8833f = new C2565h(context.getApplicationContext());
        }
        return f8833f;
    }

    /* renamed from: a */
    public void m11667a(AbstractC2538k abstractC2538k) {
        this.f8836d.put(0, abstractC2538k);
        C2281x.m12702b(new RunnableC2566a(0));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8836d.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return false;
        }
        return false;
    }
}
