package com.fimi.soul.module.p207b;

import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.module.b.b */
/* loaded from: classes.dex */
public class C3053b implements AbstractC3056c {

    /* renamed from: a */
    private List<AbstractC3055b> f11385a = new ArrayList();

    /* renamed from: com.fimi.soul.module.b.b$a */
    /* loaded from: classes.dex */
    static class C3054a {

        /* renamed from: a */
        private static C3053b f11386a = new C3053b();

        C3054a() {
        }
    }

    /* renamed from: com.fimi.soul.module.b.b$b */
    /* loaded from: classes.dex */
    public interface AbstractC3055b {
        /* renamed from: a */
        void mo9837a(int i);
    }

    /* renamed from: a */
    public static C3053b m9841a() {
        return C3054a.f11386a;
    }

    @Override // com.fimi.soul.module.p207b.AbstractC3056c
    /* renamed from: a */
    public void mo9836a(int i) {
        for (AbstractC3055b abstractC3055b : this.f11385a) {
            abstractC3055b.mo9837a(i);
        }
    }

    /* renamed from: a */
    public void m9840a(AbstractC3055b abstractC3055b) {
        this.f11385a.add(abstractC3055b);
    }

    /* renamed from: b */
    public void m9839b(AbstractC3055b abstractC3055b) {
        this.f11385a.add(abstractC3055b);
    }
}
