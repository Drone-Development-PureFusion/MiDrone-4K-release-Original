package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.misc.C4488h;
import com.xiaomi.push.log.C4556b;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.log.d */
/* loaded from: classes2.dex */
public class C4561d extends C4488h.AbstractC4490b {

    /* renamed from: a */
    C4488h.AbstractC4490b f18742a;

    /* renamed from: b */
    final /* synthetic */ C4556b f18743b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4561d(C4556b c4556b) {
        this.f18743b = c4556b;
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
    /* renamed from: b */
    public void mo3817b() {
        C4556b.C4558b c4558b = (C4556b.C4558b) this.f18743b.f18722a.peek();
        if (c4558b == null || !c4558b.mo4713d()) {
            return;
        }
        this.f18742a = (C4488h.AbstractC4490b) this.f18743b.f18722a.remove();
        this.f18742a.mo3817b();
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
    /* renamed from: c */
    public void mo4323c() {
        if (this.f18742a != null) {
            this.f18742a.mo4323c();
        }
    }
}
