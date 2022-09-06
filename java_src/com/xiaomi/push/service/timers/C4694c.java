package com.xiaomi.push.service.timers;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMJobService;
import com.xiaomi.push.service.timers.C4691a;
import com.xiaomi.smack.C4722g;
@TargetApi(21)
/* renamed from: com.xiaomi.push.service.timers.c */
/* loaded from: classes2.dex */
public class C4694c implements C4691a.AbstractC4692a {

    /* renamed from: a */
    Context f19200a;

    /* renamed from: b */
    JobScheduler f19201b;

    /* renamed from: c */
    private boolean f19202c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4694c(Context context) {
        this.f19200a = context;
        this.f19201b = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.service.timers.C4691a.AbstractC4692a
    /* renamed from: a */
    public void mo4081a() {
        this.f19202c = false;
        this.f19201b.cancel(1);
    }

    /* renamed from: a */
    void m4080a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f19200a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        AbstractC4478b.m5037c("schedule Job = " + builder.build().getId() + " in " + j);
        this.f19201b.schedule(builder.build());
    }

    @Override // com.xiaomi.push.service.timers.C4691a.AbstractC4692a
    /* renamed from: a */
    public void mo4079a(boolean z) {
        if (z || this.f19202c) {
            long m3946c = C4722g.m3946c();
            if (z) {
                mo4081a();
                m3946c -= SystemClock.elapsedRealtime() % m3946c;
            }
            this.f19202c = true;
            m4080a(m3946c);
        }
    }

    @Override // com.xiaomi.push.service.timers.C4691a.AbstractC4692a
    /* renamed from: b */
    public boolean mo4078b() {
        return this.f19202c;
    }
}
