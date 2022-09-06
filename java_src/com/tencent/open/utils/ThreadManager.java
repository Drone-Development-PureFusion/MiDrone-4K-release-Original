package com.tencent.open.utils;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class ThreadManager {
    public static final boolean DEBUG_THREAD = false;
    public static final Executor NETWORK_EXECUTOR = m5349a();

    /* renamed from: a */
    private static Handler f18216a;

    /* renamed from: b */
    private static HandlerThread f18217b;

    /* renamed from: c */
    private static Handler f18218c;

    /* renamed from: d */
    private static HandlerThread f18219d;

    /* renamed from: a */
    private static Executor m5349a() {
        Executor threadPoolExecutor;
        Executor executor;
        if (Build.VERSION.SDK_INT >= 11) {
            executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        } else {
            try {
                Field declaredField = AsyncTask.class.getDeclaredField("sExecutor");
                declaredField.setAccessible(true);
                threadPoolExecutor = (Executor) declaredField.get(null);
            } catch (Exception e) {
                threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
            executor = threadPoolExecutor;
        }
        if (executor instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) executor).setCorePoolSize(3);
        }
        return executor;
    }

    public static void executeOnNetWorkThread(Runnable runnable) {
        try {
            NETWORK_EXECUTOR.execute(runnable);
        } catch (RejectedExecutionException e) {
        }
    }

    public static void executeOnSubThread(Runnable runnable) {
        getSubThreadHandler().post(runnable);
    }

    public static Handler getFileThreadHandler() {
        if (f18218c == null) {
            synchronized (ThreadManager.class) {
                f18219d = new HandlerThread("QQ_FILE_RW");
                f18219d.start();
                f18218c = new Handler(f18219d.getLooper());
            }
        }
        return f18218c;
    }

    public static Looper getFileThreadLooper() {
        return getFileThreadHandler().getLooper();
    }

    public static Thread getSubThread() {
        if (f18217b == null) {
            getSubThreadHandler();
        }
        return f18217b;
    }

    public static Handler getSubThreadHandler() {
        if (f18216a == null) {
            synchronized (ThreadManager.class) {
                f18217b = new HandlerThread("QQ_SUB");
                f18217b.start();
                f18216a = new Handler(f18217b.getLooper());
            }
        }
        return f18216a;
    }

    public static Looper getSubThreadLooper() {
        return getSubThreadHandler().getLooper();
    }

    public static void init() {
    }
}
