package com.loopj.android.http;

import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;
/* loaded from: classes.dex */
public class BinaryHttpResponseHandler extends AsyncHttpResponseHandler {
    private static String[] mAllowedContentTypes = {"image/jpeg", "image/png"};

    public BinaryHttpResponseHandler() {
    }

    public BinaryHttpResponseHandler(String[] strArr) {
        this();
        mAllowedContentTypes = strArr;
    }

    protected void handleFailureMessage(Throwable th, byte[] bArr) {
        onFailure(th, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                handleSuccessMessage(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                return;
            case 1:
                Object[] objArr2 = (Object[]) message.obj;
                handleFailureMessage((Throwable) objArr2[0], (byte[]) objArr2[1]);
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }

    protected void handleSuccessMessage(int i, byte[] bArr) {
        onSuccess(i, bArr);
    }

    public void onFailure(Throwable th, byte[] bArr) {
        onFailure(th);
    }

    public void onSuccess(int i, byte[] bArr) {
        onSuccess(bArr);
    }

    public void onSuccess(byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void sendFailureMessage(Throwable th, byte[] bArr) {
        sendMessage(obtainMessage(1, new Object[]{th, bArr}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public void sendResponseMessage(HttpResponse httpResponse) {
        byte[] bArr = null;
        boolean z = false;
        StatusLine statusLine = httpResponse.getStatusLine();
        Header[] headers = httpResponse.getHeaders("Content-Type");
        if (headers.length != 1) {
            sendFailureMessage((Throwable) new HttpResponseException(statusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"), (byte[]) null);
            return;
        }
        Header header = headers[0];
        for (String str : mAllowedContentTypes) {
            if (str.equals(header.getValue())) {
                z = true;
            }
        }
        if (!z) {
            sendFailureMessage((Throwable) new HttpResponseException(statusLine.getStatusCode(), "Content-Type not allowed!"), (byte[]) null);
            return;
        }
        try {
            HttpEntity entity = httpResponse.getEntity();
            bArr = EntityUtils.toByteArray(entity != null ? new BufferedHttpEntity(entity) : null);
        } catch (IOException e) {
            sendFailureMessage(e, (byte[]) null);
        }
        if (statusLine.getStatusCode() >= 300) {
            sendFailureMessage((Throwable) new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), bArr);
        } else {
            sendSuccessMessage(statusLine.getStatusCode(), bArr);
        }
    }

    protected void sendSuccessMessage(int i, byte[] bArr) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), bArr}));
    }
}
