package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.p232a.C4400d;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.g */
/* loaded from: classes2.dex */
public final class C4429g implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ Context f18479a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4429g(Context context) {
        this.f18479a = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        StatLogger statLogger;
        StatLogger statLogger2;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        StatLogger statLogger3;
        StatLogger statLogger4;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        C4436n.m5134a(this.f18479a).m5133a(new C4400d(this.f18479a, StatService.m5270a(this.f18479a, false), 2, th), (AbstractC4409c) null);
        statLogger = StatService.f18354i;
        statLogger.debug("MTA has caught the following uncaught exception:");
        statLogger2 = StatService.f18354i;
        statLogger2.error(th);
        uncaughtExceptionHandler = StatService.f18355j;
        if (uncaughtExceptionHandler == null) {
            statLogger3 = StatService.f18354i;
            statLogger3.debug("Original uncaught exception handler not set.");
            return;
        }
        statLogger4 = StatService.f18354i;
        statLogger4.debug("Call the original uncaught exception handler.");
        uncaughtExceptionHandler2 = StatService.f18355j;
        uncaughtExceptionHandler2.uncaughtException(thread, th);
    }
}
