package com.mob.tools.utils;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
/* loaded from: classes.dex */
public class FileLocker {
    private FileOutputStream fos;
    private FileLock lock;

    public synchronized void lock(Runnable runnable, boolean z) {
        if (lock(z) && runnable != null) {
            runnable.run();
        }
    }

    public synchronized boolean lock(boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.fos != null) {
                if (z) {
                    this.lock = this.fos.getChannel().lock();
                } else {
                    this.lock = this.fos.getChannel().tryLock();
                }
                if (this.lock != null) {
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public synchronized void release() {
        if (this.fos != null) {
            unlock();
            try {
                this.fos.close();
                this.fos = null;
            } catch (Throwable th) {
            }
        }
    }

    public synchronized void setLockFile(String str) {
        try {
            this.fos = new FileOutputStream(str);
        } catch (Throwable th) {
            if (this.fos != null) {
                try {
                    this.fos.close();
                } catch (Throwable th2) {
                }
                this.fos = null;
            }
        }
    }

    public synchronized void unlock() {
        if (this.lock != null) {
            try {
                this.lock.release();
                this.lock = null;
            } catch (Throwable th) {
            }
        }
    }
}
