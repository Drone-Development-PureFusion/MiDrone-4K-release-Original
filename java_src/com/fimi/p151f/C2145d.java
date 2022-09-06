package com.fimi.p151f;

import android.os.Handler;
import android.os.Message;
import com.fimi.p147d.AbstractC2118a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.fimi.f.d */
/* loaded from: classes.dex */
public class C2145d {

    /* renamed from: a */
    private static C2145d f7197a = new C2145d();

    /* renamed from: c */
    private C2138a f7199c;

    /* renamed from: b */
    private List<AbstractC2118a> f7198b = new ArrayList();

    /* renamed from: d */
    private Handler f7200d = new Handler() { // from class: com.fimi.f.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    for (AbstractC2118a abstractC2118a : C2145d.this.f7198b) {
                        abstractC2118a.mo6446b("removeSession");
                    }
                    return;
                case 1:
                    for (AbstractC2118a abstractC2118a2 : C2145d.this.f7198b) {
                        abstractC2118a2.mo6477a("startSession");
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: a */
    public static void m13452a() {
        m13447b();
    }

    /* renamed from: b */
    public static C2145d m13447b() {
        return f7197a;
    }

    /* renamed from: a */
    public synchronized void m13451a(AbstractC2118a abstractC2118a) {
        this.f7198b.add(abstractC2118a);
    }

    /* renamed from: a */
    public synchronized void m13450a(C2138a c2138a) {
        this.f7199c = c2138a;
        this.f7200d.sendEmptyMessage(1);
    }

    /* renamed from: a */
    public synchronized void m13448a(byte[] bArr, int i) {
        if (this.f7199c != null) {
            this.f7199c.mo13461a(bArr, i);
        }
    }

    /* renamed from: b */
    public synchronized void m13446b(AbstractC2118a abstractC2118a) {
        AbstractC2118a abstractC2118a2;
        Iterator<AbstractC2118a> it2 = this.f7198b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                abstractC2118a2 = null;
                break;
            }
            abstractC2118a2 = it2.next();
            if (abstractC2118a2 != null && abstractC2118a2 == abstractC2118a) {
                break;
            }
        }
        if (abstractC2118a2 != null) {
            this.f7198b.remove(abstractC2118a2);
        }
    }

    /* renamed from: c */
    public synchronized void m13445c() {
        this.f7199c = null;
        this.f7200d.sendEmptyMessage(0);
    }

    /* renamed from: d */
    public synchronized boolean m13444d() {
        return this.f7199c != null;
    }

    /* renamed from: e */
    public synchronized void m13443e() {
        if (this.f7199c != null) {
            this.f7199c.mo13460b();
        }
    }
}
