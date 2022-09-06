package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2522o;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.PlaneMsg;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.r */
/* loaded from: classes.dex */
public class C2593r implements Handler.Callback {

    /* renamed from: a */
    private static C2593r f8954a = null;

    /* renamed from: b */
    private static final int f8955b = 0;

    /* renamed from: c */
    private static final int f8956c = 1;

    /* renamed from: f */
    private Context f8959f;

    /* renamed from: e */
    private C2522o f8958e = new C2522o();

    /* renamed from: g */
    private Handler f8960g = new Handler(this);

    /* renamed from: d */
    private HashMap<Integer, AbstractC2538k> f8957d = new HashMap<>();

    /* renamed from: com.fimi.soul.biz.n.r$a */
    /* loaded from: classes.dex */
    class RunnableC2594a implements Runnable {

        /* renamed from: b */
        private int f8962b;

        /* renamed from: c */
        private String f8963c;

        /* renamed from: d */
        private String f8964d;

        public RunnableC2594a(int i, String str, String str2) {
            this.f8962b = i;
            this.f8963c = str;
            this.f8964d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2593r.this.f8960g.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f8962b == 0) {
                planeMsg = C2593r.this.f8958e.m11800a(this.f8963c, this.f8964d, C2593r.this.f8959f);
            }
            if (this.f8962b == 1) {
                planeMsg = C2593r.this.f8958e.m11801a(C2593r.this.f8959f);
            }
            obtainMessage.what = this.f8962b;
            obtainMessage.obj = planeMsg;
            C2593r.this.f8960g.sendMessage(obtainMessage);
        }
    }

    public C2593r(Context context) {
        this.f8959f = null;
        this.f8959f = context;
    }

    /* renamed from: a */
    public static C2593r m11590a(Context context) {
        if (f8954a == null) {
            f8954a = new C2593r(context);
        }
        return f8954a;
    }

    /* renamed from: a */
    public void m11589a(AbstractC2538k abstractC2538k) {
        this.f8957d.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2594a(1, null, null));
    }

    /* renamed from: a */
    public void m11587a(String str, String str2, AbstractC2538k abstractC2538k) {
        this.f8957d.put(0, abstractC2538k);
        C2281x.m12702b(new RunnableC2594a(0, str, str2));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8957d.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return true;
        }
        return true;
    }
}
