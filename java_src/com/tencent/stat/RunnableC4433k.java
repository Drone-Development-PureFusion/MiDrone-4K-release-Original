package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.C4420k;
import com.tencent.stat.common.C4425p;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.p232a.AbstractC4401e;
import com.tencent.stat.p232a.EnumC4402f;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.k */
/* loaded from: classes2.dex */
public class RunnableC4433k implements Runnable {

    /* renamed from: a */
    private AbstractC4401e f18484a;

    /* renamed from: b */
    private StatReportStrategy f18485b;

    /* renamed from: c */
    private AbstractC4409c f18486c = new C4434l(this);

    public RunnableC4433k(AbstractC4401e abstractC4401e) {
        this.f18485b = null;
        this.f18484a = abstractC4401e;
        this.f18485b = StatConfig.getStatSendStrategy();
    }

    /* renamed from: a */
    private void m5139a() {
        if (C4436n.m5123b().m5136a() <= 0) {
            m5137a(true);
            return;
        }
        C4436n.m5123b().m5133a(this.f18484a, (AbstractC4409c) null);
        C4436n.m5123b().m5135a(-1);
    }

    /* renamed from: a */
    private void m5137a(boolean z) {
        C4426d.m5144b().m5146a(this.f18484a, this.f18486c);
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        StatLogger statLogger2;
        StatLogger statLogger3;
        StatLogger statLogger4;
        StatLogger statLogger5;
        StatLogger statLogger6;
        try {
            if (!StatConfig.isEnableStatService()) {
                return;
            }
            if (this.f18484a.mo5242a() != EnumC4402f.ERROR && this.f18484a.m5245d().length() > StatConfig.getMaxReportEventLength()) {
                statLogger6 = StatService.f18354i;
                statLogger6.m5236e("Event length exceed StatConfig.getMaxReportEventLength(): " + StatConfig.getMaxReportEventLength());
                return;
            }
            if (StatConfig.getMaxSessionStatReportCount() > 0) {
                if (StatConfig.getCurSessionStatReportCount() >= StatConfig.getMaxSessionStatReportCount()) {
                    statLogger5 = StatService.f18354i;
                    statLogger5.m5236e("Times for reporting events has reached the limit of StatConfig.getMaxSessionStatReportCount() in current session.");
                    return;
                }
                StatConfig.m5286c();
            }
            statLogger2 = StatService.f18354i;
            statLogger2.m5235i("Lauch stat task in thread:" + Thread.currentThread().getName());
            Context m5246c = this.f18484a.m5246c();
            if (!C4420k.m5180h(m5246c)) {
                C4436n.m5134a(m5246c).m5133a(this.f18484a, (AbstractC4409c) null);
                return;
            }
            if (StatConfig.isEnableSmartReporting() && this.f18485b != StatReportStrategy.ONLY_WIFI_NO_CACHE && C4420k.m5182g(m5246c)) {
                this.f18485b = StatReportStrategy.INSTANT;
            }
            switch (this.f18485b) {
                case INSTANT:
                    m5139a();
                    return;
                case ONLY_WIFI:
                    if (C4420k.m5186e(m5246c)) {
                        m5139a();
                        return;
                    } else {
                        C4436n.m5134a(m5246c).m5133a(this.f18484a, (AbstractC4409c) null);
                        return;
                    }
                case APP_LAUNCH:
                case DEVELOPER:
                    C4436n.m5134a(m5246c).m5133a(this.f18484a, (AbstractC4409c) null);
                    return;
                case BATCH:
                    if (C4436n.m5134a(this.f18484a.m5246c()) == null) {
                        return;
                    }
                    C4436n.m5134a(m5246c).m5133a(this.f18484a, new C4435m(this));
                    return;
                case PERIOD:
                    try {
                        C4436n.m5134a(m5246c).m5133a(this.f18484a, (AbstractC4409c) null);
                        Long valueOf = Long.valueOf(C4425p.m5153a(m5246c, "last_period_ts", 0L));
                        Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                        if (Long.valueOf(Long.valueOf(valueOf2.longValue() - valueOf.longValue()).longValue() / 60000).longValue() <= StatConfig.getSendPeriodMinutes()) {
                            return;
                        }
                        C4436n.m5134a(m5246c).m5135a(-1);
                        C4425p.m5150b(m5246c, "last_period_ts", valueOf2.longValue());
                        return;
                    } catch (Exception e) {
                        statLogger3 = StatService.f18354i;
                        statLogger3.m5237e(e);
                        return;
                    }
                case ONLY_WIFI_NO_CACHE:
                    if (!C4420k.m5186e(m5246c)) {
                        return;
                    }
                    m5137a(false);
                    return;
                default:
                    statLogger4 = StatService.f18354i;
                    statLogger4.error("Invalid stat strategy:" + StatConfig.getStatSendStrategy());
                    return;
            }
        } catch (Throwable th) {
            statLogger = StatService.f18354i;
            statLogger.m5236e(th);
        }
    }
}
