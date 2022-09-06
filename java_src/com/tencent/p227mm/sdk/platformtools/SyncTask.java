package com.tencent.p227mm.sdk.platformtools;

import android.os.Handler;
/* renamed from: com.tencent.mm.sdk.platformtools.SyncTask */
/* loaded from: classes.dex */
public abstract class SyncTask<R> {

    /* renamed from: ba */
    private final long f17861ba;

    /* renamed from: bb */
    private long f17862bb;

    /* renamed from: bc */
    private long f17863bc;

    /* renamed from: bd */
    private Runnable f17864bd;
    private Object lock;
    private R result;

    public SyncTask() {
        this(0L, null);
    }

    public SyncTask(long j, R r) {
        this.lock = new Object();
        this.f17864bd = new Runnable() { // from class: com.tencent.mm.sdk.platformtools.SyncTask.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                SyncTask.this.f17863bc = Util.ticksToNow(SyncTask.this.f17862bb);
                SyncTask.this.setResult(SyncTask.this.run());
            }
        };
        this.f17861ba = j;
        this.result = r;
    }

    public R exec(Handler handler) {
        if (handler == null) {
            Log.m5649d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return run();
        } else if (Thread.currentThread().getId() == handler.getLooper().getThread().getId()) {
            Log.m5649d("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return run();
        } else {
            this.f17862bb = Util.currentTicks();
            handler.post(this.f17864bd);
            try {
                synchronized (this.lock) {
                    this.lock.wait(this.f17861ba);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long ticksToNow = Util.ticksToNow(this.f17862bb);
            Log.m5640v("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", new StringBuilder().append(this.result).toString(), Long.valueOf(ticksToNow), Long.valueOf(this.f17863bc), Long.valueOf(ticksToNow - this.f17863bc));
            return this.result;
        }
    }

    protected abstract R run();

    public void setResult(R r) {
        this.result = r;
        synchronized (this.lock) {
            this.lock.notify();
        }
    }
}
