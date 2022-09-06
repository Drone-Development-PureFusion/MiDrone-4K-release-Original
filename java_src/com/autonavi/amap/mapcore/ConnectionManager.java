package com.autonavi.amap.mapcore;

import com.amap.api.mapcore.util.C0989fc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class ConnectionManager extends SingalThread {
    private static final int MAX_THREAD_COUNT = 1;
    boolean threadFlag = true;
    private ExecutorService threadPool = Executors.newFixedThreadPool(1);
    private ArrayList<AsMapRequestor> threadPoolList = new ArrayList<>();
    private ArrayList<BaseMapLoader> connPool = new ArrayList<>();

    private void checkListPool() {
        try {
            ArrayList arrayList = new ArrayList();
            int size = this.threadPoolList.size();
            for (int i = 0; i < size; i++) {
                AsMapRequestor asMapRequestor = this.threadPoolList.get(i);
                BaseMapLoader baseMapLoader = asMapRequestor.mMapLoader;
                if (baseMapLoader.hasFinished() || !baseMapLoader.isRequestValid()) {
                    arrayList.add(asMapRequestor);
                    baseMapLoader.doCancel();
                }
            }
            this.threadPoolList.removeAll(arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void doAsyncRequest() {
        boolean z;
        while (this.threadFlag) {
            synchronized (this.connPool) {
                checkListPool();
                while (true) {
                    if (this.connPool.size() <= 0) {
                        z = false;
                        break;
                    } else if (this.threadPoolList.size() > 1) {
                        z = true;
                        break;
                    } else {
                        AsMapRequestor asMapRequestor = new AsMapRequestor(this.connPool.remove(0));
                        this.threadPoolList.add(asMapRequestor);
                        if (!this.threadPool.isShutdown()) {
                            this.threadPool.execute(asMapRequestor);
                        }
                    }
                }
            }
            if (z) {
                try {
                    sleep(30L);
                } catch (Exception e) {
                }
            } else if (this.threadFlag) {
                try {
                    doWait();
                } catch (Throwable th) {
                }
            }
        }
    }

    void checkListPoolOld() {
        Iterator<AsMapRequestor> it2 = this.threadPoolList.iterator();
        while (it2.hasNext()) {
            BaseMapLoader baseMapLoader = it2.next().mMapLoader;
            if (!baseMapLoader.isRequestValid() || baseMapLoader.hasFinished()) {
                baseMapLoader.doCancel();
                it2.remove();
            }
        }
    }

    public void insertConntionTask(BaseMapLoader baseMapLoader) {
        synchronized (this.connPool) {
            this.connPool.add(baseMapLoader);
        }
        doAwake();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            C0989fc.m18135a();
            doAsyncRequest();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void shutDown() {
        synchronized (this.connPool) {
            if (this.connPool != null) {
                Iterator<BaseMapLoader> it2 = this.connPool.iterator();
                while (it2.hasNext()) {
                    it2.next().doCancel();
                }
                this.connPool.clear();
                this.threadPoolList.clear();
                this.threadPool.shutdownNow();
            }
        }
    }
}
