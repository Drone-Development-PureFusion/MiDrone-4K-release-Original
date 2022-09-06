package com.baidu.tts.loopj;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
/* loaded from: classes.dex */
public class BlackholeHttpResponseHandler extends AsyncHttpResponseHandler {
    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onCancel() {
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onFinish() {
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler, com.baidu.tts.loopj.ResponseHandlerInterface
    public void onPostProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler, com.baidu.tts.loopj.ResponseHandlerInterface
    public void onPreProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onProgress(long j, long j2) {
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onRetry(int i) {
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onStart() {
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
    }

    @Override // com.baidu.tts.loopj.AsyncHttpResponseHandler
    public void onUserException(Throwable th) {
    }
}
