package com.xiaomi.smack.util;

import android.content.Context;
import com.xiaomi.channel.commonutils.misc.C4488h;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.smack.util.h */
/* loaded from: classes2.dex */
public final class C4751h extends C4488h.AbstractC4490b {

    /* renamed from: a */
    final /* synthetic */ Context f19528a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4751h(Context context) {
        this.f19528a = context;
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
    /* renamed from: b */
    public void mo3817b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = C4749g.f19518c;
        synchronized (obj) {
            list = C4749g.f19519d;
            arrayList = new ArrayList(list);
            list2 = C4749g.f19519d;
            list2.clear();
        }
        C4749g.m3821b(this.f19528a, arrayList);
    }
}
