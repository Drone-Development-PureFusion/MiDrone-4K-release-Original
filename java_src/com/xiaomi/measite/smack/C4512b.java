package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.smack.AbstractC4713a;
import com.xiaomi.smack.AbstractC4717d;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.measite.smack.b */
/* loaded from: classes2.dex */
public class C4512b implements AbstractC4717d {

    /* renamed from: a */
    final /* synthetic */ C4510a f18599a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4512b(C4510a c4510a) {
        this.f18599a = c4510a;
    }

    @Override // com.xiaomi.smack.AbstractC4717d
    /* renamed from: a */
    public void mo3803a(AbstractC4713a abstractC4713a) {
        AbstractC4713a abstractC4713a2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.f18599a.f18591b.format(new Date())).append(" Connection reconnected (");
        abstractC4713a2 = this.f18599a.f18592c;
        AbstractC4478b.m5037c(append.append(abstractC4713a2.hashCode()).append(")").toString());
    }

    @Override // com.xiaomi.smack.AbstractC4717d
    /* renamed from: a */
    public void mo3802a(AbstractC4713a abstractC4713a, int i, Exception exc) {
        AbstractC4713a abstractC4713a2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.f18599a.f18591b.format(new Date())).append(" Connection closed (");
        abstractC4713a2 = this.f18599a.f18592c;
        AbstractC4478b.m5037c(append.append(abstractC4713a2.hashCode()).append(")").toString());
    }

    @Override // com.xiaomi.smack.AbstractC4717d
    /* renamed from: a */
    public void mo3801a(AbstractC4713a abstractC4713a, Exception exc) {
        AbstractC4713a abstractC4713a2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.f18599a.f18591b.format(new Date())).append(" Reconnection failed due to an exception (");
        abstractC4713a2 = this.f18599a.f18592c;
        AbstractC4478b.m5037c(append.append(abstractC4713a2.hashCode()).append(")").toString());
        exc.printStackTrace();
    }

    @Override // com.xiaomi.smack.AbstractC4717d
    /* renamed from: b */
    public void mo3799b(AbstractC4713a abstractC4713a) {
        AbstractC4713a abstractC4713a2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.f18599a.f18591b.format(new Date())).append(" Connection started (");
        abstractC4713a2 = this.f18599a.f18592c;
        AbstractC4478b.m5037c(append.append(abstractC4713a2.hashCode()).append(")").toString());
    }
}
