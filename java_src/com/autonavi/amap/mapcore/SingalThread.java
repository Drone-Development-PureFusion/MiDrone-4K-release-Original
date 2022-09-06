package com.autonavi.amap.mapcore;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class SingalThread extends Thread {
    private final Lock mLock = new ReentrantLock();
    private final Condition mWaiting = this.mLock.newCondition();
    private boolean isWaiting = true;
    public String logTag = "SingalThread";

    public void doAwake() {
        if (this.isWaiting) {
            this.mLock.lock();
            this.isWaiting = false;
            this.mWaiting.signal();
            this.mLock.unlock();
        }
    }

    public void doWait() {
        this.mLock.lock();
        this.isWaiting = true;
        this.mWaiting.await();
        this.mLock.unlock();
    }
}
