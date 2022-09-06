package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2517j;
import com.fimi.soul.biz.p183l.AbstractC2534g;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.HomePage;
import com.fimi.soul.entity.PlaneMsg;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.i */
/* loaded from: classes.dex */
public class C2567i implements Handler.Callback {

    /* renamed from: a */
    private static C2567i f8840a = null;

    /* renamed from: b */
    private static final int f8841b = 10;

    /* renamed from: c */
    private static final int f8842c = 11;

    /* renamed from: d */
    private static final int f8843d = 12;

    /* renamed from: e */
    private Context f8844e;

    /* renamed from: f */
    private HashMap<Integer, AbstractC2538k> f8845f = new HashMap<>();

    /* renamed from: g */
    private Handler f8846g = new Handler(this);

    /* renamed from: h */
    private AbstractC2534g f8847h = new C2517j();

    /* renamed from: com.fimi.soul.biz.n.i$a */
    /* loaded from: classes.dex */
    class RunnableC2568a implements Runnable {

        /* renamed from: b */
        private int f8849b;

        /* renamed from: c */
        private HomePage f8850c;

        public RunnableC2568a(int i, HomePage homePage) {
            this.f8849b = i;
            this.f8850c = homePage;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2567i.this.f8846g.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f8849b == 11) {
                planeMsg = C2567i.this.f8847h.mo11777a(this.f8850c, C2567i.this.f8844e);
            } else if (this.f8849b == 12) {
                planeMsg = C2567i.this.f8847h.mo11775b(this.f8850c, C2567i.this.f8844e);
            } else if (this.f8849b == 10) {
                planeMsg = C2567i.this.f8847h.mo11776b(C2567i.this.f8844e);
            }
            obtainMessage.what = this.f8849b;
            obtainMessage.obj = planeMsg;
            C2567i.this.f8846g.sendMessage(obtainMessage);
        }
    }

    public C2567i(Context context) {
        this.f8844e = null;
        this.f8844e = context;
    }

    /* renamed from: a */
    public static C2567i m11663a(Context context) {
        if (f8840a == null) {
            f8840a = new C2567i(context);
        }
        return f8840a;
    }

    /* renamed from: a */
    public void m11662a(AbstractC2538k abstractC2538k) {
        this.f8845f.put(10, abstractC2538k);
        C2281x.m12702b(new RunnableC2568a(10, null));
    }

    /* renamed from: a */
    public void m11660a(HomePage homePage, AbstractC2538k abstractC2538k) {
        this.f8845f.put(12, abstractC2538k);
        C2281x.m12702b(new RunnableC2568a(12, homePage));
    }

    /* renamed from: b */
    public void m11658b(HomePage homePage, AbstractC2538k abstractC2538k) {
        this.f8845f.put(11, abstractC2538k);
        C2281x.m12702b(new RunnableC2568a(11, homePage));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8845f.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return false;
        }
        return false;
    }
}
