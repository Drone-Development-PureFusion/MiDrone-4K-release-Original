package org.p290c.p312f.p313a;

import java.util.concurrent.TimeUnit;
/* renamed from: org.c.f.a.l */
/* loaded from: classes2.dex */
public class C5652l extends Exception {
    private static final long serialVersionUID = 31935685163547539L;

    /* renamed from: a */
    private final TimeUnit f22756a;

    /* renamed from: b */
    private final long f22757b;

    public C5652l(long j, TimeUnit timeUnit) {
        super(String.format("test timed out after %d %s", Long.valueOf(j), timeUnit.name().toLowerCase()));
        this.f22756a = timeUnit;
        this.f22757b = j;
    }

    /* renamed from: a */
    public long m402a() {
        return this.f22757b;
    }

    /* renamed from: b */
    public TimeUnit m401b() {
        return this.f22756a;
    }
}
