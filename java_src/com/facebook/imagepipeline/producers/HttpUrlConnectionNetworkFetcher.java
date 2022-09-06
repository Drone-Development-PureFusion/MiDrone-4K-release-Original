package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.p248a.p249a.C5083e;
/* loaded from: classes.dex */
public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<FetchState> {
    private static final int NUM_NETWORK_THREADS = 3;
    private final ExecutorService mExecutorService = Executors.newFixedThreadPool(3);

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public FetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new FetchState(consumer, producerContext);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(final FetchState fetchState, final NetworkFetcher.Callback callback) {
        final Future<?> submit = this.mExecutorService.submit(new Runnable() { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.1
            @Override // java.lang.Runnable
            public void run() {
                HttpURLConnection httpURLConnection;
                String scheme = fetchState.getUri().getScheme();
                String uri = fetchState.getUri().toString();
                String str = scheme;
                HttpURLConnection httpURLConnection2 = null;
                while (true) {
                    try {
                        try {
                            httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
                        } catch (Exception e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        String headerField = httpURLConnection.getHeaderField(C5083e.f21644H);
                        String scheme2 = headerField == null ? null : Uri.parse(headerField).getScheme();
                        if (headerField == null || scheme2.equals(str)) {
                            break;
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        str = scheme2;
                        httpURLConnection2 = httpURLConnection;
                        uri = headerField;
                    } catch (Exception e2) {
                        httpURLConnection2 = httpURLConnection;
                        e = e2;
                        callback.onFailure(e);
                        if (httpURLConnection2 == null) {
                            return;
                        }
                        httpURLConnection2.disconnect();
                        return;
                    } catch (Throwable th2) {
                        httpURLConnection2 = httpURLConnection;
                        th = th2;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                }
                callback.onResponse(httpURLConnection.getInputStream(), -1);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        });
        fetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                if (submit.cancel(false)) {
                    callback.onCancellation();
                }
            }
        });
    }
}
