package com.xiaomi.push.service;

import com.xiaomi.push.service.C4630av;
import com.xiaomi.push.service.C4633aw;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.bi */
/* loaded from: classes.dex */
public class C4652bi implements C4633aw.AbstractC4635b {

    /* renamed from: a */
    final /* synthetic */ XMPushService f19073a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4652bi(XMPushService xMPushService) {
        this.f19073a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m4281a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f19073a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.service.C4633aw.AbstractC4635b
    /* renamed from: a */
    public void mo4280a(ArrayList<C4630av.C4632b> arrayList) {
        this.f19073a.m4494a(new C4653bj(this, 4, arrayList));
    }

    @Override // com.xiaomi.push.service.C4633aw.AbstractC4635b
    /* renamed from: a */
    public boolean mo4283a(C4630av.C4632b c4632b) {
        return m4281a(this.f19073a.getPackageName()) != null;
    }
}
