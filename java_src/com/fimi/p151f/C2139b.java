package com.fimi.p151f;

import android.os.Handler;
import android.os.Message;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p147d.AbstractC2119b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.fimi.f.b */
/* loaded from: classes.dex */
public class C2139b implements AbstractC2119b {

    /* renamed from: a */
    private static C2139b f7172a = new C2139b();

    /* renamed from: b */
    private List<AbstractC2119b> f7173b = new ArrayList();

    /* renamed from: c */
    private Handler f7174c = new Handler() { // from class: com.fimi.f.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (AbstractC2119b abstractC2119b : C2139b.this.f7173b) {
                abstractC2119b.mo6481a(message.what, (C2104c) message.obj);
            }
        }
    };

    /* renamed from: a */
    public static void m13469a() {
        m13466b();
    }

    /* renamed from: b */
    public static C2139b m13466b() {
        return f7172a;
    }

    @Override // com.fimi.p147d.AbstractC2119b
    /* renamed from: a */
    public synchronized void mo6481a(int i, C2104c c2104c) {
        this.f7174c.obtainMessage(i, c2104c).sendToTarget();
    }

    /* renamed from: a */
    public synchronized void m13468a(AbstractC2119b abstractC2119b) {
        this.f7173b.add(abstractC2119b);
    }

    /* renamed from: b */
    public synchronized void m13465b(AbstractC2119b abstractC2119b) {
        AbstractC2119b abstractC2119b2;
        Iterator<AbstractC2119b> it2 = this.f7173b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                abstractC2119b2 = null;
                break;
            }
            abstractC2119b2 = it2.next();
            if (abstractC2119b2 != null && abstractC2119b2 == abstractC2119b) {
                break;
            }
        }
        if (abstractC2119b2 != null) {
            this.f7173b.remove(abstractC2119b2);
        }
    }
}
