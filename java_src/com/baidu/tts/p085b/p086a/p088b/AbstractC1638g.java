package com.baidu.tts.p085b.p086a.p088b;

import com.baidu.tts.loopj.AsyncHttpResponseHandler;
import com.baidu.tts.loopj.RequestParams;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
/* renamed from: com.baidu.tts.b.a.b.g */
/* loaded from: classes.dex */
public abstract class AbstractC1638g extends AsyncHttpResponseHandler {

    /* renamed from: a */
    private String f5778a;

    /* renamed from: b */
    private HttpEntity f5779b;

    /* renamed from: a */
    String m15158a(HttpEntity httpEntity) {
        Header contentType = httpEntity.getContentType();
        if (contentType == null || !RequestParams.APPLICATION_JSON.equals(contentType.getValue())) {
            return null;
        }
        return RequestParams.APPLICATION_JSON;
    }

    /* renamed from: a */
    public abstract void mo15157a(int i, Header[] headerArr, String str, HttpEntity httpEntity);

    /* renamed from: a */
    public abstract void mo15156a(int i, Header[] headerArr, String str, HttpEntity httpEntity, Throwable th);

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        mo15156a(i, headerArr, this.f5778a, this.f5779b, th);
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        mo15157a(i, headerArr, this.f5778a, this.f5779b);
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler, com.baidu.tts.loopj.ResponseHandlerInterface
    public void sendResponseMessage(HttpResponse httpResponse) {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = httpResponse.getStatusLine();
            this.f5779b = httpResponse.getEntity();
            this.f5778a = m15158a(this.f5779b);
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (statusLine.getStatusCode() >= 300) {
                sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
            } else {
                sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null);
            }
        }
    }
}
