package com.baidu.tts.client.model;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p096e.EnumC1709l;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public class BasicHandler<T> {

    /* renamed from: a */
    private FutureTask<T> f5835a;

    public BasicHandler(FutureTask<T> futureTask) {
        this.f5835a = futureTask;
    }

    public boolean cancel() {
        return this.f5835a.cancel(true);
    }

    public T get() {
        try {
            LoggerProxy.m15091d("BasicHandler", "before get");
            return this.f5835a.get(EnumC1709l.DEFAULT.m14891a(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            LoggerProxy.m15091d("BasicHandler", e.toString());
            return null;
        } catch (ExecutionException e2) {
            LoggerProxy.m15091d("BasicHandler", e2.getCause().toString());
            return null;
        } catch (TimeoutException e3) {
            LoggerProxy.m15091d("BasicHandler", e3.toString());
            return null;
        }
    }

    public void start() {
        new Thread(this.f5835a).start();
    }
}
