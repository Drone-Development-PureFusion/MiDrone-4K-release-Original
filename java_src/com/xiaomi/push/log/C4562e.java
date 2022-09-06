package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
/* renamed from: com.xiaomi.push.log.e */
/* loaded from: classes2.dex */
public class C4562e implements LoggerInterface {

    /* renamed from: a */
    private LoggerInterface f18744a;

    /* renamed from: b */
    private LoggerInterface f18745b;

    public C4562e(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f18744a = null;
        this.f18745b = null;
        this.f18744a = loggerInterface;
        this.f18745b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        if (this.f18744a != null) {
            this.f18744a.log(str);
        }
        if (this.f18745b != null) {
            this.f18745b.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        if (this.f18744a != null) {
            this.f18744a.log(str, th);
        }
        if (this.f18745b != null) {
            this.f18745b.log(str, th);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }
}
