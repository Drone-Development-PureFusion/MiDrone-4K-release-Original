package com.tencent.stat;
/* renamed from: com.tencent.stat.m */
/* loaded from: classes2.dex */
class C4435m implements AbstractC4409c {

    /* renamed from: a */
    final /* synthetic */ RunnableC4433k f18488a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4435m(RunnableC4433k runnableC4433k) {
        this.f18488a = runnableC4433k;
    }

    @Override // com.tencent.stat.AbstractC4409c
    /* renamed from: a */
    public void mo5110a() {
        if (C4436n.m5123b().m5136a() >= StatConfig.getMaxBatchReportCount()) {
            C4436n.m5123b().m5135a(StatConfig.getMaxBatchReportCount());
        }
    }

    @Override // com.tencent.stat.AbstractC4409c
    /* renamed from: b */
    public void mo5109b() {
    }
}
