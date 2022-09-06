package com.baidu.tts.p105j;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p105j.AbstractC1725a;
import com.baidu.tts.p105j.AbstractCallableC1726b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
/* renamed from: com.baidu.tts.j.c */
/* loaded from: classes.dex */
public class C1727c<A extends AbstractCallableC1726b<A, R>, R extends AbstractC1725a> {

    /* renamed from: a */
    private final ConcurrentMap<A, Future<R>> f6218a = new ConcurrentHashMap();

    /* renamed from: b */
    private A m14829b(A a) {
        for (A a2 : this.f6218a.keySet()) {
            if (a.compareTo(a2) == 0) {
                return a2;
            }
        }
        return null;
    }

    /* renamed from: a */
    public R m14830a(A a) {
        Future<R> future;
        Future<R> future2;
        FutureTask futureTask;
        A m14829b = m14829b(a);
        Future<R> future3 = m14829b != null ? this.f6218a.get(m14829b) : null;
        try {
            if (future3 != null) {
                LoggerProxy.m15091d("Memorizer", "+ get f=" + future3);
                R r = future3.get();
                LoggerProxy.m15091d("Memorizer", "- get f=" + future3);
                if (!r.mo14832g()) {
                    LoggerProxy.m15091d("Memorizer", "arg invalid r=" + r);
                    this.f6218a.remove(m14829b);
                    future = null;
                    if (future == null || (future = this.f6218a.putIfAbsent(a, (futureTask = new FutureTask(a)))) != null) {
                        future2 = future;
                    } else {
                        LoggerProxy.m15091d("Memorizer", "+ run f=" + futureTask);
                        futureTask.run();
                        LoggerProxy.m15091d("Memorizer", "- run f=" + futureTask);
                        future2 = futureTask;
                    }
                    return (R) future2.get();
                }
            }
            return (R) future2.get();
        } catch (ExecutionException e) {
            this.f6218a.remove(a, future2);
            throw ((Exception) e.getCause());
        } catch (Exception e2) {
            this.f6218a.remove(a, future2);
            throw e2;
        }
        future = future3;
        if (future == null) {
        }
        future2 = future;
    }

    /* renamed from: a */
    public void m14831a() {
        if (this.f6218a != null) {
            this.f6218a.clear();
        }
    }
}
