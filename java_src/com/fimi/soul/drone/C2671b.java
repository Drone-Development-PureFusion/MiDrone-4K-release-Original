package com.fimi.soul.drone;

import android.os.Handler;
import com.fimi.soul.drone.C2678d;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
/* renamed from: com.fimi.soul.drone.b */
/* loaded from: classes.dex */
public class C2671b extends C2822e {

    /* renamed from: c */
    private final Handler f9342c;

    /* renamed from: b */
    private final ConcurrentLinkedQueue<C2678d.EnumC2679a> f9341b = new ConcurrentLinkedQueue<>();

    /* renamed from: d */
    private final Runnable f9343d = new Runnable() { // from class: com.fimi.soul.drone.b.1
        @Override // java.lang.Runnable
        public void run() {
            do {
                C2671b.this.f9342c.removeCallbacks(this);
                C2678d.EnumC2679a enumC2679a = (C2678d.EnumC2679a) C2671b.this.f9341b.poll();
                if (enumC2679a != null && !C2671b.this.f9344e.isEmpty()) {
                    Iterator it2 = C2671b.this.f9344e.iterator();
                    while (it2.hasNext()) {
                        ((C2678d.AbstractC2680b) it2.next()).onDroneEvent(enumC2679a, C2671b.this.f10431a);
                    }
                }
            } while (!C2671b.this.f9341b.isEmpty());
        }
    };

    /* renamed from: e */
    private final ConcurrentLinkedQueue<C2678d.AbstractC2680b> f9344e = new ConcurrentLinkedQueue<>();

    public C2671b(C2657a c2657a, Handler handler) {
        super(c2657a);
        this.f9342c = handler;
    }

    /* renamed from: a */
    public void m11252a(C2678d.EnumC2679a enumC2679a) {
        this.f9341b.offer(enumC2679a);
        this.f9342c.post(this.f9343d);
    }

    /* renamed from: a */
    public void m11251a(C2678d.AbstractC2680b abstractC2680b) {
        boolean z = true;
        boolean z2 = abstractC2680b != null;
        if (this.f9344e.contains(abstractC2680b)) {
            z = false;
        }
        if (z2 && z) {
            this.f9344e.add(abstractC2680b);
        }
    }

    /* renamed from: b */
    public void m11249b(C2678d.AbstractC2680b abstractC2680b) {
        if (abstractC2680b == null || !this.f9344e.contains(abstractC2680b)) {
            return;
        }
        this.f9344e.remove(abstractC2680b);
    }
}
