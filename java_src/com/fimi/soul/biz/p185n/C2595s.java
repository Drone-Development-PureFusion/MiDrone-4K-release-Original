package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2523p;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p183l.AbstractC2540m;
import com.fimi.soul.entity.PlaneMsg;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.s */
/* loaded from: classes.dex */
public class C2595s implements Handler.Callback {

    /* renamed from: e */
    private static final int f8965e = 0;

    /* renamed from: f */
    private static final int f8966f = 1;

    /* renamed from: g */
    private static C2595s f8967g = null;

    /* renamed from: a */
    private Handler f8968a;

    /* renamed from: c */
    private Context f8970c;

    /* renamed from: d */
    private AbstractC2540m f8971d = new C2523p();

    /* renamed from: b */
    private HashMap<Integer, AbstractC2538k> f8969b = new HashMap<>();

    /* renamed from: com.fimi.soul.biz.n.s$a */
    /* loaded from: classes.dex */
    class RunnableC2596a implements Runnable {

        /* renamed from: a */
        int f8972a;

        /* renamed from: b */
        String f8973b;

        public RunnableC2596a(int i, String str) {
            this.f8972a = i;
            this.f8973b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2595s.this.f8968a.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f8972a == 0) {
                planeMsg = C2595s.this.f8971d.mo11767c(this.f8973b, C2595s.this.f8970c);
            } else if (this.f8972a == 1) {
                planeMsg = C2595s.this.f8971d.mo11766d(this.f8973b, C2595s.this.f8970c);
            }
            obtainMessage.what = this.f8972a;
            obtainMessage.obj = planeMsg;
            C2595s.this.f8968a.sendMessage(obtainMessage);
        }
    }

    private C2595s(Context context) {
        this.f8970c = context;
        this.f8968a = new Handler(this.f8970c.getMainLooper(), this);
    }

    /* renamed from: a */
    public static C2595s m11584a(Context context) {
        if (f8967g == null) {
            f8967g = new C2595s(context.getApplicationContext());
        }
        return f8967g;
    }

    /* renamed from: a */
    public void m11582a(String str, AbstractC2538k abstractC2538k) {
        this.f8969b.put(0, abstractC2538k);
        C2281x.m12702b(new RunnableC2596a(0, str));
    }

    /* renamed from: b */
    public void m11580b(String str, AbstractC2538k abstractC2538k) {
        this.f8969b.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2596a(1, str));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8969b.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return false;
        }
        return false;
    }
}
