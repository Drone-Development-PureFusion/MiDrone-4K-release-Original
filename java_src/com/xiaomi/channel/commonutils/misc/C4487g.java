package com.xiaomi.channel.commonutils.misc;

import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.misc.C4484f;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.channel.commonutils.misc.g */
/* loaded from: classes2.dex */
public class C4487g extends C4484f.RunnableC4486b {

    /* renamed from: a */
    final /* synthetic */ String f18555a;

    /* renamed from: b */
    final /* synthetic */ C4484f f18556b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4487g(C4484f c4484f, C4484f.AbstractRunnableC4485a abstractRunnableC4485a, String str) {
        super(abstractRunnableC4485a);
        this.f18556b = c4484f;
        this.f18555a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.channel.commonutils.misc.C4484f.RunnableC4486b
    /* renamed from: a */
    public void mo5018a() {
        super.mo5018a();
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4484f.RunnableC4486b
    /* renamed from: b */
    void mo5017b() {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.f18556b.f18553e;
        sharedPreferences.edit().putLong(this.f18555a, System.currentTimeMillis()).commit();
    }
}
