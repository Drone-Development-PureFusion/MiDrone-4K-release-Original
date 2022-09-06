package com.baidu.tts.loopj;

import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
public class AsyncHttpRequest implements Runnable {
    private boolean cancelIsNotified;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private final AtomicBoolean isCancelled = new AtomicBoolean();
    private volatile boolean isFinished;
    private boolean isRequestPreProcessed;
    private final HttpUriRequest request;
    private final ResponseHandlerInterface responseHandler;

    public AsyncHttpRequest(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, ResponseHandlerInterface responseHandlerInterface) {
        this.client = (AbstractHttpClient) Utils.notNull(abstractHttpClient, "client");
        this.context = (HttpContext) Utils.notNull(httpContext, C0359h.f700ac);
        this.request = (HttpUriRequest) Utils.notNull(httpUriRequest, SocialConstants.TYPE_REQUEST);
        this.responseHandler = (ResponseHandlerInterface) Utils.notNull(responseHandlerInterface, "responseHandler");
    }

    private void makeRequest() {
        if (isCancelled()) {
            return;
        }
        if (this.request.getURI().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
        }
        if (this.responseHandler instanceof RangeFileAsyncHttpResponseHandler) {
            ((RangeFileAsyncHttpResponseHandler) this.responseHandler).updateRequestHeaders(this.request);
        }
        HttpResponse execute = this.client.execute(this.request, this.context);
        if (isCancelled()) {
            return;
        }
        this.responseHandler.onPreProcessResponse(this.responseHandler, execute);
        if (isCancelled()) {
            return;
        }
        this.responseHandler.sendResponseMessage(execute);
        if (isCancelled()) {
            return;
        }
        this.responseHandler.onPostProcessResponse(this.responseHandler, execute);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0009 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void makeRequestWithRetries() {
        boolean z;
        IOException e = null;
        HttpRequestRetryHandler httpRequestRetryHandler = this.client.getHttpRequestRetryHandler();
        boolean z2 = true;
        while (z2) {
            try {
                try {
                    try {
                        makeRequest();
                        return;
                    } catch (UnknownHostException e2) {
                        try {
                            IOException iOException = new IOException("UnknownHostException exception: " + e2.getMessage());
                            if (this.executionCount >= 0) {
                                int i = this.executionCount + 1;
                                this.executionCount = i;
                                if (httpRequestRetryHandler.retryRequest(e2, i, this.context)) {
                                    z = true;
                                    z2 = z;
                                    e = iOException;
                                    if (!z2) {
                                        this.responseHandler.sendRetryMessage(this.executionCount);
                                    }
                                }
                            }
                            z = false;
                            z2 = z;
                            e = iOException;
                            if (!z2) {
                            }
                        } catch (Exception e3) {
                            AsyncHttpClient.log.mo14720e("AsyncHttpRequest", "Unhandled exception origin cause", e3);
                            throw new IOException("Unhandled exception: " + e3.getMessage());
                        }
                    }
                } catch (NullPointerException e4) {
                    e = new IOException("NPE in HttpClient: " + e4.getMessage());
                    int i2 = this.executionCount + 1;
                    this.executionCount = i2;
                    z2 = httpRequestRetryHandler.retryRequest(e, i2, this.context);
                    if (!z2) {
                    }
                }
            } catch (IOException e5) {
                e = e5;
                if (isCancelled()) {
                    return;
                }
                int i3 = this.executionCount + 1;
                this.executionCount = i3;
                z2 = httpRequestRetryHandler.retryRequest(e, i3, this.context);
                if (!z2) {
                }
            }
        }
    }

    private synchronized void sendCancelNotification() {
        if (!this.isFinished && this.isCancelled.get() && !this.cancelIsNotified) {
            this.cancelIsNotified = true;
            this.responseHandler.sendCancelMessage();
        }
    }

    public boolean cancel(boolean z) {
        this.isCancelled.set(true);
        this.request.abort();
        return isCancelled();
    }

    public Object getTag() {
        return this.responseHandler.getTag();
    }

    public boolean isCancelled() {
        boolean z = this.isCancelled.get();
        if (z) {
            sendCancelNotification();
        }
        return z;
    }

    public boolean isDone() {
        return isCancelled() || this.isFinished;
    }

    public void onPostProcessRequest(AsyncHttpRequest asyncHttpRequest) {
    }

    public void onPreProcessRequest(AsyncHttpRequest asyncHttpRequest) {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isCancelled()) {
            return;
        }
        if (!this.isRequestPreProcessed) {
            this.isRequestPreProcessed = true;
            onPreProcessRequest(this);
        }
        if (isCancelled()) {
            return;
        }
        this.responseHandler.sendStartMessage();
        if (isCancelled()) {
            return;
        }
        try {
            makeRequestWithRetries();
        } catch (IOException e) {
            if (!isCancelled()) {
                this.responseHandler.sendFailureMessage(0, null, null, e);
            } else {
                AsyncHttpClient.log.mo14720e("AsyncHttpRequest", "makeRequestWithRetries returned error", e);
            }
        }
        if (isCancelled()) {
            return;
        }
        this.responseHandler.sendFinishMessage();
        if (isCancelled()) {
            return;
        }
        onPostProcessRequest(this);
        this.isFinished = true;
    }

    public AsyncHttpRequest setRequestTag(Object obj) {
        this.responseHandler.setTag(obj);
        return this;
    }
}
