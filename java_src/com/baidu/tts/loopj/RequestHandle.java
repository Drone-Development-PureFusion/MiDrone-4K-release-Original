package com.baidu.tts.loopj;

import android.os.Looper;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class RequestHandle {
    private final WeakReference<AsyncHttpRequest> request;

    public RequestHandle(AsyncHttpRequest asyncHttpRequest) {
        this.request = new WeakReference<>(asyncHttpRequest);
    }

    public boolean cancel(final boolean z) {
        final AsyncHttpRequest asyncHttpRequest = this.request.get();
        if (asyncHttpRequest != null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return asyncHttpRequest.cancel(z);
            }
            new Thread(new Runnable() { // from class: com.baidu.tts.loopj.RequestHandle.1
                @Override // java.lang.Runnable
                public void run() {
                    asyncHttpRequest.cancel(z);
                }
            }).start();
            return true;
        }
        return false;
    }

    public Object getTag() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        if (asyncHttpRequest == null) {
            return null;
        }
        return asyncHttpRequest.getTag();
    }

    public boolean isCancelled() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        return asyncHttpRequest == null || asyncHttpRequest.isCancelled();
    }

    public boolean isFinished() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        return asyncHttpRequest == null || asyncHttpRequest.isDone();
    }

    public RequestHandle setTag(Object obj) {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        if (asyncHttpRequest != null) {
            asyncHttpRequest.setRequestTag(obj);
        }
        return this;
    }

    public boolean shouldBeGarbageCollected() {
        boolean z = isCancelled() || isFinished();
        if (z) {
            this.request.clear();
        }
        return z;
    }
}
