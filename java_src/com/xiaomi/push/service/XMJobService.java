package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.reflect.C4500a;
import com.xiaomi.push.service.timers.C4691a;
/* loaded from: classes.dex */
public class XMJobService extends Service {

    /* renamed from: a */
    static Service f18882a = null;

    /* renamed from: b */
    private IBinder f18883b = null;

    @TargetApi(21)
    /* renamed from: com.xiaomi.push.service.XMJobService$a  reason: invalid class name */
    /* loaded from: classes.dex */
    static class jobJobServiceC4580a extends JobService {

        /* renamed from: a */
        Binder f18884a;

        /* renamed from: b */
        private Handler f18885b;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a */
        /* loaded from: classes2.dex */
        private static class HandlerC4581a extends Handler {

            /* renamed from: a */
            JobService f18886a;

            HandlerC4581a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f18886a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        JobParameters jobParameters = (JobParameters) message.obj;
                        AbstractC4478b.m5041a("Job finished " + jobParameters.getJobId());
                        this.f18886a.jobFinished(jobParameters, false);
                        if (jobParameters.getJobId() != 1) {
                            return;
                        }
                        C4691a.m4085a(false);
                        return;
                    default:
                        return;
                }
            }
        }

        jobJobServiceC4580a(Service service) {
            this.f18884a = null;
            this.f18884a = (Binder) C4500a.m4972a(this, "onBind", new Intent());
            C4500a.m4972a(this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            AbstractC4478b.m5041a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f18885b == null) {
                this.f18885b = new HandlerC4581a(this);
            }
            this.f18885b.sendMessage(Message.obtain(this.f18885b, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            AbstractC4478b.m5041a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Service m4502a() {
        return f18882a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f18883b != null ? this.f18883b : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f18883b = new jobJobServiceC4580a(this).f18884a;
        }
        f18882a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f18882a = null;
    }
}
