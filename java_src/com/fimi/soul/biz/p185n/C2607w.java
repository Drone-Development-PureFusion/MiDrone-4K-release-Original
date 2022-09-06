package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2525r;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p183l.AbstractC2541n;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.UpdateDroneItem;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.w */
/* loaded from: classes.dex */
public class C2607w implements Handler.Callback {

    /* renamed from: a */
    private static C2607w f9006a = null;

    /* renamed from: b */
    private static final int f9007b = 0;

    /* renamed from: c */
    private static final int f9008c = 1;

    /* renamed from: d */
    private static final int f9009d = 2;

    /* renamed from: e */
    private static final int f9010e = 3;

    /* renamed from: f */
    private static final int f9011f = 4;

    /* renamed from: g */
    private static final int f9012g = 5;

    /* renamed from: h */
    private AbstractC2541n f9013h = new C2525r();

    /* renamed from: i */
    private Handler f9014i = new Handler(this);

    /* renamed from: j */
    private HashMap<Integer, AbstractC2538k> f9015j = new HashMap<>();

    /* renamed from: k */
    private Context f9016k;

    /* renamed from: com.fimi.soul.biz.n.w$a */
    /* loaded from: classes.dex */
    class RunnableC2608a implements Runnable {

        /* renamed from: b */
        private int f9018b;

        /* renamed from: c */
        private UpdateDroneItem f9019c;

        /* renamed from: d */
        private String f9020d;

        /* renamed from: e */
        private int f9021e;

        /* renamed from: f */
        private String f9022f;

        public RunnableC2608a(int i, UpdateDroneItem updateDroneItem) {
            this.f9018b = i;
            this.f9019c = updateDroneItem;
        }

        public RunnableC2608a(int i, String str) {
            this.f9020d = str;
            this.f9018b = i;
        }

        public RunnableC2608a(int i, String str, int i2) {
            this.f9018b = i;
            this.f9020d = str;
            this.f9021e = i2;
        }

        public RunnableC2608a(int i, String str, int i2, String str2) {
            this.f9018b = i;
            this.f9020d = str;
            this.f9021e = i2;
            this.f9022f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2607w.this.f9014i.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f9018b == 0) {
                planeMsg = C2607w.this.f9013h.mo11765a(this.f9019c, C2607w.this.f9016k);
            } else if (this.f9018b == 1) {
                planeMsg = C2607w.this.f9013h.mo11763b(this.f9019c, C2607w.this.f9016k);
            } else if (this.f9018b == 2) {
                planeMsg = C2607w.this.f9013h.mo11762c(this.f9020d, C2607w.this.f9016k);
            } else if (this.f9018b == 3) {
                planeMsg = C2607w.this.f9013h.mo11761d(this.f9020d, C2607w.this.f9016k);
            } else if (this.f9018b == 4) {
                planeMsg = C2607w.this.f9013h.mo11760e(this.f9020d, C2607w.this.f9016k);
            } else if (this.f9018b == 5) {
                planeMsg = C2607w.this.f9013h.mo11764a(this.f9020d, this.f9022f, this.f9021e, C2607w.this.f9016k);
            }
            obtainMessage.what = this.f9018b;
            obtainMessage.obj = planeMsg;
            C2607w.this.f9014i.sendMessage(obtainMessage);
        }
    }

    public C2607w(Context context) {
        this.f9016k = null;
        this.f9016k = context;
    }

    /* renamed from: a */
    public static C2607w m11547a(Context context) {
        if (f9006a == null) {
            f9006a = new C2607w(context);
        }
        return f9006a;
    }

    /* renamed from: a */
    public void m11545a(UpdateDroneItem updateDroneItem, AbstractC2538k abstractC2538k) {
        this.f9015j.put(0, abstractC2538k);
        C2281x.m12702b(new RunnableC2608a(0, updateDroneItem));
    }

    /* renamed from: a */
    public void m11544a(String str, AbstractC2538k abstractC2538k) {
        this.f9015j.put(2, abstractC2538k);
        C2281x.m12702b(new RunnableC2608a(2, str));
    }

    /* renamed from: a */
    public void m11543a(String str, String str2, int i, AbstractC2538k abstractC2538k) {
        this.f9015j.put(5, abstractC2538k);
        C2281x.m12702b(new RunnableC2608a(5, str, i, str2));
    }

    /* renamed from: b */
    public void m11541b(UpdateDroneItem updateDroneItem, AbstractC2538k abstractC2538k) {
        this.f9015j.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2608a(1, updateDroneItem));
    }

    /* renamed from: b */
    public void m11540b(String str, AbstractC2538k abstractC2538k) {
        this.f9015j.put(3, abstractC2538k);
        C2281x.m12702b(new RunnableC2608a(3, str));
    }

    /* renamed from: c */
    public void m11538c(String str, AbstractC2538k abstractC2538k) {
        this.f9015j.put(4, abstractC2538k);
        C2281x.m12702b(new RunnableC2608a(4, str));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f9015j.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return false;
        }
        return false;
    }
}
