package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.RawNetworkCallback;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class BitmapProcessor {
    private static final int CAPACITY = 3;
    private static final int MAX_CACHE_SIZE = 50;
    private static final int MAX_CACHE_TIME = 60000;
    private static final int MAX_REQ_TIME = 20000;
    private static final int MAX_SIZE = 100;
    private static final int OVERFLOW_SIZE = 120;
    private static final int SCAN_INTERVAL = 20000;
    private static File cacheDir;
    private static ManagerThread manager;
    private static NetworkHelper.NetworkTimeOut timeout;
    private static boolean work;
    private static ArrayList<ImageReq> reqList = new ArrayList<>();
    private static ArrayList<ImageReq> netReqTPS = new ArrayList<>();
    private static WorkerThread[] workerList = new WorkerThread[3];
    private static CachePool<String, Bitmap> cachePool = new CachePool<>(50);

    /* loaded from: classes.dex */
    public interface BitmapCallback {
        void onImageGot(String str, Bitmap bitmap);
    }

    /* loaded from: classes.dex */
    public static class ImageReq {
        private String url;
        private WorkerThread worker;
        private long reqTime = System.currentTimeMillis();
        private ArrayList<BitmapCallback> callbacks = new ArrayList<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void throwComplete(Bitmap bitmap) {
            Iterator<BitmapCallback> it2 = this.callbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onImageGot(this.url, bitmap);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("url=").append(this.url);
            sb.append("time=").append(this.reqTime);
            sb.append("worker=").append(this.worker.getName()).append(" (").append(this.worker.getId()).append("");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ManagerThread implements Handler.Callback {
        private Handler handler;

        public ManagerThread() {
            MobHandlerThread mobHandlerThread = new MobHandlerThread() { // from class: com.mob.tools.gui.BitmapProcessor.ManagerThread.1
                @Override // com.mob.tools.MobHandlerThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    ManagerThread.this.beforeRun();
                    super.run();
                }
            };
            mobHandlerThread.start();
            this.handler = new Handler(mobHandlerThread.getLooper(), this);
            this.handler.sendEmptyMessageDelayed(1, 20000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void beforeRun() {
            int i = 0;
            while (i < BitmapProcessor.workerList.length) {
                if (BitmapProcessor.workerList[i] == null) {
                    BitmapProcessor.workerList[i] = new WorkerThread();
                    BitmapProcessor.workerList[i].setName("worker " + i);
                    BitmapProcessor.workerList[i].localType = i == 0;
                    BitmapProcessor.workerList[i].start();
                }
                i++;
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (BitmapProcessor.cachePool != null) {
                BitmapProcessor.cachePool.trimBeforeTime(System.currentTimeMillis() - 60000);
            }
            MobLog.getInstance().m5972d(">>>> BitmapProcessor.cachePool: " + (BitmapProcessor.cachePool == null ? 0 : BitmapProcessor.cachePool.size()), new Object[0]);
            MobLog.getInstance().m5972d(">>>> BitmapProcessor.reqList: " + (BitmapProcessor.reqList == null ? 0 : BitmapProcessor.reqList.size()), new Object[0]);
            if (BitmapProcessor.work) {
                this.handler.sendEmptyMessageDelayed(1, 20000L);
            }
            return false;
        }

        public void quit() {
            this.handler.removeMessages(1);
            this.handler.getLooper().quit();
            for (int i = 0; i < BitmapProcessor.workerList.length; i++) {
                if (BitmapProcessor.workerList[i] != null) {
                    BitmapProcessor.workerList[i].interrupt();
                    BitmapProcessor.workerList[i] = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static class PatchInputStream extends FilterInputStream {

        /* renamed from: in */
        InputStream f17337in;

        protected PatchInputStream(InputStream inputStream) {
            super(inputStream);
            this.f17337in = inputStream;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) {
            long j2 = 0;
            while (j2 < j) {
                long skip = this.f17337in.skip(j - j2);
                if (skip == 0) {
                    break;
                }
                j2 += skip;
            }
            return j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class WorkerThread extends Thread {
        private ImageReq curReq;
        private boolean localType;

        private WorkerThread() {
        }

        private void doLocalTask() {
            ImageReq imageReq;
            synchronized (BitmapProcessor.reqList) {
                imageReq = BitmapProcessor.reqList.size() > 0 ? (ImageReq) BitmapProcessor.reqList.remove(0) : null;
            }
            if (imageReq == null) {
                try {
                    Thread.sleep(30L);
                    return;
                } catch (Throwable th) {
                    return;
                }
            }
            Bitmap bitmap = (Bitmap) BitmapProcessor.cachePool.get(imageReq.url);
            if (bitmap != null) {
                this.curReq = imageReq;
                this.curReq.worker = this;
                imageReq.throwComplete(bitmap);
            } else if (BitmapProcessor.cacheDir != null && new File(BitmapProcessor.cacheDir, Data.MD5(imageReq.url)).exists()) {
                doTask(imageReq);
            } else {
                synchronized (BitmapProcessor.reqList) {
                    if (BitmapProcessor.netReqTPS.size() > 100) {
                        synchronized (BitmapProcessor.reqList) {
                            while (BitmapProcessor.reqList.size() > 0) {
                                BitmapProcessor.reqList.remove(0);
                            }
                        }
                        BitmapProcessor.netReqTPS.remove(0);
                    }
                }
                BitmapProcessor.netReqTPS.add(imageReq);
            }
        }

        private void doNetworkTask() {
            ImageReq imageReq;
            ImageReq imageReq2 = null;
            synchronized (BitmapProcessor.netReqTPS) {
                if (BitmapProcessor.netReqTPS.size() > 0) {
                    imageReq2 = (ImageReq) BitmapProcessor.netReqTPS.remove(0);
                }
            }
            if (imageReq2 == null) {
                synchronized (BitmapProcessor.reqList) {
                    if (BitmapProcessor.reqList.size() > 0) {
                        imageReq2 = (ImageReq) BitmapProcessor.reqList.remove(0);
                    }
                }
                imageReq = imageReq2;
            } else {
                imageReq = imageReq2;
            }
            if (imageReq == null) {
                try {
                    Thread.sleep(30L);
                    return;
                } catch (Throwable th) {
                    return;
                }
            }
            Bitmap bitmap = (Bitmap) BitmapProcessor.cachePool.get(imageReq.url);
            if (bitmap == null) {
                doTask(imageReq);
                return;
            }
            this.curReq = imageReq;
            this.curReq.worker = this;
            imageReq.throwComplete(bitmap);
        }

        private void doTask(final ImageReq imageReq) {
            Bitmap bitmap;
            this.curReq = imageReq;
            this.curReq.worker = this;
            final boolean z = imageReq.url.toLowerCase().endsWith("png") || imageReq.url.toLowerCase().endsWith("gif");
            final String MD5 = Data.MD5(imageReq.url);
            if (BitmapProcessor.cacheDir == null || !new File(BitmapProcessor.cacheDir, MD5).exists()) {
                new NetworkHelper().rawGet(imageReq.url, new RawNetworkCallback() { // from class: com.mob.tools.gui.BitmapProcessor.WorkerThread.1
                    @Override // com.mob.tools.network.RawNetworkCallback
                    public void onResponse(InputStream inputStream) {
                        Bitmap bitmap2 = BitmapHelper.getBitmap(new PatchInputStream(inputStream), 1);
                        if (bitmap2 == null || bitmap2.isRecycled()) {
                            WorkerThread.this.curReq = null;
                            return;
                        }
                        if (bitmap2 != null) {
                            if (BitmapProcessor.cacheDir != null) {
                                WorkerThread.this.saveFile(bitmap2, new File(BitmapProcessor.cacheDir, MD5), z);
                            }
                            BitmapProcessor.cachePool.put(imageReq.url, bitmap2);
                            imageReq.throwComplete(bitmap2);
                        }
                        WorkerThread.this.curReq = null;
                    }
                }, BitmapProcessor.timeout);
                bitmap = null;
            } else {
                bitmap = BitmapHelper.getBitmap(new File(BitmapProcessor.cacheDir, MD5).getAbsolutePath());
                if (bitmap != null) {
                    BitmapProcessor.cachePool.put(imageReq.url, bitmap);
                    imageReq.throwComplete(bitmap);
                }
                this.curReq = null;
            }
            if (bitmap != null) {
                BitmapProcessor.cachePool.put(imageReq.url, bitmap);
                imageReq.throwComplete(bitmap);
            }
            this.curReq = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void saveFile(Bitmap bitmap, File file, boolean z) {
            try {
                if (file.exists()) {
                    file.delete();
                }
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
                Bitmap.CompressFormat compressFormat = z ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(compressFormat, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Throwable th) {
                if (!file.exists()) {
                    return;
                }
                file.delete();
            }
        }

        @Override // java.lang.Thread
        public void interrupt() {
            try {
                super.interrupt();
            } catch (Throwable th) {
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (BitmapProcessor.work) {
                try {
                    if (this.localType) {
                        doLocalTask();
                    } else {
                        doNetworkTask();
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().m5959w(th);
                }
            }
        }
    }

    static {
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.connectionTimeout = 5000;
        networkTimeOut.readTimout = 20000 - networkTimeOut.connectionTimeout;
    }

    public static Bitmap getBitmapFromCache(String str) {
        if (cachePool == null || str == null) {
            return null;
        }
        return cachePool.get(str);
    }

    public static synchronized void prepare(Context context) {
        synchronized (BitmapProcessor.class) {
            cacheDir = new File(ResHelper.getImageCachePath(context));
        }
    }

    public static synchronized void process(String str, BitmapCallback bitmapCallback) {
        synchronized (BitmapProcessor.class) {
            if (str != null) {
                synchronized (reqList) {
                    int size = reqList.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            ImageReq imageReq = reqList.get(i);
                            if (imageReq.url.equals(str)) {
                                if (bitmapCallback != null && imageReq.callbacks.indexOf(bitmapCallback) == -1) {
                                    imageReq.callbacks.add(bitmapCallback);
                                }
                                start();
                            } else {
                                i++;
                            }
                        } else {
                            ImageReq imageReq2 = new ImageReq();
                            imageReq2.url = str;
                            if (bitmapCallback != null) {
                                imageReq2.callbacks.add(bitmapCallback);
                            }
                            synchronized (reqList) {
                                reqList.add(imageReq2);
                                if (reqList.size() > 120) {
                                    while (reqList.size() > 100) {
                                        reqList.remove(0);
                                    }
                                }
                            }
                            start();
                        }
                    }
                }
            }
        }
    }

    public static synchronized void start() {
        synchronized (BitmapProcessor.class) {
            if (!work) {
                work = true;
                manager = new ManagerThread();
            }
        }
    }

    public static synchronized void stop() {
        synchronized (BitmapProcessor.class) {
            if (work) {
                work = false;
                synchronized (reqList) {
                    reqList.clear();
                    cachePool.clear();
                }
                manager.quit();
            }
        }
    }
}
