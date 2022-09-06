package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2520m;
import com.fimi.soul.biz.p183l.AbstractC2537j;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.MessagePush;
import com.fimi.soul.entity.PlaneMsg;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.n */
/* loaded from: classes.dex */
public class C2578n implements Handler.Callback {

    /* renamed from: d */
    private static C2578n f8899d = null;

    /* renamed from: f */
    private static final int f8900f = 0;

    /* renamed from: c */
    private Context f8903c;

    /* renamed from: b */
    private HashMap<Integer, AbstractC2538k> f8902b = new HashMap<>();

    /* renamed from: e */
    private AbstractC2537j f8904e = new C2520m();

    /* renamed from: a */
    private Handler f8901a = new Handler(this);

    /* renamed from: com.fimi.soul.biz.n.n$a */
    /* loaded from: classes.dex */
    class RunnableC2579a implements Runnable {

        /* renamed from: a */
        int f8905a;

        /* renamed from: b */
        MessagePush f8906b;

        public RunnableC2579a(int i) {
            this.f8905a = i;
        }

        public RunnableC2579a(int i, MessagePush messagePush) {
            this.f8905a = i;
            this.f8906b = messagePush;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2578n.this.f8901a.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f8905a == 0) {
                planeMsg = C2578n.this.f8904e.mo11772a(this.f8906b, C2578n.this.f8903c);
            }
            obtainMessage.what = this.f8905a;
            obtainMessage.obj = planeMsg;
            C2578n.this.f8901a.sendMessage(obtainMessage);
        }
    }

    private C2578n(Context context) {
        this.f8903c = context;
        this.f8903c = context;
    }

    /* renamed from: a */
    public static C2578n m11627a(Context context) {
        if (f8899d == null) {
            f8899d = new C2578n(context.getApplicationContext());
        }
        return f8899d;
    }

    /* renamed from: a */
    public void m11625a(MessagePush messagePush, AbstractC2538k abstractC2538k) {
        this.f8902b.put(0, abstractC2538k);
        C2281x.m12702b(new RunnableC2579a(0, messagePush));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8902b.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return false;
        }
        return false;
    }
}
