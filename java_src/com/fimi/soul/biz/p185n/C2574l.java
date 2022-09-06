package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p182k.C2518k;
import com.fimi.soul.biz.p183l.AbstractC2535h;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.User;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.l */
/* loaded from: classes.dex */
public class C2574l implements Handler.Callback {

    /* renamed from: e */
    private static final int f8879e = 1;

    /* renamed from: f */
    private Context f8881f;

    /* renamed from: d */
    private static C2574l f8878d = null;

    /* renamed from: a */
    public static String f8876a = "1";

    /* renamed from: b */
    public static String f8877b = "2";

    /* renamed from: c */
    private HashMap<Integer, AbstractC2538k> f8880c = new HashMap<>();

    /* renamed from: g */
    private AbstractC2535h f8882g = new C2518k();

    /* renamed from: h */
    private Handler f8883h = new Handler(this);

    /* renamed from: com.fimi.soul.biz.n.l$a */
    /* loaded from: classes.dex */
    class RunnableC2575a implements Runnable {

        /* renamed from: b */
        private User f8885b;

        /* renamed from: c */
        private int f8886c;

        /* renamed from: d */
        private String f8887d;

        public RunnableC2575a(int i, String str, User user) {
            this.f8886c = i;
            this.f8885b = user;
            this.f8887d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2574l.this.f8883h.obtainMessage();
            PlaneMsg planeMsg = null;
            switch (this.f8886c) {
                case 1:
                    planeMsg = C2574l.this.f8882g.mo11774a(this.f8885b, this.f8887d, C2574l.this.f8881f);
                    break;
            }
            obtainMessage.what = this.f8886c;
            obtainMessage.obj = planeMsg;
            C2574l.this.f8883h.sendMessage(obtainMessage);
        }
    }

    public C2574l(Context context) {
        this.f8881f = null;
        this.f8881f = context;
    }

    /* renamed from: a */
    public static C2574l m11638a(Context context) {
        if (f8878d == null) {
            f8878d = new C2574l(context);
        }
        return f8878d;
    }

    /* renamed from: a */
    public void m11636a(User user, String str, AbstractC2538k abstractC2538k) {
        this.f8880c.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2575a(1, str, user));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8880c.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return false;
        }
        return false;
    }
}
