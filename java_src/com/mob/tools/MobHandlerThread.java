package com.mob.tools;

import android.os.Looper;
import android.os.Process;
/* loaded from: classes.dex */
public class MobHandlerThread extends Thread {
    private Looper looper;
    private int priority;
    private int tid;

    public MobHandlerThread() {
        this.tid = -1;
        this.priority = 0;
    }

    public MobHandlerThread(int i) {
        this.tid = -1;
        this.priority = i;
    }

    public Looper getLooper() {
        if (!isAlive()) {
            return null;
        }
        synchronized (this) {
            while (isAlive() && this.looper == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return this.looper;
    }

    public int getThreadId() {
        return this.tid;
    }

    protected void onLooperPrepared() {
    }

    public boolean quit() {
        Looper looper = getLooper();
        if (looper != null) {
            looper.quit();
            return true;
        }
        return false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.tid = Process.myTid();
        Looper.prepare();
        synchronized (this) {
            this.looper = Looper.myLooper();
            notifyAll();
        }
        Process.setThreadPriority(this.priority);
        onLooperPrepared();
        Looper.loop();
        this.tid = -1;
    }
}
