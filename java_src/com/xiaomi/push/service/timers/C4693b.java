package com.xiaomi.push.service.timers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.reflect.C4500a;
import com.xiaomi.push.service.AbstractC4618am;
import com.xiaomi.push.service.timers.C4691a;
import com.xiaomi.smack.C4722g;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.timers.b */
/* loaded from: classes2.dex */
public class C4693b implements C4691a.AbstractC4692a {

    /* renamed from: b */
    private Context f19198b;

    /* renamed from: a */
    private PendingIntent f19197a = null;

    /* renamed from: c */
    private volatile long f19199c = 0;

    public C4693b(Context context) {
        this.f19198b = null;
        this.f19198b = context;
    }

    /* renamed from: a */
    private void m4083a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 0, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
        }
    }

    @Override // com.xiaomi.push.service.timers.C4691a.AbstractC4692a
    /* renamed from: a */
    public void mo4081a() {
        if (this.f19197a != null) {
            ((AlarmManager) this.f19198b.getSystemService("alarm")).cancel(this.f19197a);
            this.f19197a = null;
            AbstractC4478b.m5037c("unregister timer");
        }
        this.f19199c = 0L;
    }

    /* renamed from: a */
    public void m4082a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f19198b.getSystemService("alarm");
        this.f19197a = PendingIntent.getBroadcast(this.f19198b, 0, intent, 0);
        if (Build.VERSION.SDK_INT >= 23) {
            C4500a.m4972a(alarmManager, "setExactAndAllowWhileIdle", 0, Long.valueOf(j), this.f19197a);
        } else if (Build.VERSION.SDK_INT >= 19) {
            m4083a(alarmManager, j, this.f19197a);
        } else {
            alarmManager.set(0, j, this.f19197a);
        }
        AbstractC4478b.m5037c("register timer " + j);
    }

    @Override // com.xiaomi.push.service.timers.C4691a.AbstractC4692a
    /* renamed from: a */
    public void mo4079a(boolean z) {
        long m3946c = C4722g.m3946c();
        if (z || this.f19199c != 0) {
            if (z) {
                mo4081a();
            }
            if (z || this.f19199c == 0) {
                this.f19199c = (m3946c - (SystemClock.elapsedRealtime() % m3946c)) + System.currentTimeMillis();
            } else {
                this.f19199c += m3946c;
                if (this.f19199c < System.currentTimeMillis()) {
                    this.f19199c = m3946c + System.currentTimeMillis();
                }
            }
            Intent intent = new Intent(AbstractC4618am.f18998o);
            intent.setPackage(this.f19198b.getPackageName());
            m4082a(intent, this.f19199c);
        }
    }

    @Override // com.xiaomi.push.service.timers.C4691a.AbstractC4692a
    /* renamed from: b */
    public boolean mo4078b() {
        return this.f19199c != 0;
    }
}
