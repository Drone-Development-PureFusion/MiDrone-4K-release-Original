package com.tencent.stat;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.u */
/* loaded from: classes2.dex */
public class C4443u implements AbstractC4409c {

    /* renamed from: a */
    final /* synthetic */ List f18508a;

    /* renamed from: b */
    final /* synthetic */ int f18509b;

    /* renamed from: c */
    final /* synthetic */ C4436n f18510c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4443u(C4436n c4436n, List list, int i) {
        this.f18510c = c4436n;
        this.f18508a = list;
        this.f18509b = i;
    }

    @Override // com.tencent.stat.AbstractC4409c
    /* renamed from: a */
    public void mo5110a() {
        this.f18510c.m5125a(this.f18508a);
    }

    @Override // com.tencent.stat.AbstractC4409c
    /* renamed from: b */
    public void mo5109b() {
        this.f18510c.m5124a(this.f18508a, 1);
        this.f18510c.f18492b += this.f18509b;
    }
}
