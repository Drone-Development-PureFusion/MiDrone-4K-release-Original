package com.xiaomi.smack.util;

import com.xiaomi.channel.commonutils.misc.C4488h;
/* renamed from: com.xiaomi.smack.util.f */
/* loaded from: classes2.dex */
final class C4748f extends C4488h.AbstractC4490b {

    /* renamed from: a */
    final /* synthetic */ Runnable f19515a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4748f(Runnable runnable) {
        this.f19515a = runnable;
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
    /* renamed from: b */
    public void mo3817b() {
        this.f19515a.run();
    }
}
