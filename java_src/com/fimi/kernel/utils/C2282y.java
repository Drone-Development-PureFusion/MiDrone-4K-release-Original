package com.fimi.kernel.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* renamed from: com.fimi.kernel.utils.y */
/* loaded from: classes.dex */
public class C2282y {

    /* renamed from: com.fimi.kernel.utils.y$a */
    /* loaded from: classes.dex */
    static class CallableC2283a implements Callable<Boolean> {

        /* renamed from: a */
        private String f7604a;

        public CallableC2283a(String str) {
            this.f7604a = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            for (int i = 0; i < 999999999; i++) {
                if (i == 999999997) {
                    System.out.println(this.f7604a);
                }
                if (Thread.interrupted()) {
                    return false;
                }
            }
            System.out.println("继续执行..........");
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* renamed from: a */
    public static Boolean m12701a(Callable<Boolean> callable, int i) {
        Boolean bool;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future submit = newSingleThreadExecutor.submit(callable);
        Boolean bool2 = i * 1000;
        try {
            try {
                bool = (Boolean) submit.get(bool2, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                newSingleThreadExecutor.shutdown();
                return bool2;
            }
            try {
                System.out.println(bool);
                newSingleThreadExecutor.shutdown();
                bool2 = bool;
            } catch (InterruptedException e) {
                submit.cancel(true);
                newSingleThreadExecutor.shutdown();
                bool2 = bool;
                return bool2;
            } catch (ExecutionException e2) {
                submit.cancel(true);
                newSingleThreadExecutor.shutdown();
                bool2 = bool;
                return bool2;
            } catch (TimeoutException e3) {
                submit.cancel(true);
                newSingleThreadExecutor.shutdown();
                bool2 = bool;
                return bool2;
            }
        } catch (InterruptedException e4) {
            bool = false;
        } catch (ExecutionException e5) {
            bool = false;
        } catch (TimeoutException e6) {
            bool = false;
        } catch (Throwable th2) {
            bool2 = false;
            newSingleThreadExecutor.shutdown();
            return bool2;
        }
        return bool2;
    }

    /* renamed from: a */
    public static void m12700a(String[] strArr) {
        m12701a(new CallableC2283a("传递的参数"), 2);
    }
}
