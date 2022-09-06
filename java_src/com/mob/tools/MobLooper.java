package com.mob.tools;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
/* loaded from: classes.dex */
public class MobLooper {
    private Context context;
    private boolean goingToStop;

    public MobLooper(Context context) {
        this.context = context.getApplicationContext();
    }

    public void start(Runnable runnable, long j) {
        start(runnable, j, 0L);
    }

    public synchronized void start(final Runnable runnable, final long j, long j2) {
        this.goingToStop = false;
        final Object obj = new Object();
        Intent intent = new Intent(getClass().getName() + "." + SystemClock.elapsedRealtime());
        final PendingIntent broadcast = PendingIntent.getBroadcast(this.context, 0, intent, 0);
        final AlarmManager alarmManager = (AlarmManager) this.context.getSystemService("alarm");
        alarmManager.set(3, SystemClock.elapsedRealtime() + j2, broadcast);
        this.context.registerReceiver(new BroadcastReceiver() { // from class: com.mob.tools.MobLooper.1
            /* JADX WARN: Type inference failed for: r0v2, types: [com.mob.tools.MobLooper$1$1] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent2) {
                if (!MobLooper.this.goingToStop) {
                    new Thread() { // from class: com.mob.tools.MobLooper.1.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            synchronized (obj) {
                                runnable.run();
                            }
                        }
                    }.start();
                    alarmManager.set(3, SystemClock.elapsedRealtime() + j, broadcast);
                }
            }
        }, new IntentFilter(intent.getAction()));
    }

    public synchronized void stop() {
        this.goingToStop = true;
    }
}
