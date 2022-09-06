package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2509c;
import com.fimi.soul.biz.p183l.AbstractC2531d;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.PlaneMsg;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.e */
/* loaded from: classes.dex */
public class C2560e implements Handler.Callback {

    /* renamed from: a */
    private static C2560e f8804a = null;

    /* renamed from: b */
    private static final int f8805b = 0;

    /* renamed from: c */
    private static final int f8806c = 1;

    /* renamed from: d */
    private static final int f8807d = 2;

    /* renamed from: e */
    private static final int f8808e = 3;

    /* renamed from: f */
    private AbstractC2531d f8809f = new C2509c();

    /* renamed from: g */
    private Handler f8810g = new Handler(this);

    /* renamed from: h */
    private HashMap<Integer, AbstractC2538k> f8811h = new HashMap<>();

    /* renamed from: i */
    private Context f8812i;

    /* renamed from: com.fimi.soul.biz.n.e$a */
    /* loaded from: classes.dex */
    class RunnableC2561a implements Runnable {

        /* renamed from: b */
        private int f8814b;

        public RunnableC2561a(int i) {
            this.f8814b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2560e.this.f8810g.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f8814b == 0) {
                planeMsg = C2560e.this.f8809f.mo11782b(C2560e.this.f8812i);
            } else if (this.f8814b == 1) {
                planeMsg = C2560e.this.f8809f.mo11781c(C2560e.this.f8812i);
            } else if (this.f8814b == 2) {
                planeMsg = C2560e.this.f8809f.mo11780d(C2560e.this.f8812i);
            } else if (this.f8814b == 3) {
                planeMsg = C2560e.this.f8809f.mo11779e(C2560e.this.f8812i);
            }
            obtainMessage.what = this.f8814b;
            obtainMessage.obj = planeMsg;
            C2560e.this.f8810g.sendMessage(obtainMessage);
        }
    }

    public C2560e(Context context) {
        this.f8812i = null;
        this.f8812i = context;
    }

    /* renamed from: a */
    public static C2560e m11692a(Context context) {
        if (f8804a == null) {
            f8804a = new C2560e(context);
        }
        return f8804a;
    }

    /* renamed from: a */
    public void m11691a(AbstractC2538k abstractC2538k) {
        this.f8811h.put(0, abstractC2538k);
        C2281x.m12702b(new RunnableC2561a(0));
    }

    /* renamed from: b */
    public void m11689b(AbstractC2538k abstractC2538k) {
        this.f8811h.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2561a(1));
    }

    /* renamed from: c */
    public void m11687c(AbstractC2538k abstractC2538k) {
        this.f8811h.put(2, abstractC2538k);
        C2281x.m12702b(new RunnableC2561a(2));
    }

    /* renamed from: d */
    public void m11685d(AbstractC2538k abstractC2538k) {
        this.f8811h.put(3, abstractC2538k);
        C2281x.m12702b(new RunnableC2561a(3));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8811h.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return false;
        }
        return false;
    }
}
